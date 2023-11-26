package com.iweb.work.service;

import com.iweb.work.controller.ReplyServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LYH
 * @date 2023/11/24 16:27
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("正在监听8888");
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos = new DataOutputStream(os);
        while (true){
            String receive = dis.readUTF();
            System.out.println("收到客户消息:"+receive);
            dos.writeUTF(ReplyServer.getRsponse(receive));
        }
    }
}
