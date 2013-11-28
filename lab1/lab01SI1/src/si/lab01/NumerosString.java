/**
 * @author Jérémy Pougnet
 */

package si.lab01;

import java.util.Scanner;

public class NumerosString {

	public static Scanner numero;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			imprimeNumero();
		} catch (Exception e) {
			System.err.println("Informe apenas numeros!");
			imprimeNumero();
		}

	}

	private static void imprimeNumero() {

		numero = new Scanner(System.in);

		System.out.println("Informe um numero entre 0 e 1000000000 (um bilhão):");

		int number = numero.nextInt();

		NumerosString num = new NumerosString();

		System.out.println(num.milhaoMilharCentenaDezenaUnidade(number));

	}

	public String dezena(int dez) {
		String[] dezenas = new String[] { "vinte", "trinta", "quarenta",
				"cinquenta", "sessenta", "setenta", "oitenta", "noventa" };

		return dezenas[dez / 10 - 2];
	}

	public String centena(int cen) {
		String[] centenas = new String[] { "cento", "duzentos", "trezentos",
				"quatrocentos", "quinhentos", "seiscentos", "setecentos",
				"oitocentos", "novecentos" };

		if (cen == 100)
			return "cem";

		return centenas[(int) (cen / 100) - 1];
	}

	public String ateVinte(int ate) {
		String[] dezenasUnidades = new String[] { "zero", "um", "dois", "três",
				"quatro", "cinco", "seis", "sete", "oito", "nove", "dez",
				"onze", "doze", "treze", "quatorze", "quinze", "dezesseis",
				"dezessete", "dezoito", "dezenove" };

		return dezenasUnidades[ate];
	}

	public String dezenaUnidade(int dezuni) {
		String saida = "";

		if (dezuni >= 20) {
			saida += dezena((int) (dezuni / 10) * 10);
			if ((dezuni -= (int) (dezuni / 10) * 10) > 0) {
				saida += " e " + ateVinte(dezuni);
			}
		} else {
			saida = ateVinte(dezuni);
		}

		return saida;
	}

	public String centenaDezenaUnidade(int cendezuni) {
		String saida = "";

		if (cendezuni >= 100) {
			saida += centena(cendezuni);
			if ((cendezuni -= (int) (cendezuni / 100) * 100) > 0) {
				saida += " e " + dezenaUnidade(cendezuni);
			}
		} else {
			saida = dezenaUnidade(cendezuni);
		}

		return saida;
	}

	public String milharCentenaDezenaUnidade(int milcendezuni) {
		String saida = "";

		int num;

		if (milcendezuni >= 1000) {
			num = (int) (milcendezuni / 1000);
			if (num != 1) {
				saida = centenaDezenaUnidade(num) + " ";
			}
			saida += "mil";

			if ((num = milcendezuni - num * 1000) > 0) {
				saida += (num % 100 == 0 && num >= 100 || num < 100 ? " e "
						: " ") + centenaDezenaUnidade(num);
			}
		} else {
			saida = centenaDezenaUnidade(milcendezuni);
		}

		return saida;
	}

	public String milhaoMilharCentenaDezenaUnidade(int milmilcendezuni) {
		String saida = "";

		int num;

		if (milmilcendezuni >= 1000000) {
			num = (int) (milmilcendezuni / 1000000);
			saida = centenaDezenaUnidade(num)
					+ (num == 1 ? " milhão" : " milhões");

			if ((num = milmilcendezuni - num * 1000000) > 0) {
				saida += (num % 100 == 0 && num >= 100 && num <= 900
						|| num < 100 ? " e " : " ")
						+ milharCentenaDezenaUnidade(num);
			}
		} else {
			saida = milharCentenaDezenaUnidade(milmilcendezuni);
		}

		return saida;
	}

}
