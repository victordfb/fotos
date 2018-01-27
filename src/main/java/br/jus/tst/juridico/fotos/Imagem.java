package br.jus.tst.juridico.fotos;

import java.awt.image.BufferedImage;

public class Imagem {

    private final Tamanho tamanho;
    private final BufferedImage bufferedImage;

    public Imagem(Tamanho tamanho, BufferedImage bufferedImage) {
        this.tamanho = tamanho;
        this.bufferedImage = bufferedImage;
    }
}
