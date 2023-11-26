package com.iweb.homework.two;

import java.io.File;

/**
 * @author LYH
 * @date 2023/11/20 14:46
 */
public class Test {
    private File file = new File("E:/");
    private static long maxFile = 0;
    private static long minFile = 10000000;
    public static void fileLength(File file){
        if(!file.isDirectory()){
            if(file.length()>maxFile){
                maxFile = file.length();
            }
            if(file.length()<minFile & file.length() !=0){
                minFile = file.length();
            }
        }else{
            // File[] filelist = file.listFiles();
            // for (File f1 :
            //         filelist) {
            //     fileLength(f1);
            // }

            File[] filelist = file.listFiles();
            for (final File f1 : filelist) {
                Thread thread = new Thread(){
                    @Override
                    public void run() {
                        fileLength(f1);
                    }
                };
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        fileLength(new File("E:/"));
        long end = System.currentTimeMillis();
        System.out.println("最大文件为: "+maxFile);
        System.out.println("最小文件为: "+minFile);
        System.out.println("耗时"+(end-start));
    }
}
