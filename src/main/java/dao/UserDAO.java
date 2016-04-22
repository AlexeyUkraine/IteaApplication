package dao;

import model.User;

import java.util.List;

/**
 * Created by Alexey.Savchuk on 15.04.2016.
 */
public interface UserDAO {

    long saveUser(User user); //save

    void deleteUserById(long user_id); //delete by id

    void updateUser(long user_id, String firstName, String secondName, int mobile); //update

    List<User> findAllUsers();  //find all

    User findById(long user_id);     //find by id

}
