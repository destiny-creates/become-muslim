package com.facebook.react.devsupport;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;

class DebugOverlayController {
    private FrameLayout mFPSDebugViewContainer;
    private final ReactContext mReactContext;
    private final WindowManager mWindowManager;

    public static void requestPermission(Context context) {
        if (VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(context)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("package:");
            stringBuilder.append(context.getPackageName());
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(stringBuilder.toString()));
            intent.setFlags(268435456);
            FLog.m5714w(ReactConstants.TAG, "Overlay permissions needs to be granted in order for react native apps to run in dev mode");
            if (canHandleIntent(context, intent)) {
                context.startActivity(intent);
            }
        }
    }

    private static boolean permissionCheck(Context context) {
        if (VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(context) == null ? null : true;
        } else {
            return hasPermission(context, "android.permission.SYSTEM_ALERT_WINDOW");
        }
    }

    private static boolean hasPermission(Context context, String str) {
        try {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (context.requestedPermissions != null) {
                for (String equals : context.requestedPermissions) {
                    if (equals.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Throwable e) {
            FLog.m5675e(ReactConstants.TAG, "Error while retrieving package info", e);
        }
        return false;
    }

    private static boolean canHandleIntent(Context context, Intent intent) {
        return intent.resolveActivity(context.getPackageManager()) != null ? true : null;
    }

    public DebugOverlayController(ReactContext reactContext) {
        this.mReactContext = reactContext;
        this.mWindowManager = (WindowManager) reactContext.getSystemService("window");
    }

    public void setFpsDebugViewVisible(final boolean z) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (z && DebugOverlayController.this.mFPSDebugViewContainer == null) {
                    if (DebugOverlayController.permissionCheck(DebugOverlayController.this.mReactContext)) {
                        DebugOverlayController.this.mFPSDebugViewContainer = new FpsView(DebugOverlayController.this.mReactContext);
                        DebugOverlayController.this.mWindowManager.addView(DebugOverlayController.this.mFPSDebugViewContainer, new LayoutParams(-1, -1, WindowOverlayCompat.TYPE_SYSTEM_OVERLAY, 24, -3));
                    } else {
                        FLog.m5662d(ReactConstants.TAG, "Wait for overlay permission to be set");
                    }
                } else if (!(z || DebugOverlayController.this.mFPSDebugViewContainer == null)) {
                    DebugOverlayController.this.mFPSDebugViewContainer.removeAllViews();
                    DebugOverlayController.this.mWindowManager.removeView(DebugOverlayController.this.mFPSDebugViewContainer);
                    DebugOverlayController.this.mFPSDebugViewContainer = null;
                }
            }
        });
    }
}
