package server.jwt.lhtp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.jwt.lhtp.entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {
}
