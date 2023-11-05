package com.tobeto.spring.b;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {

    List<Product> products = new ArrayList<>();


    @GetMapping
    public List<Product> get(){
        return products;
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        //Lammbda Expressions
        //Stream API

        Product product = products
                .stream()
                //Lambda Expression
                .filter((p)->p.getId() == id).findFirst()
                .orElseThrow();

        return product;
    }

    @PostMapping
    public void add(@RequestBody Product product){
        products.add(product);
    }

    @PutMapping("/{id}")
    public  void update(@PathVariable int id,@RequestBody Product updateProduct){
      Product product = getById(id);
      product.setProductName(updateProduct.getProductName());
      product.setProductPrice(updateProduct.getProductPrice());

    }
    @DeleteMapping("/{id}")
    public  void delete(@PathVariable int id){
        Product productToRemove = getById(id);
        products.remove(productToRemove);
    }

}