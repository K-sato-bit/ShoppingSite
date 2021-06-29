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
 * Servlet implementation class UpdateCheck
 */
@WebServlet("/servlet/update-check")
public class UpdateCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCheck() {
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
		
		//セッションオブジェクト取得
		HttpSession session = request.getSession();
		
		//セッションスコープから属性値の取得
		SiteBean site = (SiteBean) session.getAttribute("site");
		
		//DAO生成
		SiteDAO dao = new SiteDAO();
		
		int count = 0; //処理件数
		
		try {
			//DAO利用
			count = dao.update(site);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//リクエストスコープへの属性設定
		request.setAttribute("count", count);
		
		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher("../jsp/update-result.jsp");
			rd.forward(request, response);
		}
	}