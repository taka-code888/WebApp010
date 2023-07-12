package jp.hit.coffeebeans.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.hit.coffeebeans.bean.Item;
import jp.hit.coffeebeans.service.ItemManager;
import jp.hit.coffeebeans.service.ServiceException;

/**
 * Servlet implementation class FindItemServlet
 */
@WebServlet("/FindItemServlet")
public class FindItemServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    //public FindItemServlet() {
        //super();
        // TODO Auto-generated constructor stub
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
		// 入力値のコード設定
		request.setCharacterEncoding("UTF-8");
		
		// 原産地域の取得
		String area = request.getParameter("area");

		// 原産地域からコーヒー豆の情報を取得↓
		List<Item> items = new ItemManager().findByArea(area);
		
		// コーヒー豆の情報をリクエスト・スコープに格納
		request.setAttribute("items", items);
		
		// itemList.jspへフォワード
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/itemList.jsp");
		requestDispatcher.forward(request, response);
	
	} catch (ServiceException e) {
		e.printStackTrace();
		// error.htmlへリダイレクト
		response.sendRedirect("error.html");
	}
}
	

}
