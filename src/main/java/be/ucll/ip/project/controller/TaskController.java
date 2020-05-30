package be.ucll.ip.project.controller;

import be.ucll.ip.project.domain.SubTask;
import be.ucll.ip.project.dto.SubTaskDTO;
import be.ucll.ip.project.dto.TaskDTO;
import be.ucll.ip.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
	private final TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping("/")
	public String index() {
		return "redirect:/tasks";
	}

	@GetMapping("/tasks")
	public String gettasks(Model model){
		model.addAttribute("tasks", taskService.gettasks());
		return "tasks";
	}

	@GetMapping("/tasks/{id}")
	public String gettask(Model model, @PathVariable("id") int id){

		if(taskService.getTaskById(id) == null){
			System.out.println("task does not exist");
			model.addAttribute("task", null);
			return "task";
		}
		model.addAttribute("task", taskService.getTaskDTO(id));
		model.addAttribute("subtasks", taskService.getTaskById(id).getSubTasks());
		return "task";
	}

	@PostMapping("/tasks/new")
	public String addTask(@ModelAttribute TaskDTO taskDTO){
		taskService.addTask(taskDTO);
		return "redirect:/tasks";
	}

	@GetMapping("/tasks/new")
	public String newTask(){
		return "new";
	}

	@GetMapping("/tasks/edit/{id}")
	public String taskEditor(Model model, @PathVariable("id") int id){
		if(taskService.getTaskById(id) == null){
			System.out.println("task does not exist");
			model.addAttribute("task", null);
			return "edit";
		}
		System.out.println(id);
		model.addAttribute("task", taskService.getTaskDTO(id));
		return "edit";
	}

	@PostMapping("/tasks/edit/{id}")
	public String editTask(@ModelAttribute TaskDTO taskDTO){
		int id = taskDTO.getId();
		taskService.editTask(taskDTO);
		System.out.println("method POST edit received in controller");
		return "redirect:/tasks/"+id;
	}

	@GetMapping("/tasks/{id}/sub/create")
	public String subTask(Model model, @PathVariable("id") int id){
		if(taskService.getTaskById(id) == null){
			System.out.println("task does not exist");
			model.addAttribute("task", null);
			return "edit";
		}
		System.out.println(id);
		model.addAttribute("task", taskService.getTaskDTO(id));
		return "subtask";
	}

	@PostMapping("/tasks/{id}/sub/create")
	public String addSubTask(@ModelAttribute SubTaskDTO subTaskDTO, @PathVariable("id") int id){
		taskService.addSubTask(taskService.getTaskById(id), subTaskDTO);
		return "redirect:/tasks/"+id;
	}

}
