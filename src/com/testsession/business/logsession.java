package com.testsession.business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testlistener.dao.UsersDao;

/**
 * Servlet implementation class logsession
 */
@WebServlet("/logsession.do")
public class logsession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logsession() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String account=request.getParameter("account");
		
		String password=request.getParameter("password");
		
		
		UsersDao managerdao=new UsersDao();
		
		int count=managerdao.getVipCount(account, password);
		
		if(count>0)
		{
			//�����ݷ��뵽Session
			//�õ�session���û���򴴽�  ����о�ֱ�ӻ��
			
			//���ʴ���  ͨ��getServletContext()�����  application��ż�¼���� �ӳ���ʼ����ѯ�ر�
//			Object logcount=getServletContext().getAttribute("logcount");
//			
//			
//			//��ӡͨ��system.print.out
//			
//			if(logcount!=null)
//			{
//				getServletContext().setAttribute("logcount", Integer.parseInt(logcount.toString())+1);
//			}
//			
//			
//			else
//			{
//				getServletContext().setAttribute("logcount", 1);
//			}
//			
			Cookie cookie=new Cookie("account", account);
			
			
			//cookie����ʱ�� ��λ����
			cookie.setMaxAge(3600);
			
			
			//�������˷����������Ϣ
			response.addCookie(cookie);
			
			//����������������ʱ  Ҫ��һ����������session  ����ʶ����һ���ͻ���   jssessioned���ж�
			//jssessioned���ڿͻ���  �����ж�����һ��session���ͻ�
			request.getSession(true).setAttribute("account", account);
        	response.sendRedirect("main.html");
		}
	}

}
