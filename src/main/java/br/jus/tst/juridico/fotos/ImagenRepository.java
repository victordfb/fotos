package br.jus.tst.juridico.fotos;

import java.util.Set;

public interface ImagenRepository {

    void carregarImagens(Set<Pessoa> pessoas, Tamanho... tamanho);
}
