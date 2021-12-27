package server.jwt.lhtp.service;

import antlr.collections.List;
import server.jwt.lhtp.entity.Products;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public interface ProductService {
    Products add(Long idShop, Long idCtg, Products products);
    Collection<Products> all();
    Products findById(int id);
    Boolean delete(int id);
}
