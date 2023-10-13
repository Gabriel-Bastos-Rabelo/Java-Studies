package view;

import java.util.Scanner;
import java.util.ArrayList;

import javax.sql.rowset.spi.SyncResolver;

import controller.Funcionalidades;
import model.*;

public class Menu {
    protected Scanner entrada;
    protected Funcionalidades funcionalidades;
    public Menu(){

        entrada = new Scanner(System.in);
        funcionalidades = new Funcionalidades();

    }

    public void exibirMenu(){

    
            System.out.println("    MENU    ");
            System.out.println("Escolha uma opção abaixo:");
            System.out.println("1. Cadastrar acervo");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Consultar acervo");
            System.out.println("4. Realizar Empréstimo");
            System.out.println("5. Situação empréstimo");
            System.out.println("6. Realizar devolução");
            System.out.println("7. Emitir relatório empréstimo/devolução");
            System.out.println("8. Emitir ranking de leitura");
            System.out.println("9. Sair");



    }


    public void escolherFuncao(){
        while(true){
            exibirMenu();
            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch(opcao){
                case 1:
                    menuExemplar();
                    break;
                    
                case 2:
                    System.out.println("Digite o nome do usuario");
                    String nome = entrada.nextLine();
                    System.out.println("Digite a data de nascimento");
                    String dataNascimento = entrada.nextLine();
                    System.out.println("Digite o CPF");
                    String cpf = entrada.nextLine();
                    System.out.println("É adulto (1 para sim ou 2 para não)");
                    int maiorIdade = entrada.nextInt();
                    boolean adulto;
                    if(maiorIdade == 1){
                        adulto = true;
                    }
                    else if(maiorIdade == 2){
                        adulto = false;
                    }
                    else{
                        System.out.println("Digite uma opção válida");
                        continue;
                    }
                    entrada.nextLine();
                    funcionalidades.cadastroUsuario(nome, cpf, dataNascimento, adulto);
                    break;
                case 3:
                    
                    System.out.println("Digite a palavra chave");
                    String palavraChave = entrada.nextLine();
                    ArrayList<Exemplar> listaExemplares = funcionalidades.consultaAcervo(palavraChave);
                    int i = 1;
                    System.out.println("Total de livros achados: " + listaExemplares.size());
                    for(Exemplar exemplar : listaExemplares){
                        System.out.println(i + ". " + exemplar.getTitulo());
                        i++;
                    }

                    break;
                case 4:
                    
                    Usuario usuario = MenuBuscarUsuario();
                    if(usuario == null){
                        System.out.println("O usuário não foi encontrado no sistema");
                        continue;
                    }

                    Exemplar exemplar = MenuBuscaExemplarCadastro();
                    
                    if(exemplar == null){
                        System.out.println("O exemplar não foi encontrado no sistema ou não está disponível");
                        continue;
                    }

                    

                    boolean cadastroEmprestimo = funcionalidades.cadastroEmprestimo(usuario, exemplar);
                    if(cadastroEmprestimo){
                        System.out.println("O emprestimo foi efetuado com sucesso");
                    }
                    else{
                        System.out.println("Erro ao cadastrar o emprestimo");
                    }



                    break;
                case 5:
                    break;
                case 6:
                    Usuario usuarioDevolucao = MenuBuscarUsuario();
                    if(usuarioDevolucao == null){
                        System.out.println("O usuário não foi encontrado no sistema");
                        continue;
                    }

                    Exemplar exemplarDevolucao = MenuBuscarExemplarDevolucao(usuarioDevolucao);
                    
                    if(exemplarDevolucao == null){
                        System.out.println("O exemplar não foi encontrado no sistema");
                        continue;
                    }

                    
                    System.out.println("A obra foi lida? (1 para sim ou 2 para não)");
                    int op = entrada.nextInt();
                    entrada.nextLine();
                    boolean obraLida;
                    if(op == 1){
                        obraLida = true;
                    }
                    else if(opcao == 2){
                        obraLida = false;
                    }
                    else{
                        System.out.println("Digite uma opção válida");
                        break;
                    }


                    boolean cadastroDevolucao = funcionalidades.cadastroDevolucao(usuarioDevolucao, exemplarDevolucao, obraLida );
                    if(cadastroDevolucao){
                        System.out.println("Devolução efetuada com sucesso");
                    }
                    else{
                        System.out.println("Erro ao efetuar a devolução");
                    }
                    break;
                case 7:
                    ArrayList<Movimentacao> relatorio = funcionalidades.gerarRelatorio();
                    for(Movimentacao movimentacao : relatorio){
                        if(movimentacao instanceof Emprestimo){
                            System.out.println("Emprestimo| " + "Livro: " + movimentacao.getExemplar().getTitulo() + "| Usuário: " + movimentacao.getUsuario().getNome() + "| Data: " + movimentacao.getDataMovimentacao() + "   " + ((Emprestimo)movimentacao).getDataDevolucao());
                        }
                        else{
                            System.out.println("Devolução| " + "Livro: " + movimentacao.getExemplar().getTitulo() + "| Usuário: " + movimentacao.getUsuario().getNome() + "| Data: " + movimentacao.getDataMovimentacao());
                        }
                    }
                    break;
                case 8:
                    ArrayList<Usuario> rankingUsuarios = funcionalidades.rankingLeitura();
                    for(Usuario usuarioRanking : rankingUsuarios){
                        System.out.println(usuarioRanking.getNome() + ": " + usuarioRanking.getLivrosLidos() + " Livros lidos.");
                    }
                    break;
                case 9:
                    break;
            }
            
        }
    }


