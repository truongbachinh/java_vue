package server.jwt.lhtp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Service;
import server.jwt.lhtp.entity.Categories;
import server.jwt.lhtp.repository.CategoryRepository;
import server.jwt.lhtp.service.CategoriesService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.Option;
import javax.xml.bind.SchemaOutputResolver;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;


@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    CategoryRepository categoryRepository;


    @Autowired
    EntityManager entityManager;
    @Override
    public Optional<Categories> findByIdandCtgId(Long id, Long ctgId) {
        return Optional.empty();
    }

    @Override
    public Categories findByCtgId(Long id) {
        System.out.println("id -> " + id);
        Integer ctgId = Math.toIntExact(id);
        String queryCtg = "FROM Categories c where c.id = :ctg_id";
        Query query = entityManager.createQuery(queryCtg);
        query.setParameter("ctg_id", ctgId);
        Categories result =  (Categories) query.getSingleResult();
         return result;
    }

    @Override
    public Categories add(Categories categories) {
        return categoryRepository.save(categories);
    }


    @Override
    public Collection<Categories> all() {
        Collection<Categories> categories =  new LinkedList<>();
        categories = categoryRepository.findAll();
        return categories;
    }

    @Override
    public Boolean delete(int id) {
        return null;
    }
}
