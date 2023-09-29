package Model;

import java.util.ArrayList;

public class Funcionario {
    protected String cpf;
    protected String nome;
    protected float salario;
    protected Departamento departamento;
    protected ArrayList<Beneficios> listaDeBeneficios;
    protected ArrayList<Desconto> listaDeDescontos;

    public Funcionario(String cpf, String nome, float salario, Departamento departamento) {
        this.cpf = cpf;
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
        listaDeBeneficios = new ArrayList<Beneficios>();
        listaDeDescontos = new ArrayList<Desconto>();
        Beneficios beneficioPlanoSaude = new Beneficios("Plano de saúde", 1000);
        Beneficios beneficioValeTransporte = new Beneficios("Vale Tranporte", 400);
        listaDeBeneficios.add(beneficioPlanoSaude);
        listaDeBeneficios.add(beneficioValeTransporte);
        Desconto descontoInss = new Desconto("INSS", 15, -1);
        Desconto descontoIRPF = new Desconto("Imposto de Renda", 11, -1);
        listaDeDescontos.add(descontoInss);
        listaDeDescontos.add(descontoIRPF);

    }

    public void setListaDeDescontos(String nome, float valorPerc, float valorNum) {

        if (valorPerc == -1) {
            Desconto descontoNovo = new Desconto(nome, -1, valorNum);
            listaDeDescontos.add(descontoNovo);
        } else {
            Desconto descontoNovo = new Desconto(nome, valorPerc, -1);
            listaDeDescontos.add(descontoNovo);
        }

    }

    public void setListaDeBeneficios(String nome, float value) {
        Beneficios beneficioNovo = new Beneficios(nome, value);
        listaDeBeneficios.add(beneficioNovo);
    }

    public ArrayList<Beneficios> getListaBeneficios() {
        return listaDeBeneficios;
    }

    public ArrayList<Desconto> getListaDescontos() {
        return listaDeDescontos;
    }

    public float calcularSalario() {
        return salario;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getDepartamento() {
        return this.departamento.getName();
    }

    public String gerarContraCheque() {

        String textoResultado = "--------------------\n";
        textoResultado += "Nome: " + getNome() + "\n";
        textoResultado += "CPF: " + getCpf() + "\n";
        textoResultado += ("Departamento: " + getDepartamento() + "\n");
        textoResultado += "Salário base: " + calcularSalario() + "\n";
        ArrayList<Beneficios> listaDeBeneficios = getListaBeneficios();

        textoResultado += ("Lista de Benefícios:" + "\n");
        for (Beneficios beneficio : listaDeBeneficios) {

            textoResultado += (beneficio.getNome() + " ");

            textoResultado += ("R$ " + beneficio.getValue() + "\n");

        }

        ArrayList<Desconto> listaDeDescontos = getListaDescontos();
        textoResultado += ("Lista de Descontos:" + "\n");
        for (Desconto desconto : listaDeDescontos) {

            textoResultado += (desconto.getNome() + " ");
            textoResultado += (desconto.getValor() + "\n");

        }

        return textoResultado;
    }

}
