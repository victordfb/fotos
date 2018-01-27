package br.jus.tst.juridico.fotos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PessoaServico {

    private final PessoaRepository pessoaRepository;
    private final ImagenRepository imagenRepository;

    @Autowired
    public PessoaServico(PessoaRepository pessoaRepository, ImagenRepository imagenRepository) {
        this.pessoaRepository = pessoaRepository;
        this.imagenRepository = imagenRepository;
    }

    public void inserir(Pessoa pessoa) {

        pessoaRepository.inserir(pessoa);
    }

    public Set<Pessoa> pessoas() {

        Set<Pessoa> pessoas = pessoaRepository.pessoas();

        imagenRepository.carregarImagens(pessoas, Tamanho.PEQUENA);

        return pessoas;
    }
}
