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
public class ContributionDirectory {
    
    String cont_id;
    String cont_name;
    String cont_type;
    String cont_amount;
    String cont_status;

    public ContributionDirectory() {
    }
    
    
    public ContributionDirectory(String cont_id,String cont_name, String cont_type, String cont_amount, String cont_status) {
        this.cont_id = cont_id;
        this.cont_name = cont_name;
        this.cont_type = cont_type;
        this.cont_amount = cont_amount;
        this.cont_status = cont_status;
    }

    public String getCont_id() {
        return cont_id;
    }

    public void setCont_id(String cont_id) {
        this.cont_id = cont_id;
    }
    
    

    public String getCont_name() {
        return cont_name;
    }

    public void setCont_name(String cont_name) {
        this.cont_name = cont_name;
    }

    public String getCont_type() {
        return cont_type;
    }

    public void setCont_type(String cont_type) {
        this.cont_type = cont_type;
    }

    public String getCont_amount() {
        return cont_amount;
    }

    public void setCont_amount(String cont_amount) {
        this.cont_amount = cont_amount;
    }

    public String getCont_status() {
        return cont_status;
    }

    public void setCont_status(String cont_status) {
        this.cont_status = cont_status;
    }
    
     public List<ContributionDirectory>  getDetails(){
       List<ContributionDirectory> contDetails = new ArrayList();
        MongoClient mongoClient = new MongoClient("localhost", 27017); 
        DB db = mongoClient.getDB("TestDB");
        DBCollection userCollection = db.getCollection("ContributorDetails");
        DBCursor cursor = null;
        cursor = userCollection.find();
        while(cursor.hasNext()){
            DBObject obj = cursor.next();
            cont_id =  obj.get("_id").toString();
            cont_name = obj.get("Name").toString();
            cont_type = obj.get("Type").toString();
            cont_amount = obj.get("Contribution").toString();
            cont_status = obj.get("Status").toString();
            ContributionDirectory contribution= new ContributionDirectory(cont_id,cont_name,cont_type,cont_amount,cont_status);
            contDetails.add(contribution);
        }
          return contDetails;
    }
    
}
