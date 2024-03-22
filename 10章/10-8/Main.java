package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Mutter;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // つぶやきリストをアプリケーションスコープから取得
    ServletContext application = this.getServletContext();
    List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
    // 取得できなかった場合は、つぶやきリストを新規作成して
    // アプリケーションスコープに保存
    if (mutterList == null) {
      mutterList = new ArrayList<>();
      application.setAttribute("mutterList", mutterList);
    }
    
    // ログインしているか確認するため
    // セッションスコープからユーザー情報を取得
    HttpSession session = request.getSession();
    User loginUser = (User) session.getAttribute("loginUser");
    
    if (loginUser == null) { // ログインしていない場合
      // リダイレクト
      response.sendRedirect("index.jsp");
    } else { // ログイン済みの場合
      // フォワード
      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
      dispatcher.forward(request, response);
    }
  }
}