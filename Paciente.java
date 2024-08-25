public class Paciente extends Pessoa{
    
    Paciente(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
        this.ativo = true;
        
    }
    
    public void mostrar(){
        System.out.println("Nome: " + this.nome + "\nIdade: " + this.idade + "\nCPF: " + this.cpf + "\nAtivo: " + this.ativo);
    }

}
