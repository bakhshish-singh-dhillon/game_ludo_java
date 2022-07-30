/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ludo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Dhillon-PC
 */
public class BoardLudo extends JPanel {
    
    Players pl;
            
    BoardLudo(int count,String name[],String color[]) 
    {
        setLayout(null);
        setOpaque(false);
        pl=new Players(count,name,color);
        add(pl);
    }
    @Override
    @SuppressWarnings("empty-statement")
    public void paintComponent(Graphics g)
    {
     g.setColor(Color.BLACK);
     g.fillRect(10, 10, 680, 680);
     g.setColor(Color.DARK_GRAY);
     g.fillRect(20, 20, 660, 660);
     
     int x=20,y=20;
     g.setColor(Color.BLUE);
     g.fillRect(x, y, 240, 240);
     g.setColor(Color.white);
     g.fillRect(x+20, y+20, 200, 200);
     g.setColor(Color.BLUE);
     g.fillRect(x+50, y+50, 50, 50);
     g.fillRect(x+140, y+50, 50, 50);
     g.fillRect(x+50, y+140, 50, 50);
     g.fillRect(x+140, y+140, 50, 50);
    
     g.fillRect(60, 260, 40, 60);
     for(int i=60;i<260;i=i+40)
     {
         g.fillRect(i, 320, 40, 60);
     }
     
     
     
     x=440;
     g.setColor(Color.red);
     g.fillRect(x, y, 240, 240);
     g.setColor(Color.white);
     g.fillRect(x+20, y+20, 200, 200);
     g.setColor(Color.red);
     g.fillRect(x+50, y+50, 50, 50);
     g.fillRect(x+140, y+50, 50, 50);
     g.fillRect(x+50, y+140, 50, 50);
     g.fillRect(x+140, y+140, 50, 50);
     
     g.fillRect(380, 60, 60, 40);
     for(int i=60;i<260;i=i+40)
     {
         g.fillRect(320, i, 60, 40);
     }
     
     x=20;
     y=440;
     g.setColor(Color.yellow);
     g.fillRect(x, y, 240, 240);
     g.setColor(Color.white);
     g.fillRect(x+20, y+20, 200, 200);
     g.setColor(Color.yellow);
     g.fillRect(x+50, y+50, 50, 50);
     g.fillRect(x+140, y+50, 50, 50);
     g.fillRect(x+50, y+140, 50, 50);
     g.fillRect(x+140, y+140, 50, 50);
     
     g.fillRect(260, 600, 60, 40);
     for(int i=600;i>=440;i=i-40)
     {
         g.fillRect(320, i, 60, 40);
     }
          
     
     x=440;  
     y=440;
     g.setColor(Color.green);
     g.fillRect(x, y, 240, 240);
     g.setColor(Color.white);
     g.fillRect(x+20, y+20, 200, 200);
     g.setColor(Color.green);
     g.fillRect(x+50, y+50, 50, 50);
     g.fillRect(x+140, y+50, 50, 50);
     g.fillRect(x+50, y+140, 50, 50);
     g.fillRect(x+140, y+140, 50, 50);
     
     g.fillRect(600, 380, 40, 60);
     for(int i=600;i>=440;i=i-40)
     {
         g.fillRect(i, 320, 40, 60);
     }      
     
     
     g.setColor(Color.BLACK);
     x=10;
     y=10;
     g.drawRect(x,y, 680, 680);
     g.drawRect(x+10, y+10, 660,660);
     
     g.setColor(Color.black);
     g.drawLine(x+250,y+10,x+250,y+670);
     g.drawLine(x+310, y+10, x+310, y+670);
     g.drawLine(x+370, y+10, x+370, y+670);
     g.drawLine(x+430, y+10, x+430, y+670);
     
     g.drawLine(x+10, y+250, x+670, y+250);
     g.drawLine(x+10, y+310, x+670, y+310);
     g.drawLine(x+10, y+370, x+670, y+370);
     g.drawLine(x+10, y+430, x+670, y+430);
     
     g.setColor(Color.white);
     g.fillRect(260, 260, 180, 180);
     
     g.setColor(Color.black);
     x=20;
     y=260;
     for(int i=1;i<=6;i++)
     {
         g.drawLine(x, y, x, y+180);
         x=x+40;
     }
     x=440;
     y=260;
     for(int i=1;i<=6;i++)
     {
         g.drawLine(x, y, x, y+180);
         x=(x+40);
     }
     
     x=260;
     y=20;
     for(int i=1;i<=6;i++)
     {
         g.drawLine(x, y, x+180, y);
         y=(y+40);
     }
     
     x=260;
     y=440;
     for(int i=1;i<=6;i++)
     {
         g.drawLine(x, y, x+180, y);
         y=(y+40);
     }
     
     {
     g.setColor(Color.blue);
     int a[]={260,350,260,260};
     int b[]={260,350,440,260};
     g.fillPolygon(a, b, 4);
     }
     {
     g.setColor(Color.red);
     int a[]={260,350,440,260};
     int b[]={260,350,260,260};
     g.fillPolygon(a, b, 4);
     }
     {
     g.setColor(Color.green);
     int a[]={440,350,440,440};
     int b[]={440,350,260,440};
     g.fillPolygon(a, b, 4);
     }
     {
     g.setColor(Color.yellow);
     int a[]={440,350,260,440};
     int b[]={440,350,440,440};
     g.fillPolygon(a, b, 4);
     }
    }
}
