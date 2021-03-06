package fms.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fms.api.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
