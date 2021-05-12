package fms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fms.api.exception.ResourceNotFoundException;
import fms.api.repository.Trainee_Comment;

@RestController
@RequestMapping("/api/comments")
public class TraineeCommentController {

	@Autowired
	Trainee_Comment repository;
	
	@GetMapping("/getAll")
	public List<Trainee_Comment> getAllComment() throws ResourceNotFoundException{
		return repository.findAll();
	}
	
	@GetMapping("/getComment/{classID}/{moduleID}/{traineeID}")
	public String getComment(
			@PathVariable(value = "classID") int classID,
			@PathVariable(value = "moduleID") int moduleID,
			@PathVariable(value = "traineeID") String traineeID) 
					throws ResourceNotFoundException {
			
		return repository.findCommentByID(traineeID, moduleID, classID);
	}
	
	@GetMapping("/getCommentsByClassID/{classID}")
	public List<Trainee_Comment> getCommentsByClassID(
			@PathVariable(value = "classID") int classID) 
					throws ResourceNotFoundException{
		return repository.findTraineeCommentByClassID(classID);
	}
	
	@GetMapping("/getCommentsByModuleID/{moduleID}")
	public List<Trainee_Comment> getCommentsByModuleID(
			@PathVariable(value = "moduleID") int moduleID) 
					throws ResourceNotFoundException{
		return repository.findTraineeCommentByModuleID(moduleID);
	}
	
	@GetMapping("/getCommentsByTraineeID/{traineeID}")
	public List<Trainee_Comment> getCommentsByTraineeID(
			@PathVariable(value = "traineeID") String traineeID) 
					throws ResourceNotFoundException{
		return repository.findTraineeCommentByTraineeID(traineeID);
	}
}
