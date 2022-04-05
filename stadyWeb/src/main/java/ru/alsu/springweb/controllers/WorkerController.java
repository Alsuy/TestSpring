package ru.alsu.springweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alsu.springweb.entity.User;
import ru.alsu.springweb.entity.Worker;
import ru.alsu.springweb.services.WorkerService;

import java.util.List;

@Controller
@RequestMapping("/worker")
public class WorkerController {
    private WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping()
    public String index(Model model) {
        List<Worker> list = this.workerService.getList();
        model.addAttribute("worker", list);
        return "worker/index";
    }

//    @GetMapping("/input")
//    public String input(Model model) {
//        List<Worker> list = this.workerService.getList();
//        model.addAttribute("worker", list);
//        return "worker/input";
//    }
//    @PostMapping("/input")
//    public String createPosition(@ModelAttribute("user") User user) {
//        workerService.setUser(user);
//        return "redirect:/worker";
   // }
    @GetMapping("/new")
    public String newWorker(@ModelAttribute("worker") Worker worker) {
        return "worker/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("worker") Worker worker) {
        workerService.save(worker);
        return "redirect:/worker";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("worker", workerService.show(id));
        return "worker/edit";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("worker", workerService.show(id));
        return "worker/show";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("document") Worker worker,
                         @PathVariable("id") int id) {
        workerService.update(id, worker);
        return "redirect:/worker";
    }

    @PostMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        workerService.delete(id);
        return "redirect:/worker";
    }
}
