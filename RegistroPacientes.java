import java.lang.Math;

public class RegistroPacientes implements HashMap{
    
    private int tamanho;
    private int numeroDePacientes;
    private Pessoa[] itens;

    RegistroPacientes(int tamanho){
        this.tamanho = tamanho;
        this.numeroDePacientes = 0;
        this.itens = new Pessoa[tamanho];
    }
    public int tamanho(){
        return this.numeroDePacientes;
    }
    public boolean inserir(Pessoa p){
        if(p.cpf == null){
            System.out.println("Pessoa sem CPF cadastrado");
            return false;
        }
        if(this.pertence(p.cpf) || this.cheio()){
            return false;
        }
        int chave = valorString(p.cpf);
        int pos = metodoDivisao(chave, this.tamanho);
        if(this.itens[pos] == null){
            this.itens[pos] = p;
            return true;
        }
        int newPos;
        for(int i = 0; i < this.tamanho; i++){
            newPos = sondagemLinear(pos, i, this.tamanho);
            if(this.itens[newPos] == null || this.itens[newPos].ativo == false){
                this.itens[newPos] = p;
                this.numeroDePacientes++;
                return true;
            }
        }
        System.out.println("Ocorreu um erro na inserção");
        return false;
    }
    public Pessoa buscar(String cpf){
        int valor = valorString(cpf);
        int pos = metodoDivisao(valor, this.tamanho);
        if(this.itens[pos] == null){
            System.out.println("Paciente não está cadastrado");
            return null;
        }
        if(this.itens[pos].cpf == cpf){
            return this.itens[pos];
        }
        int newPos;
        for(int i = 0; i < this.tamanho; i++){
            newPos = sondagemLinear(pos, i, this.tamanho);
            if(this.itens[newPos].cpf == cpf){
                return this.itens[newPos];
            }
        }
        System.out.println("Ocorreu um erro na busca");
        return null;
    }
    public int valorString(String cpf){
        int valor = 7;
        for(int i = 0; i < cpf.length(); i++){
            valor = 31 * valor + (int) cpf.charAt(i);
        }
        return valor;
    }
    public int metodoDivisao(int chave, int tamanho){
        return Math.abs(chave) % tamanho;
    }
    public int sondagemLinear(int pos, int i, int tamanho){
        return Math.abs((pos + i)) % tamanho;
    }
    public boolean pertence(String cpf){
        int valor = valorString(cpf);
        int pos = metodoDivisao(valor, this.tamanho);
        return (this.itens[pos] != null);
    }
    public boolean cheio(){
        return (this.numeroDePacientes == this.tamanho);
    }
}
