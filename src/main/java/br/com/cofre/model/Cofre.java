package br.com.cofre.model;

import java.util.List;

public class Cofre {
    private Double saldo = 0.0D;

    public void depositar(List<Dinheiro> dinheiro) {

        try {
            if (!dinheiro.isEmpty()) {
                saldo += somaDinheiro(dinheiro);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void sacar(Double quantia) {

        try {
            if (quantia <= saldo && quantia > 0) {
                saldo -= quantia;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Double somaDinheiro(List<Dinheiro> dinheiro) {
        return dinheiro.stream()
                .mapToDouble(Dinheiro::getValor)
                .sum();
    }

    public Double consultarSaldo() {
        return saldo;
    }
}
