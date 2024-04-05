package controller;

import model.Member;
import storage.IReadWriteFile;
import storage.member.ReadWriteFileMember;


import java.util.List;

public class MemberManager {
    private static final IReadWriteFile<Member> readWriteFile = new ReadWriteFileMember();
    private static final List<Member> members = readWriteFile.readFile();

    public static void addNewMember(Member member) {
        members.add(member);
        readWriteFile.writeFile(members);
        System.out.println("Thành viên đã được thêm thành công.");
    }

    public static void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("Không có Thành viên nào.");
            return;
        }
        for (Member member : members) {
            System.out.println(member);
        }
    }

    public static void findMember(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                System.out.println("Thành viên được tìm thấy: " + memberId);
                return;
            }
        }
        System.out.println("Không tìm thấy Thành viên với mã: " + memberId);
    }

    public static void removeMember(String memberId) {
        Member memberToRemove = null;
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                memberToRemove = member;
                break;
            }
        }
        if (memberToRemove != null) {
            members.remove(memberToRemove);
            readWriteFile.writeFile(members);
            System.out.println("Thành viên đã được xóa.");
        } else {
            System.out.println("Không tìm thấy Thành viên với mã: " + memberId);
        }
    }

    public static void editMember(String memberId, Member updatedMember) {
        int memberIndex = -1;
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberId().equals(memberId)) {
                memberIndex = i;
                break;
            }
        }
        if (memberIndex != -1) {

            members.set(memberIndex, updatedMember);
            readWriteFile.writeFile(members);
            System.out.println("Thành viên đã được cập nhật thành công.");
        } else {
            System.out.println("Không tìm thấy Thành viên với mã: " + memberId);
        }
    }
}
