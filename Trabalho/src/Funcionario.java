import java.util.ArrayList;


public class Funcionario {
    protected String cpf;
    protected String nome;
    protected float salario;
    protected Departamento departamento;
    ArrayList<Beneficios> listaDeBeneficios = new ArrayList<Beneficios>();
    ArrayList<Desconto> listaDeDescontos = new ArrayList<Desconto>();

    public Funcionario(String cpf, String nome, float salario, Departamento departamento){
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
        
    }


    public void setListaDeDescontos(String nome, float valorPerc, float valorNum){

        if(valorPerc == -1){
            Desconto descontoNovo = new Desconto(nome, -1, valorNum);
            listaDeDescontos.add(descontoNovo);
        }
        else{
            Desconto descontoNovo = new Desconto(nome, valorPerc, -1);
            listaDeDescontos.add(descontoNovo);
        }

        
        
    }


    public void setListaDeBeneficios(String nome, float value){
        Beneficios beneficioNovo = new Beneficios(nome, value);
        listaDeBeneficios.add(beneficioNovo);
    }


    public float calcularSalario(){
        return salario;
    }
    
}
