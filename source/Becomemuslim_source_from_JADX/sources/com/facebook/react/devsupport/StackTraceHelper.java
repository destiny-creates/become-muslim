package com.facebook.react.devsupport;

import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.devsupport.interfaces.StackFrame;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class StackTraceHelper {
    public static final String COLUMN_KEY = "column";
    public static final String LINE_NUMBER_KEY = "lineNumber";
    private static final Pattern STACK_FRAME_PATTERN1 = Pattern.compile("^(?:(.*?)@)?(.*?)\\:([0-9]+)\\:([0-9]+)$");
    private static final Pattern STACK_FRAME_PATTERN2 = Pattern.compile("\\s*(?:at)\\s*(.+?)\\s*[@(](.*):([0-9]+):([0-9]+)[)]$");

    public static class StackFrameImpl implements StackFrame {
        private final int mColumn;
        private final String mFile;
        private final String mFileName;
        private final int mLine;
        private final String mMethod;

        private StackFrameImpl(String str, String str2, int i, int i2) {
            this.mFile = str;
            this.mMethod = str2;
            this.mLine = i;
            this.mColumn = i2;
            this.mFileName = str != null ? new File(str).getName() : "";
        }

        private StackFrameImpl(String str, String str2, String str3, int i, int i2) {
            this.mFile = str;
            this.mFileName = str2;
            this.mMethod = str3;
            this.mLine = i;
            this.mColumn = i2;
        }

        public String getFile() {
            return this.mFile;
        }

        public String getMethod() {
            return this.mMethod;
        }

        public int getLine() {
            return this.mLine;
        }

        public int getColumn() {
            return this.mColumn;
        }

        public String getFileName() {
            return this.mFileName;
        }

        public JSONObject toJSON() {
            return new JSONObject(MapBuilder.of(UriUtil.LOCAL_FILE_SCHEME, getFile(), "methodName", getMethod(), StackTraceHelper.LINE_NUMBER_KEY, Integer.valueOf(getLine()), StackTraceHelper.COLUMN_KEY, Integer.valueOf(getColumn())));
        }
    }

    public static StackFrame[] convertJsStackTrace(ReadableArray readableArray) {
        int size = readableArray != null ? readableArray.size() : 0;
        StackFrame[] stackFrameArr = new StackFrame[size];
        for (int i = 0; i < size; i++) {
            ReadableType type = readableArray.getType(i);
            if (type == ReadableType.Map) {
                ReadableMap map = readableArray.getMap(i);
                String string = map.getString("methodName");
                String string2 = map.getString(UriUtil.LOCAL_FILE_SCHEME);
                int i2 = (!map.hasKey(LINE_NUMBER_KEY) || map.isNull(LINE_NUMBER_KEY)) ? -1 : map.getInt(LINE_NUMBER_KEY);
                int i3 = (!map.hasKey(COLUMN_KEY) || map.isNull(COLUMN_KEY)) ? -1 : map.getInt(COLUMN_KEY);
                stackFrameArr[i] = new StackFrameImpl(string2, string, i2, i3);
            } else if (type == ReadableType.String) {
                stackFrameArr[i] = new StackFrameImpl(null, readableArray.getString(i), -1, -1);
            }
        }
        return stackFrameArr;
    }

    public static StackFrame[] convertJsStackTrace(JSONArray jSONArray) {
        int i = 0;
        int length = jSONArray != null ? jSONArray.length() : 0;
        StackFrame[] stackFrameArr = new StackFrame[length];
        while (i < length) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("methodName");
                String string2 = jSONObject.getString(UriUtil.LOCAL_FILE_SCHEME);
                int i2 = (!jSONObject.has(LINE_NUMBER_KEY) || jSONObject.isNull(LINE_NUMBER_KEY)) ? -1 : jSONObject.getInt(LINE_NUMBER_KEY);
                int i3 = (!jSONObject.has(COLUMN_KEY) || jSONObject.isNull(COLUMN_KEY)) ? -1 : jSONObject.getInt(COLUMN_KEY);
                stackFrameArr[i] = new StackFrameImpl(string2, string, i2, i3);
                i++;
            } catch (JSONArray jSONArray2) {
                throw new RuntimeException(jSONArray2);
            }
        }
        return stackFrameArr;
    }

    public static StackFrame[] convertJsStackTrace(String str) {
        String[] split = str.split(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        StackFrame[] stackFrameArr = new StackFrame[split.length];
        for (int i = 0; i < split.length; i++) {
            Matcher matcher = STACK_FRAME_PATTERN1.matcher(split[i]);
            Matcher matcher2 = STACK_FRAME_PATTERN2.matcher(split[i]);
            if (matcher2.find()) {
                matcher = matcher2;
            } else if (!matcher.find()) {
                stackFrameArr[i] = new StackFrameImpl(null, split[i], -1, -1);
            }
            stackFrameArr[i] = new StackFrameImpl(matcher.group(2), matcher.group(1) == null ? "(unknown)" : matcher.group(1), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
        }
        return stackFrameArr;
    }

    public static StackFrame[] convertJavaStackTrace(Throwable th) {
        th = th.getStackTrace();
        StackFrame[] stackFrameArr = new StackFrame[th.length];
        for (int i = 0; i < th.length; i++) {
            stackFrameArr[i] = new StackFrameImpl(th[i].getClassName(), th[i].getFileName(), th[i].getMethodName(), th[i].getLineNumber(), -1);
        }
        return stackFrameArr;
    }

    public static String formatFrameSource(StackFrame stackFrame) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackFrame.getFileName());
        int line = stackFrame.getLine();
        if (line > 0) {
            stringBuilder.append(":");
            stringBuilder.append(line);
            stackFrame = stackFrame.getColumn();
            if (stackFrame > null) {
                stringBuilder.append(":");
                stringBuilder.append(stackFrame);
            }
        }
        return stringBuilder.toString();
    }

    public static String formatStackTrace(String str, StackFrame[] stackFrameArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        for (StackFrame stackFrame : stackFrameArr) {
            stringBuilder.append(stackFrame.getMethod());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder.append("    ");
            stringBuilder.append(formatFrameSource(stackFrame));
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        }
        return stringBuilder.toString();
    }
}
