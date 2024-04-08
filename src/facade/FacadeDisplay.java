package facade;

import controller.BookManager;
import controller.MemberManager;
import controller.StaffManager;

public class FacadeDisplay {
    public void display() {
        System.out.println("\n\n--------  SÁCH  ------ \n");
        BookManager.displayBooks();
        System.out.println("\n\n\n--------  THÀNH VIÊN  -------- \n");
        MemberManager.displayMembers();
        System.out.println("\n\n\n--------  NHÂN VIÊN  -------- \n");
        StaffManager.displayStaffs();
    }

}
