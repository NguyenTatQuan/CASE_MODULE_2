package storage.member;

import model.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileMember implements IReadWriteFileMember {
    public static final String PATHNAMEMEMBER = "member.txt";

    @Override
    public List<Member> readFile() {
        File fileMember = new File(PATHNAMEMEMBER);
        if (!fileMember.exists()) {
            return getDefaultMembers();
        }

        try (ObjectInputStream oisMember = new ObjectInputStream(new FileInputStream(fileMember))) {
            return (List<Member>) oisMember.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
            return getDefaultMembers();
        }
    }

    @Override
    public void writeFile(List<Member> members) {
        try (ObjectOutputStream oosMember = new ObjectOutputStream(new FileOutputStream(PATHNAMEMEMBER))) {
            oosMember.writeObject(members);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }
    private List<Member> getDefaultMembers() {
        return new ArrayList<>();
    }
}
