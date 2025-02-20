package pl.excellentapp.brewery.inventoryfailover.web;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class InventoryHandler {

    public Mono<ServerResponse> beerInventory(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(Mono.just(prepareInventoryResponse()), InventoryResponse.class);
    }

    private InventoryResponse prepareInventoryResponse() {
        return new InventoryResponse(
                UUID.fromString("00000000-0000-0000-0000-000000000000"),
                999
        );
    }


}
