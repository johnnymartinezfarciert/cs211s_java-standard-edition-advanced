import java.lang.reflect.*;

public class ReflectionTester {

    public static void main(String[] args) throws Exception {

        // GETTING AN OBJECT'S CLASS
        Employee f = new FullTimeEmployee(13, "FullTime Fran");
        f.pay(); // can do this because "pay" exists in the declared class- Employee
        //f.bonus(); // COMPILER ERROR! cannot do this because "bonus" does not exist in declared class (Employee)-
        // it only exists in the actual class (FullTimeEmployee), but the compiler doesn't know about that
        // compiler only knows about declared class
        
        Class c = f.getClass(); // the actual type- not known at compile time, but available at runtime
        System.out.println(f + " is of type " + c.getName());

        
        Status st = Status.ACTIVE;
        c = st.getClass();
        System.out.println(st + " is of type " + c);
       
        int[] nums = { 1, 2, 3 };
        c = nums.getClass();
        System.out.println(nums + " is of type " + c.getName());
       
        Employee[] emps = { null, null };
        System.out.println(emps + " is of type " + emps.getClass());
       
        // CREATING OBJECTS
        Intern i1 = new Intern(22, "Irma Intern");

        // three ways to get a class object- one from an object, one from the class, one based on the name of the class
//        Class internClass = i1.getClass();
//        Class internClass = Intern.class;
        Class internClass = Class.forName("Intern");
        Intern i2 = i1.getClass().newInstance();
        // FullTimeEmployee.class.newInstance(); // runtime error- FullTimeEmployee has no default constructor

        
      
        // CREATING OBJECTS AND INVOKING A METHOD
        String payName = "HourlyPayer";
        Payer p = (Payer) Class.forName(payName).newInstance();
        p.pay();

        
      
        // GETTING AN OBJECT'S PARENTS AND ALL FIELDS AND CONSTRUCTORS IN PARENT AND CHILD CLASS
        String s = "FullTimeEmployee";
        Class class1 = Class.forName(s);
        Class class1Parent = class1.getSuperclass();
        System.out.println("Full time employee's parent? " + class1Parent);

        Object obj = new Object();
        Class objectParent = obj.getClass().getSuperclass();
        System.out.println("Object's parent? " + objectParent);

        Class[] classes = { class1, class1Parent, class1Parent.getSuperclass() };
        // three classes- FullTimeEmployee, Employee, and Object
        
        for (Class cl : classes) {
            System.out.println("***");
            System.out.println("Class name is " + cl.getName());

            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName() + " (type " + field.getType().getName() + ")");

                boolean stat = Modifier.isStatic(field.getModifiers());
                if (stat) 
                    System.out.println("\tstatic");
                boolean pub = Modifier.isPublic(field.getModifiers());
                if (pub)
                    System.out.println("\tpublic");
                boolean priv = Modifier.isPrivate(field.getModifiers());
                if (priv)
                    System.out.println("\tprivate");
                boolean prot = Modifier.isProtected(field.getModifiers());
                if (prot)
                    System.out.println("\tprotected");

            }

            Constructor[] Constructor = cl.getConstructors();
            for (Constructor constructor : Constructor) {
                System.out.println("Constructor:");
                Parameter[] params = constructor.getParameters();
                for (Parameter param : params) {
                    System.out.println("\tparam type " + param.getType().getName());
                }

            }

            Method[] methods = cl.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.getName() + " (return type " + method.getReturnType().getName() + ")");
                Parameter[] params = method.getParameters();
                for (Parameter param : params) {
                    System.out.println("\tparam type " + param.getType().getName());
                }

            }

        }
       
        Object o = Class.forName(payName).newInstance();
        Method method = o.getClass().getMethod("pay");
        method.invoke(o);
        
        //String payName = "HourlyPayer";
        Object object = Class.forName(payName).newInstance();
        Method[] methods = object.getClass().getDeclaredMethods();
        for(Method m : methods) {
            m.invoke(object);
        }
      
        
        
    }

}
