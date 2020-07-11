package xyz.muscaestar.muscabaristaclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import xyz.muscaestar.muscabaristaclient.web.model.CoffeeDto;
import xyz.muscaestar.muscabaristaclient.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

/**
 * Created by muscaestar on 7/11/20
 *
 * @author muscaestar
 */
@Component
@ConfigurationProperties(value = "musca.barista", ignoreUnknownFields = false)
public class BaristaClient {
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    public final String COFFEE_PATH_V1 = "/api/v1/coffee/";

    private String apihost;

    private final RestTemplate restTemplate;

    public BaristaClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CoffeeDto getCoffeeById(UUID id) {
        return restTemplate.getForObject(apihost + COFFEE_PATH_V1 + id.toString(), CoffeeDto.class);
    }

    public URI saveNewCoffee(CoffeeDto coffeeDto) {
        return restTemplate.postForLocation(apihost + COFFEE_PATH_V1, coffeeDto);
    }

    public void updateCoffee(UUID id, CoffeeDto coffeeDto) {
        restTemplate.put(apihost + COFFEE_PATH_V1 + id.toString(), coffeeDto);
    }

    public void deleteCoffeeById(UUID id) {
        restTemplate.delete(apihost + COFFEE_PATH_V1 + id.toString());
    }

    public CustomerDto getCustomerById(UUID id) {
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + id.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID id, CustomerDto customerDto) {
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + id.toString(), customerDto);
    }

    public void deleteCustomerById(UUID id) {
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + id.toString());
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
