package com.facebook.appevents;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.stetho.common.Utf8Charset;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

class AppEvent implements Serializable {
    private static final long serialVersionUID = 1;
    private static final HashSet<String> validatedIdentifiers = new HashSet();
    private final String checksum;
    private final boolean isImplicit;
    private final JSONObject jsonObject;
    private final String name;

    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        private final boolean isImplicit;
        private final String jsonString;

        private SerializationProxyV1(String str, boolean z) {
            this.jsonString = str;
            this.isImplicit = z;
        }

        private Object readResolve() {
            return new AppEvent(this.jsonString, this.isImplicit, null);
        }
    }

    static class SerializationProxyV2 implements Serializable {
        private static final long serialVersionUID = 20160803001L;
        private final String checksum;
        private final boolean isImplicit;
        private final String jsonString;

        private SerializationProxyV2(String str, boolean z, String str2) {
            this.jsonString = str;
            this.isImplicit = z;
            this.checksum = str2;
        }

        private Object readResolve() {
            return new AppEvent(this.jsonString, this.isImplicit, this.checksum);
        }
    }

    public AppEvent(String str, String str2, Double d, Bundle bundle, boolean z, UUID uuid) {
        this.jsonObject = getJSONObjectForAppEvent(str, str2, d, bundle, z, uuid);
        this.isImplicit = z;
        this.name = str2;
        this.checksum = calculateChecksum();
    }

    public String getName() {
        return this.name;
    }

    private AppEvent(String str, boolean z, String str2) {
        this.jsonObject = new JSONObject(str);
        this.isImplicit = z;
        this.name = this.jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY);
        this.checksum = str2;
    }

    public boolean getIsImplicit() {
        return this.isImplicit;
    }

    public JSONObject getJSONObject() {
        return this.jsonObject;
    }

    public boolean isChecksumValid() {
        if (this.checksum == null) {
            return true;
        }
        return calculateChecksum().equals(this.checksum);
    }

    private static void validateIdentifier(String str) {
        if (!(str == null || str.length() == 0)) {
            if (str.length() <= 40) {
                boolean contains;
                synchronized (validatedIdentifiers) {
                    contains = validatedIdentifiers.contains(str);
                }
                if (!contains) {
                    if (str.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
                        synchronized (validatedIdentifiers) {
                            validatedIdentifiers.add(str);
                        }
                        return;
                    }
                    throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[]{str}));
                }
                return;
            }
        }
        if (str == null) {
            str = "<None Provided>";
        }
        throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[]{str, Integer.valueOf(40)}));
    }

    private static JSONObject getJSONObjectForAppEvent(String str, String str2, Double d, Bundle bundle, boolean z, UUID uuid) {
        validateIdentifier(str2);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.EVENT_NAME_EVENT_KEY, str2);
        jSONObject.put(Constants.EVENT_NAME_MD5_EVENT_KEY, md5Checksum(str2));
        jSONObject.put(Constants.LOG_TIME_APP_EVENT_KEY, System.currentTimeMillis() / 1000);
        jSONObject.put("_ui", str);
        if (uuid != null) {
            jSONObject.put("_session_id", uuid);
        }
        if (d != null) {
            jSONObject.put(AppEventsConstants.EVENT_PARAM_VALUE_TO_SUM, d.doubleValue());
        }
        if (z) {
            jSONObject.put("_implicitlyLogged", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                validateIdentifier(str3);
                Object obj = bundle.get(str3);
                if (!(obj instanceof String)) {
                    if (!(obj instanceof Number)) {
                        throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[]{obj, str3}));
                    }
                }
                jSONObject.put(str3, obj.toString());
            }
        }
        if (!z) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", jSONObject.toString());
        }
        return jSONObject;
    }

    private Object writeReplace() {
        return new SerializationProxyV2(this.jsonObject.toString(), this.isImplicit, this.checksum);
    }

    public String toString() {
        return String.format("\"%s\", implicit: %b, json: %s", new Object[]{this.jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()});
    }

    private String calculateChecksum() {
        if (VERSION.SDK_INT > 19) {
            return md5Checksum(this.jsonObject.toString());
        }
        Object arrayList = new ArrayList();
        Iterator keys = this.jsonObject.keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            stringBuilder.append(str);
            stringBuilder.append(" = ");
            stringBuilder.append(this.jsonObject.optString(str));
            stringBuilder.append('\n');
        }
        return md5Checksum(stringBuilder.toString());
    }

    private static String md5Checksum(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            str = str.getBytes(Utf8Charset.NAME);
            instance.update(str, 0, str.length);
            return AppEventUtility.bytesToHex(instance.digest());
        } catch (Exception e) {
            Utility.logd("Failed to generate checksum: ", e);
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } catch (Exception e2) {
            Utility.logd("Failed to generate checksum: ", e2);
            return AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
    }
}
