package com.example.bcs_preparation.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UserRegistration {

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
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("subscription")
        @Expose
        private Object subscription;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getSubscription() {
            return subscription;
        }

        public void setSubscription(Object subscription) {
            this.subscription = subscription;
        }

    }
    public class Header {

        @SerializedName("requestReceivedTime")
        @Expose
        private Object requestReceivedTime;
        @SerializedName("responseTime")
        @Expose
        private String responseTime;
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
        private String responseCode;
        @SerializedName("responseMessage")
        @Expose
        private String responseMessage;
        @SerializedName("responseVersion")
        @Expose
        private Object responseVersion;
        @SerializedName("requestSourceService")
        @Expose
        private Object requestSourceService;
        @SerializedName("traceId")
        @Expose
        private String traceId;

        public Object getRequestReceivedTime() {
            return requestReceivedTime;
        }

        public void setRequestReceivedTime(Object requestReceivedTime) {
            this.requestReceivedTime = requestReceivedTime;
        }

        public String getResponseTime() {
            return responseTime;
        }

        public void setResponseTime(String responseTime) {
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

        public String getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(String responseCode) {
            this.responseCode = responseCode;
        }

        public String getResponseMessage() {
            return responseMessage;
        }

        public void setResponseMessage(String responseMessage) {
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

        public String getTraceId() {
            return traceId;
        }

        public void setTraceId(String traceId) {
            this.traceId = traceId;
        }

    }
    public class Meta {

    }
}
