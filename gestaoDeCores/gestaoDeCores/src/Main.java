import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FormaManager formaManager = new FormaManager();

        List<String> coresValidas = Arrays.asList(
                "VERMELHO", "VERDE", "AZUL", "AMARELO", "PRETO", "BRANCO\n",
                "LARANJA", "ROSA", "CIANO", "MAGENTA", "CINZA", "MARROM\n",
                "VIOLETA", "DOURADO", "PRATA", "TURQUESA",
                "BEGE", "LAVANDA\n", "SALMON", "OLIVA", "PÚRPURA",
                "SIENA\n", "CARAMELO", "AZUL CLARO", "VERDE LIMÃO", "AMETISTA"
        ).stream().map(String::toUpperCase).collect(Collectors.toList());

        while (true) {
            System.out.print("Digite o nome da cor (ou 'sair' para encerrar): ");
            String nomeCor = scanner.nextLine().toUpperCase();
            if (nomeCor.equalsIgnoreCase("sair")) {
                break;
            }

            if (nomeCor.trim().isEmpty()) {
                System.out.println("Erro: O nome da cor não pode ser vazio. Tente novamente.");
                continue;
            }


            if (!coresValidas.contains(nomeCor)) {
                System.out.println("Erro: Cor inválida. As cores permitidas são: " + coresValidas);
                continue;
            }

            System.out.print("Digite a posição (ex: 10,20): ");
            String posicao = scanner.nextLine();

            int tamanho = -1;
            while (tamanho < 0) {
                System.out.print("Digite o tamanho (número positivo): ");
                try {
                    tamanho = Integer.parseInt(scanner.nextLine());

                    if (tamanho < 0) {
                        System.out.println("Erro: O tamanho não pode ser negativo. Tente novamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Erro: Entrada inválida. Por favor, insira um número inteiro.");
                }
            }

            formaManager.addForma(nomeCor, posicao, tamanho);
        }

        System.out.println("\nFormas adicionadas:");
        formaManager.apresentar();
        scanner.close();
    }
}
