package fms.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fms.api.entity.*;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, AnswerKey>{
	@Query(nativeQuery = true, 
			value = "select * from Answer a where a.ClassID=:ClassID")
	List<Answer> findAnswerByClassId(@Param ("ClassID") int classID);

	@Query(nativeQuery = true, 
			value = "select * from Answer a where a.ModuleID=:ModuleID")
	List<Answer> findAnswerByModuleId(@Param ("ModuleID") int moduleID);

	@Query(nativeQuery = true, 
			value = "select * from Answer a where a.TraineeID=:TraineeID")
	List<Answer> findAnswerByTraineeId(@Param ("TraineeID") String traineeID);

	@Query(nativeQuery = true, 
			value = "select * from Answer a where a.QuestionID=:QuestionID")
	List<Answer> findAnswerByQuestionId(@Param ("QuestionID") int questionID);
	
	List<Answer> findAnswerByValue(Integer integer);
}