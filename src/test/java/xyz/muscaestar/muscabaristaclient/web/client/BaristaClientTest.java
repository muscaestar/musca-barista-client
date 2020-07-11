package xyz.muscaestar.muscabaristaclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.muscaestar.muscabaristaclient.web.model.CoffeeDto;
import xyz.muscaestar.muscabaristaclient.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by muscaestar on 7/11/20
 *
 * @author muscaestar
 */
@SpringBootTest
class BaristaClientTest {

    @Autowired
    BaristaClient baristaClient;

    @Test
    void getCoffeeById() {
        CoffeeDto dto = baristaClient.getCoffeeById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void saveNewCoffee() {
        CoffeeDto dto = CoffeeDto.builder().cfeName("New Coffee").build();
        URI uri = baristaClient.saveNewCoffee(dto);

        assertNotNull(uri);
        System.out.println(uri);

    }

    @Test
    void updateCoffee() {
        CoffeeDto dto = CoffeeDto.builder().cfeName("New Coffee").build();
        baristaClient.updateCoffee(UUID.randomUUID(), dto);
    }

    @Test
    void setApihost() {
    }

    @Test
    void deleteCoffeeById() {
        baristaClient.deleteCoffeeById(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto dto = baristaClient.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto dto = baristaClient.getCustomerById(UUID.randomUUID());
        URI uri = baristaClient.saveNewCustomer(dto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto dto = baristaClient.getCustomerById(UUID.randomUUID());
        baristaClient.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteCustomerById() {
        baristaClient.deleteCustomerById(UUID.randomUUID());
    }
}