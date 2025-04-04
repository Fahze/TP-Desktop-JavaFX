package com.fahze.demojavafx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.fahze.demojavafx.ExpenseController.data;

public class ExpenseDAO {

    public static void insertLine(Line line){
        String query = "INSERT INTO expense VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        System.out.println("Insertion");

        try (Connection connection = Database.connect()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, line.getPeriod());
            statement.setFloat(2, line.getHousing());
            statement.setFloat(3, line.getFood());
            statement.setFloat(4, line.getOuting());
            statement.setFloat(5, line.getTransport());
            statement.setFloat(6,line.getTravel());
            statement.setFloat(7, line.getTaxes());
            statement.setFloat(8, line.getOther());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void fetchAllDb(){
        // On clear l'array
        System.out.println("Refresh list");
        data.removeAll();

        // Setup query
        String q = "SELECT * FROM expense";

        // try catch
        try(Connection connection = Database.connect()){
            PreparedStatement statement = connection.prepareStatement(q);
            ResultSet ArrayResults = statement.executeQuery();

            while (ArrayResults.next()){
                String date = ArrayResults.getString("date");
                Float housing = ArrayResults.getFloat("housing");
                Float food = ArrayResults.getFloat("food");
                Float outing = ArrayResults.getFloat("goingOut");
                Float transport = ArrayResults.getFloat("transportation");
                Float travel = ArrayResults.getFloat("travel");
                Float taxes = ArrayResults.getFloat("tax");
                Float other = ArrayResults.getFloat("other");
                Float total = (housing + food + outing + transport + travel + taxes + other);

                Line line = new Line(date,total,housing,food,outing,transport,travel,taxes,other);

                data.add(line);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
