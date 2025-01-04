package ru.linali.springwebtask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.linali.springwebtask.model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    List<Task> tasks = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, value = "/tasks")
    public String tasks(Model model, @RequestParam(value = "id", required = false) String id) {
            if (tasks.isEmpty()) {
                System.out.println("No tasks found");
                return "noTasks";
            }
            else {
                System.out.println("Found tasks");
                if (id != null) {
                    List<Task> taskId = tasks.stream().filter(i -> i.getId()==Integer.parseInt(id)).toList();
                    model.addAttribute("tasks", taskId);
                }
                else {
                    model.addAttribute("tasks", tasks);
                }
                return "tasks";
            }

    }
    @RequestMapping(method = RequestMethod.GET, value = "tasks/new")
    String newTask(Model model) {
        System.out.println("Creating new task");
        return "new";
    }
    @RequestMapping(method = RequestMethod.POST, value = "tasks/new")
    public String newTaskAdd(Model model,
                          @RequestParam("id") String id,
                          @RequestParam("name") String name,
                          @RequestParam("context") String context,
                          @RequestParam("appointmentDate") String appointmentDate) {
        System.out.println("Adding new task");
        int idInt = Integer.parseInt(id);
        tasks.add(new Task(idInt, name, context, LocalDate.now()));
        model.addAttribute("tasks",tasks);
        return "redirect:/tasks";
    }
}
