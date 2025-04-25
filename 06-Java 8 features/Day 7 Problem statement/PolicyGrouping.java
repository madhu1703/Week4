package name;
import java.util.*;
import java.util.stream.Collectors;

class InsurancePlcy {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public InsurancePlcy(String policyNumber, String holderName, double premiumAmount) {
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

public class PolicyGrouping {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("POL12345", "John Doe", 1200.00),
            new InsurancePolicy("POL67890", "Jane Smith", 1500.75),
            new InsurancePolicy("POL54321", "Alice Johnson", 1000.25),
            new InsurancePolicy("POL98765", "Bob Brown", 1300.00),
            new InsurancePolicy("POL13579", "Tom Harris", 2500.00)
        );
        Map<Character, List<InsurancePolicy>> groupedByInitial = policies.stream()
                .collect(Collectors.groupingBy(policy -> policy.getHolderName().charAt(0)));
        System.out.println("Policies Grouped by Holder's Name Initial:");
        groupedByInitial.forEach((initial, group) -> {
            System.out.println("Initial: " + initial);
            group.forEach(System.out::println);
        });
    }
}

