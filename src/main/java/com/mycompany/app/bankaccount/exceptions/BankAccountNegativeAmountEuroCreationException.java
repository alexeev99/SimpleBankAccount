public class BankAccountNegativeAmountEuroCreationException
    extends RuntimeException {

    public BankAccountNegativeAmountEuroCreationException(double amountEuro) {
        super(
            String.format(
                "A negative amount %.2f cannot be used as. ",
                "an initial deposit to create a bank account",
                amountEuro
            )
        );
    }
}
