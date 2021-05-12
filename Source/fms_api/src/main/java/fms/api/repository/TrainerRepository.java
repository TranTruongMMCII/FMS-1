package fms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fms.api.entity.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, String>{
	
}
