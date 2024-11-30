package br.dev.emerique.tarefas.Tarefas.service;

import br.dev.emerique.tarefas.Tarefas.Repository.TarefaRepositorio;
import br.dev.emerique.tarefas.Tarefas.model.Prioridade;
import br.dev.emerique.tarefas.Tarefas.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaServico implements TarefaServicoInterface {

    @Autowired
    private TarefaRepositorio repository;


    @Override
    public Tarefa findById(long id) {
        Optional<Tarefa> tarefa = repository.findById(id);
        return tarefa.orElse(null);
    }

    @Override
    public Tarefa salvar(Tarefa tarefa) {
        if(repository.existsById(tarefa.getId())){
            return null;
        }
        return repository.save(tarefa);
    }

    @Override
    public Tarefa atualizar(Tarefa tarefa) {
        Optional<Tarefa> tarefaAtt = repository.findById(tarefa.getId());
        tarefaAtt.get().setTitulo(tarefa.getTitulo());
        tarefaAtt.get().setDescricao(tarefa.getDescricao());
        tarefaAtt.get().setStatus(tarefa.getStatus());
        tarefaAtt.get().setPrioridade(tarefa.getPrioridade());
        return repository.save(tarefa);

    }

    @Override
    public Tarefa deletar(Tarefa tarefa) {
        Optional<Tarefa> tarefaDeletar = repository.findById(tarefa.getId());
        repository.delete(tarefaDeletar.get());
        return tarefaDeletar.get();
    }



    @Override
    public List<Tarefa> buscarPorTitulo(String titulo) {
        List<Tarefa> tarefas = repository.findByTituloIgnoreCase(titulo);
        return tarefas;


    }



    @Override
    public void deletarTudo() {
        List<Tarefa> tarefas = repository.findAll();
        repository.deleteAll();
        
    }

    @Override
    public List<Tarefa> listaTudo() {
        List<Tarefa> listaTarefa = repository.findAll();
        return listaTarefa;
    }

    @Override
    public List<Tarefa> buscarPorPrioridade(Prioridade prioridade) {
         List<Tarefa> tarefasPrioridade = repository.findByPrioridade(prioridade);
         return tarefasPrioridade;
    }
}

