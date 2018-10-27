package by.it.korolchuk.jd03_01;

public class Runner {
    public static void main(String[] args) {
        C_Reset.reset();
        C_Init.init();
        A_AddData.addData();
        A_AddUser.addUser();
        B_AddRoles.addRoles();
        B_ShowUsers.showUsers();
    }
}
