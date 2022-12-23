package UIElements.Game;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

@ScenarioScope

public class ShowSingleActorStepDef {
    @Autowired
    ActorRepository actorRepository;

    int actor_id;
    Actor chosenActor;
    @Given("Actor exists with ID {int}")

    public void Actor_exists_with_ID(int id) {
        actor_id = id;
        actorRepository.findById(id)
        .orElseThrow(() -> new ResourceAccessException(("Actor id does not exist"+ actor_id)));
    }

    @When("I request that actors details")
        public void i_request_that_actors_details() {
        chosenActor = (actorRepository.findById(actor_id)
                .orElseThrow(() -> new ResourceAccessException("Actor id does not exist" + actor_id )));
        Assertions.assertNotEquals(null,chosenActor,"actor was not found");
    }
    @Then("the webpage should show the actors {string} and {string}")

    public void the_webpage_should_show_the_actors_firstname_and_lastname(String firstname, String lastname) {
     String correctDetails = firstname + " "  + lastname;
     String testDetails = chosenActor.getFirstname() + " " + chosenActor.getLastname();
     Assertions.assertEquals(correctDetails, testDetails, "Actor details do not match");
    }

}
