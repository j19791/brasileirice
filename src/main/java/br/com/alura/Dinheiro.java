package br.com.alura;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.javamoney.moneta.convert.ExchangeRateType;

public class Dinheiro {

	public static void main(String[] args) {
		// definir a moeda com a qual trabalharemos.
		CurrencyUnit moeda = Monetary.getCurrency("BRL");

		// valor monetario
		MonetaryAmount valorDaParcela = Money.of(75, moeda);

		System.out.println(valorDaParcela);

		System.out.println(valorDaParcela.multiply(12)); // multiplicando valor monetario

		// Primeiro vamos criar as moedas e os valores
		CurrencyUnit dolar = Monetary.getCurrency("USD");
		CurrencyUnit real = Monetary.getCurrency("BRL");

		MonetaryAmount valorProdutoDolar = FastMoney.of(90, dolar);
		MonetaryAmount valorImpostoReal = FastMoney.of(30, real);

		System.out.println(valorImpostoReal);

		// Agora vamos usar o provider para pegar a cotação
		ExchangeRateProvider provider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.IMF);

		// Vamos pegar a conversão atual(do dia)
		CurrencyConversion conversaoAtual = provider.getCurrencyConversion("USD");
		System.out.println(conversaoAtual.toString());

		// Agora vamos transformar o valor do imposto em Real para dólar
		MonetaryAmount valorImpostoDolar = conversaoAtual.apply(valorImpostoReal);
		System.out.println(valorImpostoDolar);

		// Agora que o valor do imposto está em dólar, podemos somar com o valor inicial
		// do produto
		MonetaryAmount valorFinalProdutoDolar = valorProdutoDolar.add(valorImpostoDolar);

		System.out.println(valorFinalProdutoDolar);

	}

}
