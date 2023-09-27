public class Presenter {

    ArrayList<Funcionario> ListaFuncionarios = new ArrayList<Funcionario>();

    public void cadastroFuncionario(String cpf, String name, float salario, String departamento){
        Departamento cadastroDepartamento = new Departamento(departamento);
        Funcionario novoFuncionario = new Funcionario(cpf, name, salario, cadastroDepartamento);
        ListaFuncionarios.add(novoFuncionario);

    }

    public void cadastroEntregador(String cpf, String name, float salario, String departamento, float periculosidade){
        Departamento cadastroDepartamento = new Departamento(departamento);
        Entregador = novoEntregador = new Entregador(cpf, name, salario, departamento, periculosidade);
        ListaFuncionarios.add(novoEntregador);
    }

    public void cadastroAdministrador(String cpf, String name, float salario, String departamento, float bonusChefia){

        Departamento cadastroDepartamento = new Departamento(departamento);
        Administrador novoAdministrador = new Admistrador(cpf, name, salario, departamento, bonusChefia);
        ListaFuncionarios.add(novoAdministrador);

    }

    public void cadastroVendedor(String cpf, String name, float salario, String departamento, float taxaComissao){

        Departamento cadastroDepartamento = new Departamento(departamento);
        Vendedor novoVendedor = new Vendedor(cpf, name, salario, departamento, taxaComissao);
        ListaFuncionarios.add(novoVendedor);

    }

    public float folhaPagamento(){
        //imagino que seja para varrer o array, e para cada funcionario, obter o salario com o metodo calcularSalario
        //e soma isso a uma variavel "total"
    }
}
