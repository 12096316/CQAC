import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InstallmentsForm extends JFrame {
	static InstallmentsForm frame;
	private JPanel contentPane;
	private JTextField textFieldHP;
	private JTextField textFieldZones;
	private JTextField textFieldOutlets;
	private JTextField textFieldAddress;
	private JTextField textFieldTechnician;
        private JTextField textFieldStart;
	private JTextField textFieldEnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new InstallmentsForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InstallmentsForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddInstallment = new JLabel("Add Installment");
		lblAddInstallment.setForeground(Color.GRAY);
		lblAddInstallment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblHP = new JLabel("Horse Power:");
		
		JLabel lblZones = new JLabel("Zones No.:");
		
		JLabel lblOutlets = new JLabel("Outlets No.:");
		
		JLabel lblAddress = new JLabel("Address:");
		
		JLabel lblTechnician = new JLabel("Technician:");
                
                JLabel lblStart = new JLabel("Start Date:");
		
		JLabel lblEnd = new JLabel("End Date:");
		
		textFieldHP = new JTextField();
		textFieldHP.setColumns(10);
		
		textFieldZones = new JTextField();
		textFieldZones.setColumns(10);
		
		textFieldOutlets = new JTextField();
		textFieldOutlets.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		
		textFieldTechnician = new JTextField();
		textFieldTechnician.setColumns(10);
                
                textFieldStart = new JTextField();
		textFieldStart.setColumns(10);
		
		textFieldEnd = new JTextField();
		textFieldEnd.setColumns(10);
		
		JButton btnAddInstallment = new JButton("Add Installment");
		btnAddInstallment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String hp=textFieldHP.getText();
			String zones=textFieldZones.getText();
			String outlets=textFieldOutlets.getText();
			String address=textFieldAddress.getText();
			String technician=textFieldTechnician.getText();
                        String start=textFieldStart.getText();
                        String end=textFieldEnd.getText();
			int i=InstallmentDao.save(technician, address, hp, zones, outlets, start, end);
			if(i>0){
				JOptionPane.showMessageDialog(InstallmentsForm.this,"Installments added successfully!");
				Installments.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(InstallmentsForm.this,"Sorry, unable to save!");
			}
			}
		});
		
		JButton btnBack = new JButton("Back");
                btnBack.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //
                        Installments.main(new String[]{});
                        frame.dispose();
                    }
                });
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(150)
							.addComponent(lblAddInstallment))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblZones)
								.addComponent(lblHP)
								.addComponent(lblOutlets)
								.addComponent(lblAddress)
								.addComponent(lblTechnician)
                                                                .addComponent(lblStart)
                                                                .addComponent(lblEnd))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldTechnician, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldAddress, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldOutlets, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldZones, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldHP, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(textFieldStart)
                                                                .addComponent(textFieldEnd))))
					.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(161)
					.addComponent(btnAddInstallment)
					.addContainerGap(162, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(359, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddInstallment)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHP)
						.addComponent(textFieldHP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZones)
						.addComponent(textFieldZones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOutlets)
						.addComponent(textFieldOutlets, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(textFieldAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTechnician)
						.addComponent(textFieldTechnician, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStart)
						.addComponent(textFieldStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnd)
						.addComponent(textFieldEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(30)
					.addComponent(btnAddInstallment, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBack)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
