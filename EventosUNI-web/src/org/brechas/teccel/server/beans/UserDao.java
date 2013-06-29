package org.brechas.teccel.server.beans;

public class UserDao extends BaseDao<User> {
    public UserDao() {
        super(User.class);
    }
    public User findByGoogleId(String googleId) {
        return ofy().load().type(User.class).filter("googleId =", googleId).first().now();
    }
}
