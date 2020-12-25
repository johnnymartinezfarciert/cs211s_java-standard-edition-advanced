import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;


public class BankAccountTestParamterized1 {
	
	private BankAccount account;
	private final static int INITIAL_BALANCE = 100;
	private final static double THRESHOLD = 0.0001;
	

    @BeforeEach
    public void setup() {
        account = new BankAccount(INITIAL_BALANCE);
    }
	
	@ParameterizedTest
	@ValueSource(doubles = {1, INITIAL_BALANCE})
	public void depositPositiveIncreasesBalance(double amount) {
		double beforeBalance = account.getBalance();
		account.deposit(amount);
		double afterBalance = account.getBalance();
		assertEquals(beforeBalance + amount, afterBalance, THRESHOLD);
	}
	
	
	@ParameterizedTest
	@ValueSource(doubles = {-1, 0, -1*INITIAL_BALANCE})
	public void depositNegativeOrZeroLeavesBalanceUnchanged(double amount) {
		double beforeBalance = account.getBalance();
		account.deposit(amount);
		double afterBalance = account.getBalance();
		assertEquals(beforeBalance, afterBalance, THRESHOLD);
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {-1, 0, -1*INITIAL_BALANCE})
    public void withdrawNegativeOrZeroLeavesBalanceUnchanged(double amount) {
		double beforeBalance = account.getBalance();
		account.withdraw(amount);
		double afterBalance = account.getBalance();
		assertEquals(beforeBalance, afterBalance, THRESHOLD);
    }
	
	@ParameterizedTest
	@ValueSource(doubles = {0.25, 0.5, 0.75, 1})
    public void withdrawPositiveUpToBalanceDecreasesBalance(double portionOfBalance) {
		double beforeBalance = account.getBalance();
		double amount = beforeBalance * portionOfBalance;
		account.withdraw(amount);
		double afterBalance = account.getBalance();
		assertEquals(beforeBalance-amount, afterBalance, THRESHOLD);
    }
	
	@ParameterizedTest
	@ValueSource(doubles = {0.1, 1, INITIAL_BALANCE})
    public void withdrawGreaterThanBalanceLeavesBalanceUnchanged(double amount) {
		double beforeBalance = account.getBalance();
		account.withdraw(amount+beforeBalance);
		double afterBalance = account.getBalance();
		assertEquals(beforeBalance, afterBalance, THRESHOLD);
    }
	
	

	
	
	



}
