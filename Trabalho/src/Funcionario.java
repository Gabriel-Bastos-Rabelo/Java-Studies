public class Funcionario {
    protected String cpf;
    protected String nome;
    protected float salario;
    protected Departamento departamento;
    ArrayList<Beneficios> listaDeBeneficios = new ArrayList<Beneficios>();
    ArrayList<Descontos> listaDeDescontos = new ArrayList<Descontos>();

    public Funcionario(String cpf, String nome, float salario, Departamento departamento){
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
        
    }


    public setListaDeDescontos(String nome, float valorPerc, float valorNum){

        if(valorPerc == -1){
            Desconto descontoNovo = new Desconto(nome, -1, valorNum);
        }
        else{
            Desconto descontoNovo = new Desconto(nome, valoPerc, -1);
        }

        listaDeDescontos.add(descontoNovo);
        
    }


    public setListaDeBeneficios(String nome, float value){
        Beneficios beneficioNovo = new Beneficio(nome, value);
        listaDeBeneficios.add(beneficioNovo);
    }


    public calcularSalario(){
        return salario;
    }
    
}
