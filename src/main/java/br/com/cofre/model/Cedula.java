package br.com.cofre.model;

public enum Cedula implements Dinheiro {
    UM_REAL("Um Real", 1.0),
    DOIS_REAIS("Dois Reais", 2.0),
    CINCO_REAIS("Cinco Reais", 5.0),
    DEZ_REAIS("Dez Reais", 10.0),
    VINTE_REAIS("Vinte Reais", 20.0),
    CINQUENTA_REAIS("Cinquenta Reais", 50.0),
    CEM_REAIS("Cem Reais", 100.0),
    DUZENTOS_REAIS("Duzentos Reais", 200.0);

    private final String nome;
    private final Double valor;

    Cedula(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }


    @Override
    public String getValorPorExtenso() {
        return nome;
    }

    @Override
    public Double getValor() {
        return valor;
    }
}
