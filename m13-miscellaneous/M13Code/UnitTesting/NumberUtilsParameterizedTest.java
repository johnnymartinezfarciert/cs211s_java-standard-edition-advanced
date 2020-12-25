import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsParameterizedTest {

	@ParameterizedTest
	@ValueSource(ints = {2, 6, -2, 0, -6, 100})
	public void evenNumberIsEven(int number) {
		boolean result = NumberUtils.isEven(number);
		assertTrue(result);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {3, 15, -7})
	public void oddNumberIsNotEven(int number) {
		assertFalse(NumberUtils.isEven(number));
	}
	

}
