package br.com.alura;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class Aula4 {

	public static void main(String[] args) {

		// Fa�a a valida��o desse CPF aqui: 51720155232 .
		String cpf = "51720155232";

		CPFValidator cpfValidator = new CPFValidator();

		try {
			cpfValidator.assertValid(cpf); // Se ele for v�lido, envie uma cobran�a pra ele no valor de R$900,00
											// ,referente � sua fatura do cart�o de cr�dito.

			CurrencyUnit moeda = Monetary.getCurrency("BRL"); // define a moeda
			MonetaryAmount valorDaParcela = Money.of(900, moeda);

			NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());

			// String valorPorExtenso = conversor.

			// .toWords(valorDaParcela.getNumber().doubleValue());

			System.out.println("Valor referente a fatura do cart�od e cr�dito" + valorDaParcela.toString());

		} catch (InvalidStateException e) {// Se n�o for v�lido, envie uma mensagem pedindo para ele atualizar seus
											// dados, pois est�o incorretos.
			System.out.println("atualizar seus dados, pois est�o incorretos.");
		}

	}

}
