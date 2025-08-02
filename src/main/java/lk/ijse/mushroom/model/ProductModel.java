package lk.ijse.mushroom.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.mushroom.dto.ProductDTO;
import lk.ijse.mushroom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductModel {
    public boolean add(ProductDTO productDTO) throws SQLException{
        Boolean isadded = CrudUtil.execute("INSERT INTO Product Values(?,?,?)",productDTO.getProduct_id(),productDTO.getProduct_name(),productDTO.getQuantity());
        return isadded;
    }
    public boolean update(ProductDTO productDTO) throws SQLException{
        boolean isUpdated = CrudUtil.execute("UPDATE Product SET product_name=?,quantity=? WHERE product_id=?");
        return isUpdated;
    }
    public boolean delete(ProductDTO productDTO) throws SQLException{
        boolean isDeleted = CrudUtil.execute("DELETE FROM Product WHERE product_id=?");
        return isDeleted;
    }
    public ObservableList<ProductDTO> getAll() throws SQLException{
        ArrayList<ProductDTO> productDTOS = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT * FROM Product");
        ObservableList<ProductDTO> products = FXCollections.observableArrayList();
        while(rs.next()){
            ProductDTO productDTO = new ProductDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
            );
            products.add(productDTO);
        }
  return products;

    }
    public int getNextId() throws SQLException{
        ResultSet rs = CrudUtil.execute("SELECT MAX(product_id) FROM Product");
        if(rs.next()){
            int nextId = rs.getInt(1)+1;
            System.out.println(nextId);
            return nextId;

        }
        return 0;
    }
}
