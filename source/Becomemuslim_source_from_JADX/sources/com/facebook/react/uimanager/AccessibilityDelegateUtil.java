package com.facebook.react.uimanager;

import android.content.Context;
import android.support.v4.view.C0494b;
import android.support.v4.view.C0517s;
import android.support.v4.view.p033a.C0483b;
import android.view.View;
import com.facebook.react.C1864R;
import java.util.Locale;

public class AccessibilityDelegateUtil {

    public enum AccessibilityRole {
        NONE(null),
        BUTTON("android.widget.Button"),
        LINK("android.widget.ViewGroup"),
        SEARCH("android.widget.EditText"),
        IMAGE("android.widget.ImageView"),
        IMAGEBUTTON("android.widget.ImageView"),
        KEYBOARDKEY("android.inputmethodservice.Keyboard$Key"),
        TEXT("android.widget.ViewGroup"),
        ADJUSTABLE("android.widget.SeekBar"),
        SUMMARY("android.widget.ViewGroup"),
        HEADER("android.widget.ViewGroup");
        
        private final String mValue;

        private AccessibilityRole(String str) {
            this.mValue = str;
        }

        public String getValue() {
            return this.mValue;
        }

        public static AccessibilityRole fromValue(String str) {
            for (AccessibilityRole accessibilityRole : values()) {
                if (accessibilityRole.getValue() != null && accessibilityRole.getValue().equals(str)) {
                    return accessibilityRole;
                }
            }
            return NONE;
        }
    }

    private AccessibilityDelegateUtil() {
    }

    public static void setDelegate(final View view) {
        if (!C0517s.m1701a(view)) {
            C0517s.m1695a(view, new C0494b() {
                public void onInitializeAccessibilityNodeInfo(View view, C0483b c0483b) {
                    super.onInitializeAccessibilityNodeInfo(view, c0483b);
                    CharSequence charSequence = (String) view.getTag(C1864R.id.accessibility_hint);
                    AccessibilityDelegateUtil.setRole(c0483b, AccessibilityDelegateUtil.getAccessibilityRole((String) view.getTag(C1864R.id.accessibility_role)), view.getContext());
                    if (charSequence != null) {
                        String str = (String) c0483b.m1548r();
                        if (str != null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(str);
                            stringBuilder.append(", ");
                            stringBuilder.append(charSequence);
                            c0483b.m1522d(stringBuilder.toString());
                            return;
                        }
                        c0483b.m1522d(charSequence);
                    }
                }
            });
        }
    }

    public static void setRole(C0483b c0483b, AccessibilityRole accessibilityRole, Context context) {
        c0483b.m1512b(accessibilityRole.getValue());
        if (Locale.getDefault().getLanguage().equals(new Locale("en").getLanguage())) {
            if (accessibilityRole.equals(AccessibilityRole.LINK)) {
                c0483b.m1528f(context.getString(C1864R.string.link_description));
            }
            if (accessibilityRole.equals(AccessibilityRole.SEARCH)) {
                c0483b.m1528f(context.getString(C1864R.string.search_description));
            }
            if (accessibilityRole.equals(AccessibilityRole.IMAGE)) {
                c0483b.m1528f(context.getString(C1864R.string.image_description));
            }
            if (accessibilityRole.equals(AccessibilityRole.IMAGEBUTTON)) {
                c0483b.m1528f(context.getString(C1864R.string.image_button_description));
            }
            if (accessibilityRole.equals(AccessibilityRole.ADJUSTABLE)) {
                c0483b.m1528f(context.getString(C1864R.string.adjustable_description));
            }
        }
        if (accessibilityRole.equals(AccessibilityRole.IMAGEBUTTON) != null) {
            c0483b.m1533h(true);
        }
    }

    public static AccessibilityRole getAccessibilityRole(String str) {
        if (str == null) {
            return AccessibilityRole.NONE;
        }
        return AccessibilityRole.valueOf(str.toUpperCase());
    }
}
