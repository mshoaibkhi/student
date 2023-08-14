package stdmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stdmgmt.models.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
