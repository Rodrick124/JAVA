package com.company;

        import javax.swing.*;
        import javax.swing.border.Border;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class FormPanel  extends JPanel {

    private JLabel NameLabel;
    private JLabel SurnameLabel;
    private JLabel MatriculesLabel;
    private JTextField NameField;
    private JTextField SurnameField;
    private JTextField MatriculesField;
    private JButton Submit;
    private JButton Cancel;
    private FormListener formListener;
    private JList rankList;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        NameLabel = new JLabel("Name: ");
        SurnameLabel = new JLabel("Surname: ");
        MatriculesLabel = new JLabel("Matricule: ");
        NameField = new JTextField(10);
        SurnameField = new JTextField(10);
        MatriculesField = new JTextField(10);
        rankList = new JList();

        DefaultListModel rankmodole = new DefaultListModel();
        rankmodole.addElement("level 1");
        rankmodole.addElement("level 2");
        rankmodole.addElement("Licences");
        rankmodole.addElement("Master");
        rankmodole.addElement("Master 2");
        rankList.setModel(rankmodole);

        rankList.setPreferredSize(new Dimension(110, 100));
        rankList.setBorder(BorderFactory.createEtchedBorder());
        rankList.setSelectedIndex(0);

        Submit = new JButton("SUBMIT");
        Cancel = new JButton("CANCEL");

        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = NameField.getText();
                String surname = SurnameField.getText();
                String matricule = MatriculesField.getText();


            }
        });

        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = NameField.getText();
                String surname = SurnameField.getText();
                String matricules = MatriculesField.getText();
                String rankCat = (String)rankList.getSelectedValue();

                FormEvent ev = new FormEvent(this, name, surname, matricules);

                if (formListener != null){
                    formListener.formEventOccurred(ev);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add Student");
        Border outerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        ///////FIRST ROW///////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);

        add(NameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(NameField, gc);
        //////SECOND ROW///////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridy = 1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(SurnameLabel, gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(SurnameField, gc);

        ///////forth ROW//////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridy = 2;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(MatriculesLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(MatriculesField, gc);
        ///////THIRD ROW//////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridy = 4;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 5);
        add(rankList, gc);
        ///////5 ROW////////
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridy = 5;
        gc.gridx = 0;
        add(Submit, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        add(Cancel, gc);
    }
    public void setFormListener (FormListener listener) {
        this.formListener = listener;
    }
}
