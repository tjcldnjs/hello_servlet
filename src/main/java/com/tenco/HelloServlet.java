package com.tenco;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServlet 클래스를 상속받아서 내가 정의한 클래스가 선언이 된다. why? HTTP 프로토콜을 통한 request,
 * response 처리를 할 수 있기 때문
 * 
 * URL 맵핑에 대한 개념을 알자. 클라이언트가 특정 URL을 요청했을 때 해당 URL에 대응하는 서블릿을 실행하도록 설정하는 것을 의미
 * 합니다. URL 맵핑 - 2가지 방법 알아 보자.
 */

 @WebServlet(urlPatterns = "/example", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 생성자
	public HelloServlet() {
		super();
		System.out.println("생성자가 호출 됨");
	}

	// 해당 서블릿 클래스가 인스턴스화 될 때 단 한번 실행 하는 메서드 이다.
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 메서드가 호출 됨");
	}

	// 메모리에서 내려가기 직전에 호출 되는 메서드이다.
	public void destroy() {
		System.out.println("destroy() 메서드가 호출");
	}

	// GET 요청으로 들어 올 때 동작 됨
	// 주소 설계 - http://localhost:8080/hello/hello-servlet
	// 주소 설계 - http://localhost:8080/hello/hello-servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// MIME TYPE - 인터넷 세상에서 데이터의 유형을 나타내는 표준 방식
		System.out.println("doGet");

		// response.setContentType("text/html;charset=utf-8"); 문자 형식/ <> html
		response.setContentType("application/pdf");
		response.setCharacterEncoding("UTF-8");

		// 스트림을 어디에서 뽑아야 될까?
		// http 통신할때는 프린트라이터가 더 효과적임
		response.getWriter().write("<html><body><h1>HELLO</h1></body></html>");

	}

	// POST 요청으로 들어 올 때 동작 됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("POST 작동");
		// 문제 -> post 요청이 들어오는것을 확인하고
		// 응용해서 데이터 또는 html 형식으로 응답처리 하시오!

		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().write("""
								<!DOCTYPE html>
				<html lang="en">
				<head>
				    <meta charset="UTF-8">
				    <meta name="viewport" content="width=device-width, initial-scale=1.0">
				    <title>Document</title>
				</head>
				<body>
				    <section>
				        <p style="color:red">Hello Frist srvlet 반가워</p>
				    </section>
				</body>
				</html>
								""");

	}

}
