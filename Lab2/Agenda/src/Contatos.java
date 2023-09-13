import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contatos {

    private List<PessoaFisica> pessoasFisicas = new ArrayList<>();
    private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void inserirContato() {

        String resp;
        while (true) {

            System.out.println("Pessoa jurídica ou pessoa física? (J ou F) ");
            resp = scanner.nextLine();
            if (resp.equals("J") || resp.equals("F")) {
                break;
            }

            System.out.println("Digite somente J ou F");

        }
        // String cpf, String nome, String endereco, String dataNascimento, String
        // email, String estadoCivil
        if (resp.equals("F")) {
            System.out.println("Digite o CPF: ");
            String cpf = scanner.nextLine();
            System.out.println("Digite o nome: ");
            String nome = scanner.nextLine();
            System.out.println("Digite o endereço: ");
            String endereco = scanner.nextLine();
            System.out.println("Digite a data de nascimento: ");
            String dataNascimento = scanner.nextLine();
            System.out.println("Digite o email: ");
            String email = scanner.nextLine();
            System.out.println("Digite seu estado cívil: ");
            String estadoCivil = scanner.nextLine();

            PessoaFisica pessoaFisica = new PessoaFisica(cpf, nome, endereco, dataNascimento, email, estadoCivil);

            pessoasFisicas.add(pessoaFisica);

        } else {
            // String cnpj, String nome, String endereco, String email, String
            // inscricaoEstadual, String razaoSocial
            System.out.println("Digite o CNPJ: ");
            String cnpj = scanner.nextLine();
            System.out.println("Digite o nome: ");
            String nome = scanner.nextLine();
            System.out.println("Digite o endereço: ");
            String endereco = scanner.nextLine();
            System.out.println("Digite o email: ");
            String email = scanner.nextLine();
            System.out.println("Digite a inscrição estadual: ");
            String inscricaoEstadual = scanner.nextLine();
            System.out.println("Digite a razao social: ");
            String razaoSocial = scanner.nextLine();

            PessoaJuridica pessoaJuridica = new PessoaJuridica(cnpj, nome, endereco, email, inscricaoEstadual,
                    razaoSocial);

            pessoasJuridicas.add(pessoaJuridica);

        }

    }

    public void pesquisarContato() {
        while (true) {

            System.out.println("Pessoa Fisica ou Pessoa Jurídica? (F ou J): ");
            String opcao = scanner.nextLine();
            if (opcao.equals("F") || opcao.equals("J")) {
                if (opcao.equals("F")) {
                    while (true) {

                        System.out.println("Deseja pesquisar por nome ou CPF? (N ou C)? ");
                        String opcao2 = scanner.nextLine();
                        if (opcao2.equals("N") || opcao2.equals("C")) {
                            if (opcao2.equals("N")) {
                                System.out.println("Digite o nome da pessoa: ");
                                String nome = scanner.nextLine();
                                boolean achou = false;
                                for (PessoaFisica contato : pessoasFisicas) {
                                    if (contato.getNome().equalsIgnoreCase(nome)) {
                                        System.out.println("Contato achado: ");
                                        System.out.println("----------------------\n");
                                        System.out.println(contato);
                                        System.out.println("----------------------\n");
                                        achou = true;
                                        break;
                                    }
                                }

                                if (!achou) {
                                    System.out.println("Não foi achado nenhum contato correspondente");
                                }

                            } else {
                                System.out.println("Digite o cpf da pessoa: ");
                                String cpf = scanner.nextLine();
                                boolean achou = false;
                                for (PessoaFisica contato : pessoasFisicas) {
                                    if (contato.getCpf().equalsIgnoreCase(cpf)) {
                                        System.out.println("Contato achado: ");
                                        System.out.println("----------------------\n");
                                        System.out.println(contato);
                                        System.out.println("----------------------\n");
                                        achou = true;
                                        break;
                                    }
                                }

                                if (!achou) {
                                    System.out.println("Não foi achado nenhum contato correspondente");
                                }

                            }

                            break;
                        }

                        System.out.println("Digite uma opção válida!");

                    }

                }

                else {

                    while (true) {

                        System.out.println("Deseja pesquisar por nome ou CNPJ? (N ou C)? ");
                        String opcao2 = scanner.nextLine();
                        if (opcao2.equals("N") || opcao2.equals("C")) {
                            if (opcao2.equals("N")) {
                                System.out.println("Digite o nome da organização: ");
                                String nome = scanner.nextLine();
                                boolean achou = false;
                                for (PessoaJuridica contato : pessoasJuridicas) {
                                    if (contato.getNome().equalsIgnoreCase(nome)) {
                                        System.out.println("Contato achado: ");
                                        System.out.println("----------------------\n");
                                        System.out.println(contato);
                                        System.out.println("----------------------\n");
                                        achou = true;
                                        break;
                                    }
                                }

                                if (!achou) {
                                    System.out.println("Não foi achado nenhum contato correspondente");
                                }

                            } else {

                                System.out.println("Digite o CNPJ da organização: ");
                                String cnpj = scanner.nextLine();
                                boolean achou = false;
                                for (PessoaJuridica contato : pessoasJuridicas) {
                                    if (contato.getCnpj().equalsIgnoreCase(cnpj)) {
                                        System.out.println("Contato achado: ");
                                        System.out.println("----------------------\n");
                                        System.out.println(contato);
                                        System.out.println("----------------------\n");
                                        achou = true;
                                        break;
                                    }
                                }

                                if (!achou) {
                                    System.out.println("Não foi achado nenhum contato correspondente");
                                }

                            }

                            break;

                        }

                        System.out.println("Digite uma opção válida!");

                    }

                }

                break;

            }

            System.out.println("Digite uma opção válida!");

        }

    }

    public void listarContatos() {

        System.out.println("Lista de Contatos:");
        for (PessoaFisica contato : pessoasFisicas) {
            System.out.println("----------------------\n");
            System.out.println(contato);
            System.out.println("----------------------\n");
        }
        for (PessoaJuridica contato : pessoasJuridicas) {
            System.out.println("----------------------\n");
            System.out.println(contato);
            System.out.println("----------------------\n");
        }

    }

}
