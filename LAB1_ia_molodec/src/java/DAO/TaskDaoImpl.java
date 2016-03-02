/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Task;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private DataSource datasource;

    @Override
    public List<Task> listAllTasks() {
        try {
            ArrayList<Task> taskList = new ArrayList<>();
            String query = "SELECT * FROM task";
            PreparedStatement stmt = datasource.getConnection().prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Task t = new Task(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4));
                taskList.add(t);
            }
            return taskList;
        } catch (Exception e) {
            throw new RuntimeException("An error has occurred in listAllTasks method", e);
        } finally {
            try {
                datasource.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(TaskDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Task addTask(Task task) {
        try {
            String query = "INSERT INTO task (name, description, dueDate) VALUES (?, ?, ?)";
            PreparedStatement stmt = datasource.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, task.getName());
            stmt.setString(2, task.getDescription());
            stmt.setTimestamp(3, new Timestamp(task.getDueDate().getTime()));
            stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();
            if (resultSet.next()) {
                task.setId(resultSet.getInt(1));
                return task;
            }
            throw new Exception("Task not added to db");
        } catch (Exception e) {
            throw new RuntimeException("An error has occurred in addTask method", e);
        } finally {
            try {
                datasource.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(TaskDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Task getTaskById(Integer taskId) {
        try {
            String query = "SELECT * from task WHERE id=?";
            PreparedStatement statement = datasource.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, taskId);
            ResultSet results = statement.executeQuery();
            if (results.next()) {
                Task task = new Task();
                task.setId(taskId);
                task.setName(results.getString(2));
                task.setDescription(results.getString(3));
                task.setDueDate(results.getDate(4));
                return task;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("Произошла ошибка во время вызова метода getTaskById", e);
        }
    }

    @Override
    public boolean deleteTask(Task task) {
        try {
            String query = "DELETE FROM task WHERE idTask=?";
            PreparedStatement statement = datasource.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, task.getId());
            statement.execute();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Произошла ошибка во время вызова метода deleteTask", e);
        }
    }

    @Override
    public boolean editTask(Task task) {
        try {
            String query = "UPDATE task SET name=?, description=?, due_date=? WHERE idTask=?";
            PreparedStatement statement = datasource.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setDate(3, task.getDueDate());
            statement.setInt(4, task.getId());
            statement.execute();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Произошла ошибка во время вызова метода editTask", e);
        }
    }
}
