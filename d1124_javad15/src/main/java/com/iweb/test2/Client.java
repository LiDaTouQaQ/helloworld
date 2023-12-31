package com.iweb.test2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author LYH
 * @date 2023/11/24 15:52
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",8888);
        OutputStream os = s.getOutputStream();
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while (true){
            dos.writeUTF(sc.nextLine());
            System.out.println("收到服务器端信息:"+dis.readUTF());
        }
    }
}
