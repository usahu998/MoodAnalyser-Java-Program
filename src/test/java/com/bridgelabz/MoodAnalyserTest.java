package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

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
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, e.type);
        }
    }

    @Test
    public void givenNullMood_ShouldThrowException_withType() {
        MoodAnalyser realMoodAnalyser = new MoodAnalyser(null);
        try {
            realMoodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
        }
    }

    @Test
    public void givenMoodAnalyser_WhenImproper_shouldReturnDefaultObject() {
        MoodAnalyser moodAnalyser = (MoodAnalyser) MoodAnalyserReflector.createMoodAnalyser();
        boolean result = moodAnalyser.isEquals(new MoodAnalyser());
        Assert.assertEquals(false, result);
    }

    @Test
    public void givenMoodAnalyser_WhenImproper_shouldReturn_withNoSuchClass() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyserObject("");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("NO_SUCH_CLASS_ERROR", e.getMessage());
        }
    }

    @Test
    public void givenMoodAnalyserClass_IsEqual_ShouldReturnObject() {
        MoodAnalyser moodAnalyser = null;
        try {
            moodAnalyser = MoodAnalyserReflector.createMoodAnalyserObject("I am in Happy mood");
            boolean mood = moodAnalyser.equals(new MoodAnalyser("I am in Happy mood"));
            Assert.assertTrue(String.valueOf(true), mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenMood_ClassIsNotAvailable_ByParametrizedConstructor_ShouldReturn_CustomException_WithNoSuchClass() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyserObject("I am in Happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("NO_SUCH_CLASS_ERROR", e.getMessage());
        }
    }

    @Test
    public void whenMood_ConstructorIsNotValid_ByParametrizedConstructor_ShouldReturn_CustomException_WithNoSuchMethod() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyserObject("Hello");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("NO_SUCH_METHOD_ERROR", e.getMessage());
        }
    }

    @Test
    public void giveHappyMessage_WithReflection_ShouldReturnHappy() {
        try {
            Object myObject = MoodAnalyserReflector.createMoodAnalyserObject("I am in Happy mood");
            Object mood = MoodAnalyserReflector.invokeMethod(myObject, "analyseMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.getCause().getCause().printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyser_OnChangeMood_ShouldReturnHappy() {
        try {
            Object myObject = MoodAnalyserReflector.createMoodAnalyserObject("");
            MoodAnalyserReflector.setFieldValue(myObject, "message", "I am in Happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(myObject, "analyseMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void giveHappyMessage_WithDefaultConstructor_ShouldReturnHappy() {
        try {
            Constructor<?> constructor = MoodAnalyserReflector.getConstructor();
           Object myObject=MoodAnalyserReflector.createMoodAnalyser(constructor);
            MoodAnalyserReflector.setFieldValue(myObject, "message", "I am in Happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(myObject,"analyseMood");
            Assert.assertEquals("HAPPY",mood);
        }catch (MoodAnalysisException e){
            e.printStackTrace();
        }
    }
}
