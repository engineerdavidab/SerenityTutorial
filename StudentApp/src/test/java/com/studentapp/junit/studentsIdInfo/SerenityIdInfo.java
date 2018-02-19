package com.studentapp.junit.studentsIdInfo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;


@RunWith(SerenityRunner.class)
public class SerenityIdInfo {

//	@BeforeClass
//	public static void init()
//		{
//			RestAssured.baseURI="http://localhost:8080/student"; 
//		}
//	
//
//	
//	
//	
//	@Test
//	public void getAllStudents()
//	{
//		//RestAssured.given()
//		SerenityRest.given()
//		.when()
//		.get("/list")
//		.then()
//		.log()
//		.all()
//		.statusCode(200);
//	}
//	
//	
//	@Test
//	public void thisIsFailing()
//	{
//		SerenityRest.given()
//		.when()
//		.get("/list")
//		.then()
//		.log()
//		.all()
//		.statusCode(500);
//		
//		
//	}
//	
//	@Pending
//	@Test
//	public void thisIsAPendingTest()
//	{
//		
//	}
//	
//	@Ignore
//	@Test
//	public void thisIsASkippedTest()
//	{
//		
//	}
//	
//	
//	@Test
//	public void thisIsAtestWithError()
//	{
//		System.out.println("This a error"+(5/0));
//	}
//
//
//	@Test
//	public void fileDoesNotExists() throws IOException
//	{
//		File file= new File("JunkSSdq://junk.txt");
//		FileReader fr=new FileReader(file);
//		fr.close();
//	
//	}
//	
//	@Manual
//	@Test
//	public void thisIsManualTest()
//	{
//	
//	}

	
	
}
