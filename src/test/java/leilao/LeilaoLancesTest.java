package leilao;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import exception.LanceException;
import exception.LeilaoException;
import impl.LanceNegocioImpl;
import impl.LeilaoNegocioImpl;
import model.PessoaModel;

public class LeilaoLancesTest {

	private static LeilaoNegocioImpl leilao;
	private Calendar inicio = Calendar.getInstance();
	private Calendar fim = Calendar.getInstance();
	private Double valorInicial = 2000.00;

	public LeilaoLancesTest() throws LeilaoException {

		this.inicio.set(2018, 4, 20, 14, 00, 00);
		this.fim.set(2018, 4, 30, 20, 00, 00);
		LeilaoLancesTest.leilao = new LeilaoNegocioImpl("Titulo", "Descrição", this.inicio, this.fim,
				this.valorInicial);
	}

	@Test
	public void testaLance() throws LanceException {

		LanceNegocioImpl lance = new LanceNegocioImpl(new PessoaModel("Maria", "1"), 2001.00);
		Calendar data = Calendar.getInstance();
		data.set(2018, 4, 22);
		lance.setData(data);

		assertEquals(true, LeilaoLancesTest.leilao.criarLance(lance));
	}

	@Test
	public void testaLanceMenorQueValorInicial() throws LanceException {

		LanceNegocioImpl lance = new LanceNegocioImpl(new PessoaModel("Maria", "1"), 1999.00);
		Calendar data = Calendar.getInstance();
		data.set(2018, 4, 22);
		lance.setData(data);

		assertEquals(false, LeilaoLancesTest.leilao.criarLance(lance));
		assertEquals(0, LeilaoLancesTest.leilao.getLances().size());
	}

	@Test
	public void testaDoisLancesSeguidosMesmoUsuario() throws LanceException {

		Calendar data = Calendar.getInstance();
		data.set(2018, 4, 22);

		LanceNegocioImpl lance1 = new LanceNegocioImpl(new PessoaModel("João", "1"), 2300.00);
		lance1.setData(data);

		LanceNegocioImpl lance2 = new LanceNegocioImpl(new PessoaModel("Maria", "2"), 2500.00);
		lance2.setData(data);

		LanceNegocioImpl lance3 = new LanceNegocioImpl(new PessoaModel("Maria", "2"), 2700.00);
		lance2.setData(data);

		assertEquals(0.0, LeilaoLancesTest.leilao.getValorMaiorLance(), 0.000001);
//		assertEquals(0.0, LeilaoLancesTest.leilao.getValorMenorLance(), 0.000001);

		boolean add1 = LeilaoLancesTest.leilao.criarLance(lance1);
		boolean add2 = LeilaoLancesTest.leilao.criarLance(lance2);
		boolean add3 = LeilaoLancesTest.leilao.criarLance(lance3);

		assertEquals(true, add1);
		assertEquals(true, add2);
		assertEquals(false, add3);
		assertEquals(2, LeilaoLancesTest.leilao.getLances().size());

		assertEquals(2300.00, LeilaoLancesTest.leilao.getValorMenorLance(), 0.000001);
		assertEquals(2500.00, LeilaoLancesTest.leilao.getValorMaiorLance(), 0.000001);
	}

	@Test
	public void testaLanceValorMaiorQueLanceAnterior() throws LanceException {

		Calendar data = Calendar.getInstance();
		data.set(2018, 4, 22);

		LanceNegocioImpl lance1 = new LanceNegocioImpl(new PessoaModel("João", "1"), 2200.00);
		lance1.setData(data);

		LanceNegocioImpl lance2 = new LanceNegocioImpl(new PessoaModel("Maria", "2"), 2300.00);
		lance2.setData(data);

		boolean add1 = LeilaoLancesTest.leilao.criarLance(lance1);
		boolean add2 = LeilaoLancesTest.leilao.criarLance(lance2);

		assertEquals(true, add1);
		assertEquals(true, add2);
		assertEquals(2, LeilaoLancesTest.leilao.getLances().size());
	}

	@Test
	public void testaValorMenorQueLanceAnterior() throws LanceException {

		Calendar data = Calendar.getInstance();
		data.set(2018, 4, 22);

		LanceNegocioImpl lance1 = new LanceNegocioImpl(new PessoaModel("João", "1"), 2300.00);
		lance1.setData(data);

		LanceNegocioImpl lance2 = new LanceNegocioImpl(new PessoaModel("Maria", "2"), 2200.00);
		lance2.setData(data);

		boolean add1 = LeilaoLancesTest.leilao.criarLance(lance1);
		boolean add2 = LeilaoLancesTest.leilao.criarLance(lance2);

		assertEquals(true, add1);
		assertEquals(false, add2);
		assertEquals(1, LeilaoLancesTest.leilao.getLances().size());
	}
}
