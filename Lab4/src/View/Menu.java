package View;

import java.util.Scanner;
import Controller.Presenter;

public class Menu {

    private Scanner scanner;
    private Presenter presenter;

    public Menu() {
        scanner = new Scanner(System.in);
        presenter = new Presenter();
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("0. Cadastrar Funcionário");
            System.out.println("1. Cadastrar Administrador");
            System.out.println("2. Cadastrar Vendedor");
            System.out.println("3. Cadastrar Entregador");
            System.out.println("4. Gerar contra-cheque");
            System.out.println("5. Consultar Folha de pagamento");
            System.out.println("6. Cadastrar Benefício para funcionário");
            System.out.println("7. Cadastrar Desconto para funcionário");
            System.out.println("8. Cadastrar venda para vendedor");
            System.out.println("9. Verificar vendas de um vendedor");
            System.out.println("10. Ajustar taxa de comissão para vendedores");
            System.out.println("11. Ajustar taxa de periculosidade para entregadores");
            System.out.println("12. Ajustar bônus de chefia para administradores");
            System.out.println("13. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao > 13 || opcao < 1) {

                System.out.println("Digite uma opção valida");
            } else if (opcao == 13) {
                break;
            } else {
                operacoesMenu(opcao);
            }

        }
    }

    public void operacoesMenu(int opcao) {
        if (opcao == 0 || opcao == 1 || opcao == 2 || opcao == 3) {
            System.out.println("Informe o nome completo: ");
            String nome = scanner.nextLine();
            System.out.println("Informe o cpf: ");
            String cpf = scanner.nextLine();
            System.out.println("informe o salário em BRL: ");
            float salario = scanner.nextFloat();
            scanner.nextLine();
            System.out.println("Informe o departamento: ");
            String departamento = scanner.nextLine();

            if (opcao == 1) {
                System.out.println("informe o bônus por chefia: ");
                float bonusChefia = scanner.nextFloat();
                presenter.cadastroAdministrador(cpf, nome, salario, departamento, bonusChefia);

            } else if (opcao == 2) {
                System.out.println("Informe a taxa de comissão: ");
                float taxaComissao = scanner.nextFloat();
                presenter.cadastroVendedor(cpf, nome, salario, departamento, taxaComissao);
            } else if (opcao == 3) {
                System.out.println("Informe o bônus por periculosidade");
                float periculosidade = scanner.nextFloat();
                presenter.cadastroEntregador(cpf, nome, salario, departamento, periculosidade);
            } else {

                presenter.cadastroFuncionario(cpf, nome, salario, departamento);
            }

        }

        else if (opcao == 4) {
            System.out.println("Informe um nome para a consulta");
            String nome = scanner.nextLine();
            System.out.println("Informe o cpf para a consulta");
            String cpf = scanner.next();
            String resultado = presenter.ContraCheque(nome, cpf);
            System.out.println(resultado);
        } else if (opcao == 5) {
            float total = presenter.folhaPagamento();
            System.out.println("Folha de pagamento: " + total);
        }
        else if(opcao == 6){
            System.out.println("Digite o nome do funcionário: ");
            String nome = scanner.nextLine();
            System.out.println("Digite o CPF do funcionário:");
            String cpf = scanner.nextLine();
            System.out.println("Digite o nome do benefício:");
            String nomeBeneficio = scanner.nextLine();
            System.out.println("Digite o valor do benefício em BRL:");
            float valorBeneficio = scanner.nextFloat();
            scanner.nextLine();
            boolean result = presenter.cadastroBeneficio(nome, cpf, nomeBeneficio, valorBeneficio);
            if(result == false){
                System.out.println("Não foi possível achar o funcionário ou o CPF");
            }
            else{
                System.out.println("Cadastro realizado com sucesso");
            }
        }

        else if(opcao == 7){
            System.out.println("Informe o nome do funcionário:");
            String nome = scanner.nextLine();
            System.out.println("Informe o CPF do funcionário: ");
            String cpf = scanner.nextLine();
            System.out.println("Informe o nome do desconto: ");
            String nomeDesconto = scanner.nextLine();
            while(true){
                System.out.println("1. Cadastrar valor percentual\n2. Cadastrar valor numérico\n(Escolha 1 ou 2)");
                int opcaoValor = scanner.nextInt();
                scanner.nextLine();
                if(opcaoValor == 1){
                    System.out.println("Informe o valor percentual (Ex: 4.5)");
                    float valorPerc = scanner.nextFloat();
                    scanner.nextLine();
                    float valorNum = 0;
                    boolean result = presenter.cadastroDesconto(nome, cpf, nomeDesconto, valorPerc, valorNum);
                    if(result == false){
                        System.out.println("Não foi possível achar o funcionário ou o CPF");
                    }
                    else{
                        System.out.println("Cadastro realizado com sucesso");
                    }
                    break;
                }
                else if(opcaoValor == 2){
                    System.out.println("Informe o valor numérico: ");
                    float valorNum = scanner.nextInt();
                    scanner.nextLine();
                    float valorPerc = 0;
                    boolean result = presenter.cadastroDesconto(nome, cpf, nomeDesconto, valorPerc, valorNum);
                    if(result == false){
                        System.out.println("Não foi possível achar o funcionário ou o CPF");
                    }
                    else{
                        System.out.println("Cadastro realizado com sucesso");
                    }
                    break;
                }
                else{
                    System.out.println("Digite um opção válida");
                }
            }
            


        }

        else if(opcao == 8){
            System.out.println("Informe o nome do vendedor:");
            String nome = scanner.nextLine();
            System.out.println("Informe o CPF do funcionário: ");
            String cpf = scanner.nextLine();
            System.out.println("Informe a data da venda:");
            String data = scanner.nextLine();
            System.out.println("Informe o valor da venda: ");
            float valor = scanner.nextFloat();
            scanner.nextLine();

            boolean result = presenter.cadastroVenda(nome, cpf, data, valor, true);

            if(result == false){
                System.out.println("Não foi possível achar o funcionário ou o CPF do vendedor");
            }
            else{
                System.out.println("Cadastro realizado com sucesso");
            }
        }

        else if(opcao == 9){
            System.out.println("Informe o nome do vendedor:");
            String nome = scanner.nextLine();
            System.out.println("Informe o CPF do funcionário: ");
            String cpf = scanner.nextLine();

            String result = presenter.verificarVendas(nome, cpf);
            System.out.println(result);
        }
        else if(opcao == 10){
             System.out.println("Informe a nova taxa de comissão");
             float taxa = scanner.nextFloat();
             scanner.nextLine();
             presenter.mudarTaxaComissão(taxa);

        }

        else if(opcao == 11){
             System.out.println("Informe a nova taxa de periculosidade para entregadores");
             float taxa = scanner.nextFloat();
             scanner.nextLine();
             presenter.mudarTaxaPericulosidade(taxa);
        }

        else if(opcao == 12){
            System.out.println("Informe o novo bônus de chefia");
            float bonus = scanner.nextFloat();
            scanner.nextLine();
            presenter.mudarBonusChefia(bonus);
        }

    }
}
