package name;
import java.util.*;
import java.util.stream.*;

class InsurancePolicyNew {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public InsurancePolicyNew(String policyNumber, String holderName, double premiumAmount) {
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

public class PolicyPremiumCheckApp {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("POL12345", "John Doe", 1200.00),
            new InsurancePolicy("POL67890", "Jane Smith", 1500.75),
            new InsurancePolicy("POL54321", "Alice Johnson", 1000.25),
            new InsurancePolicy("POL98765", "Bob Brown", 1300.00),
            new InsurancePolicy("POL13579", "Tom Harris", 2500.00)
        );
        boolean anyPolicyExceeds2000 = policies.stream()
                .anyMatch(policy -> policy.getPremiumAmount() > 2000);
        if (anyPolicyExceeds2000) {
            System.out.println("There is at least one policy with a premium amount greater than $2,000.");
        } else {
            System.out.println("No policies have a premium amount greater than $2,000.");
        }
    }
}
