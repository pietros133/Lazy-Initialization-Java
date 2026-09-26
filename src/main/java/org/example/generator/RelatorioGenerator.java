package org.example.generator;

import org.example.model.Relatorio;

public class RelatorioGenerator {

    public RelatorioGenerator() {
        System.out.println("RelatorioGenerator criado!");
    }

    public void gerar(Relatorio relatorio) {
        relatorio.gerar();
    }
}