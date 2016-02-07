package models;

import Beans.UserBean;
import db.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Menna
 */
public class EditUserProfileModel {

    static Connection currentCon = null;
    static ResultSet rs = null;

    public static UserBean EditUserData(UserBean ub) {
        PreparedStatement preparedStatement = null;

        int uid = ub.getId();
        String umail = ub.getEmail();
        String uname = ub.getName();
        String upw = ub.getPassword();
        String uaddress = ub.getAddress();
        String ujob = ub.getJob();
        Date ubd = ub.getBirthDate();
        int ucrLimit = ub.getCardLimit();

        try {
            //connect to DB 
            currentCon = DBUtil.getConnection();

            preparedStatement = currentCon.prepareStatement("update user c set u_name=?,u_email=?,u_password =?,u_address=?,u_job=?,u_bdate=?,u_credit_limit=? where u_id=?");
            System.out.println("Query: " + preparedStatement);
            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, umail);
            preparedStatement.setString(3, upw);
            preparedStatement.setString(4, uaddress);
            preparedStatement.setString(5, ujob);
            preparedStatement.setDate(6, ubd);
            preparedStatement.setInt(7, ucrLimit);
            preparedStatement.setInt(8, uid);

            int i = preparedStatement.executeUpdate();

            if (i == 0) // this is a DDL statement
            {
                ub.setId(rs.getInt("u_id"));
                ub.setName(rs.getString("u_name"));
                ub.setEmail(rs.getString("u_email"));
                ub.setPassword(rs.getString("u_password"));
                ub.setJob(rs.getString("u_job"));
                ub.setAddress(rs.getString("u_address"));
                ub.setBirthDate(rs.getDate("u_bdate"));
                ub.setCardId(rs.getInt("cart_id"));
                ub.setCardLimit(rs.getInt("u_credit_limit"));

                ub.setValid(true);
            }
           
                
      

        } catch (Exception ex) {
            System.out.println("update failed: An Exception has occurred! " + ex);
            ub.setValid(false);
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

}
