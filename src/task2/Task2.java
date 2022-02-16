package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter yor number");
        plusOne(scanner.nextInt());

    }

    static void plusOne(int number) {
        List<Integer> list = new ArrayList<>();
        list.add(number % 10 + 1);
        int test = number;
        int vit = 10;
        while (number / vit != 0) {
            test = number / vit % 10 + 1;
            list.add(test);
            vit = vit * 10;
        }
        int mult = 1;
        int f = 0;

        for (Integer one : list) {
            if (one == 10) {
                f += one * mult;
                mult = mult * 100;
            } else {
                f += one * mult;
                mult = mult * 10;

            }
        }
        System.out.println(f);
    }
}
