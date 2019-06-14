package com.facebook.react.views.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.uimanager.ViewProps;

public class ReactDrawableHelper {
    private static final TypedValue sResolveOutValue = new TypedValue();

    public static Drawable createDrawableFromJSDescription(Context context, ReadableMap readableMap) {
        String string = readableMap.getString("type");
        if ("ThemeAttrAndroid".equals(string)) {
            readableMap = readableMap.getString("attribute");
            SoftAssertions.assertNotNull(readableMap);
            int identifier = context.getResources().getIdentifier(readableMap, "attr", "android");
            StringBuilder stringBuilder;
            if (identifier == 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Attribute ");
                stringBuilder.append(readableMap);
                stringBuilder.append(" couldn't be found in the resource list");
                throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            } else if (!context.getTheme().resolveAttribute(identifier, sResolveOutValue, true)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Attribute ");
                stringBuilder.append(readableMap);
                stringBuilder.append(" couldn't be resolved into a drawable");
                throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            } else if (VERSION.SDK_INT >= 21) {
                return context.getResources().getDrawable(sResolveOutValue.resourceId, context.getTheme());
            } else {
                return context.getResources().getDrawable(sResolveOutValue.resourceId);
            }
        } else if (!"RippleAndroid".equals(string)) {
            readableMap = new StringBuilder();
            readableMap.append("Invalid type for android drawable: ");
            readableMap.append(string);
            throw new JSApplicationIllegalArgumentException(readableMap.toString());
        } else if (VERSION.SDK_INT >= 21) {
            if (readableMap.hasKey(ViewProps.COLOR) && !readableMap.isNull(ViewProps.COLOR)) {
                context = readableMap.getInt(ViewProps.COLOR);
            } else if (context.getTheme().resolveAttribute(16843820, sResolveOutValue, true)) {
                context = context.getResources().getColor(sResolveOutValue.resourceId);
            } else {
                throw new JSApplicationIllegalArgumentException("Attribute colorControlHighlight couldn't be resolved into a drawable");
            }
            if (readableMap.hasKey("borderless") && !readableMap.isNull("borderless")) {
                if (readableMap.getBoolean("borderless") != null) {
                    readableMap = null;
                    return new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{context}), null, readableMap);
                }
            }
            readableMap = new ColorDrawable(-1);
            return new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{context}), null, readableMap);
        } else {
            throw new JSApplicationIllegalArgumentException("Ripple drawable is not available on android API <21");
        }
    }
}
