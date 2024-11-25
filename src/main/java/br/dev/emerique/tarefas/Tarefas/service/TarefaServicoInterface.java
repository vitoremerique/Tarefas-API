package br.dev.emerique.tarefas.Tarefas.service;

import br.dev.emerique.tarefas.Tarefas.model.Tarefa;

import java.util.List;


public interface TarefaServicoInterface {

    Tarefa findById(long id);
    Tarefa salvar(Tarefa tarefa);
    Tarefa atualizar(Tarefa tarefa);
    Tarefa deletar(Tarefa tarefa);
    void deletarTudo();
    List<Tarefa> listaTudo();
}
