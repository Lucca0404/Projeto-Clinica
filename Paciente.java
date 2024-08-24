public class Paciente extends Pessoa{
    
    private boolean ativo;
    
    Paciente(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
        this.ativo = true;
        
    }

    public boolean isAtivo() {
        return ativo;
    }
    public void desativar() {
        if(this.ativo == false){
            System.out.println("O paciente já está desativado");
            return;
        }
        this.ativo = false;
    }
    public void ativar(){
        if(this.ativo == true){
            System.out.println("O paciente já está ativo");
            return;
        }
        this.ativo = true;
    }

    public void mostrar(){
        System.out.println("Nome: " + this.nome + "\nIdade: " + this.idade + "\nCPF: " + this.cpf + "\nAtivo: " + this.ativo);
    }

}
