package com.example.bcs_preparation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FavouriteQuestionPlaylistModel {

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
        @SerializedName("userId")
        @Expose
        private Integer userId;
        @SerializedName("questionIds")
        @Expose
        private List<Object> questionIds = null;
        @SerializedName("name")
        @Expose
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public List<Object> getQuestionIds() {
            return questionIds;
        }

        public void setQuestionIds(List<Object> questionIds) {
            this.questionIds = questionIds;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
