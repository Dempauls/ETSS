package admin;

import etss.config;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;


public class taskForm extends javax.swing.JFrame {

   
    public taskForm() {
        initComponents();
        getUserData();
    }
    void getUserData(){
      config con = new config();
        
      
        String sql = "SELECT t.id AS 'ID', "
                   + "t.title AS 'Task Title', "
                   + "t.desc AS 'Description', "
                   + "t.status AS 'Status', "
                   + "t.deadline AS 'Deadline', "
                   + "ta.user_id AS 'Assigned ID' " 
                   + "FROM tbl_tasks t "
                   + "LEFT JOIN tbl_task_assignment ta ON t.id = ta.task_id";
        
        con.displayData(sql, tasksTable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tasksTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        search_bar = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(19, 30, 70));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));

        tasksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tasksTable);

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ADD NEW TASK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 51, 102));
        jButton2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("UPDATE TASK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 51, 102));
        jButton3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("DELETE TASK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Search:");

        search_bar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_barKeyReleased(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 51, 102));
        jButton4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 204, 102));
        jButton4.setText("EXIT");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(9, 9, 9)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addGap(0, 15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jLabel2)
                    .addComponent(search_bar)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TASK MANAGEMENT");

        jButton5.setBackground(new java.awt.Color(255, 204, 102));
        jButton5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 51, 102));
        jButton5.setText("Generate Certificate");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel1)
                        .addGap(89, 89, 89)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     taskCrud tc = new taskCrud();
    tc.setVisible(true);
    tc.saveBtn.setText("SAVE"); 
    this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int rowIndex = tasksTable.getSelectedRow();
    
    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select a task to update!");
    } else {
        try {
            TableModel model = tasksTable.getModel();
            taskCrud tc = new taskCrud();
            
            
            tc.tx_id.setText("" + model.getValueAt(rowIndex, 0).toString());
            tc.tx_title.setText("" + model.getValueAt(rowIndex, 1).toString());
            tc.tx_desc.setText("" + model.getValueAt(rowIndex, 2).toString());
            tc.tx_dline.setText("" + model.getValueAt(rowIndex, 3).toString());
            
            tc.setVisible(true);
            tc.saveBtn.setText("UPDATE");
            this.dispose();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     int rowIndex = tasksTable.getSelectedRow();

    if (rowIndex < 0) {
        javax.swing.JOptionPane.showMessageDialog(null, "Please select a user to delete!");
    } else {
       
        String id = tasksTable.getModel().getValueAt(rowIndex, 0).toString();

        
        int confirm = javax.swing.JOptionPane.showConfirmDialog(null, 
                "Are you sure you want to delete ID: " + id + "?", 
                "Confirmation", javax.swing.JOptionPane.YES_NO_OPTION);

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            config conf = new config();
            
           
            String sql = "DELETE FROM tbl_tasks WHERE id = '" + id + "'";
            
         
            if (conf.insertData(sql) == 1) { 
                javax.swing.JOptionPane.showMessageDialog(null, "User Deleted Successfully!");
                getUserData(); 
            }
        }
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void search_barKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_barKeyReleased
        config con = new config();
    String query = search_bar.getText();

   
    String sql = "SELECT t.id AS 'ID', t.title AS 'Task Title', t.desc AS 'Description', "
               + "t.status AS 'Status', t.deadline AS 'Deadline', "
               + "ta.user_id AS 'Assigned ID' " 
               + "FROM tbl_tasks t "
               + "LEFT JOIN tbl_task_assignment ta ON t.id = ta.task_id "
               + "WHERE t.id LIKE '%" + query + "%' "
               + "OR t.title LIKE '%" + query + "%' "
               + "OR t.status LIKE '%" + query + "%' "
               + "OR ta.user_id LIKE '%" + query + "%'"; 
               
    con.displayData(sql, tasksTable);
    }//GEN-LAST:event_search_barKeyReleased

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        adminDashboard ad = new adminDashboard();
    
    
    ad.setVisible(true);
    
    
    this.dispose();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    int row = tasksTable.getSelectedRow();
    if (row == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Select a task first!");
        return;
    }

    
    String task = tasksTable.getValueAt(row, 1).toString();
    String date = tasksTable.getValueAt(row, 4).toString();
    Object nameObj = tasksTable.getValueAt(row, 5);
    String name = (nameObj != null) ? nameObj.toString() : "Unassigned";

    if (name.equals("Unassigned")) {
        javax.swing.JOptionPane.showMessageDialog(this, "This task has no assignee!");
        return;
    }

    String userHome = System.getProperty("user.home");
    String pdfPath = userHome + "\\Desktop\\Award_" + name.replace(" ", "_") + ".pdf";
    String htmlPath = userHome + "\\Desktop\\temp_cert.html";

    
    String htmlContent = "<html><head><style>"
            + "@page { size: landscape; margin: 0; }" 
            + "body { font-family: 'Cambria', serif; text-align: center; background-color: #f4f4f4; padding: 50px; }"
            + ".border { border: 15px double #1a237e; padding: 40px; background-color: white; height: 85%; }"
            + "h1 { color: #1a237e; font-size: 60px; margin-bottom: 5px; }"
            + "h2 { font-weight: bold; font-size: 30px; color: #b8860b; margin-top: 0; text-transform: uppercase; }"
            + ".name { color: #1a237e; font-size: 55px; font-weight: bold; margin: 25px 0; border-bottom: 2px solid #b8860b; display: inline-block; padding: 0 50px; }"
            + ".details { font-size: 24px; color: #333; }"
            + "</style></head><body>"
            + "<div class='border'>"
            + "<h1>CERTIFICATE</h1>"
            + "<h2>Best Employee Award</h2>"
            + "<p class='details'>This is to officially recognize and honor</p>"
            + "<div class='name'>" + name.toUpperCase() + "</div>"
            + "<p class='details'>for exceptional performance and dedication in completing</p>"
            + "<h3 style='font-size: 28px; color: #1a237e;'>" + task + "</h3>"
            + "<p class='details'>Awarded on: " + date + "</p>"
            + "<br><br><p style='font-size: 20px;'>__________________________<br><b>Admin Authorized Signature</b></p>"
            + "</div></body></html>";

    try {
      
        java.io.PrintWriter out = new java.io.PrintWriter(new java.io.FileWriter(htmlPath));
        out.println(htmlContent);
        out.close();

       
        String[] possiblePaths = {
            "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe",
            "C:\\Program Files\\Microsoft\\Edge\\Application\\msedge.exe",
            "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe",
            "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"
        };
        
        String enginePath = "";
        for (String p : possiblePaths) {
            if (new java.io.File(p).exists()) {
                enginePath = p;
                break;
            }
        }

       
        if (!enginePath.isEmpty()) {
            ProcessBuilder pb = new ProcessBuilder(
                enginePath, "--headless", "--disable-gpu", 
                "--print-to-pdf=" + pdfPath, htmlPath
            );
            Process process = pb.start();
            
           
            process.waitFor(10, java.util.concurrent.TimeUnit.SECONDS);

            java.io.File pdfFile = new java.io.File(pdfPath);
            if (pdfFile.exists()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Award Certificate saved to Desktop!");
                java.awt.Desktop.getDesktop().open(pdfFile);
                new java.io.File(htmlPath).delete(); 
            } else {
                
                java.awt.Desktop.getDesktop().browse(new java.io.File(htmlPath).toURI());
                javax.swing.JOptionPane.showMessageDialog(this, "PDF Engine busy. Opened as Web Certificate.");
            }
        } else {
           
            java.awt.Desktop.getDesktop().browse(new java.io.File(htmlPath).toURI());
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(taskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(taskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(taskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(taskForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new taskForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search_bar;
    private javax.swing.JTable tasksTable;
    // End of variables declaration//GEN-END:variables

}
