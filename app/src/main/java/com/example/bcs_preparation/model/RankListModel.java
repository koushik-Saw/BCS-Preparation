package com.example.bcs_preparation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RankListModel {

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
        @SerializedName("examId")
        @Expose
        private Integer examId;
        @SerializedName("users")
        @Expose
        private Users users;
        @SerializedName("answers")
        @Expose
        private List<Answer> answers = null;
        @SerializedName("totalAnsweredQuestionCount")
        @Expose
        private Integer totalAnsweredQuestionCount;
        @SerializedName("correctAnswerCount")
        @Expose
        private Integer correctAnswerCount;
        @SerializedName("wrongAnswerCount")
        @Expose
        private Integer wrongAnswerCount;
        @SerializedName("marks")
        @Expose
        private Double marks;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getExamId() {
            return examId;
        }

        public void setExamId(Integer examId) {
            this.examId = examId;
        }

        public Users getUsers() {
            return users;
        }

        public void setUsers(Users users) {
            this.users = users;
        }

        public List<Answer> getAnswers() {
            return answers;
        }

        public void setAnswers(List<Answer> answers) {
            this.answers = answers;
        }

        public Integer getTotalAnsweredQuestionCount() {
            return totalAnsweredQuestionCount;
        }

        public void setTotalAnsweredQuestionCount(Integer totalAnsweredQuestionCount) {
            this.totalAnsweredQuestionCount = totalAnsweredQuestionCount;
        }

        public Integer getCorrectAnswerCount() {
            return correctAnswerCount;
        }

        public void setCorrectAnswerCount(Integer correctAnswerCount) {
            this.correctAnswerCount = correctAnswerCount;
        }

        public Integer getWrongAnswerCount() {
            return wrongAnswerCount;
        }

        public void setWrongAnswerCount(Integer wrongAnswerCount) {
            this.wrongAnswerCount = wrongAnswerCount;
        }

        public Double getMarks() {
            return marks;
        }

        public void setMarks(Double marks) {
            this.marks = marks;
        }

    }

    public class Users {

        @SerializedName("isDeleted")
        @Expose
        private Integer isDeleted;
        @SerializedName("lastModificationTime")
        @Expose
        private Long lastModificationTime;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("password")
        @Expose
        private String password;

        public Integer getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(Integer isDeleted) {
            this.isDeleted = isDeleted;
        }

        public Long getLastModificationTime() {
            return lastModificationTime;
        }

        public void setLastModificationTime(Long lastModificationTime) {
            this.lastModificationTime = lastModificationTime;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


    }

    public class Answer {

        @SerializedName("questionId")
        @Expose
        private Integer questionId;
        @SerializedName("answer")
        @Expose
        private Integer answer;

        public Integer getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Integer questionId) {
            this.questionId = questionId;
        }

        public Integer getAnswer() {
            return answer;
        }

        public void setAnswer(Integer answer) {
            this.answer = answer;
        }

    }

}
