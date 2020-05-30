package be.ucll.ip.project.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
	private int id;

	@NotEmpty(message = "Title cannot be empty")
	private String title;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime dueDate;

	private String description;

	private List<SubTask> subTasks = new ArrayList<>();

	public Task(int id, String title, LocalDateTime dueDate, String description) {
		this.id = id;
		this.title = title;
		this.dueDate = dueDate;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addSubTask(SubTask subTask){
		subTasks.add(subTask);
	}

	public List<SubTask> getSubTasks(){
		return subTasks;
	}
}

