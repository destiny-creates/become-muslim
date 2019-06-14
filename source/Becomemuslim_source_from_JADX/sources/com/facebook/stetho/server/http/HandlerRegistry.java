package com.facebook.stetho.server.http;

import java.util.ArrayList;

public class HandlerRegistry {
    private final ArrayList<HttpHandler> mHttpHandlers = new ArrayList();
    private final ArrayList<PathMatcher> mPathMatchers = new ArrayList();

    public synchronized void register(PathMatcher pathMatcher, HttpHandler httpHandler) {
        this.mPathMatchers.add(pathMatcher);
        this.mHttpHandlers.add(httpHandler);
    }

    public synchronized boolean unregister(PathMatcher pathMatcher, HttpHandler httpHandler) {
        pathMatcher = this.mPathMatchers.indexOf(pathMatcher);
        if (pathMatcher < null || httpHandler != this.mHttpHandlers.get(pathMatcher)) {
            return null;
        }
        this.mPathMatchers.remove(pathMatcher);
        this.mHttpHandlers.remove(pathMatcher);
        return true;
    }

    public synchronized HttpHandler lookup(String str) {
        int size = this.mPathMatchers.size();
        for (int i = 0; i < size; i++) {
            if (((PathMatcher) this.mPathMatchers.get(i)).match(str)) {
                return (HttpHandler) this.mHttpHandlers.get(i);
            }
        }
        return null;
    }
}
