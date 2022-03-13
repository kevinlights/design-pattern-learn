package sample;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
class Client {
    public static void main(String[] args) {
        EncryptFacade facade = new EncryptFacade();
        facade.fileEncrypt("src.txt", "target.txt");
    }
}

public class EncryptFacade {
    private FileReader reader = new FileReader();
    private FileWriter writer = new FileWriter();
    private CipherMachine cipher = new CipherMachine();

    public void fileEncrypt(String sourceFile, String targetFile) {
        String plainText = reader.read(sourceFile);
        String encryped = cipher.encrypt(plainText);
        writer.write(encryped, targetFile);
    }
}

class FileReader {
    public String read(String fileName) {
        return fileName + ": content";
    }
}

class FileWriter {
    public void write(String encrypted, String fileName) {
        System.out.println("saved encrypted content to file " + fileName + ": " + encrypted);
    }
}

class CipherMachine {
    public String encrypt(String plainText) {
        return Base64.getEncoder().encodeToString(plainText.getBytes(StandardCharsets.UTF_8));
    }
}