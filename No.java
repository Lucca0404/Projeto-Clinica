public class No {
    
    Pessoa dados;
    No prox;
    No ant;
    int peso;

    No(){

    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public Pessoa getDados() {
        return this.dados;
    }
    public void setDados(Pessoa dados) {
        this.dados = dados;
    }
    public No getProx() {
        return this.prox;
    }
    public void setProx(No prox) {
        this.prox = prox;
    }
    public No getAnt() {
        return this.ant;
    }
    public void setAnt(No ant) {
        this.ant = ant;
    }

}
