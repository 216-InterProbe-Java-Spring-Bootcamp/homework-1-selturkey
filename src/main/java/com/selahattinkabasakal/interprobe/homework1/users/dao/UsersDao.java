package com.selahattinkabasakal.interprobe.homework1.users.dao;

import com.selahattinkabasakal.interprobe.homework1.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @created By Selahattin Kabasakal 26/06/2022
 */
public interface UsersDao extends JpaRepository<Users,Long> {
}
