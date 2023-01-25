package com.example.bcs_preparation.utils;

public class ConstantUtils {


    public static class AuthPreference{
        public static String ACCESS_TOKEN = "";
        public final static String FILE_NAME = "auth_pref";
        public final static String TOKEN_NAME = "token_key";
        public final static String STATUS_KEY = "status";
        public final static String LOGIN_USER = "user_id";
    }

    public static class LiveExam{
        public static int LIVE_EXAM_Id = 0;
        public static int LOGIN_USER_Id = 0;
        public static int LIVE_EXAM_ROUTINE = 0;
        public static int TODAY_LIVE_EXAM_ROUTINE = 0;
        public static int PREVIOUS_EXAM_ARKAYVED = 0;
        public static int previousQuestionID = 0;
    }
}
