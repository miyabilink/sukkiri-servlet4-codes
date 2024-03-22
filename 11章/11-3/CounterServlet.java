package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /*
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    // 訪問回数を表すIntegerインスタンスを新規作成し
    // アプリケーションスコープに保存
    Integer count = 0;
    ServletContext application = config.getServletContext();
    application.setAttribute("count", count);

    System.out.println("init()が実行されました");
  }
  */

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /// アプリケーションスコープに保存された訪問回数を増加
	 ServletContext application = this.getServletContext();
	 Integer count = (Integer)application.getAttribute("count");
	 count++;
	 application.setAttribute("count", count);

    // HTMLを出力
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\" />");
    out.println("<title>訪問回数を表示</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p>訪問回数：" + count + "</p>");
    out.println("<a href=\"CounterServlet\">更新</a>");
    out.println("</body>");
    out.println("</html>");
  }
  public void destroy() {
    System.out.println("destroy()が実行されました");
  }
}