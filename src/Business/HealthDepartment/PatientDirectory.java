/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.HealthDepartment;

import Business.WelfareDepartment.BeneficiaryDirectory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sindhu
 */
public class PatientDirectory {
     String patient_id;
    String patient_name;
    String patient_status;
    String patient_city;
    String health_issue;
    BeneficiaryDirectory beneficiary = new BeneficiaryDirectory();

    public PatientDirectory() {
    }

    public PatientDirectory(String patient_id, String patient_name, String patient_status, String patient_city, String health_issue) {
        this.patient_id = patient_id;
        this.patient_name = patient_name;
        this.patient_status = patient_status;
        this.patient_city = patient_city;
        this.health_issue = health_issue;
    }
    
    
    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_status() {
        return patient_status;
    }

    public void setPatient_status(String patient_status) {
        this.patient_status = patient_status;
    }

    public String getPatient_city() {
        return patient_city;
    }

    public void setPatient_city(String patient_city) {
        this.patient_city = patient_city;
    }

    public String getHealth_issue() {
        return health_issue;
    }

    public void setHealth_issue(String health_issue) {
        this.health_issue = health_issue;
    }

    
    public List<PatientDirectory>  getDetails(){
       List<PatientDirectory> patientDetails = new ArrayList();
        for(BeneficiaryDirectory patient:beneficiary.getDetails()){
           if(patient.getAss_type().equals("HealthCare")){
               patient_id = patient.getBen_id();
               patient_name = patient.getBen_name();
               patient_status = patient.getBen_status();
               patient_city = patient.getBen_city();
               health_issue = "N/A";
               PatientDirectory new_patient = new PatientDirectory(patient_id,patient_name,patient_status,patient_city,health_issue);
           } 
        }
       return patientDetails;
    }
    
}
