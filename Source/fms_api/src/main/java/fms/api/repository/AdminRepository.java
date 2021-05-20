package fms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fms.api.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
	@Query(nativeQuery = true,
			value = "select * from Admin a where a.UserName =:userName and a.Password =:password")
	Admin getAdmin(@Param ("userName") String userName,
				@Param ("password") String password);
}
