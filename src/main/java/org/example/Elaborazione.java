package org.example;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Elaborazione extends Thread{
    Gson gson=new Gson();
    Socket clientSocket=null;
    ServerSocket serverSocket=null;
    static Operazioni_Arraylist o;

    Elaborazione(){}

    Elaborazione(Socket clientSocket, ServerSocket serverSocket){
        this.clientSocket=clientSocket;
        this.serverSocket=serverSocket;
    }
    void createOperation(){
        o=new Operazioni_Arraylist();
        o.crea_lista();
    }
    @Override
    public void run(){
        BufferedReader input=null;
        try {
            input=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Errore\n"+e.toString());
        }
        String messaggio="";
        PrintWriter output=null;
        try {
            output=new PrintWriter(clientSocket.getOutputStream(),true);
        } catch (IOException e) {
            System.out.println("Errore \n"+e.toString());
        }
        output.println("connected");

        try {
            while ((messaggio = input.readLine()) != null) {
                output.println(elaborazione_messaggio(messaggio.toLowerCase(Locale.ROOT)));
            }
        }catch(IOException e){
            System.out.println("Errore\n"+e.toString());
        }
    }

    String elaborazione_messaggio(String digitato){
        String result="";
        switch (digitato){
            case "all":
                result=o.all();
                break;
            case "more_expensive":
                result=o.maxPrice();
                break;
            case "all_sorted":
                result=o.sort();
                break;
            default:
                result="il comando digitato non esiste";
                break;
        }
        return result;
    }






}