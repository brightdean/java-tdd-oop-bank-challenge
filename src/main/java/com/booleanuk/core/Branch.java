package com.booleanuk.core;

import java.util.HashMap;
import java.util.Map;

public class Branch {

    private String name;
    private Map<String, Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public String createCustomer(){
        Customer customer = new Customer();
        customers.put(customer.getId(), customer);

        return customer.getId();
    }

    public String createAccount(String customerId, Bank.AccountType accountType, double initialBalance) throws IllegalArgumentException{

        if(!customers.containsKey(customerId)) throw new IllegalArgumentException(Bank.ErrorType.CUSTOMER_NOT_EXISTS.value);

        Account newAccount = Bank.AccountType.CURRENT.equals(accountType) ?
                new CurrentAccount(initialBalance) :
                new SavingsAccount(initialBalance);

        return customers.get(customerId).addAccount(newAccount);
    }

    /*public boolean evaluateOverdraftRequest(OverdraftRequest request, Bank.OverdraftStatus newStatus){
        if(request == null) return false;
        if(!request.getStatus().equals(Bank.OverdraftStatus.PENDING)) return false;

        request.setStatus(newStatus);
        return true;
    }*/

}
