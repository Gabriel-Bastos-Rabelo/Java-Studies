public class PessoaFisica {

    private String cpf;
    private String nome;
    private String endereco;
    private String dataNascimento;
    private String email;
    private String estadoCivil;

    public PessoaFisica(String cpf, String nome, String endereco, String dataNascimento, String email,
            String estadoCivil) {

        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.estadoCivil = estadoCivil;

    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String toString() {
        return "CPF: " + cpf + "\nNome: " + nome + "\nEndereço: " + endereco + "\nData de Nascimento: " + dataNascimento
                + "\nEmail: " + email + "\nEstado Civil: " + estadoCivil;
    }
}
