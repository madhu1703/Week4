import java.util.*;
import java.text.*;
import java.time.*;
class PolicyDetails {
    private String policyNumber;
    private String policyholderName;
    private String expiryDate;
    private String coverageType;
    private double premiumAmount;
    public PolicyDetails(String policyNumber, String policyholderName, String expiryDate, String coverageType, double premiumAmount) {
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
        PolicyDetails policy = (PolicyDetails) obj;
        return policyNumber.equals(policy.policyNumber);  // Policies are equal if policyNumber is the same
    }
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
}
class InsurancePolicyManager {
    private Set<PolicyDetails> policyHashSet = new HashSet<>();
    private Set<PolicyDetails> policyLinkedHashSet = new LinkedHashSet<>();
    private Set<PolicyDetails> policyTreeSet = new TreeSet<>(Comparator.comparing(PolicyDetails::getExpiryDate));
    public void addPolicy(PolicyDetails policy) {
        policyHashSet.add(policy);
        policyLinkedHashSet.add(policy);
        policyTreeSet.add(policy);
    }
    public void displayAllUniquePolicies() {
        System.out.println("All Unique Policies:");
        for (PolicyDetails policy : policyHashSet) {
            System.out.println(policy);
        }
    }
    public void displayExpiringSoonPolicies() {
        LocalDate currentDate = LocalDate.now();
        LocalDate thirtyDaysLater = currentDate.plusDays(30);

        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        for (PolicyDetails policy : policyHashSet) {
            try {
                LocalDate expiryDate = LocalDate.parse(policy.getExpiryDate());
                if ((expiryDate.isAfter(currentDate) || expiryDate.isEqual(currentDate)) && expiryDate.isBefore(thirtyDaysLater)) {
                    System.out.println(policy);
                }
            } catch (Exception e) {
                System.out.println("Invalid date format for policy: " + policy.getPolicyNumber());
            }
        }
    }
    public void displayPoliciesByCoverageType(String coverageType) {
        System.out.println("\nPolicies with coverage type '" + coverageType + "':");
        for (PolicyDetails policy : policyHashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }
    public void displayDuplicatePolicies() {
        System.out.println("\nDuplicate Policies Based on Policy Numbers:");
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (PolicyDetails policy : policyHashSet) {
            if (!seen.add(policy.getPolicyNumber())) {
                duplicates.add(policy.getPolicyNumber());
            }
        }
        for (PolicyDetails policy : policyHashSet) {
            if (duplicates.contains(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }
    public void displayPolicies() {
        displayAllUniquePolicies();
        displayExpiringSoonPolicies();
        displayPoliciesByCoverageType("Health");
        displayDuplicatePolicies();
    }
}
class RetrievePolicies {
    public static void main(String[] args) throws ParseException {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        PolicyDetails policy1 = new PolicyDetails("P001", "John Doe", "2025-05-01", "Health", 5000);
        PolicyDetails policy2 = new PolicyDetails("P002", "Jane Smith", "2023-12-15", "Auto", 1500);
        PolicyDetails policy3 = new PolicyDetails("P003", "Alice Johnson", "2024-07-01", "Home", 2500);
        PolicyDetails policy4 = new PolicyDetails("P004", "Bob Brown", "2023-10-01", "Health", 4500);
        PolicyDetails policy5 = new PolicyDetails("P002", "Jane Smith", "2023-12-15", "Auto", 1500);
        manager.addPolicy(policy1);
        manager.addPolicy(policy2);
        manager.addPolicy(policy3);
        manager.addPolicy(policy4);
        manager.addPolicy(policy5);
        manager.displayPolicies();
    }
}
