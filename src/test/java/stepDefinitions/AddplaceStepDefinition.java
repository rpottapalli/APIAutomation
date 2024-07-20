package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.runner.RunWith;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

@RunWith(Cucumber.class)
public class AddplaceStepDefinition extends Utils{
	
	ResponseSpecification repSpec;
	RequestSpecification res;
	Response response;
    TestDataBuild data = new TestDataBuild();
    public static String place_id;
	JsonPath js;
	
    @Given("Add place payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {
    	
    res = given().relaxedHTTPSValidation().spec(requestSpecification()).body(data.addPlacePayload(name,language,address));
    
	}

    @When("User calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) { 
    	
    
    	repSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    	
    	APIResources resouceApi = APIResources.valueOf(resource);
    	System.out.println(resouceApi.getResource());
    	
    	if(method.equalsIgnoreCase("POST")) {
    		
		response = res.when().post(resouceApi.getResource());
		
    	}
    	
    	if(method.equalsIgnoreCase("GET")) {
    		
    	response = res.when().get(resouceApi.getResource());
    	
        }
    	
		//.then().log().all().spec(repSpec).extract().response();

	}

    	
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		
		// Write code here that turns the phrase above into concrete actions
		 assertEquals(response.getStatusCode(), 200);
	}
	

	@Then("status in response body is OK")
	public void status_in_response_body_is_ok() {
		
		// Write code here that turns the phrase above into concrete actions
		String resp = response.asString();
		js = new JsonPath(resp);
		String status = js.get("status");
		assertEquals(status, "OK");
	}
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname, String resource) throws IOException {
		
	     place_id = getJsonpath(response,"place_id");
	     res = given().relaxedHTTPSValidation().spec(requestSpecification()).queryParam("place_id",place_id);
	     user_calls_with_http_request(resource,"GET");
	     String actualname = getJsonpath(response,"name");
	     assertEquals(expectedname,actualname);
	}
	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
		
		res = given().relaxedHTTPSValidation().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}

}
