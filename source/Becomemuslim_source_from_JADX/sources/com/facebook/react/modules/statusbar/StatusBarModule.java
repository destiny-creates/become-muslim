package com.facebook.react.modules.statusbar;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.C0517s;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.facebook.common.logging.FLog;
import com.facebook.internal.Utility;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;

@ReactModule(name = "StatusBarManager")
public class StatusBarModule extends ReactContextBaseJavaModule {
    private static final String HEIGHT_KEY = "HEIGHT";

    public String getName() {
        return "StatusBarManager";
    }

    public StatusBarModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        Context reactApplicationContext = getReactApplicationContext();
        int identifier = reactApplicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return MapBuilder.of(HEIGHT_KEY, Float.valueOf(identifier > 0 ? PixelUtil.toDIPFromPixel((float) reactApplicationContext.getResources().getDimensionPixelSize(identifier)) : 0.0f));
    }

    @ReactMethod
    public void setColor(int i, boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.m5714w(ReactConstants.TAG, "StatusBarModule: Ignored status bar change, current activity is null.");
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            final boolean z2 = z;
            final int i2 = i;
            UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext()) {

                /* renamed from: com.facebook.react.modules.statusbar.StatusBarModule$1$1 */
                class C19521 implements AnimatorUpdateListener {
                    C19521() {
                    }

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        currentActivity.getWindow().setStatusBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }

                @TargetApi(21)
                public void runGuarded() {
                    currentActivity.getWindow().addFlags(LinearLayoutManager.INVALID_OFFSET);
                    if (z2) {
                        int statusBarColor = currentActivity.getWindow().getStatusBarColor();
                        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(statusBarColor), Integer.valueOf(i2)});
                        ofObject.addUpdateListener(new C19521());
                        ofObject.setDuration(300).setStartDelay(0);
                        ofObject.start();
                        return;
                    }
                    currentActivity.getWindow().setStatusBarColor(i2);
                }
            });
        }
    }

    @ReactMethod
    public void setTranslucent(final boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.m5714w(ReactConstants.TAG, "StatusBarModule: Ignored status bar change, current activity is null.");
            return;
        }
        if (VERSION.SDK_INT >= 21) {
            UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext()) {

                /* renamed from: com.facebook.react.modules.statusbar.StatusBarModule$2$1 */
                class C19531 implements OnApplyWindowInsetsListener {
                    C19531() {
                    }

                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        view = view.onApplyWindowInsets(windowInsets);
                        return view.replaceSystemWindowInsets(view.getSystemWindowInsetLeft(), 0, view.getSystemWindowInsetRight(), view.getSystemWindowInsetBottom());
                    }
                }

                @TargetApi(21)
                public void runGuarded() {
                    View decorView = currentActivity.getWindow().getDecorView();
                    if (z) {
                        decorView.setOnApplyWindowInsetsListener(new C19531());
                    } else {
                        decorView.setOnApplyWindowInsetsListener(null);
                    }
                    C0517s.m1721o(decorView);
                }
            });
        }
    }

    @ReactMethod
    public void setHidden(final boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.m5714w(ReactConstants.TAG, "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (z) {
                        currentActivity.getWindow().addFlags(1024);
                        currentActivity.getWindow().clearFlags(2048);
                        return;
                    }
                    currentActivity.getWindow().addFlags(2048);
                    currentActivity.getWindow().clearFlags(1024);
                }
            });
        }
    }

    @ReactMethod
    public void setStyle(final String str) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.m5714w(ReactConstants.TAG, "StatusBarModule: Ignored status bar change, current activity is null.");
            return;
        }
        if (VERSION.SDK_INT >= 23) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                @TargetApi(23)
                public void run() {
                    currentActivity.getWindow().getDecorView().setSystemUiVisibility(str.equals("dark-content") ? Utility.DEFAULT_STREAM_BUFFER_SIZE : 0);
                }
            });
        }
    }
}
