package hanoitower;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HanoiTower extends JFrame implements ActionListener {

	public static void main(String args[]) {
		HanoiTower hanoi = new HanoiTower();
		hanoi.setVisible(true);
	}
	
//	Número máximo de discos é 8, do 9 em diante os discos ficam muito pequenos e não aparecem na tela, porém a regra funciona normalmente	
	int numDisk = 4;
	int fwidth = 1000, fheight = 600;

	JButton exit = new JButton("Sair");

	JButton btnAB = new JButton("B");
	JButton btnAC = new JButton("C");

	JButton btnBA = new JButton("A");
	JButton btnBC = new JButton("C");

	JButton btnCA = new JButton("A");
	JButton btnCB = new JButton("B");

	JLabel A = new JLabel("A");
	JLabel B = new JLabel("B");
	JLabel C = new JLabel("C");

	JLabel numof_moves = new JLabel("Número de movimentos: 0");
	JLabel minMoves = new JLabel("Número mínimo de movimentos: " + (Math.pow(2, numDisk)-1));

	int moves = 1;
	int topAtual = 0;
	int topDestino = 0;
	int posDestino = 0;

	Rectangle[] estaca = new Rectangle[3];
	Rectangle[] disk = new Rectangle[numDisk];

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	Stack<Integer> stack3 = new Stack<Integer>();

	public HanoiTower() {

		setLayout(null);
		setSize(fwidth, fheight);
		setTitle("Torre de Hanoi");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		numof_moves.setBounds(100, 50, 300, 25);
		minMoves.setBounds(500, 50, 300, 25);

		exit.setBounds(100, 100, 100, 25);

		btnAB.setBounds(185, 480, 50, 25);
		btnAC.setBounds(275, 480, 50, 25);

		btnBA.setBounds(445, 480, 50, 25);
		btnBC.setBounds(535, 480, 50, 25);

		btnCA.setBounds(695, 480, 50, 25);
		btnCB.setBounds(785, 480, 50, 25);

		A.setBounds(250, 150, 25, 25);
		B.setBounds(510, 150, 300, 25);
		C.setBounds(760, 150, 300, 25);

		add(numof_moves);
		add(minMoves);
		
		add(exit);

		add(btnAB);
		add(btnAC);

		add(btnBA);
		add(btnBC);

		add(btnCA);
		add(btnCB);

		add(A);
		add(B);
		add(C);

		for (int i = 0; i < numDisk; i++) {
			disk[i] = new Rectangle(160 + i * 12, 475 - i * 25, 200 - i * 25, 25);
		}

		estaca[0] = new Rectangle(250, 200, 15, 300);
		estaca[1] = new Rectangle(510, 200, 15, 300);
		estaca[2] = new Rectangle(760, 200, 15, 300);

		for (int i = 0; i < numDisk; i++) {
			stack1.push(i);
		}

		exit.addActionListener(this);

		btnAB.addActionListener(this);
		btnAC.addActionListener(this);

		btnBA.addActionListener(this);
		btnBC.addActionListener(this);

		btnCA.addActionListener(this);
		btnCB.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == exit) {
			System.exit(0);
		}

		// Botões pilha 1
		if (ae.getSource() == btnAB) {

			try {
				topAtual = stack1.peek();
			} catch (Exception e) {
				topAtual = -1;
			}

			try {
				topDestino = stack2.peek();
			} catch (Exception e) {
				topDestino = -1;
			}

			if (topAtual > topDestino) {
				posDestino = stack2.size();
				stack2.push(stack1.pop());
				disk[topAtual].setLocation(150 + (topAtual * 12) + 260, 475 - (posDestino) * 25);
				repaint();
				numof_moves.setText("Número de movimentos: " + (moves++));
			}
		}

		if (ae.getSource() == btnAC) {

			try {
				topAtual = stack1.peek();
			} catch (Exception e) {
				topAtual = -1;
			}

			try {
				topDestino = stack3.peek();
			} catch (Exception e) {
				topDestino = -1;
			}

			if (topAtual > topDestino) {
				posDestino = stack3.size();
				stack3.push(stack1.pop());
				disk[topAtual].setLocation(150 + (topAtual * 12) + 520, 475 - (posDestino) * 25);
				repaint();
				numof_moves.setText("Número de movimentos: " + (moves++));
			}
		}

		// Botões pilha 2
		if (ae.getSource() == btnBA) {
			try {
				topAtual = stack2.peek();
			} catch (Exception e) {
				topAtual = -1;
			}

			try {
				topDestino = stack1.peek();
			} catch (Exception e) {
				topDestino = -1;
			}

			if (topAtual > topDestino) {
				posDestino = stack1.size();
				stack1.push(stack2.pop());
				disk[topAtual].setLocation(150 + (topAtual * 12) + 10, 475 - (posDestino) * 25);
				repaint();
				numof_moves.setText("Número de movimentos: " + (moves++));
			}
		}

		if (ae.getSource() == btnBC) {
			try {
				topAtual = stack2.peek();
			} catch (Exception e) {
				topAtual = -1;
			}

			try {
				topDestino = stack3.peek();
			} catch (Exception e) {
				topDestino = -1;
			}

			if (topAtual > topDestino) {
				posDestino = stack3.size();
				stack3.push(stack2.pop());
				disk[topAtual].setLocation(150 + (topAtual * 12) + 520, 475 - (posDestino) * 25);
				repaint();
				numof_moves.setText("Número de movimentos: " + (moves++));
			}
		}

		// Botões pilha 3
		if (ae.getSource() == btnCA) {
			try {
				topAtual = stack3.peek();
			} catch (Exception e) {
				topAtual = -1;
			}

			try {
				topDestino = stack1.peek();
			} catch (Exception e) {
				topDestino = -1;
			}

			if (topAtual > topDestino) {
				posDestino = stack1.size();
				stack1.push(stack3.pop());
				disk[topAtual].setLocation(150 + (topAtual * 12) + 10, 475 - (posDestino) * 25);
				repaint();
				numof_moves.setText("Número de movimentos: " + (moves++));
			}
		}
		
		if (ae.getSource() == btnCB) {
			try {
				topAtual = stack3.peek();
			} catch (Exception e) {
				topAtual = -1;
			}

			try {
				topDestino = stack2.peek();
			} catch (Exception e) {
				topDestino = -1;
			}

			if (topAtual > topDestino) {
				posDestino = stack2.size();
				stack2.push(stack3.pop());
				disk[topAtual].setLocation(150 + (topAtual * 12) + 260, 475 - (posDestino) * 25);
				repaint();
				numof_moves.setText("Número de movimentos: " + (moves++));
			}
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);

		for (int i = 0; i < 3; i++) {
			g.fillRect(estaca[i].x, estaca[i].y, estaca[i].width, estaca[i].height);
		}

		g.drawLine(100, 500, 850, 500);

//		Desenha os discos
		for (int i = 0; i < numDisk; i++) {
			g.setColor(Color.red);
			g.fillRoundRect(disk[i].x, disk[i].y, disk[i].width, disk[i].height, 10, 10);

			g.setColor(Color.BLACK);
			g.drawRoundRect(disk[i].x, disk[i].y, disk[i].width, disk[i].height, 10, 10);

			g.setColor(Color.black);
			g.drawString("" + (i + 1), disk[i].x + 100 - i * 12, disk[i].y + 12);
		}
	}
}
