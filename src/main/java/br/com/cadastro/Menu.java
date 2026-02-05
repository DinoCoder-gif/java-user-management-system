package br.com.cadastro;

import java.util.Scanner;

public class Menu {
    private UsuarioService service = new UsuarioService();
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1 -Cadastrar usuario");
            System.out.println("2 - Listar usuarios");
            System.out.println("3 - Buscar usuarios por ID");
            System.out.println("4 - Atualizar usuario");
            System.out.println("5 - Remover usuario");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); //limpar buffer

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    service.listarUsuarios();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    atualizar();
                    break;
                case 5:
                    remover();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }while (opcao != 0);
    }
    private void cadastrar() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        service.cadastrarUsuario(nome, email);
    }
    private void buscar() {
        System.out.print("ID do usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario = service.buscarPorId(id);
        if (usuario == null) {
            System.out.println("Usuario não encontrado");
        }else {
            System.out.println(usuario);
        }
    }
    private void atualizar() {
        System.out.print("ID do usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo email; ");
        String email = scanner.nextLine();

        service.atualizarUsuario(id, nome, email);
    }
    private void remover() {
        System.out.print("ID do usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        service.removerUsuario(id);
    }
}
