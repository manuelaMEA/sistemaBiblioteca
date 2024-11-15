package ui;

import negocio.Biblioteca;
import negocio.Livro;
import java.util.Scanner;
import negocio.UsuarioCliente;

public class MenuAdministrador {
	
	protected Biblioteca biblioteca;
    protected Scanner scanner;

    public MenuAdministrador(Biblioteca biblioteca, Scanner scanner) {
    	this.biblioteca = biblioteca;
        this.scanner = scanner;
    }

  
    public void exibirMenu() {
        while (true) {
            System.out.println("\nMODO ADMINISTRADOR");
            System.out.println("======================================");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Listar Livros");
            System.out.println("4. Listar Usuários");
            System.out.println("5. Listar Empréstimos");
            System.out.println("6. Sair");
            System.out.println("======================================");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            executarOpcao(opcao);
            if (opcao == 6) { 
                break;
            }
        }
    }

    
    public void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                System.out.print("\nTítulo do livro: ");
                String titulo = scanner.nextLine();
                System.out.print("Autor do livro: ");
                String autor = scanner.nextLine();
                System.out.print("ISBN do livro: ");
                String idLivro = scanner.nextLine();
                Livro livro = new Livro(idLivro, titulo, autor);
                biblioteca.adicionarLivros(livro);
                System.out.println("Livro adicionado com sucesso!");
                break;

            case 2:
                System.out.print("\nNome do usuário: ");
                String nome = scanner.nextLine();
                System.out.print("ID do usuário: ");
                String idUsuario = scanner.nextLine();
                System.out.print("Senha do usuário: ");
                String senha = scanner.nextLine();
                UsuarioCliente usuario = new UsuarioCliente(idUsuario, nome, senha);
                biblioteca.adicionarUsuarios(usuario);
                System.out.println("Usuário cadastrado com sucesso!");
                break;

            case 3:
                System.out.println("Livros no catálogo: ");
                System.out.println(biblioteca.listarLivros());
                break;

            case 4:
                System.out.println("Usuários cadastrados:");
                System.out.println(biblioteca.listarUsuarios());
                break;

            case 5:
                System.out.println("Empréstimos: ");
                System.out.println(biblioteca.listarEmprestimos());
                break;

            case 6:
                System.out.println("Saindo...");
                return;

            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
