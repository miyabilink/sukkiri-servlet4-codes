package model;

import java.util.List;
import dao.MuttersDAO;

public class GetMutterListLogic {
  public List<Mutter> execute() {
    MuttersDAO dao = new MuttersDAO();
    List<Mutter> mutterList = dao.findAll();
    return mutterList;
  }
}