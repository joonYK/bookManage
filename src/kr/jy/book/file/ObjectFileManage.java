package kr.jy.book.file;

import kr.jy.book.dataStructure.MyLinkedList;
import kr.jy.book.dto.Book;
import kr.jy.book.dto.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectFileManage {
    private File file;
    private BufferedInputStream bis;
    private BufferedOutputStream bos;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public ObjectFileManage(String filename) {
        file = new File(ObjectFileManage.class.getResource("").getPath() + "../resources/" + filename);
    }

    /**
     * 파일 내용 읽기
     * @return
     */
    public Object readFile() {
       Object data = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            in = new ObjectInputStream(bis);

            data = in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        }

        return data;
    }

    /**
     * 파일 쓰기
     * @param data
     * @return
     */
    public boolean writeFile(Object data) {
        try {
            bos = new BufferedOutputStream(new FileOutputStream(file));
            out = new ObjectOutputStream(bos);

            out.writeObject(data);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ObjectFileManage f1 = new ObjectFileManage("member.ser");
        MyLinkedList<Member> list = new MyLinkedList<>();
        list.add(new Member("김준엽", "서울시", "01023456789"));
        list.add(new Member("홍길동", "성남시", "01043256312"));
        list.add(new Member("이순신", "수원시", "01034135431"));
        f1.writeFile(list);

        ObjectFileManage f2 = new ObjectFileManage("book.ser");
        List<Book> list2 = new ArrayList<>();
        list2.add(new Book("Java의 정석", "남궁석", 30000));
        list2.add(new Book("이것이 자바다", "신용권", 30000));
        list2.add(new Book("자바스크립트 핵심가이드", "더글라스 크락포드", 22000));
        f2.writeFile(list2);
    }


}
