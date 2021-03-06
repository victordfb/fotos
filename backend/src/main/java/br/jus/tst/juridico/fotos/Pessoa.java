package br.jus.tst.juridico.fotos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Pessoa implements Comparable<Pessoa> {

    private final String codigo;
    private final String nome;
    private final Set<Imagem> imagens;

    public Pessoa(String codigo, String nome, Set<Imagem> imagens) {
        this.codigo = codigo;
        this.nome = nome;
        this.imagens = imagens;
    }

    public Pessoa(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.imagens = new HashSet<>();
    }

    public void addImagens(Set<Imagem> selecionadas) {
        imagens.addAll(selecionadas);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Optional<byte[]> getImagemEmBytes(Tamanho tamanho) {
        Optional<Imagem> imagemOpt = imagens.stream()
                .filter(imagem -> imagem.getTamanho() == tamanho)
                .findFirst();

        return imagemOpt.map(Imagem::getBytes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getCodigo(), pessoa.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }

    @Override
    public int compareTo(Pessoa o) {
        return this.codigo.compareTo(o.codigo);
    }
}
