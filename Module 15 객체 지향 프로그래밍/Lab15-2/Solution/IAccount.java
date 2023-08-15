import java.math.BigDecimal;

public interface IAccount {
    BigDecimal deposit(BigDecimal amount);
    boolean withDraw(BigDecimal amount);
}
