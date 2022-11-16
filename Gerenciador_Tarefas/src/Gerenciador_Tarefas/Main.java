package Gerenciador_Tarefas;

import controller.ProjectController;
import model.Project;

public class Main {
	
	public static void main(String[] args) {
		
		ProjectController projectController = new ProjectController();
		
		Project project = new Project();
		project.setName("Estudar");
		project.setDescription("estudar PYTHON");
		projectController.save(project);
		
	}

}
