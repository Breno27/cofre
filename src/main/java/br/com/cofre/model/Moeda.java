package br.com.cofre.model;

public enum Moeda implements Dinheiro {
    UM_CENTAVO("Um Centavo", 0.01),
    CINCO_CENTAVOS("Cinco Centavos", 0.05),
    DEZ_CENTAVOS("Dez Centavos", 0.1),
    VINTE_E_CINCO_CENTAVOS("Vinte Centavos", 0.25),
    CINQUENTA_CENTAVOS("Cinquenta Centavos", 0.5),
    UM_REAL("Um Real", 1.0);

    private final String nome;
    private final Double valor;

    Moeda(String nome, Double valor) {
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
