package br.jus.tst.juridico.aplicacao;

import br.jus.tst.juridico.fotos.Pessoa;

public class PessoaDTO {

    private final String codigo;
    private final String nome;

    PessoaDTO(Pessoa pessoa) {
        this.codigo = pessoa.getCodigo();
        this.nome = pessoa.getNome();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
