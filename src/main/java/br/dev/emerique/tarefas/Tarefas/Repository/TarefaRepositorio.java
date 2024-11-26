package br.dev.emerique.tarefas.Tarefas.Repository;

import br.dev.emerique.tarefas.Tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TarefaRepositorio extends JpaRepository<Tarefa, Long> {

    @Query("FROM Tarefa t where t.titulo = ?1")
    List<Tarefa> findByTitulo(String titulo);

}


