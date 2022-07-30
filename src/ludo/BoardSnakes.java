/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ludo;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Dhillon-PC
 */
public class BoardSnakes extends JPanel
{
    BoardSnakes()
    {
        setOpaque(false);
    }
    @Override
    public void paintComponent(Graphics g)
    {
        g.drawRect(10, 10, 820, 620);
        g.drawRect(20, 20, 800, 600);
        for(int j=20;j<600;j=j+60)
        {
        for(int i=20;i<800;i=i+80 )
        {
            Random rand = new Random();
            int red = rand.nextInt(256);
            int green = rand.nextInt(256);
            int blue = rand.nextInt(200);
            Color color = new Color(red,green,blue);
            g.setColor(color);
            g.fillRect(i,j,80,60);
        }
        }
        g.setColor(Color.BLACK);
        for(int j=60;j<600;j=j+60)
        {
            g.drawLine(20, j+20, 820, j+20);
        }
        for(int i=80;i<800;i=i+80 )
        {
            g.drawLine(i+20, 20, i+20, 620);
        }  
        int count=100;
        g.setColor(Color.WHITE);
        for(int j=40;j<600;j=j+60)
        {
        for(int i=50;i<800;i=i+80 )
        {
            g.drawString(String.valueOf(count),i, j);
            count--;
        }
        }
    }
}

