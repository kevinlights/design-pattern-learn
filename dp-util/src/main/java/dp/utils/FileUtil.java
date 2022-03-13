package dp.utils;

import java.io.*;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class FileUtil {
    public static void writeObject(Object obj, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos))) {
            oos.writeObject(obj);
        } catch (Exception e) {
            System.out.println("保存失败！");
            e.printStackTrace();
        }
    }

    public static Object readObject(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis))) {
            return ois.readObject();
        } catch (Exception e) {
            System.out.println("读取失败！");
            e.printStackTrace();
            return null;
        }
    }
}
