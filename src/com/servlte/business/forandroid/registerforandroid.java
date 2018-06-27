package com.servlte.business.forandroid;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.testlistener.dao.UsersDao;

/**
 * Servlet implementation class registerforandroid
 */
@WebServlet("/registerforandroid.do")
public class registerforandroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerforandroid() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		String userEmail=request.getParameter("userEmail");
		
		
		
		
		UsersDao user=new UsersDao();
		
		//Boolean bol=user.insert(userName, userPassword, userEmail);
		
	
		int count=user.getRegCount(userName);
		
		//System.out.println(count);
		if(count>0)
		{
			
			
			
			//��һ����ʶ����׿
			JSONObject json=new JSONObject();
			
			
			//ͨ��Json����һ��key 1��ע��ɹ�
			
			json.put("registerchoose", 0);
			
			
			response.getWriter().write(json.toString());
//			
//			response.getWriter().write("���˺�");
		}
		else
		{
			Boolean bol=user.insert(userName, userPassword, userEmail);
		if(bol)
		{
			//��һ����ʶ����׿
			JSONObject json=new JSONObject();
			
			
			//ͨ��Json����һ��key 1�ܵ�¼�ɹ�
			
			json.put("registerchoose", 1);

			response.getWriter().write(json.toString());
//			response.getWriter().write("û���˺�");
		}
		
		else
		{
			//��һ����ʶ����׿
			JSONObject json=new JSONObject();
			
			
			//ͨ��Json����һ��key 1�ܵ�¼�ɹ�
			
			json.put("registerchoose", 0);

			response.getWriter().write(json.toString());
//			response.getWriter().write("û���˺�");
		}
		}
	}

}
