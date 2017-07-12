package com.jd.hackerrank;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public static String validate(String msg) {
        try {
            validateSingle(msg);
            validateEscape(msg);
            msg = msg.replace("~~", "...");
            String[] records = msg.split("\\~n", 0);
            records = correct(records);
            Object[] names = validateHeader(records[0]);
            String name = (String) names[1];
            int numberOfField = (Integer) names[0];
            int numberOfEmpty = 0;
            List<Integer> emptyFields = new ArrayList<>();
            List<Integer> fields = new ArrayList<>();
            for (int i = 1; i < records.length; i++) {
                Object[] results = validateRecord(records[i], numberOfField);
                if (numberOfField < (Integer) results[0]) {
                    numberOfField = (Integer) results[0];
                }
                emptyFields.add((Integer) results[1]);
                fields.add((Integer) results[0]);
            }
            for (int i = 0; i < fields.size(); i++) {
                numberOfEmpty += emptyFields.get(i) + (numberOfField - fields.get(i));
            }
            if ((Integer) names[0] < numberOfField) {
                name = name + "_" + (numberOfField - (Integer) names[0]);
            }
            return (records.length - 1) + ":" + numberOfField + ":" + numberOfEmpty + ":" + name;
        } catch (Exception e) {

            return "0:0:0:format_error";
        }
    }

    private static Object[] validateHeader(String record) throws Exception {
        record = record.replace("~|", "__");
        if (!record.startsWith("|") || !record.endsWith("|")) {
            throw new Exception();
        }
        record = record.substring(1, record.length() - 1);
        String[] names = record.split("\\|", -1);
        Set<String> namecheck = new HashSet<>();
        for (String s : names) {
            if (s.length() == 0 || s.trim().length() == 0) {
                throw new Exception();
            }
            if (!namecheck.add(s)) {
                throw new Exception();
            }
        }
        Object[] results = new Object[3];
        String lastname = names[names.length - 1];
        lastname = lastname.replace("__", "|");
        lastname = lastname.replace("...", "~");
        results[0] = names.length;
        results[1] = lastname;
        return results;
    }

    private static Object[] validateRecord(String record, int headers) throws Exception {
        record = record.replace("~|", "__");
        if (!record.startsWith("|") || !record.endsWith("|")) {
            throw new Exception();
        }
        if (record.length() == 1) {
            Object[] results = new Object[3];
            results[0] = 0;
            results[1] = 0;
            return results;
        }
        record = record.substring(1, record.length() - 1);
        String[] records = record.split("\\|", -1);
        int numberOfField = records.length;
        int numberOfEmpty = 0;
        for (String s : records) {
            if (s.length() == 0 || s.trim().length() == 0) {
                numberOfEmpty++;
            }
        }

        Object[] results = new Object[3];
        results[0] = numberOfField;
        results[1] = numberOfEmpty;
        return results;

    }

    private static String[] correct(String[] records) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < records.length; i++) {
            while (records[i].startsWith("~n")) {
                records[i] = records[i].substring(2);
            }
            if (records[i].trim().length() > 0) {
                result.add(records[i]);
            }
        }
        String a[] = new String[result.size()];
        result.toArray(a);
        return a;
    }

    private static void validateEscape(String s) throws Exception {
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '~') {
                i++;
                char nextChar = s.charAt(i);
                if (nextChar != '|' && nextChar != 'n' && nextChar != '~') {
                    throw new Exception();
                }
            }
            i++;
        }
    }

    private static void validateSingle(String s) throws Exception {
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c < 0x20 || c > 0x7E) {
                throw new Exception();
            }
            i++;
        }
    }

    @Test
    public void test1() {
        Assert.assertEquals("2:3:1:address_1", validate("|name|address|"
                + "~n|Patrick|patrick@test.com|pat@test.com|"
                + "~n|Annie||annie@test.com|~n"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("0:0:0:format_error", validate("~~~"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("2:6:7:address_4", validate("|name|address|"
                + "~n||1|Patrick|pat@test.com|"
                + "~n||||Annie||annie@test.com|~n"));
    }

    @Test
    public void test4() {
        Assert.assertEquals("2:3:2:address~n", validate("~n~n~n|age|name|address~~n|"
                + "~n|Patrick@test.com|pat@test.com~~~||"
                + "~n|Annie||annie@test.com|~n"));
    }
}
