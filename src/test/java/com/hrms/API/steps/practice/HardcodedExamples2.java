package com.hrms.API.steps.practice;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class HardcodedExamples2 {
	/*
	 * REST assured - Java library specifically developed to automate REST endpoints
	 * 
	 * Given - Preparing your request (cucumber - gherkin language, precondition)
	 * When - What action will you perform, what type of call are you making? Then -
	 * Verification
	 */

	String baseURI = RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MDM1NTk5NzUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYwMzYwMzE3NSwidXNlcklkIjoiMTI5NSJ9.C6APyjo3pWnKarZgdQFjnfI_dCpqHOkw3cIVyzu03mg";
	static String employeeID;

	// @Test
	public void aPOSTcreateEmployee() {

		/** Prepering request for creating an employee */
		RequestSpecification createEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application/json")
				.body("{\n" + "\"emp_firstname\": \"syntaxFirstName\",\n" + "  \"emp_lastname\": \"syntaxLastName\", \n"
						+ "  \"emp_middle_name\": \"syntaxMiddleName\", \n" + "  \"emp_gender\": \"F\", \n"
						+ "  \"emp_birthday\": \"2000-12-12\", \n" + "  \"emp_status\": \"Worker\", \n"
						+ "  \"emp_job_title\": \"Cloud Consultant\"}");

		/** making call to /createEmployee.php */
		Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");

		/** Printing response */
		createEmployeeResponse.prettyPrint();

		/**
		 * Using jsonPath() to view the response body which lets us get the employee ID
		 * We are storing the employeeID as a static global variable to be able to use
		 * with other calls
		 */
		employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");

		/** Optional: Printing employeeID */
		System.out.println(employeeID);

		/** Verifying status code is 201 */
		createEmployeeResponse.then().assertThat().statusCode(201);

		/**
		 * Verifying responce body "Message" is paired with "Entry Created"; equalTo()
		 * method comes from static Hamcrest package - NEED TO IMPORT MANUALLY import
		 * static org.harmcrest.Matchers.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));

		/** Verifying created employee first name */
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("syntaxFirstName"));

		/** Verifying server Apache/2.4.39 (Win64) PHP/7.2.18 */
		createEmployeeResponse.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

	}



	@Test
	public void bGetcreatedEmployee() {
		
		/** Preparing request to get created employee */
		RequestSpecification getCreatedEmployeeRequest = given().header("Authorization", token)
				.header("Content-Type", "application/json").queryParam("employee_id", employeeID);
		
		/** Storing response for retrieving created employee*/
		Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");
		
		/** Printing response*/
		getCreatedEmployeeResponse.prettyPrint();
		
		/** Storing response employee ID into empID to compare with static global employee ID */
		String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
		
		/** Comparing empID with stored employeeID from created employee call*/
		boolean verifyingEmployeeID = empID.equalsIgnoreCase(employeeID);
		
		/** Asserting to verify the above condition is true*/
		Assert.assertTrue(verifyingEmployeeID);
		
		/** Verifying status code is 200 */
		getCreatedEmployeeResponse.then().assertThat().statusCode(200);
		
		
		
		

	}
}