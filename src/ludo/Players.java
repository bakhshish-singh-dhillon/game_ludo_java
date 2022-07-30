/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ludo;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Dhillon-PC
 */
public class Players extends JPanel implements ActionListener{
    
        final int RedHash=-65536;
        final int BlueHash=-16776961;
        final int YellowHash=-256;
        final int GreenHash=-16711936;
        final int RedStart=13;
        final int BlueStart=0;
        final int YellowStart=39;
        final int GreenStart=26;
        final int Safe[]=new int[8];
        
        int number=0;
        
        int x=20,y=20,c=0;
       
        int count;

        int playerNum=0;
        
        JButton R[]=new JButton[4];
        JButton G[]=new JButton[4];
        JButton B[]=new JButton[4];
        JButton Y[]=new JButton[4];
        JButton Dice=new JButton();
        
        JLabel LblName[]=new JLabel[4];   
        
        Random rand=new Random();
        
        
        Location bPosition[]=new Location[4];
        Location rPosition[]=new Location[4];;
        Location gPosition[]=new Location[4];;
        Location yPosition[]=new Location[4];;
        
        Color DiceColor[]=new Color[4];
        
        String color[]=new String[4];
        
        int rHouse=0,bHouse=0,yHouse=0,gHouse=0,rank=1;
        
        
    Players(int count,String name[],String color[])
    {
        this.count=count;
        this.color=color;
        Dice.addActionListener(this);
        Dice.setBounds(750, 420, 50, 50);
        Dice.setForeground(Color.WHITE);
        Dice.setFont(new Font("Arial", Font.PLAIN, 20));
        Dice.setFocusPainted(false);
        add(Dice);
        setLayout(null);
        setOpaque(false);
        setBounds(0, 0, 900, 800);
        
        for(int i=0;i<count;i++)
        {
            switch(color[i])
            {
                case "Blue":
                {
                initBlue(name[i],i);
                break;
                }
                case "Red":
                {
                initRed(name[i],i);
                break;
                }
                case "Yellow":
                {
                initYellow(name[i],i);
                break;
                }
                case "Green":
                {
                initGreen(name[i],i);
                break;
                }
            }
        }
        for(int i=0,j=0;i<8;i=i+2)
        {
            Safe[i]=j;
            Safe[i+1]=j+8;
            j=j+13;
        }
        for(int i=0;i<8;i++)
        {
            JButton safe=new JButton();
            safe.setOpaque(false);
            safe.setContentAreaFilled(false);
            safe.setBorderPainted(false);
            ImageIcon img;
            if(i%2==0)
            {
            img=new ImageIcon(getClass().getResource("../pics/ludo/"+((i+2)/2)+".png"));
            }
            else
            {
            img=new ImageIcon(getClass().getResource("../pics/ludo/safe.png"));
            }
            safe.setIcon(img);
            safe.setEnabled(true);
            safe.setDisabledIcon(img);
            safe.setBackground(Color.GRAY);
            safe.setBounds(new Location(0).x[Safe[i]]+4,new Location(0).y[Safe[i]]+4,38,38);
            add(safe);
        }
    }   
    
