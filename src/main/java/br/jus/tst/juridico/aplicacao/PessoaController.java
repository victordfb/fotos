package br.jus.tst.juridico.aplicacao;

import br.jus.tst.juridico.fotos.Pessoa;
import br.jus.tst.juridico.fotos.PessoaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class PessoaController {

    @Autowired
    private PessoaServico pessoaServico;

    @RequestMapping("/pessoas")
    public Set<Pessoa> pessoas() {
        return pessoaServico.pessoas();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/pessoas")
    public Pessoa inserir(@RequestParam(name = "codigo") String codigo,
                          @RequestParam(name = "nome") String nome) {

        Pessoa pessoa = new Pessoa(codigo, nome, imagens);
        pessoaServico.inserir(pessoa);
        return pessoa;
    }
}
