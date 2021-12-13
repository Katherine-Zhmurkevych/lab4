package edu.labs.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.labs.dto.TaskDTO;
import edu.labs.exceptions.BaseException;
import edu.labs.services.TaskService;

@RestController
public class TaskController {
    @Resource
    private TaskService taskService;

    @PostMapping("/task")
    public ResponseEntity<Long> saveTask(@Validated @RequestBody final TaskDTO dto) {
        return ResponseEntity.ok().body(taskService.createTask(dto));
    }

    @PutMapping("/task")
    public ResponseEntity<TaskDTO> updateTask(@Validated @RequestBody final TaskDTO dto) throws BaseException {
        return ResponseEntity.ok().body(taskService.updateTask(dto));
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable final Long id) throws BaseException {
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity deleteTaskById(@PathVariable final Long id) throws BaseException {
        taskService.removeTaskById(id);
        return ResponseEntity.ok().build();
    }
}
