package HarmonicAnalyser;

// Launches error window with an error string

public class ErrorGui extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	public ErrorGui(String errorString) {
		initComponents(errorString);
	}

	private void initComponents(String errorString) {

		closeButton = new javax.swing.JButton();
		titleLabel = new javax.swing.JLabel();
		errorLabel = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		closeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		closeButton.setText("Close");
		closeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				closeButtonActionPerformed(evt);
			}
		});

		titleLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
		titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		titleLabel.setText("Error:");

		errorLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
		errorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		errorLabel.setText(errorString);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.CENTER)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.CENTER)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				titleLabel,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				334,
																				Short.MAX_VALUE))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				errorLabel,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				334,
																				Short.MAX_VALUE))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				closeButton)))
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.CENTER)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(24, 24, 24)
										.addComponent(titleLabel)
										.addGap(24, 24, 24)
										.addComponent(
												errorLabel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												64,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												30, Short.MAX_VALUE)
										.addComponent(closeButton)
										.addContainerGap()));

		setSize(500, 220);
	}// </editor-fold>

	private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// Dispose of window
		dispose();
	}

	public static void main(final String errorString) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ErrorGui(errorString).setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton closeButton;
	private javax.swing.JLabel errorLabel;
	private javax.swing.JLabel titleLabel;
	// End of variables declaration

}
