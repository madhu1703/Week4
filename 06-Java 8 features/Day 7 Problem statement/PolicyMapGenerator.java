package name;
import java.util.*;
import java.util.stream.*;

class InsurancePolicyMapBased {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public InsurancePolicyMapBased(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }
}

public class PolicyMapGenerator {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("POL12345", "John Doe", 1200.00),
            new InsurancePolicy("POL67890", "Jane Smith", 1500.75),
            new InsurancePolicy("POL54321", "Alice Johnson", 1000.25),
            new InsurancePolicy("POL98765", "Robert Smith", 1300.00)
        );
        Map<String, Double> policyMap = policies.stream()
            .collect(Collectors.toMap(
                InsurancePolicy::getPolicyNumber,
                InsurancePolicy::getPremiumAmount
            ));
        System.out.println("Policy Number -> Premium Amount:");
        policyMap.forEach((number, premium) ->
            System.out.println(number + " -> $" + premium));
    }
}

