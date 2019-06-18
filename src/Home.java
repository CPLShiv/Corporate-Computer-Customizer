//Caleb Garcia

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {
    
    JPanel containerPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 60, 55));
    
    JButton addBtn = new JButton("Add Computer");
    JButton invoiceBtn = new JButton("Generate Invoice");
    JButton exitBtn = new JButton("Exit");
    
    public static ArrayList<Computer> computersList = new ArrayList();
    public static ArrayList<ComputerListObject> listObjs = new ArrayList();
    public static ArrayList<Double> totals = new ArrayList();
    
    public Home() {
        // Frame and panel settings
        pack();
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Corporate Computer Customizer");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().add(containerPanel);
        
        buildButtons();
    }
    
    private void buildButtons() {
        addBtn.setPreferredSize(new Dimension(380, 80));
        invoiceBtn.setPreferredSize(new Dimension(380, 80));
        exitBtn.setPreferredSize(new Dimension(380, 80));
        containerPanel.add(addBtn);
        containerPanel.add(invoiceBtn);
        containerPanel.add(exitBtn);
        addListeners();
    }
    
    private void addListeners() {
        addBtn.addActionListener(this);
        invoiceBtn.addActionListener(this);
        exitBtn.addActionListener(this);
    }
    
    private void showAddWindow() {
        AddWindow window = new AddWindow();
    }
    
    private void showInvoiceWindow() {
        InvoiceWindow window = new InvoiceWindow();
    }
    
    private void exit() {
        JOptionPane.showMessageDialog(null, "Thank you for using the Corporate Computer Customizer.");
        System.exit(0);
    }
    
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        
        if (addBtn.equals(source)) {
            showAddWindow();
        } else if (invoiceBtn.equals(source)) {
            showInvoiceWindow();
        } else if (exitBtn.equals(source)) {
            exit();
        }
    }
}

