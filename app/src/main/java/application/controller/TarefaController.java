package application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import application.model.Tarefa;
import application.repository.TarefaRepository;
import application.services.TarefaService;

@RestController("/api/v1/tarefas")
public class TarefaController {
    
    @Autowired
    private TarefaRepository repo;
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> getAll() {
        //return tarefaService.getAll();
        return new ArrayList<Tarefa>(); //(List<Tarefa>)repo.findAll();
    }


    @GetMapping("/{id}")
    public Tarefa getById(@PathVariable Long id) throws Exception {
        return tarefaService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Tarefa create(@RequestBody Tarefa tarefa) throws Exception {
        return tarefaService.create(tarefa);
    }


    @PutMapping
    public Tarefa updateById(@PathVariable Long id, @RequestBody Tarefa tarefa) throws Exception {
        return tarefaService.updateById(tarefa, id);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws Exception {
        tarefaService.deleteById(id);
    }



}
