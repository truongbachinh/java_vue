package server.jwt.lhtp.controller;


import javafx.application.Application;
import javafx.scene.media.Media;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.jwt.lhtp.entity.Categories;
import server.jwt.lhtp.service.CategoriesService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    CategoriesService categoriesService;



    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<?> add(@RequestBody Categories categories)
    {
        logger.info("-----Create new Category-----");
        Categories result =  categoriesService.add(categories);
        return new ResponseEntity<Categories>(result, HttpStatus.CREATED);
    }

    @PostMapping(value = "findBy/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<?> findBy(@PathVariable Long id)
    {
        logger.info("-----Category find by id-----");
        Categories categories = categoriesService.findByCtgId(id);
        return new ResponseEntity<Categories>(categories,HttpStatus.OK);
    }
}
