package com.mycompany.app.customer.valueobjects;

/**
 * Represents a postal address for a customer. <br>
 * <br>
 * An {@code Address} is modeled as an immutable record and consists of:
 *
 * <ul>
 *   <li>City name
 *   <li>Postal code
 *   <li>Street number
 *   <li>Street name
 * </ul>
 *
 * <p>This value object enforces validation via its components ({@link NormalizedString}, {@link
 * PostalCode}, {@link StreetNumber}).
 *
 * @param city the city of the address
 * @param postalCode the postal code (must be 5 digits)
 * @param streetNumber the street number (must be numeric)
 * @param streetName the street name
 */
public record Address(
    NormalizedString city,
    PostalCode postalCode,
    StreetNumber streetNumber,
    NormalizedString streetName) {}
