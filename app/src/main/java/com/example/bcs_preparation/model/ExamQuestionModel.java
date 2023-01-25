package com.example.bcs_preparation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ExamQuestionModel {

    @SerializedName("header")
    @Expose
    private Header header;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("body")
    @Expose
    private Body body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public class Header {

        @SerializedName("requestReceivedTime")
        @Expose
        private Object requestReceivedTime;
        @SerializedName("responseTime")
        @Expose
        private Object responseTime;
        @SerializedName("hopCount")
        @Expose
        private Integer hopCount;
        @SerializedName("responseProcessingTimeInMs")
        @Expose
        private Integer responseProcessingTimeInMs;
        @SerializedName("requestId")
        @Expose
        private Object requestId;
        @SerializedName("responseCode")
        @Expose
        private Object responseCode;
        @SerializedName("responseMessage")
        @Expose
        private Object responseMessage;
        @SerializedName("responseVersion")
        @Expose
        private Object responseVersion;
        @SerializedName("requestSourceService")
        @Expose
        private Object requestSourceService;
        @SerializedName("traceId")
        @Expose
        private Object traceId;

        public Object getRequestReceivedTime() {
            return requestReceivedTime;
        }

        public void setRequestReceivedTime(Object requestReceivedTime) {
            this.requestReceivedTime = requestReceivedTime;
        }

        public Object getResponseTime() {
            return responseTime;
        }

        public void setResponseTime(Object responseTime) {
            this.responseTime = responseTime;
        }

        public Integer getHopCount() {
            return hopCount;
        }

        public void setHopCount(Integer hopCount) {
            this.hopCount = hopCount;
        }

        public Integer getResponseProcessingTimeInMs() {
            return responseProcessingTimeInMs;
        }

        public void setResponseProcessingTimeInMs(Integer responseProcessingTimeInMs) {
            this.responseProcessingTimeInMs = responseProcessingTimeInMs;
        }

        public Object getRequestId() {
            return requestId;
        }

        public void setRequestId(Object requestId) {
            this.requestId = requestId;
        }

        public Object getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(Object responseCode) {
            this.responseCode = responseCode;
        }

        public Object getResponseMessage() {
            return responseMessage;
        }

        public void setResponseMessage(Object responseMessage) {
            this.responseMessage = responseMessage;
        }

        public Object getResponseVersion() {
            return responseVersion;
        }

        public void setResponseVersion(Object responseVersion) {
            this.responseVersion = responseVersion;
        }

        public Object getRequestSourceService() {
            return requestSourceService;
        }

        public void setRequestSourceService(Object requestSourceService) {
            this.requestSourceService = requestSourceService;
        }

        public Object getTraceId() {
            return traceId;
        }

        public void setTraceId(Object traceId) {
            this.traceId = traceId;
        }

    }

    public class Meta {}

    public class Body {

        @SerializedName("data")
        @Expose
        private List<Datum> data = null;

        public List<Datum> getData() {
            return data;
        }

        public void setData(List<Datum> data) {
            this.data = data;
        }

    }

    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("totalTime")
        @Expose
        private Integer totalTime;
        @SerializedName("numberOfQuestion")
        @Expose
        private Integer numberOfQuestion;
        @SerializedName("perQuestionMark")
        @Expose
        private Double perQuestionMark;
        @SerializedName("negativeMark")
        @Expose
        private Double negativeMark;
        @SerializedName("questions")
        @Expose
        private List<Question> questions = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getTotalTime() {
            return totalTime;
        }

        public void setTotalTime(Integer totalTime) {
            this.totalTime = totalTime;
        }

        public Integer getNumberOfQuestion() {
            return numberOfQuestion;
        }

        public void setNumberOfQuestion(Integer numberOfQuestion) {
            this.numberOfQuestion = numberOfQuestion;
        }

        public Double getPerQuestionMark() {
            return perQuestionMark;
        }

        public void setPerQuestionMark(Double perQuestionMark) {
            this.perQuestionMark = perQuestionMark;
        }

        public Double getNegativeMark() {
            return negativeMark;
        }

        public void setNegativeMark(Double negativeMark) {
            this.negativeMark = negativeMark;
        }

        public List<Question> getQuestions() {
            return questions;
        }

        public void setQuestions(List<Question> questions) {
            this.questions = questions;
        }

    }

    public class Question {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("questions")
        @Expose
        private List<Question__1> questions = null;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Question__1> getQuestions() {
            return questions;
        }

        public void setQuestions(List<Question__1> questions) {
            this.questions = questions;
        }

    }

    public class Question__1 {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("subject")
        @Expose
        private String subject;
        @SerializedName("option1")
        @Expose
        private String option1;
        @SerializedName("option2")
        @Expose
        private String option2;
        @SerializedName("option3")
        @Expose
        private String option3;
        @SerializedName("option4")
        @Expose
        private String option4;
        @SerializedName("correctAnswer")
        @Expose
        private Integer correctAnswer;
        @SerializedName("questionType")
        @Expose
        private Integer questionType;
        @SerializedName("explanation")
        @Expose
        private String explanation;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getOption1() {
            return option1;
        }

        public void setOption1(String option1) {
            this.option1 = option1;
        }

        public String getOption2() {
            return option2;
        }

        public void setOption2(String option2) {
            this.option2 = option2;
        }

        public String getOption3() {
            return option3;
        }

        public void setOption3(String option3) {
            this.option3 = option3;
        }

        public String getOption4() {
            return option4;
        }

        public void setOption4(String option4) {
            this.option4 = option4;
        }

        public Integer getCorrectAnswer() {
            return correctAnswer;
        }

        public void setCorrectAnswer(Integer correctAnswer) {
            this.correctAnswer = correctAnswer;
        }

        public Integer getQuestionType() {
            return questionType;
        }

        public void setQuestionType(Integer questionType) {
            this.questionType = questionType;
        }

        public String getExplanation() {
            return explanation;
        }

        public void setExplanation(String explanation) {
            this.explanation = explanation;
        }

    }



}
