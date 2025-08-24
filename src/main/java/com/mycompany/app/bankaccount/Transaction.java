import com.mycompany.app.bankaccount.enums.Operation;
import java.time.LocalDateTime;

public record Transaction(
    LocalDateTime timestamp,
    String transactionId,
    Operation operation,
    String senderBankId,
    String targetBankId
) {}
