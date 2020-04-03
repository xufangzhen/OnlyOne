package com.onlyone.algorithm.leecode;

import java.util.Stack;

public class LongestPalindrome {


    private Stack stack = new Stack();

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] charArray = s.toCharArray();
        int startPos = 0;
        int maxNum = 0;

        for (maxNum = charArray.length; maxNum > 1; maxNum--) {
            for (startPos = 0; startPos + maxNum <= charArray.length; startPos++) {
                int start = startPos;
                int end = startPos + maxNum - 1;
                while (start < end && charArray[start] == charArray[end]) {
                    start++;
                    end--;
                    if (start >= end) {
                        //成功
                        return s.substring(startPos, startPos + maxNum);
                    }
                }
            }
        }
        return s.substring(0, 1);
    }


}
