package edu.labs.controllers;

import edu.labs.dto.TaskAssignmentDTO;
import edu.labs.dto.TaskDTO;
import edu.labs.exceptions.BaseException;
import edu.labs.services.TaskAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TaskAssignmentController {
    @Resource
    private TaskAssignmentService taskAssignmentService;

    @PostMapping("/task_assignment")
    public ResponseEntity<Long> saveTask(@Validated @RequestBody final TaskAssignmentDTO dto) {
        return ResponseEntity.ok().body(taskAssignmentService.createTaskAssignment(dto));
    }

    @PutMapping("/task_assignment")
    public ResponseEntity<TaskAssignmentDTO> updateTask(@Validated @RequestBody final TaskAssignmentDTO dto) throws BaseException {
        return ResponseEntity.ok().body(taskAssignmentService.updateTaskAssignment(dto));
    }

    @GetMapping("/task_assignments")
    public ResponseEntity<List<TaskAssignmentDTO>> getAllTasks() {
        return ResponseEntity.ok().body(taskAssignmentService.getAllTaskAssignments());
    }

    @GetMapping("/task_assignment/{id}")
    public ResponseEntity<TaskAssignmentDTO> getTaskAssignmentById(@PathVariable final Long id) throws BaseException {
        return ResponseEntity.ok().body(taskAssignmentService.getTaskAssignmentById(id));
    }

    @DeleteMapping("/task_assignment/{id}")
    public ResponseEntity deleteTaskAssignmentById(@PathVariable final Long id) throws BaseException {
        taskAssignmentService.removeTaskAssignmentById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/task_assignment/employee/{id}")
    public ResponseEntity<List<TaskDTO>> getTasksByEmployee(@PathVariable final Long id) throws BaseException {
        return ResponseEntity.ok().body(taskAssignmentService.findTasksByEmployeeId(id));
    }

    @GetMapping("/task_assignment/reporter/{id}")
    public ResponseEntity<List<TaskDTO>> getTasksByReporter(@PathVariable final Long id) throws BaseException {
        return ResponseEntity.ok().body(taskAssignmentService.findTasksByReporterId(id));
    }
}
