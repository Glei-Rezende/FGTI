import java.util.ArrayList;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    // Método Construtor
    public Baralho() {
        cartas = new ArrayList<>();
        String[] naipes = {"Copas", "Ouros", "Paus", "Espadas"};
        String[] nomes = {"Ás", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei"};

        // Adiciona as 52 cartas regulares
        for (String naipe : naipes) {
            for (String nome : nomes) {
                cartas.add(new Carta(nome, naipe));
            }
        }

        // Adiciona os 4 coringas
        for (int i = 0; i < 4; i++) {
            cartas.add(new Carta("Coringa", "Coringa"));
        }
    }

    // Método para embaralhar as cartas
    public void embaralhar() {
        int tamanhoBaralho = cartas.size();

        // Repetir o processo de troca várias vezes
        for (int i = 0; i < 1000; i++) {
            // Sorteia duas posições aleatórias
            int posicao1 = (int) (Math.random() * tamanhoBaralho);
            int posicao2 = (int) (Math.random() * tamanhoBaralho);

            // Troca as cartas nas posições sorteadas
            Carta temp = cartas.get(posicao1);
            cartas.set(posicao1, cartas.get(posicao2));
            cartas.set(posicao2, temp);
        }
    }

    // Método para distribuir uma carta do topo do baralho
    public Carta distribuirCarta() {
        if (haCarta()) {
            // Remove e retorna a última carta do baralho (topo)
            return cartas.remove(cartas.size() - 1);
        } else {
            // Retorna null se o baralho estiver vazio
            return null;
        }
    }

    // Método para verificar se há cartas no baralho
    public boolean haCarta() {
        return !cartas.isEmpty();
    }

    // Método para imprimir o baralho de forma organizada
    public void imprimirBaralho() {
        System.out.println("Cartas no baralho:");
        for (int i = 0; i < cartas.size(); i++) {
            System.out.print(cartas.get(i) + " | ");
            // Quebra de linha a cada 13 cartas para melhor visualização
            if ((i + 1) % 13 == 0) {
                System.out.println();
            }
        }
        System.out.println(); // Pula uma linha no final
    }

    // Método main para executar o programa
    public static void main(String[] args) {
        Baralho baralho = new Baralho();

        System.out.println("Baralho inicial:");
        baralho.imprimirBaralho();

        // Embaralha o baralho
        baralho.embaralhar();

        System.out.println("Baralho após embaralhar:");
        baralho.imprimirBaralho();

        // Distribui algumas cartas
        System.out.println("Distribuindo cartas:");
        for (int i = 0; i < 5; i++) {
            Carta carta = baralho.distribuirCarta();
            if (carta != null) {
                System.out.println("Carta distribuída: " + carta);
            } else {
                System.out.println("Não há mais cartas no baralho.");
            }
        }

        // Verifica se ainda há cartas no baralho
        System.out.println("\nAinda há cartas no baralho? " + baralho.haCarta());

        // Imprime o baralho após distribuir cartas
        System.out.println("Baralho após distribuir cartas:");
        baralho.imprimirBaralho();
    }
}