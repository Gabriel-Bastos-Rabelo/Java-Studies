package Model;

public class Administrador extends Funcionario{
    private float bonusChefia;


    public Administrador(String cpf, String nome, float salario, Departamento departamento, float bonusChefia){
        super(cpf, nome, salario, departamento);
        this.bonusChefia = bonusChefia;
    }



    public String gerarContraCheque(){
        String result = "";
        result += super.gerarContraCheque() + "Adicional de bônus de chefia: R$" + bonusChefia + "\n";
        result += "Total: " + (salario + bonusChefia) + "\n";


        return result;
    }

    public void setBonus(float value){
        this.bonusChefia = value;
    }
}
