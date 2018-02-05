package edu.mum.wap.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Result {
    private String result;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String reason;

    public Result(Boolean result) {
        this(result, "");
    }

    public Result(Boolean result, String reason) {
        this.result = result ? "successful" : "fail";
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
