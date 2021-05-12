package fms.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fms.api.entity.Feedback;
//import fms.api.entity.FeedbackGetResult;
import fms.api.exception.ResourceNotFoundException;
import fms.api.repository.FeedbackRepository;

@RestController
@RequestMapping("/api/v1")
public class FeedbackController {
	
	@Autowired
	private FeedbackRepository repository;
	
	@GetMapping("/Feedback")
	public List<Feedback> getAllFeedbacks() {
		return repository.getFeedbackList();
	}
	
	@GetMapping("/last_Feedback")
	public Feedback getLastFeedback() {
		return repository.getLastFeedback();
	}
	
	@GetMapping("/Feedback/{id}")
	public ResponseEntity<Feedback> getFeedbackById(@PathVariable(value = "id") Long feedbackId) 
			throws ResourceNotFoundException {
		Feedback feedback = repository.findById(feedbackId)
				.orElseThrow(()->new ResourceNotFoundException("Feedback not found on :: " + feedbackId));
		return ResponseEntity.ok().body(feedback);
	}
	
	@PostMapping("/Feedback")
	public Feedback addFeedback(@Validated @RequestBody Feedback feedback) {
		return repository.save(feedback);
	}
	

	@Transactional
	@PostMapping("/Feedback/{title}/{userName}/{typeID}")
	public void insertFeedback(@PathVariable(value = "title") String title, @PathVariable(value = "userName") String userName, @PathVariable(value = "typeID") Long typeId) throws ResourceNotFoundException {
		repository.insertFeedback(title, userName, typeId);
	}
	

	@PutMapping("/Feedback/{id}")
	public ResponseEntity<Feedback> updateFeedback(@PathVariable(value = "id") Long feedbackId, @Validated @RequestBody Feedback feedbackDetail)
		throws ResourceNotFoundException {
		Feedback feedback = repository.findById(feedbackId)
		.orElseThrow(()->new ResourceNotFoundException("Feedback not found on ::"+ feedbackId));
		feedback.setAdminID(feedbackDetail.getAdminID());
		
		final Feedback feedback2 = repository.save(feedback);
		return ResponseEntity.ok(feedback2);
	}
	

	@Transactional
	@PutMapping("/Feedback/{id}/{typeid}/{title}")
	public void updateFeedback(@PathVariable(value = "id") Long id, @PathVariable(value = "typeid") Long typeId, @PathVariable(value = "title") String title) throws ResourceNotFoundException {
		repository.updateFeedback(id, typeId, title);
	}
	
	@DeleteMapping("/Feedback/{id}")
	public Map<String, Boolean> deleteFeedback(@PathVariable(value = "id") Long feedbackId) throws Exception {
		Feedback feedback = repository.findById(feedbackId).orElseThrow(()->new ResourceNotFoundException("Feedback not found on :: " + feedbackId));
		repository.delete(feedback);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return response;
	}

}