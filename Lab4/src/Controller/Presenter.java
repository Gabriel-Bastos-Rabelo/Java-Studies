package Controller;

import java.util.ArrayList;

import Model.Funcionario;
import Model.Departamento;
import Model.Entregador;
import Model.Vendedor;
import Model.Administrador;
import Model.Beneficios;
import Model.Desconto;
import Model.Vendas;

public class Presenter {

    ArrayList<Funcionario> ListaFuncionarios;

    public Presenter() {
        ListaFuncionarios = new ArrayList<Funcionario>();
    }

    public Funcionario cadastroFuncionario(String cpf, String name, float salario, String departamento) {
        Departamento cadastroDepartamento = new Departamento(departamento);
        Funcionario novoFuncionario = new Funcionario(cpf, name, salario, cadastroDepartamento);
        ListaFuncionarios.add(novoFuncionario);
        return novoFuncionario;

    }

    public Entregador cadastroEntregador(String cpf, String name, float salario, String departamento,
            float periculosidade) {
        Departamento cadastroDepartamento = new Departamento(departamento);
        Entregador novoEntregador = new Entregador(cpf, name, salario, cadastroDepartamento, periculosidade);
        ListaFuncionarios.add(novoEntregador);
        return novoEntregador;
    }

    public Administrador cadastroAdministrador(String cpf, String name, float salario, String departamento,
            float bonusChefia) {

        Departamento cadastroDepartamento = new Departamento(departamento);
        Administrador novoAdministrador = new Administrador(cpf, name, salario, cadastroDepartamento, bonusChefia);
        ListaFuncionarios.add(novoAdministrador);
        return novoAdministrador;

    }

    public Vendedor cadastroVendedor(String cpf, String name, float salario, String departamento, float taxaComissao) {

        Departamento cadastroDepartamento = new Departamento(departamento);
        Vendedor novoVendedor = new Vendedor(cpf, name, salario, cadastroDepartamento, taxaComissao);
        ListaFuncionarios.add(novoVendedor);
        return novoVendedor;

    }

    public float folhaPagamento() {
    
        float total = 0;
        for (Funcionario funcionario : ListaFuncionarios) {
            total += funcionario.calcularSalario();
        }

        return total;
    }

    public String ContraCheque(String nome, String cpf) {

        String nomeFuncionario;
        String cpfFuncionario;

        for (Funcionario funcionario : ListaFuncionarios) {
            nomeFuncionario = funcionario.getNome();
            cpfFuncionario = funcionario.getCpf();
            if (nome.equalsIgnoreCase(nomeFuncionario) && cpf.equalsIgnoreCase(cpfFuncionario)) {
                return funcionario.gerarContraCheque();

            }

        }

        return "Não foi possível achar funcionários com o nome ou com o cpf informado";
    }

    public boolean cadastroBeneficio(String nome, String cpf, String nomeBeneficio, float valorNum) {
        for (Funcionario funcionario : ListaFuncionarios) {
            if (nome.equalsIgnoreCase(funcionario.getNome()) && cpf.equalsIgnoreCase(funcionario.getCpf())) {
                funcionario.setListaDeBeneficios(nomeBeneficio, valorNum);
                return true;
            }
        }

        return false;
    }

    public boolean cadastroDesconto(String nome, String cpf, String nomeDesconto, float valorPerc, float valorNum) {
        for (Funcionario funcionario : ListaFuncionarios) {
            if (nome.equalsIgnoreCase(funcionario.getNome()) && cpf.equalsIgnoreCase(funcionario.getCpf())) {
                funcionario.setListaDeDescontos(nomeDesconto, valorPerc, valorNum);
                return true;
            }
        }

        return false;
    }

    public boolean cadastroVenda(String nome, String cpf, String data, float valor, boolean status) {
        for (Funcionario funcionario : ListaFuncionarios) {
            if (nome.equalsIgnoreCase(funcionario.getNome()) && cpf.equalsIgnoreCase(funcionario.getCpf())) {
                if (funcionario instanceof Vendedor) {
                    ((Vendedor) funcionario).setVendas(data, valor, status);

                    return true;
                }

                return false;

            }
        }

        return false;
    }

    public String verificarVendas(String nome, String cpf){
        for (Funcionario funcionario : ListaFuncionarios) {
            if (nome.equalsIgnoreCase(funcionario.getNome()) && cpf.equalsIgnoreCase(funcionario.getCpf())) {
                if (funcionario instanceof Vendedor) {
                    String result = "Histórico de vendas\n";
                    ArrayList<Vendas> historicoVendas = ((Vendedor) funcionario).getVendas();
                    for(Vendas venda : historicoVendas){
                        result += "Data: " + venda.getDate()  + "\n";
                        result += "Valor: " + venda.getValor() + "\n";
                        result += "Status: " + venda.getStatus() + "\n" + "\n";
                    }

                    return result;

                    
                }

                

            }
        }

        return "Não foi possível achar vendedor com o nome e o CPF fornecidos";
    }


    public void mudarTaxaComissão(float value){
        for (Funcionario funcionario : ListaFuncionarios) {

            if (funcionario instanceof Vendedor) {
                ((Vendedor) funcionario).setTaxaComissao(value);
               
            }

            
        }
    }


    public void mudarTaxaPericulosidade(float value){
         for (Funcionario funcionario : ListaFuncionarios) {

            if (funcionario instanceof Entregador) {
                ((Entregador) funcionario).setTaxaPericulosidade(value);
               
            }

            
        }
    }


    public void mudarBonusChefia(float value){
        for (Funcionario funcionario : ListaFuncionarios) {

            if (funcionario instanceof Administrador) {
                ((Administrador) funcionario).setBonus(value);
               
            }

            
        }
    }

}
