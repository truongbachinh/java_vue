package server.jwt.lhtp.service;

import org.springframework.stereotype.Service;
import server.jwt.lhtp.entity.Shop;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;


public interface ShopServicce {

    Shop addShop(Integer id, Shop shop);
    Collection<Shop> viewAllShop();
    Optional<Shop> findById(Long id);
    Boolean deleteShop(Integer id);
}
