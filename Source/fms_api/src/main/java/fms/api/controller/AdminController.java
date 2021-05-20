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

import fms.api.entity.Admin;
import fms.api.exception.ResourceNotFoundException;
import fms.api.repository.AdminRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;
	
	@GetMapping("/getAllAdmin")
	public List<Admin> getAllAdmin(){
	 return adminRepository.findAll();	
	}
	
	@GetMapping("getAdmin/{userName}/{password}")
	public ResponseEntity<Admin> getAdmin(@PathVariable(value = "userName") String userName,
			@PathVariable(value = "password") String password){	
		Admin admin = adminRepository.getAdmin(userName, password);
		
		return admin == null? null : ResponseEntity.ok().body(admin);
	}
	
	@GetMapping("getAdminById/{userName}")
	public ResponseEntity<Admin> getAdminById(@PathVariable(value = "userName") String userName) throws ResourceNotFoundException{
		Admin admin = 
				adminRepository
				.findById(userName).orElseThrow(() -> new ResourceNotFoundException("Admin not found ::" + userName));
		return ResponseEntity.ok().body(admin);
	}
	
	@PostMapping("/addAdmin")
	public Admin addAdmin(@Validated @RequestBody Admin admin) {
		return adminRepository.save(admin);
	}
	
	@PutMapping("/updateAdmin/{userName}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable(value = "userName") String userName, @Validated @RequestBody Admin adminDetails) throws ResourceNotFoundException{
		Admin admin = adminRepository
				.findById(userName)
				.orElseThrow(() -> new ResourceNotFoundException("User not found ::" + userName));
		
//		admin.setEmail(adminDetails.getEmail());
//		admin.setName(adminDetails.getName());
//		admin.setPhone(adminDetails.getPhone());
//		admin.setAddress(adminDetails.getAddress());
//		admin.setPassword(adminDetails.getPassword());
//		admin.setIsActive(adminDetails.getIsActive());
//		admin.setIdSkill(adminDetails.getIdSkill());
//		
//		admin.setIsReceiveNotification(adminDetails.getIsReceiveNotification());
		final Admin admins  = adminRepository.save(admin);
		return ResponseEntity.ok(admins);
	}
	
	@DeleteMapping("/deleteAdmin/{userName}")
	public Map<String, Boolean> deleteAdmin(@PathVariable(value = "userName") String userName) throws ResourceNotFoundException{
		Admin admin = adminRepository
				.findById(userName)
				.orElseThrow(() -> new ResourceNotFoundException("User not found ::" + userName));
		adminRepository.delete(admin);
		Map<String,Boolean> respone = new HashMap<>();
		respone.put("deleted", Boolean.TRUE);
		return respone;
	}

}

