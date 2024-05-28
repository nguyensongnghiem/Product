package org.codegym.product.controller;

import org.codegym.product.model.Product;
import org.codegym.product.service.ICategoryService;
import org.codegym.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/list")
    public String index(Model model, @RequestParam(defaultValue = "0",required = false) Integer pageNumber, @RequestParam(defaultValue = "", required = false) String searchName, @RequestParam(required = false,defaultValue = "") String searchCategory){
        Pageable pageable = PageRequest.of(pageNumber, 2);
        Page<Product> productList = productService.searchByNameAndCategory(searchName,searchCategory,pageable);
        model.addAttribute("productList", productList);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchCategory", searchCategory);
        model.addAttribute("categoryList", categoryService.findAll());
        return "home";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        if (productService.findById(id) != null) productService.deleteById(id);
        return "home";
    }

}
