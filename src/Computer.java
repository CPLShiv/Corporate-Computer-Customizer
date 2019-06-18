
//Caleb Garcia
    
import java.util.*;
import java.util.HashMap;
import java.util.Map;
    
public class Computer {
    
    String cpuSel;
    String ramSel;
    String hddSel;
    String caseSel;
    String[] opticalSels;
    String[] ioSels;
    ArrayList<String> opticalSelecs = new ArrayList();
    ArrayList<String> ioSelecs = new ArrayList();
    
    Map<String, Double> cpuPrices = new HashMap();
    Map<String, Double> ramPrices = new HashMap();
    Map<String, Double> hddPrices = new HashMap();
    Map<String, Double> opticalPrices = new HashMap();
    Map<String, Double> ioPrices = new HashMap();
    
    Double cpuPrice = 0.00;
    Double ramPrice = 0.00;
    Double hddPrice = 0.00;
    Double opticalPrice = 0.00;
    Double ioPrice = 0.00;
    
    Double subtotal = 0.00;
    Double tax = 0.00;
    Double total = 0.00;
    
    public Computer(String cpuSel, String ramSel, String hddSel, String caseSel,
            String opticalSels, String ioSels) {
        
        this.cpuSel = cpuSel;
        this.ramSel = ramSel;
        this.hddSel = hddSel;
        this.caseSel = caseSel;
        this.opticalSels = opticalSels.split("\n");
        this.ioSels = ioSels.split("\n");
        
        addOpticalToList();
        addIOToList();
        
        definePrices();
        
        cpuPrice = getCPUPrice(cpuSel);
        ramPrice = getRAMPrice(ramSel);
        hddPrice = getHDDPrice(hddSel);
        opticalPrice = getOpticalsPrice(opticalSelecs);
        ioPrice = getIOPrice(ioSelecs);
        
        calculateTotal(cpuPrice, ramPrice, hddPrice, opticalPrice, ioPrice);
    }
    
    private void addOpticalToList() {
        for (int i = 0; i < opticalSels.length; i++) {
            opticalSelecs.add(opticalSels[i]);
        }
    }
    
    private void addIOToList() {
        for (int i = 0; i < ioSels.length; i++) {
            ioSelecs.add(ioSels[i]);
        }
    }
    
    private void definePrices() {
        defineCPUPrices();
        defineRAMPrices();
        defineHDDPrices();
        defineOpticalPrices();
        defineIOPrices();
    }
    
    private void defineCPUPrices() {
        cpuPrices.put("i5 - $538", 538.00);
        cpuPrices.put("i7 - $755", 755.00);
        cpuPrices.put("i9 - $999", 999.00);
    }
    
    private void defineRAMPrices() {
        ramPrices.put("8GB - $100", 100.00);
        ramPrices.put("16GB - $175", 175.00);
        ramPrices.put("32GB - $300", 300.00);
    }
    
    private void defineHDDPrices() {
        hddPrices.put("250GB - $80", 80.00);
        hddPrices.put("500GB - $140", 140.00);
        hddPrices.put("1TB - $180", 180.00);
    }
    
    private void defineOpticalPrices() {
        opticalPrices.put("DVD - $50", 50.00);
        opticalPrices.put("DVD R/W - $60", 60.00);
        opticalPrices.put("Blu-Ray - $100", 100.00);
        opticalPrices.put("Blu-Ray R/W - $120", 120.00);
    }
    
    private void defineIOPrices() {
        ioPrices.put("Performance Keyboard - $50", 50.00);
        ioPrices.put("Performance Mouse - $40", 40.00);
        ioPrices.put("Trak Ball - $60", 60.00);
        ioPrices.put("Tablet - $100", 100.00);
    }
    
    private Double getCPUPrice(String cpu) {
        return cpuPrices.get(cpu);
    }
    
    private Double getRAMPrice(String ram) {
        return ramPrices.get(ram);
    }
    
    private Double getHDDPrice(String hdd) {
        return hddPrices.get(hdd);
    }
    
    private Double getOpticalsPrice(ArrayList<String> opticals) {
        Double opticalPrice = 0.0;
        if (opticals.size() > 1) {
            for (String optical : opticals) {
                opticalPrice += opticalPrices.get(optical);
            }
        } else {
            return 0.0;
        }
        return opticalPrice;
    }
    
    private Double getIOPrice(ArrayList<String> ios) {
        Double ioPrice = 0.0;
        if (ios.size() > 1) {
            for (String io : ios) {
                ioPrice += ioPrices.get(io);
            }
        } else {
            return 0.0;
        }
        return ioPrice;
    }
    
    private void calculateTotal(Double cpuTotal, Double ramTotal, Double hddTotal,
            Double opticalTotal, Double ioTotal) {
        subtotal = cpuTotal + ramTotal + hddTotal + opticalTotal + ioTotal;
        tax = subtotal * Constants.SALES_TAX;
        total = subtotal + tax;
        
        Home.totals.add(total);
    }
    
}

