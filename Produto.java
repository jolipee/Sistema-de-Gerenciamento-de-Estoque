public class Produto {
    private int id;
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(int id, String nome, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

public int getId(){
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }


    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Quantidade: " + quantidade + " | Preço: R$" + preco;
    }
}
