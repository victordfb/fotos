package br.jus.tst.juridico.aplicacao;

import br.jus.tst.juridico.fotos.Pessoa;
import br.jus.tst.juridico.fotos.PessoaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PessoaController {

    @Autowired
    private PessoaServico pessoaServico;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/pessoas")
    public List<PessoaDTO> pessoas() {
        return pessoaServico.pessoas()
                .stream()
                .map(PessoaDTO::new)
                .distinct()
                .sorted(Comparator.comparing(PessoaDTO::getNome))
                .collect(Collectors.toList());
    }

    @CrossOrigin(origins = "http://localhost:3000")
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
