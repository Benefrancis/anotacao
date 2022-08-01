package br.com.benefrancis.anotacao.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
 
/**
 * Logica para validação de e-mail
 * 
 * @author Benefrancis
 * @version 1.0
 * @since 1.0
 *
 */
public class MyEmailValidator implements ConstraintValidator<Email, String> {

	@Override
	public boolean isValid(final String value, ConstraintValidatorContext context) {
		
		if (value == null || value.length() == 0) {
			return true;
		}

		// cannot split email string at @ as it can be a part of quoted local part of
		// email.
		// so we need to split at a position of last @ present in the string:
		String stringValue = value.toString();
		
		int splitPosition = stringValue.lastIndexOf("@");

		// need to check if
		if (splitPosition < 0) {
			return false;
		}

		/**
		 * Using OWASP validation regex Besides creating your own regular expression in
		 * Java for email verification, you can also use the ones that are freely
		 * provided by the OWASP organization.
		 */
		final String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,15}$";

		// initialize the Pattern object
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(value);
		
		return matcher.matches();
	}

	@Override
	public void initialize(Email constraintAnnotation) {
	}

}
