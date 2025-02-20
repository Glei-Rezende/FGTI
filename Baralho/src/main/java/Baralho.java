import java.util.ArrayList;
import java.util.List;

public class Baralho {
    private List<Carta> cartas;

    // Construtor
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

    // Método para exibir todas as cartas do baralho
    public void exibirBaralho() {
        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }

    // Método main para executar o programa
    public static void main(String[] args) {
        Baralho baralho = new Baralho();
        baralho.exibirBaralho();
    }
}
