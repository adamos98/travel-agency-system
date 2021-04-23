package pl.softserve.dao;

import pl.softserve.Models.User;

import java.util.List;

public interface UserDAO {

    public void addUser(User u);
    public void updateUser(User u);
    public List<User> listUsers();
    public User getUserById(int id);
    public void removePerson(int id);

}
