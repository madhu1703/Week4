import java.lang.*;
import java.util.*;
class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();
    public void addAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        System.out.println("Account added: " + accountNumber + " -> ₹" + initialBalance);
    }
    public void requestWithdrawal(String accountNumber, double amount) {
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
        System.out.println("Withdrawal requested: " + accountNumber + " -> ₹" + amount);
    }
    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawal Requests:");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            String account = req.accountNumber;
            double amount = req.amount;
            if (!accounts.containsKey(account)) {
                System.out.println("Account not found: " + account);
            } else if (accounts.get(account) < amount) {
                System.out.println("Insufficient funds in " + account + ". Available: ₹" + accounts.get(account));
            } else {
                accounts.put(account, accounts.get(account) - amount);
                System.out.println("Withdrawn ₹" + amount + " from " + account + ". New Balance: ₹" + accounts.get(account));
            }
        }
    }
    public void displaySortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");
        TreeMap<Double, List<String>> sorted = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sorted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        for (Map.Entry<Double, List<String>> entry : sorted.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println("Account: " + acc + ", Balance: ₹" + entry.getKey());
            }
        }
    }
    static class WithdrawalRequest {
        String accountNumber;
        double amount;
        WithdrawalRequest(String accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount("ACC001", 5000);
        bank.addAccount("ACC002", 3000);
        bank.addAccount("ACC003", 7000);
        bank.requestWithdrawal("ACC001", 1000);
        bank.requestWithdrawal("ACC002", 4000);
        bank.requestWithdrawal("ACC003", 2000);
        bank.processWithdrawals();
        bank.displaySortedByBalance();
    }
}

