package pl.excellentapp.brewery.inventoryfailover.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.excellentapp.brewery.inventoryfailover.web.InventoryHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration(proxyBeanMethods = false)
public class RouterConfiguration {

    @Bean
    public RouterFunction<ServerResponse> inventoryRoute(InventoryHandler inventoryHandler) {
        return route()
                .GET("/inventory-failover", accept(MediaType.APPLICATION_JSON), inventoryHandler::beerInventory)
                .build();
    }
}