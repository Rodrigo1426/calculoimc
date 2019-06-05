import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Calculo_IMC extends JFrame {

	private JPanel contentPane;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtImc;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculo_IMC frame = new Calculo_IMC();
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
	public Calculo_IMC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lvlPeso = new JLabel("Peso");
		lvlPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lvlPeso.setBounds(10, 25, 48, 14);
		contentPane.add(lvlPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(68, 22, 107, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltura.setBounds(10, 56, 48, 14);
		contentPane.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(68, 53, 107, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setIcon(new ImageIcon(Calculo_IMC.class.getResource("/icones/imc.png")));
		btnCalcular.setBounds(216, 36, 64, 64);
		contentPane.add(btnCalcular);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Calculo_IMC.class.getResource("/icones/limpar.png")));
		btnLimpar.setBounds(320, 36, 64, 64);
		contentPane.add(btnLimpar);
		
		JLabel lblIMC = new JLabel("IMC");
		lblIMC.setHorizontalAlignment(SwingConstants.CENTER);
		lblIMC.setBounds(10, 86, 48, 14);
		contentPane.add(lblIMC);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Calculo_IMC.class.getResource("/icones/tabela_imc.jpg")));
		lblStatus.setBounds(10, 123, 394, 197);
		contentPane.add(lblStatus);
		
		txtImc = new JTextField();
		txtImc.setBounds(68, 83, 107, 20);
		contentPane.add(txtImc);
		txtImc.setColumns(10);
	}
	
	//métodos para calcular o IMC
	private void calcular()
	{
		DecimalFormat formatador = new DecimalFormat("0.00");
		double peso, altura, imc;
		peso = Double.parseDouble(txtPeso.getText().replace("," , "."));
		altura = Double.parseDouble(txtPeso.getText().replace("," , "."));
		imc = peso / (altura * altura);
		txtImc.setText(formatador.format(imc));
		
		if (imc < 18.5) {
			System.out.println("Abaixo do Peso");
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/tabela_imc_abaixo.jpg")));
		} else if (imc >= 18.5 && imc < 25) {
			System.out.println("Abaixo do Peso");
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/tabela_imc_normal.jpg")));
		} else if (imc >= 25 && imc < 30) {
			System.out.println("Abaixo do Peso");
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/tabela_imc_acima.jpg")));
		} else {
			System.out.println("Abaixo do Peso");
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/tabela_imc_obeso.jpg")));
		}
	}
	
	
	
	//método para limpar
	private void limpar()
	{
		txtAltura.setText(null);
		txtPeso.setText(null);
		txtImc.setText(null);
		lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/tabela_imc.jpg")));
	}
	
	
}