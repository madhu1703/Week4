package name;
import java.util.*;
import java.util.stream.Collectors;
class InsurancePolicy {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;
    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
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
        return "Policy Number: " + policyNumber +
               ", Holder Name: " + holderName +
               ", Premium Amount: " + premiumAmount;
    }
}
public class FilterHighPremiumPolicies {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("POL12345", "John Doe", 1200.00),
            new InsurancePolicy("POL67890", "Jane Smith", 1500.75),
            new InsurancePolicy("POL54321", "Alice Johnson", 1000.25),
            new InsurancePolicy("POL98765", "Bob Brown", 1300.00)
        );
        List<InsurancePolicy> highPremiumPolicies = policies.stream()
            .filter(policy -> policy.getPremiumAmount() > 1200)
            .collect(Collectors.toList());
        System.out.println("Policies with Premium Amount > $1200:");
        highPremiumPolicies.forEach(System.out::println);
    }
}

