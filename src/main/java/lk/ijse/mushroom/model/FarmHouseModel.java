package lk.ijse.mushroom.model;

import lk.ijse.mushroom.dto.FarmHouseDTO;
import lk.ijse.mushroom.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

public class FarmHouseModel {
    public static boolean add(FarmHouseDTO farmHouseDTO) throws SQLException, ClassNotFoundException {
        boolean isAdded = CrudUtil.execute("INSERT INTO Farm_house value(?,?,?)", farmHouseDTO.getFarmId(),farmHouseDTO.getLocation(),farmHouseDTO.getSize());
        return isAdded;
    }
    public static boolean update(FarmHouseDTO farmHouseDTO) throws SQLException, ClassNotFoundException {
      boolean isUpdate =CrudUtil.execute("UPDATE Farm_house SET location=?,size=?,WHERE farm_id =?",farmHouseDTO.getLocation(),farmHouseDTO.getSize(),farmHouseDTO.getFarmId());
        return isUpdate;
    }
    public boolean delete(FarmHouseDTO farmHouseDTO) throws SQLException, ClassNotFoundException {
        boolean isDelete =CrudUtil.execute("Delete FROM Farm_house WHERE farm_id =?",farmHouseDTO.getFarmId());
        return isDelete;
    }
    public static ArrayList<FarmHouseDTO> getAll() throws SQLException {
        ArrayList<FarmHouseDTO> farmHouseDTOs = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT * FROM Farm_house");

        while (rs.next()) {
//            double sie = Double.parseDouble(rs.getString(3));
            FarmHouseDTO farmHouseDTO = new FarmHouseDTO(
                    rs.getInt(1),
                    rs.getString(2),
                    200.00
            );
            farmHouseDTOs.add(farmHouseDTO);
        }
        return farmHouseDTOs;
    }



    public static int getNextId() throws SQLException {
        ResultSet rs = CrudUtil.execute("SELECT max(farm_id) FROM Farm_house");
        if (rs.next()) {
            return rs.getInt(1)+1;
        }
        return 0;
    }
}
