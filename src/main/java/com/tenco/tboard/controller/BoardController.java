package com.tenco.tboard.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	// BoardRepository 추가 예정
    } // end of init()

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("doGet : " +request.getPathInfo());
		
		// TODO 인증처리는 추후 추가
		
		switch (action) {
		case "/create":
			// 게시글 생성 페이지 이동 처리
			break;
			
		case "/list":
			// 게시글 리스트 페이지 이동 처리
			handleListBoards(request, response);
			break;

		default:
			break;
		}
		
		
	} // end of doGet(HttpServletRequest request, HttpServletResponse response)
	
	/**
	 * 페이징 처리를 해야한다. (중요)
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void handleListBoards(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * select * 
			from board
			order by created_at asc
			limit ? offset ?;
		 */
		
		// 게시글 목록 조회 기능 
		int page = 1; // 기본 페이지 번호
		int pageSize = 3; // 한 페이지 당 보여질 게시글에 수 
		
		try {
			String pageStr = request.getParameter("page");
			if(pageStr != null) {
				page = Integer.parseInt(pageStr);
			}
			
		} catch (Exception e) {
			// 유효하지 않는 번호를 마음대로 보낼 경우
			page = 1;
		}
		
		// pageSize --> 3이다. 
		// page 1, page 2, page 3 요청 동적으로 시작값을 계산하는 산수 공식 넣기
		int offset = (page - 1) * pageSize; // 시작 위치 계산 (offset 값 계산을 산수공식을 만들어야한다.)
		
		
		System.out.println("page : " + page);
		System.out.println("offset : " + offset);
		
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	} // end of handleListBoards(HttpServletRequest request, HttpServletResponse response)

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	} // end of doPost(HttpServletRequest request, HttpServletResponse response)

}
