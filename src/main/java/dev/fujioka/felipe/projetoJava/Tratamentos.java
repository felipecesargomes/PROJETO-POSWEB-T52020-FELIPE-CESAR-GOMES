package dev.fujioka.felipe.projetoJava;

import java.text.DecimalFormat;
import java.text.Normalizer;

/**
 * @author felipecesar
 *
 */

public class Tratamentos {

	public static String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
	}
	
	public static String removerPontos(String str) {
		return str.replaceAll("\\D+","");
	}
	
	public static Double FormatacaoDecimal(Double num) {
		Double valor;
		DecimalFormat formatador = new DecimalFormat("0.00");
		valor = Double.valueOf(formatador.format(num).replaceAll(",", "."));
		System.out.println(valor);
		return valor;
	}
}