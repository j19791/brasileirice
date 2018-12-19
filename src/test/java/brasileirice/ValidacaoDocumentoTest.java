package brasileirice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.format.Formatter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.stella.validation.NITValidator;
import br.com.caelum.stella.validation.Validator;

public class ValidacaoDocumentoTest {

	@Test
	public void deveTestarCPFValido() {

		String cpf = "86288366757";
		String teste;
		CPFValidator cpfValidator = new CPFValidator();

		try {
			cpfValidator.assertValid(cpf);
			teste = "CPF V�LIDO";
		} catch (InvalidStateException e) {
			teste = "CPF INV�LIDO : " + e;
		}

		assertEquals("CPF V�LIDO", teste);

	}

	@Test
	public void deveTestarCPFInvalido() {

		String cpf = "98745366797";
		String teste;
		CPFValidator cpfValidator = new CPFValidator();

		try {
			cpfValidator.assertValid(cpf);
			teste = "CPF V�LIDO";
		} catch (InvalidStateException e) {
			teste = "CPF INV�LIDO : " + e;
			System.out.println(teste);
		}

		assertNotEquals("CPF V�LIDO", teste);

	}

	@Test
	public void deveInvalidarNumerosRepetidosCPF() {
		String cpf = "22222222222";
		String teste;
		CPFValidator cpfValidator = new CPFValidator();

		try {
			cpfValidator.assertValid(cpf);
			teste = "CPF V�LIDO";
		} catch (InvalidStateException e) {
			teste = "CPF INV�LIDO : " + e;
			System.out.println(teste);
		}

		assertNotEquals("CPF V�LIDO", teste);
	}

	@Test
	public void deveValidarNITValido() {

		String nit = "12038688127";
		String teste;
		// CPFValidator cpfValidator = new CPFValidator();

		NITValidator nitValidator = new NITValidator();

		try {
			// cpfValidator.assertValid(cpf);
			validarDocumentos(nitValidator, nit);
			teste = "nit V�LIDO";
		} catch (InvalidStateException e) {
			teste = "nit INV�LIDO : " + e;
			System.out.println(teste);
		}

		assertEquals("nit V�LIDO", teste);

	}

	@Test
	public void deveFormatarCPF() {

		String cpf = "86288366757";
		String teste;
		// CPFValidator cpfValidator = new CPFValidator();

		CPFFormatter cpfFormatter = new CPFFormatter();

		try {
			teste = "formatacao: CPF V�LIDO";
			assertEquals("862.883.667-57", formatarDocumentos(cpfFormatter, cpf));

		} catch (InvalidStateException e) {
			teste = "formatacao: CPF INV�LIDO : " + e;

			assertNotEquals("862.883.667-57", formatarDocumentos(cpfFormatter, cpf));

		}

	}

	private static void validarDocumentos(Validator<String> validador, String documento) {
		validador.assertValid(documento);
	}

	private static String formatarDocumentos(Formatter formatador, String documento) {
		return formatador.format(documento);
	}

}
