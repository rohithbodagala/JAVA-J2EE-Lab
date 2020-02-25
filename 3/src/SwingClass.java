import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class SwingClass {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Student Data");
        JLabel nameLabel = new JLabel("Enter Name");
        JTextField nameTextField = new JTextField(20);
        JLabel usnLabel = new JLabel("Enter USN");
        JTextField usnTextField = new JTextField(20);
        JLabel addressLabel= new JLabel("Enter Address");
        JTextField addressTextField = new JTextField(20);
        JLabel ageLabel = new JLabel("Enter Age");
        JTextField ageTextField = new JTextField(20);
        JLabel cgpaLabel = new JLabel("CGPA");
        JTextArea cgpaTextField = new JTextArea();
        JButton enterSGPA = new JButton("Enter SGPA");
        JButton compute = new JButton("Compute");
        compute.setEnabled(false);
        JButton done = new JButton("Done");
        JButton display = new JButton("Display");
        JTextArea errorTextArea = new JTextArea();
        JTextArea displayTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(displayTextArea);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        enterSGPA.addActionListener(new ActionListener() {
            int i = 0;
            double total = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = "0";
                if(i<8){
                    s1 = JOptionPane.showInputDialog(null, "Enter SGPA for: " + (i+1) + " semester");
                }
                try {
                    total += Double.parseDouble(s1);
                    i++;
                    errorTextArea.setText(String.valueOf(total));
                    if(i==8){
                        enterSGPA.setEnabled(false);
                        compute.setEnabled(true);
                        i = 0;
                        total = 0;
                    }
                    enterSGPA.doClick();
                }
                catch(Exception exception){
                    errorTextArea.setText("SGPA Entered was not accepted");
                }
            }
        });
        compute.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                String s = errorTextArea.getText();
                double s1 = Double.parseDouble(s)/8;
                cgpaTextField.setText(String.valueOf(s1));
            }
        });
        done.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                String Name = nameTextField.getText();
                String USN = usnTextField.getText();
                String Address = addressTextField.getText();
                String age = ageTextField.getText();
                String cgpa = cgpaTextField.getText();
                students.add(new Student(Name, USN, Address, Integer.parseInt(age), Double.parseDouble(cgpa)));
                compute.setEnabled(false);
                enterSGPA.setEnabled(true);
            }
        });
        display.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                String s1 = "";
                for(Student s: students){
                    s1 = s1 + s;
                }
                displayTextArea.setText(s1);
            }
        });
        JPanel jp1 = new JPanel();
        jFrame.add(jp1);
        jp1.add(nameLabel);
        jp1.add(nameTextField);
        jp1.add(usnLabel);
        jp1.add(usnTextField);
        jp1.add(addressLabel);
        jp1.add(addressTextField);
        jp1.add(ageLabel);
        jp1.add(ageTextField);
        jp1.add(enterSGPA);
        jp1.add(errorTextArea);
        jp1.add(cgpaLabel);
        jp1.add(cgpaTextField);
        jp1.add(compute);
        jp1.add(done);
        JPanel jp2 = new JPanel();
        jFrame.add(jp2);
        jp2.add(display);
        //jFrame.add(displayTextArea);
        jp2.add(jScrollPane);
        jFrame.setVisible(true);
        jFrame.setSize(600, 400);
        jFrame.setLayout(new GridLayout(2,1));
        jp1.setLayout(new GridLayout(7,2));
        jp2.setLayout(new GridLayout(2,1));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}