package com.facebook.react.util;

import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.devsupport.StackTraceHelper;
import java.util.regex.Pattern;

public class JSStackTrace {
    private static final Pattern mJsModuleIdPattern = Pattern.compile("(?:^|[/\\\\])(\\d+\\.js)$");

    public static String format(String str, ReadableArray readableArray) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(", stack:\n");
        for (str = null; str < readableArray.size(); str++) {
            ReadableMap map = readableArray.getMap(str);
            stringBuilder.append(map.getString("methodName"));
            stringBuilder.append("@");
            stringBuilder.append(stackFrameToModuleId(map));
            stringBuilder.append(map.getInt(StackTraceHelper.LINE_NUMBER_KEY));
            if (map.hasKey(StackTraceHelper.COLUMN_KEY) && !map.isNull(StackTraceHelper.COLUMN_KEY) && map.getType(StackTraceHelper.COLUMN_KEY) == ReadableType.Number) {
                stringBuilder.append(":");
                stringBuilder.append(map.getInt(StackTraceHelper.COLUMN_KEY));
            }
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        }
        return stringBuilder.toString();
    }

    private static String stackFrameToModuleId(ReadableMap readableMap) {
        if (readableMap.hasKey(UriUtil.LOCAL_FILE_SCHEME) && !readableMap.isNull(UriUtil.LOCAL_FILE_SCHEME) && readableMap.getType(UriUtil.LOCAL_FILE_SCHEME) == ReadableType.String) {
            readableMap = mJsModuleIdPattern.matcher(readableMap.getString(UriUtil.LOCAL_FILE_SCHEME));
            if (readableMap.find()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(readableMap.group(1));
                stringBuilder.append(":");
                return stringBuilder.toString();
            }
        }
        return "";
    }
}
