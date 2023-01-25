package com.example.bcs_preparation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TodayExamByTypeLiveExamRoutineModel {

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
        @SerializedName("liveExamTypeId")
        @Expose
        private Integer liveExamTypeId;
        @SerializedName("examDate")
        @Expose
        private String examDate;
        @SerializedName("topic")
        @Expose
        private String topic;
        @SerializedName("syllabus")
        @Expose
        private String syllabus;
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
        @SerializedName("questionGroups")
        @Expose
        private List<QuestionGroup> questionGroups = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getLiveExamTypeId() {
            return liveExamTypeId;
        }

        public void setLiveExamTypeId(Integer liveExamTypeId) {
            this.liveExamTypeId = liveExamTypeId;
        }

        public String getExamDate() {
            return examDate;
        }

        public void setExamDate(String examDate) {
            this.examDate = examDate;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getSyllabus() {
            return syllabus;
        }

        public void setSyllabus(String syllabus) {
            this.syllabus = syllabus;
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

        public List<QuestionGroup> getQuestionGroups() {
            return questionGroups;
        }

        public void setQuestionGroups(List<QuestionGroup> questionGroups) {
            this.questionGroups = questionGroups;
        }

    }

    public class QuestionGroup {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("questionIds")
        @Expose
        private List<Integer> questionIds = null;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Integer> getQuestionIds() {
            return questionIds;
        }

        public void setQuestionIds(List<Integer> questionIds) {
            this.questionIds = questionIds;
        }

    }
}
