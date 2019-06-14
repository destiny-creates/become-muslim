package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;

public class SensitiveUserDataUtils {
    public static boolean isSensitiveUserData(View view) {
        boolean z = false;
        if (!(view instanceof TextView)) {
            return false;
        }
        TextView textView = (TextView) view;
        if (isPassword(textView) || isCreditCard(textView) || isPersonName(textView) || isPostalAddress(textView) || isPhoneNumber(textView) || isEmail(textView) != null) {
            z = true;
        }
        return z;
    }

    private static boolean isPassword(TextView textView) {
        if (textView.getInputType() == 128) {
            return true;
        }
        return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    private static boolean isEmail(TextView textView) {
        if (textView.getInputType() == 32) {
            return true;
        }
        textView = ViewHierarchy.getTextOfView(textView);
        if (textView != null) {
            if (textView.length() != 0) {
                return Patterns.EMAIL_ADDRESS.matcher(textView).matches();
            }
        }
        return null;
    }

    private static boolean isPersonName(TextView textView) {
        return textView.getInputType() == 96 ? true : null;
    }

    private static boolean isPostalAddress(TextView textView) {
        return textView.getInputType() == 112 ? true : null;
    }

    private static boolean isPhoneNumber(TextView textView) {
        return textView.getInputType() == 3 ? true : null;
    }

    private static boolean isCreditCard(TextView textView) {
        textView = ViewHierarchy.getTextOfView(textView).replaceAll("\\s", "");
        int length = textView.length();
        boolean z = false;
        if (length >= 12) {
            if (length <= 19) {
                length--;
                int i = 0;
                int i2 = 0;
                while (length >= 0) {
                    char charAt = textView.charAt(length);
                    if (charAt >= '0') {
                        if (charAt <= '9') {
                            int i3 = charAt - 48;
                            if (i2 != 0) {
                                i3 *= 2;
                                if (i3 > 9) {
                                    i3 = (i3 % 10) + 1;
                                }
                            }
                            i += i3;
                            i2 ^= 1;
                            length--;
                        }
                    }
                    return false;
                }
                if (i % 10 == 0) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }
}
