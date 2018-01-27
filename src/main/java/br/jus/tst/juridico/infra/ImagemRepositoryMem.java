package br.jus.tst.juridico.infra;

import br.jus.tst.juridico.fotos.ImagenRepository;
import br.jus.tst.juridico.fotos.Pessoa;
import br.jus.tst.juridico.fotos.Tamanho;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ImagemRepositoryMem implements ImagenRepository {

    @Override
    public void carregarImagens(Set<Pessoa> pessoas, Tamanho... tams) {

        Set<Tamanho> tamanhos = Arrays.stream(tams).collect(Collectors.toSet());
    }
}
