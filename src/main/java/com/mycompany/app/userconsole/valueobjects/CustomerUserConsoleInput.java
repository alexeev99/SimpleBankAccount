package com.mycompany.app.userconsole.valueobjects;

public record CustomerUserConsoleInput(
    String firstName,
    String lastName,
    String cityOfBirth,
    String birthDate,
    String taxId,
    CustomerAddressUserConsoleInput address) {}
