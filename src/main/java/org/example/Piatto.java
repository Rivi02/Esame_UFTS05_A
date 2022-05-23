package org.example;

public class Piatto {
    int id;
    String nome;
    String descrizione;
    double costo;
    Piatto(){}

    public String getNome() {
        return nome;
    }

    public Piatto(String nome, int id, String descrizione, double costo) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "{ piatti:" +
                "Nome Piatto=" + nome +
                ", id=" + id +
                ", descrizione=" + descrizione +
                ", costo=" + costo +
                '}';
    }


}