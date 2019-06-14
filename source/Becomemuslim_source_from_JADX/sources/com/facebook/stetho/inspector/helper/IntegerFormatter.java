package com.facebook.stetho.inspector.helper;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.ViewDebug.ExportedProperty;

public class IntegerFormatter {
    private static IntegerFormatter cachedFormatter;

    private static class IntegerFormatterWithHex extends IntegerFormatter {
        private IntegerFormatterWithHex() {
            super();
        }

        @TargetApi(21)
        public String format(Integer num, ExportedProperty exportedProperty) {
            if (exportedProperty == null || !exportedProperty.formatToHexString()) {
                return super.format(num, exportedProperty);
            }
            exportedProperty = new StringBuilder();
            exportedProperty.append("0x");
            exportedProperty.append(Integer.toHexString(num.intValue()));
            return exportedProperty.toString();
        }
    }

    public static IntegerFormatter getInstance() {
        if (cachedFormatter == null) {
            synchronized (IntegerFormatter.class) {
                if (cachedFormatter == null) {
                    if (VERSION.SDK_INT >= 21) {
                        cachedFormatter = new IntegerFormatterWithHex();
                    } else {
                        cachedFormatter = new IntegerFormatter();
                    }
                }
            }
        }
        return cachedFormatter;
    }

    private IntegerFormatter() {
    }

    public String format(Integer num, ExportedProperty exportedProperty) {
        return String.valueOf(num);
    }
}
