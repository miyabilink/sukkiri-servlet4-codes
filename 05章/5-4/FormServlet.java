package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメータを取得
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");

    // リクエストパラメータをチェック
    String errorMsg = "";
    if (name == null || name.length() == 0) {
      errorMsg += "名前が入力されていません<br>";
    }
    if (gender == null || gender.length() == 0) {
      errorMsg += "性別が選択されていません<br>";
    } else {
      if (gender.equals("0")) { gender = "男性"; }
      else if (gender.equals("1")) { gender = "女性"; }
    }

    // 表示するメッセージを設定
    String msg = name + "さん（" + gender + "）を登録しました";
    if (errorMsg.length() != 0) {
      msg = errorMsg;
    }

    // HTMLを出力
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html >");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>ユーザー登録結果</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p>" + msg + "</p>");
    out.println("</body>");
    out.println("</html>");
  }
}