package pl.excellentapp.brewery.inventoryfailover.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {

    private UUID id;
    private int availableStock;
}
