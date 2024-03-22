package model;

import dao.AccountsDAO;

public class LoginLogic {
  public boolean execute(Login login) {
    AccountsDAO dao = new AccountsDAO();
    Account account = dao.findByLogin(login);
    return account != null;
  }
}