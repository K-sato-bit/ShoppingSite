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

import jp.co.aforce.Bean.SiteBean;
import jp.co.aforce.DAO.SiteDAO;

/**
 * Servlet implementation class MenuAd
 */
@WebServlet("/servlet/menu-ad")
public class MenuAd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuAd() {
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
		
		List<SiteBean> siteList = null;

		// DAO生成
		SiteDAO dao = new SiteDAO();

		try {
			//DAOの利用
			siteList = dao.selectAll();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		//リクエストスコープ設定
		request.setAttribute("siteList",siteList);

		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher("../jsp/menu-ad.jsp");
		rd.forward(request, response);
	}

}