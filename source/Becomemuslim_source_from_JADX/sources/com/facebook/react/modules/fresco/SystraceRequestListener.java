package com.facebook.react.modules.fresco;

import android.util.Pair;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.Systrace.EventScope;
import java.util.HashMap;
import java.util.Map;

public class SystraceRequestListener extends BaseRequestListener {
    int mCurrentID = 0;
    Map<String, Pair<Integer, String>> mProducerID = new HashMap();
    Map<String, Pair<Integer, String>> mRequestsID = new HashMap();

    public boolean requiresExtraMap(String str) {
        return false;
    }

    public void onProducerStart(String str, String str2) {
        if (Systrace.isTracing(0)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FRESCO_PRODUCER_");
            stringBuilder.append(str2.replace(':', '_'));
            str2 = Pair.create(Integer.valueOf(this.mCurrentID), stringBuilder.toString());
            Systrace.beginAsyncSection(0, (String) str2.second, this.mCurrentID);
            this.mProducerID.put(str, str2);
            this.mCurrentID++;
        }
    }

    public void onProducerFinishWithSuccess(String str, String str2, Map<String, String> map) {
        if (Systrace.isTracing(0) && this.mProducerID.containsKey(str)) {
            Pair pair = (Pair) this.mProducerID.get(str);
            Systrace.endAsyncSection(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.mProducerID.remove(str);
        }
    }

    public void onProducerFinishWithFailure(String str, String str2, Throwable th, Map<String, String> map) {
        if (!(Systrace.isTracing(0) == null || this.mProducerID.containsKey(str) == null)) {
            Pair pair = (Pair) this.mProducerID.get(str);
            Systrace.endAsyncSection(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.mProducerID.remove(str);
        }
    }

    public void onProducerFinishWithCancellation(String str, String str2, Map<String, String> map) {
        if (Systrace.isTracing(0) && this.mProducerID.containsKey(str)) {
            Pair pair = (Pair) this.mProducerID.get(str);
            Systrace.endAsyncSection(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.mProducerID.remove(str);
        }
    }

    public void onProducerEvent(String str, String str2, String str3) {
        if (Systrace.isTracing(0)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FRESCO_PRODUCER_EVENT_");
            stringBuilder.append(str.replace(':', '_'));
            stringBuilder.append("_");
            stringBuilder.append(str2.replace(':', '_'));
            stringBuilder.append("_");
            stringBuilder.append(str3.replace(':', '_'));
            Systrace.traceInstant(0, stringBuilder.toString(), EventScope.THREAD);
        }
    }

    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
        if (Systrace.isTracing(0) != null) {
            obj = new StringBuilder();
            obj.append("FRESCO_REQUEST_");
            obj.append(imageRequest.getSourceUri().toString().replace(true, '_'));
            imageRequest = Pair.create(Integer.valueOf(this.mCurrentID), obj.toString());
            Systrace.beginAsyncSection(0, (String) imageRequest.second, this.mCurrentID);
            this.mRequestsID.put(str, imageRequest);
            this.mCurrentID++;
        }
    }

    public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
        if (!(Systrace.isTracing(0) == null || this.mRequestsID.containsKey(str) == null)) {
            Pair pair = (Pair) this.mRequestsID.get(str);
            Systrace.endAsyncSection(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.mRequestsID.remove(str);
        }
    }

    public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        if (!(Systrace.isTracing(0) == null || this.mRequestsID.containsKey(str) == null)) {
            Pair pair = (Pair) this.mRequestsID.get(str);
            Systrace.endAsyncSection(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.mRequestsID.remove(str);
        }
    }

    public void onRequestCancellation(String str) {
        if (Systrace.isTracing(0) && this.mRequestsID.containsKey(str)) {
            Pair pair = (Pair) this.mRequestsID.get(str);
            Systrace.endAsyncSection(0, (String) pair.second, ((Integer) pair.first).intValue());
            this.mRequestsID.remove(str);
        }
    }
}
