package com.bridgelabz;

public class MoodAnalysisException extends Exception {

    enum ExceptionType {ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS}
    ExceptionType type;

    public MoodAnalysisException(String message) {
        super(message);
    }

    public MoodAnalysisException(ExceptionType type,String message) {
        super(message);
        this.type=type;
    }
}
