package com.prueba_proteccion.Service;

import java.util.List;
import java.util.Optional;

import com.prueba_proteccion.Entity.Task;

public interface TaskService {
	public Task createNote(Task task);
	public Optional<Task> viewNoteId(int id);
	public List<Task> readNotes();
	public Task updateNote(Task task);
	public void deleteNote(int id);
}
