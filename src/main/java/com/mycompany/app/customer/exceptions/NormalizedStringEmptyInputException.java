package com.mycompany.app.customer.exceptions;

public class NormalizedStringEmptyInputException extends RuntimeException {

    public NormalizedStringEmptyInputException() {
        super(
            String.format(
                "Providing a string which is either empty or ",
                "consists only of white spaces is not allowed."
            )
        );
    }
}
