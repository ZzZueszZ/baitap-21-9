package DAO.Category;

import controller.db.DBConnectionMySql;
import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements ICategoryDao {

    private Connection getConnection() throws SQLException {
        return DBConnectionMySql.getConnection();
    }

    @Override
    public void createCategory(Category category) {
        String sql = "INSERT INTO categories (categoryname, images, status) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            // Use logging framework instead of printStackTrace in production code
            e.printStackTrace();
        }
    }

    @Override
    public Category readCategory(int categoryId) {
        String sql = "SELECT * FROM categories WHERE categoryid = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, categoryId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToCategory(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCategory(Category category) {
        String sql = "UPDATE categories SET categoryname = ?, images = ?, status = ? WHERE categoryid = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, category.getCategoryname());
            ps.setString(2, category.getImages());
            ps.setInt(3, category.getStatus());
            ps.setInt(4, category.getCategoryid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        String sql = "DELETE FROM categories WHERE categoryid = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, categoryId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                categories.add(mapRowToCategory(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    private Category mapRowToCategory(ResultSet rs) throws SQLException {
        Category category = new Category();
        category.setCategoryid(rs.getInt("categoryid"));
        category.setCategoryname(rs.getString("categoryname"));
        category.setImages(rs.getString("images"));
        category.setStatus(rs.getInt("status"));
        return category;
    }
}

