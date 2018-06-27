package com.servlte.business.forandroid;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.ShoppingCartDao;
import com.testlistener.dao.UsersDao;

/**
 * Servlet implementation class userloginforandroid
 */
@WebServlet("/userloginforandroid.do")
public class userloginforandroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userloginforandroid() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//int productId=Integer.parseInt(request.getParameter("productId"));
//		int usersId=Integer.parseInt(request.getParameter("usersId"));
//		int productnum=Integer.parseInt(request.getParameter("productnum"));
//		
//		
//		ShoppingCartDao shopcart=new ShoppingCartDao();
		
		//Boolean bol=shopcart.insertshoppingcart(productId, usersId, productnum);
		
		String  userName=request.getParameter("userName");
		String  userPassword=request.getParameter("userPassword");
		
		//String condition=" and userName='"+userName+"' and userPassword='"+userPassword+"'";
		
		UsersDao users=new UsersDao();
		
		int count=users.getUserCount(userName, userPassword);
		
	
		if(count>0)
		{
			
			
			
			//��һ����ʶ����׿
			JSONObject json=new JSONObject();
			
			
			//ͨ��Json����һ��key 1�ܵ�¼�ɹ�
			
			json.put("logchoose", 1);
			
			
			response.getWriter().write(json.toString());
			
			response.getWriter().write("���˺�");
		}
		
		else
		{
			//�����˺Ų����� �����������
			
		
			
			String condi=" and userName='"+userName+"'";
			
			
			ResultSet rs=(ResultSet) users.selectVip(condi);
			
			try {
				if(rs.next()==false)
				{
					
					//��һ����ʶ����׿
					JSONObject json=new JSONObject();
					
					
					//ͨ��Json����һ��key 1�ܵ�¼�ɹ�
					
					json.put("logchoose", 0);

					response.getWriter().write(json.toString());
					response.getWriter().write("û���˺�");
				}
				else
				{
					//��һ����ʶ����׿
					JSONObject json=new JSONObject();
					
					
					//ͨ��Json����һ��key 1�ܵ�¼�ɹ�
					
					json.put("logchoose", 2);

					response.getWriter().write(json.toString());
					response.getWriter().write("�������");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}
		
	}

}
