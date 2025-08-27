package com.mycompany.app.customer;

import com.mycompany.app.customer.valueobjects.Customer;
import com.mycompany.app.customer.valueobjects.TaxId;

import java.util.HashMap;
import java.util.Map;

public class CustomerManager {

  private Map<TaxId, Customer> customers = new HashMap<>();

  public void addCustomer(Customer customer) {
    this.customers.put(customer.taxId(), customer);
  }
}
