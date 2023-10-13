package controller;

import model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Funcionalidades {
    ArrayList<Exemplar> listaExemplares;
    ArrayList<Usuario> listaUsuarios;
    ArrayList<Movimentacao> listaMovimentacao;
    ArrayList<Emprestimo> listaEmprestimos;
    ArrayList<Devolucao> listaDevolucao;
    ArrayList<Emprestimo> listaUsuariosEmprestimos;

    public Funcionalidades() {
        listaExemplares = new ArrayList<Exemplar>();
        listaUsuarios = new ArrayList<Usuario>();
        listaMovimentacao = new ArrayList<Movimentacao>();
        listaEmprestimos = new ArrayList<Emprestimo>();
        listaDevolucao = new ArrayList<Devolucao>();
        listaUsuariosEmprestimos = new ArrayList<Emprestimo>();

    }

    public void cadastroLivro(String titulo, String autor, int ano, String editora, int qtdPaginas, String genero) {
        Livro newLivro = new Livro(titulo, autor, ano, editora, qtdPaginas, genero);
        listaExemplares.add(newLivro);
    }

    public void cadastroRevista(String titulo, String autor, int ano, String editora, int qtdPaginas, String genero,
            int volume, int mesPublicacao) {
        Revista newRevista = new Revista(titulo, autor, ano, editora, qtdPaginas, genero, volume, mesPublicacao);
        listaExemplares.add(newRevista);
    }

    public void cadastroUsuario(String nome, String cpf, String dataNascimento, boolean adulto) {
        Usuario newUsuario = new Usuario(nome, cpf, dataNascimento, adulto);
        listaUsuarios.add(newUsuario);

    }

    public boolean cadastroEmprestimo(Usuario usuario, Exemplar exemplar) {

        for(Emprestimo emprestimo : listaUsuariosEmprestimos){
            if(emprestimo.getUsuario() == usuario){
                return false;
            }
        }

        

        exemplar.setDisponivel(false);

        Date dataEmprestimo = new Date();

        Emprestimo newEmprestimo = new Emprestimo(usuario, dataEmprestimo, exemplar);
        listaMovimentacao.add(newEmprestimo);
        listaUsuariosEmprestimos.add(newEmprestimo);
        return true;
        

    }

    public boolean cadastroDevolucao(Usuario usuario, Exemplar exemplar, boolean obraLida) {

        //TODO tenho que ter um metodo para recuperar um exemplar que esteja indisponivel, e aí sim, passar para esse método
        // talvez possa iterar sobre a lista de usuario com emprestimo, e verificar retornar o exemplar que bata com o mesmo titulo passado para o mesmo usuario
        for(Emprestimo emprestimo : listaUsuariosEmprestimos){
            if(emprestimo.getUsuario() == usuario && emprestimo.getExemplar() == exemplar){
                exemplar.setDisponivel(true);
                if(obraLida == true){
                    usuario.setLivrosLidos();
                }

                Date dataDevolucao = new Date();
                Devolucao newDevolucao = new Devolucao(usuario, dataDevolucao, exemplar, obraLida);
                listaMovimentacao.add(newDevolucao);
                listaUsuariosEmprestimos.remove(emprestimo);
                return true;

            }
        }


        return false;
    }


    public Usuario buscarUsuario(String nome, String cpf){
        for(Usuario usuario : listaUsuarios){
            if(usuario.getNome().equals(nome) && usuario.getCpf().equals(cpf)){
                return usuario;
            }
        }

        return null;
    }


    public Exemplar buscarExemplar(String titulo, String autor){
        for(Exemplar exemplar : listaExemplares){
            if(exemplar.getTitulo().equals(titulo) && exemplar.getAutor().equals(autor) && exemplar.getDisponivel() == true){
                return exemplar;
            }
        }


        return null;
    }

    public ArrayList<Exemplar> getListaExemplares(){
        return this.listaExemplares;
    }

    public void setNome(Usuario usuario, String nome) {
        usuario.setNome(nome);
    }

    public void setCpf(Usuario usuario, String cpf) {
        usuario.setCpf(cpf);
    }

    public void setAdulto(Usuario usuario, boolean adulto) {
        usuario.setAdulto(adulto);
    }

    public void setDataNascimento(Usuario usuario, String dataNascimento) {
        usuario.setDataNascimento(dataNascimento);
    }


    public ArrayList<Usuario> rankingLeitura(){
        //tenho que pegar a lista de usuarios, procurar por todas as crianças, botar em uma lista de ranking, e ordenar por livros lidos
        ArrayList<Usuario> rankingUsuarios = new ArrayList<Usuario>();
        for(Usuario usuario : listaUsuarios){
            if(usuario.getAdulto() == false){
                rankingUsuarios.add(usuario);
            }
        }

        Collections.sort(rankingUsuarios, new Comparator<Usuario>() {
            @Override
            public int compare(Usuario s1, Usuario s2) {
                return Integer.compare(s2.getLivrosLidos(), s1.getLivrosLidos());
            }
        });

        return rankingUsuarios;



    }

    public ArrayList<Exemplar> consultaAcervo(String palavraChave){
        ArrayList<Exemplar> listaBuscadaExemplares = new ArrayList<>();
        for(Exemplar exemplar : listaExemplares){
            if(exemplar.getTitulo().indexOf(palavraChave) >= 0){
                listaBuscadaExemplares.add(exemplar);
            }
        }


        return listaBuscadaExemplares;
    }

    public Exemplar buscarExemplarDevolucao(String titulo, String autor, Usuario usuario){
        for(Emprestimo emprestimo : listaUsuariosEmprestimos){
            if(emprestimo.getExemplar().getAutor().equals(autor) && emprestimo.getExemplar().getTitulo().equals(titulo) && emprestimo.getUsuario() == usuario){
                return emprestimo.getExemplar();
            }
        }

        return null;
    }


    public ArrayList<Movimentacao> gerarRelatorio(){
        return this.listaMovimentacao;
    }
}
