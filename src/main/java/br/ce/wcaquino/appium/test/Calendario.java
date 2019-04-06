package br.ce.wcaquino.appium.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Calendario {

	public static void main(String args[]) {

		// validacaoFimdeSemana(5);
		clicarDiaDesejado(9);
		clicarDataString(2);

	}

	public static void clicarDataString(int qtd_dias) {
		String data_final = null;
		Date data_atual = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, qtd_dias);
		data_atual = cal.getTime();

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		data_final = format.format(data_atual);
		System.out.println(data_final);
	}

	public static int clicarDiaDesejado(int qtd_dias) {
		int dia_desejado = 0;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, qtd_dias += validacaoFimdeSemana(qtd_dias));
		dia_desejado = cal.get(Calendar.DAY_OF_MONTH);

		System.out.println(dia_desejado);
		return dia_desejado;

	}

	public static int validacaoFimdeSemana(int qtd_dias) {
		int dia_final = 0;
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(Calendar.SUNDAY);
		lista.add(Calendar.MONDAY);
		lista.add(Calendar.TUESDAY);
		lista.add(Calendar.WEDNESDAY);
		lista.add(Calendar.THURSDAY);
		lista.add(Calendar.FRIDAY);
		lista.add(Calendar.SATURDAY);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_WEEK, qtd_dias);

		lista = lista.stream().map(elemento -> cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ? 2
				: cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ? 1 : 0).collect(Collectors.toList());
		dia_final = lista.get(0);

		// System.out.println("ia final" + dia_final);
		return dia_final;
	}

}
