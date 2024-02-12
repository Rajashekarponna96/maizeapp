package com.maizeapp.maize.commonexceptions;

public enum CommonExceptionMessage {

	REQUIRED_ATTRIBUTE(1, " %1$s is mandatory"), VALIDATE_PIN(2, "Please enter only 4 digit PIN"),
	INCORRECT_PIN(3, "User PIN is incorrect."), ALREADY_EXISTS(4, "%1$S is already exists."),
	VALIDATE_FROMDATE(5, "From Date mandatory"), VALIDATE_TODATE(5, "To Date mandatory"),
	PERMISSION_NOTEXISTS(5, "You dont have permission to access this screen."), NOTFOUND(6, "%1$ not found."),
	VALIDATE_SIX_PIN(7, "Please enter only 6 digit PIN"),
	INCORRECT_UserNameAndPassword(8, "UserName and Password is incorrect."),
	NOT_ASSIGN(9, "User Not Assign With Any Store.");

	private int code;

	private String message;

	private CommonExceptionMessage(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
