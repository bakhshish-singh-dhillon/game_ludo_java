/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ludo;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Dhillon-PC
 */
public class Input extends JPanel implements MouseListener{
    int count=0;
    String name[]=new String[4];
    String color[]=new String[4];
    int x=100,y=100;
    JButton newPlayer;
    JButton addPlayer;
    JLabel lblName[]=new JLabel[4];
    JTextField txtName[]=new JTextField[4];
    String cmdColor[]={"Select Color","Red","Blue","Yellow","Green"};
    JComboBox combo[]=new JComboBox[4];
    int flag=0;

    
    public Input() {
        setBounds(0,0,900,800);
        setLayout(null);
        setOpaque(false);
        newPlayer=new JButton("Add New Player");
        newPlayer.setBounds(x, y, 150, 40);
        newPlayer.addMouseListener(this);
        addPlayer= new JButton("Add");
        addPlayer.addMouseListener(this);
        add(newPlayer);
        add(addPlayer);
        addPlayer.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(count<4)
        {
        if(e.getSource()==newPlayer)
        {   
            newPlayer.setVisible(false);
            lblName[count]=new JLabel("Enter name of player "+(count+1)+":");
            txtName[count]=new JTextField();
            combo[count]=new JComboBox(cmdColor);
            lblName[count].setBounds(x,y+50, 150, 40);
            txtName[count].setBounds(x+160,y+50, 100, 40);
            combo[count].setBounds(x+270,y+50, 100, 40);
            addPlayer.setBounds(x+380,y+50, 100, 40);
            add(lblName[count]);
            add(txtName[count]);
            add(combo[count]);
            addPlayer.setVisible(true);
        }
        else
        {
            
            for(int i=0;i<count;i++)
            {
                if(color[i].equals((String)combo[count].getSelectedItem()))
                {
                    flag++;
                }
            }
            if(flag==1)
            {
                JOptionPane.showMessageDialog(null,"Color already taken");
                flag=0;
            }
            else if(txtName[count].getText().equals("") || "Select Color".equals((String)combo[count].getSelectedItem()))
            {
                JOptionPane.showMessageDialog(null,"Please give a name and color");
            }
            else
            {
            addPlayer.setVisible(false);
            newPlayer.setVisible(true);
            newPlayer.setBounds(x, y+100, 150, 40);
            name[count]=txtName[count].getText();
            color[count]=(String)combo[count].getSelectedItem();
            count++;
            y=y+50;
            }
        }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Only 4 Players are allowed");
        }
    
    }
    
    public int count()
    {
        return count;
    }
    public String[] name()
    {
        return name;
    }
    public String[] color()
    {
        return color;
    }
    
    

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
