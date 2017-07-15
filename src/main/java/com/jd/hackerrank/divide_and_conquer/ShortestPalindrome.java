package com.jd.hackerrank.divide_and_conquer;

import java.io.File;
import java.util.Scanner;

public class ShortestPalindrome {

    static int palin(int i, int j, String s) {
        if (!isPalin(s, i, j)) {
            return 1 + palin(++i, j, s) + palin(i, --j, s);
        } else {
            return 0;
        }
    }

    static boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    static int shortPalin(String s) {
        int i = 0;
        int j = s.length() - 1;
        return palin(i, j, s);
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        String currentPath = new File(".").getCanonicalPath();
        String fileName = currentPath + "/src/Shortest Palindrome";
        File file = new File(fileName);

        Scanner sc = new Scanner(file);
        while (true) {
            String s = sc.nextLine();
            if (s.equals("")) {
                break;
            }
            System.out.println(shortPalin(s));
        }
    }
}
