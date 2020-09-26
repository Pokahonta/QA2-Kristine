package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class WeatherStepDefs {
    private String city;
    private String country;


    @Given("city is: {string}")
    public void set_city(String city){
        this.city = city;
    }

    @Given("country is: {string}")
    public void set_country(String country) {
        this.country = country.toLowerCase();//peredelovaem na malenkie bukvi
    }

    @When("we are requesting weather data")
    public void request_weather() {
    }

    @Then("lon is: {double}")
    public void check_lon(Double lon){
    }
    @Then("lat is: {double}")
    public void check_lat(Double lat){
    }

    @Then("weather id is: {int}")
    public void check_weather_id(int weather_id){
    }
    @Then("main is: {string}")
    public void main(String main){
    }
    @Then("description is: {string}")
    public void description (String description){
    }
    @Then("icon is: {string}")
    public void icon (String icon){
    }

    @Then("base is: {string}")
    public void base (String base){
    }

    @Then("temp is: {double}")
    public void check_temp (Double temp){
    }
    @Then("pressure is: {int}")
    public void check_pressure (int pressure){
    }
    @Then("humidity is: {int}")
    public void check_humidity (int humidity){
    }
    @Then("temp_min is: {double}")
    public void check_temp_min (Double temp_min){
    }
    @Then("temp_max is: {double}")
    public void check_temp_max (Double temp_max){
    }

    @Then("visibility is: {int}")
    public void check_visibility (int visibility){
    }

    @Then("speed is: {double}")
    public void check_speed (Double speed){
    }

    @Then("deg is: {int}")
    public void check_deg (int deg){
    }

    @Then("all is: {int}")
    public void clouds_all (int all){
    }

    @Then("dt is: {int}")
    public void check_dt (int dt){
    }

    @Then("type is: {int}")
    public void type (int type){
    }

    @Then("sys_id is: {int}")
    public void check_sys_id (int sys_id){
    }

    @Then("message is: {double}")
    public void check_message(Double message){
    }

    @Then("land is: {string}")
    public void land(String land){
    }

    @Then("sunrise is: {int}")
    public void check_sunrise(int sunrise){
    }

    @Then("sunset is: {int}")
    public void check_sunset(int sunset){
    }

    @Then("id is: {int}")
    public void check_id(int id){
    }

    @Then("name is: {string}")
    public void check_name(String name){
    }

    @Then("cod is: {int}")
    public void check_cod(int cod){
    }

}
