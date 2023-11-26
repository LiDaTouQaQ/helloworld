package com.iweb.work.service;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author LYH
 * @date 2023/11/24 16:27
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",8888);
        OutputStream os = s.getOutputStream();
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎面对淘宝客服");
        while (true){
            dos.writeUTF(sc.nextLine());
            System.out.println("收到客服信息:"+dis.readUTF());
        }
    }
}
