package com.homework.five;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * @author LYH
 * @date 2023/11/24 21:38
 */
public class Test {
    public static void allFile(){
        System.out.println("输入路径");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        File file = new File(path);
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f :files) {
                System.out.println(f.getAbsoluteFile());
            }
        }else{
            System.out.println("路径存在错误");
        }
    }

    public static void main(String[] args) {
        allFile();
    }
}
