package HarmonicAnalyser;

/*
 Main Gui class, holds main method and launches the gui from which the rest of the programme operates.
 Designed in NetBeans IDE and copied to eclipse for use within the programme. 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;

public class MainGui extends javax.swing.JFrame implements ActionListener,
		PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	public static double progressCoEff;
	private boolean outSelected;
	private boolean analysisSelected;
	private static boolean fileSelected;
	protected boolean sampleRateSelected;

	public MainGui() {

		initComponents();
	}

	private void initComponents() {

		new javax.swing.ButtonGroup();
		fileSelect = new javax.swing.JButton();
		harmonicSelect = new javax.swing.JRadioButton();
		spectralSelect = new javax.swing.JRadioButton();
		textSelect = new javax.swing.JRadioButton();
		graphSelect = new javax.swing.JRadioButton();
		sampleRateField = new javax.swing.JTextField();
		sampleRateTitle = new javax.swing.JLabel();
		hzLabel = new javax.swing.JLabel();
		analysisTitle = new javax.swing.JLabel();
		dataTitle = new javax.swing.JLabel();
		doneButton = new javax.swing.JButton();
		fileSelectTitle = new javax.swing.JLabel();
		phaseSelect = new javax.swing.JRadioButton();
		jProgressBar1 = new javax.swing.JProgressBar();
		jSeparator1 = new javax.swing.JSeparator();
		jSeparator2 = new javax.swing.JSeparator();
		jSeparator3 = new javax.swing.JSeparator();
		jSeparator4 = new javax.swing.JSeparator();

		ButtonGroup analysisType = new ButtonGroup();
		analysisType.add(harmonicSelect);
		analysisType.add(spectralSelect);
		analysisType.add(phaseSelect);

		ButtonGroup outputFormat = new ButtonGroup();
		outputFormat.add(textSelect);
		outputFormat.add(graphSelect);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		fileSelect.setText("Select File");
		fileSelect
				.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
		fileSelect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					fileSelectActionPerformed(evt);
				} catch (FileNotFoundException e) {
					// Launch error window and stop the programme executing
					ErrorGui
							.main("File error.  Please choose a .txt file with sampled waveform data.");
					fileSelected = false;
				}
			}
		});

		harmonicSelect.setText("Harmonic");
		harmonicSelect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				harmonicSelectActionPerformed(evt);
			}
		});

		spectralSelect.setText("Spectral");
		spectralSelect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				spectralSelectActionPerformed(evt);
			}
		});

		textSelect.setText("Text");
		textSelect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				textSelectActionPerformed(evt);
			}
		});

		graphSelect.setText("Graph");
		graphSelect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				graphSelectActionPerformed(evt);
			}
		});

		sampleRateTitle.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
		sampleRateTitle
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		sampleRateTitle.setText("Enter The Sample Rate");

		hzLabel.setText("Hz");

		analysisTitle.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
		analysisTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		analysisTitle.setText("Select Type Of Analysis");

		dataTitle.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
		dataTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		dataTitle.setText("Data Format");

		doneButton.setText("Done");
		doneButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doneButtonActionPerformed(evt);
			}
		});

		jProgressBar1 = new JProgressBar(0, 100);
		jProgressBar1.setValue(0);
		jProgressBar1.setStringPainted(true);

		fileSelectTitle.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
		fileSelectTitle
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		fileSelectTitle.setText("Choose FIle To Analyse");
		fileSelectTitle
				.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

		phaseSelect.setText("Phase");
		phaseSelect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				phaseSelectActionPerformed(evt);
			}
		});

		sampleRateField.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent arg0) {
				Scanner input = new Scanner(sampleRateField.getText());

				// Try to write the sample rate to sampleRate variable, display
				// error message if
				try {
					Calc.sampleRate = input.nextInt();
					sampleRateSelected = true;
				} catch (NoSuchElementException ex) {
					ErrorGui
							.main("Invalid sample rate.  Please enter an integer value.");
					// Set sampleRateSelected to false so that the programme
					// will not execute
					sampleRateSelected = false;
				}

			}

			public void focusGained(FocusEvent e) {
			}

		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap(12, Short.MAX_VALUE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				138,
																				138,
																				138)
																		.addComponent(
																				sampleRateField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				60,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				hzLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				118,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																layout
																		.createSequentialGroup()
																		.addComponent(
																				textSelect)
																		.addGap(
																				76,
																				76,
																				76)
																		.addComponent(
																				graphSelect)
																		.addGap(
																				102,
																				102,
																				102))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				21,
																				21,
																				21)
																		.addComponent(
																				harmonicSelect)
																		.addGap(
																				54,
																				54,
																				54)
																		.addComponent(
																				spectralSelect)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				44,
																				Short.MAX_VALUE)
																		.addComponent(
																				phaseSelect)
																		.addGap(
																				35,
																				35,
																				35)))
										.addGap(0, 0, 0))
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jSeparator1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												368, Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jSeparator2,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												368, Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jSeparator3,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												368, Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jSeparator4,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												368, Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(159, 159,
										159).addComponent(fileSelect,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addGap(156, 156, 156))
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												fileSelectTitle,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												368, Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												sampleRateTitle,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												368,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												analysisTitle,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												368,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												dataTitle,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												368, Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jProgressBar1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												368, Short.MAX_VALUE)
										.addContainerGap()).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addContainerGap(
										179, Short.MAX_VALUE).addComponent(
										doneButton).addGap(167, 167, 167)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGap(18, 18, 18)
										.addComponent(fileSelectTitle)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												fileSelect,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												27, Short.MAX_VALUE)
										.addGap(9, 9, 9)
										.addComponent(
												jSeparator1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												10,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(15, 15, 15)
										.addComponent(sampleRateTitle)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																sampleRateField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(hzLabel))
										.addGap(14, 14, 14)
										.addComponent(
												jSeparator2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												10,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(3, 3, 3)
										.addComponent(analysisTitle)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																spectralSelect)
														.addComponent(
																harmonicSelect)
														.addComponent(
																phaseSelect))
										.addGap(18, 18, 18)
										.addComponent(
												jSeparator3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												10,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(dataTitle)
										.addGap(12, 12, 12)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																graphSelect)
														.addComponent(
																textSelect))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jSeparator4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												10,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(doneButton)
										.addGap(31, 31, 31)
										.addComponent(
												jProgressBar1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		pack();
	}// </editor-fold>

	private void fileSelectActionPerformed(java.awt.event.ActionEvent evt)
			throws FileNotFoundException {
		// Get file and set data array
		JFileChooser dialog = new JFileChooser();

		// Once a file has been selected, prepare for an save as array
		if (dialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			InputFile(dialog.getSelectedFile());
		}
	}

	private void spectralSelectActionPerformed(java.awt.event.ActionEvent evt) {
		// Set spectral selected, false for other options. Allow programme to
		// execute
		Calc.spectral = true;
		Calc.phase = false;
		Calc.harmonic = false;
		analysisSelected = true;
	}

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// All code deciding how the programme will execute:

		// Set progress bar to 0%
		jProgressBar1.setValue(0);

		// Test to see if all fields have been filled out, if not, launch error
		// window
		if (outSelected == false) {
			ErrorGui
					.main("No data format selected.  Please choose a data format.");
		} else if (analysisSelected == false) {
			ErrorGui
					.main("No analysis selected.  Please choose a analysis to perform.");
		} else if (fileSelected == false) {
			ErrorGui
					.main("No file selected.  Please choose a .txt file with sampled waveform data.");
		} else if (sampleRateSelected == false) {
			ErrorGui
			.main("Invalid sample rate.  Please enter an integer value.");
}
		// Otherwise, execute programme
		else {
			// Select type of analysis and data format, launch correct option
			/*
			 * Once the correct class has been chosen, it is constructed as an
			 * object. Execute the programme in different thread from GUI
			 * Listens to the progress of the task and updates progress bar
			 */

			if (Calc.harmonic == true) {
				// Harmonic analysis selected
				if (Calc.text == true) {
					// HarmonicGraph analsyis with text output selected.
					HarmonicText text = new HarmonicText();
					text.worker.execute();
					text.worker.addPropertyChangeListener(this);
				} else {
					// HarmonicGraph analysis with graph output selected.
					HarmonicGraph graph = new HarmonicGraph();
					graph.worker.execute();
					graph.worker.addPropertyChangeListener(this);
				}
			}
			if (Calc.spectral == true) {
				if (Calc.text == true) {
					// Spectrum analsyis with text output selected.
					SpectralText text = new SpectralText();
					text.worker.execute();
					text.worker.addPropertyChangeListener(this);
				} else {
					// Spectrum analsyis with graph output selected.
					SpectralGraph graph = new SpectralGraph();
					graph.worker.execute();
					graph.worker.addPropertyChangeListener(this);

				}
			}
			if (Calc.phase == true) {
				if (Calc.text == true) {
					// Phase analsyis with graph output selected.
					PhaseText text = new PhaseText();
					text.worker.execute();
					text.worker.addPropertyChangeListener(this);
				} else {
					// Phase analsyis with text output selected.
					PhaseGraph graph = new PhaseGraph();
					graph.worker.execute();
					graph.worker.addPropertyChangeListener(this);
				}
			}
		}

	}

	private void harmonicSelectActionPerformed(java.awt.event.ActionEvent evt) {
		// Set harmonic selected, false for other options. Allow programme to
		// execute
		Calc.harmonic = true;
		Calc.spectral = false;
		Calc.phase = false;
		analysisSelected = true;
	}

	private void textSelectActionPerformed(java.awt.event.ActionEvent evt) {
		// Set text selected, false for other options. Allow programme to
		// execute
		Calc.text = true;
		outSelected = true;
	}

	private void graphSelectActionPerformed(java.awt.event.ActionEvent evt) {
		// Set graph selected, false for other options. Allow programme to
		// execute
		Calc.text = false;
		outSelected = true;

	}

	private void phaseSelectActionPerformed(java.awt.event.ActionEvent evt) {
		// Set phase selected, false for other options. Allow programme to
		// execute
		Calc.phase = true;
		Calc.spectral = false;
		Calc.harmonic = false;
		analysisSelected = true;
	}

	// Main method, programme launches from here
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainGui().setVisible(true);
			}
		});
	}

	// Method for converting input file to workable array
	public static void InputFile(final File inputFile) {

		// Create ArrayList object to enter data into
		ArrayList<Double> array = new ArrayList<Double>();

		// Robustness block:
		// Check if file is .txt, call error box if not throw error window
		String filename = inputFile.getName();
		String ext = filename.substring(filename.lastIndexOf('.') + 1, filename
				.length());

		if (ext.endsWith("txt") == false) {
			ErrorGui
					.main("Input file error.  Please choose a .txt file with sampled waveform data.");
			fileSelected = false;
		} else {
			// Load file into scanner object and add to ArrayList
			try {
				Scanner fileInputScan = new Scanner(inputFile);

				while (fileInputScan.hasNext()) {
					array.add(fileInputScan.nextDouble());
				}

				// Close Scanner object
				fileInputScan.close();
			}

			// Catch exceptions and open error dialog
			catch (IOException ex) {
				ErrorGui
						.main("Input file error.  Please choose a .txt file with sampled waveform data.");
			} catch (InputMismatchException ex) {
				ErrorGui
						.main("Input file error.  Please choose a .txt file with sampled waveform data.");
			}

			// Create double array and fill with ArrayList
			double outArray[] = new double[array.size()];

			for (int i = 0; i < array.size(); i++) {
				outArray[i] = array.get(i).doubleValue();
			}

			// Set progress co effecient to calculate progress correctly
			progressCoEff = (outArray.length / 2) / 100;

			// Write data to array field ready for analysis
			Calc.data = outArray;

			// Let the programme iniatilize
			fileSelected = true;
		}
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if ("progress" == evt.getPropertyName()) {
			int progress = (Integer) evt.getNewValue();
			jProgressBar1.setValue(progress);
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JLabel analysisTitle;
	private javax.swing.JLabel dataTitle;
	private javax.swing.JButton doneButton;
	private javax.swing.JButton fileSelect;
	private javax.swing.JLabel fileSelectTitle;
	private javax.swing.JRadioButton graphSelect;
	private javax.swing.JRadioButton harmonicSelect;
	private javax.swing.JLabel hzLabel;
	static javax.swing.JProgressBar jProgressBar1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private javax.swing.JRadioButton phaseSelect;
	private static javax.swing.JTextField sampleRateField;
	public static int progress;
	private javax.swing.JLabel sampleRateTitle;
	private javax.swing.JRadioButton spectralSelect;
	private javax.swing.JRadioButton textSelect;

	// End of variables declaration

	public void actionPerformed(ActionEvent arg0) {

	}
}