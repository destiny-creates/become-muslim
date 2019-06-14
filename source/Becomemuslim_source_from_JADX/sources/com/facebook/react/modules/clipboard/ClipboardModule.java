package com.facebook.react.modules.clipboard;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.react.bridge.ContextBaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "Clipboard")
public class ClipboardModule extends ContextBaseJavaModule {
    public String getName() {
        return "Clipboard";
    }

    public ClipboardModule(Context context) {
        super(context);
    }

    private ClipboardManager getClipboardService() {
        Context context = getContext();
        getContext();
        return (ClipboardManager) context.getSystemService("clipboard");
    }

    @ReactMethod
    public void getString(Promise promise) {
        try {
            ClipboardManager clipboardService = getClipboardService();
            ClipData primaryClip = clipboardService.getPrimaryClip();
            if (primaryClip == null) {
                promise.resolve("");
            } else if (primaryClip.getItemCount() >= 1) {
                Item itemAt = clipboardService.getPrimaryClip().getItemAt(0);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(itemAt.getText());
                promise.resolve(stringBuilder.toString());
            } else {
                promise.resolve("");
            }
        } catch (Throwable e) {
            promise.reject(e);
        }
    }

    @SuppressLint({"DeprecatedMethod"})
    @ReactMethod
    public void setString(String str) {
        if (VERSION.SDK_INT >= 11) {
            getClipboardService().setPrimaryClip(ClipData.newPlainText(null, str));
            return;
        }
        getClipboardService().setText(str);
    }
}
