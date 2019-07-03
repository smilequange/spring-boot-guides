package cn.jantd.exception.service;

import cn.jantd.exception.dao.TestDao;
import cn.jantd.exception.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

  @Autowired
  private TestDao testDao;

  public void throwDaoException(boolean throwException) throws ServiceException {
    testDao.throwDaoException(throwException);
  }

  public void throwServiceException(boolean throwException) throws ServiceException {
    if(throwException){
      throw new ServiceException("service throw exception");
    }
  }
}
