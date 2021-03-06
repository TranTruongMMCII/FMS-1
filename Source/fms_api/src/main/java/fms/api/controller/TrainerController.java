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

import fms.api.entity.Trainer;
import fms.api.exception.ResourceNotFoundException;
import fms.api.repository.TrainerRepository;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

	@Autowired
	private TrainerRepository trainerRepository;
	
	@GetMapping("/getAllTrainer")
	public List<Trainer> getAllTrainer(){
	 return trainerRepository.findAll();	
	}
	
	@GetMapping("getTrainerById/{userName}")
	public ResponseEntity<Trainer> getTrainerById(@PathVariable(value = "userName") String userName) throws ResourceNotFoundException{
		Trainer trainer = 
				trainerRepository
				.findById(userName).orElseThrow(() -> new ResourceNotFoundException("Trainer not found ::" + userName));
		return ResponseEntity.ok().body(trainer);
	}
	
	@PostMapping("/addTrainer")
	public Trainer addTrainer(@Validated @RequestBody Trainer trainer) {
		return trainerRepository.save(trainer);
	}
	
	@PutMapping("/updateTrainer/{userName}")
	public ResponseEntity<Trainer> updateTrainer(@PathVariable(value = "userName") String userName, @Validated @RequestBody Trainer trainerDetails) throws ResourceNotFoundException{
		Trainer trainer = trainerRepository
				.findById(userName)
				.orElseThrow(() -> new ResourceNotFoundException("User not found ::" + userName));
		
		trainer.setEmail(trainerDetails.getEmail());
		trainer.setName(trainerDetails.getName());
		trainer.setPhone(trainerDetails.getPhone());
		trainer.setAddress(trainerDetails.getAddress());
		trainer.setPassword(trainerDetails.getPassword());
		trainer.setIsActive(trainerDetails.getIsActive());
		trainer.setIdSkill(trainerDetails.getIdSkill());
		
		trainer.setIsReceiveNotification(trainerDetails.getIsReceiveNotification());
		final Trainer trainers  = trainerRepository.save(trainer);
		return ResponseEntity.ok(trainers);
	}
	
	@DeleteMapping("/deleteTrainer/{userName}")
	public Map<String, Boolean> deleteTrainer(@PathVariable(value = "userName") String userName) throws ResourceNotFoundException{
		Trainer trainer = trainerRepository
				.findById(userName)
				.orElseThrow(() -> new ResourceNotFoundException("User not found ::" + userName));
		trainerRepository.delete(trainer);
		Map<String,Boolean> respone = new HashMap<>();
		respone.put("deleted", Boolean.TRUE);
		return respone;
	}
}
