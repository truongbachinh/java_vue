package server.jwt.lhtp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.jwt.lhtp.entity.Products;
import server.jwt.lhtp.security.payload.response.MessageResponse;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @PostMapping("/add")
    public ResponseEntity<?>  addProduct(@Valid @RequestBody Products products){
        return ResponseEntity.ok(new MessageResponse("Add product success"));

    }
}
