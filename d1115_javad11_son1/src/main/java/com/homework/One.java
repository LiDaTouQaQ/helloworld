package com.homework;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author LYH
 * @date 2023/11/16 8:17
 */
public class One {
    public static void numberCount(int[] arr){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                for(int k=0;k< arr.length;k++){
                    if(i==j|i==k|j==k){
                        continue;
                    }
                    count++;
                    System.out.print(""+arr[i]+arr[j]+arr[k]+" ");
                }
            }
            System.out.println();
        }
        System.out.println(count);
    }
    public static void multiplicationFormulaTable(){
        for(int i=1;i<10;i++)
        {
            for(int j=1;j<i+1;j++)
            {
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
    }

    public static void hash() {
        Map<String,String> map = new HashMap<>();
        map.put("Name","joy");
        map.put("Age","30");
        map.put("Address","Room 1802,No.256PuDong(South)Road");
        Set<String> list = map.keySet();
        for (String s :list) {
            System.out.println(s+" "+map.get(s));
        }
    }

    public static void main(String[] args) {
        // int[] arr = {1,2,3,4};
        // numberCount(arr);
        // multiplicationFormulaTable();
        hash();
    }
}
