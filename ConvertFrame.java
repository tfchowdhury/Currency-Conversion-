//Program converts Currency.
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class ConvertFrame extends JFrame {

    JFrame frame = new JFrame();

    private final Color[] colorValue = {Color.GREEN};


    private JLabel label1;

    private JLabel lDollar, lPesos, lEuro;
    private JLabel lDollar1, lPesos1, lEuro1;

    private JPanel iconFromPanel;
    private JPanel fromJPanel;

    //icons
    private JPanel toJPanel;
    private JPanel iconToPanel;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField currencyJTextField1;
    private JTextField currencyJTextField2;

    //private ButtonGroup toButtonGroup;
    private ButtonGroup fromButtonGroup, toButtonGroup;

    private ButtonGroup fontButtonGroup;
    private ButtonGroup colorButtonGroup;


    // Currency JRadioButton
    private JRadioButton DollarToJRadioButton;
    private JRadioButton PesosToJRadioButton;
    private JRadioButton EurosToJRadioButton;
    private JRadioButton DollarFromJRadioButton;
    private JRadioButton PesosFromJRadioButton;
    private JRadioButton EurosFromJRadioButton;

    // constructor sets up GUI


    public ConvertFrame() {
        super("Currency Conversion");

        // setting menu

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');

        JMenuItem convertItem = new JMenuItem("Convert");
        convertItem.setMnemonic('C');
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.setMnemonic('E');
        fileMenu.add(convertItem);
        fileMenu.add(clearItem);
        MyEventHandler covertItemHandler = new MyEventHandler();
        convertItem.addActionListener(covertItemHandler);

        JMenuItem aboutItem = new JMenuItem("About");
        convertItem.setMnemonic('A');
        fileMenu.add(aboutItem);
        aboutHandler handler= new aboutHandler();
        aboutItem.addActionListener(handler);



        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('x');
        fileMenu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double result = JOptionPane.showConfirmDialog(frame,"You are going to close ?",
                        "Exit Confirmation : ", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    System.exit(0);
                else if (result == JOptionPane.NO_OPTION)
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });



        JMenuBar bar = new JMenuBar();
        bar.add(fileMenu);
        setJMenuBar(bar);



        // create ButtonGroup for from JRadioButtons
        DollarFromJRadioButton = new JRadioButton("US Dollar", true);
        PesosFromJRadioButton = new JRadioButton("Mexican Peso", false);
        EurosFromJRadioButton = new JRadioButton("Euros", false);
        fromButtonGroup = new ButtonGroup();
        fromButtonGroup.add(DollarFromJRadioButton);
        fromButtonGroup.add(PesosFromJRadioButton);
        fromButtonGroup.add(EurosFromJRadioButton);

        DollarToJRadioButton = new JRadioButton("US Dollar", false);
        PesosToJRadioButton = new JRadioButton("Mexican Peso", true);
        EurosToJRadioButton = new JRadioButton("Euros", false);
        toButtonGroup = new ButtonGroup();
        toButtonGroup.add(DollarToJRadioButton);
        toButtonGroup.add(PesosToJRadioButton);
        toButtonGroup.add(EurosToJRadioButton);

        // create from JPanel
        fromJPanel = new JPanel();
        fromJPanel.setLayout(new GridLayout(1, 3));
        fromJPanel.add(DollarFromJRadioButton);
        fromJPanel.add(PesosFromJRadioButton);
        fromJPanel.add(EurosFromJRadioButton);




        //icons panel and labels

        lPesos = new JLabel("");
        Image imgP = new ImageIcon (this.getClass().getResource("peso.jpg")).getImage();
        lPesos.setIcon(new ImageIcon(imgP));

        lDollar = new JLabel("");
        Image imgD = new ImageIcon (this.getClass().getResource("dollar.jpg")).getImage();
        lDollar.setIcon(new ImageIcon(imgD));

        lEuro = new JLabel("");
        Image imgE = new ImageIcon (this.getClass().getResource("euro.jpg")).getImage();
        lEuro.setIcon(new ImageIcon(imgE));


        lPesos1 = new JLabel("");
        Image imgP1 = new ImageIcon (this.getClass().getResource("peso.jpg")).getImage();
        lPesos1.setIcon(new ImageIcon(imgP1));

        lDollar1 = new JLabel("");
        Image imgD1 = new ImageIcon (this.getClass().getResource("dollar.jpg")).getImage();
        lDollar1.setIcon(new ImageIcon(imgD1));

        lEuro1 = new JLabel("");
        Image imgE1 = new ImageIcon (this.getClass().getResource("euro.jpg")).getImage();
        lEuro1.setIcon(new ImageIcon(imgE1));

        iconFromPanel = new JPanel();
        iconFromPanel.setLayout(new GridLayout(1,3));
        iconFromPanel.add(lDollar1);
        iconFromPanel.add(lPesos1);
        iconFromPanel.add(lEuro1);




        iconToPanel = new JPanel();
        iconToPanel.setLayout(new GridLayout(1,3));
        iconToPanel.add(lDollar);
        iconToPanel.add(lPesos);
        iconToPanel.add(lEuro);


        // create to JPanel
        toJPanel = new JPanel();
        toJPanel.setLayout(new GridLayout(1, 3));
        toJPanel.add(DollarToJRadioButton);
        toJPanel.add(PesosToJRadioButton);
        toJPanel.add(EurosToJRadioButton);

        // create labels
        label1 = new JLabel(" from:");
        label2 = new JLabel("to:");
        label3 = new JLabel("Enter Currency: ");
        label4 = new JLabel("Comparable Currency is: ");

        // create JTextField for getting temperature to be converted
        currencyJTextField1 = new JTextField(10);
        currencyJTextField1.setText("0");

        // event handling using inner class (Style 1)
        MyEventHandler handler1 = new MyEventHandler();// create object
        currencyJTextField1.addActionListener(handler);// register ActionEvent to text field

        // JTextField to display temperature after conversion
        currencyJTextField2 = new JTextField(10);
        currencyJTextField2.setEditable(false);

        // add components to GUI
        setLayout(new GridLayout(11, 1));
        add(label1);
        add(iconFromPanel);
        add(fromJPanel);
        add(label3);
        add(currencyJTextField1);
        add(label2);
        add(iconToPanel);
        add(toJPanel);
        add(label4);
        add(currencyJTextField2);

        /// ADDING CONVERT BUTTON
        JButton button = new JButton("CONVERT");
        button.setBounds(100, 200, 200, 50);
        add(button);
        JPanel panel = new JPanel();
        panel.add(button);
        this.getContentPane().add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        button.addActionListener(covertItemHandler);



        /// ADDING EXIT BUTTON
        JButton button1 = new JButton("EXIT");
        button1.setBounds(100, 200, 200, 50);
        add(button1);
        JPanel panel1 = new JPanel();
        panel.add(button1);
        this.getContentPane().add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double result = JOptionPane.showConfirmDialog(frame,
                        "Do you want to Exit ?", "Exit Confirmation : ",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION)
                    System.exit(0);
                else if (result == JOptionPane.NO_OPTION)
                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });



        // ADDING CLEAR BUTTON
        JButton button2 = new JButton("CLEAR");
        button2.setBounds(100, 200, 100, 50);
        add(button2);
        JPanel panel2 = new JPanel();
        panel.add(button2);
        this.getContentPane().add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        clear cl = new clear();
        button2.addActionListener(cl);



    }

    private class aboutHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            JOptionPane.showMessageDialog(ConvertFrame.this," This app convert currency i"
                            + "\n using menus and buttons."
                            +" \n Source: www.oanda.com/currency-converter/ (http://www.oanda.com/currency-converter/)",
                    "About", JOptionPane.INFORMATION_MESSAGE);
        }


    }

    private class clear implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            currencyJTextField1.setText("0");;
            currencyJTextField2.setText("");;

        }


    }

    // inner class
    private class MyEventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {


            double convertCurrency = 0, value;
            String result = ""; // for Pop up window

            // getting the value from the text field
            value  = Double.parseDouble(currencyJTextField1.getText());
            if(value<=0){

                JOptionPane.showMessageDialog(ConvertFrame.this,"value to convert");


            }
            else{

                // convert Dollar to Pesos
                if (DollarFromJRadioButton.isSelected() && PesosToJRadioButton.isSelected()) {
                    convertCurrency = (double) (value * 18);
                    currencyJTextField2.setText(String.valueOf(convertCurrency));
                    result = "Dollar to Pesos";
                }
                // convert Dollar to Euros
                else if (DollarFromJRadioButton.isSelected() && EurosToJRadioButton.isSelected()) {
                    convertCurrency = (double) (value * 0.91);
                    currencyJTextField2.setText(String.valueOf(convertCurrency));
                    result = "Dollar to Euros";
                }
                // convert euro to dollar
                else if (PesosFromJRadioButton.isSelected() && DollarToJRadioButton.isSelected()) {
                    convertCurrency = (double) (value/18);
                    currencyJTextField2.setText(String.valueOf(convertCurrency));
                    result = "Pesos to Dollar";
                }
                // convert pesos to euros
                else if (PesosFromJRadioButton.isSelected() && EurosToJRadioButton.isSelected()) {
                    convertCurrency = (double) (value*0.05);
                    currencyJTextField2.setText(String.valueOf(convertCurrency));
                    result = "Pesos to Euros";
                }
                // convert Euros to dollar
                else if (EurosFromJRadioButton.isSelected() && DollarToJRadioButton.isSelected()) {
                    convertCurrency = (double) (value / 0.91);
                    currencyJTextField2.setText(String.valueOf(convertCurrency));
                    result = "Euros to Dollar";
                }
                //convert Euros to pesos
                else if (EurosFromJRadioButton.isSelected() && PesosToJRadioButton.isSelected()) {
                    convertCurrency = (double) (value/0.05);
                    currencyJTextField2.setText(String.valueOf(convertCurrency));
                    result = "Euros to Pesos";
                }

                else {
                    currencyJTextField2.setText(String.valueOf(value));
                    result = "No conversion selected";
                }

                result += "\n" + value + "  to \t\t  " + convertCurrency + "";

                JOptionPane.showMessageDialog(ConvertFrame.this, result, "Converted Currency",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}