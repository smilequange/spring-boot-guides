package cn.jantd.jpa.service;

import cn.jantd.jpa.model.UserDetail;
import cn.jantd.jpa.param.UserDetailParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserDetailService {
     Page<UserDetail> findByCondition(UserDetailParam detailParam, Pageable pageable);
}
