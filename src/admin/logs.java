package admin;

import etss.config;

public class logs extends javax.swing.JFrame {
   
    public logs() {
      initComponents();
    displayLogs();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        logsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        EXIT = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        PRINTLOGS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        logsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(logsTable);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 102));
        jLabel1.setText("SYSTEM AUDIT TRAIL & ACTIVITY LOGS");

        EXIT.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        EXIT.setText("EXIT");
        EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXITActionPerformed(evt);
            }
        });

        DELETE.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        DELETE.setText("DELETE");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        PRINTLOGS.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        PRINTLOGS.setText("PRINT LOGS");
        PRINTLOGS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRINTLOGSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(PRINTLOGS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57)
                        .addComponent(DELETE)
                        .addGap(26, 26, 26)
                        .addComponent(EXIT)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(EXIT)
                            .addComponent(DELETE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PRINTLOGS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXITActionPerformed
        adminDashboard ad = new adminDashboard();
ad.setVisible(true);
this.dispose();
    }//GEN-LAST:event_EXITActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
       int row = logsTable.getSelectedRow();
    
    if(row < 0) {
        javax.swing.JOptionPane.showMessageDialog(null, "Please select a log entry to delete!");
    } else {
       
        String id = logsTable.getModel().getValueAt(row, 0).toString();
        
      
        int confirm = javax.swing.JOptionPane.showConfirmDialog(null, 
                "Are you sure you want to delete Log ID: " + id + "?", 
                "Confirm Deletion", javax.swing.JOptionPane.YES_NO_OPTION);

        if(confirm == javax.swing.JOptionPane.YES_OPTION) {
            etss.config conf = new etss.config();
            
            
            String sql = "DELETE FROM tbl_logs WHERE l_id = '" + id + "'";
            
            if(conf.insertData(sql) == 1) {
                javax.swing.JOptionPane.showMessageDialog(null, "Log Entry Deleted Successfully!");
                
               
                displayLogs(); 
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Deletion failed. Please check database connection.");
            }
        }
    }
    }//GEN-LAST:event_DELETEActionPerformed

    private void PRINTLOGSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRINTLOGSActionPerformed
        if (logsTable.getRowCount() == 0) {
        javax.swing.JOptionPane.showMessageDialog(null, "No logs available to export!");
        return;
    }
    
    
    try {
        generateLogPDF();
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Error generating report: " + e.getMessage());
    }
    }//GEN-LAST:event_PRINTLOGSActionPerformed

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
            java.util.logging.Logger.getLogger(logs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logs().setVisible(true);
            }
        });
    }
    
    
    public void displayLogs() {
    
   
   try {
        etss.config conf = new etss.config();
       
        
        String sql = "SELECT l.l_id AS 'Log ID', l.\"l_timestamp DATETIME\" AS 'Date/Time', "
                   + " u.first_name || ' ' || u.last_name AS 'Admin Name', "
                   + " l.l_action AS 'Action', l.l_details AS 'Details' "
                   + " FROM tbl_logs l "
                   + " LEFT JOIN tbl_users u ON l.l_user_id = u.id "
                   + " ORDER BY l.l_id DESC"; 
        
        conf.displayData(sql, logsTable);
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(null, "Error loading logs: " + e.getMessage());
    }
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DELETE;
    private javax.swing.JButton EXIT;
    private javax.swing.JButton PRINTLOGS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable logsTable;
    // End of variables declaration//GEN-END:variables

   
private void generateLogPDF() {
  String userHome = System.getProperty("user.home");
    String pdfPath = userHome + "\\Desktop\\System_Audit_Logs.pdf";
    String htmlPath = userHome + "\\Desktop\\temp_logs.html";

  
    StringBuilder html = new StringBuilder();
    html.append("<html><head><style>")
        .append("body { font-family: 'Segoe UI', Tahoma, sans-serif; padding: 40px; }")
        .append("h1 { color: #131E46; text-align: center; border-bottom: 5px solid #FFCC66; padding-bottom: 10px; }")
        .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
        .append("th { background-color: #131E46; color: white; padding: 12px; text-align: left; }")
        .append("td { padding: 10px; border-bottom: 1px solid #ddd; font-size: 12px; }")
        .append("tr:nth-child(even) { background-color: #f9f9f9; }")
        .append("</style></head><body>")
        .append("<h1>SYSTEM AUDIT TRAIL & ACTIVITY LOGS</h1>")
        .append("<p style='text-align:right;'>Generated: ").append(new java.util.Date().toString()).append("</p>")
        .append("<table><thead><tr>")
        .append("<th>ID</th><th>Date/Time</th><th>Admin</th><th>Action</th><th>Details</th>")
        .append("</tr></thead><tbody>");

    for (int i = 0; i < logsTable.getRowCount(); i++) {
        html.append("<tr>");
        for (int j = 0; j < 5; j++) {
            Object val = logsTable.getValueAt(i, j);
            html.append("<td>").append(val != null ? val.toString() : "-").append("</td>");
        }
        html.append("</tr>");
    }
    html.append("</tbody></table></body></html>");

    try {
       
        java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(htmlPath));
        pw.print(html.toString());
        pw.close();

      
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
                enginePath, 
                "--headless", 
                "--disable-gpu", 
                "--print-to-pdf=" + pdfPath, 
                htmlPath
            );
            
            Process process = pb.start();
            
        
            process.waitFor(10, java.util.concurrent.TimeUnit.SECONDS);
            
            java.io.File pdfFile = new java.io.File(pdfPath);
            if (pdfFile.exists()) {
                javax.swing.JOptionPane.showMessageDialog(this, "Audit Report (PDF) saved to Desktop!");
                java.awt.Desktop.getDesktop().open(pdfFile);
                new java.io.File(htmlPath).delete();
            } else {
             
                java.awt.Desktop.getDesktop().browse(new java.io.File(htmlPath).toURI());
                javax.swing.JOptionPane.showMessageDialog(this, "PDF creation timed out. Opened as Web Report.");
            }
        } else {
            java.awt.Desktop.getDesktop().browse(new java.io.File(htmlPath).toURI());
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}
}
