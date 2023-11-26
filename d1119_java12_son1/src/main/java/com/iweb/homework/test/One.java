package com.iweb.homework.test;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author LYH
 * @date 2023/11/21 16:49
 */
public class One {
    private static void noRepeat(Integer num){
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        String str = num.toString();
        char[] chars = str.toCharArray();
        for (char c:chars) {
            treeSet.add(Character.digit(c,10));
        }
        for (Integer i :treeSet) {
            System.out.print(i);
        }
    }



    public static void main(String[] args) {
        noRepeat(1123332221);
    }
}
