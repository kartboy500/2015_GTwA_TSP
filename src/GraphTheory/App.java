package GraphTheory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.JOptionPane;
/**
 * Write a description of class App here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class App extends Applet implements ActionListener
{
    // instance variables - replace the example below with your own
    private ArrayList<Point> points;
    private ArrayList<Double> degrees;
    private ArrayList<Point> points2;
    private ArrayList<Double> degrees2;
    private ArrayList<Point> pointsE;
    private ArrayList<Double> degreesE;
    private int width = 1000;
    private int height = 1000;
    private SolarDriver s;
    boolean hs1;
    boolean h1;
    boolean hs2;
    boolean h2;
    boolean ex;
    int j;
    int j2;
    int n;
    int xcom;
    int ycom;
    JButton hslow;
    JButton heur;
    JButton hslow2;
    JButton heur2;
    JButton Ex;
    JButton reset;
    Image img;
    Image img2;
    MediaTracker tr;
    /**
     * Constructor for objects of class App
     */
    public void init()
    {
        s = new SolarDriver(300, 300, 15);
        this.setLayout(new BorderLayout());
        points = s.getPoints();
        

        points2 = s.getPoints2();
        pointsE = points;
        xcom = (int) Math.rint(s.COM.getX());
        ycom = (int) Math.rint(s.COM.getY());
        //degrees = s.getAngles();
        degrees2 = new ArrayList<Double>();
        degreesE = new ArrayList<Double>();
        hslow = new JButton("Heuristic 1 Slow");
        heur = new JButton("Heuristic 1");
        reset = new JButton("Reset");
        Ex = new JButton("Exhaustive Search");
        hslow2 = new JButton("Heuristic 2 Slow");
        heur2 = new JButton("Heuristic 2");
        JPanel p = new JPanel();
        JPanel r = new JPanel();
        r.setLayout(new BorderLayout());
        JPanel q = new JPanel();
        p.add(Ex);
        p.add(heur);
        p.add(hslow);
        q.add(heur2);
        q.add(hslow2);
        q.add(reset);
        JLabel label = new JLabel("Rotational Center Heuristic", SwingConstants.CENTER);
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 18));
        //label.setForeground(Color.blue);
        r.add(p,BorderLayout.SOUTH);
        r.add(label,BorderLayout.NORTH);
        this.add(r,BorderLayout.NORTH);
        this.add(q,BorderLayout.SOUTH);
        n =0;
        hs1 = false;
        h1 = false;
        j = 0;
        j2=0;
        width = getSize().width;
        height = getSize().height;
        tr = new MediaTracker(this);
        img = getImage(getCodeBase(), "princefinal.jpg");
        img2 = img.getScaledInstance(30, 41, Image.SCALE_SMOOTH);
        setBackground( Color.black );
        Ex.addActionListener(this);
        hslow.addActionListener(this);
        heur.addActionListener(this);
        hslow2.addActionListener(this);
        heur2.addActionListener(this);
        reset.addActionListener(this);
    }
    private static int DOT_SIZE = 15;
    @Override
    public void paint(Graphics arg0) {
        super.paint(arg0);
        arg0.drawImage(img2, xcom, ycom, this);
        
        for (Point point: points) {
            n++;
            int xCoord = (int)(point.getX());
            int yCoord = (int)(point.getY());
            
            arg0.setColor(Color.blue);
            arg0.fillOval(xCoord, yCoord, DOT_SIZE, DOT_SIZE);
            //arg0.setColor(Color.white);
            //arg0.drawString(""+n,xCoord, yCoord+10 );
            //arg0.drawString("Deg:" + degrees.get(n-1),xCoord, yCoord+20);
            
        }
        n =0;
        if(hs1 == true)
        {
            arg0.setColor(Color.red);
            //int k = j;
            for(int index=0; index<=j; index++)
            {
                if(index<points.size()-1){
                        arg0.drawLine(((int)(points.get(index).getX()))+7,((int)(points.get(index).getY()))+7,((int)(points.get(index+1).getX()))+7,((int)(points.get(index+1).getY()))+7);
                        //j++;
                    }
                    else
                    {
                        //arg0.drawLine(((int)(points.get(index-1).getX()))+7,((int)(points.get(index-1).getY()))+7,((int)(points.get(0).getX()))+7,((int)(points.get(0).getY()))+7);
                        //j =0;
                    }
            }
            
            hs1 = false;
            arg0.setColor(Color.yellow);
            if(j<points.size()-1){
                arg0.drawLine(xcom+15, ycom+20, ((int)(points.get(j+1).getX()))+7, ((int)(points.get(j+1).getY()))+7);
                arg0.drawLine(xcom+16, ycom+21, ((int)(points.get(j+1).getX()))+8, ((int)(points.get(j+1).getY()))+8);
                arg0.drawLine(xcom+14, ycom+19, ((int)(points.get(j+1).getX()))+6, ((int)(points.get(j+1).getY()))+6);
            }
            else
            {
                arg0.drawLine(xcom+15, ycom+20, ((int)(points.get(0).getX()))+7, ((int)(points.get(0).getY()))+7);
                arg0.drawLine(xcom+16, ycom+21, ((int)(points.get(0).getX()))+8, ((int)(points.get(0).getY()))+8);
                arg0.drawLine(xcom+14, ycom+19, ((int)(points.get(0).getX()))+6, ((int)(points.get(0).getY()))+6);
            }
            j++;
            arg0.setColor(Color.white);
            arg0.drawString(""+s.totalLength, 400,400);
        }
        if(hs2 == true)
        {
            arg0.setColor(new Color(255,255,255));
            //int k = j;
            for(int index=0; index<=j2; index++)
            {
                if(index<points2.size()-1){
                        arg0.drawLine(((int)(points2.get(index).getX()))+7,((int)(points2.get(index).getY()))+7,((int)(points2.get(index+1).getX()))+7,((int)(points2.get(index+1).getY()))+7);
                        //j++;
                    }
                    else
                    {
                        arg0.drawLine(((int)(points2.get(index).getX()))+7,((int)(points2.get(index).getY()))+7,((int)(points2.get(0).getX()))+7,((int)(points2.get(0).getY()))+7);
                        //j =0;
                    }
            }
            
            hs2 = false;
            
            arg0.setColor(Color.yellow);
            if(j2<points.size()-1){
                arg0.drawLine(xcom+15, ycom+20, ((int)(points2.get(j2+1).getX()))+7, ((int)(points2.get(j2+1).getY()))+7);
                arg0.drawLine(xcom+16, ycom+21, ((int)(points2.get(j2+1).getX()))+8, ((int)(points2.get(j2+1).getY()))+8);
                arg0.drawLine(xcom+14, ycom+19, ((int)(points2.get(j2+1).getX()))+6, ((int)(points2.get(j2+1).getY()))+6);
            }
            else
            {
                arg0.drawLine(xcom+15, ycom+20, ((int)(points2.get(0).getX()))+7, ((int)(points2.get(0).getY()))+7);
                arg0.drawLine(xcom+16, ycom+21, ((int)(points2.get(0).getX()))+8, ((int)(points2.get(0).getY()))+8);
                arg0.drawLine(xcom+14, ycom+19, ((int)(points2.get(0).getX()))+6, ((int)(points2.get(0).getY()))+6);
            }
            j2++;
            arg0.setColor(Color.white);
            arg0.drawString(""+s.totalLength2, 400,400);
        }
        if(h1 == true)
        {
            arg0.setColor(Color.green);
            for (int i = 0; i<points.size(); i++)
            {
                if(i<points.size()-1){
                    arg0.drawLine(((int)(points.get(i).getX()))+7,((int)(points.get(i).getY()))+7,((int)(points.get(i+1).getX()))+7,((int)(points.get(i+1).getY()))+7);
                }
                else
                {
                    arg0.drawLine(((int)(points.get(i).getX()))+7,((int)(points.get(i).getY()))+7,((int)(points.get(0).getX()))+7,((int)(points.get(0).getY()))+7);
                }
                arg0.setColor(Color.white);
                arg0.drawString(""+s.totalLength, 400,400);
            }
            h1 = false;
            arg0.setColor(Color.white);
            arg0.drawString(""+s.totalLength, 400,400);
        }
        if(h2 == true)
        {
            arg0.setColor(new Color(201,51,230));
            for (int i = 0; i<points2.size(); i++)
            {
                if(i<points.size()-1){
                    arg0.drawLine(((int)(points2.get(i).getX()))+7,((int)(points2.get(i).getY()))+7,((int)(points2.get(i+1).getX()))+7,((int)(points2.get(i+1).getY()))+7);
                }
                else
                {
                    arg0.drawLine(((int)(points2.get(i).getX()))+7,((int)(points2.get(i).getY()))+7,((int)(points2.get(0).getX()))+7,((int)(points2.get(0).getY()))+7);
                }
            }
            h2 = false;
            arg0.setColor(Color.white);
            arg0.drawString(""+s.totalLength2, 400,400);
        }
        if(ex == true)
        {
            arg0.setColor(new Color(255,128,0));
            for (int i = 0; i<pointsE.size(); i++)
            {
                if(i<points.size()-1){
                    arg0.drawLine(((int)(pointsE.get(i).getX()))+7,((int)(pointsE.get(i).getY()))+7,((int)(pointsE.get(i+1).getX()))+7,((int)(pointsE.get(i+1).getY()))+7);
                }
                else
                {
                    arg0.drawLine(((int)(pointsE.get(i).getX()))+7,((int)(pointsE.get(i).getY()))+7,((int)(pointsE.get(0).getX()))+7,((int)(pointsE.get(0).getY()))+7);
                }
            }
            ex = false;
            arg0.setColor(Color.white);
            arg0.drawString(""+s.totalLength3, 400,400);
        }
        
        
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == hslow)
        {
            hs1=true;
        }
        if(arg0.getSource() == heur)
        {
            h1=true;
        }
        if(arg0.getSource() == reset)
        {
            j=0;
            j2=0;
            hs1 = false;
            h1 = false;
            hs2 = false;
            h2 = false;
            ex = false;
        }
        if(arg0.getSource() == hslow2)
        {
            hs2=true;
        }
        if(arg0.getSource() == heur2)
        {
            h2=true;
        }
        if(arg0.getSource() == Ex)
        {
            ex=true;
        }
        repaint();
    }

}
