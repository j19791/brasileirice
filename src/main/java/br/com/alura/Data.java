package br.com.alura;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Data {

	public static void main(String[] args) {

		LocalDate hoje = LocalDate.now();// retorna a data atual no padrão internacional aaaa-MM-dd
		System.out.println(hoje);

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // recebe uma string e coloca no
																					// padrão que desejamos

		System.out.println(hoje.format(formatador)); // data formatada a partir desse formatador

		LocalDateTime agora = LocalDateTime.now(); // data e hora atual: 2018-12-19T21:23:05.573

		System.out.println(agora);

		DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

		System.out.println(agora.format(formatadorHora));

		DateTimeFormatter formatadorCurto = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT); // formata uma
																										// data/hora a
																										// partir de um
																										// formatStyle
		// enum do java

		System.out.println(agora.format(formatadorCurto)); // sem minutos e YY

		DateTimeFormatter formatadorMedio = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM); // com minutos e
																										// YYYY

		System.out.println(agora.format(formatadorMedio));

		DateTimeFormatter formatadorChina = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.CHINA); // hora
																																// curta
																																// da
																																// china

		System.out.println(agora.format(formatadorChina));

		DateTimeFormatter formatadorBrasileiro = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("pt", "br")); // nao
																																				// existe
																																				// o
																																				// padrão
																																				// brasileiro.
		System.out.println(agora.format(formatadorBrasileiro)); // criamos um novo com sua língua " pt" e qual sua
																// especificação "br".

		System.out.println(agora.minusHours(5));

		System.out.println(agora.plusHours(5));

	}

}
