package kr.jy.book.exception;

public class LendBookException extends Exception
{
	public enum LendBookExceptionType
	{
		NO_BOOK,

		IS_RENTAL,

		IS_RENTAL_NO,

		NO_MEMBER,
	}

	private final LendBookExceptionType exceptionType;

	public LendBookException (LendBookExceptionType exceptionType)
	{
		this.exceptionType = exceptionType;
	}

	public LendBookExceptionType getExceptionType ()
	{
		return exceptionType;
	}
}
