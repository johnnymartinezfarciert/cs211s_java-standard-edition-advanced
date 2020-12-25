import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.util.stream.*;

public class TriangleUtilsTest {
	

	@ParameterizedTest(name = "{0}-{1}-{2} is isoceles")
	@CsvSource({
	    "2, 2, 3",  
	    "3, 5, 3",
	    "6, 4, 4"
	})
	public void validTrianglesWithExactlyTwoEqualSidesAreIsoceles(int a, int b, int c) {
		assertTrue(TriangleUtils.isIsoceles(a, b, c));
	}
	
	@ParameterizedTest(name = "{0}-{1}-{2} is equilateral or scalene (not isoceles)")
	@CsvSource({
	    "3, 3, 3", // equilateral
	    "6, 8, 10", // scalene
	    "7, 12, 15" // scalene
	    })
	public void equilateralAndScaleneTrianglesAreNotIsoceles(int a, int b, int c) {
		assertFalse(TriangleUtils.isIsoceles(a, b, c));
	}
	
	@ParameterizedTest(name = "{0}-{1}-{2} is not a triangle (not isoceles)")
	@CsvSource({
	    "1, 2, 3", // not a triangle
	    "1, 1, 2", // not a triangle but two side lengths equal
	    "1, 2, 1", // not a triangle but two side lengths equal
	    "2, 1, 1", // not a triangle but two side lengths equal
	})
	public void invalidTrianglesAreNotIsoceles(int a, int b, int c) {
		assertFalse(TriangleUtils.isIsoceles(a, b, c));
	}


	/*
	 * version where we just return false
	 */
	@Disabled
	@ParameterizedTest(name = "{0},{1},{2} is not a triangle (not isoceles)")
	@MethodSource("createNegativeLengths")
    public void invalidTrianglesWithNegativeLengthsAreNotIsoceles(int a, int b, int c) {
		assertFalse(TriangleUtils.isIsoceles(a, b, c));
    }
	@ParameterizedTest(name = "{0},{1},{2} is not a triangle (not isoceles)")
	@MethodSource("createNegativeLengths")
    public void invalidTrianglesWithNegativeLengthsThrowException(int a, int b, int c) {
		assertThrows(
				IllegalArgumentException.class, // the class of the exception that we're expecting
				() -> TriangleUtils.isIsoceles(a, b, c) // invoke our test method
				);
    }

    
	private static Stream<Arguments> createNegativeLengths() {
		return Stream.of(
		Arguments.of(1, -1, 1),
		Arguments.of(1, 1, -1),
		Arguments.of(-1, 1, 1),
		Arguments.of(-1, -1, 1),
		Arguments.of(-1, 1, -1),
		Arguments.of(1, -1, -1),
		Arguments.of(-1, -1, -1));
	}
	
	
	


}
