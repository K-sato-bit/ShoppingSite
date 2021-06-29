package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.DAO.SiteDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/servlet/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		String ad = "Administrator";
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		try {
			// DAO生成
			SiteDAO dao = new SiteDAO();

			
			if (request.getParameter("username") .equals(ad)){
				
				//セッション取得
				HttpSession session = request.getSession();

				//セッション設定
				session.setAttribute("username", username);
				session.setAttribute("name", name);
				
				url = "../servlet/menu-ad";
				
			// DAO利用
			} else if (dao.loginCheck(username, password)) {

				//セッション取得
				HttpSession session = request.getSession();

				//セッション設定
				session.setAttribute("username", username);
				session.setAttribute("name", name);
				
				url = "../servlet/menu";

			} else {
				//
				url = "../jsp/login.jsp";
				
				request.setAttribute("message", "*エラー　USERNAMEまたはPASSWORDが正しくありません。");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
