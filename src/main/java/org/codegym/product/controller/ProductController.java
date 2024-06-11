package org.codegym.product.controller;

import jakarta.validation.Valid;
import org.codegym.product.dto.ProductDTO;
import org.codegym.product.model.Product;
import org.codegym.product.service.ICategoryService;
import org.codegym.product.service.IProductService;
import org.codegym.product.validator.ProductValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ProductValidator productValidator;

    @GetMapping("/list")
    public String index(Model model, @RequestParam(defaultValue = "0", required = false) Integer pageNumber, @RequestParam(defaultValue = "", required = false) String searchName, @RequestParam(required = false, defaultValue = "") String searchCategory) {
        Sort sort = Sort.by("id").ascending();
        Pageable pageable = PageRequest.of(pageNumber, 2,sort);
        Page<Product> productList = productService.searchByNameAndCategory(searchName, searchCategory, pageable);
        model.addAttribute("page", productList);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchCategory", searchCategory);
        model.addAttribute("categoryList", categoryService.findAll());
        return "home";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String deleteId, RedirectAttributes redirectAttributes) {
        if (productService.findById(deleteId) != null) {
            productService.deleteById(deleteId);
            redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        }
        return "redirect:/product/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categoryList", categoryService.findAll());
        return "/create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute ProductDTO productDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        Product targetProduct = new Product();
        productValidator.validate(productDTO,bindingResult);
        if (bindingResult.hasErrors()) {
//            model.addAttribute("productDTO", productDTO);
            model.addAttribute("categoryList", categoryService.findAll());
            return "/create";
        }
        BeanUtils.copyProperties(productDTO, targetProduct);
        productService.save(targetProduct);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable(name = "id") String id) {
        Product product = productService.findById(id).get();
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);
        model.addAttribute("productDTO", productDTO);
        model.addAttribute("categoryList", categoryService.findAll());
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        Product targetProduct = new Product();
        productValidator.validate(productDTO,bindingResult);
        if (bindingResult.hasErrors()) {
//            model.addAttribute("productDTO", productDTO);
            model.addAttribute("categoryList", categoryService.findAll());
            return "/edit";
        }
        BeanUtils.copyProperties(productDTO,targetProduct);
        productService.save(targetProduct);
        redirectAttributes.addFlashAttribute("message", "Update thành công");
        return "redirect:/product/list";
    }
}
