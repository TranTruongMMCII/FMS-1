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
			value = "select * from Answer a where a.ClassID =: classID")
	List<Answer> findAnswerByClassId(@Param ("ClassID") int classID);

	@Query(nativeQuery = true, 
			value = "select * from Answer a where a.ModuleID =: moduleID")
	List<Answer> findAnswerByModuleId(@Param ("ModuleID") int moduleID);

	@Query(nativeQuery = true, 
			value = "select * from Answer a where a.TraineeID =: traineeID")
	List<Answer> findAnswerByTraineeId(@Param ("TraineeID") String traineeID);

	@Query(nativeQuery = true, 
			value = "select * from Answer a where a.QuestionID =: questionID")
	List<Answer> findAnswerByQuestionId(@Param ("QuestionID") int questionID);
	
	List<Answer> findAnswerByValue(Integer integer);
}