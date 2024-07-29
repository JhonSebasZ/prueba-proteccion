package com.prueba_proteccion.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba_proteccion.Entity.Task;
import com.prueba_proteccion.Reposirory.TaskRepository;

@Service
public class TaskServiceImp implements TaskService{
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task createNote(Task task) {
		Task newNote = taskRepository.save(task);
		return newNote;
	}

	@Override
	public Optional<Task> viewNoteId(int id) {
		Optional<Task> findTask = taskRepository.findById(id);
		return findTask;
	}

	@Override
	public List<Task> readNotes() {
		List<Task> listTask = taskRepository.findAll();
		return listTask;
	}

	@Override
	public Task updateNote(Task task) {
		Task updateTask = taskRepository.save(task);
		return updateTask;
	}

	@Override
	public void deleteNote(int id) {
		taskRepository.deleteById(id);
		
	}

}