    public void menuExemplar(){
        while(true){

            System.out.println("1. Cadastro de livro");
            System.out.println("2. Cadastro de Revista");
            System.out.println("3. Voltar");
            int opcao = entrada.nextInt();
            entrada.nextLine();
            if(opcao < 1 || opcao > 3){
                System.out.println("Digite uma opção válida");
                continue;
            }
            else if(opcao == 3){
                break;
            }

            System.out.println("Digite o título da obra");
            String titulo = entrada.nextLine();
            System.out.println("Digite o ano da obra");
            int ano = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Digite o autor da obra");
            String autor = entrada.nextLine();
            System.out.println("Digite a editora");
            String editora = entrada.nextLine();
            System.out.println("Digite a quantidade de páginas");
            int qtdPaginas = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Digite o gênero");
            String genero = entrada.nextLine();
            if(opcao == 1){
                
                
                
                funcionalidades.cadastroLivro(titulo, autor, ano, editora, qtdPaginas, genero);

            }
            else if(opcao == 2){
                
                System.out.println("Digite o volume");
                int volume = entrada.nextInt();
                entrada.nextLine();
                System.out.println("Digite o mês de publicação");
                int mesPublicacao = entrada.nextInt();
                entrada.nextLine();
                funcionalidades.cadastroRevista(titulo, autor, ano, editora, qtdPaginas, genero, volume, mesPublicacao);
            }
            






        }
        
    }


    public Usuario MenuBuscarUsuario(){
        System.out.println("Digite o nome do usuário");
        String nomeConsulta = entrada.nextLine();
        System.out.println("Digite o cpf do usuário");
        String cpfConsulta = entrada.nextLine();
        Usuario usuario = funcionalidades.buscarUsuario(nomeConsulta, cpfConsulta);
        if(usuario == null){
            return null;
        }
        else{
            return usuario;
        }
    }


    public Exemplar MenuBuscaExemplarCadastro(){
        System.out.println("Digite o titulo da obra");
        String titulo = entrada.nextLine();
        System.out.println("Digite o nome do autor");
        String autor = entrada.nextLine();
        Exemplar exemplar = funcionalidades.buscarExemplar(titulo, autor);
        if(exemplar == null){
            return null;
        }
        else{
            return exemplar;
        }
    }


    public Exemplar MenuBuscarExemplarDevolucao(Usuario usuario){
        System.out.println("Digite o titulo da obra");
        String titulo = entrada.nextLine();
        System.out.println("Digite o nome do autor");
        String autor = entrada.nextLine();
        Exemplar exemplar = funcionalidades.buscarExemplarDevolucao(titulo, autor, usuario);
        if(exemplar == null){
            return null;
        }
        else{
            return exemplar;
        }
    }
}





