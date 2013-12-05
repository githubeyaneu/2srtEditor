package srteditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import srteditor.parser.SrtParser;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;

public class SrtEditor {


	private SrtController rechteController = createSrtPanel("hu.srt");
	private SrtController linkeController = createSrtPanel("en.srt");

	public void start() {
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.add(getPanel());
		jFrame.setSize(1000, 1000);
		jFrame.pack();
		jFrame.setVisible(true);
	}

	private JPanel getPanel() {
		JPanel panel = new JPanel(new FormLayout("pref:grow, pref:grow", "fill:pref, fill:pref:grow, pref"));
		panel.add(upperPanel(), CC.xyw(1, 1, 2));
		panel.add(new JScrollPane(linkeController .getView()), CC.xy(1, 2));
		panel.add(new JScrollPane(rechteController.getView()), CC.xy(2, 2));
		panel.add(buttonPanel(), CC.xyw(1, 3, 2));
		return panel;
	}

	private JPanel buttonPanel() {
		JButton savebutton= new JButton("Save");
		savebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rechteController.save();
				linkeController.save();
			}
		});
		JButton copyTimesButton= new JButton("Times ->");
		JPanel panel = new JPanel();
		panel.add(savebutton);
		panel.add(copyTimesButton);
		return panel;
	}


	private SrtController createSrtPanel(String path) {
		return new SrtController(path);
	}

	private JLabel upperPanel() {
		return new JLabel("1");
	}

}
