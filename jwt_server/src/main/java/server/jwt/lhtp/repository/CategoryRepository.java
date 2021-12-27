package server.jwt.lhtp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.jwt.lhtp.entity.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {
}
