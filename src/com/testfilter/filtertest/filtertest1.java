package com.testfilter.filtertest;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class filtertest1
 */
@WebFilter(filterName = "author",
initParams = { @WebInitParam(name = "chartSet", value = "utf-8") },
urlPatterns = "/*",
dispatcherTypes = {
		DispatcherType.REQUEST, DispatcherType.FORWARD })


//������治дforword����  ����.forword�Ͳ���ִ��
//�����Ҫ���������е�Servlet �ҵ�serverlet������.do��β�� ��urlPatterns Ӧ��д��*.do
public class filtertest1 implements Filter {
	private FilterConfig config;
    /**
     * Default constructor. 
     */
    public filtertest1() {
        // TODO Auto-generated constructor stub FourWeb
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ��ȡ��ʼ���Ĳ���
		String charset = config.getInitParameter("chartSet");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		// �������ַ���  ��������
		httpRequest.setCharacterEncoding(charset);
		httpResponse.setCharacterEncoding(charset);
		// ���е�½�жϵ��߼�
		// ��ȡ���ʵ�ַ
		String requestPath = httpRequest.getServletPath();
		Object sessionName = httpRequest.getSession(true).getAttribute(
				"account");
		
		//���������ҳ�������login.jspҳ�������logsession.doֱ���������в���||requestPath.endsWith("addserverlet.do")
		if(requestPath.endsWith("login.jsp")||requestPath.endsWith("logsession.do")||requestPath.endsWith("addserverlet.do")||requestPath.endsWith("senddataseverlet.do")||requestPath.contains("android"))
		{
			//����ִ�з������߼�
			chain.doFilter(request, response);
		}
		else
		{
			if(sessionName!=null)
			{
				//������һ����������������β����о�һ�������� ����ʾlogin.jspҳ��Ϳ���
				chain.doFilter(request, response);
			}
			else
			{
				//httpResponse.getWriter().write("���ȵ�½");
			    //httpResponse.sendRedirect("login.jsp");
				
				//��2����������Ҫ����login.jspҳ��  �ٵ�servlet���� �ٵ�main.jsp��������ٷ�����
				//����if(sessionName!=null)���
				httpRequest.getRequestDispatcher("login.jsp")
				.forward(httpRequest, httpResponse);
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		this.config = fConfig;
	}

}
