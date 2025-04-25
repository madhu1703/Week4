package name;
import java.util.*;

class InsPly {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public InsPly(String policyNumber, String holderName, double premiumAmount) {
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

public class PolicyFilterApp {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("POL12345", "John Doe", 1200.00),
            new InsurancePolicy("POL67890", "Jane Smith", 1500.75),
            new InsurancePolicy("POL54321", "Alice Johnson", 1000.25),
            new InsurancePolicy("POL98765", "Bob Brown", 1300.00),
            new InsurancePolicy("POL13579", "Tom Harris", 2500.00)
        );
        List<InsurancePolicy> filteredPolicies = policies.stream()
                .filter(policy -> policy.getPremiumAmount() >= 1000 && policy.getPremiumAmount() <= 2000)
                .toList();
        System.out.println("Filtered Policies (Premium between $1,000 and $2,000):");
        filteredPolicies.forEach(System.out::println);
    }
}

