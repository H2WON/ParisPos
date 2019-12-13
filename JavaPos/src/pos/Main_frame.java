package pos;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import pos.removingAction.*;
import pos.Index.*;

public class Main_frame extends JFrame implements ActionListener {
	
	JFrame checkMenu = new JFrame();
	JButton[] menubtn = new JButton[4];
	JButton[] sobtn1 = new JButton[6];
	JButton[] sobtn2 = new JButton[6];
	JButton[] sobtn3 = new JButton[6];
	JButton[] sobtn4 = new JButton[6];
	JButton paymentbtn = new JButton(); //결제버튼
	
	static JLabel total = new JLabel("총 금액 : "); //총 금액
	Font totallabfont = new Font("돋움",Font.BOLD ,30);
	
	JPanel sopan1 = new JPanel(); // 종류1 누르면 나오는 패널
	JPanel sopan2 = new JPanel(); // 종류2 누르면 나오는 패널
	JPanel sopan3 = new JPanel(); // 종류3 누르면 나오는 패널
	JPanel sopan4 = new JPanel(); // 종류4 누르면 나오는 패널
	
	JPanel panela = new JPanel();
	static JPanel panelb = new JPanel();
	JPanel panel1 = new JPanel();
	static JPanel panel3 = new JPanel();
	static JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	
	/*--------------------상품명 목록-------------------------*/
	static String colName[] = {"상품명","수량","가격"};
	static DefaultTableModel model = new DefaultTableModel(colName, 0);

	static JTable t = new JTable(model);
	JScrollPane scroll = new JScrollPane(t);
	
