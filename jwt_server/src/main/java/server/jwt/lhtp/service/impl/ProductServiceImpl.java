package server.jwt.lhtp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.jwt.lhtp.entity.Categories;
import server.jwt.lhtp.entity.Products;
import server.jwt.lhtp.entity.Shop;
import server.jwt.lhtp.repository.ProductRepository;
import server.jwt.lhtp.service.CategoriesService;
import server.jwt.lhtp.service.ProductService;
import server.jwt.lhtp.service.ShopServicce;

import javax.swing.text.html.Option;
import java.util.LinkedList;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    ShopServicce shopServicce;

    @Override
    public Products add(Long idShop, Long idCtg, Products products) {
       Optional<Shop> shop = shopServicce.findById(idShop);
       Categories categories =  categoriesService.findByCtgId(idCtg);
       products.setShops(shop.get());
       products.setCategories(categories);
       Products products1 =  repository.save(products);
       return products1;
    }

    @Override
    public LinkedList<Products> all() {
        return null;
    }

    @Override
    public Products findById(int id) {
        return null;
    }

    @Override
    public Boolean delete(int id) {
        return null;
    }
}
