package br.jus.tst.juridico.aplicacao;

import br.jus.tst.juridico.fotos.Pessoa;
import br.jus.tst.juridico.fotos.Tamanho;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

@SuppressWarnings("unused")
public class PessoaDTO implements Comparable<PessoaDTO> {

    private final String codigo;
    private final String nome;
    private final String imagemBase64;

    PessoaDTO(Pessoa pessoa) {
        this.codigo = pessoa.getCodigo();
        this.nome = pessoa.getNome();
        this.imagemBase64 = getImagemBase64(pessoa);
    }

    @SuppressWarnings("WeakerAccess")
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getImagemBase64() {
        return imagemBase64;
    }

    private String getImagemBase64(Pessoa pessoa) {
        try {
            return new String(Base64.encodeBase64(pessoa.getImagemEmBytes(Tamanho.PEQUENA).orElse(new byte[]{})), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Erro ao converter imagem para base 64", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaDTO pessoaDTO = (PessoaDTO) o;
        return Objects.equals(getCodigo(), pessoaDTO.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }

    @Override
    public int compareTo(PessoaDTO o) {
        return this.codigo.compareTo(o.codigo);
    }
}
