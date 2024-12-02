package org.example.logic.database;

import org.example.logic.entity.User;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserDAL {
    private final DbConnection connection;

    public UserDAL(DbConnection connection) {
        this.connection = connection;
    }
    public int registerUser(User user){
        String fullName=user.getFullName();
        String phone=user.getPhone();
        String password=user.getPassword();
        boolean checkNumber=checkNumber(phone);
        if (!checkNumber){
            return 400;
        }
        try (Connection dbConnection=connection.getConnection()){
            String query="INSERT INTO Users (fullName, phone, password) VALUES (? , ? , ?)";
            PreparedStatement statement= dbConnection.prepareStatement(query);
            statement.setString(1,fullName);
            statement.setString(2,phone);
            statement.setString(3,password);
            statement.executeUpdate();
            return searchUserByPhone(phone);
        }catch (SQLException s){
            s.printStackTrace();
            return 404;
        }
    }
    public String[] loginUser(String phoneNumber,String password){
        String [] result= {"404","404"};
        if (phoneNumber.isBlank() || phoneNumber.isEmpty() && password.isBlank() || password.isEmpty()){
            return result;
        }
        if(password.isBlank() || password.isEmpty() || phoneNumber.isBlank() || phoneNumber.isEmpty()){
            return result;
        }
        String pass=getUserPass(phoneNumber);
        boolean verifyPass= false;
        if(pass.equals(password)){
            verifyPass=true;
        }
        if (verifyPass){
        try(Connection connection1= connection.getConnection()){
            String query="SELECT * FROM Users WHERE phone=?";
            PreparedStatement statement=connection1.prepareStatement(query);
            statement.setString(1,phoneNumber);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()) {
                String userid=String.valueOf(searchUserByPhone(phoneNumber));
                String name=getFullNameByPhone(phoneNumber);
                result[0]=userid;
                result[1]=name;
                return result;
            }
        }catch (SQLException s){
            s.printStackTrace();
            return result;
            }
        }else {
            return result;
        }
        return result;
    }
    public String getUserPass(String number){
        String hashedPass="";
        if(number.isBlank() || number.isEmpty()){
            return "phone number not found";
        }
        try(Connection connection1= connection.getConnection()){
            String query="SELECT password FROM users WHERE phone= ? ";
            PreparedStatement statement= connection1.prepareStatement(query);
            statement.setString(1,number);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                hashedPass=resultSet.getString("password");
            }
            if (hashedPass.isBlank() || hashedPass.isEmpty()){
                return "password not found";
            }else {
                return hashedPass;
            }
        }catch (SQLException s){
            s.printStackTrace();
            return "An exception occurred";
        }
    }
    public boolean checkNumber(String number){
        try(Connection connection1= connection.getConnection()){
            String query="SELECT * FROM Users WHERE phone= ?";
            PreparedStatement statement= connection1.prepareStatement(query);
            statement.setString(1,number);
            ResultSet resultSet= statement.executeQuery();
            if (resultSet.next()){
                return false;
            }else {
                return true;
            }
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }
    }
    public int searchUserByPhone(String phone){
        int userid=0;
        try(Connection connection1= connection.getConnection()){
            String query="SELECT userid FROM users WHERE phone= ? ";
            PreparedStatement statement= connection1.prepareStatement(query);
            statement.setString(1,phone);
            ResultSet result=statement.executeQuery();
            while (result.next()){
                userid=result.getInt(1);
            }
            return userid;
        }catch (SQLException s){
            s.printStackTrace();
        }
        return userid;
    }
    public String getFullNameByPhone(String phone){
        String name="";
        try(Connection connection1= connection.getConnection()){
            String query="SELECT fullname FROM users WHERE phone= ?";
            PreparedStatement statement= connection1.prepareStatement(query);
            statement.setString(1,phone);
            ResultSet resultSet= statement.executeQuery();
            while(resultSet.next()){
                name= resultSet.getString(1);
            }
            return name;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return name;
    }
}
