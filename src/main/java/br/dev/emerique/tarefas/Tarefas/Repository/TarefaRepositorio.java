package br.dev.emerique.tarefas.Tarefas.Repository;

import br.dev.emerique.tarefas.Tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepositorio extends JpaRepository<Tarefa, Long> {



}
