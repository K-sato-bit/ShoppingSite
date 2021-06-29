package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.Bean.SiteBean;

/**
 * Servlet implementation class InsertCheck
 */
@WebServlet("/servlet/insert-check")
public class InsertCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//転送先
		String url = null;
		
		if(request.getParameter("image").equals("") || request.getParameter("album_name").equals("") || request.getParameter("day").equals("") || request.getParameter("price").equals("")) {
			//未入力項目がある場合
			url = "../jsp/insert.jsp";
			request.setAttribute("message", "*エラー　未入力項目があります。");
			
		}else {

			url = "../jsp/insert-check.jsp";

			//リクエストパラメータ取得
			int num = Integer.parseInt(request.getParameter("num"));
			String image = request.getParameter("image");
			String album_name = request.getParameter("album_name");
			String day = request.getParameter("day");
			int price = Integer.parseInt(request.getParameter("price"));
			
			//セッション取得
			HttpSession session = request.getSession();

			SiteBean site = new SiteBean();

			site.setNum(num);
			site.setImage(image);
			site.setAlbum_name(album_name);
			site.setDay(day);
			site.setPrice(price);
			
			//セッション設定
		    session.setAttribute("site", site);

		}
		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
