import com.mycompany.app.bankaccount.Transaction;
import com.mycompany.app.bankaccount.exceptions.BankAccountNegativeAmountEuroDepositException;
import com.mycompany.app.bankaccount.exceptions.BankAccountNegativeAmountEuroWithdrawException;
import java.util.HashMap;
import java.util.Map;

public abstract class BankAccount {

    protected Map<String, Transaction> transactions = new HashMap<>();
    protected double amountEuro = 0;
    protected String bankId;
    protected String taxId;

    public double withdraw(double amountEuro)
        throws BankAccountNegativeAmountEuroWithdrawException {}

    public void deposit(double amountEuro)
        throws BankAccountNegativeAmountEuroDepositException {}

    public double balance() {}
}
