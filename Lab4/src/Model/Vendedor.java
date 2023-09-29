package Model;

import java.util.ArrayList;


public class Vendedor extends Funcionario {
    protected float taxaComissao;
    protected ArrayList<Vendas> vendas;


    public Vendedor(String cpf, String nome, float salario, Departamento departamento, float taxaComissao) {
        super(cpf, nome, salario, departamento);
        this.taxaComissao = taxaComissao;
        

        vendas = new ArrayList<Vendas>();

    }


    public void setVendas(String data, float valor, boolean status) {
        Vendas vendaNova = new Vendas(data, valor, status);
        vendas.add(vendaNova);
        
    }

    public void setTaxaComissao(float value){
        this.taxaComissao = value;
    }

    public ArrayList<Vendas> getVendas(){
        return vendas;
    }

    public String gerarContraCheque(){

        float total = 0;
        String result = "";
        for(Vendas venda : vendas){
            if(venda.getStatus() == true){

                total += (venda.getValor() * (taxaComissao/100));
                venda.setStatus(false);

            }
            
        }
        result = super.gerarContraCheque() + "Taxa de comissão: " + taxaComissao + "%\n";
        result += "Adicional com vendas: R$" + total + "\n";
        result += "Total: R$" + (salario + total) + "\n";

        return result;

    }
}
