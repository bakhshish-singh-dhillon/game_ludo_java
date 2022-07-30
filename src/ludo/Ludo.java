
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ludo;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;



/**
 *
 * @author Dhillon-PC
 */
public class Ludo extends JFrame implements MouseListener{

    BoardLudo bl;
    Input in;
        
    Ludo() 
    {
        in=new Input();
        add(in);
        JButton next=new JButton("Next ->");
        next.addMouseListener(this);
        next.setBounds(500, 500, 100, 40);
        in.add(next);
        setSize(900,800);
        setTitle("Ludo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args)  {
       
        Ludo ld=new Ludo();
        ld.setVisible(true);
        
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        in.setVisible(false);
        remove(in);
        bl=new BoardLudo(in.count(),in.name(),in.color());
        add(bl);
        
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
