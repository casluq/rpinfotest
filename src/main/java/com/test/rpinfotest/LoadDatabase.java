package com.test.rpinfotest;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.rpinfotest.entity.Anotacao;
import com.test.rpinfotest.entity.Cliente;
import com.test.rpinfotest.entity.Endereco;
import com.test.rpinfotest.entity.Equipamento;
import com.test.rpinfotest.entity.OrdemDeServico;
import com.test.rpinfotest.enums.OrdemDeServicoStatus;
import com.test.rpinfotest.repository.OrdemDeServicoRepository;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    
    @Bean
    CommandLineRunner initDatabase(OrdemDeServicoRepository repository) {
        var enderecoA = new Endereco();
        enderecoA.setRua("Rua Amaral Filho");
        enderecoA.setBairro("Trindade");
        enderecoA.setCidade("São Paulo");
        enderecoA.setEstado("São Paulo");
        enderecoA.setUf("SC");
        
        var clienteA = new Cliente();
        clienteA.setNome("Denis o Jovem");
        clienteA.setTelefone("41 99999-9910");
        clienteA.setEmail("clienteA@email.com");
        clienteA.setEndereco(enderecoA);

        var equipamentoA = new Equipamento();
        equipamentoA.setMarca("Samgung");
        equipamentoA.setTipo("Samsung Galaxy S23");
        equipamentoA.setProblema("Tela Quebrada");
        
        var odsPendente = new OrdemDeServico();
        odsPendente.setCliente(clienteA);
        odsPendente.setEquipamento(equipamentoA);
        odsPendente.setStatus(OrdemDeServicoStatus.PENDENTE);

        var enderecoB = new Endereco();
        enderecoB.setRua("Rua das Arvores");
        enderecoB.setBairro("Graciosa");
        enderecoB.setCidade("Londrina");
        enderecoB.setEstado("Paraná");
        enderecoB.setUf("PR");

        var clienteB = new Cliente();
        clienteB.setNome("Samanta");
        clienteB.setTelefone("41 97777-7710");
        clienteB.setEmail("clienteA@email.com");
        clienteB.setEndereco(enderecoB);

        var equipamentoB = new Equipamento();
        equipamentoB.setMarca("Samgung");
        equipamentoB.setTipo("Samsung Galaxy S23");
        equipamentoB.setProblema("Tela Quebrada");
        
        var odsEmAndamento = new OrdemDeServico();
        odsEmAndamento.setCliente(clienteB);
        odsEmAndamento.setEquipamento(equipamentoB);
        odsEmAndamento.setInicioDaManutencao(Instant.parse("2024-08-02T12:00:00.00Z"));
        odsEmAndamento.setStatus(OrdemDeServicoStatus.EM_ANDAMENTO);

        var enderecoC = new Endereco();
        enderecoC.setRua("Rua Stragenberg");
        enderecoC.setBairro("Floes");
        enderecoC.setCidade("Florianopolis");
        enderecoC.setEstado("Florianopolis");
        enderecoC.setUf("SC");

        var clienteC = new Cliente();
        clienteC.setNome("Adhonis silva");
        clienteC.setTelefone("41 98888-8810");
        clienteC.setEmail("clientec@email.com");
        clienteC.setEndereco(enderecoC);

        var equipamentoC = new Equipamento();
        equipamentoC.setMarca("Iphone");
        equipamentoC.setTipo("Iphone 14");
        equipamentoC.setProblema("Bateria Estufada");
        
        var anotacao = new Anotacao();
        anotacao.setData(Instant.parse("2024-08-03T18:00:00.00Z"));
        anotacao.setDescricao("Foi realizada a troca da bateria estufada por uma nova.");

        var odsConcluida = new OrdemDeServico();
        odsConcluida.setCliente(clienteC);
        odsConcluida.setEquipamento(equipamentoC);
        odsConcluida.setAnotacoes(List.of(anotacao));
        odsConcluida.setInicioDaManutencao(Instant.parse("2024-08-03T16:00:00.00Z"));
        odsConcluida.setFimDaManutencao(Instant.parse("2024-08-03T18:00:00.00Z"));
        odsConcluida.setStatus(OrdemDeServicoStatus.CONCLUIDO);
        
        return args -> {
            log.info("Preloading " + repository.save(odsPendente));
            log.info("Preloading " + repository.save(odsEmAndamento));
            log.info("Preloading " + repository.save(odsConcluida));
          };
    }
}
