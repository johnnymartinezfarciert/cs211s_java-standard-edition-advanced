package annotation;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

public class EmployeeTester {

    @SuppressWarnings("unchecked")
	public static void main(String[] args)  {
	    
	    Employee employee = new Employee();
	    employee.pay();
	    
	    printAnnotations(employee.getClass());
	    runTestMethods(employee);
	   
	
	}
    
    public static void runTestMethods(Object testObject) {
        Method[] methods = testObject.getClass().getDeclaredMethods();
        
        for(Method method : methods) {
            if(method.isAnnotationPresent(DevelopmentInformation.class)) {
                System.out.println("Method: " + method.getName());
                
                DevelopmentInformation annotation = method.getAnnotation(DevelopmentInformation.class);
                if(annotation.status()==DevelopmentInformation.Status.TESTING) {
                    System.out.println("Running test of " + method.getName());
                    try {
                        method.invoke(testObject);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
               
            }
        }
    }
    
    public static void printAnnotations(Class clss) {
        Method[] methods = clss.getDeclaredMethods();
        
        for(Method method : methods) {
            System.out.println("Method: " + method.getName());
            
            Annotation[] annotations = method.getAnnotations();
            for(Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        }
        
    }
	
	
	
	
}
