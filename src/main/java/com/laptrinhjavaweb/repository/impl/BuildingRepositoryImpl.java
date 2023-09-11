package com.laptrinhjavaweb.repository.impl;

import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.entity.BuildingEntity1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@PropertySource("classpath:application.properties")
public class BuildingRepositoryImpl implements BuildingRepository {
//    private String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
//    private String USER = "root";
//    private String PASS = "123456";

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String passWord;

    @Override
    public List<BuildingEntity> findAll() {
        List<BuildingEntity> results = new ArrayList<>();
        String QUERY = "SELECT * FROM estatebasic.building;";
        try(Connection conn = DriverManager.getConnection(dbUrl, userName, passWord);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
        ) {
            while(rs.next()){
                BuildingEntity buildingEntity = new BuildingEntity();
                buildingEntity.setName(rs.getString("name"));
//                buildingEntity.setDistrictId(rs.getLong("districtid"));
//                buildingEntity.setStreet(rs.getString("street"));
//                buildingEntity.setWard(rs.getString("ward"));
                results.add(buildingEntity);
            }
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
