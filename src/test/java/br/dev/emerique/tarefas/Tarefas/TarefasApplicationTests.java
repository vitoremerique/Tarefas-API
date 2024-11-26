package br.dev.emerique.tarefas.Tarefas;

import br.dev.emerique.tarefas.Tarefas.model.Tarefa;
import br.dev.emerique.tarefas.Tarefas.service.TarefaServico;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TarefasApplicationTests {

    @Autowired
    private TarefaServico tarefaServico;

	@Test
	void contextLoads() {
	}

}
