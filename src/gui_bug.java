import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

public class gui_bug {
	
	public storage s;
	
	public void start(storage store)
	{
		s = store;
		System.out.println("ERROR:BUG_DECLARED:GUI:BUG");
		
		Dimension dimension_window = new Dimension(640,480);
		Dimension dimension_top = new Dimension(640,380);
		Dimension dimension_middle = new Dimension(640, 50);
		Dimension dimension_bottom = new Dimension(640, 50);
		Dimension dimension_spacer = new Dimension(128,50);
		Dimension dimension_buttons = new Dimension(128, 50);
		
		JPanel panel_background = new JPanel();
		JPanel panel_top = new JPanel();
		JPanel panel_middle = new JPanel();
		JPanel panel_bottom = new JPanel();
		JPanel panel_spacer_01 = new JPanel();
		JPanel panel_spacer_02 = new JPanel();
		JPanel panel_spacer_03 = new JPanel();
		JPanel panel_send = new JPanel();
		JPanel panel_decline = new JPanel();
		
		JButton button_send = new JButton();
		JButton button_decline = new JButton();
		
		JTextArea text_bug_report = new JTextArea();
		JScrollPane scroll_bug_report = new JScrollPane(text_bug_report);
		
		scroll_bug_report.setPreferredSize(dimension_top);
		
		scroll_bug_report.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll_bug_report.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		panel_background.setPreferredSize(dimension_window);
		panel_top.setPreferredSize(dimension_top);
		panel_middle.setPreferredSize(dimension_middle);
		panel_bottom.setPreferredSize(dimension_bottom);
		panel_spacer_01.setPreferredSize(dimension_spacer);
		panel_spacer_02.setPreferredSize(dimension_spacer);
		panel_spacer_03.setPreferredSize(dimension_spacer);
		panel_send.setPreferredSize(dimension_buttons);
		panel_decline.setPreferredSize(dimension_buttons);
		
		BoxLayout layout_y_axis = new BoxLayout(panel_background, BoxLayout.Y_AXIS);
		BoxLayout layout_x_axis = new BoxLayout(panel_middle, BoxLayout.X_AXIS);
		panel_background.setLayout(layout_y_axis);
		panel_middle.setLayout(layout_x_axis);
		
		
		//panel_background.setLayout(new BoxLayout(panel_background, BoxLayout.Y_AXIS));
		//panel_middle.setLayout(new BoxLayout(panel_middle, BoxLayout.X_AXIS));
		
		// fixes spacing gap exposing panel problem
		FlowLayout fix = new FlowLayout(FlowLayout.CENTER, 0, 0);
		panel_send.setLayout(fix);
		panel_decline.setLayout(fix);
		panel_top.setLayout(fix);
		
		button_send.setPreferredSize(dimension_buttons);
		button_decline.setPreferredSize(dimension_buttons);
		
		button_send.setText("Send Bug Info");
		button_decline.setText("Do Not Send");
		
		/*
		panel_top.setBackground(Color.BLACK);
		panel_middle.setBackground(Color.DARK_GRAY);
		panel_bottom.setBackground(Color.MAGENTA);
		panel_spacer_01.setBackground(Color.WHITE);
		panel_spacer_02.setBackground(Color.GREEN);
		panel_spacer_03.setBackground(Color.ORANGE);
		panel_send.setBackground(Color.PINK);
		panel_decline.setBackground(Color.RED);
		*/
		
		panel_top.add(scroll_bug_report);
		
		panel_decline.add(button_decline);
		panel_send.add(button_send);
		
		panel_middle.add(panel_spacer_01);
		panel_middle.add(panel_send);
		panel_middle.add(panel_spacer_02);		
		panel_middle.add(panel_decline);
		panel_middle.add(panel_spacer_03);
		
		panel_background.add(panel_top);
		panel_background.add(panel_middle);
		panel_background.add(panel_bottom);
		
		JFrame bug_gui = new JFrame();
		
		/* bug example setPreferredSize vs setSize
		bug_gui.setPreferredSize(dimension_window);
		bug_gui.setMaximumSize(dimension_window);
		bug_gui.setMinimumSize(dimension_window);
		*/
		
		bug_gui.setSize(dimension_window);
		
		bug_gui.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		bug_gui.setTitle("Ooops! We found a Bug");
		bug_gui.add(panel_background);
		
		// pack is whitespace bug fix
		bug_gui.pack();
		
		bug_gui.setVisible(true);
	}
}
