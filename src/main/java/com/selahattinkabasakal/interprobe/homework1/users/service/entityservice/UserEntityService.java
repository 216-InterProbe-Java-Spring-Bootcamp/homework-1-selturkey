package com.selahattinkabasakal.interprobe.homework1.users.service.entityservice;

import com.selahattinkabasakal.interprobe.homework1.generic.entity.BaseEntity;
import com.selahattinkabasakal.interprobe.homework1.generic.service.BaseEntityService;
import com.selahattinkabasakal.interprobe.homework1.users.dao.UsersDao;
import com.selahattinkabasakal.interprobe.homework1.users.entity.Users;
import org.springframework.stereotype.Service;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
@Service
public class UserEntityService extends BaseEntityService<Users, UsersDao> {
    public UserEntityService(UsersDao dao) {
        super(dao);
    }
}
