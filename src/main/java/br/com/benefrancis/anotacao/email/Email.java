/**
 * 
 */
package br.com.benefrancis.anotacao.email;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;


/**
 * 
 * Anotacao para validacao de email
 * 
 * <pre>
 * public class Pessoa {
 * 
 * 	&#64;Email
 * 	private String email;
 * 
 * }
 * </pre>
 * 
 * @author Benefrancis do Nascimento
 * @version 1.0
 * @since 1.0
 *
 */
//@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,15}$", message = "Email inválido")
//@Constraint(validatedBy = MyEmailValidator.class)
 @Constraint(validatedBy = {})
 
public @interface Email {

	String MESSAGE = "Email inválido";

	String message() default MESSAGE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
