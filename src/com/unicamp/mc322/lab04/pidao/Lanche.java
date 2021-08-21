package com.unicamp.mc322.lab04.pidao;

public class Lanche {
	private String lancheNome;
	private double lanchePreco;
	private String lancheIdentificacao;
	private boolean descontarDoLanche;
	private double lancheComDesconto;
	

	public Lanche(String identificador, String nome, double preco) {
		this.lancheNome = nome;
		this.lancheIdentificacao = identificador;
		this.lanchePreco = preco;
		this.descontarDoLanche = false;
		this.lancheComDesconto = preco;
	}
	
	public String getIdentificador() {
		return this.lancheIdentificacao;
	}
	
	public void setPrecoComDesconto(double desconto, TipoDesconto porcentagem) {
		switch (porcentagem) {
			case PORCENTAGEM:
				this.descontarDoLanche = true;
				this.lancheComDesconto = this.lanchePreco - (this.lanchePreco * (desconto/100));
				break;
				
			case VALORFIXO:
				this.descontarDoLanche = true;
				this.lancheComDesconto = this.lanchePreco - desconto;
				break;
				
			default:
				break;
		}
		
	}
	
	public void tirarDesconto() {
		this.descontarDoLanche = false;
		this.lancheComDesconto = this.lanchePreco;
	}
	
	public String getNomeDoLanche() {
		return this.lancheNome;
	}
	
	public double getPrecoDoLanche() {
		if(this.descontarDoLanche) {
			return this.lancheComDesconto;
		}else {
			return this.lanchePreco;
		}
	}
	

}
