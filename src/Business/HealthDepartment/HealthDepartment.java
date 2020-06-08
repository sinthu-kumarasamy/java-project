/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.HealthDepartment;

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
public class HealthDepartment {
    String user_name;
    String password;
    String role;
    String emp_id;
    String salt_value;

    public String getSalt_value() {
        return salt_value;
    }

    public void setSalt_value(String salt_value) {
        this.salt_value = salt_value;
    }
    
    

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
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

    public HealthDepartment(String user_name, String password, String role,String emp_id,String salt_value) {
        this.user_name = user_name;
        this.password = password;
        this.role = role;
        this.emp_id = emp_id;
        this.salt_value = salt_value;
    }

    public HealthDepartment() {
    }
    
    
    public List<HealthDepartment>  getDetails(){
       List<HealthDepartment> empDetails = new ArrayList();
         MongoClient mongoClient = new MongoClient("localhost", 27017); 
            DB db = mongoClient.getDB("TestDB");
            DBCollection userCollection = db.getCollection("HealthEmpDetails");
            DBCursor cursor = null;
            cursor = userCollection.find();
            while(cursor.hasNext()){
                DBObject obj = cursor.next();
                emp_id = obj.get("_id").toString();
                user_name = obj.get("EmpName").toString();
                password = obj.get("Password").toString();
                role = obj.get("EmpRole").toString();
                salt_value = obj.get("Saltvalue").toString();
                HealthDepartment Health= new HealthDepartment(user_name,password,role,emp_id,salt_value);
                empDetails.add(Health);
            }
          return empDetails;
    }
    
}
