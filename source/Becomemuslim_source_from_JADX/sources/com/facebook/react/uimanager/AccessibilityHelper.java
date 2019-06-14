package com.facebook.react.uimanager;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.RadioButton;

class AccessibilityHelper {
    private static final String BUTTON = "button";
    private static final AccessibilityDelegate BUTTON_DELEGATE = new C19621();
    private static final String RADIOBUTTON_CHECKED = "radiobutton_checked";
    private static final AccessibilityDelegate RADIOBUTTON_CHECKED_DELEGATE = new C19632();
    private static final String RADIOBUTTON_UNCHECKED = "radiobutton_unchecked";
    private static final AccessibilityDelegate RADIOBUTTON_UNCHECKED_DELEGATE = new C19643();

    /* renamed from: com.facebook.react.uimanager.AccessibilityHelper$1 */
    static class C19621 extends AccessibilityDelegate {
        C19621() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(Button.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(Button.class.getName());
        }
    }

    /* renamed from: com.facebook.react.uimanager.AccessibilityHelper$2 */
    static class C19632 extends AccessibilityDelegate {
        C19632() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(RadioButton.class.getName());
            accessibilityEvent.setChecked(true);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(RadioButton.class.getName());
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(true);
        }
    }

    /* renamed from: com.facebook.react.uimanager.AccessibilityHelper$3 */
    static class C19643 extends AccessibilityDelegate {
        C19643() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(RadioButton.class.getName());
            accessibilityEvent.setChecked(null);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(RadioButton.class.getName());
            accessibilityNodeInfo.setCheckable(true);
            accessibilityNodeInfo.setChecked(null);
        }
    }

    AccessibilityHelper() {
    }

    public static void updateAccessibilityComponentType(View view, String str) {
        if (str == null) {
            view.setAccessibilityDelegate(null);
            return;
        }
        Object obj = -1;
        int hashCode = str.hashCode();
        if (hashCode != -1377687758) {
            if (hashCode != -1320494052) {
                if (hashCode == -714126251) {
                    if (str.equals(RADIOBUTTON_CHECKED) != null) {
                        obj = 1;
                    }
                }
            } else if (str.equals(RADIOBUTTON_UNCHECKED) != null) {
                obj = 2;
            }
        } else if (str.equals(BUTTON) != null) {
            obj = null;
        }
        switch (obj) {
            case null:
                view.setAccessibilityDelegate(BUTTON_DELEGATE);
                break;
            case 1:
                view.setAccessibilityDelegate(RADIOBUTTON_CHECKED_DELEGATE);
                break;
            case 2:
                view.setAccessibilityDelegate(RADIOBUTTON_UNCHECKED_DELEGATE);
                break;
            default:
                view.setAccessibilityDelegate(null);
                break;
        }
    }

    public static void sendAccessibilityEvent(View view, int i) {
        view.sendAccessibilityEvent(i);
    }
}
