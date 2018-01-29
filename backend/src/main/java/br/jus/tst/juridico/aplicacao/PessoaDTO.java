package br.jus.tst.juridico.aplicacao;

import br.jus.tst.juridico.fotos.Pessoa;
import br.jus.tst.juridico.fotos.Tamanho;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

@SuppressWarnings("unused")
public class PessoaDTO {

    private final String codigo;
    private final String nome;
    private final String imagemBase64;

    PessoaDTO(Pessoa pessoa) {
        this.codigo = pessoa.getCodigo();
        this.nome = pessoa.getNome();
        this.imagemBase64 = getImagemBase64(pessoa);
    }

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
}
