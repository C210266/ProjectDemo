package ra.service;

import ra.model.User;

public class UserService {
    private User[] listUsers = new User[100];
    private int size = 0;

    public UserService() {
        User user = new User(1, "khanh", "123456", (byte) 1);
    }

    public User[] getAll() {
        return listUsers;
    }

    public int getSize() {
        return size;
    }

    public boolean save(User user) {
//        add
        if (findById(user.getId()) == null) {
            if (size == listUsers.length) {
                System.err.println("Danh sach full roi");
                return false;
            } else {
                for (int i = 0; i < listUsers.length; i++) {
                    if (listUsers[i] == null) {
                        listUsers[i] = user;
                        break;
                    }
                }
                System.out.println("Them moi thanh oong");
                size++;
                return true;
            }
        } else {
//            update
            for (int i = 0; i < listUsers.length; i++) {
                if (listUsers[i] != null && listUsers[i].getId() == user.getId()) {
                    listUsers[i] = user;
                    break;
                }
            }
            System.out.println("Cap nhat thanh cong");
            return true;
        }
    }

    public User findById(int id) {
        for (User user : listUsers) {
            if (user != null) {
                if (user.getId() == id) {
                    return user;
                }
            }
        }
        return null;
    }

    public boolean delete(int id) {
        if (findById(id) != null) {
            for (int i = 0; i < listUsers.length; i++) {
                if (listUsers[i] != null && listUsers[i].getId() == id) {
                    listUsers[i] = null;
                }
            }
            size--;
            System.out.println("Xoa thanh cong");
            return true;
        } else {
            System.out.println("Ko tim thay doi tuong");
            return false;
        }

    }

    public User login(String username, String password) {
        for (User user : listUsers) {
            if (user != null && user.getUserName().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)) {
                return user;
            }
        }
        return null;
    }

    public int getNewId() {
        int max = 0;
        for (User user : listUsers) {
            if (user != null) {
                if (user.getId() > max) {
                    if (user.getId() >= max) {
                        max = user.getId();
                    }
                }
            }
        }
        return max + 1;
    }

}
