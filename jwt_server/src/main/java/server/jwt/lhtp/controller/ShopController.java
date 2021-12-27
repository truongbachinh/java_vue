package server.jwt.lhtp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.jwt.lhtp.entity.Shop;
import server.jwt.lhtp.service.ShopServicce;

import javax.xml.ws.Response;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/shop")
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

    @Autowired
    ShopServicce shopServicce;

    @PostMapping(value = "/addShop/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<?> addShop(@PathVariable (value = "id") Integer id,
                                      @RequestBody Shop shop)
    {
       logger.info("-----Adding new shop-----");
       Shop result = shopServicce.addShop(id,shop);
       System.out.println(result);
       return new ResponseEntity<Shop>(shop,HttpStatus.CREATED);
    }

    @PostMapping(value = "/add/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<?> addShop(@PathVariable (value = "id") Integer id)
    {
        logger.info("-----Adding new shop-----");
//        Shop result = shopServicce.addShop(id,shop);
//        System.out.println(result);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private String testShop(){
        return "Test shopping infomation";
    }


}
