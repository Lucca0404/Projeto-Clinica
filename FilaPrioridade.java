public interface FilaPrioridade {

    public int tamanho();

    public boolean ehVazia();

    public boolean ehCheia();

    public boolean inserir(Pessoa p, int peso);

    public boolean remover();

    public void getProximo();

}
