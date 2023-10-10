package controller;

import model.*;
import java.util.ArrayList;

public class Funcionalidades {
    ArrayList<Exemplar> listaExemplares;
    ArrayList<Usuario> listaUsuarios;
    ArrayList<Movimentacao> listaMovimentacao;
    ArrayList<Emprestimo> listaEmprestimos;
    ArrayList<Devolucao> listaDevolucao;
    ArrayList<Exemplar> exemplaresEmprestados;
    ArrayList<Usuario> usuariosComEmprestimos;

    public Funcionalidades() {
        listaExemplares = new ArrayList<Exemplar>();
        listaUsuarios = new ArrayList<Usuario>();
        listaMovimentacao = new ArrayList<Movimentacao>();
        listaEmprestimos = new ArrayList<Emprestimo>();
        listaDevolucao = new ArrayList<Devolucao>();
        exemplaresEmprestados = new ArrayList<Exemplar>();
        usuariosComEmprestimos = new ArrayList<Usuario>();

    }

    public void cadastroLivro(String titulo, String autor, int ano, String editora, int qtdPaginas, String genero,
            int exemplar) {
        Livro newLivro = new Livro(titulo, autor, ano, editora, qtdPaginas, genero, exemplar);
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

    public boolean cadastroEmprestimo(Usuario usuario, Exemplar exemplar, String dataEmprestimo) {

        if (!exemplaresEmprestados.contains(exemplar) && !usuariosComEmprestimos.contains(usuario)) {
            Emprestimo newEmprestimo = new Emprestimo(usuario, dataEmprestimo, exemplar);
            listaMovimentacao.add(newEmprestimo);
            exemplaresEmprestados.add(exemplar);
            usuariosComEmprestimos.add(usuario);
            return true;
        }

        return false;

    }

    public boolean cadastroDevolucao(Usuario usuario, Exemplar exemplar, String dataDevolucao, boolean obraLida) {
        if(usuariosComEmprestimos.contains(usuario) && exemplaresEmprestados.contains(exemplar)){
            Devolucao newDevolucao = new Devolucao(usuario, dataDevolucao, exemplar, obraLida);
            listaMovimentacao.add(newDevolucao);
            exemplaresEmprestados.remove(exemplar);
            usuariosComEmprestimos.remove(usuario);
            return true;
        }


        return false;


        //TODO fazer a verificação se o livro que o usuario quer devolver realmente foi o que ele pegou
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
}
