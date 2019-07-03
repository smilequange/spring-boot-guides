package cn.jantd.exception.dao;

import cn.jantd.exception.exception.DaoException;
import org.springframework.stereotype.Component;

@Component(value = "testDao")
public class TestDao {
  public void throwDaoException(boolean throwException) throws DaoException {
    if (throwException) {
      throw new DaoException("dao throw exception");
    }
  }
}
