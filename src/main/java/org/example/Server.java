package org.example;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
public class Server {
    Server(){}
    Server(int porta){
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(porta);
        } catch (IOException e) {
            System.out.println("Errore riscontrato durante la creazione server \n"+e.toString());}
        Socket clientSocket=null;
        while(true){
            try {
                clientSocket=serverSocket.accept();
            } catch (IOException e) {
                System.out.println("Eccezione riscontrata server accept \n"+e.toString());
                break;
            }
            System.out.println("Someone connected");
            Elaborazione thread=new Elaborazione(clientSocket,serverSocket);
            thread.start();
        }
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Errore riscontrato dutante la chiusura del socket");
        }

    }
}