/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moodcube.gui;

import moodcube.nlp.sentimentanalysis.PolarityCalculator;

/**
 *
 * @author omazhary
 */
public class FormSAInput extends javax.swing.JFrame {

    private PolarityCalculator calculator;
    
    
    /**
     * Creates new form FormSAInput
     */
    public FormSAInput() {
        initComponents();
        calculator = new PolarityCalculator();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt_input = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_happy = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_sad = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_angry = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_romantic = new javax.swing.JLabel();
        lbl_result = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_analyze = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sentiment Analysis Simulator");
        setPreferredSize(new java.awt.Dimension(800, 400));
        setResizable(false);

        jScrollPane1.setName("txt_input"); // NOI18N

        txt_input.setColumns(20);
        txt_input.setLineWrap(true);
        txt_input.setRows(5);
        txt_input.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txt_input);

        jLabel1.setText("Insert Text Here:");

        jLabel2.setText("Happy:");

        lbl_happy.setText("0%");
        lbl_happy.setName("lbl_happy"); // NOI18N

        jLabel4.setText("Sad:");

        lbl_sad.setText("0%");
        lbl_sad.setName("lbl_sad"); // NOI18N

        jLabel6.setText("Angry:");

        lbl_angry.setText("0%");
        lbl_angry.setName("lbl_angry"); // NOI18N

        jLabel8.setText("Romantic:");

        lbl_romantic.setText("0%");
        lbl_romantic.setName("lbl_romantic"); // NOI18N

        lbl_result.setText("Result description.");
        lbl_result.setName("lbl_description"); // NOI18N

        jLabel11.setText("Polarity");

        jLabel12.setText("Value");

        btn_analyze.setText("Analyze");
        btn_analyze.setName("btn_analyze"); // NOI18N
        btn_analyze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_analyzeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_analyze)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_result)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(lbl_romantic)
                            .addComponent(lbl_angry)
                            .addComponent(lbl_sad)
                            .addComponent(lbl_happy))))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbl_happy))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbl_sad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbl_angry))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lbl_romantic))
                        .addGap(89, 89, 89)
                        .addComponent(lbl_result))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_analyze)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_analyzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_analyzeActionPerformed
        // TODO add your handling code here:
        String text = this.txt_input.getText();
        double[] result = this.calculator.getPolarityStats(text);
        this.lbl_angry.setText(String.valueOf(Math.ceil(result[0] * 100)) + "%");
        this.lbl_happy.setText(String.valueOf(Math.ceil(result[1] * 100)) + "%");
        this.lbl_sad.setText(String.valueOf(Math.ceil(result[2] * 100)) + "%");
        this.lbl_romantic.setText(String.valueOf(Math.ceil(result[3] * 100)) + "%");
        
        // Determine the dominant sentiment:
        int index = -1;
        double max = 0;
        for(int i = 0; i < result.length; i++){
            if(result[i] > max){
                max = result[i];
                index = i;
            }
        }
        
        String output = "The dominant sentiment is ";
        switch(index){
            case 0:
                output += "anger.";
                break;
            case 1:
                output += "happiness.";
                break;
            case 2:
                output += "sorrow.";
                break;
            case 3:
                output += "romance.";
                break;
            default:
                output = "An error occurred. Please try again.";
                break;
        }
        
        this.lbl_result.setText(output);
    }//GEN-LAST:event_btn_analyzeActionPerformed

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
            java.util.logging.Logger.getLogger(FormSAInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSAInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSAInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSAInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSAInput().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_analyze;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_angry;
    private javax.swing.JLabel lbl_happy;
    private javax.swing.JLabel lbl_result;
    private javax.swing.JLabel lbl_romantic;
    private javax.swing.JLabel lbl_sad;
    private javax.swing.JTextArea txt_input;
    // End of variables declaration//GEN-END:variables
}
