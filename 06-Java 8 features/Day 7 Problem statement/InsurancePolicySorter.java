package name;
import java.util.*;
class PolicyRecord {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;
    public PolicyRecord(String policyNumber, String holderName, double premiumAmount) {
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
public class InsurancePolicySorter {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
            new InsurancePolicy("POL12345", "John Doe", 1200.00),
            new InsurancePolicy("POL67890", "Jane Smith", 1500.75),
            new InsurancePolicy("POL54321", "Alice Johnson", 1000.25),
            new InsurancePolicy("POL98765", "Bob Brown", 1300.00)
        );
        policies.sort((p1, p2) -> p1.getHolderName().compareToIgnoreCase(p2.getHolderName()));
        System.out.println("Policies sorted by Holder Name (Alphabetical):");
        policies.forEach(System.out::println);
    }
}
