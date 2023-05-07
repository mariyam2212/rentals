package service;

import commons.RequestStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestContext {
    private RequestStrategy requestStrategy;

    HttpServletRequest request;
    HttpServletResponse response;

    public RequestContext(RequestStrategy requestStrategy, HttpServletRequest request, HttpServletResponse response) {
        this.requestStrategy = requestStrategy;
        this.request = request;
        this.response = response;
    }

    public void execute() {
        requestStrategy.execute(request, response);
    }
}
