package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class TwoStrings {

    public static void main(String[] args) throws Exception {
        String currentPath = new File(".").getCanonicalPath();
        String fileName = currentPath + "/src/Two Strings";
        File file = new File(fileName);

        Scanner sc = new Scanner(file);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String A = sc.nextLine();
            String B = sc.nextLine();
            String flag = "NO";
            for (int j = 97; j <= 122; j++) {
                if (A.indexOf((char) j) != -1 && B.indexOf((char) j) != -1) {
                    flag = "YES";
                    break;
                }
            }
            System.out.println(flag);
        }
        sc.close();
    }
}
