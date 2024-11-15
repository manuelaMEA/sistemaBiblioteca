package ui;

import java.util.Scanner;
import negocio.Biblioteca;

public class Main {

	public static void main(String[] args) {
		
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.inicializar();
		Scanner scanner = new Scanner(System.in);
		Menu menu = new Menu(biblioteca, scanner);
	    menu.exibirMenu();
}
	
	}
	