public abstract class Pessoa {
    
    protected String nome;
    protected String cpf;
    protected int idade;

    private boolean validarCpf(String cpf){
        int soma = 0;
        int i;
        if(cpf.length() != 11){
            return false;
        }
        
        //validar primeiro dígito
        for(i = 0; i < cpf.length()-2; i++){
            soma+= Character.getNumericValue(cpf.charAt(i)) * (i + 1);
        }
        soma %= 11;
        if(soma == 10){
            soma = 0;
        }
        if(soma != Character.getNumericValue(cpf.charAt(i))){
            return false;
        }
        //validar segunda dígito
        soma = 0;
        for(i = 0; i < cpf.length()-1; i++){
            soma+= Character.getNumericValue(cpf.charAt(i)) * i;
        }
        soma %= 11;
        if(soma == 10){
            soma = 0;
        }
        if(soma != Character.getNumericValue(cpf.charAt(i))){
            return false;
        }
        return true;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String cpf) {
        if(!validarCpf(cpf)){
            System.out.println("CPF inválido");
        }
        this.cpf = cpf;
    }
    public int getIdade() {
        return this.idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public abstract void mostrar();

}
