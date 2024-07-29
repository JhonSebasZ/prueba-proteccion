package com.prueba_proteccion.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prueba_proteccion.Entity.Task;
import com.prueba_proteccion.Service.TaskServiceImp;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	TaskServiceImp taskServiceImp;
	
	@GetMapping("")
	public String verPaginaDeInicio(Model model) {
		var task = taskServiceImp.readNotes();
		model.addAttribute("tasks", task);
		return "index";
	}
	
	@GetMapping("/add")
	public String add(Task task) {
		return "form";
	}
	
	@GetMapping("/edit/{idTask}")
	public String edit(@PathVariable int idTask, Task task, Model model) {
		Optional<Task> updatetask = taskServiceImp.viewNoteId(idTask);
		model.addAttribute("tasks", updatetask);
		return "form";
	}
	
	@GetMapping("/delete/{idTask}")
	public String delete(@PathVariable int idTask) {
		taskServiceImp.deleteNote(idTask);
		return "redirect:/task";
	}
	
	@PostMapping("/save")
	public String save(Task task) {
		taskServiceImp.createNote(task);
		return "redirect:/task";
	}
	
	@GetMapping("/complete/{idTask}")
	public String complete(@PathVariable int idTask) {
		Optional<Task> updateNote = taskServiceImp.viewNoteId(idTask);
		if(updateNote.isPresent()) {
			Task task = updateNote.get();
			task.setComplete(true);
			taskServiceImp.createNote(task);
		}
		return "redirect:/task";
	}

}
