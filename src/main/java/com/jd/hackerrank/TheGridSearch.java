package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class TheGridSearch {

    private static int R;
    private static int C;
    private static int r;
    private static int c;

    private static int[][] formG(Scanner sc) {
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        int[][] G = new int[R][C];
        for (int j = 0; j < R; j++) {
            char[] val = sc.nextLine().toCharArray();
            for (int k = 0; k < C; k++) {
                G[j][k] = Integer.parseInt(String.valueOf(val[k]));
            }
        }
        return G;
    }

    private static int[][] formP(Scanner sc) {
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        int[][] P = new int[r][c];
        for (int j = 0; j < r; j++) {
            char[] val = sc.nextLine().toCharArray();
            for (int k = 0; k < c; k++) {
                P[j][k] = Integer.parseInt(String.valueOf(val[k]));
            }
        }
        return P;
    }

    private static boolean isSubArray(int[][] G, int[][] P, int offsetR, int offsetC) {
        boolean isSubArray = true;
        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                if (offsetR + y > R - 1
                        || offsetC + x > C - 1
                        || (offsetR + y <= R - 1 && offsetC + x <= C - 1 && P[y][x] != G[offsetR + y][offsetC
                        + x])) {
                    return false;
                }
            }

        }
        return isSubArray;
    }

    public static void main(String[] args) throws Exception {
        String currentPath = new File(".").getCanonicalPath();
        String fileName = currentPath + "/src/main/data/hackerrank/The Grid Search";
        File file = new File(fileName);

        Scanner sc = new Scanner(file);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int[][] G = formG(sc);
            int[][] P = formP(sc);
            boolean isSubArray = false;
            breakLoop:
            for (int y = 0; y < R; y++) {
                for (int x = 0; x < C; x++) {
                    if (G[y][x] == P[0][0]) {
                        if (isSubArray(G, P, y, x)) {
                            isSubArray = true;
                            break breakLoop;
                        }
                    }
                }
            }
            if (isSubArray) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
