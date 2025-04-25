package name;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class PolicyHolder {
    private String holderId;
    private String name;
    private int age;
    private String policyType;
    private double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderId() { return holderId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPolicyType() { return policyType; }
    public double getPremiumAmount() { return premiumAmount; }
}

class RiskAssessment {
    private String holderId;
    private String name;
    private double riskScore;

    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    public double getRiskScore() { return riskScore; }
    public String getHolderId() { return holderId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Holder ID: " + holderId + ", Name: " + name + ", Risk Score: " + String.format("%.2f", riskScore);
    }
}

public class RiskAssessmentSystem {
    public static void assessRisk(List<PolicyHolder> holders) {
        List<RiskAssessment> assessments = holders.stream()
            .filter(p -> p.getPolicyType().equalsIgnoreCase("Life") && p.getAge() > 60)
            .map(p -> new RiskAssessment(p.getHolderId(), p.getName(), p.getPremiumAmount() / p.getAge()))
            .sorted(Comparator.comparingDouble(RiskAssessment::getRiskScore).reversed())
            .collect(toList());
        Map<String, List<RiskAssessment>> categorized = assessments.stream()
            .collect(groupingBy(r -> r.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"));
        categorized.forEach((category, list) -> {
            System.out.println("\n" + category + ":");
            list.forEach(System.out::println);
        });
    }

    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
            new PolicyHolder("H001", "Alice", 65, "Life", 40000),
            new PolicyHolder("H002", "Bob", 70, "Health", 35000),
            new PolicyHolder("H003", "Charlie", 68, "Life", 20000),
            new PolicyHolder("H004", "David", 72, "Life", 37000),
            new PolicyHolder("H005", "Eve", 61, "Life", 30000),
            new PolicyHolder("H006", "Frank", 75, "Life", 20000),
            new PolicyHolder("H007", "Grace", 59, "Life", 50000)
        );

        assessRisk(holders);
    }
}

