/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp.app.service;

import upeu.edu.pe.lp.app.repository.CategoryRepository;
import upeu.edu.pe.lp.infrastructure.entity.CategoryEntity;

/**
 *
 * @author DIEGO
 */
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
     public Iterable<CategoryEntity> saveCategory(){
         
         return categoryRepository.saveCategory();
     }
    public CategoryEntity getCategoryById(Integer id){
        
        return categoryRepository.getCategoryById(id);
    }
    public void deleteCategoryById(Integer id){
        
       categoryRepository.deleteCategoryById(id);
        
    }
    
}
