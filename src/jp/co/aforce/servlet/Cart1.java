package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class Cart1
 */
@WebServlet("/servlet/cart1")
public class Cart1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart1() {
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
		
		//カートに追加する商品番号(num)取得
		int num = Integer.parseInt(request.getParameter("num"));
		
		String url = "cart2";
		
		//m_cartのリストを取得
		List<SiteBean> cart = (List<SiteBean>)session.getAttribute("cart");
		
			if(cart == null) {
			cart = new ArrayList<SiteBean>();
			session.setAttribute("cart", cart);
			
		}
			
		//これから追加する商品(num)がカートにあるか(存在する場合)
		for(SiteBean site : cart) {
			
			if(site.getNum() == num) {
			site.setAlbum_count(site.getAlbum_count() + 1);
			url = "../jsp/cart.jsp";
				
			}
		}
		request.setAttribute("num", num);
		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
