
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author 63936
 */
public class Batch2 extends javax.swing.JFrame {

    // Declare a variable to store the primary key (product ID) of the selected product.
    private int productPk = 0;

// Declare a variable to store the total quantity of a product.
    private int totalQuantity = 0;

    /**
     * Constructor for the Batch2 class. This initializes the form and centers
     * the UI and table elements.
     */
    public Batch2() {
        // Initialize the UI components (e.g., buttons, text fields, table).
        initComponents();

        // Set the JFrame to appear in the center of the screen.
        setLocationRelativeTo(null);

        // Center-align the text in the table cells.
        centerTableText();

        // Center-align the text in the table header (column titles).
        centerTableHeader();
    }

    // Method to center-align the text in all cells of the table (tableBatch2).
    private void centerTableText() {
        // Create a cell renderer that aligns text to the center.
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Apply the renderer to each column in the table.
        for (int i = 0; i < tableBatch2.getColumnCount(); i++) {
            tableBatch2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

// Method to center-align the text in the table header (column titles).
    private void centerTableHeader() {
        // Get the header of the table (column titles).
        JTableHeader header = tableBatch2.getTableHeader();

        // Get the default renderer for the table header.
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();

        // Set the renderer to align the header text to the center.
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // Apply the modified renderer back to the table header.
        header.setDefaultRenderer(headerRenderer);
    }

// Method to validate form fields based on the form type ("edit" or "new").
    private boolean validateFields(String formType) {
        // Validation for "edit" mode:
        // Ensure "name," "price," and "expiration date" fields are not empty.
        if (formType.equals("edit")
                && !txtName.getText().equals("")
                && !txtPrice.getText().equals("")
                && !txtExpirationDate.getText().equals("")) {
            return false; // Fields are valid; no validation error.
        } // Validation for "new" mode:
        // Ensure "name," "price," "expiration date," and "quantity" fields are not empty.
        else if (formType.equals("new")
                && !txtName.getText().equals("")
                && !txtPrice.getText().equals("")
                && !txtExpirationDate.getText().equals("")
                && !txtQuantity.getText().equals("")) {
            return false; // Fields are valid; no validation error.
        } // If any required field is empty, return true to indicate a validation error.
        else {
            return true;
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblExpiratonDate = new javax.swing.JLabel();
        txtExpirationDate = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBatch2 = new javax.swing.JTable();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/All_page_Background.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblName.setFont(new java.awt.Font("Powerhouse Sans", 0, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Name");
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, -1, -1));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 320, -1));

        lblQuantity.setFont(new java.awt.Font("Powerhouse Sans", 0, 18)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantity.setText("Quantity");
        jPanel1.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, -1, -1));

        txtQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 320, -1));

        lblPrice.setFont(new java.awt.Font("Powerhouse Sans", 0, 18)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblPrice.setText("Price");
        jPanel1.add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, -1));

        txtPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 320, -1));

        lblExpiratonDate.setFont(new java.awt.Font("Powerhouse Sans", 0, 18)); // NOI18N
        lblExpiratonDate.setForeground(new java.awt.Color(255, 255, 255));
        lblExpiratonDate.setText("Expiration Date");
        jPanel1.add(lblExpiratonDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, -1, -1));

        txtExpirationDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtExpirationDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtExpirationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 320, -1));

        btnSave.setBackground(new java.awt.Color(0, 20, 82));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 560, 70, -1));

        btnUpdate.setBackground(new java.awt.Color(0, 20, 82));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, 80, -1));

        btnReset.setBackground(new java.awt.Color(0, 20, 82));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Delete");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 560, -1, -1));

        btnClose.setBackground(new java.awt.Color(204, 0, 0));
        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 560, 70, -1));

        jLabel3.setFont(new java.awt.Font("Powerhouse Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("BATCH 3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, 30));

        tableBatch2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tableBatch2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Quantity", "Price", "Expiration Date"
            }
        ));
        tableBatch2.setRowHeight(30);
        tableBatch2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBatch2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBatch2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 830, 210));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        try (Connection con = MyConnection.getConnection()) {

            // Get the selected row index in the JTable
            DefaultTableModel model = (DefaultTableModel) tableBatch2.getModel();
            int selectedRow = tableBatch2.getSelectedRow();

            // If no row is selected, show a message and return
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String name = model.getValueAt(selectedRow, 0).toString();
            String quantity = model.getValueAt(selectedRow, 1).toString();

            // Get the values from the selected row (assuming the client_name and file_link are in columns 0 and 1)
            // SQL query to delete the row from the database based on client_name and file_link
            String sql = "DELETE FROM batchone WHERE name=? AND quantity=?";

            // Prepare the SQL statement
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, name);
                stmt.setString(2, quantity);

                // Set client_name value
                // Set file_link value
                // Execute the update (deletion)
                int rowsAffected = stmt.executeUpdate();

                // If rows are affected, proceed to remove the row from the table
                if (rowsAffected > 0) {
                    // Remove the selected row from the table model
                    model.removeRow(selectedRow);

                    // Show success message
                    JOptionPane.showMessageDialog(null, "Row deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // If no rows were deleted from the database
                    JOptionPane.showMessageDialog(null, "Error deleting the row from the database.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
        setVisible(false);
        new Batch2().setVisible(true);


    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        // Retrieve the values entered by the user in the text fields.
        String name = txtName.getText(); // Get the "name" value from the txtName field.
        String quantity = txtQuantity.getText(); // Get the "quantity" value from the txtQuantity field.
        String price = txtPrice.getText(); // Get the "price" value from the txtPrice field.
        String expirationDate = txtExpirationDate.getText(); // Get the "expirationDate" value from the txtExpirationDate field.

        // Call the validateFields method to ensure all required fields are filled.
        if (validateFields("new")) {
            // If any required fields are empty, display a message and stop further processing.
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            try {
                // Establish a connection to the database using the custom MyConnection class.
                Connection con = MyConnection.getConnection();

                // Prepare an SQL query to insert the new product into the "batchone" table.
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO batchone (name, quantity, price, expirationDate) VALUES (?, ?, ?, ?)"
                );

                // Set the values for the placeholders (?) in the prepared statement.
                ps.setString(1, name); // Set the "name" field value.
                ps.setString(2, quantity); // Set the "quantity" field value.
                ps.setString(3, price); // Set the "price" field value.
                ps.setString(4, expirationDate); // Set the "expirationDate" field value.

                // Execute the SQL query to insert the product data into the database.
                ps.executeUpdate();

                // If successful, display a message confirming the product was added.
                JOptionPane.showMessageDialog(null, "Product Added Successfully");

                // Close the current window and refresh the UI by opening a new instance of Batch2.
                setVisible(false);
                new Batch2().setVisible(true);
            } catch (Exception e) {
                // If any error occurs during the database interaction, show the error message.
                JOptionPane.showMessageDialog(null, e);
            }
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        // Create a DefaultTableModel to manage the data in the table (tableBatch2).
        DefaultTableModel model = (DefaultTableModel) tableBatch2.getModel();

        // Start a try-catch block to handle exceptions that might occur during the database interaction.
        try {
            // Establish a connection to the database using the custom MyConnection class.
            Connection con = MyConnection.getConnection();

            // Create a Statement object to execute SQL queries on the database.
            Statement st = con.createStatement();

            // Execute a SQL query to select all records from the "batchone" table.
            ResultSet rs = st.executeQuery("SELECT * FROM batchone");

            // Loop through all rows returned by the query (ResultSet).
            while (rs.next()) {
                // Add a new row to the table model using the data retrieved from the database.
                // Get the "name", "quantity", "price", and "expirationDate" values from the ResultSet.
                model.addRow(new Object[]{
                    rs.getString("name"), // The name of the product.
                    rs.getString("quantity"), // The quantity of the product.
                    rs.getString("price"), // The price of the product.
                    rs.getString("expirationDate") // The expiration date of the product.
                });
            }
        } catch (Exception e) {
            // If an error occurs (e.g., database connection failure or query issue), show an error message.
            JOptionPane.showMessageDialog(null, e);
        }

        // Disable the "Update" button initially since no product is selected for editing.
        btnUpdate.setEnabled(false);

    }//GEN-LAST:event_formComponentShown

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tableBatch2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBatch2MouseClicked
        // TODO add your handling code here:
        // Get the index of the selected row in the table.
        int index = tableBatch2.getSelectedRow();

        // Get the model of the table (tableBatch2) to access the data of the selected row.
        TableModel model = tableBatch2.getModel();

        // Retrieve the value of the "name" from the selected row (column 0).
        String name = model.getValueAt(index, 0).toString();

        // Set the retrieved "name" value into the txtName text field.
        txtName.setText(name);

        // Retrieve the value of the "quantity" from the selected row (column 1).
        String quantity = model.getValueAt(index, 1).toString();

        // Set the label for quantity to prompt the user to "Add Quantity" (or edit it).
        lblQuantity.setText("Add Quantity");

        // Retrieve the value of the "price" from the selected row (column 2).
        String price = model.getValueAt(index, 2).toString();

        // Set the retrieved "price" value into the txtPrice text field.
        txtPrice.setText(price);

        // Retrieve the value of the "expirationDate" from the selected row (column 3).
        String expirationDate = model.getValueAt(index, 3).toString();

        // Set the retrieved "expirationDate" value into the txtExpirationDate text field.
        txtExpirationDate.setText(expirationDate);

        // Disable the "Save" button since the user is in "edit" mode (updating an existing record).
        btnSave.setEnabled(false);

        // Enable the "Update" button since the user is selecting a record for updating.
        btnUpdate.setEnabled(true);


    }//GEN-LAST:event_tableBatch2MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        // Retrieve the values entered by the user in the text fields.
        // Get input values from the fields.
        String name = txtName.getText();
        String quantity = txtQuantity.getText();
        String price = txtPrice.getText();
        String expirationDate = txtExpirationDate.getText();

// Ensure that all required fields are filled in.
        if (validateFields("edit")) {
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            try {
                // Parse the quantity value as an integer.
                int newQuantity = Integer.parseInt(quantity);

                // Establish a connection to the database.
                Connection con = MyConnection.getConnection();

                // Prepare an SQL update query to modify the selected product details.
                // This query will only update the product that matches the selected "name".
                PreparedStatement ps = con.prepareStatement(
                        "UPDATE batchone SET quantity = quantity + ?, price = ?, expirationDate = ? WHERE name = ?"
                );

                // Set the values for the placeholders in the prepared statement.
                ps.setInt(1, newQuantity); // Add the new quantity to the current quantity in the database.
                ps.setString(2, price); // Set the new price in the database.
                ps.setString(3, expirationDate); // Set the new expiration date in the database.
                ps.setString(4, name); // Specify the product to update by name.

                // Execute the update query.
                int rowsUpdated = ps.executeUpdate();

                if (rowsUpdated > 0) {
                    // If the update is successful, display a success message.
                    JOptionPane.showMessageDialog(null, "Product Updated Successfully");

                    // Close the current window and open a new instance of Batch2 to refresh the UI.
                    setVisible(false);
                    new Batch2().setVisible(true);
                } else {
                    // If no rows were updated, notify the user (e.g., product not found).
                    JOptionPane.showMessageDialog(null, "No product found with the specified name.");
                }

            } catch (NumberFormatException e) {
                // If the quantity is not a valid number, catch the exception and show an error message.
                JOptionPane.showMessageDialog(null, "Invalid quantity format. Please enter a numeric value.");
            } catch (Exception e) {
                // If any other exception occurs, display the error message.
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

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
            java.util.logging.Logger.getLogger(Batch2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Batch2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Batch2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Batch2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Batch2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblExpiratonDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JTable tableBatch2;
    private javax.swing.JTextField txtExpirationDate;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
