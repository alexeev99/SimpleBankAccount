package com.mycompany.app.customer;

import com.mycompany.app.customer.valueobjects.Customer;
import com.mycompany.app.customer.valueobjects.TaxId;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages customer entities within the banking domain. <br>
 * <br>
 * The {@code CustomerManager} acts as a simple in-memory repository for storing and retrieving
 * {@link Customer} objects, keyed by their {@link TaxId}.
 *
 * <p>This implementation uses a {@link HashMap} as its backing store and currently supports only
 * adding customers. Retrieval and update methods can be added as needed.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * CustomerManager manager = new CustomerManager();
 * Customer customer = new Customer(...);
 * manager.addCustomer(customer);
 * }</pre>
 */
public class CustomerManager {

  /** Internal map of customers, keyed by their {@link TaxId}. */
  private Map<TaxId, Customer> customers = new HashMap<>();

  /**
   * Adds a customer to the manager, indexed by its {@link TaxId}.
   *
   * @param customer the customer to be added
   */
  public void addCustomer(Customer customer) {
    this.customers.put(customer.taxId(), customer);
  }
}
