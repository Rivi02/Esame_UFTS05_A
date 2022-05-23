package org.example;

/**
 * Verderio Riccardo
 */
public class App
{
    public static void main( String[] args )
    {
        Elaborazione o=new Elaborazione();
        o.createOperation();
        Server server= new Server(1234);
    }
}