//Caleb Garcia

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class InvoiceWindow extends JFrame implements ActionListener {
    
    JPanel containerPanel = new JPanel(new BorderLayout());
    JPanel listPanel = new JPanel(new FlowLayout());
    JPanel utilPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
    
    //Util panel
    JLabel orderTotalLbl = new JLabel("Order total: $");
    JButton exitBtn = new JButton("Exit");
    
    Double allOrdersTotal = 0.0;
    
    public InvoiceWindow() {
        // Frame and panel settings
        pack();
        setSize(Constants.LIST_WINDOW_WIDTH, Constants.LIST_WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Corporate Computer Customizer");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        getContentPane().add(containerPanel);
        
        calculateOrderTotal();
        
        buildWindow();
        buildListPanel();
        buildUtilPanel();
    }
    
    private void calculateOrderTotal() {
        for (Double orderTotal : Home.totals) {
            this.allOrdersTotal += orderTotal;
        }
    }
    
    private void buildWindow() {
        listPanel.setPreferredSize(new Dimension(500, 450));
        utilPanel.setPreferredSize(new Dimension(500, 50));
        
        containerPanel.add(listPanel, BorderLayout.CENTER);
        containerPanel.add(utilPanel, BorderLayout.SOUTH);
    }
    
    private void buildListPanel() {
        for (ComputerListObject clo : Home.listObjs) {
            listPanel.add(clo);
        }
        listPanel.revalidate();
    }
    
    private void buildUtilPanel() {
        utilPanel.add(orderTotalLbl);
        if (allOrdersTotal == null) {
            orderTotalLbl.setText(orderTotalLbl.getText() + "00.00");
        } else {
            orderTotalLbl.setText(orderTotalLbl.getText()
                    + String.format("%.2f", allOrdersTotal));
        }
            utilPanel.add(exitBtn);
        exitBtn.addActionListener(this);
    }
    
    private void exit() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        
        if (exitBtn.equals(source)) {
            exit();
        }
    }
}

