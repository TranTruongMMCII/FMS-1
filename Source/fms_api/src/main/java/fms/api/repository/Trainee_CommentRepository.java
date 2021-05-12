package fms.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fms.api.entity.Trainee_Comment;

@Repository
public interface Trainee_CommentRepository extends JpaRepository<Trainee_Comment, Integer>{
	@Query(nativeQuery = true, 
			value = "select * from Trainee_Comment a where a.ClassID= :classID")
	List<Trainee_CommentRepository> findTraineeCommentByClassID(@Param ("classID") int classID);
	
	@Query(nativeQuery = true, 
			value = "select * from Trainee_Comment a where a.ModuleID= :moduleID")
	List<Trainee_CommentRepository> findTraineeCommentByModuleID(@Param ("moduleID") int moduleID);

	@Query(nativeQuery = true, 
			value = "select * from Trainee_Comment a where a.TraineeID= :traineeID")
	List<Trainee_CommentRepository> findTraineeCommentByTraineeID(@Param ("traineeID") String traineeID);

	@Query(nativeQuery = true,
			value = "select Comment from Trainee_Comment a "
					+ "where a.TraineeID = :traineeID and a.ModuleID = :moduleID"
					+ "and a.ClassID = :classID")
	String findCommentByID(@Param ("traineeID") String traineeID,
			@Param ("moduleID") int moduleID, @Param ("classID") int classID);
}
