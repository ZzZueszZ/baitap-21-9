package DAO.Category;

import model.Category;

import java.util.List;

public interface ICategoryDao {

    // Tạo mới một danh mục
    void createCategory(Category category);

    // Đọc một danh mục theo ID
    Category readCategory(int categoryId);

    // Cập nhật một danh mục
    void updateCategory(Category category);

    // Xóa một danh mục theo ID
    void deleteCategory(int categoryId);

    // Lấy danh sách tất cả các danh mục
    List<Category> getAllCategories();
}
