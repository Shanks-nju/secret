import java.util.Scanner;

public class Decoder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Where: ");
        String where = scanner.nextLine();
        String ciphertext;
        try {
            ciphertext = Reader.readFile(where);
        } catch (Exception e) {
            System.out.println("File reading failed.");
            return;
        }

        System.out.print("Password: ");
        String code = scanner.nextLine();

        String text;
        try {
            text = new String(Privacy.decrypt(ciphertext, code.getBytes()));
        } catch (Exception e) {
            System.out.println("Decoding failed.");
            return;
        }
        System.out.println(text);
    }
}
