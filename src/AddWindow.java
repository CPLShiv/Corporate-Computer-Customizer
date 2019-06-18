//Caleb Garcia

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class AddWindow extends JFrame implements ActionListener {
    
    JPanel containerPanel = new JPanel(new BorderLayout());
    JPanel componentsPanel = new JPanel(null);
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 50, 15));
    
    //Labels
    JLabel cpuLbl = new JLabel("CPU:");
    JLabel ramLbl = new JLabel("RAM:");
    JLabel hddLbl = new JLabel("Hard Drive:");
    JLabel opticalLbl = new JLabel("Optical Drive:");
    JLabel ioLbl = new JLabel("I/O:");
    JLabel caseLbl = new JLabel("Case Profile:");
    
    //Radios and groups
    //CPU
    JRadioButton i5Radio = new JRadioButton("i5 - $538");
    JRadioButton i7Radio = new JRadioButton("i7 - $755");
    JRadioButton i9Radio = new JRadioButton("i9 - $999");
    ButtonGroup cpuGrp = new ButtonGroup();
    
    //RAM
    JRadioButton gb8Radio = new JRadioButton("8GB - $100");
    JRadioButton gb16Radio = new JRadioButton("16GB - $175");
    JRadioButton gb32Radio = new JRadioButton("32GB - $300");
    ButtonGroup ramGrp = new ButtonGroup();
    
    //HDD
    JRadioButton gb250Radio  = new JRadioButton("250GB - $80");
    JRadioButton gb500Radio = new JRadioButton("500GB - $140");
    JRadioButton tb1Radio = new JRadioButton("1TB - $180");
    ButtonGroup hddGrp = new ButtonGroup();
    
    //Case
    JRadioButton standardRadio = new JRadioButton("Standard");
    JRadioButton slimRadio = new JRadioButton("Slim");
    JRadioButton flatlowRadio = new JRadioButton("Flat Low");
    ButtonGroup caseGrp = new ButtonGroup();
    
    //Checks
    //Optical
    JCheckBox dvdBox = new JCheckBox("DVD - $50");
    JCheckBox dvdrwBox = new JCheckBox("DVD R/W - $60");
    JCheckBox blurayBox = new JCheckBox("Blu-Ray - $100");
    JCheckBox blurayrwBox = new JCheckBox("Blu-Ray R/W - $120");
    
    //IO
    JCheckBox keyboardBox = new JCheckBox("Performance Keyboard - $50");
    JCheckBox mouseBox = new JCheckBox("Performance Mouse - $40");
    JCheckBox trakBox = new JCheckBox("Trak Ball - $60");
    JCheckBox tabletBox = new JCheckBox("Tablet - $100");
    
    JCheckBox addMoreBox = new JCheckBox("Add More");
    
    //Buttons
    JButton clearBtn = new JButton("Clear");
    JButton addBtn = new JButton("Add");
    JButton closeBtn = new JButton("Close");
    
    //Button and check lists
    ArrayList<JRadioButton> cpuBtns = new ArrayList();
    ArrayList<JRadioButton> ramBtns = new ArrayList();
    ArrayList<JRadioButton> hddBtns = new ArrayList();
    ArrayList<JRadioButton> caseBtns = new ArrayList();
    ArrayList<JCheckBox> opticalChecks = new ArrayList();
    ArrayList<JCheckBox> ioChecks = new ArrayList();
    
    public AddWindow() {
        // Frame and panel settings
        pack();
        setSize(Constants.ADD_WINDOW_WIDTH, Constants.ADD_WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Corporate Computer Customizer");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        getContentPane().add(containerPanel);
        
        buildWindow();
        buildLists();
    }
    
    private void buildWindow() {
        componentsPanel.setPreferredSize(new Dimension(600, 350));
        buttonPanel.setPreferredSize(new Dimension(600, 50));
        
        containerPanel.add(componentsPanel, BorderLayout.CENTER);
        containerPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        buildCompsPanel();
        buildButtonPanel();
    }
    
    private void buildLists() {
        buildCPUList();
        buildRAMList();
        buildHDDList();
        buildCaseList();
        buildOpticalList();
        buildIOList();
    }
    
    private void buildCPUList() {
        cpuBtns.add(i5Radio);
        cpuBtns.add(i7Radio);
        cpuBtns.add(i9Radio);
    }
    
    private void buildRAMList() {
        ramBtns.add(gb8Radio);
        ramBtns.add(gb16Radio);
        ramBtns.add(gb32Radio);
    }
    
    private void buildHDDList() {
        hddBtns.add(gb250Radio);
        hddBtns.add(gb500Radio);
        hddBtns.add(tb1Radio);
    }
    
    private void buildCaseList() {
        caseBtns.add(standardRadio);
        caseBtns.add(slimRadio);
        caseBtns.add(flatlowRadio);
    }
    
    private void buildOpticalList() {
        opticalChecks.add(dvdBox);
        opticalChecks.add(dvdrwBox);
        opticalChecks.add(blurayBox);
        opticalChecks.add(blurayrwBox);
    }
    
    private void buildIOList() {
        ioChecks.add(keyboardBox);
        ioChecks.add(mouseBox);
        ioChecks.add(trakBox);
        ioChecks.add(tabletBox);
    }
    
    private void buildCompsPanel() {
        addLabels();
        addRadios();
        addChecks();
        
        addItemListeners();
    }
    
    private void addLabels() {
        cpuLbl.setFont(Constants.BOLD_FONT);
        ramLbl.setFont(Constants.BOLD_FONT);
        hddLbl.setFont(Constants.BOLD_FONT);
        opticalLbl.setFont(Constants.BOLD_FONT);
        ioLbl.setFont(Constants.BOLD_FONT);
        caseLbl.setFont(Constants.BOLD_FONT);
        
        cpuLbl.setBounds(50, 30, 50, 15);
        ramLbl.setBounds(210, 30, 50, 15);
        hddLbl.setBounds(380, 30, 80, 15);
        caseLbl.setBounds(50, 170, 100, 15);
        opticalLbl.setBounds(210, 170, 130, 15);
        ioLbl.setBounds(380, 170, 40, 15);
        
        componentsPanel.add(cpuLbl);
        componentsPanel.add(ramLbl);
        componentsPanel.add(hddLbl);
        componentsPanel.add(caseLbl);
        componentsPanel.add(opticalLbl);
        componentsPanel.add(ioLbl);
    }
    
    private void addRadios() {
        addCPUGroup();
        addRAMGroup();
        addHDDGroup();
        addCaseGroup();
    }
    
    private void addCPUGroup() {
        cpuGrp.add(i5Radio);
        cpuGrp.add(i7Radio);
        cpuGrp.add(i9Radio);
        
        i5Radio.setBounds(50, 50, 100, 20);
        i7Radio.setBounds(50, 80, 100, 20);
        i9Radio.setBounds(50, 110, 100, 20);
        
        componentsPanel.add(i5Radio);
        componentsPanel.add(i7Radio);
        componentsPanel.add(i9Radio);
    }
    
    private void addRAMGroup() {
        ramGrp.add(gb8Radio);
        ramGrp.add(gb16Radio);
        ramGrp.add(gb32Radio);
        
        gb8Radio.setBounds(210, 50, 110, 20);
        gb16Radio.setBounds(210, 80, 130, 20);
        gb32Radio.setBounds(210, 110, 130, 20);
        
        componentsPanel.add(gb8Radio);
        componentsPanel.add(gb16Radio);
        componentsPanel.add(gb32Radio);
    }
    
    private void addHDDGroup() {
        hddGrp.add(gb250Radio);
        hddGrp.add(gb500Radio);
        hddGrp.add(tb1Radio);
        
        gb250Radio.setBounds(380, 50, 120, 20);
        gb500Radio.setBounds(380, 80, 120, 20);
        tb1Radio.setBounds(380, 110, 120, 20);
        
        componentsPanel.add(gb250Radio);
        componentsPanel.add(gb500Radio);
        componentsPanel.add(tb1Radio);
    }
    
    private void addCaseGroup() {
        caseGrp.add(standardRadio);
        caseGrp.add(slimRadio);
        caseGrp.add(flatlowRadio);
        
        standardRadio.setBounds(50, 190, 100, 20);
        slimRadio.setBounds(50, 220, 100, 20);
        flatlowRadio.setBounds(50, 250, 100, 20);
        
        componentsPanel.add(standardRadio);
        componentsPanel.add(slimRadio);
        componentsPanel.add(flatlowRadio);
    }
    
    private void addChecks() {
        addOpticalChecks();
        addIOChecks();
    }
    
    private void addOpticalChecks() {
        dvdBox.setBounds(210, 190, 150, 20);
        dvdrwBox.setBounds(210, 220, 150, 20);
        blurayBox.setBounds(210, 250, 150, 20);
        blurayrwBox.setBounds(210, 280, 180, 20);
        
        componentsPanel.add(dvdBox);
        componentsPanel.add(dvdrwBox);
        componentsPanel.add(blurayBox);
        componentsPanel.add(blurayrwBox);
    }
    
    private void addIOChecks() {
        keyboardBox.setBounds(380, 190, 230, 20);
        mouseBox.setBounds(380, 220, 230, 20);
        trakBox.setBounds(380, 250, 200, 20);
        tabletBox.setBounds(380, 280, 200, 20);
        
        componentsPanel.add(keyboardBox);
        componentsPanel.add(mouseBox);
        componentsPanel.add(trakBox);
        componentsPanel.add(tabletBox);
    }
    
    private void addItemListeners() {
        
    }
    
    private void buildButtonPanel() {
        buttonPanel.add(clearBtn);
        buttonPanel.add(addBtn);
        buttonPanel.add(addMoreBox);
        buttonPanel.add(closeBtn);
        
        addListeners();
    }
    
    private void addListeners() {
        clearBtn.addActionListener(this);
        addBtn.addActionListener(this);
        closeBtn.addActionListener(this);
    }
    
    private String getCPUSelection() {
        for (JRadioButton btn : cpuBtns) {
            if (btn.isSelected()) {
                return btn.getText();
            }
        }
        return "";
    }
    
    private String getRAMSelection() {
        for (JRadioButton btn : ramBtns) {
            if (btn.isSelected()) {
                return btn.getText();
            }
        }
        return "";
    }
    
    private String getHDDSelection() {
        for (JRadioButton btn : hddBtns) {
            if (btn.isSelected()) {
                return btn.getText();
            }
        }
        return "";
    }
    
    private String getCaseSelection() {
        for (JRadioButton btn : caseBtns) {
            if (btn.isSelected()) {
                return btn.getText();
            }
        }
        return "";
    }
    
    private String getOpticalSelections() {
        String selections  = "";
        for (JCheckBox box : opticalChecks) {
            if (box.isSelected()) {
                selections += box.getText() + "\n";
            }
        }
        return selections;
    }
    
    private String getIOSelections() {
        String selections = "";
        for (JCheckBox box : ioChecks) {
            if (box.isSelected()) {
                selections += box.getText() + "\n";
            }
        }
        return selections;
    }
    
    private void clear() {
        cpuGrp.clearSelection();
        
        ramGrp.clearSelection();
        
        hddGrp.clearSelection();
        
        caseGrp.clearSelection();
        
        dvdBox.setSelected(false);
        dvdrwBox.setSelected(false);
        blurayBox.setSelected(false);
        blurayrwBox.setSelected(false);
        
        keyboardBox.setSelected(false);
        mouseBox.setSelected(false);
        trakBox.setSelected(false);
        tabletBox.setSelected(false);
    }
    
    private void add() {
        boolean validComp = true;
        
        String cpuSel = getCPUSelection();
        String ramSel = getRAMSelection();
        String hddSel = getHDDSelection();
        String caseSel = getCaseSelection();
        String opticalSels = getOpticalSelections();
        String ioSels = getIOSelections();
        
        if (cpuSel.equals("")) {
            JOptionPane.showMessageDialog(null, "Please choose a CPU type.");
            validComp = false;
        }
        
        if (ramSel.equals("")) {
            JOptionPane.showMessageDialog(null, "Please choose a RAM storage amount.");
            validComp = false;
        }
        
        if (hddSel.equals("")) {
            JOptionPane.showMessageDialog(null, "Please choose a HDD storage amount.");
            validComp = false;
        }
        
        if (caseSel.equals("")) {
            JOptionPane.showMessageDialog(null, "Please choose a case type.");
            validComp = false;
        }
        
        if (validComp) {
            Computer comp = new Computer(cpuSel, ramSel, hddSel, caseSel, opticalSels, ioSels);
            Home.computersList.add(comp);
            ComputerListObject clo = new ComputerListObject(comp);
            Home.listObjs.add(clo);
            if (!addMoreBox.isSelected()) {
                close();
            } else {
                clear();
            }
            
        }
        
        //System.out.println(cpuSel + " " + ramSel + " " + hddSel + " " + caseSel + " "
        //        + opticalSels + " " + ioSels);
    }
    
    private void close() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        
        if (clearBtn.equals(source)) {
            clear();
        } else if (addBtn.equals(source)) {
            add();
        } else if (closeBtn.equals(source)) {
            close();
        }
    }
}

