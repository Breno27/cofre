package br.com.cofre.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CofreTest {

    List<Dinheiro> moedasECedulas = Arrays.asList(Moeda.UM_CENTAVO, Moeda.CINCO_CENTAVOS, Moeda.DEZ_CENTAVOS, Cedula.CEM_REAIS, Cedula.CINCO_REAIS);
    List<Dinheiro> moedas = Arrays.asList(Moeda.UM_CENTAVO, Moeda.CINCO_CENTAVOS, Moeda.DEZ_CENTAVOS);
    List<Dinheiro> cedulas = Arrays.asList(Cedula.CEM_REAIS, Cedula.CINCO_REAIS);

    @Test
    void deveDepositarAoReceberMoedasECedulas() {
        Cofre cofre = new Cofre();

        cofre.depositar(moedasECedulas);
        assertEquals(105.16, cofre.consultarSaldo());
    }

    @Test
    void deveDepositarAoReceberApenasMoedas() {
        Cofre cofre = new Cofre();

        cofre.depositar(moedas);
        assertEquals(0.16, cofre.consultarSaldo());
    }

    @Test
    void deveDepositarAoReceberApenasCedulas() {
        Cofre cofre = new Cofre();

        cofre.depositar(cedulas);
        assertEquals(105.0, cofre.consultarSaldo());
    }

    @Test
    void deveSacarQuandoQuantiaMenorQueSaldo() {
        Cofre cofre = new Cofre();
        cofre.depositar(cedulas);

        cofre.sacar(100.0);
        assertEquals(5.0, cofre.consultarSaldo());
    }

    @Test
    void deveSacarQuandoQuantiaIgualQueSaldo() {
        Cofre cofre = new Cofre();
        cofre.depositar(cedulas);

        cofre.sacar(105.0);
        assertEquals(0.0, cofre.consultarSaldo());
    }

    @Test
    void naoDeveSacarQuandoQuantiaMaiorQueSaldo() {
        Cofre cofre = new Cofre();
        cofre.depositar(cedulas);

        cofre.sacar(200.0);
        assertEquals(105.0, cofre.consultarSaldo());
    }

    @Test
    void naoDeveSacarQuandoQuantiaZero() {
        Cofre cofre = new Cofre();
        cofre.depositar(cedulas);

        cofre.sacar(0.0);
        assertEquals(105.0, cofre.consultarSaldo());
    }

    @Test
    void naoDeveSacarQuandoQuantiaNegativa() {
        Cofre cofre = new Cofre();
        cofre.depositar(cedulas);

        cofre.sacar(-10.0);
        assertEquals(105.0, cofre.consultarSaldo());
    }

}