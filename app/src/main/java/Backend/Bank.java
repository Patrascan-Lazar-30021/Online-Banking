package Backend;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;
    private String branches;
    private String customerDetail;
    private String loanDetails;
    private String rulesAndRegulations;
    private String location;

    public Bank(String name, String location) {
        this.name = name;
        this.location = location;
        this.accounts = new ArrayList<>();
    }

    public void createAccount(Client client, double initialBalance) {
        Account newAccount = new Account(client, initialBalance);
        accounts.add(newAccount);
        System.out.println("Account created successfully for " + client.getName());
    }

    public void provideLoan(Client client, double loanAmount) {
        // Implement loan provision logic here
        System.out.println("Loan provided successfully to " + client.getName());
    }

    public void updateDetails(String branches, String customerDetail, String loanDetails, String rulesAndRegulations) {
        this.branches = branches;
        this.customerDetail = customerDetail;
        this.loanDetails = loanDetails;
        this.rulesAndRegulations = rulesAndRegulations;
        System.out.println("Bank details updated successfully");
    }

    public String getLocation() {
        return location;
    }

}
