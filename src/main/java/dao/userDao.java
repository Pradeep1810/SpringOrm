/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.UserInfo;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.LockMode;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class userDao {

    private HibernateTemplate hiberTemp;

    @Transactional
    public int insertUser(UserInfo user) {

        Integer s = (Integer) this.hiberTemp.save(user);

        return s;
    }

    @Transactional
    public void deleteUser(int userId) {

        UserInfo user = (UserInfo) this.hiberTemp.get(UserInfo.class, userId);
        this.hiberTemp.delete(user);

    }

    public List<UserInfo> getAllUsers() {
        List<UserInfo> allUsers = this.hiberTemp.loadAll(UserInfo.class);
        return allUsers;
    }

     public UserInfo getUser(int userId) {

        UserInfo gotUser = this.hiberTemp.get(UserInfo.class, userId);

        return gotUser;
    }
     
    @Transactional
    public void userUpdate(UserInfo user) {
       
      
      this.hiberTemp.update(user);
    }

   

    public HibernateTemplate getHiberTemp() {
        return hiberTemp;
    }

    public void setHiberTemp(HibernateTemplate hiberTemp) {
        this.hiberTemp = hiberTemp;
    }

}
