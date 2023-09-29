package Model;

public class Entregador extends Funcionario{
    private float periculosidade;

    public Entregador(String cpf, String nome, float salario, Departamento departamento, float periculosidade){
        super(cpf, nome, salario, departamento);
        this.periculosidade = periculosidade;
    }


    public String gerarContraCheque(){
        String result = "";
        result +=  super.gerarContraCheque() + "Adicional de periculosidade: R$" + periculosidade + "\n";
        result += "Total: R$" + (salario + periculosidade) + "\n";

        return result;

    }

    public void setTaxaPericulosidade(float value){
        this.periculosidade = value;
    }
}
