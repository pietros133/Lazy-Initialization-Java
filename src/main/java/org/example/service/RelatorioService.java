package org.example.service;

import org.example.generator.RelatorioGenerator;
import org.example.model.Relatorio;

public class RelatorioService {

    private Relatorio relatorio;
    private RelatorioGenerator generator;

    public Relatorio getRelatorio() {
        if (relatorio == null) {
            relatorio = new Relatorio("vendas");
        }

        return relatorio;
    }

    public void gerarRelatorio() {

        if (generator == null) {
            generator = new RelatorioGenerator();
        }

        generator.gerar(getRelatorio());
    }
}