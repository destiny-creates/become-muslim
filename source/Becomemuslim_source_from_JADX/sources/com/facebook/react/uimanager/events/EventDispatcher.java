package com.facebook.react.uimanager.events;

import android.util.LongSparseArray;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.systrace.Systrace;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EventDispatcher implements LifecycleEventListener {
    private static final Comparator<Event> EVENT_COMPARATOR = new C19731();
    private final ScheduleDispatchFrameCallback mCurrentFrameCallback = new ScheduleDispatchFrameCallback();
    private final DispatchEventsRunnable mDispatchEventsRunnable = new DispatchEventsRunnable();
    private final LongSparseArray<Integer> mEventCookieToLastEventIdx = new LongSparseArray();
    private final Map<String, Short> mEventNameToEventId = MapBuilder.newHashMap();
    private final ArrayList<Event> mEventStaging = new ArrayList();
    private final Object mEventsStagingLock = new Object();
    private Event[] mEventsToDispatch = new Event[16];
    private final Object mEventsToDispatchLock = new Object();
    private int mEventsToDispatchSize = 0;
    private volatile boolean mHasDispatchScheduled = false;
    private final AtomicInteger mHasDispatchScheduledCount = new AtomicInteger();
    private final ArrayList<EventDispatcherListener> mListeners = new ArrayList();
    private short mNextEventTypeId = (short) 0;
    private final ReactApplicationContext mReactContext;
    private volatile ReactEventEmitter mReactEventEmitter;

    /* renamed from: com.facebook.react.uimanager.events.EventDispatcher$1 */
    static class C19731 implements Comparator<Event> {
        C19731() {
        }

        public int compare(Event event, Event event2) {
            if (event == null && event2 == null) {
                return 0;
            }
            if (event == null) {
                return -1;
            }
            if (event2 == null) {
                return 1;
            }
            event = ((event.getTimestampMs() - event2.getTimestampMs()) > null ? 1 : ((event.getTimestampMs() - event2.getTimestampMs()) == null ? 0 : -1));
            if (event == null) {
                return 0;
            }
            return event < null ? -1 : 1;
        }
    }

    /* renamed from: com.facebook.react.uimanager.events.EventDispatcher$2 */
    class C19742 implements Runnable {
        C19742() {
        }

        public void run() {
            EventDispatcher.this.stopFrameCallback();
        }
    }

    private class DispatchEventsRunnable implements Runnable {
        private DispatchEventsRunnable() {
        }

        public void run() {
            Systrace.beginSection(0, "DispatchEventsRunnable");
            try {
                Systrace.endAsyncFlow(0, "ScheduleDispatchFrameCallback", EventDispatcher.this.mHasDispatchScheduledCount.getAndIncrement());
                int i = 0;
                EventDispatcher.this.mHasDispatchScheduled = false;
                Assertions.assertNotNull(EventDispatcher.this.mReactEventEmitter);
                synchronized (EventDispatcher.this.mEventsToDispatchLock) {
                    if (EventDispatcher.this.mEventsToDispatchSize > 1) {
                        Arrays.sort(EventDispatcher.this.mEventsToDispatch, 0, EventDispatcher.this.mEventsToDispatchSize, EventDispatcher.EVENT_COMPARATOR);
                    }
                    while (i < EventDispatcher.this.mEventsToDispatchSize) {
                        Event event = EventDispatcher.this.mEventsToDispatch[i];
                        if (event != null) {
                            Systrace.endAsyncFlow(0, event.getEventName(), event.getUniqueID());
                            event.dispatch(EventDispatcher.this.mReactEventEmitter);
                            event.dispose();
                        }
                        i++;
                    }
                    EventDispatcher.this.clearEventsToDispatch();
                    EventDispatcher.this.mEventCookieToLastEventIdx.clear();
                }
                Systrace.endSection(0);
            } catch (Throwable th) {
                Systrace.endSection(0);
            }
        }
    }

    private class ScheduleDispatchFrameCallback extends FrameCallback {
        private volatile boolean mIsPosted;
        private boolean mShouldStop;

        /* renamed from: com.facebook.react.uimanager.events.EventDispatcher$ScheduleDispatchFrameCallback$1 */
        class C19751 implements Runnable {
            C19751() {
            }

            public void run() {
                ScheduleDispatchFrameCallback.this.maybePost();
            }
        }

        private ScheduleDispatchFrameCallback() {
            this.mIsPosted = false;
            this.mShouldStop = false;
        }

        public void doFrame(long j) {
            UiThreadUtil.assertOnUiThread();
            if (this.mShouldStop != null) {
                this.mIsPosted = 0;
            } else {
                post();
            }
            Systrace.beginSection(0, "ScheduleDispatchFrameCallback");
            try {
                EventDispatcher.this.moveStagedEventsToDispatchQueue();
                if (EventDispatcher.this.mEventsToDispatchSize > null && EventDispatcher.this.mHasDispatchScheduled == null) {
                    EventDispatcher.this.mHasDispatchScheduled = true;
                    Systrace.startAsyncFlow(0, "ScheduleDispatchFrameCallback", EventDispatcher.this.mHasDispatchScheduledCount.get());
                    EventDispatcher.this.mReactContext.runOnJSQueueThread(EventDispatcher.this.mDispatchEventsRunnable);
                }
                Systrace.endSection(0);
            } catch (Throwable th) {
                Systrace.endSection(0);
            }
        }

        public void stop() {
            this.mShouldStop = true;
        }

        public void maybePost() {
            if (!this.mIsPosted) {
                this.mIsPosted = true;
                post();
            }
        }

        private void post() {
            ReactChoreographer.getInstance().postFrameCallback(CallbackType.TIMERS_EVENTS, EventDispatcher.this.mCurrentFrameCallback);
        }

        public void maybePostFromNonUI() {
            if (!this.mIsPosted) {
                if (EventDispatcher.this.mReactContext.isOnUiQueueThread()) {
                    maybePost();
                } else {
                    EventDispatcher.this.mReactContext.runOnUiQueueThread(new C19751());
                }
            }
        }
    }

    private static long getEventCookie(int i, short s, short s2) {
        return (((((long) s) & 65535) << 32) | ((long) i)) | ((((long) s2) & 65535) << 48);
    }

    public EventDispatcher(ReactApplicationContext reactApplicationContext) {
        this.mReactContext = reactApplicationContext;
        this.mReactContext.addLifecycleEventListener(this);
        this.mReactEventEmitter = new ReactEventEmitter(this.mReactContext);
    }

    public void dispatchEvent(Event event) {
        Assertions.assertCondition(event.isInitialized(), "Dispatched event hasn't been initialized");
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((EventDispatcherListener) it.next()).onEventDispatch(event);
        }
        synchronized (this.mEventsStagingLock) {
            this.mEventStaging.add(event);
            Systrace.startAsyncFlow(0, event.getEventName(), event.getUniqueID());
        }
        if (this.mReactEventEmitter != null) {
            this.mCurrentFrameCallback.maybePostFromNonUI();
        }
    }

    public void addListener(EventDispatcherListener eventDispatcherListener) {
        this.mListeners.add(eventDispatcherListener);
    }

    public void removeListener(EventDispatcherListener eventDispatcherListener) {
        this.mListeners.remove(eventDispatcherListener);
    }

    public void onHostResume() {
        this.mCurrentFrameCallback.maybePostFromNonUI();
    }

    public void onHostPause() {
        stopFrameCallback();
    }

    public void onHostDestroy() {
        stopFrameCallback();
    }

    public void onCatalystInstanceDestroyed() {
        UiThreadUtil.runOnUiThread(new C19742());
    }

    private void stopFrameCallback() {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentFrameCallback.stop();
    }

    private void moveStagedEventsToDispatchQueue() {
        synchronized (this.mEventsStagingLock) {
            synchronized (this.mEventsToDispatchLock) {
                for (int i = 0; i < this.mEventStaging.size(); i++) {
                    Event event = (Event) this.mEventStaging.get(i);
                    if (event.canCoalesce()) {
                        long eventCookie = getEventCookie(event.getViewTag(), event.getEventName(), event.getCoalescingKey());
                        Integer num = (Integer) this.mEventCookieToLastEventIdx.get(eventCookie);
                        Event event2 = null;
                        if (num == null) {
                            this.mEventCookieToLastEventIdx.put(eventCookie, Integer.valueOf(this.mEventsToDispatchSize));
                        } else {
                            Event event3 = this.mEventsToDispatch[num.intValue()];
                            Event coalesce = event.coalesce(event3);
                            if (coalesce != event3) {
                                this.mEventCookieToLastEventIdx.put(eventCookie, Integer.valueOf(this.mEventsToDispatchSize));
                                this.mEventsToDispatch[num.intValue()] = null;
                                event2 = event3;
                                event = coalesce;
                            } else {
                                event2 = event;
                                event = null;
                            }
                        }
                        if (event != null) {
                            addEventToEventsToDispatch(event);
                        }
                        if (event2 != null) {
                            event2.dispose();
                        }
                    } else {
                        addEventToEventsToDispatch(event);
                    }
                }
            }
            this.mEventStaging.clear();
        }
    }

    private long getEventCookie(int i, String str, short s) {
        short shortValue;
        Short sh = (Short) this.mEventNameToEventId.get(str);
        if (sh != null) {
            shortValue = sh.shortValue();
        } else {
            short s2 = this.mNextEventTypeId;
            this.mNextEventTypeId = (short) (s2 + 1);
            this.mEventNameToEventId.put(str, Short.valueOf(s2));
            shortValue = s2;
        }
        return getEventCookie(i, shortValue, s);
    }

    public void registerEventEmitter(int i, RCTEventEmitter rCTEventEmitter) {
        this.mReactEventEmitter.register(i, rCTEventEmitter);
    }

    public void unregisterEventEmitter(int i) {
        this.mReactEventEmitter.unregister(i);
    }

    private void addEventToEventsToDispatch(Event event) {
        if (this.mEventsToDispatchSize == this.mEventsToDispatch.length) {
            this.mEventsToDispatch = (Event[]) Arrays.copyOf(this.mEventsToDispatch, this.mEventsToDispatch.length * 2);
        }
        Event[] eventArr = this.mEventsToDispatch;
        int i = this.mEventsToDispatchSize;
        this.mEventsToDispatchSize = i + 1;
        eventArr[i] = event;
    }

    private void clearEventsToDispatch() {
        Arrays.fill(this.mEventsToDispatch, 0, this.mEventsToDispatchSize, null);
        this.mEventsToDispatchSize = 0;
    }
}
