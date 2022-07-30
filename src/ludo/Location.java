/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ludo;

import javax.swing.JOptionPane;

/**
 *
 * @author Dhillon-PC
 */
public class Location {

    int x[]=new int[77];
    int y[]=new int[77];
    int countX,countY,count=0;
    
    public Location(int start) 
    {
        int i=0;
        int x=17;
        int y=257;
        while(i<5)
        {
            x=x+40;
            this.x[i]=x;
            this.y[i]=y+8;
            i++;
        }
        x=x+40;
        while(i<11)
        {
            y=y-40;
            this.x[i]=x+8;
            this.y[i]=y;
            i++;
        }
        while(i<13)
        {
            x=x+60;
            this.x[i]=x+8;
            this.y[i]=y;
            i++;
        }
        while(i<18)
        {
            y=y+40;
            this.x[i]=x+8;
            this.y[i]=y;
            i++;
        }
        y=y+40;
        x=x+20;
        while(i<24)
        {
            x=x+40;
            this.x[i]=x;
            this.y[i]=y+8;
            i++;
        }
        while(i<26)
        {
            y=y+60;
            this.x[i]=x;
            this.y[i]=y+8;
            i++;
        }
        while(i<31)
        {
            x=x-40;
            this.x[i]=x;
            this.y[i]=y+8;
            i++;
        }
        x=x-60;
        y=y+20;
        while(i<37)
        {
            y=y+40;
            this.x[i]=x+8;
            this.y[i]=y;
            i++;
        }
        while(i<39)
        {
            x=x-60;
            this.x[i]=x+8;
            this.y[i]=y;
            i++;
        }
        while(i<44)
        {
            y=y-40;
            this.x[i]=x+8;
            this.y[i]=y;
            i++;
        }
        y=y-60;
        while(i<50)
        {
            x=x-40;
            this.x[i]=x;
            this.y[i]=y+8;
            i++;
        }
        while(i<52)
        {
            y=y-60;
            this.x[i]=x;
            this.y[i]=y+8;
            i++;
        }
        
        x=57;
        y=317;
        while(i<58)
        {
            this.x[i]=x;
            this.y[i]=y+8;
            i++;
            x=x+40;
        }
        x=317;
        y=57;
        while(i<64)
        {
            this.x[i]=x+8;
            this.y[i]=y;
            i++;
            y=y+40;
        }
        x=597;
        y=317;
        while(i<70)
        {
            this.x[i]=x;
            this.y[i]=y+8;
            i++;
            x=x-40;
        }
        x=317;
        y=597;
        while(i<76)
        {
            this.x[i]=x+8;
            this.y[i]=y;
            i++;
            y=y-40;
        }
        for(i=0;i<53;i++)
        {
            System.out.println(i+"."+"x="+this.x[i]+" y="+this.y[i]);
        }
        countX=start;
        countY=start;
        
        
    }
    
    public void setPosition(int steps) 
    {
        if((countX+steps)>51)
        {
            countX=(countX+steps)-52;
            countY=(countY+steps)-52;
            count=count+steps;
        }
        else
        {
        countX=countX+steps;
        countY=countY+steps;
        count=count+steps;
        }
    }
    public int getX()
    {
        return(x[countX]);   
    }
    public int getY()
    {
        return(y[countY]);
    }
    public void resetCounts(int start)
    {
        countX=start;
        countY=start;
        count=0;
    }
    public int getCount()
    {
        return (count);
    }
    
    public int setHouse(int steps,int count) 
    {
        countX=steps;
        countY=steps;
        this.count=this.count+count;
        if(this.count==56)
        {
            JOptionPane.showMessageDialog(null,"Token is in House");
            return 1;
        }
        return 0;
    }
}
    
