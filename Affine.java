import java.util.*;

public class Affine {

    static String encryptMessage(char[] msg, int a, int b) {
        String cipherText = "";
        for (int i = 0; i < msg.length; i++) {
            if (msg[i] != ' ') {
                cipherText += (char) (((a * (msg[i] - 'A') + b) % 26) + 'A');
            } else {
                cipherText += msg[i];
            }
        }
        return cipherText;
    }

    static String decryptMessage(char[] cipher, int a, int b) {
        String msg = "";
        int a_inverse = 0;
        int flag = 0;

        for (int i = 0; i < 26; i++) {
            flag = (a * i) % 26;
            if (flag == 1) {
                a_inverse = i;
            }
        }

        for (int i = 0; i < cipher.length; i++) {
            if (cipher[i] != ' ') {
                msg += (char) (((a_inverse * ((cipher[i] + 'A' - b)) % 26)) + 'A');
            } else {
                msg += cipher[i];
            }
        }
        return msg;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String msg = sc.nextLine();
        System.out.println("Enter a value: ");
        int a = sc.nextInt();
        System.out.println("Enter b value: ");
        int b = sc.nextInt();
        String encryptedMsg = encryptMessage(msg.toUpperCase().toCharArray(), a, b);
        System.out.println("The Encrypted message is " + encryptedMsg);
        String decryptedMsg = decryptMessage(encryptedMsg.toCharArray(), a, b);
        System.out.println("The Decrypted message is " + decryptedMsg);
    }
}
