package leilao;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import exception.LanceException;
import exception.LeilaoException;
import model.PessoaModel;
import negocio.LanceNegocio;
import negocio.LeilaoNegocio;

public class LeilaoCriaLanceTest {
	
	private LeilaoNegocio leilao;
	private Calendar inicio = Calendar.getInstance();
	private Calendar fim	= Calendar.getInstance();
	private Double valorInicial = 2000.00;

	public LeilaoCriaLanceTest() throws LeilaoException {

		this.inicio.set(2018, 4, 20, 14, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		this.leilao = new LeilaoNegocio("Titulo", "Descrição", this.inicio, this.fim, this.valorInicial );
	}

	@Test
	public void testaLance() throws LanceException {
		
		LanceNegocio lance = new LanceNegocio(new PessoaModel("Maria", "1"), 2001.00);
		Calendar data = Calendar.getInstance();
		data.set(2018, 4, 22);
		lance.setData(data);
		
		assertEquals(true, this.leilao.criarLance(lance));
	}
	
	@Test
	public void testaLanceMenorQueValorInicial() throws LanceException {
		
		LanceNegocio lance = new LanceNegocio(new PessoaModel("Maria", "1"), 1999.00);
		Calendar data = Calendar.getInstance();
		data.set(2018, 4, 22);
		lance.setData(data);
		
		assertEquals(false, this.leilao.criarLance(lance));
		assertEquals(0, this.leilao.getLances().size());
	}
	
	@Test
	public void testaDoisLancesSeguidosMesmoUsuario() throws LanceException {
		
		Calendar data = Calendar.getInstance();
		data.set(2018, 4, 22);
		
		LanceNegocio lance1 = new LanceNegocio(new PessoaModel("João", "1"), 2300.00);
		lance1.setData(data);

		LanceNegocio lance2 = new LanceNegocio(new PessoaModel("Maria", "2"), 2500.00);
		lance2.setData(data);
		
		LanceNegocio lance3 = new LanceNegocio(new PessoaModel("Maria", "2"), 2700.00);
		lance2.setData(data);
		
		boolean add1 = this.leilao.criarLance(lance1);
		boolean add2 = this.leilao.criarLance(lance2);
		boolean add3 = this.leilao.criarLance(lance3);
		
		assertEquals(true, add1);
		assertEquals(true, add2);
		assertEquals(false, add3);
		assertEquals(2, this.leilao.getLances().size());
	}
	
	@Test
	public void testaLanceValorMaiorQueLanceAnterior() throws LanceException {
		
		Calendar data = Calendar.getInstance();
		data.set(2018, 4, 22);
		
		LanceNegocio lance1 = new LanceNegocio(new PessoaModel("João", "1"), 2200.00);
		lance1.setData(data);

		LanceNegocio lance2 = new LanceNegocio(new PessoaModel("Maria", "2"), 2300.00);
		lance2.setData(data);
		
		boolean add1 = this.leilao.criarLance(lance1);
		boolean add2 = this.leilao.criarLance(lance2);
		
		assertEquals(true, add1);
		assertEquals(true, add2);
		assertEquals(2, this.leilao.getLances().size());
	}
	
	@Test
	public void testaValorMenorQueLanceAnterior() throws LanceException {
		
		Calendar data = Calendar.getInstance();
		data.set(2018, 4, 22);
		
		LanceNegocio lance1 = new LanceNegocio(new PessoaModel("João", "1"), 2300.00);
		lance1.setData(data);

		LanceNegocio lance2 = new LanceNegocio(new PessoaModel("Maria", "2"), 2200.00);
		lance2.setData(data);
		
		boolean add1 = this.leilao.criarLance(lance1);
		boolean add2 = this.leilao.criarLance(lance2);
		
		assertEquals(true, add1);
		assertEquals(false, add2);
		assertEquals(1, this.leilao.getLances().size());
	}
}
