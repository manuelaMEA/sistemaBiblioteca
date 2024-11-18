package ui;

import java.util.Scanner;
import negocio.Biblioteca;
import negocio.Usuario;
import negocio.UsuarioCliente;
import negocio.UsuarioAdmin;

public class Menu{
    protected Biblioteca biblioteca;
    protected Scanner scanner;

    public Menu(Biblioteca biblioteca, Scanner scanner) {
        this.biblioteca = biblioteca;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("\nBem Vindo(a) à Paplioteca!");
            System.out.println("======================================");
            System.out.println("1. Acessar como usuário");
            System.out.println("2. Acessar como administrador");
            System.out.println("3. Sair");
            System.out.println("======================================");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            if (opcao == 3) {
                System.out.println("Saindo...");
                return;
            }
            executarOpcao(opcao);
        }
    }    
    
    public void executarOpcao(int opcao) {
    	try {
    		String idUsuario;
            String senha;
            Usuario usuario;
            switch (opcao) {
            case 1:
            	System.out.print("\nLogin\n");
            	System.out.print("ID do usuário: ");
                idUsuario = scanner.nextLine();
                System.out.print("Senha do usuário: ");
                senha = scanner.nextLine();
            	usuario = biblioteca.fazerLogin(idUsuario, senha);
            	if (usuario instanceof UsuarioCliente) {
            		MenuCliente menuCliente = new MenuCliente(biblioteca, scanner, idUsuario);
                    menuCliente.exibirMenu();
            	}
            	else
            		throw new RuntimeException("Acesso Negado.");
            	break;
            case 2:
            	System.out.print("\nLogin\n");
            	System.out.print("ID do usuário: ");
                idUsuario = scanner.nextLine();
                System.out.print("Senha do usuário: ");
                senha = scanner.nextLine();
            	usuario = biblioteca.fazerLogin(idUsuario, senha);
            	if (usuario instanceof UsuarioAdmin) {
            		MenuAdministrador menuAdmin = new MenuAdministrador(biblioteca, scanner);
                    menuAdmin.exibirMenu();
            	}
            	else
            		throw new RuntimeException("Acesso Negado.");      	               	
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    	} catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
    }
}

