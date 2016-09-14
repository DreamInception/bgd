package com.doro.background.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class LoginFilter extends HttpServlet implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) sRequest;
		HttpServletResponse resp = (HttpServletResponse) sResponse;
		/*String path = req.getContextPath();
		String url = req.getServletPath();
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path;
		HttpSession session = req.getSession(true);*/
		chain.doFilter(req, resp);
//		if ((url.startsWith("/") && (url.startsWith("/register.do")||url.startsWith("/favicon.ico")||url.startsWith("/sysAdminLogin.do")||url.startsWith("/script")||url.startsWith("/images")||url.startsWith("/fonts")||url.startsWith("/font")||url.startsWith("/css")||url.startsWith("/login.do")))) {
//			chain.doFilter(req, resp);
//		} else {
//			String adminName = (String) session.getAttribute("adminName");
//			if (DRUtil.isEmptyObject(adminName)) {
//				resp.setHeader("Cache-Control", "no-store");
//				resp.setDateHeader("Expires", 0);
//				resp.setHeader("Prama", "no-cache");
//				resp.sendRedirect(basePath + "/login.do");
//			} else {
//				chain.doFilter(req, resp);
//			}
//		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
