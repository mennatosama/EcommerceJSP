
package models;

import Beans.UserBean;
import db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;


/**
 *
 * @author Menna
 */
public class UserHomeModel {
    
    static Connection currentCon = null;
    static ResultSet rs = null;
    
    public UserBean GetUserData(UserBean ub)
    {
        PreparedStatement preparedStatement = null;
        
        String email = ub.getEmail();
        
        try {
            //connect to DB 
            currentCon = DBUtil.getConnection();

            preparedStatement = currentCon.prepareStatement("select * from user where u_email=?");
            System.out.println("Query: " + preparedStatement);
            preparedStatement.setString(1, email);
           
            rs = preparedStatement.executeQuery();

            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                ub.setValid(false);
            } //if user exists set the isValid variable to true
            else if (more) {
                ub.setId(rs.getInt("u_id"));
                ub.setName(rs.getString("u_name"));
                ub.setEmail(rs.getString("u_email"));
                ub.setPassword(rs.getString("u_password"));
                ub.setJob(rs.getString("u_job"));
                ub.setAddress(rs.getString("u_address"));
                ub.setBirthDate(rs.getDate("u_bdate"));
                ub.setCardId(rs.getInt("cart_id"));
                ub.setCardLimit(rs.getInt("u_credit_limit"));
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
        
        return ub;
    }
    
     public HashMap<Integer, Integer> GetUserShoppinCart(UserBean ub)
    {
        PreparedStatement preparedStatement = null;
        
        HashMap<Integer, Integer> CartList = new HashMap<Integer, Integer>();

        
        int uId = ub.getId();
        
        try {
            //connect to DB 
            currentCon = DBUtil.getConnection();

            preparedStatement = currentCon.prepareStatement("select * from shopping_cart where u_id=?");
            System.out.println("Query: " + preparedStatement);
            preparedStatement.setInt(1, uId);
           
            rs = preparedStatement.executeQuery();

            boolean more = rs.next();
            if (more) {
       
            
              while (more) {

                CartList.put(rs.getInt("pro_id"),rs.getInt("quantity"));

            }
              
              ub.setValid(true);
}
            // if user does not exist set the isValid variable to false
            else {
                System.out.println("Sorry,Can't get Your cart data");
                ub.setValid(false);
            } //if user exists set the isValid variable to true
            
        } catch (Exception ex) {
            System.out.println("Load data failed: An Exception has occurred! " + ex);
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
        
        return CartList;
    }
    
    
    
    
    
}
