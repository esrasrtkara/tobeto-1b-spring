package com.tobeto.spring.b;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private List<Category> categories = new ArrayList<>();

    @GetMapping
    public List<Category> get() {
        return categories;
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable int id) {
        Category category = categories.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (category == null) {
            throw new RuntimeException("Category not found for id: " + id);
        }

        return category;
    }

    @PostMapping
    public void add(@RequestBody Category category) {
        categories.add(category);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Category updatedCategory) {
        Category category = getById(id);
        category.setCategoryName(updatedCategory.getCategoryName());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Category categoryToRemove = getById(id);
        categories.remove(categoryToRemove);
    }
}


