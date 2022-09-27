import java.util.*;

public class vignere {

    public static void encryptDecrypt(String plaintext, String keyword) {
        char msg[] = plaintext.toCharArray();
        int msgLen = msg.length;
        int i, j;

        char key[] = new char[msgLen];
        char encryptedMsg[] = new char[msgLen];
        char decryptedMsg[] = new char[msgLen];

        for (i = 0, j = 0; i < msgLen; ++i, ++j) {
            if (j == keyword.length()) {
                j = 0;
            }
            key[i] = keyword.charAt(j);
        }

        for (i = 0; i < msgLen; ++i)
            encryptedMsg[i] = (char) (((msg[i] + key[i]) % 26) + 'A');

        for (i = 0; i < msgLen; ++i)
            decryptedMsg[i] = (char) ((((encryptedMsg[i] - key[i]) + 26) % 26) + 'A');

        System.out.println("Original Message: " + plaintext);
        System.out.println("Keyword: " + keyword);
        System.out.println("Key: " + String.valueOf(key));
        System.out.println();
        System.out.println("Encrypted Message: " + String.valueOf(encryptedMsg));
        System.out.println();
        System.out.println("Decrypted Message: " + String.valueOf(decryptedMsg));
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String plaintext = sc.nextLine();
        System.out.println("Enter keyword: ");
        String keyword = sc.nextLine();
        encryptDecrypt(plaintext, keyword);
    }
}
