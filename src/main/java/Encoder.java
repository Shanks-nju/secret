import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class Encoder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Source (end with '^'): ");
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1 && c != (int) '^') {
            sb.append((char) c);
        }
        reader.read();
        reader.read();

        System.out.print("Target file: ");
        String target = reader.readLine();

        System.out.print("Password: ");
        String code = reader.readLine();

        String ciphertext;
        try {
            ciphertext = Privacy.encrypt(sb.toString().getBytes(), code.getBytes());
        } catch (Exception e) {
            System.out.println("Encoding failed.");
            return;
        }
        try (FileWriter fw = new FileWriter(new File(target))) {
            fw.write(ciphertext);
        } catch (Exception e) {
            System.out.println("Error caught during writing file.");
        }
    }
}
