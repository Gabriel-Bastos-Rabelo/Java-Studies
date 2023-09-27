import java.util.ArrayList;


public class Vendedor extends Funcionario{
    protected float taxaComissao;
    ArrayList<Vendas> vendas = new ArrayList<Vendas>();

    public Vendedor(String cpf, String nome, float salario, Departamento departamento, float taxaComissao){
        super(cpf, nome, salario, departamento);
        this.taxaComissao = taxaComissao;
        
    }

    public float calcularSalario(){

        //ainda tenho que pegar o total de vendas
        return super.salario + (taxaComissao);
    }

    public void setVendas(String data, float valor, boolean status){
        Vendas vendaNova = new Vendas(data, valor, status);
        vendas.add(vendaNova);
    }
}
