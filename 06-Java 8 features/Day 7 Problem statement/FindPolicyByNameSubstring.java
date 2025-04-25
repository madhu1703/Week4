package name;
import java.util.*;
import java.util.stream.*;

class InsurancePolicyName {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public InsurancePolicyName(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderName() {
        return holderName;
    }

    @Override
    public String toString() {
        return String.format("Policy Number: %s, Holder Name: %s, Premium: $%.2f",
                policyNumber, holderName, premiumAmount);
    }
}

public class FindPolicyByNameSubstring {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("POL12345", "John Doe", 1200.00),
            new InsurancePolicy("POL67890", "Jane Smith", 1500.75),
            new InsurancePolicy("POL54321", "Alice Johnson", 1000.25),
            new InsurancePolicy("POL98765", "Robert Smith", 1300.00),
            new InsurancePolicy("POL24680", "Emma White", 950.00)
        );

        String searchSubstring = "Smith";
        List<InsurancePolicy> matchingPolicies = policies.stream()
            .filter(policy -> policy.getHolderName().contains(searchSubstring))
            .collect(Collectors.toList());
        System.out.println("Policies with holder name containing \"" + searchSubstring + "\":");
        matchingPolicies.forEach(System.out::println);
    }
}

