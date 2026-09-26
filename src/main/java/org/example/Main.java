package org.example;

import org.example.service.RelatorioService;

public class Main {

    public static void main(String[] args) {

        RelatorioService service = new RelatorioService();

        System.out.println("Sistema iniciado.");

        System.out.println("\nSolicitando relatório...");
        service.gerarRelatorio();

        System.out.println("\nSolicitando relatório novamente...");
        service.gerarRelatorio();
    }
}