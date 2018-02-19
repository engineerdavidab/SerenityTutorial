package com.studentapp.junit.studentsinfo;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.Assert;

import com.serenityrestassured.model.StudentClass;
import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.testbase.ReuseableSpecifications;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import org.hamcrest.Matcher.*;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentsCRUDTest extends TestBase {

	static String firstName = "SMOKEUSER"+TestUtils.getRandomValue();
	static String lastName = "SMOKEUSER"+TestUtils.getRandomValue();
	static String programname = "ComputerScience";
	static String email = TestUtils.getRandomValue()+"xyz@gmail.com";
	static int studentId;
	
	@Steps
	StudentSerenitySteps steps;
	
	
	@Title("This test will create a new student")
	@Test
	public void test001()
	{	
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		steps.createStudent(firstName, lastName, email, programname, courses)
		.statusCode(201).spec(ReuseableSpecifications.getGenericResponseSpec());
		
				
		
//		StudentClass student = new StudentClass();
//		student.setFirstName(firstName);
//		student.setLastName(lastName);
//		student.setEmail(email);
//		student.setProgramme(programname);
//		student.setCourses(courses);
//		
//		
//		
//		
//		
//		SerenityRest.rest().given()
//		.contentType(ContentType.JSON)
//		.log()
//		.all()
//		.when()
//		.body(student)
//		.post()
//		.then()
//		.log()
//		.all()
//		.statusCode(201);
		
		
		
	}
	
	@Title("Verify if student was added to the application")
	@Test
	public void test002()
	{
		String p1 = "findAll{it.firstName='";
		String p2 = "'}.get(0)";
			
		
		
		HashMap<String,Object> value = steps.getStudentInfoByFirstName(firstName);				
				
				
//		=SerenityRest.rest().given()
//		.when()
//		.get("/list")
//		.then()
//		.log()
//		.all()
//		.statusCode(200)
//		.extract()
//		.path(p1+firstName+p2);
//	
	System.out.println("The value is"+value);
	//HashMap<String,Object> Expectvalue=Matchers.hasValue(firstName);
	
	Assert.assertThat(value,Matchers.hasValue(firstName));
	studentId=(int) value.get("id");

	}
	
	@Title("Update the user information and verify that updated information!")
	@Test
	public void test003()
	{
		
		String p1 = "findAll{it.firstName='";
		String p2 = "'}.get(0)";
		
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		firstName=firstName+"_Updated";
		
//		StudentClass student = new StudentClass();
//		student.setFirstName(firstName);
//		student.setLastName(lastName);
//		student.setEmail(email);
//		student.setProgramme(programname);
//		student.setCourses(courses);
//		
//		
//		SerenityRest.rest().
//		given()
//		.contentType(ContentType.JSON)
//		.log()
//		.all()
//		.when()
//		.body(student)
//		.put("/"+studentId)
//		.then()
//		.log()
//		.all();
		
		steps.updateStudent(studentId, firstName, lastName, email, programname, courses);
		
		HashMap<String,Object> value=steps.getStudentInfoByFirstName(firstName);
//				=SerenityRest.rest()
//				.given()
//				.when()
//				.get("/list")
//				.then()
//				.log()
//				.all()
//				.statusCode(200)
//				.extract()
//				.path(p1+firstName+p2);
			
			System.out.println("The value is"+value);
			//HashMap<String,Object> Expectvalue=Matchers.hasValue(firstName);
			Assert.assertThat(value,Matchers.hasValue(firstName));
			
		
	}
	
	
	@Title("Detete the student and verify if the student is deleted")
	@Test
	public void test004(){
		
//		SerenityRest
//		.rest()
//		.given()
//		.when()
//		.delete("/"+studentId);
		
		steps.deleteStudent(studentId);
		
		
//		SerenityRest
//		.rest()
//		.given()
//		.when()
//		.get("/"+studentId)
//		.then()
//		.log()
//		.all()
//		.statusCode(404);
	
		steps.getStudentId(studentId).statusCode(404);
		
	}
	
	
	
	
}
