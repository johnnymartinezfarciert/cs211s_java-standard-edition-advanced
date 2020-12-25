import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;


public class BankAccountTestParamterized2 {
	
	private final static double THRESHOLD = 0.0001;

	
	@ParameterizedTest
	@MethodSource("createDepositTests")
	public void depositPositiveIncreasesBalanceOtherwiseLeavesBalanceUnchanged(double beforeBalance, double amount, double afterBalance) {
		BankAccount account = new BankAccount(beforeBalance);
		account.deposit(amount);
		double result = account.getBalance();
		assertEquals(afterBalance, result, THRESHOLD);
	}
	
	private static Stream<Arguments> createDepositTests() {
		return Stream.of(
		Arguments.of(100, 1, 101),
		Arguments.of(100, 100, 200),
		Arguments.of(100, -1, 100),
		Arguments.of(100, 0, 100),
		Arguments.of(100, -100, 100));
	}
	

	
	@ParameterizedTest(name="balance before={0} and after withdrawing {1}, the balance is={2}")
	@MethodSource("createWithdrawTests")
    public void withdrawPositiveLessThanOrEqualToBalanceReducesBalanceOtherwiseLeavesBalanceUnchanged(double beforeBalance, double amount, double afterBalance) {
		BankAccount account = new BankAccount(beforeBalance);
		account.withdraw(amount);
		double result = account.getBalance();
		assertEquals(afterBalance, result, THRESHOLD);
    }
	
	private static Stream<Arguments> createWithdrawTests() {
		return Stream.of(
		Arguments.of(100, -1, 100),
		Arguments.of(100, 0, 100),
		Arguments.of(100, -100, 100),
		Arguments.of(100, 25, 75),
		Arguments.of(100, 50, 50),
		Arguments.of(100, 75, 25),
		Arguments.of(100, 100, 0),
		Arguments.of(100, 100.1, 100),
		Arguments.of(100, 101, 100),
		Arguments.of(100, 200, 100));
	}
	

	
	

	
	
	



}
