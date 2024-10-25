package com.example.pumpkin.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    String host = "fungover.org";
    int port = 8080;
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    boolean connected = false;

    public void connect(){
        try {
            socket = new Socket(host, port);
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            connected = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void disconnect(){
        try {
            socket.close();
            connected = false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String message) {
        out.println(message);
        out.flush();
    }
}
