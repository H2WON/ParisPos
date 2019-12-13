package pos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pos.*;


public class removingAction implements ActionListener {

	JTable ta;
	
	public removingAction(JTable tables) {
		ta = tables;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = ta.getSelectedRow();
		if(row == -1) {
			return;
		}
		DefaultTableModel model = (DefaultTableModel)ta.getModel();
		model.removeRow(row);

	}

}
