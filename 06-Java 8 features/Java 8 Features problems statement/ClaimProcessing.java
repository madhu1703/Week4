package name;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
class Claim {
    private String claimId;
    private String policyNumber;
    private double claimAmount;
    private String claimDate;
    private String status;
    public Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
    public String getClaimId() { return claimId; }
    public String getPolicyNumber() { return policyNumber; }
    public double getClaimAmount() { return claimAmount; }
    public String getClaimDate() { return claimDate; }
    public String getStatus() { return status; }
}
class PolicySummary {
    private String policyNumber;
    private double totalAmount;
    private double averageAmount;
public PolicySummary(String policyNumber, double totalAmount, double averageAmount) {
        this.policyNumber = policyNumber;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }
    public String getPolicyNumber() { return policyNumber; }
    public double getTotalAmount() { return totalAmount; }
    public double getAverageAmount() { return averageAmount; }
    @Override
    public String toString() {
        return "Policy: " + policyNumber +
               ", Total Amount: $" + totalAmount +
               ", Average Amount: $" + averageAmount;
    }
}
public class ClaimProcessing {
    public static void processClaims(List<Claim> claims) {
        List<Claim> filteredClaims = claims.stream()
                .filter(c -> c.getStatus().equalsIgnoreCase("Approved") && c.getClaimAmount() > 5000)
                .collect(toList());
        Map<String, List<Claim>> grouped = filteredClaims.stream()
                .collect(groupingBy(Claim::getPolicyNumber));
        List<PolicySummary> summaries = grouped.entrySet().stream()
                .map(entry -> {
                    String policy = entry.getKey();
                    List<Claim> claimList = entry.getValue();
                    double total = claimList.stream().mapToDouble(Claim::getClaimAmount).sum();
                    double average = total / claimList.size();
                    return new PolicySummary(policy, total, average);
                })
                .collect(toList());
        List<PolicySummary> topPolicies = summaries.stream()
                .sorted(Comparator.comparingDouble(PolicySummary::getTotalAmount).reversed())
                .limit(3)
                .collect(toList());
        System.out.println("Top 3 Policies with Highest Total Claim Amounts:");
        topPolicies.forEach(System.out::println);
    }
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("C101", "P001", 8000, "2024-01-10", "Approved"),
            new Claim("C102", "P002", 12000, "2024-01-15", "Approved"),
            new Claim("C103", "P001", 6000, "2024-01-20", "Approved"),
            new Claim("C104", "P003", 4000, "2024-01-22", "Pending"),
            new Claim("C105", "P002", 9000, "2024-01-25", "Approved"),
            new Claim("C106", "P004", 15000, "2024-02-01", "Rejected"),
            new Claim("C107", "P003", 7000, "2024-02-05", "Approved"),
            new Claim("C108", "P005", 5500, "2024-02-10", "Approved"),
            new Claim("C109", "P005", 2000, "2024-02-15", "Approved")
        );
        processClaims(claims);
    }
}
