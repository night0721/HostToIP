package frames;

import javax.swing.border.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;

public class Frame extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    JButton btnResolve;
    String address;

    public Frame() {
        this.setVisible(true);
        this.setTitle("Host -> IP");
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 434, 157);
        (this.contentPane = new JPanel()).setBorder((new EmptyBorder(5,5,5,5)));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final JLabel lblBittteGebeEin = new JLabel("IP");
        this.contentPane.add(lblBittteGebeEin);
        lblBittteGebeEin.setBounds(-10, 11, 418, 14);
        this.textField = new JTextField();
        this.contentPane.add(textField);
        this.textField.setBounds(144, 29, 131, 20);
        this.textField.setColumns(10);
        this.textField_1 = new JTextField();
        this.contentPane.add(textField_1);
        this.textField_1.setBounds(98,87,222,20);
        this.textField_1.setEditable(false);
        this.textField_1.setColumns(10);
        this.btnResolve = new JButton("Resolve");
        this.contentPane.add(this.btnResolve);
        this.btnResolve.addActionListener(this);
        this.btnResolve.setBounds(167,53,89,23);


    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == this.btnResolve && !this.textField.getText().isEmpty()) {
            final String host = this.textField.getText().toString().toLowerCase();
            try {
                this.address = InetAddress.getByName(host).getHostAddress();
            }
            catch (UnknownHostException e2) {
                this.textField_1.setText(e2.toString());
            }
            this.textField_1.setText(this.address);
        }
    }
}
