public class PessoaJuridica {
    private String cnpj;
    private String nome;
    private String endereco;
    private String email;
    private String inscricaoEstadual;
    private String razaoSocial;


   

    public PessoaJuridica(String cnpj, String nome, String endereco, String email, String inscricaoEstadual, String razaoSocial){
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.inscricaoEstadual = inscricaoEstadual;
        this.razaoSocial = razaoSocial;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCnpj(){

        return this.cnpj;
    }

    public String toString() {
        return "CNPJ: " + cnpj + "\nNome: " + nome + "\nEndereço: " + endereco + "\nEmail: " + email + "\nInscrição estadual: " + inscricaoEstadual + "\nRazão Social: " + razaoSocial;
    }
}
