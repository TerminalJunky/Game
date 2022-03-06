import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class panel_test {

	JPanel panel;
	storage s;
	
	public void start(storage store)
	{
		s = store;
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		Dimension d = new Dimension();
		d.setSize(720, 990);
		panel.setSize(d);
		panel.setMaximumSize(d);
		panel.setMinimumSize(d);
		//BoxLayout lay = new BoxLayout(panel, BoxLayout.X_AXIS);
		//panel.setLayout(lay);
	}
	public JPanel get_panel()
	{
		return panel;
	}
}
