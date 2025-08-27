package com.mycompany.app.userconsole.valueobjects;

public record CustomerAddressUserConsoleInput(
    String city,
    String postalCode,
    String streetNumber,
    String streetName
) {}
