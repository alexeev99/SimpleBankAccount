public class PositiveAmountEuroNegativeValueException extends RuntimeException {

    public PositiveAmountEuroNegativeValueException(
        double positiveBalanceEuro
    ) {
        super(
            String.format(
                "The provided balance in Euro: '%.2f' cannot be negative.",
                positiveBalanceEuro
            )
        );
    }
}
