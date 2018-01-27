package br.jus.tst.juridico.infra;

import br.jus.tst.juridico.fotos.Pessoa;
import br.jus.tst.juridico.fotos.PessoaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class PessoaRepositoryMem implements PessoaRepository {

    private Set<Pessoa> pessoas = new HashSet<>();

    @Override
    public Set<Pessoa> pessoas() {
        return new HashSet<>(pessoas);
    }

    @Override
    public void inserir(Pessoa pessoa) {

        pessoas.add(pessoa);
    }
}
