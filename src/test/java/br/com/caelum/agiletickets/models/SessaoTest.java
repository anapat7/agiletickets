package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {


	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
        sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}
	
	public void naoDeveVenderZeroIngresso(){
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(1);
		
		Assert.assertFalse(sessao.podeReservar(0));
	}
	
	public void naoDeveVenderQtdNegativa(){
		Sessao sessao = new Sessao();
		Assert.assertFalse(sessao.podeReservar(-1));
	}
	
	@Test
	public void deveVender1ingressoSeHa1vaga(){
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(1);
		
		Assert.assertTrue(sessao.podeReservar(1));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
}
