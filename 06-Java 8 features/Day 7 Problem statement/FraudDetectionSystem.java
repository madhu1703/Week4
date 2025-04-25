package name;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Transaction {
    private String transactionId;
    private String policyNumber;
    private double amount;
    private Date transactionDate;
    private boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, Date transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public String getTransactionId() { return transactionId; }
    public String getPolicyNumber() { return policyNumber; }
    public double getAmount() { return amount; }
    public Date getTransactionDate() { return transactionDate; }
    public boolean isFraudulent() { return isFraudulent; }
}

class FraudStats {
    private long count;
    private double totalAmount;

    public FraudStats(long count, double totalAmount) {
        this.count = count;
        this.totalAmount = totalAmount;
    }

    public long getCount() { return count; }
    public double getTotalAmount() { return totalAmount; }

    @Override
    public String toString() {
        return "Count: " + count + ", Total Amount: $" + String.format("%.2f", totalAmount);
    }
}

public class FraudDetectionSystem {

    public static void detectFraud(List<Transaction> transactions) {
       
        List<Transaction> filtered = transactions.stream()
            .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
            .collect(toList());
        Map<String, FraudStats> fraudStatsMap = filtered.stream()
            .collect(groupingBy(Transaction::getPolicyNumber,
                collectingAndThen(toList(),
                    list -> new FraudStats(
                        list.size(),
                        list.stream().mapToDouble(Transaction::getAmount).sum()
                    )
                )
            ));
        System.out.println("=== Fraud Alerts ===");
        fraudStatsMap.forEach((policyNumber, stats) -> {
            if (stats.getCount() > 5 || stats.getTotalAmount() > 50000) {
                System.out.println("Policy: " + policyNumber + " | " + stats + " -> ALERT!");
            }
        });
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T1", "P1001", 12000, new Date(), true),
            new Transaction("T2", "P1001", 15000, new Date(), true),
            new Transaction("T3", "P1001", 17000, new Date(), true),
            new Transaction("T4", "P1001", 16000, new Date(), true),
            new Transaction("T5", "P1001", 14000, new Date(), true),
            new Transaction("T6", "P1001", 18000, new Date(), true),  
            new Transaction("T7", "P2001", 20000, new Date(), true),  

            new Transaction("T8", "P3001", 11000, new Date(), true),
            new Transaction("T9", "P3001", 12000, new Date(), true),
            new Transaction("T10", "P3001", 10000, new Date(), false),  
            new Transaction("T11", "P3001", 10500, new Date(), true),
            new Transaction("T12", "P3001", 10900, new Date(), true)    
        );

        detectFraud(transactions);
    }
}

