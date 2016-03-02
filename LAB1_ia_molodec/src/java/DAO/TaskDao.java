/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.Task;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public interface TaskDao {

    List<Task> listAllTasks();

    Task getTaskById(Integer taskId);

    Task addTask(Task task);

    boolean deleteTask(Task task);

    public boolean editTask(Task task);
}
