import org.apache.commons.compress.archivers.*;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.utils.IOUtils;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/** Программа для распаковывания арихивов на базе библиотеки org.apache.commons.compress, версии 1.21.
   Архив распаковывается в директорию, где хранится исходный файл.
   Поддерживаются форматы (по документации org.apache.commons.compress, версии 1.21):
    ar, cpio, Unix dump, tar, zip, gzip, XZ, Pack200, bzip2, 7z, arj, lzma, snappy, DEFLATE, lz4, Brotli, Zstandard, DEFLATE64 и Z.
 */
public class Decompressor {
    public static void main(String[] args) throws IOException, ArchiveException {
        // получение имени архивного файла из командной строки
        String file_name;
        String warning = "К сожалению архив данного формата не поддерживается в текущий момент. Мы работаем над этим. Приносим извинения за временные неудобства.";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите полное имя архивного файла:");
            file_name = bufferedReader.readLine();
        }
        File file = new File(file_name);
        String targetDir = file.getParent();
        InputStream is = Files.newInputStream(file.toPath());
        // определяем формат архива
        String format = null;
        try (InputStream i = new BufferedInputStream(Files.newInputStream(file.toPath()))) {
            try {
                format = new ArchiveStreamFactory().detect(i);
                System.out.println(format);
            } catch (ArchiveException e) {
                System.out.println(warning);
                System.exit(0);
            }
        }
        // 7-zip требует особого подхода, это связано со спецификой org.apache.commons.compress 1.21
        
        if (format == "7z") {
            try {
                        SevenZFile sevenZFile = new SevenZFile(file);
                        SevenZArchiveEntry entry = sevenZFile.getNextEntry();
                        System.out.println(entry.getName());
                        while (entry != null) {
                            File file_7z = new File(targetDir + File.separator + entry.getName());
                            if (entry.isDirectory()) {
                                if (!file_7z.exists()) {
                                    file_7z.mkdirs();
                                }
                                entry = sevenZFile.getNextEntry();
                                continue;
                            }
                            if (!file_7z.getParentFile().exists()) {
                                file_7z.getParentFile().mkdirs();
                            }
                            FileOutputStream out = new FileOutputStream(file_7z);
                            byte[] content = new byte[(int) entry.getSize()];
                            sevenZFile.read(content, 0, content.length);
                            out.write(content);
                            out.close();
                    entry = sevenZFile.getNextEntry();
                }
                sevenZFile.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (format == "cpio"){
            CpioArchiveInputStream cpioIn = new CpioArchiveInputStream(Files.newInputStream(Paths.get(file_name)));
            //System.out.println(cpioArchiveInputStream);
            CpioArchiveEntry cpioEntry = cpioIn.getNextCPIOEntry();
            System.out.println(cpioEntry.getName());
            while (cpioEntry != null) {
                FileOutputStream fos = new FileOutputStream(targetDir + File.separator + cpioEntry.getName());
                byte[] content = new byte[(int) cpioEntry.getSize()];
                cpioIn.read(content,0,content.length);
                fos.write(content);
                fos.close();
                cpioEntry = cpioIn.getNextCPIOEntry();
            }

        }
        else {
            try (ArchiveInputStream i = new ArchiveStreamFactory().createArchiveInputStream(format, is)) {
                ArchiveEntry entry = null;
                while ((entry = i.getNextEntry()) != null) {
                    System.out.println(entry.getName());
                    if (!i.canReadEntryData(entry)) {
                        System.out.println(warning);
                        //System.exit(0);
                    }
                    String name = fileName(targetDir, entry);
                    File f = new File(name);
                    if (entry.isDirectory()) {
                        if (!f.isDirectory() && !f.mkdirs()) {
                            throw new IOException("не удалось создать каталог " + f);
                        }
                    } else {
                        File parent = f.getParentFile();
                        if (!parent.isDirectory() && !parent.mkdirs()) {
                            throw new IOException("не удалось создать каталог " + parent);
                        }
                        try (OutputStream o = Files.newOutputStream(f.toPath())) {
                            IOUtils.copy(i, o);
                        }
                    }
                }
            } catch (ArchiveException e) {
                e.printStackTrace();
            }
        }
    }
    private static String fileName(String targetDir, ArchiveEntry entry) {
        String name = entry.getName();
        String targetfileName = targetDir + "\\" + name;
        return targetfileName;
    }
}