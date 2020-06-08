/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WelfareDepartment;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Sindhu
 */
public class WelfareDepartment {
    String user_name;
    String password;
    String role;
    String salt_value;
    
     public String getSalt_value() {
        return salt_value;
    }

    public void setSalt_value(String salt_value) {
        this.salt_value = salt_value;
    }
    

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public WelfareDepartment(String user_name, String password, String role,String salt_value) {
        this.user_name = user_name;
        this.password = password;
        this.role = role;
        this.salt_value = salt_value;
    }

    public WelfareDepartment() {
    }
    
    
    public List<WelfareDepartment>  getDetails(){
       List<WelfareDepartment> empDetails = new ArrayList();
         MongoClient mongoClient = new MongoClient("localhost", 27017); 
            DB db = mongoClient.getDB("TestDB");
            DBCollection userCollection = db.getCollection("WelfareEmpDetails");
            DBCursor cursor = null;
            cursor = userCollection.find();
            while(cursor.hasNext()){
                DBObject obj = cursor.next();
                user_name = obj.get("EmpName").toString();
                password = obj.get("Password").toString();
                role = obj.get("EmpRole").toString();
                 salt_value = obj.get("Saltvalue").toString();
                WelfareDepartment Welfare= new WelfareDepartment(user_name,password,role,salt_value);
                empDetails.add(Welfare);
            }
          return empDetails;
    }
    
}
