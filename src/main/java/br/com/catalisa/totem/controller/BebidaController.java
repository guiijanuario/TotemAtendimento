package br.com.catalisa.totem.controller;

import br.com.catalisa.totem.model.BebidaModel;
import br.com.catalisa.totem.model.LancheModel;
import br.com.catalisa.totem.repository.BebidaRepository;
import br.com.catalisa.totem.repository.LancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Scanner;

public class BebidaController {

    private final BebidaRepository bebidaRepository;

    @Autowired
    public BebidaController(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    public void criarBebida() {

        System.out.print("Digite o nome da Bebida: ");
        String nome = new Scanner(System.in).nextLine();
        System.out.print("Digite o valor da Bebida: ");
        BigDecimal valor = new Scanner(System.in).nextBigDecimal();

        // Crie uma nova instância de LancheModel com os dados recebidos do Scanner
        BebidaModel novaBebida = new BebidaModel();
        novaBebida.setNome(nome);
        novaBebida.setValor(valor);

        // Salve o novo lanche no repositório
        BebidaModel bebidaSalvo = bebidaRepository.save(novaBebida);

        ResponseEntity.ok(bebidaSalvo);
    }
}
