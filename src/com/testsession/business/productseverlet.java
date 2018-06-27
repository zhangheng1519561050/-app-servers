package com.testsession.business;

import java.io.IOException;
import java.nio.charset.CodingErrorAction;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.ProductDao;
import com.testlistener.dao.ProductTypeDao;

/**
 * Servlet implementation class productseverlet
 */
@WebServlet("/productseverlet.do")
public class productseverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productseverlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	
    	
    	ProductTypeDao producttype=new ProductTypeDao();
    	
    	String condition="";
    	
    	String tyidForPar=request.getParameter("stament1");
    	
    	String pageNo=request.getParameter("pageNo");
    	int	pageNonew=0;
    	if(pageNo!=null&&!pageNo.equals(""))
    	{
    		//Ҫ�ж�һ���Ƿ�Ϊ��  Ҫ��Ϊ�ղ�������ת��
    		pageNonew=Integer.parseInt(pageNo);
    		
    		
    		//û�����ⲽ�����ҵ�1 3
    		//System.out.println(tyForPar);
    	}
    	
    	//һ������
    
    	int  tyForPar=0;
    	
    	
    	if(tyidForPar!=null&&!tyidForPar.equals(""))
    	{
    		//Ҫ�ж�һ���Ƿ�Ϊ��  Ҫ��Ϊ�ղ�������ת��
    		tyForPar=Integer.parseInt(tyidForPar);
    		
    		
    		//û�����ⲽ�����ҵ�1 3
    		//System.out.println(tyForPar);
    	}
    	
    	
    
    	
    	
    	
    	
    	
    	
    	
    	
    	//��������
    	String producttypeid=request.getParameter("stament2");
    	int  typeId=0;
    	
    	
    	if(producttypeid!=null&&!producttypeid.equals(""))
    	{
    		//Ҫ�ж�һ���Ƿ�Ϊ��  Ҫ��Ϊ�ղ�������ת��
    		typeId=Integer.parseInt(producttypeid);
    	}
    	
    	//System.out.println(producttypeid);
    	String account=request.getParameter("account");
    	
    
    	String price1=request.getParameter("price1");
    	String sale1=request.getParameter("sale1");
    	String price2=request.getParameter("price2");
    	String sale2=request.getParameter("sale2");
    	
    	
    	//���ɾ��id
        String delid=request.getParameter("delid");
    	ProductDao productdao=new ProductDao();
    	
    	//��һ�������
    	ResultSet sqlall=null;
    	
