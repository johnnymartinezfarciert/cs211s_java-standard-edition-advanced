import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class NumberUtilsTest {
	
	@Test
	public void evenPositivePrimeNumberIsEven() {
		int number = 2;
		boolean result = NumberUtils.isEven(number);
		assertTrue(result);
		//assertEquals(true, result);
	}
	
	@Test
	public void evenPositiveCompositeNumberIsEven() {
		int number = 6;
		assertTrue(NumberUtils.isEven(number));
	}
	
	@Test
	public void evenNegativeNumberIsEven() {
		int number = -2;
		assertTrue(NumberUtils.isEven(number));
	}
	
	@Test
	public void zeroIsEven() {
		int number = 0;
		assertTrue(NumberUtils.isEven(number));
	}
	
	@Test
	public void oddPositivePrimeNumberIsNotEven() {
		int number = 3;
		assertFalse(NumberUtils.isEven(number));
	}
	@Test
	public void oddPositiveCompositeNumberIsNotEven() {
		int number = 15;
		assertFalse(NumberUtils.isEven(number));
	}
	
	@Test
	public void oddNegativeNumberIsNotEven() {
		int number = -7;
		assertFalse(NumberUtils.isEven(number));
	}

}
