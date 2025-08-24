import com.mycompany.app.bankaccount.Transaction;
import com.mycompany.app.bankaccount.exceptions.BankAccountNegativeAmountEuroCreationException;
import com.mycompany.app.bankaccount.exceptions.BankAccountNegativeAmountEuroDepositException;
import com.mycompany.app.bankaccount.exceptions.BankAccountNegativeAmountEuroWithdrawException;
import com.mycompany.app.bankaccount.valueobjects.BankId;
import com.mycompany.app.bankaccount.valueobjects.PositiveAmountEuro;
import java.util.HashMap;
import java.util.Map;

public abstract class BankAccount {

    protected Map<String, Transaction> transactions = new HashMap<>();
    protected PositiveAmountEuro amountEuro = new PositiveAmountEuro(0);
    protected BankId bankId;

    public BankAccount(BankId bankId, PositiveAmountEuro amountEuro) {}

    public PositiveAmountEuro withdraw(PositiveAmountEuro amountEuro) {}

    public void deposit(PositiveAmountEuro amountEuro) {}

    public double balance() {}
}
