
import dao.userDao;
import entities.UserInfo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pradeep
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        userDao user = context.getBean("userDao", userDao.class);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while (go) {
            System.out.println("PRESS 1 for add new user");
            System.out.println("PRESS 2 for display  all user");
            System.out.println("PRESS 3 for get detail of single user");
            System.out.println("PRESS 4 for delete user");
            System.out.println("PRESS 5 for update user");
            System.out.println("PRESS 6 for exit");

            try {

                int input = Integer.parseInt(br.readLine());

                switch (input) {

                    case 1:
                        System.out.println("Enter user name :");
                        String uName = br.readLine();
                        System.out.println("Enter email");
                        String uEmail = br.readLine();
                        System.out.println("Enter password");
                        String uPAssword = br.readLine();
                        System.out.println("Enter your mobile number please :");
                        int uNumber = Integer.parseInt(br.readLine());

                        UserInfo userD = new UserInfo();
                        userD.setUserName(uName);
                        userD.setUserEmail(uEmail);
                        userD.setUserPassword(uPAssword);
                        userD.setmNumber(uNumber);

                        int a = user.insertUser(userD);
                        System.out.println(a);
                        break;

                    case 2:
                        List<UserInfo> allUsers = user.getAllUsers();
                        for (UserInfo ud : allUsers) {

                            System.out.println(ud.getUserName());
                            System.out.println(ud.getUserEmail());
                            System.out.println(ud.getmNumber());
                        }
                        break;

                    case 3:
                        System.out.println("Enter the id to get the details");
                        Integer id = Integer.parseInt(br.readLine());
                        //getting user info  
                        UserInfo u = user.getUser(id);
                        System.out.println("Name :" + u.getUserName());
                        System.out.println("Email :" + u.getUserEmail());
                        System.out.println("Number :" + u.getmNumber());
                        break;

                    case 4:
                        System.out.println("Enter the user id you wanna delete");
                        Integer uid = Integer.parseInt(br.readLine());
                        user.deleteUser(uid);
                        System.out.println("User succefully deleted");
                        break;

                    case 5:
                        System.out.println("Enter the id of the user  you wanna update the details");
                        Integer idUpdate = Integer.parseInt(br.readLine());
                        System.out.println("Enter user name :");
                        String userName = br.readLine();
                        System.out.println("Enter email");
                        String userEmail = br.readLine();
                        System.out.println("Enter password");
                        String userPAssword = br.readLine();
                        System.out.println("Enter your mobile number please :");
                        int userNumber = Integer.parseInt(br.readLine());

                        
                        UserInfo userUpdate = user.getUser(idUpdate);
                        userUpdate.setUserName(userName);
                        userUpdate.setUserEmail(userEmail);
                        userUpdate.setUserPassword(userPAssword);
                        userUpdate.setmNumber(userNumber);

                        user.userUpdate(userUpdate);
                        System.out.println("User Updated Successfully");
                        break;

                    case 6:
                        System.out.println("Thanks for giving an opportunity to help you");
                        go = false;
                        break;

                }

            } catch (Exception e) {
                System.out.println("Invalid Input Try with another one !!");
                System.out.println(e.getMessage());
            }

        }

    }
}
