//Caleb Garcia

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComputerListObject extends JPanel implements ActionListener {
    
    JButton computerBtn = new JButton("Computer " + Home.computersList.size());
    Computer comp;
    String opticals = "";
    String ios = "";
    
    public ComputerListObject(Computer comp) {
        setPreferredSize(new Dimension(299, 30));
        setLayout(new FlowLayout());
        
        this.comp = comp;
        add(computerBtn);
        computerBtn.addActionListener(this);
        
        opticalsForDisplay();
        ioForDisplay();
    }
    
    private void opticalsForDisplay() {
        for (String optical : comp.opticalSelecs) {
            opticals += optical + "\n";
        }
    }
    
    private void ioForDisplay() {
        for (String io : comp.ioSelecs) {
            ios += io + "\n";
        }
    }
    
    private void showComputer() {
        JOptionPane.showMessageDialog(null, computerBtn.getText() + " Order:\n\nCPU: "
                + comp.cpuSel + "\n\nRAM Storage: " + comp.ramSel + "\n\nHDD Storage: "
                + comp.hddSel + "\n\nOptical Drives:\n" + opticals + "\nI/O:\n"
                + ios + "\nSubtotal: $" + String.format("%.2f", comp.subtotal)
                + "\nTax: $" + String.format("%.2f", comp.tax) + "\nTotal: $"
                + String.format("%.2f", comp.total));
    }
    
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        
        if (computerBtn.equals(source)) {
            showComputer();
        }
    }
}

