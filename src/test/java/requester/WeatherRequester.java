package requester;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Response;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
    //peremennaja na urovne class
    private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?q="; //PREFIX = pervaja chastj
    private final String POSTFIX = "&appid=439d4b804bc8187953eb36d2a8c26a02";  //POSTFIX = tretja chastj

    public Response requestWeather(String city, String country) throws JsonProcessingException {  //etu funkciju mozno budet vizvatj, tolko esli peredadim gorod i stranu
        String url = PREFIX + city + "," + country + POSTFIX;

        RestTemplate restTemplate = new RestTemplate();
        String responseToParse = restTemplate.getForEntity(url, String.class).getBody(); //kuda -url, chto vozvrawaet - Responce, vozmet tolko nuznoe - getBody i pitaemsja natjanutj na Responce

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseToParse, Response.class);  //iz resp.toParse peredelivaem v responce.class



    }

}
