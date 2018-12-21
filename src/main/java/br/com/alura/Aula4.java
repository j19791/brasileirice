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

		// Faça a validação desse CPF aqui: 51720155232 .
		String cpf = "51720155232";

		CPFValidator cpfValidator = new CPFValidator();

		try {
			cpfValidator.assertValid(cpf); // Se ele for válido, envie uma cobrança pra ele no valor de R$900,00
											// ,referente à sua fatura do cartão de crédito.

			CurrencyUnit moeda = Monetary.getCurrency("BRL"); // define a moeda
			MonetaryAmount valorDaParcela = Money.of(900, moeda);

			NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());

			// String valorPorExtenso = conversor.

			// .toWords(valorDaParcela.getNumber().doubleValue());

			System.out.println("Valor referente a fatura do cartãod e crédito" + valorDaParcela.toString());

		} catch (InvalidStateException e) {// Se não for válido, envie uma mensagem pedindo para ele atualizar seus
											// dados, pois estão incorretos.
			System.out.println("atualizar seus dados, pois estão incorretos.");
		}

	}

}
