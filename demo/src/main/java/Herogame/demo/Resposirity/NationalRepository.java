package Herogame.demo.Resposirity;

import Herogame.demo.Entity.National;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalRepository extends JpaRepository<National, Integer> {

}
