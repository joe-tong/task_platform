package com.tulin.api.user;

import com.tulin.common.base.controller.ServerResponse;
import com.tulin.platform_model.dto.UserLoginDTO;
import com.tulin.platform_model.vo.request.UserLoginRequest;

public interface UserService {

    ServerResponse<UserLoginDTO> login(UserLoginRequest request);
}
