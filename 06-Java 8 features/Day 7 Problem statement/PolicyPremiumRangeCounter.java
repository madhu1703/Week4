package name;
import java.util.*;
import java.util.stream.*;

class InsPolicyNew {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public InsPolicyNew(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return String.format("Policy: %s | Holder: %s | Premium: $%.2f",
                             policyNumber, holderName, premiumAmount);
    }
}

public class PolicyPremiumRangeCounter {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("POL12345", "John Doe", 1200.00),
            new InsurancePolicy("POL67890", "Jane Smith", 1500.75),
            new InsurancePolicy("POL54321", "Alice Johnson", 1000.25),
            new InsurancePolicy("POL98765", "Bob Brown", 1300.00),
            new InsurancePolicy("POL13579", "Tom Harris", 2500.00),
            new InsurancePolicy("POL24680", "Emma White", 900.00)
        );
        Map<String, Long> premiumRangeCount = policies.stream()
            .collect(Collectors.groupingBy(policy -> {
                double premium = policy.getPremiumAmount();
                if (premium <= 1000) return "$0 - $1000";
                else if (premium <= 2000) return "$1001 - $2000";
                else return ">$2000";
            }, Collectors.counting()));
        premiumRangeCount.forEach((range, count) ->
            System.out.println("Range " + range + ": " + count + " policies"));
    }
}
