package org.example.model;

public class Relatorio {

    private String tipo;

    public Relatorio(String tipo) {
        this.tipo = tipo;

        System.out.println("Relatorio criado!");
    }

    public void gerar() {
        System.out.println("Gerando relatório: " + tipo);
    }
}