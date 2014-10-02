package com.belagroup.sc.dto;

/**
 * Used to hold user response related data
 * as well as status of the request at data level.
 *
 * @author aodubela
 */
public class Response {

    /* Response status to indicate successfully process of request */
    public static final String OK = "OK";


    /* Response status to indicate failure to process request */
    public static final String FAILED = "FAILED";


    /* Status of request process */
    private String status;


    /* Error message of what actually went wrong during processing */
    private String error;


    /* Error code relating to error that occurred */
    private int errorCode;


    /* Holds reponse data related to successfully requests that are processed */
    private Object message;

    public Response() {
        status = OK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
