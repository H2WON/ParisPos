package pos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pos.removingAction.*;
import pos.Main_frame.*;

public class Index extends JFrame implements ActionListener {

	JButton btn = new JButton(new ImageIcon("img/IndexButton.png"));
	
	public Index() {
		setLayout(null);
		
		Toolkit tool = Toolkit.getDefaultToolkit();
		Dimension dm = tool.getScreenSize();
		
		int sw = dm.width; //��ũ���ʺ�
		int sh = dm.height; //��ũ������
		int width = 700; // frame�ʺ�
		int height = 870; //frame����
		int x = (int)(0.5*(sw-width));
		int y = (int)(0.5*(sh-height));
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel(new BorderLayout());
		JLabel lbl = new JLabel(new ImageIcon("img/IndexBack.png"));
		
		panel2.setLayout(new GridLayout(1, 1));
		lbl.setHorizontalAlignment(JLabel.CENTER);
		
		
		panel1.setBounds(0,0,700,600);
		panel2.setBounds(0,600,700,250);
		
//		��ư �����ϰ� �����
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		
		panel1.add(lbl);
		
		
		add(panel1);
		add(panel2);
		panel2.add(btn);
		
		btn.addActionListener(this);
		
		setTitle("���ĸ��ٰ�Ʈ�� ���Ű� ȯ���մϴ١�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true); // ����ڰ� â�� ũ�⸦ ������ �� ����
		setBounds(x, y, width, height);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == btn)
		{
			this.dispose();
			new Main_frame();
		}

	}


}
