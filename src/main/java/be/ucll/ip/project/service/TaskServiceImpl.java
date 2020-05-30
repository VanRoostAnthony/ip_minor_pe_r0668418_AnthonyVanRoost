package be.ucll.ip.project.service;

import be.ucll.ip.project.domain.SubTask;
import be.ucll.ip.project.domain.Task;
import be.ucll.ip.project.dto.SubTaskDTO;
import be.ucll.ip.project.dto.TaskDTO;
import be.ucll.ip.project.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
	private final TaskRepository repository;

	@Autowired
	public TaskServiceImpl(TaskRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Task> gettasks() {
		return repository.gettasks();
	}

	@Override
	public Task getTaskById(int id) {
		return repository.getTaskById(id);
	}

	@Override
	public TaskDTO getTaskDTO(int id) {
		Task task = repository.getTaskById(id);
		TaskDTO dto = new TaskDTO();
		dto.setTitle(task.getTitle());
		dto.setDescription(task.getDescription());
		dto.setDueDate(task.getDueDate());
		dto.setId(task.getId());
		return dto;
	}

	@Override
	public void addTask(TaskDTO taskDTO) {
		if(taskDTO.getId() == 0){
			taskDTO.setId(repository.gettasks().size()+1);
		}

		if(repository.getTaskById(taskDTO.getId())!=null){
			System.out.println("task with this id already exists");
		}else{
			Task task = new Task(taskDTO.getId(), taskDTO.getTitle(), taskDTO.getDueDate(), taskDTO.getDescription());
			repository.addtask(task);
		}
	}

	@Override
	public void editTask(TaskDTO taskDTO) {
		Task task = repository.getTaskById(taskDTO.getId());

		System.out.println("testing editTask service");
		task.setTitle(taskDTO.getTitle());
		task.setDescription(taskDTO.getDescription());
		task.setDueDate(taskDTO.getDueDate());
	}

	@Override
	public void addSubTask(Task task, SubTaskDTO subTaskDTO) {
		SubTask subTask = new SubTask(subTaskDTO.getTitle(), subTaskDTO.getDescription());
		task.addSubTask(subTask);
	}
}
