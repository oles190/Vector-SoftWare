package task1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text");
        String text = scanner.nextLine();
        System.out.println("Enter key");
        int key = scanner.nextInt();


        System.out.println(encryption(text, key));
        String en = encryption(text, key);
        String des = decryption(en, key);
        System.out.println(des);
    }

    static String encryption(String text, int key) {
        String encryptedText = "";
        boolean check = false;
        int j = 0;
        int row = key;
        int col = text.length();
        char[][] a = new char[row][col];

        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1)
                check = !check;
            a[j][i] = text.charAt(i);

            if (check)
                j++;
            else
                j--;
        }
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (a[i][k] != 0)
                    encryptedText += a[i][k];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                System.out.print(a[i][k] + " ");
            }
            System.out.println();
        }

        return encryptedText;
    }


    static String decryption(String text, int key) {
        String decryptionText = "";
        boolean check = false;
        int j = 0;
        int row = key;
        int col = text.length();
        char[][] a = new char[row][col];

        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1)
                check = !check;
            a[j][i] = '*';

            if (check)
                j++;
            else
                j--;
        }
        int index = 0;
        check = false;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                if (a[i][k] == '*' && index < col) {
                    a[i][k] = text.charAt(index++);
                }
            }
        }
        j = 0;
        for (int i = 0; i < col; i++) {
            if (j == 0 || j == key - 1)
                check = !check;
            decryptionText += a[j][i];

            if (check)
                j++;
            else
                j--;
        }
        return decryptionText;
    }

}
