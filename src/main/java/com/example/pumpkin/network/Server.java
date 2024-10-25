package com.example.pumpkin.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {

    static final List<PrintWriter> writers = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket socket = serverSocket.accept();
                Thread.ofVirtual().start(() -> handleClient(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void handleClient(Socket socket) {
        PrintWriter writer = null;
        try (Socket clientSocket = socket) {
            System.out.println("[" + Thread.currentThread().threadId() +  "] Client connected...");
            writer = new PrintWriter(clientSocket.getOutputStream());
            writers.add(writer);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             while(true) {
                 String message = in.readLine();
                 System.out.println(message);
                 sendMessageToAllConnected(message);
             }
        } catch (IOException e) {
            System.out.println("Client disconnected.. or something else happened.");
            writers.remove(writer);
        }
    }

    private static void sendMessageToAllConnected(String message) {
        synchronized (writers) {
            for (PrintWriter writer : writers) {
                writer.println(message);
                writer.flush();
            }
        }
    }
}
