package com.logistics.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    private final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    // Endpoint to find the cheapest transfer route
    @PostMapping("/cheapest-route")
    public TransferResult getCheapestRoute(@RequestBody TransferRequest request) {
        return transferService.findCheapestRoute(request.getMaxWeight(), request.getAvailableTransfers());
    }
}
