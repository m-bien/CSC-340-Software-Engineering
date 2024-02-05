package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author madelyn
 */
@RestController
public class DemoController {
    
    /**
     * Get a random duck picture from Random-d.uk and make them available at
     * this endpoint.
     *
     * @return json array
     */
    @GetMapping("/duck")
    public Object getDuck() {
        try {
            String url = "https://random-d.uk/api/random";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonQuote = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonQuote);

            //Print the whole response to console.
            System.out.println(root);

            return root;

        } catch (JsonProcessingException ex) {
            Logger.getLogger(DemoApplication.class.getName()).log(Level.SEVERE, null, ex);
            return "error in /quote";
        }
    }

}
