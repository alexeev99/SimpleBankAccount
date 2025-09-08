package com.mycompany.app.customer.valueobjects;

import java.time.LocalDate;

/**
 * Represents a customer in the banking domain. <br>
 * <br>
 * A {@code Customer} is modeled as an immutable record and consists of:
 *
 * <ul>
 *   <li>A unique {@link CustomerId}
 *   <li>First name and last name
 *   <li>City of birth and birth date
 *   <li>Postal address
 *   <li>Tax ID
 * </ul>
 *
 * @param customerId the unique identifier of the customer
 * @param firstName the customer's first name
 * @param lastName the customer's last name
 * @param cityOfBirth the customer's city of birth
 * @param birthDate the customer's birth date
 * @param address the customer's postal address
 * @param taxId the customer's tax ID (must be 11 digits)
 */
public record Customer(
    CustomerId customerId,
    NormalizedString firstName,
    NormalizedString lastName,
    NormalizedString cityOfBirth,
    LocalDate birthDate,
    Address address,
    TaxId taxId) {}
