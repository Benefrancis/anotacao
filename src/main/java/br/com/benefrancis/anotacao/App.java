package br.com.benefrancis.anotacao;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.benefrancis.anotacao.model.Pessoa;

public class App {

	public static void main(String[] args) {
		
		Pessoa p = new Pessoa();
		p.setNascimento(new Date());
		p.setNome("Benefrancis");
		p.setEmail("benefrancis@gmail.com");
		p.setCpf("248.788.918-74");
		p.setCnpj("248464564645654");

		isValid(p);

	}

	/**
	 * Executa validação de Pessoa
	 * 
	 * @param p
	 */
	private static boolean isValid(Pessoa p) {
		boolean retorno = true;
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

		Validator validator = validatorFactory.getValidator();

		Set<ConstraintViolation<Pessoa>> constraintViolations = validator.validate(p);

		for (ConstraintViolation<Pessoa> error : constraintViolations) {
			retorno = false;
			String msgError = error.getMessage();
			System.out.println(msgError);
		}
		return retorno;
	}

}
