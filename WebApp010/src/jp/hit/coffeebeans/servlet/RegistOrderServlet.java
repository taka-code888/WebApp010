package jp.hit.coffeebeans.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.hit.coffeebeans.bean.Order;
import jp.hit.coffeebeans.service.OrderManager;
import jp.hit.coffeebeans.service.ServiceException;

/**
 * Servlet implementation class RegistOrderServlet
 */
@WebServlet("/RegistOrderServlet")
public class RegistOrderServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
		
		// 入力値の文字コード設定
		request.setCharacterEncoding("UTF-8");
		
		// 入力値の取得
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String telNumber = request.getParameter("telNumber");
		
		// Orderクラスのインスタンス作成
		Order order = new Order();
		order.setName(name);
		order.setAddress(address);
		order.setTelNumber(telNumber);
		order.setItemId(itemId);
		
		// 注文情報の追加と注文IDの取得
		int orderId = new OrderManager().regist(order);
			
		// 注文IDをリクエスト・スコープに格納
		request.setAttribute("orderId", orderId);
			
		
		// orderComplete.jspへフォワード
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/orderComplete.jsp");
		requestDispatcher.forward(request, response);
		
		} catch (ServiceException e) {
			e.printStackTrace();
			
			// error.htmlへリダイレクト
			response.sendRedirect("error.html");
		}

	}

}
