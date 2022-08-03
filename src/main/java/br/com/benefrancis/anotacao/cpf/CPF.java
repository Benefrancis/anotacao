package br.com.benefrancis.anotacao.cpf;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
 
/**
 * 
 * Anotacao para validacao de CPF
 * 
 * <pre>
 * public class Pessoa {
 * 
 * 	&#64;CPF
 * 	private String cpf;
 * 
 * }
 * </pre>
 * 
 * @author Benefrancis do Nascimento
 * @version 1.0
 * @since 1.0
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Constraint(validatedBy = MyCPFValidator.class)
public @interface CPF {
	
	String MESSAGE = "CPF inválido";

	String message() default MESSAGE;

	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
