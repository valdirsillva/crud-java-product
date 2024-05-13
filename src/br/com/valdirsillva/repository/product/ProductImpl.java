package br.com.valdirsillva.repository.product;

import java.util.List;
import java.util.UUID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        // TODO Auto-generated method stub

    }

    @Override
    public ProductImpl findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> list() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(String id) {
        // TODO Auto-generated method stub

    }

}