//    	//һ������  �ڵ�һ�β�ѯ�������Ҫ��һ������
//		if(tyForPar==0)
//		{
//			condition+=" ";
//			
//		}
//		
//		else
//		{
//			int id=0;
//			//���һ�������id ����idȥ��PidΪid�Ķ��������id
//			
//			String co=" and typeParentid='"+tyForPar+"'";
//			
//			
//			//���ܻ��ж�������
//			ResultSet res=(ResultSet) producttype.selectProductType(co);
//			
//			
//			
//			try {
//				
//				res.next();
//				
//			
//				
//				id=res.getInt(1);
//				condition+=" and producttypeId='"+id+"'";
//				
//				while(res.next())
//				{
//					id=res.getInt(1);
//					
//					
//					//���ҵ���������� typeid
//					//System.out.println(id);
//					
//					condition+=" or producttypeId='"+id+"'";
//					
//					System.out.println(condition);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//			
//			
//		}
//    	
    	
    	//����һ��
    			if(delid==null)
    			{
    				//System.out.println("��Һ�");
    			}
    			
    			else
    			{
    				Boolean choose=productdao.deleteproduct(Integer.parseInt(delid));
    			}
    			
    			
    			
    			String  resAll=null;
    			
    			//һ������  �ڵ�һ�β�ѯ�������Ҫ��һ������
    			if(tyForPar==0)
    			{
    				condition+=" ";
    				
    			}
    			
    			else
    			{
    				int id=0;
    				//���һ�������id ����idȥ��PidΪid�Ķ��������id
    				
    				String co=" and typeParentid='"+tyForPar+"'";
    				
    				
    				//���ܻ��ж�������
    				ResultSet res=(ResultSet) producttype.selectProductType(co);
    				
    				
    				
    				try {
    					
    					res.next();
    					
    				
    					
    					id=res.getInt(1);
    					condition+=" and producttypeId='"+id+"'";
    					
    					while(res.next())
    					{
    						id=res.getInt(1);
    						
    						
    						//���ҵ���������� typeid
    						//System.out.println(id);
    						
    						String tiaojian=condition;
    						
    						condition+=" or producttypeId='"+id+"'";
    						
    						
    						
    						resAll="(select *from product where 1=1"+condition+")b";
    						
    						//System.out.println(resAll);
    						
    					}
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    				
    				
    				
    				
    			}
    	    	
    			
    			condition="";
    			
    			
    			//��������
    			if(typeId==0)
    			{
    				condition+=" ";
    				
    			}
    			
    			else
    			{
    				
    				condition+=" and producttypeId='"+typeId+"'";
    				
    				System.out.println(condition);
    			}
    			
    			if(account!=null&&!account.equals(""))
    			{
    				condition+=" and productName='"+account+"'";
    				
    			}
    			
    			
    			//�ж�ʲô��Ǯ֮��kucun!=null&&!kucun.equals("")
    			
    			if(price1!=null&&!price1.equals("") &&price2!=null&&!price2.equals(""))
    			{
    				condition+=" and productprice between '"+price1+"' and '"+price2+"'";
    				
    			}
    			
    			
    			//�ж�ʲô����֮��
    			
    		   if(sale1!=null&&!sale1.equals("") &&sale2!=null&&!sale2.equals(""))
    			{
    				condition+=" and productSales between '"+sale1+"' and '"+sale2+"'";
    				
    			}
    			
    			
    			//System.out.println(condition);
    			
    			
    	//ResultSet rs=(ResultSet) productdao.selectproduct(condition);
    			
    			
    			//��ҳ ÿҳ2��
    			 condition+= " limit " + pageNonew * 2 + ",2";
    			 
    			System.out.println(condition);
    	
    	ResultSet rs=(ResultSet) productdao.selectproductCondition(condition, resAll);
    	String table = "<Table border=1  cellpadding=0 cellspacing=0>";
    	
    	
    

		table += "<tr><th>���</th><th>ɾ��</th><th>ͼƬ</th><th>����</th><th>��������</th><th>����</th><th>����</th><th>��Ʒ��Ϣ</th><th>����</th><th>�ܶ�</th><th>����</th></tr>";
		//table+="<th>����</th><th>����</th><th>���</th><th>����</th><th>�ܶ�</th><th>����</th></tr>";
    	try {
    		
    		
			while(rs.next())
			{
				table+="<tr>";
				
				table+="<td>";
				
				table+=rs.getInt(1);
				
				
				table+="</td>";
				
				table+="<td>";
				
				table+="<input type="+"checkbox"+" ";
				//table+="id="+"checkid"+"";
				table+="id=\"checkid\"";
				
				//ת���ַ��ֿ�""
				table+="value=\""+rs.getInt(1)+"\" ";
				table+="/>";
				
				table+="</td>";
				
				

				table+="<td>";
				 //<img alt="" src="getimageAndroid.do">
				
				//��������д
				table+=" <img src="+rs.getString(4)+">";
				//table+=rs.getString(6);
				
				table+="</td>";
				
				
				table+="<td>";
	
				
				
				//��һ������
				
				String condi=" and producttypeId='"+rs.getInt(10)+"'";
			
				
				int Parentid=producttype.selectParentid(condi);
				
				//System.out.println(Parentid);
				String con2=" and producttypeId='"+Parentid+"'";
				
			//	ResultSet resset2=(ResultSet) producttype.selectProductType(con2);
				
				ResultSet resset=(ResultSet) producttype.selectProductType(con2);
				
				
				//��resset��next�ſ���
				while(resset.next())
				{
					table+=resset.getString(3);
				}
				table+="</td>";
				
				
				
				table+="<td>";

				//table+=rs.getString(4);
				
				//��ʾ��������ֱ�ӻ�ȡ��Ʒ���л�ÿ϶���
				
				String con=" and producttypeId='"+rs.getInt(10)+"'";
				
				
				//System.out.println(condi);
				
//				int Parentid=producttype.selectParentid(con);
//				String con2=" and typeParentid='"+Parentid+"'";
				
			//	ResultSet resset2=(ResultSet) producttype.selectProductType(con2);
				ResultSet resset2=(ResultSet) producttype.selectProductType(con);
				
				
				String updatecon="";
				//��resset��next�ſ���
				while(resset2.next())
				{
					table+=resset2.getString(3);
				}
				table+="</td>";
				
				
				table+="<td>";
				
				
				table+=rs.getString(2);
				
				table+="</td>";
				
				
				
				
				table+="<td>";
				
				
				table+=rs.getString(5);
				
				table+="</td>";
				
				
				table+="<td>";
				
				table+=rs.getString(7);
				
				
				table+="</td>";
				
				table+="<td>";
				
				table+=rs.getString(6);
				
				
				table+="</td>";
				
				table+="<td>";
				
				table+=rs.getString(5);
				
				
				table+="</td>";
				
				table+="<td>";
				
				//ƴ���ַ�����+���Կ����ǳ���
				//table+="<a herf="+"#"+">ɾ��</a>";
				table+="<a href="+"#"+"";
				table+=" onclick="+"update("+rs.getInt(1)+");"+"";
				table+=">";
				table+="�༭";
				table+="</a>";
				
				//����Ϊ�༭����
				
				
				
				
				table+="<br>";
				
				table+="<a href="+"#"+"";
				table+=" onclick="+"delusers("+rs.getInt(1)+");"+"";
				table+=">";
				table+="ɾ��";
				table+="</a>";
				
				table+="</td>";
				
				table+="</tr>";
				
			}
			
			table+="</table>";
			
    	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	//�����ݴ���ȥ
    	response.getWriter().write(table);
    }

}
