import java.time.LocalDate;
import java.util.*;
class InsurancePolicy {
    String policyNumber;
    String policyHolderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;
    public InsurancePolicy(String policyNumber, String policyHolderName,
                           LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public String toString() {
        return policyNumber + " | " + policyHolderName + " | " + expiryDate + " | " +
                coverageType + " | ₹" + premiumAmount;
    }
}
class InsurancePolicyManagementSystem {
    Map<String, InsurancePolicy> policyMap = new HashMap<>();
    Map<String, InsurancePolicy> insertionOrderedMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<InsurancePolicy>> sortedByExpiry = new TreeMap<>();
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.policyNumber, policy);
        insertionOrderedMap.put(policy.policyNumber, policy);

        sortedByExpiry.putIfAbsent(policy.expiryDate, new ArrayList<>());
        sortedByExpiry.get(policy.expiryDate).add(policy);
    }
    public InsurancePolicy getPolicyByNumber(String number) {
        return policyMap.get(number);
    }
    public List<InsurancePolicy> getPoliciesExpiringInNext30Days() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        List<InsurancePolicy> result = new ArrayList<>();

        for (Map.Entry<LocalDate, List<InsurancePolicy>> entry :
                sortedByExpiry.subMap(today, true, limit, true).entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }
    public List<InsurancePolicy> getPoliciesByHolder(String holderName) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.policyHolderName.equalsIgnoreCase(holderName)) {
                result.add(policy);
            }
        }
        return result;
    }
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<String, InsurancePolicy>> iterator = policyMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, InsurancePolicy> entry = iterator.next();
            if (entry.getValue().expiryDate.isBefore(today)) {
                iterator.remove();
                insertionOrderedMap.remove(entry.getKey());
                sortedByExpiry.get(entry.getValue().expiryDate).remove(entry.getValue());
            }
        }
    }
    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();
        system.addPolicy(new InsurancePolicy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        system.addPolicy(new InsurancePolicy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 4000));
        system.addPolicy(new InsurancePolicy("P003", "Alice", LocalDate.now().plusDays(25), "Home", 6000));
        system.addPolicy(new InsurancePolicy("P004", "Charlie", LocalDate.now().minusDays(1), "Health", 5500));
        System.out.println("Retrieve Policy P001:");
        System.out.println(system.getPolicyByNumber("P001"));
        System.out.println("\nPolicies Expiring in Next 30 Days:");
        for (InsurancePolicy p : system.getPoliciesExpiringInNext30Days()) {
            System.out.println(p);
        }
        System.out.println("\nPolicies by Alice:");
        for (InsurancePolicy p : system.getPoliciesByHolder("Alice")) {
            System.out.println(p);
        }
        System.out.println("\nRemoving expired policies...");
        system.removeExpiredPolicies();
        System.out.println("\nAll Remaining Policies:");
        for (InsurancePolicy p : system.policyMap.values()) {
            System.out.println(p);
        }
    }
}
