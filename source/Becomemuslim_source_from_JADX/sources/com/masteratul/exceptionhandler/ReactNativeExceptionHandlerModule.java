package com.masteratul.exceptionhandler;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.lang.Thread.UncaughtExceptionHandler;

public class ReactNativeExceptionHandlerModule extends ReactContextBaseJavaModule {
    private static Class errorIntentTargetClass = DefaultErrorScreen.class;
    private Activity activity;
    private Callback callbackHolder;
    private UncaughtExceptionHandler originalHandler;
    private ReactApplicationContext reactContext;

    public String getName() {
        return "ReactNativeExceptionHandler";
    }

    public ReactNativeExceptionHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void setHandlerforNativeException(final boolean z, Callback callback) {
        this.callbackHolder = callback;
        this.originalHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler(this) {
            /* renamed from: b */
            final /* synthetic */ ReactNativeExceptionHandlerModule f18232b;

            public void uncaughtException(Thread thread, Throwable th) {
                this.f18232b.activity = this.f18232b.getCurrentActivity();
                String stackTraceString = Log.getStackTraceString(th);
                this.f18232b.callbackHolder.invoke(new Object[]{stackTraceString});
                Log.d("ERROR", stackTraceString);
                Intent intent = new Intent();
                intent.setClass(this.f18232b.activity, ReactNativeExceptionHandlerModule.errorIntentTargetClass);
                intent.putExtra("stack_trace_string", stackTraceString);
                intent.setFlags(268435456);
                this.f18232b.activity.startActivity(intent);
                this.f18232b.activity.finish();
                if (this.f18232b.originalHandler != null) {
                    this.f18232b.originalHandler.uncaughtException(thread, th);
                }
                if (z != null) {
                    System.exit(0);
                }
            }
        });
    }

    public static void replaceErrorScreenActivityClass(Class cls) {
        errorIntentTargetClass = cls;
    }
}
