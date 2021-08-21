package com.unicamp.mc322.lab04.pidao;

public class User {
	private String nomeUsuario;
	private String cpfUsuario;
	private int[] enderecoUsuario;
	private int numeroDePedidos;
	
	public User(String nome, String cpf, int x, int y) {
		this.nomeUsuario = nome;
		this.cpfUsuario = cpf;
		this.enderecoUsuario = new int[2];
		this.enderecoUsuario[0] = x;
		this.enderecoUsuario[1] = y;
		this.numeroDePedidos = 0;
	}
	
	public int getNumeroDePedidos() {
		return this.numeroDePedidos;
	}
	
	public void addPedido() {
		this.numeroDePedidos = this.numeroDePedidos + 1;
	}
	
	public void retiraPedido() {
		this.numeroDePedidos = this.numeroDePedidos - 1;
	}
	
	public String nomeDoUsuario() {
		return this.nomeUsuario;
	}
	
	public String cpfDoUsuario() {
		return this.cpfUsuario;
	}
}
