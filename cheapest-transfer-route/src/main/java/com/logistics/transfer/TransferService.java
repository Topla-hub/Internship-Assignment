package com.logistics.transfer;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransferService {

    public TransferResult findCheapestRoute(int maxWeight, List<Transfer> availableTransfers) {
        int n = availableTransfers.size();


        int[][] dp = new int[n + 1][maxWeight + 1];

        for (int i = 1; i <= n; i++) {
            Transfer currentTransfer = availableTransfers.get(i - 1);
            for (int w = 0; w <= maxWeight; w++) {
                if (currentTransfer.getWeight() <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - currentTransfer.getWeight()] + currentTransfer.getCost());
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Backtrack to find the selected transfers
        List<Transfer> selectedTransfers = new ArrayList<>();
        int totalWeight = 0;
        int totalCost = dp[n][maxWeight];
        int w = maxWeight;

        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Transfer currentTransfer = availableTransfers.get(i - 1);
                selectedTransfers.add(currentTransfer);
                w -= currentTransfer.getWeight();
                totalWeight += currentTransfer.getWeight();
            }
        }

        System.out.println("Selected Transfers: " + selectedTransfers);
        System.out.println("Total Cost: " + totalCost);
        System.out.println("Total Weight: " + totalWeight);

        List<Transfer> finalSelectedTransfers = new ArrayList<>();
        for (int i = selectedTransfers.size() - 1; i >= 0; i--) {
            finalSelectedTransfers.add(selectedTransfers.get(i));
        }

        return new TransferResult(finalSelectedTransfers, totalCost, totalWeight);
    }
}
