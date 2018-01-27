package br.jus.tst.juridico.fotos;

import java.awt.image.BufferedImage;
import java.util.Set;

public interface ImagenRepository {

    void carregarImagens(Set<Pessoa> pessoas, Tamanho... tamanho);

    void inserir(String codigo, BufferedImage imagem);
}
