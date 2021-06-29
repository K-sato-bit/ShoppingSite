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

/**
 * Servlet implementation class CartDelete
 */
@WebServlet("/servlet/cart-delete")
public class CartDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDelete() {
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
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		List<SiteBean> cart = (List<SiteBean>)session.getAttribute("cart");
		
		for(SiteBean site : cart) {
			
			if(site.getNum() == num) {
				cart.remove(site);
				break;
				
			}
		}
		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher("../jsp/cart.jsp");
		rd.forward(request, response);	
	}

}
