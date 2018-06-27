package com.send.datatest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class senddataseverlet
 */
@WebServlet("/senddataseverlet.do")
public class senddataseverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public senddataseverlet() {
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
		
		
		try {
			
			//��ʼ�ϴ�
			smart.upload();
			
			//���浽�����  countΪ�����ļ�������  �����������Ķ���
			//int count = smart.save("d:/upload");
			
			
			//�����ļ����� ����abc
			String name=smart.getRequest().getParameter("dataname");
			
			
			//�ļ��ĺ�׺��   ����jpg
			String  ext=smart.getFiles().getFile(0).getFileExt();
			
			//���Ϊƴ���ļ���·�� �������������abc.jpg
			smart.getFiles().getFile(0).saveAs("d:/upload/"+name+"."+ext);
			
			//��ȡ�ļ�ȫ��
			String fileName = smart.getFiles().getFile(0).getFileName();
			 
			//����
			response.getWriter().write(name+":"+fileName+"."+ext);
			
			
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
