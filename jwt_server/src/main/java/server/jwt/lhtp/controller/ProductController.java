package server.jwt.lhtp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import server.jwt.lhtp.dto.ProductDTO;
import server.jwt.lhtp.entity.Products;
import server.jwt.lhtp.message.ResponseMessage;
import server.jwt.lhtp.security.payload.response.MessageResponse;
import server.jwt.lhtp.service.FilesStorageService;
import server.jwt.lhtp.service.ProductService;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    FilesStorageService filesStorageService;


    @Autowired
    ProductService productService;

    @PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            filesStorageService.save(file);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/test")
    public String getTest(){
        return "Anhchinh Test";
    }


    @PostMapping(value = "/addProduct/{shopId}/{idCtg}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> addProduct(@PathVariable (value = "idCtg") Long idCtg,
                                        @PathVariable (value = "shopId") Long idShop,
                                        @Valid @RequestBody Products products){
        logger.info("-----Adding new product-----");
        System.out.println("Adad - >" + idCtg);

        Products result =  productService.add(idShop, idCtg, products);
        return new ResponseEntity<Products>(result,HttpStatus.CREATED);
    }

    @PostMapping("/upload-image")
    public ResponseEntity<?> uploadImage(@Valid @RequestBody MultipartFile multipartFile)
    {
        String message = null;
        return ResponseEntity.ok(new ResponseMessage(message));
    }
}
