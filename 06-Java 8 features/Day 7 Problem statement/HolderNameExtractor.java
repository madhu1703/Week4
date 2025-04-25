package name;
import java.util.*;
import java.util.stream.*;

class InsurancePlcyNew {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public InsurancePlcyNew(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderName() {
        return holderName;
    }
}

public class HolderNameExtractor {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("POL12345", "John Doe", 1200.00),
            new InsurancePolicy("POL67890", "Jane Smith", 1500.75),
            new InsurancePolicy("POL54321", "Alice Johnson", 1000.25),
            new InsurancePolicy("POL98765", "John Doe", 1300.00),
            new InsurancePolicy("POL13579", "Emma White", 2500.00)
        );
        Set<String> uniqueNames = policies.stream()
            .map(InsurancePolicy::getHolderName)
            .collect(Collectors.toSet());
        System.out.println("Unique Policy Holder Names:");
        uniqueNames.forEach(System.out::println);
    }
}
