/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Beans.UserBean;
import db.DBUtil;

/**
 *
 * @author Menna
 */
public class LoginModel {

    static Connection currentCon = null;
    static ResultSet rs = null;

    public static UserBean login(UserBean bean) {

        //preparing some objects for connection 
        PreparedStatement preparedStatement = null;

        String email = bean.getEmail();
        String password = bean.getPassword();

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Your user name is " + email);
        System.out.println("Your password is " + password);

        try {
            //connect to DB 
            currentCon = DBUtil.getConnection();

            preparedStatement = currentCon.prepareStatement("select u_email , u_password from user where u_email=? and u_password=?");
            System.out.println("Query: " + preparedStatement);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            rs = preparedStatement.executeQuery();

            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                bean.setValid(false);
            } //if user exists set the isValid variable to true
            else if (more) {
                String uemail = rs.getString("u_email");

                String upassword = rs.getString("u_password");

                System.out.println("Welcome " + uemail);
                bean.setEmail(uemail);
                bean.setPassword(upassword);
                bean.setValid(true);
            }
        } catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        } //some exception handling
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                }
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return bean;
    }
}
