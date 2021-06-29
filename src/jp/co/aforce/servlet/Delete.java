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
 * Servlet implementation class Delete
 */
@WebServlet("/servlet/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
		

		String url = null; //転送先

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();
		
		//DAO生成
		SiteDAO dao = new SiteDAO();

		//リストに値が入っていれば削除可能
		if (session.getAttribute("site") != null) {

			try {
				dao.delete(Integer.parseInt(request.getParameter("num")));

				url = "../jsp/delete-result.jsp";

			} catch (Exception e) {
				e.printStackTrace();
			}

			// リストに値が入っていなければ削除不可
			} else {
		
				url = "../jsp/delete.jsp";
			
				request.setAttribute("message", "*エラー　もう一度やり直してください。");
		}

		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}



