package jp.co.aforce.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
 * Servlet implementation class Menu
 */
@WebServlet("/servlet/menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
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

		//セッション取得
		HttpSession session = request.getSession();
		
		//転送先
		String url = null;

		if (session.getAttribute("username") != null) {

			url = "../jsp/menu.jsp";

		} else {
			url = "../jsp/login.jsp";

		}

		// DAO生成
		SiteDAO dao = new SiteDAO();
		
		List<SiteBean> siteList = null;
		

		try {
			//DAOの利用
			siteList = dao.selectAll();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		//セッション設定
		session.setAttribute("siteList",siteList);

		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}