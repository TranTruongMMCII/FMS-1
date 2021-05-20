package fms.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fms.api.entity.Trainee;
import fms.api.exception.ResourceNotFoundException;
import fms.api.repository.TraineeRepository;

@RestController
@RequestMapping("/api/trainee")
public class TraineeController {
	@Autowired
	private TraineeRepository traineeRepository;
	
	@GetMapping("/getAllTrainee")
	public List<Trainee> getAllTrainee(){
	 return traineeRepository.findAll();	
	}
	
	@GetMapping("getTraineeById/{userName}")
	public ResponseEntity<Trainee> getTraineeById(@PathVariable(value = "userName") String userName) throws ResourceNotFoundException{
		Trainee trainee = 
				traineeRepository
				.findById(userName).orElseThrow(() -> new ResourceNotFoundException("Trainee not found ::" + userName));
		return ResponseEntity.ok().body(trainee);
	}
	
	@PostMapping("/addTrainee")
	public Trainee addTrainee(@Validated @RequestBody Trainee trainee) {
		return traineeRepository.save(trainee);
	}
	
	@PutMapping("/updateTrainee/{userName}")
	public ResponseEntity<Trainee> updateTrainee(@PathVariable(value = "userName") String userName, @Validated @RequestBody Trainee traineeDetails) throws ResourceNotFoundException{
		Trainee trainee = traineeRepository
				.findById(userName)
				.orElseThrow(() -> new ResourceNotFoundException("User not found ::" + userName));
		
//		trainee.setEmail(traineeDetails.getEmail());
//		trainee.setName(traineeDetails.getName());
//		trainee.setPhone(traineeDetails.getPhone());
//		trainee.setAddress(traineeDetails.getAddress());
//		trainee.setPassword(traineeDetails.getPassword());
//		trainee.setIsActive(traineeDetails.getIsActive());
//		trainee.setIdSkill(traineeDetails.getIdSkill());
//		
//		trainee.setIsReceiveNotification(traineeDetails.getIsReceiveNotification());
		final Trainee trainees  = traineeRepository.save(trainee);
		return ResponseEntity.ok(trainees);
	}
	
	@DeleteMapping("/deleteTrainee/{userName}")
	public Map<String, Boolean> deleteTrainee(@PathVariable(value = "userName") String userName) throws ResourceNotFoundException{
		Trainee trainee = traineeRepository
				.findById(userName)
				.orElseThrow(() -> new ResourceNotFoundException("User not found ::" + userName));
		traineeRepository.delete(trainee);
		Map<String,Boolean> respone = new HashMap<>();
		respone.put("deleted", Boolean.TRUE);
		return respone;
	}

}
