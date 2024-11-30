package br.dev.emerique.tarefas.Tarefas.controller;

import br.dev.emerique.tarefas.Tarefas.model.Prioridade;
import br.dev.emerique.tarefas.Tarefas.model.Tarefa;
import br.dev.emerique.tarefas.Tarefas.service.TarefaServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaServico repositorio;

    @Operation(summary = "Cria uma nova tarefa", description = "Adiciona uma nova tarefa ao sistema com título, descrição, status e prioridade.")
    @PostMapping
    public Tarefa criaTarefa(@RequestBody @Parameter(description = "Informações da tarefa a ser criada") Tarefa tarefa) {
        return repositorio.salvar(tarefa);
    }

    @Operation(summary = "Lista todas as tarefas", description = "Retorna uma lista de todas as tarefas armazenadas no sistema.")
    @GetMapping("/all")
    public List<Tarefa> listaTarefas() {
        List<Tarefa> tarefas = repositorio.listaTudo();
        if (tarefas != null) {
            return tarefas;
        } else {
            return null;
        }
    }

    @Operation(summary = "Busca tarefas por título", description = "Retorna uma lista de tarefas com o título especificado.")
    @GetMapping("/name")
    public List<Tarefa> listaTarefasPorTitulo( @RequestParam(name = "titulo", required = false)
            @Parameter(description = "Título da tarefa para filtro", example = "Minha Tarefa") String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            return repositorio.listaTudo(); // Retorna todas as tarefas se o parâmetro não for fornecido
        }
        return repositorio.buscarPorTitulo(titulo);
    }


    @GetMapping("/prioridade")
    public List<Tarefa> listaTarefaPrioridade(@RequestParam(name = "nivel", required = false) Prioridade prioridade){

        return repositorio.buscarPorPrioridade(prioridade);
    }




    @Operation(summary = "Atualiza uma tarefa existente", description = "Atualiza os dados de uma tarefa com base no ID fornecido.")
    @PutMapping
    public Tarefa atualizaTarefa(@RequestBody @Parameter(description = "Dados da tarefa a ser atualizada") Tarefa tarefa) {
        return repositorio.atualizar(tarefa);
    }

    @Operation(summary = "Deleta uma tarefa", description = "Remove uma tarefa do sistema com base no ID fornecido.")
    @DeleteMapping
    public void deletaTarefa(@RequestBody @Parameter(description = "Tarefa a ser deletada") Tarefa tarefa) {
        repositorio.deletar(tarefa);
    }

    @Operation(summary = "Deleta todas as tarefas", description = "Remove todas as tarefas do sistema.")
    @DeleteMapping("/all")
    public void deletarTudo() {
        repositorio.deletarTudo();
    }
}
