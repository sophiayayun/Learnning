package com.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by dengyayun on 17/11/16.
 */
public class Client {
    private static int PORT = 8379;
    private static String IP = "127.0.0.1";

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        Socket socket = null;
        BufferedWriter bw = null;
        try {
            socket = new Socket(IP, PORT);
            // 我要给对方的东西
            printWriter = new PrintWriter(socket.getOutputStream(), true);
//            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //对方给我的东西
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            printWriter.println("客户端请求了服务器....");
            printWriter.println("客户端请求了服务器2号....");
//            bw.write("客户端请求了服务器....");

            String response = bufferedReader.readLine();
            System.out.println("Client：" + response);
//            while (true) {
//                String response = bufferedReader.readLine();
//                System.out.println("Client：" + response);
//                if(response == null)
//                    break;
//            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(printWriter != null){
                try {
                    printWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                socket = null;
            }
        }
    }
}
