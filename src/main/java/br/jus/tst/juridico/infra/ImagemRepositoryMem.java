package br.jus.tst.juridico.infra;

import br.jus.tst.juridico.fotos.Imagem;
import br.jus.tst.juridico.fotos.ImagenRepository;
import br.jus.tst.juridico.fotos.Pessoa;
import br.jus.tst.juridico.fotos.Tamanho;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ImagemRepositoryMem implements ImagenRepository {

    private final Map<String, Set<Imagem>> imagens;

    public ImagemRepositoryMem() {
        this.imagens = new HashMap<>();
    }

    @Override
    public void carregarImagens(Set<Pessoa> pessoas, Tamanho... tams) {

        Set<Tamanho> tamanhos = Arrays.stream(tams).collect(Collectors.toSet());

        pessoas.forEach(pessoa -> {
            Set<Imagem> todasImagens = imagens.getOrDefault(pessoa.getCodigo(), new HashSet<>());
            Set<Imagem> selecionadas = todasImagens.stream()
                    .filter(imagem -> tamanhos.contains(imagem.getTamanho()))
                    .collect(Collectors.toSet());
            pessoa.addImagens(selecionadas);
        });
    }
}
