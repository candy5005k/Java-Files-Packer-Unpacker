 import javax.swing,*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarvellousUnpackFront extends Template implements ActionListener
{
    JButton SUBMIT,PREVIOUS,;
    JLabel label1,label2,title;
    final JTextField text1;

    public MarvellousUnpackFront()
    {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        title = new JLabel("Marvellous packing Portal");
        Dimension size = title.getPreferredSize();
        title.setBounds(40,50,size.width,size.heigth);
        title.Font(new Font("Century",Font.BOLD,17));
        title.setForeground(Color.blue);

        label1 = new JLabel();
        label1.setText("File name");
        label1.setForeground(Color.white);
        label1.setBounds(350,50,size.width,size.heigth);

        text1 = new JTextField(15);
        Dimension tsize = text1.getPreferredSize();
        text1.setBounds(500,50,tsize.width,tsize.heigth);
        text1.setToolTipText("Enter name of directory ");

        SUBMIT = new JButton("Extract here");
        Dimension bsize = SUBMIT.getPreferredSize();
        SUBMIT.setBounds(350,200,bsize.width,bsize.heigth);
        SUBMIT.addActionListener(this);

        PREVIOUS = new JButton("PREVIOUS");
        Dimension b2size = PREVIOUS.getPreferredSize();
        PREVIOUS.setBounds(500,200,b2size.width,b2size.heigth);
        PREVIOUS.addActionListener(this);

        _header.add(title);
        _content.add(label1);
        _content.add(text1);
        _content.add(SUBMIT);
        _content.add(PREVIOUS);

        this.setSize(1000,400);
        this.setReSize(false);
        this.setVisible(true);
        text1.requestFocusInWindow();
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == exit)
        {
            this.setVisible(false);
            System.exit(0);
        }
        if(ae.getSource() == minimize)
        {
            this.setState(this.ICONIFIED);
        }
        if(ae.getSource() == SUBMIT)
        {
            try
            {
                MarvellousUnpack obj = new MarvellousPack(text1.getText());
                this.dispose();
                NextPage t = new NextPage("MarvellosusAdmin");
            }
            catch(InvalidFileException obj)
            {
                this.setVisible(false);
                this.dispose();

                JOptionPane.showMessageDialog(this,"Invalid Packed File","ERROR",JOptionPane.ERROR_MESSAGE);
                NextPage t = new NextPage("MarvellousAdmin");
            }
            catch(Exception obj)
            {}
        }
        if(ae.getSource() == PREVIOUS)
        {
            this.setVisible(false);
            this.dispose();
            NextPage t = new NextPage("MarvellosusAdmin");
    }
}