package com.listener.listenertest;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import com.testlistener.dao.BaseDao;

/**
 * Application Lifecycle Listener implementation class listener1
 *
 */

//���úܼ򵥾�����һ�仰�Ϳ�����
@WebListener
public class listener1 implements ServletContextListener {

    private Connection conn;

	/**
     * Default constructor. 
     */
    public listener1() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    
    //������ʼ
    public void contextInitialized(ServletContextEvent sce) {
        // TODO Auto-generated method stub
    	
    	
    	//������±���Ȼ�����ӽ����������ݿ�Ĳ���
    	String driver=sce.getServletContext().getInitParameter("driver");
    	String url=sce.getServletContext().getInitParameter("url");
    	String name = sce.getServletContext().getInitParameter("name");
		String password = sce.getServletContext().getInitParameter("password");
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = (Connection) DriverManager.getConnection(url,
					name, password);
			
			//������conn����BaseDao��ͨ��set����
			BaseDao.setConn(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    
    //�����ر�
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
    	
    	if(this.conn!=null)
    	{
    		try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
	
}
