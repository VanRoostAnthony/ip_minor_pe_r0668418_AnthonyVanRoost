package be.ucll.ip.project.service;

import be.ucll.ip.project.domain.Task;
import be.ucll.ip.project.dto.SubTaskDTO;
import be.ucll.ip.project.dto.TaskDTO;

import java.util.List;

public interface TaskService {
	public List<Task> gettasks();

	public Task getTaskById(int id);

	public TaskDTO getTaskDTO(int id);

	public void addTask(TaskDTO taskDTO);

	public void editTask(TaskDTO taskDTO);

	public void addSubTask(Task task, SubTaskDTO subTaskDTO);
}
