package com.facebook.react.bridge.queue;

import android.os.Looper;
import com.facebook.react.common.MapBuilder;
import java.util.Map;

public class ReactQueueConfigurationImpl implements ReactQueueConfiguration {
    private final MessageQueueThreadImpl mJSQueueThread;
    private final MessageQueueThreadImpl mNativeModulesQueueThread;
    private final MessageQueueThreadImpl mUIQueueThread;

    private ReactQueueConfigurationImpl(MessageQueueThreadImpl messageQueueThreadImpl, MessageQueueThreadImpl messageQueueThreadImpl2, MessageQueueThreadImpl messageQueueThreadImpl3) {
        this.mUIQueueThread = messageQueueThreadImpl;
        this.mNativeModulesQueueThread = messageQueueThreadImpl2;
        this.mJSQueueThread = messageQueueThreadImpl3;
    }

    public MessageQueueThread getUIQueueThread() {
        return this.mUIQueueThread;
    }

    public MessageQueueThread getNativeModulesQueueThread() {
        return this.mNativeModulesQueueThread;
    }

    public MessageQueueThread getJSQueueThread() {
        return this.mJSQueueThread;
    }

    public void destroy() {
        if (this.mNativeModulesQueueThread.getLooper() != Looper.getMainLooper()) {
            this.mNativeModulesQueueThread.quitSynchronous();
        }
        if (this.mJSQueueThread.getLooper() != Looper.getMainLooper()) {
            this.mJSQueueThread.quitSynchronous();
        }
    }

    public static ReactQueueConfigurationImpl create(ReactQueueConfigurationSpec reactQueueConfigurationSpec, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        Map newHashMap = MapBuilder.newHashMap();
        MessageQueueThreadSpec mainThreadSpec = MessageQueueThreadSpec.mainThreadSpec();
        MessageQueueThreadImpl create = MessageQueueThreadImpl.create(mainThreadSpec, queueThreadExceptionHandler);
        newHashMap.put(mainThreadSpec, create);
        MessageQueueThreadImpl messageQueueThreadImpl = (MessageQueueThreadImpl) newHashMap.get(reactQueueConfigurationSpec.getJSQueueThreadSpec());
        if (messageQueueThreadImpl == null) {
            messageQueueThreadImpl = MessageQueueThreadImpl.create(reactQueueConfigurationSpec.getJSQueueThreadSpec(), queueThreadExceptionHandler);
        }
        MessageQueueThreadImpl messageQueueThreadImpl2 = (MessageQueueThreadImpl) newHashMap.get(reactQueueConfigurationSpec.getNativeModulesQueueThreadSpec());
        if (messageQueueThreadImpl2 == null) {
            messageQueueThreadImpl2 = MessageQueueThreadImpl.create(reactQueueConfigurationSpec.getNativeModulesQueueThreadSpec(), queueThreadExceptionHandler);
        }
        return new ReactQueueConfigurationImpl(create, messageQueueThreadImpl2, messageQueueThreadImpl);
    }
}
