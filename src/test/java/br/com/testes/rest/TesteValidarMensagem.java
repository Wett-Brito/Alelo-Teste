package br.com.testes.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class TesteValidarMensagem {

	
	@BeforeClass
	public static void beforeClass() 
	{
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

	}
	
	
	@Test
	public void TesteRestJsonPlaceHolder() 
	{		
		given()
			.log().all()
		.when()
			.get("/todos/1")
		.then()
			.log().all()
			.statusCode(200)
			.body("userId", is(1))
			.body("id", is(1))
			.body("title", is("delectus aut autem"))
			.body("completed", is(false))
		;
		
	}
}
