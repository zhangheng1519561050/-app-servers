package com.testsession.business;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.ProductDao;

/**
 * Servlet implementation class updateserverlet
 */
@WebServlet("/updateserverlet.do")
public class updateserverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateserverlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	request.setCharacterEncoding("gbk");
		response.setCharacterEncoding("gbk");
		
		SmartUpload smart=new SmartUpload();
		
		//��smart��ʼ��
		smart.initialize(getServletConfig(), request, response);

    	
    	
    	
    	ProductDao product=new ProductDao();
    	
		try {
			
			//��ʼ�ϴ�
			smart.upload();
			
			//���浽�����  countΪ�����ļ�������  �����������Ķ���
			//int count = smart.save("d:/upload");
		
			
			//һ������
	    	//int idOne=0;
	    	int priceint=0;
			
			
			
			String  ext="";
			//��ȡͼƬ·����
	    	String file="";

			String name=smart.getRequest().getParameter("name");
	    	
		 	
		 	//System.out.println(name);
		    
	    	String stament1=smart.getRequest().getParameter("stament1");
	    	String stament2=smart.getRequest().getParameter("stament2");
	    	
	    	//����Ϊ��
	    	String price=smart.getRequest().getParameter("price");
	    	String yuanlai_price=smart.getRequest().getParameter("yuanlai_price");
	    	String kucun=smart.getRequest().getParameter("kucun");
	    	
	    	
	    	
	    	//String yuanlai_price=request.getParameter("yuanlai_price");
	    	
	    	
	    	//String kucun=request.getParameter("kucun");
	    	String time=smart.getRequest().getParameter("time");
	    	String introduction=smart.getRequest().getParameter("introduction");
			
			//�����ļ����� ����abc
			//String namefile=smart.getRequest().getParameter("dataname");
			
			//���productId
			String productId=smart.getRequest().getParameter("productId");
			
			System.out.println(productId);
			//�ļ��ĺ�׺��   ����jpg
			 ext=smart.getFiles().getFile(0).getFileExt();
			
			//���Ϊƴ���ļ���·�� �������������abc.jpg
			//smart.getFiles().getFile(0).saveAs("d:/upload/"+namefile+"."+ext);
			
			//��ȡ�ļ�ȫ��
			String fileName = smart.getFiles().getFile(0).getFileName();
			 
			//����
			//response.getWriter().write(name+":"+fileName+"."+ext);
			// file="d:/upload/"+namefile+"."+ext;
			 
			 String condi="";
			 
			 int productIdnew=0;
			 
			 if(productId!=null&&!productId.equals(""))
		    	{
		    		//Ҫ�ж�һ���Ƿ�Ϊ��  Ҫ��Ϊ�ղ�������ת��
				 productIdnew=Integer.parseInt(productId);
		    		
		    		
		    		
		    		//û�����ⲽ�����ҵ�1 3
		    		//System.out.println(tyForPar);
		    	}
			 
			 if(price!=null&&!price.equals(""))
		    	{
		    		//Ҫ�ж�һ���Ƿ�Ϊ��  Ҫ��Ϊ�ղ�������ת��
		    		priceint=Integer.parseInt(price);
		    		
		    		condi=" set productprice='"+priceint+"' where productId='"+productId+"'";
		    		
		    		//û�����ⲽ�����ҵ�1 3
		    		//System.out.println(tyForPar);
		    	}
		    	
		    	//ԭ��
		    	int yuanint=0;
		    	
		    	
		    
		    	
		    	if(yuanlai_price!=null&&!yuanlai_price.equals(""))
		    	{
		    		//Ҫ�ж�һ���Ƿ�Ϊ��  Ҫ��Ϊ�ղ�������ת��
		    		yuanint=Integer.parseInt(yuanlai_price);
		    		
		    		
		    		//û�����ⲽ�����ҵ�1 3
		    		//System.out.println(tyForPar);
		    	}
		    	
		    	
		    	int kucunint=0;
		    	
		    	
		    
		    	
		    	if(kucun!=null&&!kucun.equals(""))
		    	{
		    		//Ҫ�ж�һ���Ƿ�Ϊ��  Ҫ��Ϊ�ղ�������ת��
		    		kucunint=Integer.parseInt(kucun);
		    		
		    		
		    		//û�����ⲽ�����ҵ�1 3
		    		//System.out.println(tyForPar);
		    	}
		    	
		    	
		    	
//		    	if(stament1!=null&&!stament1.equals(""))
//		    	{
//		    		//Ҫ�ж�һ���Ƿ�Ϊ��  Ҫ��Ϊ�ղ�������ת��
//		    		idOne=Integer.parseInt(stament1);
//		    		
//		    		
//		    		//û�����ⲽ�����ҵ�1 3
//		    		//System.out.println(tyForPar);
//		    	}
		    	
		    	//��������
		    	int idTwo=0;
		    	
		    	//����
		    	int discount=0;
		    	if(yuanint!=0)
		    	{
		    		discount=priceint/yuanint;
		    	}
		    	if(stament2!=null&&!stament1.equals(""))
		    	{
		    		//Ҫ�ж�һ���Ƿ�Ϊ��  Ҫ��Ϊ�ղ�������ת��
		    		idTwo=Integer.parseInt(stament2);
		    		
		    		
		    		//û�����ⲽ�����ҵ�1 3
		    		//System.out.println(tyForPar);
		    	}
		    	
		    	Boolean bol=product.updateProduct(condi);
		    	
		    		if(bol=true)
			    	{
			    		response.getWriter().write("�޸ĳɹ�!");
			    	}
			    	
			    	else
			    	{
			    		response.getWriter().write("�޸�ʧ��!");
			    	}
			    	
		    	
		    	
//		    	String condition=" and productName='"+name+"'";
//		    	
//		    	
//		    	ResultSet rs=(ResultSet) product.selectproduct(condition);
//		    	
//		    	int choose=1;
//		    	
//		    	//�����Ѿ����������Ʒ
//		    	try {
//					while(rs.next())
//					{
//						response.getWriter().write("����Ʒ�Ѵ���");
//						
//						choose=0;
//					}
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		    	//Boolean bol=product.insertproduct(name, price, file, kucun, 0, introduction, time, discount, idTwo);
//		    	
//		    	if(choose==1)
//		    	{
//		    	Boolean bol=product.insertproduct(name, priceint, file, kucunint, 0, introduction, time, discount, idTwo);
//		    	
//		    	if(bol=true)
//		    	{
//		    		response.getWriter().write("��ӳɹ�!");
//		    	}
//		    	
//		    	else
//		    	{
//		    		response.getWriter().write("���ʧ��!");
//		    	}
//		    	
//		    	
//		    	}

		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		 
	    	
	    	
	    
	    	
    }
	

}
