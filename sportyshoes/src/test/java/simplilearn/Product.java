package simplilearn;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.apache.log4j.Logger;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class Product {

	
	public Product(long l, String string, double d, String string2) {
		// TODO Auto-generated constructor stub
	}

	@RestController
	@RequestMapping("http://localhost:8080")
	public class ProductController {

	    @RequestMapping(value = "http://localhost:8080")
	    public List<Product> getAllProducts() {
	        // Return a sample list of products
	        return List.of(
	            new Product(1L, "Product1", 10.99, "Description of Product 1"),
	            new Product(2L, "Product2", 20.99, "Description of Product 2")
	        );
	    }
	}
}
