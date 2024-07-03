package com.polytechnic.astra.ac.id.knowledgemanagementsystem;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RetryInterceptor implements Interceptor {
    private int maxRetry;
    private int retryNum = 0;

    public RetryInterceptor(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = null;
        boolean responseOK = false;
        while (!responseOK && retryNum < maxRetry) {
            try {
                response = chain.proceed(request);
                responseOK = response.isSuccessful();
            } catch (Exception e) {
                retryNum++;
            }
        }
        if (response == null) {
            throw new IOException("Max retries exceeded");
        }
        return response;
    }
}
