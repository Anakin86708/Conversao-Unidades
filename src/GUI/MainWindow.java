/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Codes.Controller;
import Codes.Language;
import Converts.AbstractConverter;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ResourceBundle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author enzoj
 */
public class MainWindow extends javax.swing.JFrame {
    
    private Controller controller;
    private AbstractConverter inputConverter;
    private AbstractConverter expectedConverter;
    private String categoryString;
    private ResourceBundle languageBundle;

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        this.setTitle("Conversor");
        this.languageBundle = Language.getResourceBundle();
        
        String localDir = System.getProperty("user.dir");
        String pathToFolderString = localDir + "/src/Converts";
        this.controller = new Controller(this, pathToFolderString);

        // Cria o modelo com as classes carregadas
        controller.updateAllComboBox();

    }
    
    public AbstractConverter getInputConverter() {
        setInputConverter();
        return this.inputConverter;
    }
    
    private void setInputConverter() {
        Object obj = comboBoxInput.getSelectedItem();
        AbstractConverter interfaceConverter = (AbstractConverter) obj;
        this.inputConverter = interfaceConverter;
    }
    
    private AbstractConverter getExpectedConverter() {
        setExpectedConverter();
        return this.expectedConverter;
    }
    
    private void setExpectedConverter() {
        Object obj = comboBoxExpected.getSelectedItem();
        AbstractConverter interfaceConverter = (AbstractConverter) obj;
        this.expectedConverter = interfaceConverter;
    }
    
    public JComboBox<String> getComboBoxInput() {
        return comboBoxInput;
    }
    
    public JComboBox<String> getComboBoxExpected() {
        return comboBoxExpected;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContainer = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        labelHeader = new javax.swing.JLabel();
        panelTextConvert = new javax.swing.JPanel();
        labelConvert = new javax.swing.JLabel();
        panelTextTo = new javax.swing.JPanel();
        labelTo = new javax.swing.JLabel();
        panelInsertNumber = new javax.swing.JPanel();
        textFieldInsertNumber = new javax.swing.JTextField();
        panelConvertedNumber = new javax.swing.JPanel();
        textFieldConvertedNumber = new javax.swing.JTextField();
        panelUserOption = new javax.swing.JPanel();
        comboBoxInput = new javax.swing.JComboBox<>();
        panelUserOption2 = new javax.swing.JPanel();
        comboBoxExpected = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        panelFooter = new javax.swing.JPanel();
        labelCounterClasses = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        menuItemSettings = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuItemExit = new javax.swing.JMenuItem();
        mEdit = new javax.swing.JMenu();
        menuItemCopy = new javax.swing.JMenuItem();
        mHelp = new javax.swing.JMenu();
        menuItemHelp = new javax.swing.JMenuItem();
        menuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        panelContainer.setBackground(new java.awt.Color(153, 153, 153));

        panelHeader.setBackground(new java.awt.Color(51, 51, 51));

        labelHeader.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelHeader.setForeground(new java.awt.Color(255, 255, 255));
        labelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHeader.setText("Unit: distances");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(labelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelTextConvert.setBackground(new java.awt.Color(102, 102, 102));
        panelTextConvert.setForeground(new java.awt.Color(255, 255, 255));

        labelConvert.setBackground(new java.awt.Color(153, 153, 153));
        labelConvert.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelConvert.setForeground(new java.awt.Color(255, 255, 255));
        labelConvert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelConvert.setText(Language.getResourceBundle().getString("Convert")); // NOI18N

        javax.swing.GroupLayout panelTextConvertLayout = new javax.swing.GroupLayout(panelTextConvert);
        panelTextConvert.setLayout(panelTextConvertLayout);
        panelTextConvertLayout.setHorizontalGroup(
            panelTextConvertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelConvert, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
        );
        panelTextConvertLayout.setVerticalGroup(
            panelTextConvertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelConvert, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        panelTextTo.setBackground(new java.awt.Color(102, 102, 102));

        labelTo.setBackground(new java.awt.Color(153, 153, 153));
        labelTo.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        labelTo.setForeground(new java.awt.Color(255, 255, 255));
        labelTo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTo.setText(Language.getResourceBundle().getString("To")); // NOI18N

        javax.swing.GroupLayout panelTextToLayout = new javax.swing.GroupLayout(panelTextTo);
        panelTextTo.setLayout(panelTextToLayout);
        panelTextToLayout.setHorizontalGroup(
            panelTextToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTextToLayout.setVerticalGroup(
            panelTextToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTo, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        panelInsertNumber.setBackground(new java.awt.Color(0, 0, 255));

        textFieldInsertNumber.setBackground(new java.awt.Color(204, 204, 204));
        textFieldInsertNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textFieldInsertNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldInsertNumber.setText("0.0");
        textFieldInsertNumber.setToolTipText("Insert the number");
        textFieldInsertNumber.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                inputUpdate(evt);
            }
        });

        javax.swing.GroupLayout panelInsertNumberLayout = new javax.swing.GroupLayout(panelInsertNumber);
        panelInsertNumber.setLayout(panelInsertNumberLayout);
        panelInsertNumberLayout.setHorizontalGroup(
            panelInsertNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textFieldInsertNumber, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelInsertNumberLayout.setVerticalGroup(
            panelInsertNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textFieldInsertNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        panelConvertedNumber.setBackground(new java.awt.Color(51, 255, 0));

        textFieldConvertedNumber.setEditable(false);
        textFieldConvertedNumber.setBackground(new java.awt.Color(204, 204, 204));
        textFieldConvertedNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textFieldConvertedNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldConvertedNumber.setText("0.0");
        textFieldConvertedNumber.setToolTipText("Converted Number");

        javax.swing.GroupLayout panelConvertedNumberLayout = new javax.swing.GroupLayout(panelConvertedNumber);
        panelConvertedNumber.setLayout(panelConvertedNumberLayout);
        panelConvertedNumberLayout.setHorizontalGroup(
            panelConvertedNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textFieldConvertedNumber, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelConvertedNumberLayout.setVerticalGroup(
            panelConvertedNumberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textFieldConvertedNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        comboBoxInput.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBoxInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mili", "Centi", "Deci", "Base", "Deca", "Hecto", "Kilo" }));
        comboBoxInput.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxInputItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelUserOptionLayout = new javax.swing.GroupLayout(panelUserOption);
        panelUserOption.setLayout(panelUserOptionLayout);
        panelUserOptionLayout.setHorizontalGroup(
            panelUserOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboBoxInput, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelUserOptionLayout.setVerticalGroup(
            panelUserOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboBoxInput, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );

        comboBoxExpected.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBoxExpected.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mili", "Centi", "Deci", "Base", "Deca", "Hecto", "Kilo" }));
        comboBoxExpected.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxExpectedItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelUserOption2Layout = new javax.swing.GroupLayout(panelUserOption2);
        panelUserOption2.setLayout(panelUserOption2Layout);
        panelUserOption2Layout.setHorizontalGroup(
            panelUserOption2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboBoxExpected, 0, 255, Short.MAX_VALUE)
        );
        panelUserOption2Layout.setVerticalGroup(
            panelUserOption2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboBoxExpected, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
        );

        panelFooter.setBackground(new java.awt.Color(153, 153, 153));

        labelCounterClasses.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCounterClasses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCounterClasses.setText("Gaveta Produções");

        javax.swing.GroupLayout panelFooterLayout = new javax.swing.GroupLayout(panelFooter);
        panelFooter.setLayout(panelFooterLayout);
        panelFooterLayout.setHorizontalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCounterClasses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelFooterLayout.setVerticalGroup(
            panelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelCounterClasses, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout panelContainerLayout = new javax.swing.GroupLayout(panelContainer);
        panelContainer.setLayout(panelContainerLayout);
        panelContainerLayout.setHorizontalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(panelFooter, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2)
                .addGroup(panelContainerLayout.createSequentialGroup()
                    .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(panelUserOption, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelTextConvert, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelInsertNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelTextTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelConvertedNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelUserOption2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelContainerLayout.setVerticalGroup(
            panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContainerLayout.createSequentialGroup()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTextTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTextConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInsertNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelConvertedNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelUserOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelUserOption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mFile.setText(Language.getResourceBundle().getString("File")); // NOI18N

        menuItemSettings.setText(Language.getResourceBundle().getString("Settings")); // NOI18N
        menuItemSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSettingsActionPerformed(evt);
            }
        });
        mFile.add(menuItemSettings);
        mFile.add(jSeparator1);

        menuItemExit.setText(Language.getResourceBundle().getString("Exit")); // NOI18N
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        mFile.add(menuItemExit);

        menuBar.add(mFile);

        mEdit.setText(Language.getResourceBundle().getString("Edit")); // NOI18N

        menuItemCopy.setText(Language.getResourceBundle().getString("Copy")); // NOI18N
        menuItemCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCopyActionPerformed(evt);
            }
        });
        mEdit.add(menuItemCopy);

        menuBar.add(mEdit);

        mHelp.setText(Language.getResourceBundle().getString("Help")); // NOI18N

        menuItemHelp.setText(Language.getResourceBundle().getString("Help")); // NOI18N
        menuItemHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemHelpActionPerformed(evt);
            }
        });
        mHelp.add(menuItemHelp);

        menuItemAbout.setText(Language.getResourceBundle().getString("About")); // NOI18N
        menuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAboutActionPerformed(evt);
            }
        });
        mHelp.add(menuItemAbout);

        menuBar.add(mHelp);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAboutActionPerformed
        DialogMessages dialogMessages = new DialogMessages(this, true, "About");
        dialogMessages.setLocationRelativeTo(this);
        dialogMessages.setVisible(true);
    }//GEN-LAST:event_menuItemAboutActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuItemExitActionPerformed
    
    private void changeFolderDynamicClasses() {
        String currentDirectory = System.getProperty("user.dir");
        JFileChooser fileChooser = new JFileChooser(currentDirectory);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);        
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.controller.setPathToFolderString(fileChooser.getSelectedFile().getAbsolutePath());
            this.controller.updateAllComboBox();
            this.controller.restartWatchThread();
        }
    }
    /**
     * Updates the input.
     */
    public void updateInput()  {
        //Change only when the category is different
        String currentCategory = getInputConverter().getCategory();
        if (!currentCategory.equals(this.categoryString)) {
            controller.updateComboBoxExpectedModel();
        }
        convertAndShow();
    }

    private void menuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHelpActionPerformed
        DialogMessages dialogMessages  = new DialogMessages(this, true, "Help");
        dialogMessages.setLocationRelativeTo(this);
        dialogMessages.setVisible(true);
    }//GEN-LAST:event_menuItemHelpActionPerformed

    private void menuItemCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCopyActionPerformed
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = new StringSelection(textFieldConvertedNumber.getText());
        clipboard.setContents(transferable, null);
    }//GEN-LAST:event_menuItemCopyActionPerformed

    private void menuItemSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSettingsActionPerformed
        changeFolderDynamicClasses();
    }//GEN-LAST:event_menuItemSettingsActionPerformed

    private void comboBoxExpectedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxExpectedItemStateChanged
        convertAndShow();
    }//GEN-LAST:event_comboBoxExpectedItemStateChanged

    /**
     * Changes the output ComboBox model according to the category of the 
     * selected unit
     *
     * @param evt 
     */
    private void comboBoxInputItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxInputItemStateChanged
        updateInput();
    }//GEN-LAST:event_comboBoxInputItemStateChanged

    private void inputUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_inputUpdate
        convertAndShow();
    }//GEN-LAST:event_inputUpdate
    
    private void convertAndShow() throws HeadlessException {
        String inputString = this.textFieldInsertNumber.getText();
        try {
            double input = Double.valueOf(inputString);
            setConverted(controller.convert(input, this.getInputConverter(), this.getExpectedConverter()));
        } catch (NumberFormatException e) {
            if (!inputString.isEmpty()) {
                String message = "Invalid value!\n" + e.getMessage();
                String titleString = "Error";
                JOptionPane.showMessageDialog(this, message, titleString, JOptionPane.WARNING_MESSAGE);
            } else {
                // Valor é vazio
                setConverted(0.0);
            }
        }
    }
    
    private void setConverted(Double value) {
        double doubleValue = value;
        
        // Para 10^7
        // Transformação para int do value e consegue a quantidade de numeros antes do "."
        int intValue = (int)doubleValue;
        int tamanhoValue = String.valueOf(intValue).length();
        
        // Para 10^-7
        // Transformação para String do value e consegue a quantidade de numeros depois do "."
        String StringNumPequeno = String.valueOf(value);
        int indexPequeno = StringNumPequeno.indexOf(".");
        int tamanhoDecimal = StringNumPequeno.substring(indexPequeno + 1).length();
        
        // Arredondamento do value
        long NumeroArredondado = Math.round(value);
        
        // Verifica se o value é 10^7 ou 10^-7 
        if(tamanhoValue > 7 || tamanhoDecimal > 7) {
            DecimalFormat df = new DecimalFormat("0.#E0");
            this.textFieldConvertedNumber.setText(df.format(value));
        }
        else {
            //this.textFieldConvertedNumber.setText(Long.toString(NumeroArredondado));
            this.textFieldConvertedNumber.setText(Double.toString(doubleValue));
        }
    }
    

    private int countDecimalPlaces(Double value){
        DecimalFormatSymbols decimalSeparator = new DecimalFormatSymbols();
        
        String valueString = Double.toString(Math.abs(value));
//        int indexDotPlace = valueString.indexOf(decimalSeparator.getDecimalSeparator());
        int indexDotPlace = valueString.indexOf('.');
        int numberOfDecimals = valueString.length() - indexDotPlace - 1;
        
        return numberOfDecimals;
    }
    

    private void changeComboBoxExpectedModel() {
        AbstractConverter interfaceConverter = getInputConverter();
        String actualCategory = interfaceConverter.getCategory();
        
        DefaultComboBoxModel outputModel = this.controller.generateComboBoxModel(actualCategory);
        comboBoxExpected.setModel(outputModel);
        
        changeUnit(actualCategory);
    }

    public void changeUnit(String unit) {
        this.categoryString = unit;
        labelHeader.setText(this.languageBundle.getString("Unit") + unit);
    }
    
    public void changeClassesCounter() {
        int count = this.comboBoxInput.getItemCount();
        this.labelCounterClasses.setText(this.languageBundle.getString("Number_classes") + count);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxExpected;
    private javax.swing.JComboBox<String> comboBoxInput;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelConvert;
    private javax.swing.JLabel labelCounterClasses;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JLabel labelTo;
    private javax.swing.JMenu mEdit;
    private javax.swing.JMenu mFile;
    private javax.swing.JMenu mHelp;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemAbout;
    private javax.swing.JMenuItem menuItemCopy;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemHelp;
    private javax.swing.JMenuItem menuItemSettings;
    private javax.swing.JPanel panelContainer;
    private javax.swing.JPanel panelConvertedNumber;
    private javax.swing.JPanel panelFooter;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelInsertNumber;
    private javax.swing.JPanel panelTextConvert;
    private javax.swing.JPanel panelTextTo;
    private javax.swing.JPanel panelUserOption;
    private javax.swing.JPanel panelUserOption2;
    private javax.swing.JTextField textFieldConvertedNumber;
    private javax.swing.JTextField textFieldInsertNumber;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JLabel getLabelConvert() {
        return labelConvert;
    }

    public javax.swing.JLabel getLabelHeader() {
        return labelHeader;
    }

    public javax.swing.JLabel getLabelTo() {
        return labelTo;
    }

    public javax.swing.JMenu getmEdit() {
        return mEdit;
    }

    public javax.swing.JMenu getmFile() {
        return mFile;
    }

    public javax.swing.JMenu getmHelp() {
        return mHelp;
    }

    public javax.swing.JMenuItem getMenuItemAbout() {
        return menuItemAbout;
    }

    public javax.swing.JMenuItem getMenuItemCopy() {
        return menuItemCopy;
    }

    public javax.swing.JMenuItem getMenuItemExit() {
        return menuItemExit;
    }

    public javax.swing.JMenuItem getMenuItemHelp() {
        return menuItemHelp;
    }
}
