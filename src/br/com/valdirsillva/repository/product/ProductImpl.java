package br.com.valdirsillva.repository.product;

import java.util.List;
import java.util.ArrayList;

import java.util.UUID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import br.com.valdirsillva.entity.Product;
import br.com.valdirsillva.database.MysqlConn;

public class ProductImpl implements IProduct {

    private Connection conexao;

    PreparedStatement pstmt = null;

    @Override
    public void add(Product product) {
        try {

            conexao = MysqlConn.getConn();
            pstmt = conexao
                    .prepareStatement(
                            "INSERT INTO product (id, name, price, quantity, description)"
                                    + " VALUES (?, ?, ?, ?, ?)");

            pstmt.setString(1, UUID.randomUUID().toString());
            pstmt.setString(2, product.getName());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());
            pstmt.setString(5, product.getDescription());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error code: " + e.getErrorCode());
            System.out.println("SQL state: " + e.getSQLState());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            conexao = MysqlConn.getConn();
            pstmt = conexao.prepareStatement("DELETE FROM product WHERE id = ?");
            pstmt.setString(1, id);
            int numRow = pstmt.executeUpdate();

            if (numRow > 0) {
                System.out.println("Produto excluído com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Error code: " + e.getErrorCode());
            System.out.println("SQL state: " + e.getSQLState());
            System.out.println("Product not deleted:" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(String id) {
        try {
            conexao = MysqlConn.getConn();
            pstmt = conexao.prepareStatement("SELECT * FROM product WHERE id = ?");

            pstmt.setString(1, id);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();

                product.setId(UUID.fromString(resultSet.getString("id")));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setDescription(resultSet.getString("description"));

                // Retrieve the java.sql.Date from the ResultSet
                java.sql.Date sqlDate = resultSet.getDate("createdAt");
                if (sqlDate != null) {
                    // Convert java.sql.Date to java.util.Date
                    java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
                    // Convert java.util.Date to Instant
                    Instant instant = utilDate.toInstant();
                    // Convert Instant to LocalDateTime
                    LocalDateTime createdAt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                    // Set LocalDateTime to Product
                    product.setCreatedAt(createdAt);
                }
                return product;
            }

        } catch (SQLException e) {
            System.out.println("Error code: " + e.getErrorCode());
            System.out.println("SQL state: " + e.getSQLState());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> list() {
        List<Product> list = new ArrayList<Product>();
        try {
            conexao = MysqlConn.getConn();
            pstmt = conexao.prepareStatement("SELECT * FROM product");
            ResultSet rs = pstmt.executeQuery();
            // rs.next()
            // Move o cursor para a próxima linha, iterando o conjunto de resultados
            while (rs.next()) {
                Product product = new Product();
                product.setId(UUID.fromString(rs.getString("id")));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setDescription(rs.getString("description"));
                java.sql.Date sqlDate = rs.getDate("createdAt");
                if (sqlDate != null) {
                    // Convert java.sql.Date to java.util.Date
                    java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
                    // Convert java.util.Date to Instant
                    Instant instant = utilDate.toInstant();
                    // Convert Instant to LocalDateTime
                    LocalDateTime createdAt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
                    // Set LocalDateTime to Product
                    product.setCreatedAt(createdAt);
                }
                list.add(product);
            }

        } catch (SQLException e) {
            System.out.println("Erro an list products:" + e.getMessage());
            System.out.println("SQL state:" + e.getSQLState());
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(String id) {
        // TODO Auto-generated method stub

    }

}
