package pos;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class End_frame extends JFrame implements ActionListener {
	
	JButton exit = new JButton(new ImageIcon("img/exit.png"));
	
	public End_frame() {
		setLayout(null);
		/*-------------------������ ��ġ �߾�--------------------*/
	      Toolkit tool = Toolkit.getDefaultToolkit();
	      Dimension dm = tool.getScreenSize();
	      
	      int sw = dm.width; //��ũ���ʺ�
	      int sh = dm.height; //��ũ������
	      
	      int width = 715; // frame�ʺ�
	      int height = 890; //frame����
	      
	      int x = (int)(0.5*(sw-width));
	      int y = (int)(0.5*(sh-height));
	      /*--------------------------------------------------- */
	      
	      /*------------------------��� �ֱ�------------------------*/
	      JLabel lbl = new JLabel(new ImageIcon("img/End.png"));
	      JPanel background = new JPanel();
	      lbl.setHorizontalAlignment(JLabel.CENTER);
	      background.setLayout(new BorderLayout());
	      
	      background.setBounds(0, 0, 715, 890);
	      background.add(lbl);
	      add(background);
	      /*-------------------------------------------------------*/
	      
	      exit.setBounds(250, 760, 200, 60);
	      
	      lbl.add(exit);
	      exit.addActionListener(this);
	      
	      exit.setBorderPainted(false);
	      exit.setContentAreaFilled(false);
	      exit.setFocusPainted(false);
	      
	      
	      
	      setTitle("���� �Ϸ� â");
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	      setResizable(false); // ����ڰ� â�� ũ�⸦ ������ �� ����
	      setBounds(x, y, width, height);
	      setVisible(true);
	      Main_frame.totalPrice = 0;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == exit)
		{
			this.dispose();
		}
		

	}

}
