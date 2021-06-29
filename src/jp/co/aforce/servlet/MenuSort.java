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
 * Servlet implementation class MenuSort
 */
@WebServlet("/servlet/menu-sort")
public class MenuSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuSort() {
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
		String c = request.getParameter("c");
		String ex = request.getParameter("ex");
		String a = request.getParameter("a");
		//String z = request.getParameter("z");
		
		// DAO生成
		SiteDAO dao = new SiteDAO();

	//価格が安い順
		if (c != null) {
			List<SiteBean> cheapList = null;

			try {
				//DAOの利用
				cheapList = dao.cheap();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			//セッション設定
			session.setAttribute("cheapList",cheapList);
			
			url = "../jsp/menu-c.jsp";
			
	//価格が高い順
		} else if (ex != null){
			List<SiteBean> expensiveList = null;
			
			try {
				//DAOの利用
				expensiveList = dao.expensive();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			//セッション設定
			session.setAttribute("expensiveList",expensiveList);
			
			url = "../jsp/menu-e.jsp";
			
	//商品名A~Z
		} else if (a != null){
			List<SiteBean> azList = null;
				
			try {
				//DAOの利用
				azList = dao.az();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			//セッション設定
			session.setAttribute("azList",azList);
		
			url = "../jsp/menu-a.jsp";
	
	//商品名Z~A
		} else {
			List<SiteBean> zaList = null;
			
			try {
				//DAOの利用
				zaList = dao.za();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			//セッション設定
			session.setAttribute("zaList",zaList);
		
			url = "../jsp/menu-z.jsp";
		}

		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}


