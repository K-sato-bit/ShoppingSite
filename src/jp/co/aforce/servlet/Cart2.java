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
 * Servlet implementation class Cart2
 */
@WebServlet("/servlet/cart2")
public class Cart2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart2() {
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
				
		//m_cartのリストを取得
		List<SiteBean> cart = (List<SiteBean>)session.getAttribute("cart");
				
		//m_albumのリストを取得
		List<SiteBean> siteList = (List<SiteBean>)session.getAttribute("siteList");
		
		//これから追加する商品(num)がカートにあるか(存在しない場合)
		for(SiteBean site : siteList) {
			
				
				if(site.getNum() == num) {
							
				SiteDAO dao = new SiteDAO();
				
				SiteBean album = new SiteBean();
				
				try {
					album = dao.select(num);
					
				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
				}
				album.setAlbum_count(1);
				cart.add(album);
			}
		}		
		
		session.setAttribute("cart", cart);
		
		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher("../jsp/cart.jsp");
		rd.forward(request, response);
	}
}

