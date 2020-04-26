package com.tulin.platform_system.task;

import com.tulin.api.user.UserService;
import com.tulin.common.base.controller.ServerResponse;
import com.tulin.common.enums.UserErrorEnum;
import com.tulin.common.utlis.validator.Validator;
import com.tulin.platform_model.dao.UserDao;
import com.tulin.platform_model.dto.UserLoginDTO;
import com.tulin.platform_model.model.User;
import com.tulin.platform_model.vo.request.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class UserServiceImpl extends Validator implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public ServerResponse<UserLoginDTO> login(UserLoginRequest request) {
        notNull("电话号码", request.getTel());

        User user = userDao.queryByUserName(request.getRealName());
        //校验用户
        if (Objects.isNull(user)){
            return ServerResponse.createByErrorEnum(UserErrorEnum.用户不存在);
        }

        UserLoginDTO vo = new UserLoginDTO();
        vo.setNickName(user.getNickName());
        vo.setRealName(user.getRealName());
        vo.setTel(user.getTel());

        return ServerResponse.createBySuccess(vo);
    }
}
