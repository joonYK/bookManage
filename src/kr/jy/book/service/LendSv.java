package kr.jy.book.service;

import kr.jy.book.dto.Book;
import kr.jy.book.dto.Member;
import kr.jy.book.exception.LendBookException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LendSv {

    private static LendSv instance;
    public static LendSv getInstance() {
        if(instance == null) instance = new LendSv();
        return instance;
    }
    private LendSv() {}

    //대여 반납 로그
    private List<String> logList = new ArrayList<String>();

    //책 대여
    public void lendBook(Member member, Book book) throws LendBookException
    {
        checkLendBookCore (member, book, true);

        member.addBook(book);
        book.setRental(true);

        addLog("대여", member, book);
    }

    //책 반납
    public void getBackBook(Member member, Book book) throws LendBookException {
        checkLendBookCore(member, book, false);

        member.removeBook(book);
        book.setRental(false);

        addLog("반납", member, book);
    }

    /**
     * 책을 대여및 반납할 수 있는지 체크를 한다.
     * @param member
     * @param book
     * @param isLendType
     * @return
     * @throws LendBookException
     */
    private void checkLendBookCore (Member member, Book book, boolean isLendType) throws LendBookException
    {
        if(member == null)
            throw new LendBookException (LendBookException.LendBookExceptionType.NO_MEMBER);

        if(book == null)
            throw new LendBookException (LendBookException.LendBookExceptionType.NO_BOOK);

        if (isLendType && book.isRental ())
            throw new LendBookException (LendBookException.LendBookExceptionType.IS_RENTAL);
        else if(!isLendType && !book.isRental())
            throw new LendBookException (LendBookException.LendBookExceptionType.IS_RENTAL_NO);
    }

    /**
     * 대여/반납 로그
     * @param action 대여 또는 반납
     */
    private void addLog(String action, Member member, Book book) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String log = sdf.format(calendar.getTime()) + "  " + action  + ", " + member.getName() + "(" + member.getMemberId() + "), " + book.getName() + "(" + book.getBookId() + ")";
        logList.add(log);
    }

    /**
     * 로그 리스트
     * @return
     */
    public List<String> getLogList() {
        return logList;
    }

}
