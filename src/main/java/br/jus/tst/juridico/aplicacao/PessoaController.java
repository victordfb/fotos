package br.jus.tst.juridico.aplicacao;

import br.jus.tst.juridico.fotos.Pessoa;
import br.jus.tst.juridico.fotos.PessoaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PessoaController {

    @Autowired
    private PessoaServico pessoaServico;

    @RequestMapping("/pessoas")
    public Set<PessoaDTO> pessoas() {
        return pessoaServico.pessoas().stream()
                .map(PessoaDTO::new)
                .collect(Collectors.toSet());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/pessoas")
    public PessoaDTO inserir(@RequestParam(name = "codigo") String codigo,
                             @RequestParam(name = "nome") String nome) {

        Pessoa pessoa = new Pessoa(codigo, nome);
        pessoaServico.inserir(pessoa);
        return new PessoaDTO(pessoa);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pessoas/avatar")
    public PessoaDTO inserirAvatar(@RequestParam(name = "codigo") String codigo,
                                   @RequestParam(name = "file") MultipartFile file) {

        try {
            BufferedImage imagem = ImageIO.read(file.getInputStream());
            pessoaServico.inserirAvatar(codigo, imagem);
            return new PessoaDTO(new Pessoa(codigo, ""));
        } catch (IOException e) {
            throw new IllegalStateException("Erro ao ler arquivo do uoload.", e);
        }
    }
}
