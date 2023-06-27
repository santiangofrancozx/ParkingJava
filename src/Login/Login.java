package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JDialog {
    JLabel correo, contraseña;
    JButton aceptar;
    JTextField email, password;
    public Login(Frame papa, Boolean modal){
        super(papa, modal);
        setTitle("Logeo");
// SAPO HPTA
        contraseña = new JLabel("Contraseña");
        contraseña.setBounds(30, 80, 100, 30);

        correo = new JLabel("Correo");
        correo.setBounds(30, 30, 100, 30);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(130, 130, 100, 30);

        email = new JTextField(10);
        email.setBounds(130, 30, 200, 30);

        password = new JTextField(10);
        password.setBounds(130, 80, 200, 30);

        add(correo);
        add(email);
        add(contraseña);
        add(password);
        add(aceptar);

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });




        setSize(350,200);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Login(null, true);
        // HOLA MUNDO
    }
}
