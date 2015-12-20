package dnd_across_panels;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * This is a Drag and Drop of complex object example. Reference:
 * http://zetcode.com/tutorials/javaswingtutorial/draganddrop/
 * */
public class Main extends JFrame {

	private JPanel contentPane;
	private JPanel esquerda;
	private JPanel direita;
	private JLabelAnimal labelAnimal;
	
        
        /**
	 * Create the frame.
	 */
	public Main() {
		setTitle("D'n'D example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		esquerda = new JPanel();
		esquerda.setBackground(SystemColor.desktop);
		esquerda.setBounds(5, 5, 186, 263);
		contentPane.add(esquerda);

		labelAnimal = new JLabelAnimal(new Animal());
		esquerda.add(labelAnimal);

		direita = new JPanel();
		direita.setBackground(SystemColor.desktop);
		direita.setBounds(251, 5, 186, 263);
		contentPane.add(direita);

		init();
	}

	private void init() {
		DragSource ds = new DragSource();
		ds.createDefaultDragGestureRecognizer(labelAnimal, 
                        DnDConstants.ACTION_COPY, new DragGestureListImp());

		new MyDropTargetListImp(direita);
	}

        
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Main().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	

	

	
}