package com.demo.component_scan.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CodeGenerator {

    private static final char[] CHARS = initChars();

    private static char[] initChars() {
        char[] chars = new char[36];
        int idx = 0;
        for (char c = '0'; c <= '9'; c++) {
            chars[idx++] = c;
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            chars[idx++] = c;
        }
        return chars;
    }

    private static int charToIndex(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else if (c >= 'A' && c <= 'Z') {
            return 10 + (c - 'A');
        } else {
            throw new IllegalArgumentException("Invalid character: " + c);
        }
    }

    public static String nextCode(String current) {
        if (current == null || current.length() != 2) {
            throw new IllegalArgumentException("Code must be 2 characters long");
        }

        char[] arr = current.toCharArray();
        int index2 = charToIndex(arr[1]);
        int index1 = charToIndex(arr[0]);

        // tăng chữ số thứ 2 trước
        index2++;
        if (index2 >= CHARS.length) {
            index2 = 0;
            index1++;
            if (index1 >= CHARS.length) {
                throw new IllegalStateException("Code overflow: " + current);
            }
        }

        return "" + CHARS[index1] + CHARS[index2];
    }
}