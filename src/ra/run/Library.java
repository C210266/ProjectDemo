package ra.run;

import ra.config.Config;
import ra.controller.UserController;
import ra.model.User;

public class Library {
    static User[] listUser;
    static UserController userController = new UserController();

    public static void main(String[] args) {
        listUser = userController.getAll();
        System.out.println("--------------------------------------------");

        System.out.println("1 . Đăng nhập");
        System.out.println("2 . Đăng kí");
        System.out.println("3 . Thoat");
        int choice = Config.scanner().nextInt();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 3:
                System.out.println("Good bye");
                System.exit(0);
            default:
                System.out.println("Vui long nhap 1 so tu 1 den 3");
        }

    }

    public static void login() {
        System.out.println("Nhap username : ");
        String username = Config.scanner().nextLine();
        System.out.println("Nhap password : ");
        String password = Config.scanner().nextLine();
        User userLogin = userController.login(username, password);
        if (userLogin == null) {
            System.err.println("Sai tai khoan hoac mat khau ");
        } else {
            if (userLogin.getRole() == 1) {
//                admin =>menu admin
                System.out.println("day la trang admin");
                Config.scanner().nextLine();
            } else {
                System.out.println("day la trang user");
                Config.scanner().nextLine();
            }
        }
    }

    public static void register() {
        User newUser = new User();
        int id = userController.getNewId();
        System.out.println("New Id : " + id);
        newUser.setId(id);
        System.out.println("Nhap username : ");
        newUser.setUserName(Config.scanner().nextLine());
        System.out.println("Nhap password : ");
        newUser.setPassword(Config.scanner().nextLine());
        System.out.println("Nhap fullName : ");
        newUser.setFullName(Config.scanner().nextLine());
        System.out.println("Nhap phoneNumber : ");
        newUser.setPhoneNumber(Config.scanner().nextLine());
        System.out.println("Nhap email : ");
        newUser.setEmail(Config.scanner().nextLine());
        userController.save(newUser);
        login();

    }
    public static void menuAdmin(){
        System.out.println("-------------------ADMIN-------------------");
        System.out.println("1 . Quan li danh muc ");
        System.out.println("2 . Quan li sach ");
        System.out.println("3 . Quan li tai khoan ");
        System.out.println("4 .Lich su muon tra sach ");
        System.out.println("5 . Dang xuat ");
        int choice = Config.scanner().nextInt();
        switch (choice){
            case 1 :
//                danh muc
                break;
        }

    }

    public static void menuCategory(){
        System.out.println("----------ADMIN-----------");
        System.out.println("1 . Danh sach danh muc");
        System.out.println("2 . Them moi danh muc");
        System.out.println("3 . Chinh sua danh muc");
        System.out.println("4 . Xoa danh muc");
        System.out.println("5 . Quay lai");
    }


}
