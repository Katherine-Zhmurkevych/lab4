package edu.labs.services;

import java.util.List;

import edu.labs.dto.TaskAssignmentDTO;
import edu.labs.dto.TaskDTO;
import edu.labs.entities.Customer;
import edu.labs.entities.Employee;
import edu.labs.entities.Task;
import edu.labs.exceptions.BaseException;
import edu.labs.exceptions.CustomerNotFoundException;
import edu.labs.exceptions.EmployeeNotFoundException;

public interface TaskAssignmentService {

    List<TaskAssignmentDTO> getAllTaskAssignments();

    TaskAssignmentDTO getTaskAssignmentById(final Long id) throws BaseException;

    TaskAssignmentDTO updateTaskAssignment(TaskAssignmentDTO dto) throws BaseException;

    void removeTaskAssignment(TaskAssignmentDTO dto);

    Long createTaskAssignment(TaskAssignmentDTO dto);

    void removeTaskAssignmentById(Long id) throws BaseException;

    List<TaskDTO> findTasksByEmployee(final Employee employee);

    List<TaskDTO> findTasksByReporter(final Customer customer);

    List<TaskDTO> findTasksByEmployeeId(Long id) throws BaseException;

    List<TaskDTO> findTasksByReporterId(Long id) throws BaseException;
}
