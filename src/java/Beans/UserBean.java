/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Date;

/**
 *
 * @author Rawan
 */
public class UserBean 
{
    private String name;
    private String password;
    private String email;
    private String job;
    private String address;
    private Date birthdate;
    private int cardlimit;
    private int cardid;
    private boolean valid;
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setJob(String job)
    {
        this.job = job;
    }
    
    public String getJob()
    {
        return job;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setBirthDate(Date birthdate)
    {
        this.birthdate = birthdate ;
    }
    
    public Date getBirthDate()
    {
        return birthdate;
    }
    
    public void setCardLimit(Integer cardlimit)
    {
        this.cardlimit = cardlimit ;
    }
    
    public int getCardLimit()
    {
        return cardlimit;
    }
    
    public void setCardId(Integer cardid)
    {
        this.cardid = cardid ;
    }
    
    public int getCardId()
    {
        return cardid;
    }
    
        public boolean isValid() {
         return valid;
	}

      public void setValid(boolean newValid) {
         valid = newValid;
	}
      
      public boolean isManager(){  
    if(password.equals("admin")&&email.equals("admin@admin.com")){  
        return true;  
    }  
    else{  
        return false;  
    }  
}  
    
    
}
