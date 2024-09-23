package Sistema;

import java.util.Scanner;

public class mainSistema {

	public static void main(String[] args) {
		
		String senha;
		String idUsuario;
		
		Biblioteca biblioteca = new Biblioteca();
		RepositorioUsuarios repositorioUsuarios = new RepositorioUsuarios();
		Scanner scanner = new Scanner(System.in);
		
		Livro livro0 = new Livro("978-6-3258-9681-8", "Amanhecer", "Stefani Neves");
		biblioteca.adicionarLivros(livro0);
		Livro livro1 = new Livro("978-7-3291-1555-4", "Entardecer", "Stefani Neves");
		biblioteca.adicionarLivros(livro1);
		Livro livro2 = new Livro("978-4-3193-7896-8", "Anoitecer", "Stefani Neves");
		biblioteca.adicionarLivros(livro2);
		Livro livro3 = new Livro("978-8-0902-9295-6", "96 Tons de Carmin", "M.C. Benevides");
		biblioteca.adicionarLivros(livro3);
		Livro livro4 = new Livro("978-6-6204-4114-0", "É Assim que Continua", "M.C. Benevides");
		biblioteca.adicionarLivros(livro4);
		Livro livro5 = new Livro("978-9-3952-3913-4", "Anna Bella", "Lucas S. Alves");
		biblioteca.adicionarLivros(livro5);
		Livro livro6 = new Livro("978-0-9189-7738-0", "Bozo, o Palhazo Assassino", "Lucas S. Alves");
		biblioteca.adicionarLivros(livro6);
		Livro livro7 = new Livro("978-2-9883-4867-1", "Adotada", "Lucas S. Alves");
		biblioteca.adicionarLivros(livro7);
		Livro livro8 = new Livro("978-2-7045-1758-9", "O Depois", "Mary Lane");
		biblioteca.adicionarLivros(livro8);
		Livro livro9 = new Livro("978-6-2279-9756-9", "A resposta", "Emanuel J. Douglas");
		biblioteca.adicionarLivros(livro9);
		
		Usuario usuario0 = new Usuario("2024005676", "Manuela Menezes Alves", "abc123");
		biblioteca.adicionarUsuarios(usuario0);
		Usuario usuario1 = new Usuario("2024002114", "Helio Rodrigues Carvalho", "helio123");
		biblioteca.adicionarUsuarios(usuario1);
		
		while (true) {
            System.out.println("\nBem Vindo(a) ao Sistema Bibliotecário!");
            System.out.println("======================================");
            System.out.println("1. Acessar como usuário");
            System.out.println("2. Acessar como administrador");
            System.out.println("3. Sair");
            System.out.println("======================================");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();             

            switch (opcao) {
                case 1:
                	System.out.print("\nLogin\n");
                	System.out.print("ID do usuário: ");
                    idUsuario = scanner.nextLine();
                    System.out.print("Senha do usuário: ");
                    senha = scanner.nextLine();
                    Usuario userLogin = biblioteca.fazerLogin(idUsuario, senha);
                    if(userLogin == null) {                	
                    }
                    else {
                    	userMenu(biblioteca, repositorioUsuarios, scanner, idUsuario);
                    }     	        
                    break;
                case 2:
                	adminMenu(biblioteca, repositorioUsuarios, scanner);       	               	
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
		
}
	
	private static void adminMenu(Biblioteca biblioteca, RepositorioUsuarios repositorioUsuarios, Scanner scanner) {
		String senha;
		String idLivro;
		String idUsuario;
		while (true) {
		    System.out.println("\nMODO ADMINISTRADOR");
		    System.out.println("======================================");
		    System.out.println("1. Adicionar Livro");
		    System.out.println("2. Cadastrar Usuário");
		    System.out.println("3. Listar Livros");
		    System.out.println("4. Listar Usuários");
		    System.out.println("5. Listar empréstimos");
		    System.out.println("6. Sair");
		    System.out.println("======================================");
		    System.out.print("Escolha uma opção: ");
		    int opcao = scanner.nextInt();
		    scanner.nextLine();             

		    switch (opcao) {
		        case 1:
		            System.out.print("\nTítulo do livro: ");
		            String titulo = scanner.nextLine();
		            System.out.print("Autor do livro: ");
		            String autor = scanner.nextLine();
		            System.out.print("ISBN do livro: ");
		            idLivro = scanner.nextLine();
		            Livro livro = new Livro(idLivro, titulo, autor);
		            biblioteca.adicionarLivros(livro);
		            System.out.println("Livro adicionado com sucesso!");
		            break;
		        case 2:
		            System.out.print("\nNome do usuário: ");
		            String nome = scanner.nextLine();
		            System.out.print("ID do usuário: ");
		            idUsuario = scanner.nextLine();
		            System.out.print("Senha do usuário: ");
		            senha = scanner.nextLine();
		            Usuario usuario = new Usuario(idUsuario, nome, senha);
		            biblioteca.adicionarUsuarios(usuario);
		            System.out.println("Usuário cadastrado com sucesso!");
		            break;
		        case 3:
		        	biblioteca.listarLivros();
		            break;
		        case 4:
		            biblioteca.listarUsuarios();
		            break;
		        case 5:
		            biblioteca.listarEmprestimos();
		            break;
		        case 6:
		            System.out.println("Saindo...");
		            return;
		        default:
		            System.out.println("Opção inválida. Tente novamente.");
		    }
	

	
}
	}
	
	private static void userMenu(Biblioteca biblioteca, RepositorioUsuarios repositorioUsuarios, Scanner scanner, String idUsuario) {
		String idLivro;
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
  
        switch (opcao) {
            case 1:
                biblioteca.listarEmprestimosPorUsuario(idUsuario);
                break;
            case 2:
	        	biblioteca.listarLivros();
	            break;
            case 3:
                System.out.print("\nID do livro: ");
                idLivro = scanner.nextLine();
                biblioteca.emprestarLivro(idLivro, idUsuario);
                break;
            case 4:
                System.out.print("ID do livro: ");
                idLivro = scanner.nextLine();
                biblioteca.devolverLivro(idLivro);
                break;

            case 5:
                System.out.println("Saindo...");
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
        }

	
	

	
}
	}
	

