import Beans.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JDialog{
    private JPanel registerPanel;
    private JTextField tfName;
    private JTextField tfFirstName;
    private JTextField tfEmail;
    private JPasswordField tfPassword;
    private JPasswordField tfPasswordVerify;
    private JButton btnRegister;
    private JButton btnCancel;
    //Constructeur
    public RegisterForm(JFrame parent){
        super(parent);
        setTitle("Ajouter un nouveau compte");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(450, 500));
        //setModal(false);
        setLocationRelativeTo(parent);
        tfName.setText("defaut");
        tfFirstName.setText("defaut");
        tfEmail.setText("defaut@defaut.com");
        tfPassword.setText("defaut");
        btnRegister.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        //Close App
        btnCancel.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.out.println("Fermeture de la fenêtre");
            }
        });
        setVisible(true);
    }

    private void registerUser() {
        String nom = tfName.getText();
        String prenom = tfFirstName.getText();
        String email = tfEmail.getText();
        String password = String.valueOf(tfPassword.getPassword());
        String verify = String.valueOf(tfPasswordVerify.getPassword());
        //vérification si les champs sont bien remplis
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Veuillez remplir tous les champs du formulaire",
                    "Essaie encore",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        //vérification si le password correspond à la vérification
        if (!password.equals(verify)) {
            JOptionPane.showMessageDialog(this,
                    "Les mots de passe ne correpondent pas",
                    "Essaie encore",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        //création d'un objet
        User user = new User(nom, prenom, email, password);
        System.out.println(this);
        System.out.println(user.getNom()+","+user.getPrenom()+" a été ajouté");
    }
}
