package com.tenco;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8080/hello/my-servlet
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyServlet() {
		super();
		// 생성자 호출
		System.out.println("생성자 호출1");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init 호출2");
	}

	// 클라이언트가 매번 요청을 한느데 매번 호출이 될까?
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("서비스 메서드 호출 확인3");
		response.setContentType("text/html;charset=utf-8");
		// 부모 클래스 메서드 호출
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet 메서드 호출4-1");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost 메서드 호출4-2");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destory호출");
	}

}
