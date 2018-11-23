package kr.jy.book.exception;

public class LendBookException extends Exception
{
	public enum LendBookExceptionType
	{
		NO_BOOK,

		IS_RENTAL,

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
