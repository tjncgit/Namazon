package com;

import com.Account.Account;
import com.Account.Customer;
import com.Account.Vendor;
import com.Exceptions.AccountAuthenticationException;
import com.Exceptions.AccountCreationException;

import java.util.*;

public class Namazon {
    private List<Customer> customers;
    private List<Vendor> vendors;
    private Map<String, Account> accounts;

    public Namazon() {
        this.customers = new ArrayList<>();
        this.vendors  = new ArrayList<>();
        this.accounts = new TreeMap<>();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public Account signInTo(String email, String passWord) throws AccountAuthenticationException {
        Account userAccount = null;
        if(!accounts.containsKey(email)) {
            throw new AccountAuthenticationException("An account with that email does not exist");
        }
        if(!accounts.get(email).getPassword().equals(passWord)) throw new AccountAuthenticationException("Password is Incorrect");
        userAccount = accounts.get(email);
        return userAccount;
    }

    public Vendor signUpAsVendor(String brandName, String firstName, String lastName, String email, String passWord) throws AccountCreationException {
        if(accounts.containsKey(email)) throw new AccountCreationException("An account with this email already exists");
        Vendor vendorAccount = new Vendor(brandName, firstName, lastName, email, passWord);
        getVendors().add(vendorAccount);
        getAccounts().put(email,vendorAccount);
        return vendorAccount;
    }

    public Customer signUpAsCustomer(String firstName, String lastName, String email, String passWord) throws AccountCreationException {
        if(accounts.containsKey(email)) throw new AccountCreationException("An account with this email already exists");
        Customer customerAccount = new Customer(firstName, lastName, email, passWord);
        getCustomers().add(customerAccount);
        getAccounts().put(email,customerAccount);
        return customerAccount;
    }

    public Vendor selectVendor(String vendorName) {
        Vendor selectedVendor = null;
        for(Vendor vendor: getVendors()) {
            if(vendor.getBrandName().equals(vendorName)) {
                selectedVendor = vendor;
            }
        }
        return selectedVendor;
    }

    @Override
    public String toString() {
        return "customers= " + customers +
                ", vendors= " + vendors +
                ", accounts= " + accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Namazon namazon = (Namazon) o;
        return Objects.equals(customers, namazon.customers) && Objects.equals(vendors, namazon.vendors) && Objects.equals(accounts, namazon.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customers, vendors, accounts);
    }
}
