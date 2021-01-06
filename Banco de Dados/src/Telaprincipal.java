import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;
import Logica.ManipulatesDatabase;
import javax.swing.border.LineBorder;


public class Telaprincipal extends JFrame{

	private JPanel contentPane;
	private Item t2;
	private ManipulatesDatabase MD;
	public static void main(String[] args) throws IOException {
		File file=new File("FILES");
		if(!file.exists()) {
			file.mkdir();
		}
					new Telaprincipal();
	}
	
	public Telaprincipal() {
		this.setTitle("                                                CADASTRO DO MERCADO");
		setBounds(100, 100, 868, 436);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		getContentPane().add(contentPane);
		
		JLabel criar = new JLabel("CRIAR");
		criar.setBounds(36, 70, 322, 167);
		contentPane.add(criar);
		criar.setIcon(new ImageIcon(getClass().getResource("/imagem/oie_24191813qXo0nnUf (2).jpg")));
		
		criar.setBorder(new LineBorder(new Color(0, 0, 0)));
		criar.setFont(new Font("Arial", Font.BOLD, 20));
		
				JLabel abrir = new JLabel("ABRIR");
				abrir.setBounds(468, 70, 303, 167);
				contentPane.add(abrir);
				abrir.setIcon(new ImageIcon(getClass().getResource("/imagem/oie_2418382285FQzJz2.jpg")));
				abrir.setBorder(new LineBorder(new Color(0, 0, 0)));
				abrir.setFont(new Font("Arial", Font.BOLD, 20));
				
				JLabel excluir = new JLabel("EXCLUIR ");
				excluir.setBorder(new LineBorder(new Color(0, 0, 0)));
				excluir.setIcon(new ImageIcon(getClass().getResource("/imagem/oie_24202252X0i9tdFp.jpg")));
				excluir.setFont(new Font("Arial", Font.BOLD, 20));
				excluir.setBounds(268, 265, 322, 173);
				contentPane.add(excluir);
				excluir.addMouseListener(new MouseListener() {
					public void mouseClicked(MouseEvent e) {
						File arquivo = new File("FILES");
						String[] file = arquivo.list();
						if((file.length != 0)) {	
						String a = (String) JOptionPane.showInputDialog(null, "SELECIONE UM BANCO DE DADOS ", "CADASTRO DE SUPERMERCADO", JOptionPane.QUESTION_MESSAGE, null, file, file[0]);
						if(a!=null) {
							deleteFile(new File("FILES/"+a));
							JOptionPane.showMessageDialog(null, "BANCO DE DADOS APAGADO COM SUCESSO");
						}
						}else {
							JOptionPane.showMessageDialog(null, "NENHUM BANCO DE DADOS CADASTRADOS");
						}
					}
					public void mousePressed(MouseEvent e) {}public void mouseReleased(MouseEvent e) {}public void mouseEntered(MouseEvent e) {}public void mouseExited(MouseEvent e) {}
				});
						abrir.addMouseListener(new MouseListener() {
							public void mouseClicked(MouseEvent e) {
								File arquivo = new File("FILES");
								String[] file = arquivo.list();
								if((file.length != 0)) {	
								String a = (String) JOptionPane.showInputDialog(null, "SELECIONE UM BANCO DE DADOS ", "CADASTRO DE SUPERMERCADO", JOptionPane.QUESTION_MESSAGE, null, file, file[0]);
								if(a!=null) {
									try {
										MD = new ManipulatesDatabase("FILES/"+a);
									} catch (IOException e1) {
										// TODO Bloco catch gerado automaticamente
										e1.printStackTrace();
									}
									try {
										t2 = new Item(contentPane,MD);
									} catch (IOException e1) {
										// TODO Bloco catch gerado automaticamente
										e1.printStackTrace();
									}
									getContentPane().add(t2);
									contentPane.setVisible(false);
									t2.setVisible(true);
								}
								}else {
									JOptionPane.showMessageDialog(null, "NENHUM BANCO DE DADOS CADASTRADOS");
								}
							}
							public void mousePressed(MouseEvent e) {}public void mouseReleased(MouseEvent e) {}public void mouseEntered(MouseEvent e) {}public void mouseExited(MouseEvent e) {}
						});	
		criar.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				String filer = JOptionPane.showInputDialog("INSIRA O NOME PARA CRIAR UM BANCO DE DADOS");
				File file = new File("FILES/"+filer);
			if(filer!=null) {
				if( !(file.exists()) )
		        {
					try {
						MD = new ManipulatesDatabase("FILES/"+filer);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		            JOptionPane.showMessageDialog(null,"CRIADO COM SUCESSO\n" );	
		        }else {
		        	JOptionPane.showMessageDialog(null,"Arquivo com esse nome ja exite\n" );	
				} 
			} 
			}
			public void mousePressed(MouseEvent e) {}public void mouseReleased(MouseEvent e) {}public void mouseEntered(MouseEvent e) {}public void mouseExited(MouseEvent e) {}
		});	
		
		getContentPane().add(contentPane);
		
		
		this.setMinimumSize(new Dimension(868, 510));
		this.setPreferredSize(new Dimension(670, 510));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
	}
    private static boolean deleteFile(File file) {
        for(File f:file.listFiles()){
            if(!f.delete()){
                if(!deleteFile(f)){
                    return false;
                }
            }
        }
        file.delete();
        return file.exists();
    }

}
