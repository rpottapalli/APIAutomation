package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {

		AddplaceStepDefinition def = new AddplaceStepDefinition();
		if (AddplaceStepDefinition.place_id == null) {
			def.add_place_payload_with("ram", "Telugu", "Andhra");
			def.user_calls_with_http_request("AddPlaceAPI", "POST");
			def.verify_place_id_created_maps_to_using("ram", "GetPlaceAPI");
		}
	}

}
