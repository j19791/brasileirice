package br.com.alura;

import java.io.IOException;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;

public class CEP {

	public static void main(String[] args) {

		ViaCEPClient cliente = new ViaCEPClient();

		try {
			System.out.println(cliente.getEndereco("82010340").getLogradouro());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
