import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class OLD_panel_launcher {

	/*
	storage s;
	JPanel background;
	JPanel row_0;
	JPanel row_1;
	JPanel row_2;
	JPanel row_3;
	JPanel row_4;
	
	JPanel gap_0;
	JPanel gap_1;
	JPanel gap_2;
	JPanel gap_3;
	JPanel gap_4;
	JPanel gap_5;
	JPanel gap_6;
	
	JPanel spacer_left_0;
	JPanel spacer_left_1;
	JPanel spacer_left_2;
	JPanel spacer_left_3;
	JPanel spacer_left_4;
	
	JPanel spacer_right_0;
	JPanel spacer_right_1;
	JPanel spacer_right_2;
	JPanel spacer_right_3;
	JPanel spacer_right_4;
	
	JPanel bottom;
	
	public void start(storage store)
	{
		s = store;
		s.debug.message("panel_launcher:start");
		create_panels();
		set_dimensions();
		load_panels();
	}
	public void create_panels()
	{
		background = new JPanel();
		
		row_0 = new JPanel();
		row_1 = new JPanel();
		row_2 = new JPanel();
		row_3 = new JPanel();
		row_4 = new JPanel();
		
		gap_0 = new JPanel();
		gap_1 = new JPanel();
		gap_2 = new JPanel();
		gap_3 = new JPanel();
		gap_4 = new JPanel();
		gap_5 = new JPanel();
		gap_6 = new JPanel();
		
		spacer_left_0 = new JPanel();
		spacer_left_1 = new JPanel();
		spacer_left_2 = new JPanel();
		spacer_left_3 = new JPanel();
		spacer_left_4 = new JPanel();
		
		spacer_right_0 = new JPanel();
		spacer_right_1 = new JPanel();
		spacer_right_2 = new JPanel();
		spacer_right_3 = new JPanel();
		spacer_right_4 = new JPanel();
		
		bottom = new JPanel();
	}
	public void set_dimensions()
	{
		background.setPreferredSize(s.dimension.launcher.background);
		background.setMinimumSize(s.dimension.launcher.background);
		background.setMaximumSize(s.dimension.launcher.background);
		
		row_0.setPreferredSize(s.dimension.launcher.row);
		row_0.setMinimumSize(s.dimension.launcher.row);
		row_0.setMaximumSize(s.dimension.launcher.row);
		
		row_1.setPreferredSize(s.dimension.launcher.row);
		row_1.setMinimumSize(s.dimension.launcher.row);
		row_1.setMaximumSize(s.dimension.launcher.row);
		
		row_2.setPreferredSize(s.dimension.launcher.row);
		row_2.setMinimumSize(s.dimension.launcher.row);
		row_2.setMaximumSize(s.dimension.launcher.row);
		
		row_3.setPreferredSize(s.dimension.launcher.row);
		row_3.setMinimumSize(s.dimension.launcher.row);
		row_3.setMaximumSize(s.dimension.launcher.row);
		
		row_4.setPreferredSize(s.dimension.launcher.row);
		row_4.setMinimumSize(s.dimension.launcher.row);
		row_4.setMaximumSize(s.dimension.launcher.row);
		
		gap_0.setPreferredSize(s.dimension.launcher.gaps);
		gap_0.setMinimumSize(s.dimension.launcher.gaps);
		gap_0.setMaximumSize(s.dimension.launcher.gaps);
		
		gap_1.setPreferredSize(s.dimension.launcher.gaps);
		gap_1.setMinimumSize(s.dimension.launcher.gaps);
		gap_1.setMaximumSize(s.dimension.launcher.gaps);
		
		gap_2.setPreferredSize(s.dimension.launcher.gaps);
		gap_2.setMinimumSize(s.dimension.launcher.gaps);
		gap_2.setMaximumSize(s.dimension.launcher.gaps);
		
		gap_3.setPreferredSize(s.dimension.launcher.gaps);
		gap_3.setMinimumSize(s.dimension.launcher.gaps);
		gap_3.setMaximumSize(s.dimension.launcher.gaps);
		
		gap_4.setPreferredSize(s.dimension.launcher.gaps);
		gap_4.setMinimumSize(s.dimension.launcher.gaps);
		gap_4.setMaximumSize(s.dimension.launcher.gaps);
		
		gap_5.setPreferredSize(s.dimension.launcher.gaps);
		gap_5.setMinimumSize(s.dimension.launcher.gaps);
		gap_5.setMaximumSize(s.dimension.launcher.gaps);

		gap_6.setPreferredSize(s.dimension.launcher.gaps);
		gap_6.setMinimumSize(s.dimension.launcher.gaps);
		gap_6.setMaximumSize(s.dimension.launcher.gaps);
		
		spacer_left_0.setPreferredSize(s.dimension.launcher.spacers);
		spacer_left_0.setMinimumSize(s.dimension.launcher.spacers);
		spacer_left_0.setMaximumSize(s.dimension.launcher.spacers);
		
		spacer_left_1.setPreferredSize(s.dimension.launcher.spacers);
		spacer_left_1.setMinimumSize(s.dimension.launcher.spacers);
		spacer_left_1.setMaximumSize(s.dimension.launcher.spacers);
		
		spacer_left_2.setPreferredSize(s.dimension.launcher.spacers);
		spacer_left_2.setMinimumSize(s.dimension.launcher.spacers);
		spacer_left_2.setMaximumSize(s.dimension.launcher.spacers);
		
		spacer_left_3.setPreferredSize(s.dimension.launcher.spacers);
		spacer_left_3.setMinimumSize(s.dimension.launcher.spacers);
		spacer_left_3.setMaximumSize(s.dimension.launcher.spacers);
		
		spacer_left_4.setPreferredSize(s.dimension.launcher.spacers);
		spacer_left_4.setMinimumSize(s.dimension.launcher.spacers);
		spacer_left_4.setMaximumSize(s.dimension.launcher.spacers);
		
		spacer_right_0.setPreferredSize(s.dimension.launcher.spacers);
		spacer_right_0.setMinimumSize(s.dimension.launcher.spacers);
		spacer_right_0.setMaximumSize(s.dimension.launcher.spacers);
		
		spacer_right_1.setPreferredSize(s.dimension.launcher.spacers);
		spacer_right_1.setMinimumSize(s.dimension.launcher.spacers);
		spacer_right_1.setMaximumSize(s.dimension.launcher.spacers);
		
		spacer_right_2.setPreferredSize(s.dimension.launcher.spacers);
		spacer_right_2.setMinimumSize(s.dimension.launcher.spacers);
		spacer_right_2.setMaximumSize(s.dimension.launcher.spacers);
		
		spacer_right_3.setPreferredSize(s.dimension.launcher.spacers);
		spacer_right_3.setMinimumSize(s.dimension.launcher.spacers);
		spacer_right_3.setMaximumSize(s.dimension.launcher.spacers);
		
		spacer_right_4.setPreferredSize(s.dimension.launcher.spacers);
		spacer_right_4.setMinimumSize(s.dimension.launcher.spacers);
		spacer_right_4.setMaximumSize(s.dimension.launcher.spacers);
		
		bottom.setPreferredSize(s.dimension.launcher.bottom);
		bottom.setMinimumSize(s.dimension.launcher.bottom);
		bottom.setMaximumSize(s.dimension.launcher.bottom);
	}
	public void load_panels()
	{	
		BoxLayout layout_y_axis = new BoxLayout(background, BoxLayout.Y_AXIS);
		
		BoxLayout row_0_layout = new BoxLayout(row_0, BoxLayout.X_AXIS);
		BoxLayout row_1_layout = new BoxLayout(row_1, BoxLayout.X_AXIS);
		BoxLayout row_2_layout = new BoxLayout(row_2, BoxLayout.X_AXIS);
		BoxLayout row_3_layout = new BoxLayout(row_3, BoxLayout.X_AXIS);
		BoxLayout row_4_layout = new BoxLayout(row_4, BoxLayout.X_AXIS);
		
		BoxLayout bottom_layout = new BoxLayout(bottom, BoxLayout.X_AXIS);
		
		background.setLayout(layout_y_axis);
		row_0.setLayout(row_0_layout);
		row_1.setLayout(row_1_layout);
		row_2.setLayout(row_2_layout);
		row_3.setLayout(row_3_layout);
		row_4.setLayout(row_4_layout);
		bottom.setLayout(bottom_layout);
		
		row_0.add(spacer_left_0);
		row_0.add(s.dashboard.launcher.button_new);
		row_0.add(spacer_right_0);
		
		row_1.add(spacer_left_1);
		row_1.add(s.dashboard.launcher.button_load);
		row_1.add(spacer_right_1);
		
		row_2.add(spacer_left_2);
		row_2.add(s.dashboard.launcher.button_mods);
		row_2.add(spacer_right_2);
		
		row_3.add(spacer_left_3);
		row_3.add(s.dashboard.launcher.button_mod_tools);
		row_3.add(spacer_right_3);
		
		row_4.add(spacer_left_4);
		row_4.add(s.dashboard.launcher.button_settings);
		row_4.add(spacer_right_4);
		
		bottom.add(s.dashboard.launcher.label_language);
		bottom.add(s.dashboard.launcher.drop_language);
		bottom.add(s.dashboard.launcher.label_version);
		bottom.add(s.dashboard.launcher.drop_version);

		background.add(gap_0);
		background.add(row_0);
		background.add(gap_1);
		background.add(row_1);
		background.add(gap_2);
		background.add(row_2);
		background.add(gap_3);
		background.add(row_3);
		background.add(gap_4);
		background.add(row_4);
		background.add(gap_5);
		background.add(bottom);
		background.add(gap_6);
	}
	*/
}