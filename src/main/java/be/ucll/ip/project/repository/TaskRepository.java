package be.ucll.ip.project.repository;

import be.ucll.ip.project.domain.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
	private List<Task> list;

	public TaskRepository() {
		list = new ArrayList<>();
		list.add(new Task(1,"eerste taak", LocalDateTime.now(), "de eerste taak"));
		list.add(new Task(2,"tweede taak", LocalDateTime.now(),"de tweede taak"));

	}

	public List<Task> gettasks() {
		return list;
	}

	public Task getTaskById(int id){
		for (int i = 0; i < list.size() ; i++){
			if(list.get(i).getId() == id){
				return list.get(i);
			}
		}
		return null;
	}


	public void addtask(Task task) {
		list.add(task);
	}
}
