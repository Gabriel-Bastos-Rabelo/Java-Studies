public class Vendedor extends Funcionario{
    protected float taxaComissao;
    ArrayList<Vendas> vendas = new ArrayList<Vendas>();

    public Vendedor(String cpf, String nome, float salario, Departamento departamento, float taxaComissao){
        super(cpf, nome, salario, departamento);
        this.taxaComissao = taxaComissao;
        this.vendas = 0;
    }

    public float calcularSalario(){
        return salario + (taxaComissao * vendas);
    }

    public setVendas(String data, float valor, boolean status){
        Vendas vendaNova = new Vendas(data, valor, status);
        vendas.add(vendaNova);
    }
}
