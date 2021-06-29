package jp.co.aforce.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class Order
 */
@WebServlet("/servlet/order1")
public class Order1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order1() {
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
		
		int total = 0;
		
		int sub_total = 0;
		
		List<SiteBean> cart = (List<SiteBean>)session.getAttribute("cart");
		
		for(SiteBean site : cart) {
			
			sub_total = site.getPrice() * site.getAlbum_count();
			
			site.setSub_total(sub_total);
			
			total += sub_total;
		}
		
		SiteBean userinfo = new SiteBean();
		
		userinfo.setTotal(total);
		
		String username = (String)session.getAttribute("username");
		
		userinfo.setUsername(username);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String str = sdf.format(timestamp);
		String cart_no = "A" + str;
		
		userinfo.setCart_no(cart_no);
		
		session.setAttribute("userinfo", userinfo);
		
		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher("../jsp/order.jsp");
		rd.forward(request, response);
	}

}
