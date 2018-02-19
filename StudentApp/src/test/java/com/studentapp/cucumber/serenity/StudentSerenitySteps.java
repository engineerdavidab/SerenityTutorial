package com.studentapp.cucumber.serenity;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;

import com.serenityrestassured.model.StudentClass;
import com.studentapp.testbase.ReuseableSpecifications;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StudentSerenitySteps {

@Step("Creating student with firstName : {0}, lastName : {1}, email : {2}, programname : {3}, courses : {4}")
public ValidatableResponse createStudent(String firstName, String lastName, String email, String programname, List<String> courses) 
{
	StudentClass student = new StudentClass();
	student.setFirstName(firstName);
	student.setLastName(lastName);
	student.setEmail(email);
	student.setProgramme(programname);
	student.setCourses(courses);
	
	
	
	
	
return	SerenityRest.rest().given()
		//.contentType(ContentType.JSON)
		.spec(ReuseableSpecifications.getGenericRequestSpec())
		.log()
		.all()
		.when()
		.body(student)
		.post()
		.then();	
	


}	


@Step("Getting the student information with firstName : {0}")
public HashMap<String,Object> getStudentInfoByFirstName(String firstName)
{
	String p1 = "findAll{it.firstName='";
	String p2 = "'}.get(0)";
		
	
	
return SerenityRest.rest().given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200)
		.extract()
		.path(p1+firstName+p2);

	
	
}

@Step("Updating student informatiom with studentID : {0}, firstName : {1}, lastName: {2}, email : {3}, programname : {4}, courses : {5}")
public ValidatableResponse updateStudent(int studentId,String firstName, String lastName, String email, String programname, List<String> courses) 
{
StudentClass student = new StudentClass();
student.setFirstName(firstName);
student.setLastName(lastName);
student.setEmail(email);
student.setProgramme(programname);
student.setCourses(courses);


return SerenityRest.rest().
given()
//.contentType(ContentType.JSON)
.spec(ReuseableSpecifications.getGenericRequestSpec())
.log()
.all()
.when()
.body(student)
.put("/"+studentId)
.then();



}

@Step("Deleting student informatiom with studentID : {0}")
public void deleteStudent(int studentId)
{
SerenityRest.rest().given().when().delete("/"+studentId);
}

@Step("Getting information of the student with ID : {0}")
public ValidatableResponse getStudentId(int studentId)
{
	return SerenityRest.
			rest()
			.given()
			.when()
			.get("/" + studentId).then();

}


}
