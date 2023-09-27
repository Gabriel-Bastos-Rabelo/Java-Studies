public class Entregador {
    private float periculosidade;

    public Entregador(String cpf, String nome, float salario, Departamento departamento, float periculosidade){
        super(cpf, nome, salario, departamento);
        this.periculosidade = periculosidade;
    }


    public float calcularSalario(){
        return salario + periculosidade;
    }
}
