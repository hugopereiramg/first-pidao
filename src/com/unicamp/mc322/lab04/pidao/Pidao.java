package com.unicamp.mc322.lab04.pidao;
import java.util.ArrayList;

public class Pidao {
	private String pidaoNome;
	private String pidaoCnpj;
	private int[] pidaoEndereco;
	private ArrayList<Lanche> pidaoCardapio;
	private ArrayList<Pedido> pedidos;
	

	public Pidao(String nome, String cnpj, int x, int y) {
		this.pidaoNome = nome;
		this.pidaoCnpj = cnpj;
		this.pidaoEndereco = new int[2];
		this.pidaoEndereco[0] = x;
		this.pidaoEndereco[1] = y;
		this.pidaoCardapio = new ArrayList<Lanche>();
		this.pedidos = new ArrayList<Pedido>();
	}

	public User cadastrarUsuario(String nome, String cpf, int x, int y) {
		User usuario = new User(nome, cpf, x, y);
		return usuario;
	}

	public void adicionarAoCardapio(Lanche novo) {
		this.pidaoCardapio.add(novo);
	}
	
	public void removerDoCardapio(String identificador) {
		for(int i = 0; i > this.pidaoCardapio.size(); i++) {
			if(this.pidaoCardapio.get(i).getIdentificador().equals(identificador)) {
				this.pidaoCardapio.remove(i);
			}
		}
	}

	public void aplicarDesconto(String identificador, int valor, TipoDesconto porcentagem) {
		for (Lanche lanche : this.pidaoCardapio) {
			if(lanche.getIdentificador().equals(identificador)) {
				lanche.setPrecoComDesconto(valor, porcentagem);
			}
		}
	}
	
	public void fazerPedido(Pedido pedido) {
		pedido.setNumeroDoPedido(this.pedidos.size() + 1);
		pedido.getUser().addPedido();
		pedido.alteraEstadoDoPedido();
		this.pedidos.add(pedido);
	}
	
	public void cancelarPedido(Pedido pedido) {
		EstadoDoPedido estado = this.pedidos.get(pedido.getNumeroDoPedido() - 1).getEstadoDoPedido();
		if(estado.equals(EstadoDoPedido.NOVO) || estado.equals(EstadoDoPedido.EMPREPARACAO)) {
			this.pedidos.remove(pedido.getNumeroDoPedido() - 1);
			pedido.getUser().retiraPedido();
		}else {
			System.out.println("O pedido " + pedido.getNumeroDoPedido() + " não pôde ser cancelado.");
		}
	}
	
	public void alteraEstadoDoPedido(Pedido pedido) {
		this.pedidos.get(pedido.getNumeroDoPedido()-1).alteraEstadoDoPedido();
	}
	
	public void imprimirCardapio() {
		System.out.println("Restaurante: " + this.pidaoNome);
		System.out.println("CNPJ: " + this.pidaoCnpj);
		System.out.println("Cardápio");
		System.out.println("");
		for(Lanche lanche :this.pidaoCardapio) {
			System.out.println("Lanche: " +  lanche.getIdentificador() + " " + lanche.getNomeDoLanche() );
			System.out.println("Preço: " + lanche.getPrecoDoLanche());
			System.out.println("");
		}
	}
	
	public void imprimirResumoPedidos() {
		System.out.printf("Existem %d pedidos:", this.pedidos.size());
		System.out.println("=========================================================");
		for(Pedido pedido: this.pedidos) {
			System.out.printf("Usuario: %s (%s) \n", pedido.getUser().nomeDoUsuario(), pedido.getUser().cpfDoUsuario());
			pedido.imprimirLanches();
			System.out.printf("Valor total: R$ %.2f \n", pedido.precoFinal());
			System.out.println("=========================================================");
		}
		
	}

}
