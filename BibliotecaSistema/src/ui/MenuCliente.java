package ui;

import negocio.Biblioteca;
import java.util.Scanner;

public class MenuCliente {
	
	protected Biblioteca biblioteca;
    protected Scanner scanner;
    protected String idUsuario;

    public MenuCliente(Biblioteca biblioteca, Scanner scanner, String idUsuario) {
    	this.biblioteca = biblioteca;
        this.scanner = scanner;
        this.idUsuario = idUsuario;
    }

    
    public void exibirMenu() {
        while (true) {
            System.out.println("\nMODO USUÁRIO");
            System.out.println("======================================");
            System.out.println("1. Listar empréstimos por usuário");
            System.out.println("2. Listar livros da biblioteca");
            System.out.println("3. Realizar empréstimo");
            System.out.println("4. Realizar devolução");
            System.out.println("5. Sair");
            System.out.println("======================================");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            executarOpcao(opcao);
            if (opcao == 5) { 
                break;
            }
        }
    }
    
    public void executarOpcao(int opcao) {
    	try {
    		switch (opcao) {
            case 1:
                System.out.println(biblioteca.listarEmprestimosPorUsuario(idUsuario));
                break;

            case 2:
                System.out.println("Livros no catálogo: ");
                System.out.println(biblioteca.listarLivros());
                break;

            case 3:
                System.out.print("\nID do livro: ");
                String idLivro = scanner.nextLine();
                biblioteca.emprestarLivro(idLivro, idUsuario);
                System.out.println("Empréstimo realizado com sucesso!");
                break;

            case 4:
                System.out.print("ID do livro: ");
                idLivro = scanner.nextLine();
                biblioteca.devolverLivro(idLivro);
                System.out.println("Devolução realizada com sucesso!");
                break;

            case 5:
                System.out.println("Saindo...");
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    	} catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

