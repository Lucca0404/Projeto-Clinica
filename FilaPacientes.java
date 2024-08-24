public class FilaPacientes implements FilaPrioridade{
    
    private No inicio;
    private No fim;
    private int numeroDePacientes;

    FilaPacientes(){

    }

    public int tamanho(){
        return this.numeroDePacientes;
    }

    public boolean ehVazia(){
        return (this.numeroDePacientes == 0);
    }

    public boolean ehCheia(){
        return false;
    }

    public boolean inserir(Pessoa p, int peso){
        No n1 = new No();
        n1.setDados(p);
        n1.setPeso(peso);
        if(this.inicio == null){
            n1.setAnt(null);
            n1.setProx(null);
            this.fim = n1;
            this.inicio = n1;
        }
        else if(this.inicio.getPeso() >= peso){
            n1.setAnt(null);
            n1.setProx(this.inicio);
            this.inicio.setAnt(n1);
            this.inicio = n1;
        }
        else{
            No aux = this.inicio;
            while(aux != this.fim && n1.getPeso() > aux.getPeso()){
                aux = aux.getProx();
            }
            n1.setAnt(aux);
            n1.setProx(aux.getProx());
            aux.setProx(n1);
            if(aux == this.fim){
                this.fim = n1;
            }
        }
        this.numeroDePacientes++;
        return true;
    }

    public boolean remover(){
        if(this.ehVazia()){
            System.out.println("Fila já está vazia");
            return false;
        }
        No aux = this.fim;
        if(this.fim == this.inicio){
            this.inicio = null;
            this.fim = null;
        }
        else{
            aux.getAnt().setProx(null);
            this.fim = aux.getAnt();
        }
        this.numeroDePacientes--;
        return true;
    }

    public void getProximo(){
        if(this.ehVazia()){
            System.out.println("A fila está vazia");
            return;
        }
        System.out.println(this.fim.dados.nome);
    }
}
