package jp.co.aforce.servlet;

import java.io.IOException;
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
 * Servlet implementation class Order2
 */
@WebServlet("/servlet/order2")
public class Order2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order2() {
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
		
		List<SiteBean> cart = (List<SiteBean>)session.getAttribute("cart");
		
		SiteBean userinfo = (SiteBean)session.getAttribute("userinfo");
		
		SiteDAO dao = new SiteDAO();
		
		String url = null;
		
		try {
		
		if(cart == null || !dao.insert(cart, userinfo)) {
			//できない場合
			url = "..jsp/order-error.jsp";
			
		}else {
			session.removeAttribute("cart");
			
			url = "../jsp/order-result.jsp";
			
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		
	}

}
