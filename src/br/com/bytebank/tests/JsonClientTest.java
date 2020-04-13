package br.com.bytebank.tests;

import org.json.JSONObject;

import br.com.bytebank.classes.Client;

public class JsonClientTest {

	public static void main(String[] args) {

		Client c1 = new Client("Maria", "14445475874", "Fotografa");
		JSONObject c1Json = c1.getClientJson();
		System.out.println(c1Json.toString());
		
		Client c2 = new Client("Maria", "14445475874", "Professora");
		System.out.println(c2);
	}

}
