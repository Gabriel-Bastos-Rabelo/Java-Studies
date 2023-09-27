public class Administrador {
    private float bonusChefia;


    public Administrador(String cpf, String nome, float salario, Departamento departamento, float bonusChefia){
        super(cpf, nome, salario, departamento);
        this.bonusChefia = bonusChefia;
    }


    public float calcularSalario(){
        return salario + bonusChefia;
    }
}
