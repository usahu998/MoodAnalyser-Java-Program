package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenMessage_WhenHappy_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy Mood");
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenNullMood_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenEmptyMood_ShouldThrowException_withType() {
        MoodAnalyser realMoodAnalyser = new MoodAnalyser("");
        try {
            realMoodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenNullMood_ShouldThrowException_withType() {
        MoodAnalyser realMoodAnalyser = new MoodAnalyser(null);
        try {
            realMoodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL,e.type);
        }
    }

    @Test
    public void givenMoodAnalyser_WhenImproper_shouldReturnDefaultObject() {
          MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyser();
          boolean result = moodAnalyser.equals(new MoodAnalyser());
          Assert.assertEquals(false, result);
    }

    @Test
    public void givenMoodAnalyser_WhenImproper_shouldReturn_withNoSuchClass() {
       try {
           MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyserObject_NoClassFound_OR_NoMethodFound();
       }catch (MoodAnalysisException e){
           Assert.assertEquals("NO_SUCH_CLASS_ERROR",e.getMessage());
       }
    }

    @Test
    public void givenMoodAnalyser_WhenImproper_shouldReturn_withNoSuchMethod() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyserObject_NoClassFound_OR_NoMethodFound();
        }catch (MoodAnalysisException e){
            Assert.assertEquals("NO_SUCH_METHOD_ERROR",e.getMessage());
        }
    }
}
