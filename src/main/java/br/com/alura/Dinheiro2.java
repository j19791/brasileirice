package br.com.alura;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryOperators;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

public class Dinheiro2 {

	public static void main(String[] args) {

		CurrencyUnit moeda = Monetary.getCurrency("BRL"); // define a moeda
		MonetaryAmount valorDaParcela = Money.of(75, moeda); // define o valor associado a moeda
		System.out.println(valorDaParcela);
		MonetaryAmount valorTotal = valorDaParcela.multiply(12); // multiplica o valor da parcela por 12
		System.out.println(valorTotal);
		MonetaryAmount valorComDesconto = valorTotal.with(MonetaryOperators.percent(10)); // retorna 10% do valor total
		System.out.println(valorComDesconto); // 9E+1: precisão do BigDecimal

		NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());

		String valorPorExtenso = conversor.toWords(valorComDesconto.getNumber().doubleValue());
		System.out.println(valorPorExtenso);

		System.out.println("Olá, Aluno. Ganhe " + valorPorExtenso + " ouvindo nosso podcast. LINK");

	}

}
