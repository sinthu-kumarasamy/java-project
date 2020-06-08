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
public class BeneficiaryDirectory {
    String ben_id;
    String ben_name;
    String ass_type;
    String ben_status;
    String ben_city;

    public BeneficiaryDirectory() {
    }

    public BeneficiaryDirectory(String ben_id, String ben_name, String ass_type, String ben_status,String ben_city) {
        this.ben_id = ben_id;
        this.ben_name = ben_name;
        this.ass_type = ass_type;
        this.ben_status = ben_status;
        this.ben_city = ben_city;
    }

    public String getBen_city() {
        return ben_city;
    }

    public void setBen_city(String ben_city) {
        this.ben_city = ben_city;
    }
    
    

    public String getBen_id() {
        return ben_id;
    }

    public void setBen_id(String ben_id) {
        this.ben_id = ben_id;
    }

    public String getBen_name() {
        return ben_name;
    }

    public void setBen_name(String ben_name) {
        this.ben_name = ben_name;
    }

    public String getAss_type() {
        return ass_type;
    }

    public void setAss_type(String ass_type) {
        this.ass_type = ass_type;
    }

    public String getBen_status() {
        return ben_status;
    }

    public void setBen_status(String ben_status) {
        this.ben_status = ben_status;
    }
    
    public List<BeneficiaryDirectory>  getDetails(){
       List<BeneficiaryDirectory> benDetails = new ArrayList();
        MongoClient mongoClient = new MongoClient("localhost", 27017); 
        DB db = mongoClient.getDB("TestDB");
        DBCollection userCollection = db.getCollection("BeneficiaryDetails");
        DBCursor cursor = null;
        cursor = userCollection.find();
        while(cursor.hasNext()){
            DBObject obj = cursor.next();
            ben_id =  obj.get("_id").toString();
            ben_name = obj.get("Name").toString();
            ass_type = obj.get("Type").toString();
            ben_status = obj.get("Status").toString();
            ben_city = obj.get("City").toString();
            BeneficiaryDirectory benficiary= new  BeneficiaryDirectory(ben_id,ben_name,ass_type,ben_status,ben_city);
            benDetails.add(benficiary);
        }
          return benDetails;
    }
}
