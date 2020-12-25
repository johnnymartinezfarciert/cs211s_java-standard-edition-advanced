package annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DevelopmentInformation {
    
    public static enum Status {DEVELOPMENT, TESTING, LIVE };
    
    String developer();
    int version() default 1;
    Status status() default Status.DEVELOPMENT;

}
