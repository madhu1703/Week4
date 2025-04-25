package name;
import java.util.*;
class InsurancePolicyDetails {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;
    public InsurancePolicyDetails(String policyNumber, String holderName, double premiumAmount) {
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
public class PremiumCalculatorApp {
    public static void main(String[] args) {
        List<InsurancePolicyDetails> policies = Arrays.asList(
            new InsurancePolicyDetails("POL12345", "John Doe", 1200.00),
            new InsurancePolicyDetails("POL67890", "Jane Smith", 1500.75),
            new InsurancePolicyDetails("POL54321", "Alice Johnson", 1000.25),
            new InsurancePolicyDetails("POL98765", "Bob Brown", 1300.00)
        );
        double totalPremium = policies.stream()
                                      .mapToDouble(InsurancePolicyDetails::getPremiumAmount)
                                      .sum();
        System.out.println("Total Premium Amount: $" + totalPremium);
    }
}