    public void initBlue(String name,int count)
    {
        x=20;
        y=20;
        bPosition[0]=new Location(BlueStart);
        bPosition[1]=new Location(BlueStart);
        bPosition[2]=new Location(BlueStart);
        bPosition[3]=new Location(BlueStart);
        DiceColor[count]=Color.BLUE;
        LblName[0]=new JLabel(name);
        LblName[0].setVisible(true);
        LblName[0].setBounds(x+60,y+10,150,30);
        add(LblName[0]);
        ImageIcon img=new ImageIcon(getClass().getResource("../pics/ludo/Blue.png"));
        for(int i=0;i<4;i++)
        {
        B[i]=new JButton();
        B[i].setOpaque(false);
        B[i].setContentAreaFilled(false);
        B[i].setBorderPainted(false);
        B[i].setIcon(img);
        B[i].setEnabled(false);
        B[i].setDisabledIcon(img);
        B[i].setActionCommand(""+i);
        B[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveBlue(Integer.parseInt(e.getActionCommand()));
            }});
        add(B[i]);
        }
        
        B[0].setBounds(x+50, y+50, 50, 50);
        B[1].setBounds(x+140, y+50, 50, 50);
        B[2].setBounds(x+50, y+140, 50, 50);
        B[3].setBounds(x+140, y+140, 50, 50);
        
        for(int i=0;i<4;i++)
        {
            bPosition[i].x[76]=B[i].getX();
            bPosition[i].y[76]=B[i].getY();
        }
        
    }
    
    public void initRed(String name,int count)
    {
        x=440;
        y=20;
        rPosition[0]=new Location(RedStart);
        rPosition[1]=new Location(RedStart);
        rPosition[2]=new Location(RedStart);
        rPosition[3]=new Location(RedStart);
        DiceColor[count]=Color.RED;
        LblName[1]=new JLabel(name);
        LblName[1].setVisible(true);
        LblName[1].setBounds(x+60,y+10,150,30);
        add(LblName[1]);
        ImageIcon img=new ImageIcon(getClass().getResource("../pics/ludo/Red.png"));       
        for(int i=0;i<4;i++)
        {
        R[i]=new JButton();
        R[i].setOpaque(false);
        R[i].setContentAreaFilled(false);
        R[i].setBorderPainted(false);
        R[i].setIcon(img);
        R[i].setEnabled(false);
        R[i].setDisabledIcon(img);
        R[i].setActionCommand(""+i);
        R[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveRed(Integer.parseInt(e.getActionCommand()));
            }});
        add(R[i]);
        }
        
        R[0].setBounds(x+50, y+50, 50, 50);
        R[1].setBounds(x+140, y+50, 50, 50);
        R[2].setBounds(x+50, y+140, 50, 50);
        R[3].setBounds(x+140, y+140, 50, 50);
        
        for(int i=0;i<4;i++)
        {
            rPosition[i].x[76]=R[i].getX();
            rPosition[i].y[76]=R[i].getY();
        }
        
    }
    
    public void initGreen(String name,int count)
    {
        x=440;
        y=440;
        gPosition[0]=new Location(GreenStart);
        gPosition[1]=new Location(GreenStart);
        gPosition[2]=new Location(GreenStart);
        gPosition[3]=new Location(GreenStart);
        DiceColor[count]=Color.GREEN;
        LblName[2]=new JLabel(name);
        LblName[2].setVisible(true);
        LblName[2].setBounds(x+60,y+10,150,30);
        add(LblName[2]);
        ImageIcon img=new ImageIcon(getClass().getResource("../pics/ludo/Green.png"));
        for(int i=0;i<4;i++)
        {
        G[i]=new JButton();
        G[i].setOpaque(false);
        G[i].setContentAreaFilled(false);
        G[i].setBorderPainted(false);
        G[i].setIcon(img);
        G[i].setEnabled(false);
        G[i].setDisabledIcon(img);
        G[i].setActionCommand(""+i);
        G[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveGreen(Integer.parseInt(e.getActionCommand()));
            }});
        add(G[i]);
        }
        
        G[0].setBounds(x+50, y+50, 50, 50);
        G[1].setBounds(x+140, y+50, 50, 50);
        G[2].setBounds(x+50, y+140, 50, 50);
        G[3].setBounds(x+140, y+140, 50, 50);
        
        for(int i=0;i<4;i++)
        {
            gPosition[i].x[76]=G[i].getX();
            gPosition[i].y[76]=G[i].getY();
        }
    }
    
    public void initYellow(String name,int count)
    {
        x=20;
        y=440;
        yPosition[0]=new Location(YellowStart);
        yPosition[1]=new Location(YellowStart);
        yPosition[2]=new Location(YellowStart);
        yPosition[3]=new Location(YellowStart);
        DiceColor[count]=Color.YELLOW;
        LblName[3]=new JLabel(name);
        LblName[3].setVisible(true);
        LblName[3].setBounds(x+60,y+10,150,30);
        add(LblName[3]);
        ImageIcon img=new ImageIcon(getClass().getResource("../pics/ludo/Yellow.png"));
        for(int i=0;i<4;i++)
        {
        Y[i]=new JButton();
        Y[i].setOpaque(false);
        Y[i].setContentAreaFilled(false);
        Y[i].setBorderPainted(false);
        Y[i].setIcon(img);
        Y[i].setEnabled(false);
        Y[i].setDisabledIcon(img);
        Y[i].setActionCommand(""+i);
        Y[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveYellow(Integer.parseInt(e.getActionCommand()));
            }});
        add(Y[i]);
        }
        
        Y[0].setBounds(x+50, y+50, 50, 50);
        Y[1].setBounds(x+140, y+50, 50, 50);
        Y[2].setBounds(x+50, y+140, 50, 50);
        Y[3].setBounds(x+140, y+140, 50, 50);
       
        for(int i=0;i<4;i++)
        {
            yPosition[i].x[76]=Y[i].getX();
            yPosition[i].y[76]=Y[i].getY();
        }
    }

        @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==Dice)
        {
        if(number==6)
        {
            playerNum--;
        }
        if(playerNum==count)
        {
            playerNum=0;
        }
        Dice.setBackground(DiceColor[playerNum]);
        number=rand.nextInt(6)+1;
        Dice.setText(String.valueOf(number));
        Dice.setEnabled(false);
        move();
        playerNum++;
        checkWinner();
        }
    }
    
    public void move()
    {
        switch(Dice.getBackground().hashCode())
        {
            case RedHash:
            {
                if(number==6)
                {
                    for(int i=0;i<4;i++)
                    {
                        R[i].setEnabled(true);
                    }
                }
                else 
                {
                    int flag=0;
                    for(int i=0;i<4;i++)
                    {
                        if((R[i].getX()!=rPosition[i].x[76]) && (R[i].getY()!=rPosition[i].y[76]))
                        {
                         R[i].setEnabled(true);
                         flag++;
                        }
                    }
                    if(flag==0)
                    {
                        Dice.setEnabled(true);
                    }
                }
                break;
            }
            case YellowHash:
            {
                if(number==6)
                {
                    for(int i=0;i<4;i++)
                    {
                        Y[i].setEnabled(true);
                    }
                }
                else
                {
                    int flag=0;
                    for(int i=0;i<4;i++)
                    {
                        if((Y[i].getX()!=yPosition[i].x[76]) && (Y[i].getY()!=yPosition[i].y[76]))
                        {
                         Y[i].setEnabled(true);
                         flag++;
                        }
                    }
                    if(flag==0)
                    {
                        Dice.setEnabled(true);
                    }
                }
                break;
            }
            case GreenHash:
            {
                if(number==6)
                {
                    for(int i=0;i<4;i++)
                    {
                        G[i].setEnabled(true);
                    }
                }
                else
                {
                    int flag=0;
                    for(int i=0;i<4;i++)
                    {
                        if((G[i].getX()!=gPosition[i].x[76]) && (G[i].getY()!=gPosition[i].y[76]))
                        {
                         G[i].setEnabled(true);
                         flag++;
                        }
                    }
                    if(flag==0)
                    {
                        Dice.setEnabled(true);
                    }
                }
                break;
            }
            case BlueHash:
            {
                if(number==6)
                {
                    for(int i=0;i<4;i++)
                    {
                        B[i].setEnabled(true);
                    }
                }
                else
                {
                    int flag=0;
                    for(int i=0;i<4;i++)
                    {
                        if((B[i].getX()!=bPosition[i].x[76]) && (B[i].getY()!=bPosition[i].y[76]))
                        {
                         B[i].setEnabled(true);
                         flag++;
                        }
                    }
                    if(flag==0)
                    {
                        Dice.setEnabled(true);
                    }
                }
                break;
            }
        }
    }
    
    public void moveRed(int i)
    {
        if((R[i].getX()==rPosition[i].x[76]) && (R[i].getY()==rPosition[i].y[76]))
        {
            R[i].setLocation(rPosition[i].getX(), rPosition[i].getY());
        }
        else
        {
            if(rPosition[i].getCount()+number>50)
            {
                int futurePosition=57+((rPosition[i].getCount()+number)-50);
                if(futurePosition<64)
                {
                    rHouse=rHouse+rPosition[i].setHouse(futurePosition,number);
                    R[i].setLocation(rPosition[i].getX(), rPosition[i].getY());
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Token Can't Move");
                }
            }
            else
            {
                rPosition[i].setPosition(number);
                R[i].setLocation(rPosition[i].getX(), rPosition[i].getY());
            }
        }
        checkReset(rPosition[i].getX(),rPosition[i].getY());
        disableRed();
        Dice.setEnabled(true);
    }
    public void moveBlue(int i)
    {
        if((B[i].getX()==bPosition[i].x[76]) && (B[i].getY()==bPosition[i].y[76]))
        {
            B[i].setLocation(bPosition[i].getX(), bPosition[i].getY());
        }
        else
        {
            if(bPosition[i].getCount()+number>50)
            {
                int futurePosition=51+((bPosition[i].getCount()+number)-50);
                if(futurePosition<58)
                {
                    bHouse=bHouse+bPosition[i].setHouse(futurePosition,number);
                    B[i].setLocation(bPosition[i].getX(), bPosition[i].getY());
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Token Can't Move");
                }
            }
            else
            {
                bPosition[i].setPosition(number);
                B[i].setLocation(bPosition[i].getX(), bPosition[i].getY());
            }
        }
        checkReset(bPosition[i].getX(),bPosition[i].getY());        
        disableBlue();
        Dice.setEnabled(true);
    }
    public void moveYellow(int i)
    {
        if((Y[i].getX()==yPosition[i].x[76]) && (Y[i].getY()==yPosition[i].y[76]))
        {
            Y[i].setLocation(yPosition[i].getX(), yPosition[i].getY());
        }
        else
        {
            if(yPosition[i].getCount()+number>50)
            {
                int futurePosition=69+((yPosition[i].getCount()+number)-50);
                if(futurePosition<77)
                {
                    yHouse=yHouse+yPosition[i].setHouse(futurePosition,number);
                    Y[i].setLocation(yPosition[i].getX(), yPosition[i].getY());
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Token Can't Move");
                }
            }
            else
            {
                yPosition[i].setPosition(number);
                Y[i].setLocation(yPosition[i].getX(), yPosition[i].getY());
            }
        }
        checkReset(yPosition[i].getX(),yPosition[i].getY());
        disableYellow();
        Dice.setEnabled(true);
    }
    public void moveGreen(int i)
    {
        if((G[i].getX()==gPosition[i].x[76]) && (G[i].getY()==gPosition[i].y[76]))
        {
            G[i].setLocation(gPosition[i].getX(), gPosition[i].getY());
        }
        else
        {
            if(gPosition[i].getCount()+number>50)
            {
                int futurePosition=63+((gPosition[i].getCount()+number)-50);
                if(futurePosition<70)
                {
                    gHouse=gHouse+gPosition[i].setHouse(futurePosition,number);
                    G[i].setLocation(gPosition[i].getX(), gPosition[i].getY());
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Token Can't Move");
                }
            }
            else
            {
                gPosition[i].setPosition(number);
                G[i].setLocation(gPosition[i].getX(), gPosition[i].getY());
            }
        }
        checkReset(gPosition[i].getX(),gPosition[i].getY());
        disableGreen();
        Dice.setEnabled(true);
    }
    
    public void disableRed()
    {
        for(int i=0;i<4;i++)
        {
            R[i].setEnabled(false);
        }
    }
    public void disableGreen()
    {
        for(int i=0;i<4;i++)
        {
            G[i].setEnabled(false);
        }
    }
    public void disableBlue()
    {
        for(int i=0;i<4;i++)
        {
            B[i].setEnabled(false);
        }
    }
    public void disableYellow()
    {
        for(int i=0;i<4;i++)
        {            
            Y[i].setEnabled(false);
        }
    }
    public void checkReset(int x,int y)
    {
        for(int i=0;i<count;i++)
        {
            if(DiceColor[i].hashCode()==DiceColor[playerNum-1].hashCode())
            {
                continue;
            }
            for(int j=0;j<4;j++)
            {
            switch(color[i])
            {
                case "Red":
                {
                    if(rPosition[j].getX()==x && rPosition[j].getY()==y)
                    {
                        rPosition[j].resetCounts(RedStart);
                        R[j].setLocation(rPosition[j].x[76], rPosition[j].y[76]);
                    }
                    break;
                }
                case "Blue":
                {            
                    if(bPosition[j].getX()==x && bPosition[j].getY()==y)
                    {
                        bPosition[j].resetCounts(BlueStart);
                        B[j].setLocation(bPosition[j].x[76], bPosition[j].y[76]);
                    }
                    break;
                }
                case "Yellow":
                {
                    if(yPosition[j].getX()==x && yPosition[j].getY()==y)
                    {
                        yPosition[j].resetCounts(YellowStart);
                        Y[j].setLocation(yPosition[j].x[76], yPosition[j].y[76]);
                    }
                    break;
                }
                case "Green":
                {
                    if(gPosition[j].getX()==x && gPosition[j].getY()==y)
                    {
                        gPosition[j].resetCounts(GreenStart);
                        G[j].setLocation(gPosition[j].x[76], gPosition[j].y[76]);
                    }
                    break;
                }
            }
        }
        }
    }
    public void checkWinner()
    {
        if(rHouse==4)
        {
            rHouse=0;
            JOptionPane.showMessageDialog(null,"Red is on position:"+rank+"");
            rank++;
        }
        else if(bHouse==4)
        {
            bHouse=0;
            JOptionPane.showMessageDialog(null,"Blue is on position:"+rank+"");
            rank++;
        }
        else if(yHouse==4)
        {
            yHouse=0;
            JOptionPane.showMessageDialog(null,"Yellow is on position:"+rank+"");
            rank++;
        }
        else if(gHouse==4)
        {
            gHouse=0;
            JOptionPane.showMessageDialog(null,"Green is on position:"+rank+"");
            rank++;
        }
    }
}
