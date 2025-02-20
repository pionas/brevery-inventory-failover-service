package pl.excellentapp.brewery.inventoryfailover;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.reactive.server.WebTestClient;
import pl.excellentapp.brewery.inventoryfailover.configuration.RouterConfiguration;
import pl.excellentapp.brewery.inventoryfailover.web.InventoryHandler;
import pl.excellentapp.brewery.inventoryfailover.web.InventoryResponse;

import java.util.UUID;

@SpringBootTest
@Profile("it")
class InventoryFailoverApplicationTests {

    @Autowired
    private RouterConfiguration routerConfiguration;

    @Autowired
    private InventoryHandler inventoryHandler;


    @Test
    void shouldReturnDefaultBeerInventory() {
        // given
        final var client = WebTestClient.bindToRouterFunction(routerConfiguration.inventoryRoute(inventoryHandler))
                .build();

        // when
        final var responseSpec = client.get()
                .uri("/inventory-failover")
                .exchange();

        // then
        responseSpec.expectStatus()
                .isOk()
                .expectBody(InventoryResponse.class)
                .isEqualTo(new InventoryResponse(
                        UUID.fromString("00000000-0000-0000-0000-000000000000"),
                        999
                ));
    }

}
