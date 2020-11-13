package com.hrms.API.steps.practice;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class HardcodedExamples {
	/*
	 * REST assured - Java library specifically developed to automate REST endpoints
	 * 
	 * Given - Preparing your request (cucumber - gherkin language, precondition)
	 * When - What action will you perform, what type of call are you making? Then -
	 * Verification
	 */

	@Test
	public void samleTest() {

		/** BaseURI for all endpoints */
		RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

		/**JWT*/
		String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MDM1NTk5NzUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYwMzYwMzE3NSwidXNlcklkIjoiMTI5NSJ9.C6APyjo3pWnKarZgdQFjnfI_dCpqHOkw3cIVyzu03mg";

		/** Preparing request for /getOneEmployee.php*/
		/** Using .log().all() to print out everything being sent with the request*/
		RequestSpecification preparingGetOneEmployeeRequest = given().header("Authorization", token).header("Content-Type", "application/json").queryParam("employee_id",
				"3695").log().all();

		/** Making call to /getOneEmployee.php*/
		Response getOneEmployeeResponce = preparingGetOneEmployeeRequest.when().get("/getOneEmployee.php");

		/** One way to print response object*/
		//System.out.println(getOneEmployeeResponce.asString());
		
		/** Second way using rest assured prettyPrint() */
		getOneEmployeeResponce.prettyPrint();
		
		/** Using assertThat() to verify status code */
		getOneEmployeeResponce.then().assertThat().statusCode(200);
		
	}
}
