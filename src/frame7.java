import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frame7 extends JFrame {
    private  Point p = new Point(0, 0);
//    private int positionX = 0, positionY = 0;
//    private Point prevPressedPoint;

    private int Flag =0,objx=50,objy=50,objw=50,objh=50;
    private  JButton b1 = new JButton("Run");
    private  JButton b2 = new JButton("↑");
    private  JButton b3 = new JButton("↓");
    private  JButton b4 = new JButton("←");
    private  JButton b5 = new JButton("→");
    private  JButton b6 = new JButton("Exit");
    private Container cp;
    private  JLabel lab = new JLabel();
    private  ImageIcon icon = new ImageIcon("destroyer.png");
    private  Timer time ;
    private  boolean flag =false;
          private JPanel jpnc = new JPanel();
    private JPanel jpnr = new JPanel(new GridLayout(1, 6, 2, 2));

    public frame7(){
        init();
    }

    public void init(){

        this.setBounds(200,200,600,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(2, 2));
        cp.add(jpnc, BorderLayout.CENTER);
        cp.add(jpnr, BorderLayout.SOUTH);
        jpnr.add(b1);
        jpnr.add(b2);
        jpnr.add(b3);
        jpnr.add(b4);
        jpnr.add(b5);
        jpnr.add(b6);
        lab.setIcon(icon);
        this.add(lab);
//        lab.setFont(new Font(null,Font.BOLD,36));
        time = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (Flag){
                    case 1:
                        if(objy-4>-130){
                            objy-= 4;
                        }
                        break;
                    case 2:
                        if(objy+4<260) {
                            objy+= 4;
                        }
                        break;
                    case 3:
                        if(objx-4>50){
                            objx-= 4;
                        }
                        break;
                    case 4:
                        if(objx+4<400){
                            objx+=4;
                        }
                        break;
                }
                lab.setLocation(objx-50,objy-50);
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);
            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time.start();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flag=1;

            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flag=2;

            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flag=3;

            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flag=4;

            }
        });

        lab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)){
                    Component jl = (Component) e.getSource();
                    Point newP = SwingUtilities.convertPoint(jl, e.getPoint(),
                            jl.getParent()); // 转换坐标系统
                    jl.setLocation(jl.getX() + (newP.x - p.x), jl.getY()
                            + (newP.y - p.y)); // 设置标签的新位置
                    p = newP; // 更改坐标点
                }
            }
        });
        lab.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    Component jl = (Component) e.getSource();
                    p = SwingUtilities.convertPoint(jl, e.getPoint(), jl.getParent()); // 得到当前坐标点
                }
            }
        });
    }
}