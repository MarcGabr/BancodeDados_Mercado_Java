

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import Logica.ManipulatesDatabase;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class InserirDialog extends JDialog {

	private static final long serialVersionUID = 8549199877970797986L;
	private final JPanel contentPanel = new JPanel();
	//private ManipulatesDatabase MD;
	
	public InserirDialog(ManipulatesDatabase MD) {
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("                                                CADASTRO DO MERCADO");
		this.setVisible(false);
		setBounds(700, 100, 678, 430);
		setMaximumSize(new Dimension(678, 383));
		setResizable(false);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel textotela = new JLabel("INSER\u00C7\u00C3O");
		textotela.setForeground(Color.RED);
		textotela.setFont(new Font("Arial", Font.BOLD, 20));
		textotela.setBounds(290, 11, 125, 61);
		contentPanel.add(textotela);
		
		JLabel nomelabel = new JLabel("NOME DO ITEM:");
		nomelabel.setFont(new Font("Arial", Font.PLAIN, 13));
		nomelabel.setBounds(29, 112, 106, 14);
		contentPanel.add(nomelabel);
		
		JLabel valorlabel = new JLabel("VALOR R$:");
		valorlabel.setFont(new Font("Arial", Font.PLAIN, 13));
		valorlabel.setBounds(29, 165, 71, 14);
		contentPanel.add(valorlabel);
		
		JLabel idlabel = new JLabel("ID:");
		idlabel.setFont(new Font("Arial", Font.PLAIN, 15));
		idlabel.setBounds(29, 264, 46, 14);
		contentPanel.add(idlabel);
		
		JEditorPane nomePane = new JEditorPane();
		nomePane.setBorder(new LineBorder(new Color(0, 0, 0)));
		nomePane.setBounds(176, 99, 453, 40);
		contentPanel.add(nomePane);
		
		JEditorPane valorPane = new JEditorPane();
		valorPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		valorPane.setBounds(176, 165, 179, 20);
		contentPanel.add(valorPane);
		
		JTextPane idpane = new JTextPane();
		idpane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		idpane.setBounds(176, 258, 125, 20);
		contentPanel.add(idpane);
		
		JButton cadbotao = new JButton("CADASTRAR");
		cadbotao.setIcon(new ImageIcon(getClass().getResource("/imagem/oie_transparent (18).png")));
		cadbotao.setFont(new Font("Arial", Font.BOLD, 13));
		cadbotao.setBounds(156, 327, 145, 40);
		contentPanel.add(cadbotao);
		
		JButton cancelarbotao = new JButton("CANCELAR");
		cancelarbotao.setIcon(new ImageIcon(getClass().getResource("/imagem/cancelar (2).png")));
		cancelarbotao.setFont(new Font("Arial", Font.BOLD, 13));
		cancelarbotao.setBounds(398, 327, 150, 40);
		contentPanel.add(cancelarbotao);
		
		JLabel qtd = new JLabel("RAMO:");
		qtd.setFont(new Font("Arial", Font.PLAIN, 13));
		qtd.setForeground(new Color(0, 0, 0));
		qtd.setBounds(29, 214, 136, 14);
		contentPanel.add(qtd);
		
		JTextPane ramopane = new JTextPane();
		ramopane.setBorder(new LineBorder(new Color(0, 0, 0)));
		ramopane.setBounds(176, 214, 453, 20);
		contentPanel.add(ramopane);
		
		cancelarbotao.addActionListener((ActionEvent ae) -> {
	           this.dispose();
	      });
		cadbotao.addActionListener((ActionEvent ae) -> {
	       try {
	    	   if(nomePane.getText().equals("")|| valorPane.getText().equals("")||ramopane.getText().equals("")||idpane.getText().equals("")) {
	       
	        	 JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente");
	        }else {
	        	Object o[] = {Integer.valueOf(idpane.getText()),nomePane.getText(),Float.valueOf(valorPane.getText()),ramopane.getText()};
	        		//System.out.println(""+b);
					//MD = new ManipulatesDatabase(b);
					
					if(MD.InserirProduto(o)) {
					JOptionPane.showMessageDialog(null,"Cadastrado com SUCESSO\n" );	
					 this.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "ID JA CADASTRADO");
					}
	        }
	       }catch(NumberFormatException e){
	    	   JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente3");
	       }catch(NullPointerException f) {
	    	   JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente5");
	       } catch (IOException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
	      });
		
	}
}
