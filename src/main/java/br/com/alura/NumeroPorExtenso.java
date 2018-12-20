package br.com.alura;

import java.math.BigDecimal;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

public class NumeroPorExtenso {

	public static void main(String[] args) {

		// recebe o formato pelo qual vc deseja converter
		// NumericToWordsConverter conversor = new NumericToWordsConverter(new
		// InteiroSemFormato());

		NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());// ideal para trabalhar com
																								// valores monetarios

		// double valor = 75.00;

		BigDecimal valor = new BigDecimal(12341218457345.22); // maior precisao em multiplicaoes

		;

		System.out.println(conversor.toWords(valor.doubleValue())); // ja inclui a palvra reais

	}

}
