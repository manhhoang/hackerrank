package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindTheCommonManager {

	private class Node {
		public String name;
		public int level;
		public List<Node> children = new ArrayList<Node>();
	}

	public static void main(String[] args) throws IOException {
		String currentPath = new File(".").getCanonicalPath();
		String fileName = currentPath + "/src/Find The Common Manager";
		File file = new File(fileName);

		Scanner sc = new Scanner(file);
		int n = sc.nextInt();
		sc.nextLine();
		Map<String, Integer> map = new HashMap<String, Integer>();
		String first = sc.nextLine();
		String second = sc.nextLine();
		for (int i = 0; i < n; i++) {
			String[] line = sc.nextLine().split(" ");
			String parent = line[0];
			String child = line[1];
			if (i == 0) {
				map.put(parent, 1);
				map.put(child, 2);
			} else {
				int parentLevel = map.get(parent);
				map.put(child, parentLevel++);
			}

		}
	}
}
