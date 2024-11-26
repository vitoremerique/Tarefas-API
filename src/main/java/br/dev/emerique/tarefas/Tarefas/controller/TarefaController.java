package br.dev.emerique.tarefas.Tarefas.controller;

import br.dev.emerique.tarefas.Tarefas.model.Tarefa;
import br.dev.emerique.tarefas.Tarefas.service.TarefaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaServico repositorio;

    @PostMapping
    public Tarefa criaTarefa(@RequestBody Tarefa tarefa) {
        return repositorio.salvar(tarefa);
    }

    @GetMapping("/all")
    public List<Tarefa> listaTarefas() {
        List<Tarefa> tarefas = repositorio.listaTudo();
        if(tarefas != null) {
            return tarefas;
        }else{
            return null;
        }
    }

    @PutMapping
    public Tarefa atualizaTarefa(@RequestBody Tarefa tarefa) {
        return repositorio.atualizar(tarefa);
    }

    @DeleteMapping
    public void deletaTarefa(@RequestBody Tarefa tarefa) {
        repositorio.deletar(tarefa);
    }

    @DeleteMapping("/all")
    public void deletarTudo(){
        repositorio.deletarTudo();
    }



}
