package com.logistics.transfer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class TransferServiceTest {

    private TransferService transferService;

    @BeforeEach
    void setUp() {
        transferService = new TransferService();
    }

    @Test
    void testFindCheapestRoute_validScenario() {
        int maxWeight = 15;
        List<Transfer> availableTransfers = List.of(
                new Transfer(5, 10),
                new Transfer(10, 20),
                new Transfer(3, 5),
                new Transfer(8, 15)
        );

        TransferResult result = transferService.findCheapestRoute(maxWeight, availableTransfers);

        assertEquals(2, result.getSelectedTransfers().size());
        assertEquals(30, result.getTotalCost());
        assertEquals(15, result.getTotalWeight());
    }

    @Test
    void testFindCheapestRoute_noTransfersWithinWeightLimit() {
        int maxWeight = 2;
        List<Transfer> availableTransfers = List.of(
                new Transfer(5, 10),
                new Transfer(10, 20),
                new Transfer(3, 5),
                new Transfer(8, 15)
        );

        TransferResult result = transferService.findCheapestRoute(maxWeight, availableTransfers);

        assertEquals(0, result.getSelectedTransfers().size());
        assertEquals(0, result.getTotalCost());
        assertEquals(0, result.getTotalWeight());
    }

    @Test
    void testFindCheapestRoute_emptyTransfers() {
        int maxWeight = 15;
        List<Transfer> availableTransfers = List.of();

        TransferResult result = transferService.findCheapestRoute(maxWeight, availableTransfers);

        assertEquals(0, result.getSelectedTransfers().size());
        assertEquals(0, result.getTotalCost());
        assertEquals(0, result.getTotalWeight());
    }
}
