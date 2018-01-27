package br.jus.tst.juridico.fotos;

import java.util.Set;

public interface PessoaRepository {

    Set<Pessoa> pessoas();

    void inserir(Pessoa pessoa);
}
