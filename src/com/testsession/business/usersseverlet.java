package com.testsession.business;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;
import com.testlistener.dao.UsersDao;

/**
 * Servlet implementation class managerseverlet
 */
@WebServlet("/usersseverlet.do")
public class usersseverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usersseverlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request , HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		
		String condition="";
		String account=request.getParameter("account");
		String email=request.getParameter("email");
		String stament=request.getParameter("stament");
		
		//���ɾ��id
		String delid=request.getParameter("delid");
		
		
		UsersDao users=new UsersDao();
		
		String pageNo=request.getParameter("pageNo");
    	int	pageNonew=0;
    	if(pageNo!=null&&!pageNo.equals(""))
    	{
    		//Ҫ�ж�һ���Ƿ�Ϊ��  Ҫ��Ϊ�ղ�������ת��
    		pageNonew=Integer.parseInt(pageNo);
    		
    		
    		//û�����ⲽ�����ҵ�1 3
    		//System.out.println(tyForPar);
    	}
		//����һ��
		if(delid==null)
		{
			//System.out.println("��Һ�");
		}
		
		else
		{
			Boolean choose=users.delVip(Integer.parseInt(delid));
		}
		
		
		//Boolean choose=users.delVip(delid);
		
		//System.out.println(Integer.parseInt(delid));
		
		//�Կͻ��˴��������ݽ����ж� ֻ����д�� ""дnull�ᱨ��
		if(account!=null&&!account.equals("") )
		{
			condition+=" and userName='"+account+"'";
			
		}
		
		

		if(email!=null&&!email.equals("") )
		{
			
			condition+=" and userEmail='"+email+"'";
		}
		
		
		
		
		//�Ǹ�option value="" ����ľ��ǿո� �����ǿ�
		if(stament.equals(" "))
		{
			condition+=" ";
			
		}
		
		else
		{
			
			condition+=" and userState='"+stament+"'";
		}
		
	
		

		 condition+= " limit " + pageNonew * 2 + ",2";
		
		ResultSet rs=(ResultSet) users.selectVip(condition);
		
		String table="<table border=1  cellpadding=0 cellspacing=0><tr><th>���</th><th>ɾ��</th><th>ͼƬ</th><th>�ǳ�</th><th>����</th><th>����</th><th>״̬</th><th>����</th></tr>";
		
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
				
				//չʾͼƬ
				table+=" <img src="+rs.getString(8)+">";
				
				table+="</td>";
				
				
				table+="<td>";
				
				table+=rs.getString(2);
				
				table+="</td>";
				
				
				
				table+="<td>";

				table+=rs.getString(5);
				
				
				table+="</td>";
				
				
				table+="<td>";
				
				
				table+=rs.getString(4);
				
				table+="</td>";
				
				
				
				
				table+="<td>";
				
//		  <select id="stament1">
//				<option ></option>
//				<option  value="����">����</option>
//				<option  value="���� ">����</option>
//				selected="selected"
//			</select>
				//�����ж�
				String pd="����";
			if(pd.equals(rs.getString(6)))
				
			{
				
				table+="<select>";
				table+="<option value="+"����"+" selected="+"selected"+">";
				table+="����";
				table+="</option>";
				
				table+="<option value="+"����"+">";
				table+="����";
				table+="</option>";
				table+="</select>";
				
				//table+=rs.getString(6);
			}	
			
			else
			{
				table+="<select>";
				table+="<option value="+"����"+" >";
				table+="����";
				table+="</option>";
				
				table+="<option value="+"����"+"  selected="+"selected"+">";
				table+="����";
				table+="</option>";
				table+="</select>";
			}
				table+="</td>";
				
				
				
				
				
				
				
				
				
				table+="<td>";
				
				//ƴ���ַ�����+���Կ����ǳ���
				//table+="<a herf="+"#"+">ɾ��</a>";
				
				
				//ƴ���ַ�����+���Կ����ǳ���  onclick="delusers();"
				//table+="<a herf="+"#"+">ɾ��</a>";
				table+="<a href="+"#"+"";
				table+=" onclick="+"delusers("+rs.getInt(1)+");"+"";
				table+=">";
				table+="ɾ��";
				table+="</a>";
				
				table+="</td>";
				
				
				table+="</tr>";
				
				
				
				
			}
			
			table+="</table>";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//�����ݴ���ȥ
    	response.getWriter().write(table);
		
		
	}

}
