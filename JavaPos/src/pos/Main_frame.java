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
	JButton paymentbtn = new JButton(); //������ư
	
	static JLabel total = new JLabel("�� �ݾ� : "); //�� �ݾ�
	Font totallabfont = new Font("����",Font.BOLD ,30);
	
	JPanel sopan1 = new JPanel(); // ����1 ������ ������ �г�
	JPanel sopan2 = new JPanel(); // ����2 ������ ������ �г�
	JPanel sopan3 = new JPanel(); // ����3 ������ ������ �г�
	JPanel sopan4 = new JPanel(); // ����4 ������ ������ �г�
	
	JPanel panela = new JPanel();
	static JPanel panelb = new JPanel();
	JPanel panel1 = new JPanel();
	static JPanel panel3 = new JPanel();
	static JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	
	/*--------------------��ǰ�� ���-------------------------*/
	static String colName[] = {"��ǰ��","����","����"};
	static DefaultTableModel model = new DefaultTableModel(colName, 0);

	static JTable t = new JTable(model);
	JScrollPane scroll = new JScrollPane(t);
	
	JPanel pan1 = new JPanel(); //Į���г�
	JButton button2 = new JButton("���� ����");
	JButton button3 = new JButton("��������");
	JButton button4 = new JButton("��ü ����");
	/*------------------------------------------------------*/

	
	public Main_frame() {
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
		
		JLabel logolabel = new JLabel(new ImageIcon("img/logo.png")); //�ΰ�
		paymentbtn = new JButton(new ImageIcon("img/payment.png"));
		paymentbtn.addActionListener(this);
	
/*		--------------------------���� ��ư--------------------------*/
		for (int i = 0; i < menubtn.length; i++) {
			menubtn[i] = new JButton(new ImageIcon("img/"+i+".jpg"));
			panel1.add(menubtn[i]);
			menubtn[i].addActionListener(this);
			menubtn[i].setBorderPainted(false);
			menubtn[i].setContentAreaFilled(false);
			menubtn[i].setFocusPainted(false);
		}
		/*----------------------------------------------------------*/
		
		/*------------------------�Ҹ޴� ��ư-----------------------------*/
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
				
		add(panela);//ū �ǳ�A
		add(panelb);//ū �ǳ�B
		panelb.add(panel1);//�ǳ�B�� 1��
		panelb.add(sopan1);//�ǳ�B�� 2��
		panelb.add(panel3);//�ǳ�B�� 3��
		panelb.add(panel4);//�ǳ�B�� 4��
		panelb.add(panel5);//�ǳ�B�� 5��
		panela.add(logolabel);//�ΰ�
		panel5.add(paymentbtn);//������ư
		panel4.add(total);//�� �ݾ׶�
		total.setFont(totallabfont);
		scroll.setBounds( 0, 0, 350, 200 );
		panel3.add(scroll,BorderLayout.CENTER);
		panel3.add(pan1,BorderLayout.SOUTH);
		
		/*-----------------------------��ġ ����----------------------------*/
		panela.setBounds(0, 0, 700, 100); //ū �ǳ�A
		panelb.setBounds(0, 100, 700, 750);//ū �ǳ�B
		panel1.setBounds(0, 100, 150, 750);//�ǳ�B�� 1��
		sopan1.setBounds(150, 100, 550, 450);//�ǳ�B�� 2��
		panel3.setBounds(150, 550, 350, 200);//�ǳ�B�� 3��
		panel4.setBounds(150, 750, 350, 100);//�ǳ�B�� 4��
		panel5.setBounds(500, 550, 200, 300);//�ǳ�B�� 5��
		/*----------------------------------------------------------------*/
			
		panel4.setBackground(Color.white);//�ǳ�B�� 4��
		
		/*---------------------��ǰ�� ��� JTable--------------------------*/
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

		setTitle("�ڸ޴��� �������ּ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false); // ����ڰ� â�� ũ�⸦ ������ �� ����
		setBounds(x, y, width, height);
		setVisible(true);
	}
	
	int so_1 = 1, so_2 = 1, so_3 = 1, so_4 = 1, so_5 = 1, so_6 = 1;	//�� ī�װ� �� 6�� ������ ���� ���� ����
	int so_7 = 1, so_8 = 1, so_9 = 1, so_10 = 1, so_11 = 1, so_12 = 1;	//���� ī�װ� 
	int so_13 = 1, so_14 = 1, so_15 = 1, so_16 = 1, so_17 = 1, so_18 = 1;	//�Ļ� ī�װ�
	int so_19 = 1, so_20 = 1, so_21 = 1, so_22 = 1, so_23 = 1, so_24 = 1;	//����ũ ī�װ�
	//24�� ���� �迭�� �����ϰ� �;��µ�..
	//int so[] = new int[24]; �ݺ������� �ε������� 1�� �ʱ�ȭ ���ְ� �;��µ�.. �ݺ����� �� �ź���..

	
	static int totalPrice = 0;   //�ݾ��� ������ų ����
    int rowCount;
    int column = 0,won;
    Object breadName,cName;
	@Override
	
	public void actionPerformed(ActionEvent e) {
		
		Object btn = e.getSource();
		
		Object array[] = new Object[3];

		
		int tableRow = t.getRowCount();   //���̺� ����ִ� ���� ���� ��������
		
		if(btn == sobtn1[0])
		{
			int won_1 = 1500;
			array[0] = "����ũ������";
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
			array[0] = "�θ��мҺ��继";
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
			array[0] = "��ũ����";
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
			array[0] = "����ġ��극��";
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
			array[0] = "�ǵ�� �׸� �ҽ���";
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
			array[0] = "���ڼҶ�";
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
		// ���� sobtn2
		else if(btn == sobtn2[0])
		{
			int won_7 = 1900;
			array[0] = "���Ͳʹ�⵵��";
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
			array[0] = "�����ս�ũ������";
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
			array[0] = "Ÿ�ھ߳���";
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
			array[0] = "�������׽�Ÿ";
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
			array[0] = "�򷯽�";
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
			array[0] = "�ܿ��װ����";
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
		// �Ļ� sobtn3
		else if(btn == sobtn3[0])
		{
			int won_13 = 3800;
			array[0] = "64�����佺��";
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
			array[0] = "����ȿ��θ��к극��";
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
			array[0] = "����ȿ���ũ���Ļ�";
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
			array[0] = "��纣����ũ���Ļ�";
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
			array[0] = "�״�ι��ͷ�";
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
			array[0] = "���Դ½Ļ�";
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
		// ����ũ sobtn4
		else if(btn == sobtn4[0])
		{
			int won_19 = 28000;
			array[0] = "������Ƽ��̽�";
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
			array[0] = "��������ũ";
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
			array[0] = "��Ű��ġ������ũ";
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
			array[0] = "��Ʈ�κ�����";
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
			array[0] = "���̳ѹ���2";
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
			array[0] = "����������Ƽ��̼�";
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
		// �� �Ҹ޴� �̺�Ʈ End
	
		//���� ��ư start
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
			
			if(t.getValueAt(t.getSelectedRow(), 0) == "����ũ������")
			{
				so_1 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "�θ��мҺ��继")
			{
				so_2 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "��ũ����")
			{
				so_3 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "����ġ��극��")
			{
				so_4 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "�ǵ�� �׸� �ҽ���")
			{
				so_5 = 1;
			}
				
			else if(t.getValueAt(t.getSelectedRow(), 0) == "���ڼҶ�")
			{
				so_6 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "���Ͳʹ�⵵��")
			{
				so_7 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "�����ս�ũ������")
			{
				so_8 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "Ÿ�ھ߳���")
			{
				so_9 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "�������׽�Ÿ")
			{
				so_10 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "�򷯽�")
			{
				so_11 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "�ܿ��װ����")
			{
			so_12 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "64�����佺��")
			{
				so_13 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "����ȿ��θ��к극��")
			{
				so_14 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "����ȿ���ũ���Ļ�")
			{
				so_15 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "��纣����ũ���Ļ�")
			{
				so_16 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "�״�ι��ͷ�")
			{
				so_17 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "���Դ½Ļ�")
			{
				so_18 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "������Ƽ��̽�")
			{
				so_19 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "��������ũ")
			{
				so_20 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "��Ű��ġ������ũ")
			{
				so_21 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "��Ʈ�κ�����")
			{
				so_22 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "���̳ѹ���2")
			{
				so_23 = 1;
			}
			else if(t.getValueAt(t.getSelectedRow(), 0) == "����������Ƽ��̼�")
			{
				so_24 = 1;
			}
			
			model.removeRow(t.getSelectedRow());
			
		}
		//���� ��ư end
		
		//���� ���� �κ� start
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
				if(t.getValueAt(t.getSelectedRow(), 0) == "����ũ������")
				{
					so_1 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "�θ��мҺ��继")
				{
					so_2 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "��ũ����")
				{
					so_3 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "����ġ��극��")
				{
					so_4 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "�ǵ�� �׸� �ҽ���")
				{
					so_5 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "���ڼҶ�")
				{
					so_6 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "���Ͳʹ�⵵��")
				{
					so_7 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "�����ս�ũ������")
				{
					so_8 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "Ÿ�ھ߳���")
				{
					so_9 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "�������׽�Ÿ")
				{
					so_10 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "�򷯽�")
				{
					so_11 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "�ܿ��װ����")
				{
					so_12 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "64�����佺��")
				{
					so_13 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "����ȿ��θ��к극��")
				{
					so_14 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "����ȿ���ũ���Ļ�")
				{
					so_15 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "��纣����ũ���Ļ�")
				{
					so_16 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "�״�ι��ͷ�")
				{
					so_17 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "���Դ½Ļ�")
				{
					so_18 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "������Ƽ��̽�")
				{
					so_19 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "��������ũ")
				{
					so_20 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "��Ű��ġ������ũ")
				{
					so_21 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "��Ʈ�κ�����")
				{
					so_22 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "���̳ѹ���2")
				{
					so_23 = 1;
				}
				else if(t.getValueAt(t.getSelectedRow(), 0) == "����������Ƽ��̼�")
				{
					so_24 = 1;
				}
						
				model.removeRow(t.getSelectedRow());
			}
		}
		else if(btn == button4)
		{	
			/*-----------------------------���� �ʱ�ȭ----------------------------*/
			so_1 = 1; so_2 = 1; so_3 = 1; so_4 = 1; so_5 = 1; so_6 = 1;	
			so_7 = 1; so_8 = 1; so_9 = 1; so_10 = 1; so_11 = 1; so_12 = 1;
			so_13 = 1; so_14 = 1; so_15 = 1; so_16 = 1; so_17 = 1; so_18 = 1;
			so_19 = 1; so_20 = 1; so_21 = 1; so_22 = 1; so_23 = 1; so_24 = 1;	
			/*-----------------------------------------------------------------*/
			model.setNumRows(0);
			totalPrice =0 ;
		}
	      
	      //�� �ݾ� ��� �κ� Start
	      total.setText("�� �ݾ� : " + totalPrice);
	      panel4.add(total);
	      //�� �ݾ� ������� �κ� End
		
		//���� ��ư �̺�Ʈ Start
	    if(btn == menubtn[0]) // ����1 ������ �г�
		{
			sopan1.setVisible(true);
			
		}
		else if(btn == menubtn[1]) // ����2 ������ �г�
		{
			sopan1.setVisible(false);
			sopan3.setVisible(false);
			sopan4.setVisible(false);
			panelb.add(sopan2);
			sopan2.setBounds(150, 100, 550, 450);
			sopan2.setVisible(true);
		}
		else if(btn == menubtn[2]) // ����3 ������ �г� 
		{
			sopan1.setVisible(false);
			sopan2.setVisible(false);
			sopan4.setVisible(false);
			panelb.add(sopan3);
			sopan3.setBounds(150, 100, 550, 450);
			sopan3.setVisible(true);
		}
		else if(btn == menubtn[3]) // ����4 ������ �г�
		{
			sopan1.setVisible(false);
			sopan2.setVisible(false);
			sopan3.setVisible(false);
			panelb.add(sopan4);
			sopan4.setBounds(150, 100, 550, 450);
			sopan4.setVisible(true);
		}
		//���� ��ư �̺�Ʈ End
	    
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
