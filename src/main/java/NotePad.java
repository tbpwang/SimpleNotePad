import DAO.TextDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Administrator
 * Created by tbpwang
 * 2016/7/26.
 */
public class NotePad extends JFrame{

    private TextDAO textDAO;

    private JMenuBar menuBar;
    
    private JMenu fileMenu;
    private JMenuItem menuOpen;
    private JMenuItem menuSave;
    private JMenuItem menuSaveAs;
    private JMenuItem menuClose;
    
    private JMenu editMenu;
    private JMenuItem menuCut;
    private JMenuItem menuCopy;
    private JMenuItem menuPaste;

    private JMenu aboutMenu;
    private JMenuItem menuAbout;

    private JTextArea textArea;
    private JLabel stateBar;

    private JPopupMenu popUpMenu;

    public NotePad(TextDAO textDAO) throws HeadlessException {
        this();
        this.textDAO = textDAO;
    }

    public NotePad() throws HeadlessException {
        initComponents();
        initEventListeners();
    }

    private void initComponents(){
        setTitle("新建文本文档");
        setSize(400,300);
        initFileMenu();
        initEditMenu();
        initAboutMenu();
        initMenuBar();
        initTextArea();
        initStateBar();

        popUpMenu = editMenu.getPopupMenu();
    }

    private void initStateBar() {
        //文本状态
        stateBar = new JLabel("未修改");
        stateBar.setHorizontalAlignment(SwingConstants.LEFT);
        stateBar.setBorder(BorderFactory.createEtchedBorder());
        getContentPane().add(stateBar, BorderLayout.SOUTH);
    }

    private void initTextArea() {
        textArea = new JTextArea();
        textArea.setFont(new Font("宋体",Font.PLAIN,16));
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

    }

    private void initMenuBar() {
        menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);
        
        setJMenuBar(menuBar);
    }

    private void initAboutMenu() {
        aboutMenu = new JMenu("关于");
        menuAbout = new JMenuItem("关于记事本");
        aboutMenu.add(menuAbout);
    }

    private void initEditMenu() {
        editMenu = new JMenu("编辑");
        menuCut = new JMenuItem("剪切");
        menuCopy = new JMenuItem("复制");
        menuPaste = new JMenuItem("粘贴");
        
        editMenu.add(menuCut);
        editMenu.addSeparator();
        editMenu.add(menuCopy);
        editMenu.addSeparator();
        editMenu.add(menuPaste);
                
    }

    private void initFileMenu() {
        fileMenu = new JMenu("文件");
        menuOpen = new JMenuItem("打开");
        menuSave = new JMenuItem("保存");
        menuSaveAs = new JMenuItem("另存");
        menuClose = new JMenuItem("关闭");
        
        fileMenu.add(menuOpen);
        fileMenu.addSeparator();
        fileMenu.add(menuSave);
        fileMenu.add(menuSaveAs);
        fileMenu.addSeparator();
        fileMenu.add(menuClose);
    }

    private void initEventListeners(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initAccelerator();//初始化快捷键

        //窗口关闭事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow(e);
            }
        });

        initMenuListener();

        //编辑区键盘事件
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textAreaActionPerformed(e);
            }
        });

        //编辑区鼠标事件
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    popUpMenu.setVisible(false);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popUpMenu.show(editMenu,e.getX(),e.getY());
                }
            }
        });
    }

    private void initMenuListener() {
        menuOpen.addActionListener(this::openFile);
        menuSave.addActionListener(this::saveFile);
        menuSaveAs.addActionListener(this::saveFileAs);
        menuClose.addActionListener(this::closeFile);
        menuCut.addActionListener(this::cut);
        menuCopy.addActionListener(this::copy);
        menuPaste.addActionListener(this::paster);
        menuAbout.addActionListener(e -> JOptionPane.showOptionDialog(null, "NotePad 1.0","关于记事本", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null));
    }

    private void paster(ActionEvent actionEvent) {
    }

    private void copy(ActionEvent actionEvent) {
    }

    private void cut(ActionEvent actionEvent) {
    }

    private void closeFile(ActionEvent actionEvent) {
    }

    private void saveFileAs(ActionEvent actionEvent) {
    }

    private void saveFile(ActionEvent actionEvent) {
    }

    private void openFile(ActionEvent actionEvent) {
    }

    private void textAreaActionPerformed(KeyEvent e) {
    }

    private void closeWindow(WindowEvent e) {
    }

    private void initAccelerator() {
        menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        menuClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        menuCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        menuCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        menuPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        menuAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
    }

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                NotePad notePad = new NotePad();
//                notePad.setVisible(true);
//            }
//        });
        SwingUtilities.invokeLater(()-> new NotePad().setVisible(true));
    }
}
