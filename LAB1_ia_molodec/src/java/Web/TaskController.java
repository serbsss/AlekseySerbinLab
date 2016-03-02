/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import DAO.TaskDao;
import Model.Task;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskDao taskDao;

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity with specified id not found")
    public void handleNotFoundException(NotFoundException ex, HttpServletResponse response)
            throws IOException {
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listAllTasks(Model ui) {
        ui.addAttribute("taskList", taskDao.listAllTasks());
        return "task/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getTaskById(@PathVariable("id") int taskId, Model ui) {
        Task task = taskDao.getTaskById(taskId);
        if (task == null) {
            throw new NotFoundException();
        }
        ui.addAttribute("task", task);
        return "task/show";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTask(Model model) {
        model.addAttribute("title", "Создание задачи");
        model.addAttribute("sendURL", "/task/add");
        return "/task/create";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTask(@ModelAttribute Task task, Model model) {
        taskDao.addTask(task);
        return "redirect:/task/";
    }

    @RequestMapping(value = "/{id}/remove", method = RequestMethod.GET)
    public String removeTask(@PathVariable("id") int id, Model ui) {
        ui.addAttribute("task", taskDao.getTaskById(id));
        return "/task/remove";
    }

    @RequestMapping(value = "/removeConfirm", method = RequestMethod.POST)
    public String removeTaskConfirm(@RequestParam("id") int id, Model model) {
        if (taskDao.deleteTask(taskDao.getTaskById(id))) {
            return "redirect:/task/";
        } else {
            return "redirect:/task/";
        }
    }

    
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editTask(@PathVariable("id") int id, Model model) {
        Task task = taskDao.getTaskById(id);
        if (task == null) {
            throw new NotFoundException();
        }
        model.addAttribute("title", "Редактирование задачи");
        model.addAttribute("sendURL", "/task/editConfirm");
        model.addAttribute("task", task);
        return "/task/create";
    }

    @RequestMapping(value = "/editConfirm", method = RequestMethod.POST)
    public String editTask(@ModelAttribute Task task, Model ui) {
        if (taskDao.editTask(task)) {
            return "redirect:/task/";
        } else {
            return "redirect:/task/";
        }
    }

}
