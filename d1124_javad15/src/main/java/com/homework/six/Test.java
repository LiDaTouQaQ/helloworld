package com.homework.six;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author LYH
 * @date 2023/11/24 21:49
 */
public class Test {
    public static void copyFile(){
        System.out.println("输入文件路径");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        File file = new File(path);
        if(file.isFile()){
            System.out.println("输入目标路径");
            path = sc.nextLine();
            File file1 = new File(path);
            if(file1.isDirectory()){
                path = path+"/"+file.getName();
                try(FileInputStream fis = new FileInputStream(file);
                    FileOutputStream fos = new FileOutputStream(new File(path));){
                    byte[] bytes = new byte[(int)file.length()];
                    fis.read(bytes);
                    fos.write(bytes);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                System.out.println("目标路径不是目录");
            }
        }else{
            System.out.println("文件路径不是文件");
        }
    }

    public static void main(String[] args) {
        copyFile();
    }
}
