import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.applet.*;
import java.net.*;
import java.util.*;


public class myJPanel extends JPanel implements ActionListener, MouseMotionListener
{
    JButton ColorRed, ColorBlack, ColorYellow, ColorWhite, BrushThicker, BrushThinner, XCoord, YCoord;
    JLabel labelx, labely;
    Color c = Color.black;
    Point[] ps = new Point[1000];
    Color[] colors = new Color[1000];
    Integer[] thicknessArray = new Integer[1000];
//    ArrayList<Point> points = new ArrayList();
//    ArrayList<Color> colors = new ArrayList();
//    ArrayList<Integer> thicknessArray = new ArrayList();
    int i = 0;
    int thickness = 5;
    JPanel p1, p2;
    public myJPanel()
    {
        super();
        setBackground(Color.white);
        setLayout(new BorderLayout());
        addMouseMotionListener(this);
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,2));
        p2 = new JPanel();
        p2.setLayout(new GridLayout(13,1));
        add(p1, "South");
        add(p2, "East");
        labelx = new JLabel("X: ");
        labely = new JLabel("Y: ");
        p2.add(labelx);
        p2.add(labely);
        BrushThicker = new JButton("Thicker");
        BrushThinner = new JButton("Thinner");
        p1.add(BrushThicker);
        p1.add(BrushThinner);
        BrushThicker.addActionListener(this);
        BrushThinner.addActionListener(this);
        ColorRed = new JButton("Red");
        ColorYellow = new JButton("Yellow");
        ColorBlack = new JButton("Black");
        ColorWhite = new JButton("Eraser");
        p2.add(ColorRed);
        ColorRed.addActionListener(this);
        p2.add(ColorYellow);
        ColorYellow.addActionListener(this);
        p2.add(ColorBlack);
        ColorBlack.addActionListener(this);
        p2.add(ColorWhite);
        ColorWhite.addActionListener(this);
//                repaint();
//        validate();
    }
 
    public void paintComponent (Graphics gg)
    {
       super.paintComponent(gg);
               
       for (int j = 0; j<i; j++)
       {
            gg.setColor(colors[j]);
            gg.fillRect(ps[j].x,ps[j].y, thicknessArray[j], thicknessArray[j]);
       }
    }   
    
    @Override
    
    public void actionPerformed(ActionEvent ae) 
    {
        Object obj = ae.getSource();
        if(obj == BrushThicker)
        {
            thickness=thickness+5;
        }
        if(obj == BrushThinner)
        {
            thickness=thickness-5;
        }
        if(obj == ColorRed)
        {
            c = Color.red;
        }
        if(obj == ColorBlack)
        {
            c = Color.black;
        }
        if(obj == ColorYellow)
        {
            c = Color.yellow;
        }
        if(obj == ColorWhite)
        {
            c = Color.white;
        }
    }

    @Override
    public void mouseDragged(MouseEvent evt) 
    {
    
        Point pt = evt.getPoint();

           
        ps[i] = pt;
        colors[i] = c;
        thicknessArray[i] = thickness;
        i++;
      repaint();
        String t1 = "x = " + pt.getX();
        labelx.setText(t1);
        String t2 = "y = " + pt.getY();
        labely.setText(t2);

    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {
        Point pt = e.getPoint();
        String t1 = "x = " + pt.getX();
        labelx.setText(t1);
        String t2 = "y = " + pt.getY();
        labely.setText(t2);
    }


    
}
