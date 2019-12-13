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
		/*-------------------프레임 위치 중앙--------------------*/
	      Toolkit tool = Toolkit.getDefaultToolkit();
	      Dimension dm = tool.getScreenSize();
	      
	      int sw = dm.width; //스크린너비
	      int sh = dm.height; //스크린높이
	      
	      int width = 715; // frame너비
	      int height = 890; //frame높이
	      
	      int x = (int)(0.5*(sw-width));
	      int y = (int)(0.5*(sh-height));
	      /*--------------------------------------------------- */
	      
	      /*------------------------배경 넣기------------------------*/
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
	      
	      
	      
	      setTitle("결제 완료 창");
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	      setResizable(false); // 사용자가 창의 크기를 변경할 수 없음
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
