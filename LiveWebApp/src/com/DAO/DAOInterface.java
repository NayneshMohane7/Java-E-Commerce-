package com.DAO;

import com.bean.User;

public interface DAOInterface {
      public boolean insertUser(User u);
      public User retriveUser(String username);
      public int getPrice(String gadget);
}
