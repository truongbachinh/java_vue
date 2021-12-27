package server.jwt.lhtp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import server.jwt.lhtp.entity.Categories;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

public interface CategoriesService {
    Optional<Categories> findByIdandCtgId(Long id, Long ctgId);
    Categories findByCtgId(Long id);
    Categories add(Categories categories);
    Collection<Categories> all();
    Boolean delete(int id);

}
