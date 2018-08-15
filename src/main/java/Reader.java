import java.io.File;
import java.io.FileInputStream;

public class Reader {
    public static String readFile(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new Exception("File not found.");
        }
        long length = file.length();
        byte[] bytes = new byte[(int) length];
        try (FileInputStream fis = new FileInputStream(file)) {
            int tmp = fis.read(bytes);
            if (tmp != length) {
                throw new Exception();
            }
            return new String(bytes);
        } catch (Exception e) {
            throw new Exception("Error caught during reading file.");
        }
    }
}
