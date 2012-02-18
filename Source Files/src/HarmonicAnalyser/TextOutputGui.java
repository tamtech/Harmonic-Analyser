package HarmonicAnalyser;

@SuppressWarnings("serial")
public class TextOutputGui extends javax.swing.JPanel {

	/**
	 * Creates new form TextOutput
	 * 
	 * @return
	 */
	public void main(String[] args) {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		textOutput = new javax.swing.JTextArea();
		closeButton = new javax.swing.JButton();
		title = new javax.swing.JLabel();

		textOutput.setColumns(20);
		textOutput.setRows(5);
		jScrollPane1.setViewportView(textOutput);

		closeButton.setText("Close");
		closeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				closeButtonActionPerformed(evt);
			}
		});

		title.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
		title.setText("\"string\" of Selected File");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				526,
																				Short.MAX_VALUE)
																		.addContainerGap())
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																layout
																		.createSequentialGroup()
																		.addComponent(
																				closeButton)
																		.addGap(
																				245,
																				245,
																				245))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																layout
																		.createSequentialGroup()
																		.addComponent(
																				title)
																		.addGap(
																				144,
																				144,
																				144)))));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(title)
										.addGap(18, 18, 18)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												262,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												31, Short.MAX_VALUE)
										.addComponent(closeButton)
										.addContainerGap()));
	}// </editor-fold>

	private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	// Variables declaration - do not modify
	private javax.swing.JButton closeButton;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea textOutput;
	private javax.swing.JLabel title;
	// End of variables declaration

}