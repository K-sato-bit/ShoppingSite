package jp.co.aforce.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.Bean.SiteBean;
import jp.co.aforce.DAO.SiteDAO;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/servlet/edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
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
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		//DAO生成
		SiteDAO dao = new SiteDAO();
		
		try {
			SiteBean site = dao.select(num);
			
			//セッションオブジェクト取得
			HttpSession session = request.getSession();
			
			//セッションスコープへの属性設定
			session.setAttribute("site", site);
			
		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		}
		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher("../jsp/edit.jsp");
			rd.forward(request, response);
		}
	}