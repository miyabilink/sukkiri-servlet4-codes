package model;

import dao.MuttersDAO;

public class PostMutterLogic {
  public void execute(Mutter mutter) { 
    MuttersDAO dao = new MuttersDAO();
    dao.create(mutter);
  }
}