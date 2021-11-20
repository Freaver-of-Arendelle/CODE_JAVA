package view;//�������������GoBangframe��

import model.bean.Board;
import model.bean.Chess;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class GoBangframe extends JPanel implements GoBangconfig {
    public Graphics g;//定义一支画笔
    private Board board;
    public int turn = 0;//等于0时无法下棋
    public int ChooseType = 0;//0表示人人对战，1表示人机对战，默认人人对战

    public int[][] weightArray = new int[COLUMN][ROW];//定义一个二维数组，保存各个点的权值

    public void initUI() {
        //初始化一个界面,并设置标题大小等属性
        JFrame jf = new JFrame();
        jf.setTitle("五子棋");
        jf.setSize(UIWIDTH, UIHIGHTH);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);
        jf.setLayout(new BorderLayout());//设置顶级容器JFrame为框架布局

        //实现左边的界面，把GoBangframe的对象添加到框架布局的中间部分
        //已经有一个GoBangframe对象了，表示当前类的对象是this
        this.setBackground(Color.WHITE);//设置下棋界面的颜色
        //这里的话直接把左边的画板添加上去，指明是在框架布局的中间版块
        //若放在其他版块会有一些小问题
        jf.add(this, BorderLayout.CENTER);//添加到框架布局的中间部分

        //实现右边的JPanel容器界面
        JPanel jp = new JPanel();
        jp.setPreferredSize(dim1);//设置JPanel的大小
        jp.setBackground(Color.LIGHT_GRAY);//设置右边的界面颜色为白色
        jf.add(jp, BorderLayout.EAST);//添加到框架布局的东边部分
        jp.setLayout(new FlowLayout());//设置JPanel为流式布局

        //编辑用户信息栏，包括头像，昵称，性别，等级
        //ImageIcon[] userPicture={USERPICTURE,USERNAME,USERSEX,USERLEVEL};
        String[] userMessage = {"pic", "昵称：Alexwym", "性别：男", "等级：新手"};
        JLabel[] user = new JLabel[4];
        //设置背景图片的大小
        USERPICTURE.setImage(USERPICTURE.getImage().getScaledInstance(dim3.width, dim3.height, Image.SCALE_DEFAULT));
        user[0] = new JLabel(USERPICTURE);
        user[0].setPreferredSize(dim3);
        jp.add(user[0]);

        for (int i = 1; i < 4; i++) {
            user[i] = new JLabel(userMessage[i]);
            user[i].setPreferredSize(dim2);
            /*
             *利用setFont来设置TextField文本框输入信息的字体大小
             *textx1.setFont(new Font(Font.DIALOG,Font.PLAIN,30));
             */
            user[i].setFont(new Font(Font.MONOSPACED, Font.ITALIC, 20));
            jp.add(user[i]);
        }

        //接下来我们需要把按钮等组件依次加到那个JPanel上面
        //设置按钮数组
        //String[] butname= {"","",""};
        String[] butname = {"开始新游戏", "悔棋", "认输"};
        ImageIcon[] BackgroundPicture = {STARTBUTTON, BACKBUTTON, LOSEBUTTON};
        JButton[] button = new JButton[3];

        //依次把三个按钮组件加上去
        for (int i = 0; i < butname.length; i++) {
            BackgroundPicture[i].setImage(
                BackgroundPicture[i].getImage().getScaledInstance(dim4.width + 20, dim4.height, Image.SCALE_DEFAULT));
            button[i] = new JButton(butname[i], BackgroundPicture[i]);
            button[i].setPreferredSize(dim4);
            jp.add(button[i]);
        }

        //设置选项按钮

        ImageIcon[] pic = {BATTLEBUTTON1, BATTLEBUTTON2};
        JComboBox box = new JComboBox(pic);
        box.setPreferredSize(dim4);
        pic[0].setImage(pic[0].getImage().getScaledInstance(dim4.width, dim4.height, Image.SCALE_DEFAULT));
        pic[1].setImage(pic[1].getImage().getScaledInstance(dim4.width, dim4.height, Image.SCALE_DEFAULT));
        jp.add(box);

        //按钮监控类
        ButtonListener butListen = new ButtonListener(this, box);
        //对每一个按钮都添加状态事件的监听处理机制
        for (int i = 0; i < butname.length; i++) {
            button[i].addActionListener(butListen);//添加发生操作的监听方法
        }

        //对可选框添加事件监听机制
        box.addActionListener(butListen);

        frameListener fl = new frameListener();
        fl.setGraphics(this);//获取画笔对象
        this.addMouseListener(fl);

        jf.setVisible(true);
    }

    public void PopUp(String top, String result) {
        JOptionPane jo = new JOptionPane();
        JOptionPane.showMessageDialog(null, result, top, JOptionPane.PLAIN_MESSAGE);
    }

    //重写重绘方法,这里重写的是第一个大的JPanel的方法
    @Override public void paint(Graphics g) {
        super.paint(g);//画出白框

        //重绘出棋盘
        g.setColor(Color.black);
        for (int i = 0; i < ROW; i++) {
            g.drawLine(X, Y + SIZE * i, X + SIZE * (COLUMN - 1), Y + SIZE * i);
        }
        for (int j = 0; j < COLUMN; j++) {
            g.drawLine(X + SIZE * j, Y, X + SIZE * j, Y + SIZE * (ROW - 1));
        }

        //重绘出棋子
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (board.getVis()[i][j] == 1) {
                    int countx = SIZE * j + SIZE / 2;
                    int county = SIZE * i + SIZE / 2;
                    g.drawImage(BLACKCHESS, countx - SIZE + X, county - SIZE / 2, SIZE, SIZE, null);
                } else if (board.getVis()[i][j] == 2) {
                    int countx = SIZE * j + SIZE / 2;
                    int county = SIZE * i + SIZE / 2;
                    g.drawImage(WHITECHESS, countx - SIZE + X, county - SIZE / 2, SIZE, SIZE, null);
                }
            }
        }
    }

}
