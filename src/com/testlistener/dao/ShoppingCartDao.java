package com.testlistener.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShoppingCartDao extends BaseDao{
	
Connection conn=getConn();
	
	//��õ�¼�˺�
	
	public int getVipCount(String managerName,String managerpassword)
	{
		
		//String sql="select count(*) from vip where account=? and email=?";
		String sql="select count(*) from manager where managerName=? and managerpassword=?";
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, managerName);
			statement.setString(2, managerpassword);
			ResultSet rs=statement.executeQuery();
			
			//ֻ�ҵ��������ĵ�һ������
			rs.next();
			
			//����һ���˺�
			return rs.getInt(1);
		} catch (SQLException e) {
 
		}

		
	return 0;	
	}

	
	//Ĭ�ϵ��ø�����޲ι��캯��
	
	
	public Boolean insertshoppingcart(int productId,int usersId,int productnum)
	{
		
		Boolean  bool = null;
		
		//String sql = "insert into vip (account,email,scare,stament,aihao) values ('"+account+"','"+email+"','"+scare+"','"+stament+"','"+aihao+"')";
		
		String sql = "insert into shoppingcart (productId,usersId,productnum) values (?,?,?)";
		try {
			java.sql.PreparedStatement statement =conn.prepareStatement(sql);
			
			statement.setInt(1,productId);
			statement.setInt(2,usersId);
			statement.setInt(3,productnum);
			
			
		int count=statement.executeUpdate();
		
		if(count>0)
		{
			bool=true;
			
		}
		else
		{
			bool=false;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				//ִ�����ӣ�ɾ�����޸ģ�����ҵ��ú�����ͬ
				//int count=statement.executeUpdate(sql);
		return bool;
		
	}
	
	
	
	public Boolean delVip(int id)
	{
		
		Boolean  bool = null;
		
		//String sql = "insert into vip (account,email,scare,stament,aihao) values ('"+account+"','"+email+"','"+scare+"','"+stament+"','"+aihao+"')";
		
		String sql = "delete from vip where id=?";
		try {
			java.sql.PreparedStatement statement =conn.prepareStatement(sql);
			
			statement.setInt(1,id);
			
		int count=statement.executeUpdate();
		
		if(count>0)
		{
			bool=true;
			
		}
		else
		{
			bool=false;
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				//ִ�����ӣ�ɾ�����޸ģ�����ҵ��ú�����ͬ
				//int count=statement.executeUpdate(sql);
		return bool;
		
	}
	
	
	
	
	
	public ResultSet selectshoppingcart(String condition)
	{
		ResultSet rs = null;
		
		
		String sql="select *from shoppingcart where 1=1 ";
		//String sql="select *from vip ";
		sql=sql+condition;
				
		
		try {
			Statement statement=conn.createStatement();
			
			
			//������ص��ǽ����
			rs=statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}
	
	

	public int selectParentid(String condition)
	{
		int id = 0;
		ResultSet rs=null;
		
		String sql="select typeParentid from producttype where 1=1 ";
		//String sql="select *from vip ";
		sql=sql+condition;
				
		
		try {
			Statement statement=conn.createStatement();
			
			
			//������ص��ǽ����
			rs=statement.executeQuery(sql);
			
			//rs.next()���Ƶ���һ������
			rs.next();
			id=rs.getInt("typeParentid");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}

	
//	public int selectParentTypeid(String condition)
//	{
//		int id = 0;
//		ResultSet rs=null;
//		
//		String sql="select * from producttype as a,product as b where 1=1 and a.producttypeId=b.producttypeId ";
//		//String sql="select *from vip ";
//		sql=sql+condition;
//				
//		
//		try {
//			Statement statement=conn.createStatement();
//			
//			
//			//������ص��ǽ����
//			rs=statement.executeQuery(sql);
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			id=rs.getInt(2);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return id;
//	}

}
