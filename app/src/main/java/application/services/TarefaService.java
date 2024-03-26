package application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Tarefa;
import application.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;


    public List<Tarefa> getAll() throws Exception {
        try {

            return (List<Tarefa>) tarefaRepository.findAll();

        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    
    public Tarefa getById(Long id) throws Exception {
        try {

            return id != null ? tarefaRepository.findById(id).get() : null;

        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    public Tarefa create(Tarefa tarefa) throws Exception {
        try {

            return tarefa != null ? tarefaRepository.save(tarefa) : null;
     
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    public Tarefa updateById(Tarefa tarefa, Long id) throws Exception {
        try {
            if (id != null) {

                Tarefa find = tarefaRepository.findById(id).get();
                return find != null && tarefa != null ? tarefaRepository.save(tarefa) : null;

            } else {
                return null;
            }
     
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    public void deleteById(Long id) throws Exception {
        try {
            if (id != null) {
                Tarefa find = tarefaRepository.findById(id).get();
                if (find != null) {
                    tarefaRepository.deleteById(id);
                }
            }

        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }


    
}
