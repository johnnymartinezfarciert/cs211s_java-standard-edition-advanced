import java.lang.annotation.*;
//meta-annotations
// annotation is meant for fiends (instance data variables only)

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ProperLength {

	public int minLength() default 1;
	public int maxLength() default 255;

}
