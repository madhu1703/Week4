import java.util.*;
import java.text.*;
class Policy {
    private String policyNumber;
    private String policyholderName;
    private String expiryDate;
    private String coverageType;
    private double premiumAmount;
    public Policy(String policyNumber, String policyholderName, String expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public String getPolicyholderName() {
        return policyholderName;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public String getCoverageType() {
        return coverageType;
    }
    public double getPremiumAmount() {
        return premiumAmount;
    }
    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Name: " + policyholderName + ", Expiry Date: " + expiryDate +
                ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
}
class InsurancePolicyManager {
    private Set<Policy> policyHashSet = new HashSet<>();
    private Set<Policy> policyLinkedHashSet = new LinkedHashSet<>();
    private Set<Policy> policyTreeSet = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));
    public void addPolicyToHashSet(Policy policy) {
        policyHashSet.add(policy);
    }
    public void addPolicyToLinkedHashSet(Policy policy) {
        policyLinkedHashSet.add(policy);
    }
    public void addPolicyToTreeSet(Policy policy) {
        policyTreeSet.add(policy);
    }
    public void displayPolicies() {
        System.out.println("Policies in HashSet (Quick Lookup):");
        for (Policy policy : policyHashSet) {
            System.out.println(policy);
        }

        System.out.println("\nPolicies in LinkedHashSet (Insertion Order):");
        for (Policy policy : policyLinkedHashSet) {
            System.out.println(policy);
        }

        System.out.println("\nPolicies in TreeSet (Sorted by Expiry Date):");
        for (Policy policy : policyTreeSet) {
            System.out.println(policy);
        }
    }
}
public class InsurancePolicyManagementSystem {
    public static void main(String[] args) throws ParseException {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        Policy policy1 = new Policy("P001", "John Doe", "2025-05-01", "Health", 5000);
        Policy policy2 = new Policy("P002", "Jane Smith", "2023-12-15", "Auto", 1500);
        Policy policy3 = new Policy("P003", "Alice Johnson", "2024-07-01", "Home", 2500);
        Policy policy4 = new Policy("P004", "Bob Brown", "2026-03-10", "Health", 4500);
        manager.addPolicyToHashSet(policy1);
        manager.addPolicyToLinkedHashSet(policy2);
        manager.addPolicyToTreeSet(policy3);
        manager.addPolicyToHashSet(policy4);
        manager.displayPolicies();
    }
}

