import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
class InsurancePolicy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;
    public InsurancePolicy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public String getCoverageType() {
        return coverageType;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    @Override
    public String toString() {
        return String.format("Policy[%s, %s, %s, %s, %.2f]", policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InsurancePolicy)) return false;
        InsurancePolicy other = (InsurancePolicy) o;
        return policyNumber.equals(other.policyNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
}
class PerformanceComparsion {
    public static void main(String[] args) {
        List<InsurancePolicy> samplePolicies = generateSamplePolicies();
        Set<InsurancePolicy> hashSet = new HashSet<>(samplePolicies);
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>(samplePolicies);
        Set<InsurancePolicy> treeSet = new TreeSet<>(Comparator.comparing(InsurancePolicy::getExpiryDate));
        treeSet.addAll(samplePolicies);
        System.out.println("\nAll Unique Policies (HashSet):");
        printSet(hashSet);
        System.out.println("\nPolicies in Insertion Order (LinkedHashSet):");
        printSet(linkedHashSet);
        System.out.println("\nPolicies Sorted by Expiry Date (TreeSet):");
        printSet(treeSet);
        System.out.println("\nPolicies Expiring in Next 30 Days:");
        printSet(getPoliciesExpiringSoon(samplePolicies, 30));
        System.out.println("\nPolicies with Coverage Type 'Health':");
        printSet(getPoliciesByCoverageType(samplePolicies, "Health"));
        System.out.println("\nDuplicate Policies (by Policy Number):");
        printSet(findDuplicatePolicies(samplePolicies));
        System.out.println("\nPerformance Comparison:");
        comparePerformance(samplePolicies);
    }
    static List<InsurancePolicy> generateSamplePolicies() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return List.of(
                new InsurancePolicy("P001", "Alice", LocalDate.parse("2025-05-20", formatter), "Health", 10000),
                new InsurancePolicy("P002", "Bob", LocalDate.parse("2025-04-30", formatter), "Auto", 8000),
                new InsurancePolicy("P003", "Charlie", LocalDate.now().plusDays(15), "Home", 12000),
                new InsurancePolicy("P004", "David", LocalDate.now().plusDays(5), "Health", 9500),
                new InsurancePolicy("P005", "Eve", LocalDate.now().plusDays(40), "Auto", 7000),
                new InsurancePolicy("P001", "Alice", LocalDate.parse("2025-05-20", formatter), "Health", 10000)
        );
    }
    static void printSet(Collection<InsurancePolicy> set) {
        for (InsurancePolicy policy : set) {
            System.out.println(policy);
        }
    }
    static List<InsurancePolicy> getPoliciesExpiringSoon(List<InsurancePolicy> policies, int days) {
        LocalDate now = LocalDate.now();
        LocalDate threshold = now.plusDays(days);
        List<InsurancePolicy> soonExpiring = new ArrayList<>();
        for (InsurancePolicy policy : policies) {
            if (!policy.getExpiryDate().isAfter(threshold)) {
                soonExpiring.add(policy);
            }
        }
        return soonExpiring;
    }
    static List<InsurancePolicy> getPoliciesByCoverageType(List<InsurancePolicy> policies, String type) {
        List<InsurancePolicy> filtered = new ArrayList<>();
        for (InsurancePolicy policy : policies) {
            if (policy.getCoverageType().equalsIgnoreCase(type)) {
                filtered.add(policy);
            }
        }
        return filtered;
    }
    static Set<InsurancePolicy> findDuplicatePolicies(List<InsurancePolicy> policies) {
        Set<String> seen = new HashSet<>();
        Set<InsurancePolicy> duplicates = new HashSet<>();
        for (InsurancePolicy policy : policies) {
            if (!seen.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }
    static void comparePerformance(List<InsurancePolicy> policies) {
        Set<InsurancePolicy> hashSet = new HashSet<>();
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
        Set<InsurancePolicy> treeSet = new TreeSet<>(Comparator.comparing(InsurancePolicy::getExpiryDate));
        System.out.println("Measuring Add Time:");
        long start = System.nanoTime();
        hashSet.addAll(policies);
        long end = System.nanoTime();
        System.out.println("HashSet add time: " + (end - start) + " ns");
        start = System.nanoTime();
        linkedHashSet.addAll(policies);
        end = System.nanoTime();
        System.out.println("LinkedHashSet add time: " + (end - start) + " ns");
        start = System.nanoTime();
        treeSet.addAll(policies);
        end = System.nanoTime();
        System.out.println("TreeSet add time: " + (end - start) + " ns");
        System.out.println("Measuring Search Time (contains check for P003):");
        InsurancePolicy search = new InsurancePolicy("P003", "", LocalDate.now(), "", 0);
        start = System.nanoTime();
        hashSet.contains(search);
        end = System.nanoTime();
        System.out.println("HashSet contains time: " + (end - start) + " ns");
        start = System.nanoTime();
        linkedHashSet.contains(search);
        end = System.nanoTime();
        System.out.println("LinkedHashSet contains time: " + (end - start) + " ns");
        start = System.nanoTime();
        treeSet.contains(search);
        end = System.nanoTime();
        System.out.println("TreeSet contains time: " + (end - start) + " ns");
    }
}

