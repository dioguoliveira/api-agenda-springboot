package com.creathus.agenda.dto;

public class ValidacaoDto {
	private String campos, mensagem;
	
	public ValidacaoDto(String campos, String mensagem) {
		this.campos = campos;
		this.mensagem = mensagem;
	}

	public String getCampos() {
		return campos;
	}

	public String getMensagem() {
		return mensagem;
	}
}
