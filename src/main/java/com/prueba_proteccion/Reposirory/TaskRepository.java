package com.prueba_proteccion.Reposirory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prueba_proteccion.Entity.Task;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Integer> {

}
