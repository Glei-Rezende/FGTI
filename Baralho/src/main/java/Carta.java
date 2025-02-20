public class Carta {
    private String nome;
    private String naipe;

    // Construtor
    public Carta(String nome, String naipe) {
        this.nome = nome;
        this.naipe = naipe;
    }

    // Métodos GET
    public String getNome() {
        return nome;
    }

    public String getNaipe() {
        return naipe;
    }

    // Métodos SET
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    @Override
    public String toString() {
        return nome + " de " + naipe;
    }
}
