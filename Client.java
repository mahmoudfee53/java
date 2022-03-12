package edu.fee;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client started");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Socket socket = new Socket("localhost",5050);


        InputStream inputStream = socket.getInputStream();
        DataInputStream socketDIS = new DataInputStream(inputStream);
        String serverMsg = socketDIS.readUTF();
        System.out.println(serverMsg);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         Scanner input=new Scanner(System.in);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream socketDOS = new DataOutputStream(outputStream);
        System.out.println("enter a message for the server");
        String clientMsg = input.nextLine();
        socketDOS.writeUTF("client:"+clientMsg);
        
        System.out.println("client:"+clientMsg);


        socketDOS.close();
        socketDIS.close();
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}