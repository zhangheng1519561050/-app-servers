package com.servlte.business.forandroid;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.ProductDao;
import com.testlistener.dao.ProductTypeDao;

/**
 * Servlet implementation class getimageforandroid
 */
@WebServlet("/gettypeimageforandroid.do")
public class gettypeimageforandroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gettypeimageforandroid() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//����ͼƬ������ 
		
		response.setContentType("image/png;charset=GB2312");
		
		//������  ���ļ����    ���������� ����   ��д����ļ�
		
		
		//�������·���ǿͻ�������ӷ������˻�ȡ����
	
		//�ӿͻ�������ͼƬ��id
		
		
		
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		ProductTypeDao producttype=new ProductTypeDao();
		
		String condition=" and producttypeId='"+id+"'";
		
		String address="";
		
		ResultSet rs=(ResultSet) producttype.selectProductType(condition);
		
		try {
			while(rs.next())
			{
				address=rs.getString(4);
				
				System.out.println(address);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream inputstream=new FileInputStream(address);
		
		//д
		
		BufferedOutputStream outputstream=new BufferedOutputStream(response.getOutputStream());
		
		
		byte[] buffer=new byte[1024];
		
		int count=0;
		
		while((count=inputstream.read(buffer))>=0)
		{
			outputstream.write(buffer);
		}
		
		
		System.out.println(outputstream);
		
		inputstream.close();
		outputstream.close();
		outputstream.close();
	}
}
