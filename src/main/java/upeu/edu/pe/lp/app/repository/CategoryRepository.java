    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp.app.repository;

import upeu.edu.pe.lp.infrastructure.entity.CategoryEntity;

/**
 *
 * @author Luki
 */
public interface CategoryRepository {
    
    Iterable<CategoryEntity> saveCategory();
    CategoryEntity getCategoryById(Integer id);
    void deleteCategoryById(Integer id);
    
}
