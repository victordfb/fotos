package br.jus.tst.juridico.infra;

import br.jus.tst.juridico.fotos.ImagenRepository;
import br.jus.tst.juridico.fotos.Pessoa;
import br.jus.tst.juridico.fotos.Tamanho;

import java.util.Set;

public class ImagemRepositoryMem implements ImagenRepository {

    @Override
    public void carregarImagens(Set<Pessoa> pessoas, Tamanho tamanho) {

    }
}
