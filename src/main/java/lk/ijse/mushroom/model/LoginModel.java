package lk.ijse.mushroom.model;

import lk.ijse.mushroom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    public boolean login(String username, String password) throws SQLException {
        ResultSet rs = CrudUtil.execute("select * from user Where username=? AND password = ?", username, password);

        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }
}
