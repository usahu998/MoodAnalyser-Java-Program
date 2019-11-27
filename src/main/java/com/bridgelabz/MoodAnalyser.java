package com.bridgelabz;

public class MoodAnalyser {

    private String message;
    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message.length()==0)
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"Please enter proper mood");
            if (message.contains("Sad"))
                return "SAD";
            return "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL,"Please enter proper mood");
        }
    }

    public boolean isEquals(Object another){
        if (this==another)
            return true;
        return false;
    }

    public boolean equals(Object another){
        if (this.message.equals(((MoodAnalyser)another).message)) {
            return true;
        }
        return false;
    }
}
