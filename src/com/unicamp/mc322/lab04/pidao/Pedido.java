package com.unicamp.mc322.lab04.pidao;
import java.util.ArrayList;

public class Pedido {
	private User usuarioDoPedido;
	private ArrayList<Lanche> lanchesDoPedido;
	private double valorDoPedido;
	private double precoFinalDoPedido;
	private EstadoDoPedido estado;
	private int numeroDoPedido;
	
	public Pedido(User usuario) {
		this.usuarioDoPedido = usuario;
		this.lanchesDoPedido = new ArrayList<Lanche>();
		this.valorDoPedido = 0.0;
		this.precoFinalDoPedido =0.0;
		this.estado = EstadoDoPedido.NOVO;
		this.numeroDoPedido = 0;
	}
	
	public void addItem(Lanche lanche) {
		this.lanchesDoPedido.add(lanche);
	}
	
	public void removerItem(String identificador) {
		int i = 0;
		while(i < this.lanchesDoPedido.size()) {
			if(this.lanchesDoPedido.get(i).getIdentificador().equals(identificador)) {
				this.lanchesDoPedido.remove(i);
				i = this.lanchesDoPedido.size();
			}else {
				i = i + 1;
			}
		}
	}
	
	public void alteraEstadoDoPedido () {
		switch (this.estado) {
		case NOVO:
			this.estado = EstadoDoPedido.EMPREPARACAO;
			this.calculaPrecoFinal();
			break;
			
		case EMPREPARACAO:
			this.estado = EstadoDoPedido.SAIUPARAENTREGA;
			break;
			
		case SAIUPARAENTREGA:
			this.estado = EstadoDoPedido.ENTREGUE;
			break;

		default:
			break;
		}
	}
	
	public EstadoDoPedido getEstadoDoPedido () {
		return this.estado;
	}
	
	public void setNumeroDoPedido(int i) {
		this.numeroDoPedido = i;
	}
	

	public int getNumeroDoPedido() {
		return this.numeroDoPedido;
	}
	
	public User getUser() {
		return this.usuarioDoPedido;
	}
	
	public void calculaPrecoFinal() {
		for(Lanche lanche: this.lanchesDoPedido) {
			this.valorDoPedido = this.valorDoPedido + lanche.getPrecoDoLanche();
		}
		
		if(this.usuarioDoPedido.getNumeroDePedidos() == 1) {
			this.precoFinalDoPedido = (this.valorDoPedido * 0.8);
		}else {
			int x = this.usuarioDoPedido.getNumeroDePedidos() % 10;
			if(x == 0) {
				if(this.valorDoPedido <=60) {
					this.precoFinalDoPedido = 0.0;
				}else {
					this.precoFinalDoPedido = this.valorDoPedido - 60.0;
				}
			}else {
				if(this.valorDoPedido >= 100.0) {
					this.precoFinalDoPedido = this.valorDoPedido*0.9;
				} else {
					this.precoFinalDoPedido = this.valorDoPedido;
				}
			}
		}
	}
	
	public int numeroDeLanches() {
		return this.lanchesDoPedido.size();
	}
	
	public double precoFinal() {
		return this.precoFinalDoPedido;
	}
	
	public void imprimirLanches() {
		for(Lanche lanche: this.lanchesDoPedido) {
			System.out.println("- "+ lanche.getIdentificador() + "; preco R$" + lanche.getPrecoDoLanche());
		}
	}
	
}
