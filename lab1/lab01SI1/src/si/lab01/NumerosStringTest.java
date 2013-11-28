package si.lab01;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class NumerosStringTest {

	private NumerosString numero;	
	
	@Before
	public void inicializa() {
		numero = new NumerosString();
	}
	
	@Test
	public void dezena() {
		assertEquals(numero.dezena(20), "vinte");
		assertEquals(numero.dezena(30), "trinta");
		assertEquals(numero.dezena(60), "sessenta");
		assertEquals(numero.dezena(80), "oitenta");
		assertEquals(numero.dezena(90), "noventa");
	}
	
	@Test
	public void centena() {
		assertEquals(numero.centena(100), "cem");
		assertEquals(numero.centena(300), "trezentos");
		assertEquals(numero.centena(600), "seiscentos");
		assertEquals(numero.centena(900), "novecentos");
	}
	
	@Test
	public void ateVinte() {
		assertEquals(numero.ateVinte(0), "zero");
		assertEquals(numero.ateVinte(1), "um");
		assertEquals(numero.ateVinte(2), "dois");
		assertEquals(numero.ateVinte(3), "três");
		assertEquals(numero.ateVinte(7), "sete");
		assertEquals(numero.ateVinte(11), "onze");
		assertEquals(numero.ateVinte(12), "doze");
		assertEquals(numero.ateVinte(16), "dezesseis");
		assertEquals(numero.ateVinte(18), "dezoito");
	}
	
	@Test
	public void dezenaUnidade() {
		assertEquals(numero.dezenaUnidade(1), "um");
		assertEquals(numero.dezenaUnidade(3), "três");
		assertEquals(numero.dezenaUnidade(13), "treze");
		assertEquals(numero.dezenaUnidade(21),"vinte e um");
		assertEquals(numero.dezenaUnidade(22),"vinte e dois");
		assertEquals(numero.dezenaUnidade(23),"vinte e três");
		assertEquals(numero.dezenaUnidade(77),"setenta e sete");
		assertEquals(numero.dezenaUnidade(99),"noventa e nove");
	}
	
	@Test
	public void centenaDezenaUnidade() {
		assertEquals(numero.centenaDezenaUnidade(101), "cento e um");
		assertEquals(numero.centenaDezenaUnidade(199), "cento e noventa e nove");
		assertEquals(numero.centenaDezenaUnidade(215), "duzentos e quinze");
		assertEquals(numero.centenaDezenaUnidade(777), "setecentos e setenta e sete");
	}
	
	@Test
	public void milharCentenaDezenaUnidade() {
		assertEquals(numero.milharCentenaDezenaUnidade(1000), "mil");
		assertEquals(numero.milharCentenaDezenaUnidade(1200), "mil e duzentos");
		assertEquals(numero.milharCentenaDezenaUnidade(2000), "dois mil");
		assertEquals(numero.milharCentenaDezenaUnidade(2001), "dois mil e um");
		assertEquals(numero.milharCentenaDezenaUnidade(20000), "vinte mil");
		assertEquals(numero.milharCentenaDezenaUnidade(999999), "novecentos e noventa e nove mil novecentos e noventa e nove");
	}
	
	@Test
	public void milhaoMilharCentenaDezenaUnidade() {
		assertEquals(numero.milhaoMilharCentenaDezenaUnidade(1000000),"um milhão");
		assertEquals(numero.milhaoMilharCentenaDezenaUnidade(1000100),"um milhão e cem");
		assertEquals(numero.milhaoMilharCentenaDezenaUnidade(1000101),"um milhão cento e um");
		assertEquals(numero.milhaoMilharCentenaDezenaUnidade(2000000),"dois milhões");
		assertEquals(numero.milhaoMilharCentenaDezenaUnidade(123456789),"cento e vinte e três milhões quatrocentos e cinquenta e seis mil setecentos e oitenta e nove");
		assertEquals(numero.milhaoMilharCentenaDezenaUnidade(999999998),"novecentos e noventa e nove milhões novecentos e noventa e nove mil novecentos e noventa e oito");
	}
}
