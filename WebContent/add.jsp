<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>
<body>
	<form action="addserverlet.do" method="post"
		enctype="multipart/form-data">
		<h1>����</h1>


		<p>
			���ƣ�<input type="text" name="name" />
		</p>
		<p>
			���ࣺ<select name="stament1">

				<option value=""></option>
				<option value="1 ">��װ</option>
				<option value="3">�ҵ�</option>

				<option value="10 ">��ױ</option>
				<option value="11 ">ĸӤ</option>
				<option value="12 ">Ƥ��</option>

				<option value="13 ">ʳƷ</option>
			</select> &nbsp;&nbsp;&nbsp;&nbsp; �������ࣺ<select name="stament2">
				<option value=""></option>
				<option value="5">Ƥ��</option>
				<option value="4">�ʵ�</option>
				<option value="2">Ƥѥ</option>

			</select>
		</p>
		<p>
			�۸�<input type="text" name="price" /> ԭ�ۣ�<input type="text"
				name="yuanlai_price" />
		</p>
		<p>
			��棺<input type="text" name="kucun" /> ʱ�䣺 <input type="text"
				name="time" />
		</p>
		<p>
			ͼƬ�� <img alt="" /><br> <input type="text"
				name="dataname" /> <br> <input type="file" name="file" /> <br>
			�����ϴ�10��ͼƬ��ÿ��ͼƬ������5M<br>
		<p>
			����
			<textarea rows="10" cols="30" name="introduction">
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