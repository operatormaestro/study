import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.cpio.CpioArchiveOutputStream;

import javax.sound.midi.Patch;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class cpiocreate {
    public static void main(String[] args) throws IOException {
        CpioArchiveOutputStream cpioOutput = new CpioArchiveOutputStream(new FileOutputStream("c:\\1\\1.cpio"));
        File file = new File ("c:\\1\\3.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] content = Files.readAllBytes(Paths.get("c:\\1\\3.txt"));
        CpioArchiveEntry entry = new CpioArchiveEntry(file.getName(), file.length());
        cpioOutput.putArchiveEntry(entry);
        cpioOutput.write(content);
        cpioOutput.closeArchiveEntry();
    }
}
