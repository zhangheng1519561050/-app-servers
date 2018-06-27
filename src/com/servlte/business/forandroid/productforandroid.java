package com.servlte.business.forandroid;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.jsptest.pojo.Product;
import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.ProductDao;
import com.testlistener.dao.ProductTypeDao;

/**
 * Servlet implementation class productforandroid
 */
@WebServlet("/productforandroid.do")
public class productforandroid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productforandroid() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		
		
		//�ӿͻ��˻�ô�ֵ����productId
		
		int producttypeId=Integer.parseInt(request.getParameter("id"));
		
		//�Ȱ����ݷ���һ��list��
		ProductDao  productdao=new ProductDao();
		
		
		ProductTypeDao producttype=new ProductTypeDao();
		
		ArrayList<Product>  arrlist=new ArrayList<Product>();
		
//		//������Ʒ����ֱ����producttypeId
//		String condition="and productId='"+productId+"'";
//		
//		ResultSet res=(ResultSet) productdao.selectproduct(condition);
		
//			try {
//				while(res.next())
//				{
//					
////				System.out.println(res.getInt(1));
////				
////				System.out.println(res.getString(2));
////				
////				System.out.println(res.getString(3));
//					
//					
//					Product product=new Product(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getInt(5), res.getInt(6),  res.getString(7),res.getString(8),res.getInt(9),  res.getInt(10));
//					
//					
//					arrlist.add(product);
//
//				//Product product=new Product(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getInt(5), res.getInt(6),  rs.getString(7),res.getString(8),res.getInt(9),  res.getInt(10));
//				//arrlist.add(product);
//				}
//				
//				res.close();
//				JSONArray jsarray=JSONArray.fromObject(arrlist);
//				
//				response.getWriter().write(jsarray.toString());
//			
//				
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		
//	}
	
	//��list���� js����
	//��׿��servlte����������
	
	
		
		String condition="and typeParentid='"+producttypeId+"'";
		//String condition="and typeParentid='1'";
		
		//�ҵ�����idΪ1  3 10 11 12 13��һ������  ����û����
		ResultSet rs=(ResultSet) producttype.selectProductType(condition);
		
		
		
		try {
			while(rs.next())
			{
				
				String con="and producttypeId='"+rs.getInt(1)+"'";
				
				
				
					ResultSet res=(ResultSet) productdao.selectproduct(con);
				
					while(res.next())
					{
						
//						System.out.println(res.getInt(1));
//						
//						System.out.println(res.getString(2));
//						
//						System.out.println(res.getString(3));
						
						
						Product product=new Product(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getInt(5), res.getInt(6),  res.getString(7),res.getString(8),res.getInt(9),  res.getInt(10));
						
						
						arrlist.add(product);
				
					//Product product=new Product(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getInt(5), res.getInt(6),  rs.getString(7),res.getString(8),res.getInt(9),  res.getInt(10));
					//arrlist.add(product);
					}
					
					res.close();
				
			}
			
			//��list���� js����
			//��׿��servlte����������
			JSONArray jsarray=JSONArray.fromObject(arrlist);
			
			response.getWriter().write(jsarray.toString());
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
