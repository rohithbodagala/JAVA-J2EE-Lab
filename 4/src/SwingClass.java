import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
public class SwingClass {
    private static HashMap<Long, Customer> customers = new HashMap<>();
    private static HashMap<Integer, Item> items = new HashMap<>();
    static boolean flag = false;
    public static void main(String args[]){
        JFrame jFrame = new JFrame("Item Store"), jFrame1 = new JFrame("CustomerCheck");
        customers.put(9243433993L, new Customer(9243433993L, "ABC"));
        customers.put(9448780113L, new Customer(9448780113L, "BCD"));
        customers.put(9880106131L, new Customer(9880106131L, "CDE"));
        for(int i=0;i<5;i++){
            items.put(i, new Item(i, "item" + i, 10*i));
        }
        getUserName();
        JLabel customerLabel = new JLabel("Enter the phone number:");
        JTextField customerField = new JTextField(20);
        JButton check = new JButton("Check");
        JLabel customerPhField = new JLabel();
        customerPhField.setEnabled(flag);
        JLabel customerIdField = new JLabel();
        customerIdField.setEnabled(flag);
        
        
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer C = null;
                try {
                    C = customers.get(Long.parseLong(customerField.getText()));
                }
                catch (Exception exception){

                }
                jFrame1.setVisible(true);
                customerPhField.setText(customerField.getText());
                customerIdField.setText(C.id);
                jFrame.setVisible(true);
            }
        });
        jFrame1.add(customerLabel);
        jFrame1.add(customerField);
        jFrame1.add(check);
        jFrame1.setSize(300, 200);
        jFrame1.setLayout(new GridLayout(3, 1));

        JLabel customerPh = new JLabel("Customer Phone Number");
        JLabel customerId = new JLabel("Customer ID");
        JLabel itemId = new JLabel("Enter item ID");
        JTextField itemIdField = new JTextField(20);
        JLabel itemQty = new JLabel("Enter the Quantity");
        JTextField itemQtyField = new JTextField(20);
        JLabel itemName = new JLabel("Item Name");
        JLabel itemNameArea = new JLabel();
        JLabel itemCost = new JLabel("Item Cost");
        JLabel itemCostArea = new JLabel();
        JButton display = new JButton("Display");
        JButton compute = new JButton("Compute Total: ");
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item i = items.get(Integer.parseInt(itemIdField.getText()));
                itemNameArea.setText(i.name);
                itemCostArea.setText(String.valueOf(i.cost));
            }
        });
        compute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] ch = {"10%", "20%", "30%"};
                int i = JOptionPane.showOptionDialog(null, "Enter the Discount", "Discount", 0,
                        JOptionPane.INFORMATION_MESSAGE, null, ch, ch[0]);
                double total = Double.parseDouble(itemCostArea.getText()) * Double.parseDouble(itemQtyField.getText())
                        - (Double.parseDouble(itemCostArea.getText()) * Double.parseDouble(itemQtyField.getText())) * (i+1) * 10 / 100;
                compute.setText(" Computed: " + total);
                JOptionPane.showMessageDialog(null, String.valueOf(total), "Total", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        jFrame.add(customerPh);
        jFrame.add(customerPhField);
        jFrame.add(customerId);
        jFrame.add(customerIdField);
        jFrame.add(itemId);
        jFrame.add(itemIdField);
        jFrame.add(itemQty);
        jFrame.add(itemQtyField);
        jFrame.add(itemName);
        jFrame.add(itemNameArea);
        jFrame.add(itemCost);
        jFrame.add(itemCostArea);
        jFrame.add(display);
        jFrame.add(compute);

        jFrame.setVisible(false);
        jFrame1.setVisible(true);
        jFrame.setLayout(new GridLayout(7,2));
        jFrame.setSize(600, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private static void getUserName() {
        String userName = JOptionPane.showInputDialog(null, "Enter UserName");
        if(userName.equals("Andrew")){
            String passWd = JOptionPane.showInputDialog(null, "Enter password");
            if(passWd.equals("XXX")){
                flag = true;
                return;
            }
            JOptionPane.showMessageDialog(null, "Password invalid", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "UserName is Invalid", "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
