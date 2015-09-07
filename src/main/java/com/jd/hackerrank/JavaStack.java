package com.jd.hackerrank;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class JavaStack {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Java Stack";
    File file = new File(fileName);

    // Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(file);
    while (sc.hasNext()) {
      Parser X = new Parser();
      System.out.println(X.checkParenthesesBalance(sc.next()));
    }
  }
}

class Parser {
  private static final Map<Character, Character> brackets = new HashMap<Character, Character>();
  static {
    brackets.put('[', ']');
    brackets.put('{', '}');
    brackets.put('(', ')');
  }

  boolean checkParenthesesBalance(String str) {
    if (str.length() == 0) {
      throw new IllegalArgumentException("String length should be greater than 0");
    }
    // odd number would always result in false
    if ((str.length() % 2) != 0) {
      return false;
    }

    final Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < str.length(); i++) {
      if (brackets.containsKey(str.charAt(i))) {
        stack.push(str.charAt(i));
      } else if (stack.empty() || (str.charAt(i) != brackets.get(stack.pop()))) {
        return false;
      }
    }
    return true;
  }
}
