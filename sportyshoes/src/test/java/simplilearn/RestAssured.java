package simplilearn;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.apache.log4j.Logger;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssured {

	private static String baseURI;

	@BeforeAll
    public static void setUp() {
        
        RestAssured.baseURI = "http://localhost:8080";  
    }

    
    @Test
    public void testGetAllProducts() {
        given()
            .param("page", 0)   
            .param("size", 10)  
        .when()
            .get("/api/products")
        .then()
            .statusCode(200)  
            .contentType(ContentType.JSON)  
            .body("size()", greaterThan(0))  
            .body("[0].id", notNullValue())  
            .body("[0].name", notNullValue())  
            .body("[0].price", greaterThan(0.0));  
    }

    // Test to get all users
    @Test
    public void testGetAllUsers() {
        given()
            .param("page", 0)   
            .param("size", 10)  
        .when()
            .get("/api/users")
        .then()
            .statusCode(200)  // Verify that the status code is 200 OK
            .contentType(ContentType.JSON)  // Verify that the content type is JSON
            .body("size()", greaterThan(0))  // Assert that at least one user is returned
            .body("[0].id", notNullValue())  // Assert that the first user has a valid 'id'
            .body("[0].username", notNullValue())  // Assert that the first user has a valid 'username'
            .body("[0].email", notNullValue());  // Assert that the first user has a valid 'email'
    }
}