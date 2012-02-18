package HarmonicAnalyser;

// Class for text output

public class TextOutput extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	public TextOutput(String output, String title) {
       initComponents(output, title);
   }

   private void initComponents(String output, String title) {

       Title = new javax.swing.JLabel();
       outputArea = new javax.swing.JScrollPane();
       outputText = new javax.swing.JTextArea();
       closeButton = new javax.swing.JButton();

       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

       Title.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
       Title.setText(title + " Text Output");

       outputText.setColumns(20);
       outputText.setRows(5);
       outputText.setText(output);
       outputArea.setViewportView(outputText);

       closeButton.setText("Close");
       closeButton.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               closeButtonActionPerformed(evt);
           }});

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                   .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                       .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                           .addComponent(Title)
                           )
                       .addGroup(layout.createSequentialGroup()
                           .addComponent(outputArea, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                           .addContainerGap()))
                   .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                       .addComponent(closeButton)
                       )))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
           .addGroup(layout.createSequentialGroup()
               .addGap(22, 22, 22)
               .addComponent(Title)
               .addGap(18, 18, 18)
               .addComponent(outputArea, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
               .addComponent(closeButton)
               .addContainerGap())
       );

       setSize(600,450);
   }// </editor-fold>

   public static void main(final String output, final String title) {
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new TextOutput(output, title).setVisible(true);
           }
       });
   }

   private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {
       //Dispose of the text output window
	   dispose();
   }
   
   // Variables declaration - do not modify
   private javax.swing.JLabel Title;
   private javax.swing.JButton closeButton;
   private javax.swing.JScrollPane outputArea;
   private javax.swing.JTextArea outputText;
   // End of variables declaration

}

