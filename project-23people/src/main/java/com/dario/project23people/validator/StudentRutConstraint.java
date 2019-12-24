package com.dario.project23people.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = Validator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentRutConstraint {
    String message() default "Invalid rut";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