	JPanel pan1 = new JPanel(); //칼럼패널
	JButton button2 = new JButton("선택 삭제");
	JButton button3 = new JButton("수량감소");
	JButton button4 = new JButton("전체 삭제");
	/*------------------------------------------------------*/

	
	public Main_frame() {
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

		panela.setLayout(new BorderLayout());
		panelb.setLayout(null);
		panel1.setLayout(new GridLayout(4,1));
		sopan1.setLayout(new GridLayout(2,3));
		sopan2.setLayout(new GridLayout(2,3));
		sopan3.setLayout(new GridLayout(2,3));
		sopan4.setLayout(new GridLayout(2,3));
		panel3.setLayout(new BorderLayout());
		panel4.setLayout(new BorderLayout());
		panel5.setLayout(new BorderLayout());
		
		JLabel logolabel = new JLabel(new ImageIcon("img/logo.png")); //로고
		paymentbtn = new JButton(new ImageIcon("img/payment.png"));
		paymentbtn.addActionListener(this);
	
/*		--------------------------종류 버튼--------------------------*/
		for (int i = 0; i < menubtn.length; i++) {
			menubtn[i] = new JButton(new ImageIcon("img/"+i+".jpg"));
			panel1.add(menubtn[i]);
			menubtn[i].addActionListener(this);
			menubtn[i].setBorderPainted(false);
			menubtn[i].setContentAreaFilled(false);
			menubtn[i].setFocusPainted(false);
		}
		/*----------------------------------------------------------*/
		
		/*------------------------소메뉴 버튼-----------------------------*/
				for (int i = 0; i < sobtn1.length; i++) {
					sobtn1[i] = new JButton(new ImageIcon("img/bread"+(i+1)+".png"));
					sopan1.add(sobtn1[i]);
					sobtn1[i].addActionListener(this);
				}
				
				for (int i = 0; i < sobtn2.length; i++) {
					sobtn2[i] = new JButton(new ImageIcon("img/donut"+(i+1)+".png"));
					sopan2.add(sobtn2[i]);
					sobtn2[i].addActionListener(this);
				}
				
				for (int i = 0; i < sobtn3.length; i++) {
					sobtn3[i] = new JButton(new ImageIcon("img/plainbread"+(i+1)+".png"));
					sopan3.add(sobtn3[i]);
					sobtn3[i].addActionListener(this);
				}
				
				for (int i = 0; i < sobtn4.length; i++) {
					sobtn4[i] = new JButton(new ImageIcon("img/cake"+(i+1)+".png"));
					sopan4.add(sobtn4[i]);
					sobtn4[i].addActionListener(this);
				}
		/*--------------------------------------------------------------*/
				
		add(panela);//큰 판넬A
		add(panelb);//큰 판넬B
		panelb.add(panel1);//판넬B의 1번
		panelb.add(sopan1);//판넬B의 2번
		panelb.add(panel3);//판넬B의 3번
		panelb.add(panel4);//판넬B의 4번
		panelb.add(panel5);//판넬B의 5번
		panela.add(logolabel);//로고
		panel5.add(paymentbtn);//결제버튼
		panel4.add(total);//총 금액라벨
		total.setFont(totallabfont);
		scroll.setBounds( 0, 0, 350, 200 );
		panel3.add(scroll,BorderLayout.CENTER);
		panel3.add(pan1,BorderLayout.SOUTH);
		
		/*-----------------------------위치 설정----------------------------*/
		panela.setBounds(0, 0, 700, 100); //큰 판넬A
		panelb.setBounds(0, 100, 700, 750);//큰 판넬B
		panel1.setBounds(0, 100, 150, 750);//판넬B의 1번
		sopan1.setBounds(150, 100, 550, 450);//판넬B의 2번
		panel3.setBounds(150, 550, 350, 200);//판넬B의 3번
		panel4.setBounds(150, 750, 350, 100);//판넬B의 4번
		panel5.setBounds(500, 550, 200, 300);//판넬B의 5번
		/*----------------------------------------------------------------*/
			
		panel4.setBackground(Color.white);//판넬B의 4번
		
		/*---------------------상품명 목록 JTable--------------------------*/
		DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
		tableCell.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel CellMode1 = t.getColumnModel();
		
		for(int i=0; i <CellMode1.getColumnCount();i++)
			CellMode1.getColumn(i).setCellRenderer(tableCell);
			
		t.setBackground(Color.white);
		pan1.add(button2);
		pan1.add(button3);
		pan1.add(button4);
			
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
		setPreferredSize( new Dimension(200,200));
		   pack();
		/*-----------------------------------------------------------------*/

		setTitle("★메뉴를 선택해주세요★");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); // 사용자가 창의 크기를 변경할 수 없음
		setBounds(x, y, width, height);
		setVisible(true);
	}
	
	int so_1 = 1, so_2 = 1, so_3 = 1, so_4 = 1, so_5 = 1, so_6 = 1;	//빵 카테고리 안 6개 각각에 대한 수량 변수
	int so_7 = 1, so_8 = 1, so_9 = 1, so_10 = 1, so_11 = 1, so_12 = 1;	//도넛 카테고리 
	int so_13 = 1, so_14 = 1, so_15 = 1, so_16 = 1, so_17 = 1, so_18 = 1;	//식빵 카테고리
	int so_19 = 1, so_20 = 1, so_21 = 1, so_22 = 1, so_23 = 1, so_24 = 1;	//케이크 카테고리
	//24개 변수 배열로 선언하고 싶었는데..
	//int so[] = new int[24]; 반복문으로 인덱스마다 1로 초기화 해주고 싶었는데.. 반복문이 날 거부해..

	
	static int totalPrice = 0;   //금액을 누적시킬 변수
    int rowCount;
    int column = 0,won;
    Object breadName,cName;
	@Override
	
	public void actionPerformed(ActionEvent e) {
		
		Object btn = e.getSource();
		
		Object array[] = new Object[3];

		
		int tableRow = t.getRowCount();   //테이블에 들어있는 행의 갯수 가져오기
		
		if(btn == sobtn1[0])
		{
			int won_1 = 1500;
			array[0] = "단팥크림코팡";
			array[1] = so_1;
			array[2] = won_1;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			
			if(so_1 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++) {
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						won=0;
						won = so_1*won_1;
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(won, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
				
			}
			so_1++;
			totalPrice += won_1;
		}
		else if(btn == sobtn1[1])
		{
			int won_2 = 1200;
			array[0] = "로만밀소보루빵";
			array[1] = so_2;
			array[2] = won_2;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			
			if(so_2 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++) {
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						won=0;
						won = so_2*won_2;
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(won, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
				
			}
			so_2++;
			totalPrice += won_2;
		}
		else if(btn == sobtn1[2])
		{
			
			int won_3 = 1200;
			array[0] = "슈크림빵";
			array[1] = so_3;
			array[2] = won_3;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_3 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						won=0;
						won = so_3*won_3;
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(won, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
				
			}
			so_3++;
			totalPrice += won_3;
		}
		else if(btn == sobtn1[3])
		{
			
			int won_4 = 2300;
			array[0] = "양파치즈브레드";
			array[1] = so_4;
			array[2] = won_4;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_4 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						won=0;
						won = so_4*won_4;
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(won, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_4++;
			totalPrice += won_4;
		}
		else if(btn == sobtn1[4])
		{
			
			int won_5 = 1900;
			array[0] = "뽀드득 그릴 소시지";
			array[1] = so_5;
			array[2] = won_5;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_5 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						won=0;
						won = so_5*won_5;
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(won, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_5++;
			totalPrice += won_5;
		}
		else if(btn == sobtn1[5])
		{
			
			int won_6 = 1100;
			array[0] = "초코소라빵";
			array[1] = so_6;
			array[2] = won_6;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_6 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						won=0;
						won = so_6*won_6;
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(won, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_6++;
			totalPrice += won_6;
		}
		// 도넛 sobtn2
		else if(btn == sobtn2[0])
		{
			int won_7 = 1900;
			array[0] = "케익꽈배기도넛";
			array[1] = so_7;
			array[2] = won_7;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_7 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_7*won_7, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_7++;
			totalPrice += won_7;
		}
		else if(btn == sobtn2[1])
		{
			int won_8 = 1400;
			array[0] = "옛날왕슈크림도넛";
			array[1] = so_8;
			array[2] = won_8;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_8 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_8*won_8, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_8++;
			totalPrice += won_8;
		}
		else if(btn == sobtn2[2])
		{
			int won_9 = 1600;
			array[0] = "타코야끼볼";
			array[1] = so_9;
			array[2] = won_9;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_9 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_9*won_9, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_9++;
			totalPrice += won_9;
		}
		else if(btn == sobtn2[3])
		{
			int won_10 = 1400;
			array[0] = "초코츄잉스타";
			array[1] = so_10;
			array[2] = won_10;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_10 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_10*won_10, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_10++;
			totalPrice += won_10;
		}
		else if(btn == sobtn2[4])
		{
			int won_11 = 2100;
			array[0] = "츄러스";
			array[1] = so_11;
			array[2] = won_11;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_11 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_11*won_11, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_11++;
			totalPrice += won_11;
		}
		else if(btn == sobtn2[5])
		{
			int won_12 = 1800;
			array[0] = "햄에그고로케";
			array[1] = so_12;
			array[2] = won_12;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_12 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_12*won_12, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_12++;
			totalPrice += won_12;
		}
		// 식빵 sobtn3
		else if(btn == sobtn3[0])
		{
			int won_13 = 3800;
			array[0] = "64겹골든페스츄리";
			array[1] = so_13;
			array[2] = won_13;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_13 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_13*won_13, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_13++;
			totalPrice += won_13;
		}
		else if(btn == sobtn3[1])
		{
			int won_14 = 2600;
			array[0] = "토종효모로만밀브레드";
			array[1] = so_14;
			array[2] = won_14;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_14 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_14*won_14, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_14++;
			totalPrice += won_14;
		}
		else if(btn == sobtn3[2])
		{
			int won_15 = 2900;
			array[0] = "토종효모생크림식빵";
			array[1] = so_15;
			array[2] = won_15;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_15 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_15*won_15, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_15++;
			totalPrice += won_15;
		}
		else if(btn == sobtn3[3])
		{
			int won_16 = 2800;
			array[0] = "블루베리생크림식빵";
			array[1] = so_16;
			array[2] = won_16;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_16 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_16*won_16, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_16++;
			totalPrice += won_16;
		}
		else if(btn == sobtn3[4])
		{
			int won_17 = 2400;
			array[0] = "그대로버터롤";
			array[1] = so_17;
			array[2] = won_17;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_17 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_17*won_17, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_17++;
			totalPrice += won_17;
		}
		else if(btn == sobtn3[5])
		{
			int won_18 = 4000;
			array[0] = "뜯어먹는식빵";
			array[1] = so_18;
			array[2] = won_18;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_18 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_18*won_18, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_18++;
			totalPrice += won_18;
		}		
		// 케이크 sobtn4
		else if(btn == sobtn4[0])
		{
			int won_19 = 28000;
			array[0] = "딸기듬뿍티라미스";
			array[1] = so_19;
			array[2] = won_19;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_19 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_19*won_19, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_19++;
			totalPrice += won_19;
		}
		else if(btn == sobtn4[1])
		{
			int won_20 = 24000;
			array[0] = "고구마케이크";
			array[1] = so_20;
			array[2] = won_20;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_20 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_20*won_20, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_20++;
			totalPrice += won_20;
		}
		else if(btn == sobtn4[2])
		{
			int won_21 = 19000;
			array[0] = "쿠키앤치즈케이크";
			array[1] = so_21;
			array[2] = won_21;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_21 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_21*won_21, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_21++;
			totalPrice += won_21;
		}
		else if(btn == sobtn4[3])
		{
			int won_22 = 31000;
			array[0] = "스트로베리퀸";
			array[1] = so_22;
			array[2] = won_22;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_22 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_22*won_22, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_22++;
			totalPrice += won_22;
		}
		else if(btn == sobtn4[4])
		{
			int won_23 = 29000;
			array[0] = "마이넘버원2";
			array[1] = so_23;
			array[2] = won_23;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_23 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_23*won_23, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_23++;
			totalPrice += won_23;
		}
		else if(btn == sobtn4[5])
		{
			int won_24 = 21000;
			array[0] = "고구마가반한티라미수";
			array[1] = so_24;
			array[2] = won_24;
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(so_24 > 1)
			{
				for (rowCount = 0; rowCount < tableRow; rowCount++)
				{
					breadName = t.getValueAt(rowCount, column);
					if(breadName == array[0])
					{
						t.setValueAt(array[1], rowCount, column+1);
						t.setValueAt(so_24*won_24, rowCount, column+2);
					}
					
				}
			}
			else
			{
				model.addRow(array);
			}
			so_24++;
			totalPrice += won_24;
		}
		// 빵 소메뉴 이벤트 End
	
		//삭제 버튼 start
		else if(btn == button2)
		{
			DefaultTableModel model = (DefaultTableModel)t.getModel();
			if(t.getSelectedRow() == -1) {
				return;
			}
			else
			{
				totalPrice -= (int) t.getValueAt(t.getSelectedRow(), 2);
			}
			
			if(t.getValueAt(t.getSelectedRow(), 0) == "단팥크림코팡")
			{
				so_1 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "로만밀소보루빵")
			{
				so_2 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "슈크림빵")
			{
				so_3 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "양파치즈브레드")
			{
				so_4 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "뽀드득 그릴 소시지")
			{
				so_5 = 1;
			}
				
			else if(t.getValueAt(t.getSelectedRow(), 0) == "초코소라빵")
			{
				so_6 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "케익꽈배기도넛")
			{
				so_7 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "옛날왕슈크림도넛")
			{
				so_8 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "타코야끼볼")
			{
				so_9 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "초코츄잉스타")
			{
				so_10 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "츄러스")
			{
				so_11 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "햄에그고로케")
			{
			so_12 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "64겹골든페스츄리")
			{
				so_13 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "토종효모로만밀브레드")
			{
				so_14 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "토종효모생크림식빵")
			{
				so_15 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "블루베리생크림식빵")
			{
				so_16 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "그대로버터롤")
			{
				so_17 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "뜯어먹는식빵")
			{
				so_18 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "딸기듬뿍티라미스")
			{
				so_19 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "고구마케이크")
			{
				so_20 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "쿠키앤치즈케이크")
			{
				so_21 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "스트로베리퀸")
			{
				so_22 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "마이넘버원2")
			{
				so_23 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "고구마가반한티라미수")
			{
				so_24 = 1;
			}
			
			model.removeRow(t.getSelectedRow());
			
		}
		//삭제 버튼 end
		
		//수량 감소 부분 start
		else if(btn == button3)
		{
			if (t.getSelectedRow() == -1)
			{
				return;
			}
			else
			{
				int downCount = (int) t.getValueAt(t.getSelectedRow(), 1) - 1;
				int downPrice = (int) t.getValueAt(t.getSelectedRow(), 2)/(int) t.getValueAt(t.getSelectedRow(), 1);
				t.setValueAt(downCount, t.getSelectedRow(), 1);
				t.setValueAt(((int)t.getValueAt(t.getSelectedRow(), 2) - downPrice), t.getSelectedRow(), 2);
				totalPrice -= downPrice;
			}
			if ((int) t.getValueAt(t.getSelectedRow(), 1) == 0)
			{
				if(t.getValueAt(t.getSelectedRow(), 0) == "단팥크림코팡")
				{
					so_1 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "로만밀소보루빵")
				{
					so_2 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "슈크림빵")
				{
					so_3 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "양파치즈브레드")
				{
					so_4 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "뽀드득 그릴 소시지")
				{
					so_5 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "초코소라빵")
				{
					so_6 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "케익꽈배기도넛")
				{
					so_7 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "옛날왕슈크림도넛")
				{
					so_8 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "타코야끼볼")
				{
					so_9 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "초코츄잉스타")
				{
					so_10 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "츄러스")
				{
					so_11 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "햄에그고로케")
				{
					so_12 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "64겹골든페스츄리")
				{
					so_13 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "토종효모로만밀브레드")
				{
					so_14 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "토종효모생크림식빵")
				{
					so_15 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "블루베리생크림식빵")
				{
					so_16 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "그대로버터롤")
				{
					so_17 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "뜯어먹는식빵")
				{
					so_18 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "딸기듬뿍티라미스")
				{
					so_19 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "고구마케이크")
				{
					so_20 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "쿠키앤치즈케이크")
				{
					so_21 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "스트로베리퀸")
				{
					so_22 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "마이넘버원2")
				{
					so_23 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "고구마가반한티라미수")
				{
					so_24 = 1;
				}
						
				model.removeRow(t.getSelectedRow());
			}
		}
		else if(btn == button4)
		{	
			/*-----------------------------수량 초기화----------------------------*/
			so_1 = 1; so_2 = 1; so_3 = 1; so_4 = 1; so_5 = 1; so_6 = 1;	
			so_7 = 1; so_8 = 1; so_9 = 1; so_10 = 1; so_11 = 1; so_12 = 1;
			so_13 = 1; so_14 = 1; so_15 = 1; so_16 = 1; so_17 = 1; so_18 = 1;
			so_19 = 1; so_20 = 1; so_21 = 1; so_22 = 1; so_23 = 1; so_24 = 1;	
			/*-----------------------------------------------------------------*/
			model.setNumRows(0);
			totalPrice =0 ;
		}
	      
	      //총 금액 찍는 부분 Start
	      total.setText("총 금액 : " + totalPrice);
	      panel4.add(total);
	      //총 금액 찍기위한 부분 End
		
		//종류 버튼 이벤트 Start
	    if(btn == menubtn[0]) // 종류1 누를때 패널
		{
			sopan1.setVisible(true);
			
		}
		else if(btn == menubtn[1]) // 종류2 누를때 패널
		{
			sopan1.setVisible(false);
			sopan3.setVisible(false);
			sopan4.setVisible(false);
			panelb.add(sopan2);
			sopan2.setBounds(150, 100, 550, 450);
			sopan2.setVisible(true);
		}
		else if(btn == menubtn[2]) // 종류3 누를때 패널 
		{
			sopan1.setVisible(false);
			sopan2.setVisible(false);
			sopan4.setVisible(false);
			panelb.add(sopan3);
			sopan3.setBounds(150, 100, 550, 450);
			sopan3.setVisible(true);
		}
		else if(btn == menubtn[3]) // 종류4 누를때 패널
		{
			sopan1.setVisible(false);
			sopan2.setVisible(false);
			sopan3.setVisible(false);
			panelb.add(sopan4);
			sopan4.setBounds(150, 100, 550, 450);
			sopan4.setVisible(true);
		}
		//종류 버튼 이벤트 End
	    
	    if(btn == paymentbtn)
	    {
	    	this.dispose();
//	    	Main_frame.panel3.add(scroll);
	    	new End_frame();

	    }

	    
	}
	
	private int Integer(Object selectedBreadCount) {
		// TODO Auto-generated method stub
		return 0;
	}


}
