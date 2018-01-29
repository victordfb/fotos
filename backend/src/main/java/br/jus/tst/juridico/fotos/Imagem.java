package br.jus.tst.juridico.fotos;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Imagem {

    private final Tamanho tamanho;
    private final BufferedImage bufferedImage;

    public Imagem(Tamanho tamanho, BufferedImage bufferedImage) {
        this.tamanho = tamanho;
        this.bufferedImage = bufferedImage;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public byte[] getBytes() {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            ImageIO.write(bufferedImage, "jpg", baos);
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            throw new IllegalStateException("Erro ao pegar bytes de imagem.", e);
        }
    }
}
