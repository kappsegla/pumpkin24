package com.example.pumpkin.network;

import com.example.pumpkin.model.ChatModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.function.Consumer;

public class Client {
    String host = "fungover.org";
    int port = 8080;
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    boolean connected = false;
    Consumer<String> callback;

    public void connect(Consumer<String> callback) {
        try {
            socket = new Socket(host, port);
            out = new PrintWriter(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            connected = true;
            this.callback = callback;
            Thread.ofVirtual().start(()->listenForMessages());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listenForMessages() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                callback.accept(message);
            }
        }catch (IOException e) { }
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
