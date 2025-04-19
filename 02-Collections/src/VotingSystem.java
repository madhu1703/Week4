import java.lang.*;
import java.util.*;
public class VotingSystem {
    private final Map<String, Integer> voteCountMap = new HashMap<>();
    private final LinkedHashMap<Integer, String> voteOrderMap = new LinkedHashMap<>();
    private int voteId = 1;
    public void castVote(String candidate) {
        // Count vote using HashMap
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);
        // Record vote order using LinkedHashMap
        voteOrderMap.put(voteId++, candidate);
    }
    public void displayVoteOrder() {
        System.out.println("Order of Votes:");
        for (Map.Entry<Integer, String> entry : voteOrderMap.entrySet()) {
            System.out.println("Vote " + entry.getKey() + ": " + entry.getValue());
        }
    }
    public void displaySortedResults() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCountMap);
        System.out.println("\nSorted Voting Results:");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
    public void displayTopCandidates() {
        System.out.println("\nCandidates by Highest Votes:");
        voteCountMap.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");
        system.displayVoteOrder();
        system.displaySortedResults();
        system.displayTopCandidates();
    }
}

