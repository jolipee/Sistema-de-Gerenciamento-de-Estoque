import java.util.*;

public class Estoque {
    private static List<Produto> produtos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int proximoId = 1;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n--- SISTEMA DE ESTOQUE ---");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Remover Produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> listarProdutos();
                case 3 -> atualizarProduto();
                case 4 -> removerProduto();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 5);
    }

    private static void cadastrarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        Produto novo = new Produto(proximoId++, nome, quantidade, preco);
        produtos.add(novo);
        System.out.println("Produto cadastrado!");
    }

    private static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    private static void atualizarProduto() {
        System.out.print("ID do produto que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Produto p : produtos) {
            if (p.getId() == id) {
                System.out.print("Novo nome: ");
                p.setNome(scanner.nextLine());
                System.out.print("Nova quantidade: ");
                p.setQuantidade(scanner.nextInt());
                System.out.print("Novo preço: ");
                p.setPreco(scanner.nextDouble());
                System.out.println("Produto atualizado!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    private static void removerProduto() {
        System.out.print("ID do produto que deseja remover: ");
        int id = scanner.nextInt();

        produtos.removeIf(p -> p.getId() == id);
        System.out.println("Produto removido (se existia).");
    }
}
