package server.jwt.lhtp.service.impl;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.jwt.lhtp.entity.Role;
import server.jwt.lhtp.entity.Shop;
import server.jwt.lhtp.entity.User;
import server.jwt.lhtp.repository.ShopRepository;
import server.jwt.lhtp.repository.UserRepository;
import server.jwt.lhtp.service.ShopServicce;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
public class ShopServiceImpl  implements ShopServicce {


    @Autowired
    UserRepository userRepository;

    @Autowired
    ShopRepository shopRepository;


    @Autowired
    EntityManager entityManager;


    private Optional<User> getUserInfo(Integer id)
    {
        Optional<User> user = userRepository.findUserById(id);
        return user;
    }

    private boolean checkShopRoles(Integer id)
    {
        Optional<User> user = getUserInfo(id);
        Set<Role> roles = user.get().getRoles();
        String shopRole = roles.stream().filter(elm -> ("ROLE_MODERATIOR").equals(elm.getName())).toString();
        if(!shopRole.isEmpty())
            return true;
        else
            return false;
    }
    @Override
    public Shop addShop(Integer id, Shop shop) {
        Optional<User> user = getUserInfo(id);
        if(checkShopRoles(id))
        {
            shop.setUser(user.get());
            shopRepository.save(shop);
        }
        return null;
    }

    @Override
    public Collection<Shop> viewAllShop() {
        return null;
    }

    @Override
    public Optional<Shop> findById(Long id) {
        Integer shopId = Math.toIntExact(id);
        String findShop = "FROM Shop where id = :shop_id";
        Query query = entityManager.createQuery(findShop);
        query.setParameter("shop_id", shopId);
        Optional<Shop> shop = (Optional<Shop>) query.getSingleResult();
        return shop;
    }

    @Override
    public Boolean deleteShop(Integer id) {
        return null;
    }
}
