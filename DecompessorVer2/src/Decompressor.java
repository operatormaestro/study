import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.nio.file.Files;

public class Decompressor {
    private static String fileName(String targetDir, ArchiveEntry entry) {
        String name = entry.getName();
        String targetfileName = targetDir + "\\" + name;
        return targetfileName;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите полное имя архивного файла: ");
            String file_name = bufferedReader.readLine();
            File file = new File(file_name);
            String targetDir = file.getParent();
            String format = null;
            try (InputStream is = new BufferedInputStream(Files.newInputStream(file.toPath()))) {
                try {
                    format = new ArchiveStreamFactory().detect(is);
                    System.out.println(format);
                } catch (ArchiveException e) {
                    System.out.println("ошибка");
                    System.exit(0);
                }
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
                } else {
                    try (ArchiveInputStream i = new ArchiveStreamFactory().createArchiveInputStream(format, is)) {
                        ArchiveEntry entry = null;
                        while ((entry = i.getNextEntry()) != null) {
                            System.out.println(entry.getName());
                            if (!i.canReadEntryData(entry)) {
                                System.out.println("warning");
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
        }
    }
}