package br.ce.wcaquino.appium.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class calendar {

	public static void main(String args[]) throws IOException {

		for (int i = 0; i < 10; i++) {
			System.out.println("GCD of " + retornaNumerosArquivo("ESQUERDA").get(i) + " and "
					+ retornaNumerosArquivo("DIREITA").get(i) + " is "
					+ commDiv(retornaNumerosArquivo("ESQUERDA").get(i), retornaNumerosArquivo("DIREITA").get(i)));
		}

		ArrayList<String> arrl = new ArrayList<String>();
//adding elements to the end
		arrl.add("First");
		arrl.add("Second");
		arrl.add("Third");
		arrl.add("Random");
		arrl.add("Click");
		System.out.println("Actual ArrayList:" + arrl);
		List<String> list = arrl.subList(2, 4);
		System.out.println("Sub List: " + list);

		String text = "texto 1, texto 2";
		Pattern p = Pattern.compile("[^\\s]+");
		Matcher m = p.matcher(text);
		while (m.find()) {
			System.out.println(m.group());
		}

	}

	public static List<Integer> retornaNumerosArquivo(String opcao) {

		String filename = "C:\\teste\\teste.txt";
		List<String> lista = new ArrayList<String>();
		List<Integer> lista_convertida = new ArrayList<Integer>();

		switch (opcao) {

		case "ESQUERDA":
			try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
				lista = br.lines().collect(Collectors.toList());

				lista = lista.stream().filter(elemento -> elemento.contains(" "))
						.map(elemento -> elemento.substring(0, elemento.indexOf(" "))).collect(Collectors.toList());

				lista_convertida = lista.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
				// System.out.println(lista_convertida);
			} catch (Exception e) {

			}

			break;

		case "DIREITA":
			try (BufferedReader br = Files.newBufferedReader(Paths.get(filename))) {
				lista = br.lines().collect(Collectors.toList());

				lista = lista.stream().filter(elemento -> !elemento.equals("10"))
						.map(elemento -> elemento.substring(elemento.indexOf(" ") + 1)).collect(Collectors.toList());

				lista_convertida = lista.stream().map(elemento -> Integer.parseInt(elemento))
						.collect(Collectors.toList());
				// System.out.println(lista);
				/*
				 * for (String elemento : lista) { if (elemento.equals("10")) {
				 * lista_primeiros.add(elemento); } if (elemento.contains(" ")) {
				 * lista_primeiros.add(elemento = elemento.substring(0, elemento.indexOf(" ")));
				 * } } for (String elemento : lista) {
				 * lista_segundos.add(elemento.substring(elemento.indexOf(" ") + 1)); if
				 * (elemento.equals("10")) { lista_segundos.remove(elemento); }
				 * 
				 * }
				 */
			} catch (Exception e) {

			}
			break;
		}
		return lista_convertida;

	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
	
	static int commDiv(int a,int b) 
    { 
        // find gcd of a,b 
        int n = gcd(a, b); 
       
        // Count divisors of n. 
        int result = 0; 
        for (int i=1; i<=Math.sqrt(n); i++) 
        { 
            // if 'i' is factor of n 
            if (n%i==0) 
            { 
                // check if divisors are equal 
                if (n/i == i) 
                    result += 1; 
                else
                    result += 2; 
            } 
        } 
        return result; 
    } 
}
