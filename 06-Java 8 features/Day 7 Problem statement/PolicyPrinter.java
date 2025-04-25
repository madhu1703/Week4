package name;
import java.util.*;

class InsuranceDetails {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public InsuranceDetails(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return String.format("Policy Number: %-10s | Holder: %-15s | Premium: $%.2f",
                             policyNumber, holderName, premiumAmount);
    }
}

public class PolicyPrinter {
    public static void main(String[] args) {
        List<InsuranceDetails> policies = Arrays.asList(
            new InsuranceDetails("POL12345", "John Doe", 1200.00),
            new InsuranceDetails("POL67890", "Jane Smith", 1500.75),
            new InsuranceDetails("POL54321", "Alice Johnson", 1000.25),
            new InsuranceDetails("POL98765", "Bob Brown", 1300.00)
        );
        System.out.println("Formatted Policy Details:");
        policies.forEach(policy -> System.out.println(policy));
    }
}

