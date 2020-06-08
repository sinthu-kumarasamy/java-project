/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.BeneficiaryDivision;


import Business.WelfareDepartment.BeneficiaryDirectory;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sindhu
 */
public class ManageBeneficiaryPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageBeneficiaryPanel
     */
   
    JPanel userProcessContainer;
    BeneficiaryDirectory patient;
    enum status{
      Assigned,
      NA
    }

    public ManageBeneficiaryPanel(JPanel userProcessContainer) {
       initComponents();
       this.userProcessContainer = userProcessContainer;
       this.patient = new  BeneficiaryDirectory();
        bentable.getTableHeader().setFont(new Font("TImes New Roman",Font.BOLD,18));
        bentable.setRowHeight(30);
        bentable.setRowMargin(10);
        populateTable();
    }
    
     
      
      private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) bentable.getModel(); 
         MongoClient mongoClient = new MongoClient("localhost", 27017); 
        DB db = mongoClient.getDB("TestDB");
        DBCollection userCollection = db.getCollection("BeneficiaryDetails");
        DBCursor cursor = null;
        cursor = userCollection.find();
        model.setRowCount(0);
        while(cursor.hasNext()){
            Object[] row = new Object[model.getColumnCount()];
            DBObject obj = cursor.next();
            row[0] = obj.get("_id");
            row[1] = obj.get("Name");
            row[2] = obj.get("City");
            row[3] = obj.get("Type");
            row[4] = obj.get("Status");
            model.addRow(row);
         }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        bentable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        beneName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        beneCity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        assisTypeItem = new javax.swing.JComboBox<>();
        submitBtn = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        bentable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        bentable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bentable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Beneficiary Id", "Beneficiary Name", "City", "Assistance Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bentable.setRowHeight(20);
        jScrollPane1.setViewportView(bentable);

        add(jScrollPane1);
        jScrollPane1.setBounds(390, 230, 790, 160);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Beneficiary Name:");
        add(jLabel1);
        jLabel1.setBounds(590, 450, 150, 22);

        beneName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        beneName.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 102)));
        add(beneName);
        beneName.setBounds(760, 450, 150, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("  Beneficiary City :");
        add(jLabel2);
        jLabel2.setBounds(580, 510, 150, 22);

        beneCity.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        beneCity.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 102)));
        add(beneCity);
        beneCity.setBounds(760, 510, 150, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Assistance Type:");
        add(jLabel3);
        jLabel3.setBounds(590, 570, 130, 22);

        assisTypeItem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        assisTypeItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Food", "Fund", "Employment", "HealthCare" }));
        assisTypeItem.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 102)));
        add(assisTypeItem);
        assisTypeItem.setBounds(760, 570, 150, 30);

        submitBtn.setBackground(new java.awt.Color(102, 0, 102));
        submitBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        add(submitBtn);
        submitBtn.setBounds(740, 670, 90, 40);

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(imageLabel);
        imageLabel.setBounds(90, -60, 1290, 940);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel) bentable.getModel();
        String ben_name = beneName.getText();
        String ben_city = beneCity.getText();
        String ass_type = assisTypeItem.getSelectedItem().toString();
        MongoClient mongoClient = new MongoClient("localhost", 27017); 
        DB db = mongoClient.getDB("TestDB");
        DBCollection userCollection = db.getCollection("BeneficiaryDetails");
        int count = (int)userCollection.count();
        BasicDBObject bO = new BasicDBObject();
        String ben_id = "B00"+count;
        bO.put("_id", ben_id);
	bO.put("Name", ben_name);
        bO.put("City", ben_city);
        bO.put("Type", ass_type);
        bO.put("Status",status.NA.toString());
        userCollection.insert(bO);
        if(ass_type.equals("HealthCare")){
            insertPatientData(ben_name,ben_city,ben_id);
        }
        JOptionPane.showMessageDialog(null, "Beneficiary Details Added Successfully");
        populateTable();
    }//GEN-LAST:event_submitBtnActionPerformed
    
    public void insertPatientData(String ben_name,String ben_city,String ben_id){
          MongoClient mongoClient = new MongoClient("localhost", 27017); 
        DB db = mongoClient.getDB("TestDB");
        DBCollection userCollection = db.getCollection("PatientDetails");
        BasicDBObject bO = new BasicDBObject();
        bO.put("_id", ben_id);
	bO.put("Name", ben_name);
        bO.put("City", ben_city);
        bO.put("Status",status.NA.toString()); 
        bO.put("HealthIssue",status.NA.toString());
        bO.put("DoctorId",status.NA.toString());
        bO.put("AssistantId", status.NA.toString());
        userCollection.insert(bO);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> assisTypeItem;
    private javax.swing.JTextField beneCity;
    private javax.swing.JTextField beneName;
    private javax.swing.JTable bentable;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}