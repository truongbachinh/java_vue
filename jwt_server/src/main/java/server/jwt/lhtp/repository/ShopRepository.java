package server.jwt.lhtp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.jwt.lhtp.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop,Integer> {
}
