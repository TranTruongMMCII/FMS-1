package fms.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Trainee_Comment extends JpaRepository<Trainee_Comment, Integer>{
	@Query(nativeQuery = true, 
			value = "select * from Trainee_Comment a where a.ClassID =: classID")
	List<Trainee_Comment> findTraineeCommentByClassID(@Param ("ClassID") int classID);
	
	@Query(nativeQuery = true, 
			value = "select * from Trainee_Comment a where a.ModuleID =: moduleID")
	List<Trainee_Comment> findTraineeCommentByModuleID(@Param ("ModuleID") int moduleID);

	@Query(nativeQuery = true, 
			value = "select * from Trainee_Comment a where a.TraineeID =: traineeID")
	List<Trainee_Comment> findTraineeCommentByTraineeID(@Param ("TraineeID") String traineeID);

	@Query(nativeQuery = true,
			value = "select Comment from Trainee_Comment a "
					+ "where a.TraineeID =: traineeID and a.ModuleID =: moduleID"
					+ "and a.ClassID =: classID")
	String findCommentByID(@Param ("TraineeID") String traineeID,
			@Param ("ModuleID") int moduleID, @Param ("ClassID") int classID);
}
