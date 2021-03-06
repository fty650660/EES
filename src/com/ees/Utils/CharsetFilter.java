package com.ees.Utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter {

	private String charset;
	private boolean enabled;

	public void init(FilterConfig config) throws ServletException {

		System.out.println("初始化编码过滤器");
		this.charset = config.getInitParameter("charset");		 
		this.enabled = "true".equals(config.getInitParameter("enabled"));
		System.out.println("字符编码：" + charset + "    是否启用" + enabled);
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (enabled && charset != null) {
			request.setCharacterEncoding(charset);
			response.setCharacterEncoding(charset);
		}

      
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		System.out.println("销毁编码过滤器");
	}

}
