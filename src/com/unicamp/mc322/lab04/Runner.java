package com.unicamp.mc322.lab04;

import com.unicamp.mc322.lab04.pidao.Lanche;
import com.unicamp.mc322.lab04.pidao.Pedido;
import com.unicamp.mc322.lab04.pidao.Pidao;
import com.unicamp.mc322.lab04.pidao.TipoDesconto;
import com.unicamp.mc322.lab04.pidao.User;

public class Runner {
	
	public static void main(String[] args) {
		
		Pidao pidaoApp = new Pidao("MARAMBAR", "123.456.789-10", 10, 2);
		
		User user1 = pidaoApp.cadastrarUsuario("Marcos Paulo", "123.789.643-11", 1, 2);
		User user2 = pidaoApp.cadastrarUsuario("Pereira", "123.789.643-11", 8, 4);
		
		Lanche cuscuz = new Lanche("CCZ00", "Cuscuz com ovo", 10.00);	
		Lanche macaxeira = new Lanche("MXCOS", "Macaxeira com costela no bafo", 15.00);
		Lanche coxinhaFrango = new Lanche("CXFRA", "Coxinha de frango", 8.00);
				
		pidaoApp.adicionarAoCardapio(cuscuz);
		pidaoApp.adicionarAoCardapio(macaxeira);
		pidaoApp.adicionarAoCardapio(coxinhaFrango);
		
		pidaoApp.aplicarDesconto("CCZ00", 10, TipoDesconto.PORCENTAGEM);
		
		Pedido p1 = new Pedido(user1);
		p1.addItem(cuscuz);
		p1.addItem(macaxeira);
		pidaoApp.fazerPedido(p1);
				
		Pedido p2 = new Pedido(user2);
		p2.addItem(coxinhaFrango);
		p2.addItem(coxinhaFrango);
		pidaoApp.fazerPedido(p2);
		

		
		Pedido p3 = new Pedido(user2);
		p3.addItem(coxinhaFrango);
		p3.addItem(coxinhaFrango);
		pidaoApp.fazerPedido(p3);
		
		Pedido p4 = new Pedido(user2);
		p4.addItem(coxinhaFrango);
		p4.addItem(coxinhaFrango);
		p4.addItem(macaxeira);
		p4.addItem(coxinhaFrango);
		p4.addItem(macaxeira);
		p4.addItem(macaxeira);
		p4.addItem(macaxeira);
		p4.addItem(macaxeira);
		p4.addItem(macaxeira);
		pidaoApp.fazerPedido(p4);
		
		Pedido p5 = new Pedido(user2);
		p5.addItem(coxinhaFrango);
		p5.addItem(coxinhaFrango);
		pidaoApp.fazerPedido(p5);
		
		Pedido p6 = new Pedido(user2);
		p6.addItem(coxinhaFrango);
		p6.addItem(coxinhaFrango);
		pidaoApp.fazerPedido(p6);
		
		Pedido p7 = new Pedido(user2);
		p7.addItem(coxinhaFrango);
		p7.addItem(coxinhaFrango);
		pidaoApp.fazerPedido(p7);
		
		Pedido p8 = new Pedido(user2);
		p8.addItem(coxinhaFrango);
		p8.addItem(coxinhaFrango);
		pidaoApp.fazerPedido(p8);
		
		Pedido p9 = new Pedido(user2);
		p9.addItem(coxinhaFrango);
		p9.addItem(coxinhaFrango);
		pidaoApp.fazerPedido(p9);
		
		pidaoApp.alteraEstadoDoPedido(p9);
		pidaoApp.cancelarPedido(p9);
		
		Pedido p10 = new Pedido(user2);
		p10.addItem(coxinhaFrango);
		p10.addItem(coxinhaFrango);
		p10.addItem(cuscuz);
		pidaoApp.fazerPedido(p10);
		
		pidaoApp.cancelarPedido(p10);
		
		Pedido p11 = new Pedido(user2);
		p11.addItem(coxinhaFrango);
		p11.addItem(coxinhaFrango);
		p11.addItem(macaxeira);
		p11.addItem(coxinhaFrango);
		p11.addItem(macaxeira);
		p11.addItem(macaxeira);
		p11.addItem(macaxeira);
		p11.addItem(macaxeira);
		p11.addItem(macaxeira);
		pidaoApp.fazerPedido(p11);
		
		Pedido p12 = new Pedido(user2);
		p12.addItem(coxinhaFrango);
		p12.addItem(coxinhaFrango);
		p12.addItem(macaxeira);
		p12.addItem(coxinhaFrango);
		p12.addItem(macaxeira);
		p12.addItem(macaxeira);
		p12.addItem(macaxeira);
		p12.addItem(macaxeira);
		p12.addItem(macaxeira);
		pidaoApp.fazerPedido(p12);
		
		pidaoApp.imprimirCardapio();
		
		pidaoApp.imprimirResumoPedidos();
	}

}
