public interface HashMap {
    
    public boolean inserir(Pessoa p);

    public Pessoa buscar(String cpf);

    public int valorString(String cpf);

    public int metodoDivisao(int chave, int tamanho);

    public int sondagemLinear(int pos, int i, int tamanho);

    public boolean pertence(String cpf);

}
