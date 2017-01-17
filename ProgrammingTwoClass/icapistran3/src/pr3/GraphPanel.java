package pr3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphPanel extends JPanel {

	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == previous && c != 2) {
				c-=2;
				repaint();
			}
			if (event.getSource() == next && c != graphs.size()-3) {
				c+=2;
				repaint();
			}
		}
	}

	private int xOffset = 50;
	private int yOffset = 100;
	private int labelOffset = 25;
	private int xScale;
	private int yScale;


	int c = 2;
	int cc =1;
	private ArrayList<Graph> graphs;
	private ArrayList<Key> keys;
	private String[] yLabels = null;
	private JButton previous, next;

	public GraphPanel(int xScale, int yScale, int maxX, int maxY) {
		this.xScale = xScale;
		this.yScale = yScale;

		graphs = new ArrayList<Graph>();
		keys = new ArrayList<Key>();

		previous = new JButton("previous");
		next = new JButton("next");
		ButtonListener listener = new ButtonListener();
		previous.addActionListener(listener);
		next.addActionListener(listener);
		add(previous);
		add(next);

		setPreferredSize(new Dimension(xScale * maxX + xOffset, yScale * maxY+ yOffset));

	}

	public void addGraph(Graph graph) {
		graphs.add(graph);
		repaint();
	}

	public void addKey(int x, int y, String label, Color c) {
		keys.add(new Key(x, y, label, c));
		repaint();
	}

	public void setYLabels(String[] labels) {
		yLabels = labels;
		repaint();
	}

	// I doubled the yScale on the for loop that draws out the y labels and I
	// subtracted 100 pixels.

	public void paintComponent(Graphics g) {
		Dimension size = getSize();

		g.setColor(Color.white);
		g.fillRect(0, 0, size.width, size.height);
		g.setColor(Color.black);
		g.drawLine(0, size.height - yOffset, size.width, size.height - yOffset);
		g.drawLine(xOffset, 0, xOffset, size.height);
		drawHorizontalGrid(g, size.width, size.height);
		g.setColor(Color.black);
		if (yLabels != null)
			for (int i = 0; i < yLabels.length; i++)
				if (yLabels[i] != null)
					g.drawString(yLabels[i], xOffset - labelOffset, size.height
							- (i * yScale * 2 + yOffset) - 100);
		graphs.get(0).draw(g, size.height, xScale, yScale, xOffset, yOffset);
		graphs.get(1).draw(g, size.height, xScale, yScale, xOffset, yOffset);
		graphs.get(c).draw(g, size.height, xScale, yScale, xOffset, yOffset);
		graphs.get(c+cc).draw(g, size.height, xScale, yScale, xOffset, yOffset);
		//graphs.get(graphs.size()-3).draw(g, size.height, xScale, yScale, xOffset, yOffset);
		//graphs.get(graphs.size()-2).draw(g, size.height, xScale, yScale, xOffset, yOffset);
		graphs.get(graphs.size()-1).draw(g, size.height, xScale, yScale, xOffset, yOffset);
		//}
		//		for (int i = 0; i < graphs.size(); i++)
		//			graphs.get(i)
		//			.draw(g, size.height, xScale, yScale, xOffset, yOffset);
		//
				for (int i = 0; i < keys.size(); i++)
					drawKey(g, keys.get(i), size.height);

	}

	private void drawHorizontalGrid(Graphics g, int w, int h) {
		int deltaY = 1;
		g.setColor(Color.lightGray);
		int gridY = h - (yOffset + deltaY * yScale);
		while (gridY > 0) {
			g.drawLine(xOffset, gridY, w, gridY);
			gridY -= deltaY * yScale;
		}
	}

	private void drawKey(Graphics g, Key key, int height) {
		int x = key.getX() + xOffset;
		int y = height - yOffset + key.getY();
		g.setColor(key.getColor());
		g.fillRect(x, y, 10, 10);
		g.setColor(Color.black);
		g.drawString(key.getLabel(), x , y);
	}


	

}
