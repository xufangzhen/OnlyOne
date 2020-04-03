package com.onlyone.algorithm.leecode;

public class Zconvert {

    public String convert(String s, int numRows) {

        if (s == null || s.length() <= 2 || numRows == 1) {
            return s;
        }

        int length = s.length();

        //一个单元包含多少列
        int unitColumn = 1 + (numRows - 2);
        //一个单元包含多少字符
        int unitStrNum = numRows + (numRows - 2);
        //共包含多少个完整单元
        int unitNums = length / unitStrNum;
        //这些单元共多少列
        int column = unitColumn * unitNums;
        //剩余字符多少
        int residue = length % unitStrNum;
        //剩余字符多少列
        if (residue != 0) {
            if (residue < numRows) {
                column++;
            } else {
                column += (1 + residue % numRows);
            }
        }
        Character[][] zTab = new Character[column][numRows];
        char[] array = s.toCharArray();
        int i = 0;
        int j = 0;
        for (int k = 0; k < array.length; k++) {
            zTab[i][j] = array[k];
            if (i % (numRows - 1) == 0 && j < numRows - 1) {
                j++;
            } else {
                i++;
                j--;
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (j = 0; j < numRows; j++) {
            for (i = 0; i < column; i++) {
                if (zTab[i][j] != null) {
                    stringBuffer.append(zTab[i][j]);
                }
            }
        }

        return stringBuffer.toString();
    }


    public String convert2(String s, int numRows) {
        if (s == null || s.length() <= 2 || numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        StringBuilder stringBuilder = new StringBuilder();
        int unitStrNum = numRows * 2 - 2;


        int firstLayerNum = length / unitStrNum;

        if (length % unitStrNum > numRows) {
            firstLayerNum += 2;
        } else if (length % unitStrNum > 0) {
            firstLayerNum++;
        }

        int[] firstLayer = new int[firstLayerNum + 1];
        int k = 0;
        for (int i = 0; i < chars.length; i += unitStrNum) {
            firstLayer[k] = i;
            stringBuilder.append(chars[i]);
            k++;
        }
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = 0; j < firstLayerNum; j++) {
                if (firstLayer[j] - i > 0) {
                    stringBuilder.append(chars[firstLayer[j] - i]);
                }
                if (firstLayer[j] + i < chars.length) {
                    stringBuilder.append(chars[firstLayer[j] + i]);
                }
            }
        }
        for (int i = numRows - 1; i < chars.length; i += unitStrNum) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }


}
