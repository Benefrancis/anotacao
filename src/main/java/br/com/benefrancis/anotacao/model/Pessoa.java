package br.com.benefrancis.anotacao.model;

import java.util.Date;

import br.com.benefrancis.anotacao.cnpj.CNPJ;
import br.com.benefrancis.anotacao.cpf.CPF;
import br.com.benefrancis.anotacao.email.Email;
import lombok.Data;

@Data
public class Pessoa {

	private String nome;

	private Date nascimento;

	@Email
	private String email;

	@CPF
	private String cpf;

	@CNPJ
	private String cnpj;

}
