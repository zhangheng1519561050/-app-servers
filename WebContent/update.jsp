<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>   
    
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>
	<form action="updateserverlet.do?productId=${product.productId}" method="post"
		enctype="multipart/form-data">
		<h1>�༭</h1>


		<p>
			���ƣ�<input type="text" name="name" value="${product.productName}"/>
		</p>
		<p>
			���ࣺ<select name="stament1">

				<option value=""></option>
				<option value="1 " selected="selected">��װ</option>
				<option value="3">�ҵ�</option>

				<option value="10 ">��ױ</option>
				<option value="11 ">ĸӤ</option>
				<option value="12 ">Ƥ��</option>

				<option value="13 ">ʳƷ</option>
			</select> &nbsp;&nbsp;&nbsp;&nbsp; �������ࣺ<select name="stament2">
				<option value=""></option>
				<option value="5">Ƥ��</option>
				<option value="4">�ʵ�</option>
				<option value="2" selected="selected">Ƥѥ</option>

			</select>
		</p>
		<p>
			�۸�<input type="text" name="price" value="${product.productprice}"/> ԭ�ۣ�<input type="text"
				name="yuanlai_price" value="${product.productprice}"/>
		</p>
		<p>
			��棺<input type="text" name="kucun" value="${product.productInventory}"/> ʱ�䣺 <input type="text"
				name="time"  value="${product.posttime}"/>
		</p>
		<p>
			ͼƬ�� <img alt="" src="getimageforandroid.do?id=${product.productId}"/><br> <input type="text"
				name="dataname" /> <br> <input type="file" name="file" /> <br>
			�����ϴ�10��ͼƬ��ÿ��ͼƬ������5M<br>
		<p>
			����
			<textarea rows="10" cols="30" name="introduction"> ${product.productIntroduction}
</textarea>
		</p>
		<p>
			<input type="submit" id="but" value="ȷ��" />

			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			<button>ȡ��</button>
		</p>
	</form>
</body>
</html>