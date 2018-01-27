package br.jus.tst.juridico.aplicacao;

public class PessoaDTO {

    private final String codigo;
    private final String nome;

    public PessoaDTO(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
