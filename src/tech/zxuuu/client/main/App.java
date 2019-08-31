package tech.zxuuu.client.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tech.zxuuu.client.auth.AuthGUI;

import tech.zxuuu.client.messageQueue.ResponseQueue;
import tech.zxuuu.client.studentManage.StudentTableGUI;
import tech.zxuuu.client.studentManage.SwitchManager;
import tech.zxuuu.net.ConnectionToServer;
import tech.zxuuu.net.ResponseListener;
import tech.zxuuu.net.Session;
import tech.zxuuu.util.SwingUtils;

public class App extends JFrame {

  /******* 新增部分 *******/
	public static boolean hasLogon = false; // 登录状态
	public static Session session; // 登陆Session
	public static ConnectionToServer connectionToServer; // 到服务器的连接
	public static ResponseQueue responseQueue;
	private ResponseListener responseListener;
  /***********************/
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public App() {

	  /******* 新增部分 *******/
		// 连接到服务器
		App.connectionToServer = Utils.formConnection();
		// 报错，结束运行
		if (App.connectionToServer == null) {
			SwingUtils.showError(null, "服务器连接失败！连接到：" + Utils.getServerHost() + ":" + Utils.getMainPort(), "错误");
			System.exit(0);
		}
		// 初始化响应队列
		App.responseQueue = ResponseQueue.getInstance();
		// 开始侦听响应
		this.responseListener = new ResponseListener(App.connectionToServer);
		this.responseListener.start();
	  /***********************/
		
//		if (!App.hasLogon) {
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						AuthGUI frame = new AuthGUI();
//						frame.setVisible(true);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
//			
//		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblClientMainPage = new JLabel("Client Main Page");
		panel.add(lblClientMainPage);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        /* 请修改此处内容以快速进行前后端联调 */
				StudentTableGUI interface1=new StudentTableGUI();
				interface1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				interface1.setVisible(true);
			}
		});
		panel_1.add(btnNewButton);
	}

}
