

public class TriangleUtils {
	
	public static boolean isTriangle(int a, int b, int c) {
		if(a<0 || b<0 || c<0) {
			throw new IllegalArgumentException("a \"triangle\" cannot have negative length");
			//return false;
		}
		return (a+b>c) && (a+c>b) && (b+c>a);
	}
	
	public static boolean isEquilateral(int a, int b, int c) {
		if(!isTriangle(a, b, c)) {
			return false;
		} else {
			return a==b && b==c;
		}
	}
	
	public static boolean isIsoceles(int a, int b, int c) {
		if(!isTriangle(a, b, c)) {
			return false;
		} else if(isEquilateral(a, b, c)) {
			return false;
		} else {
			return a==b || a==c || b==c;
		}
	}

}



