package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.stetho.server.http.HttpStatus;
import java.net.HttpURLConnection;
import org.json.JSONObject;

public final class FacebookRequestError implements Parcelable {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    public static final Creator<FacebookRequestError> CREATOR = new C12621();
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    static final Range HTTP_RANGE_SUCCESS = new Range(HttpStatus.HTTP_OK, 299);
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorRecoveryMessage;
    private final String errorType;
    private final String errorUserMessage;
    private final String errorUserTitle;
    private final FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;

    /* renamed from: com.facebook.FacebookRequestError$1 */
    static class C12621 implements Creator<FacebookRequestError> {
        C12621() {
        }

        public FacebookRequestError createFromParcel(Parcel parcel) {
            return new FacebookRequestError(parcel);
        }

        public FacebookRequestError[] newArray(int i) {
            return new FacebookRequestError[i];
        }
    }

    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    private static class Range {
        private final int end;
        private final int start;

        private Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        boolean contains(int i) {
            return this.start <= i && i <= this.end;
        }
    }

    public int describeContents() {
        return 0;
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        this.requestStatusCode = i;
        this.errorCode = i2;
        this.subErrorCode = i3;
        this.errorType = str;
        this.errorMessage = str2;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        if (facebookException != null) {
            this.exception = facebookException;
            i = 1;
        } else {
            this.exception = new FacebookServiceException(this, str2);
            i = 0;
        }
        str = getErrorClassification();
        if (i != 0) {
            i = Category.OTHER;
        } else {
            i = str.classify(i2, i3, z);
        }
        this.category = i;
        this.errorRecoveryMessage = str.getRecoveryMessage(this.category);
    }

    FacebookRequestError(HttpURLConnection httpURLConnection, Exception exception) {
        Throwable th = exception;
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, th instanceof FacebookException ? (FacebookException) th : new FacebookException(th));
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, false, null, null, null, null, null);
    }

    public Category getCategory() {
        return this.category;
    }

    public int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getSubErrorCode() {
        return this.subErrorCode;
    }

    public String getErrorType() {
        return this.errorType;
    }

    public String getErrorMessage() {
        if (this.errorMessage != null) {
            return this.errorMessage;
        }
        return this.exception.getLocalizedMessage();
    }

    public String getErrorRecoveryMessage() {
        return this.errorRecoveryMessage;
    }

    public String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    public String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    public JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public JSONObject getRequestResult() {
        return this.requestResult;
    }

    public Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    public HttpURLConnection getConnection() {
        return this.connection;
    }

    public FacebookException getException() {
        return this.exception;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{HttpStatus: ");
        stringBuilder.append(this.requestStatusCode);
        stringBuilder.append(", errorCode: ");
        stringBuilder.append(this.errorCode);
        stringBuilder.append(", subErrorCode: ");
        stringBuilder.append(this.subErrorCode);
        stringBuilder.append(", errorType: ");
        stringBuilder.append(this.errorType);
        stringBuilder.append(", errorMessage: ");
        stringBuilder.append(getErrorMessage());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    static com.facebook.FacebookRequestError checkResponseAndCreateError(org.json.JSONObject r16, java.lang.Object r17, java.net.HttpURLConnection r18) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r10 = r16;
        r14 = 0;
        r0 = "code";	 Catch:{ JSONException -> 0x00ea }
        r0 = r10.has(r0);	 Catch:{ JSONException -> 0x00ea }
        if (r0 == 0) goto L_0x00ea;	 Catch:{ JSONException -> 0x00ea }
    L_0x000b:
        r0 = "code";	 Catch:{ JSONException -> 0x00ea }
        r1 = r10.getInt(r0);	 Catch:{ JSONException -> 0x00ea }
        r0 = "body";	 Catch:{ JSONException -> 0x00ea }
        r2 = "FACEBOOK_NON_JSON_RESULT";	 Catch:{ JSONException -> 0x00ea }
        r0 = com.facebook.internal.Utility.getStringPropertyAsJSON(r10, r0, r2);	 Catch:{ JSONException -> 0x00ea }
        if (r0 == 0) goto L_0x00b8;	 Catch:{ JSONException -> 0x00ea }
    L_0x001b:
        r2 = r0 instanceof org.json.JSONObject;	 Catch:{ JSONException -> 0x00ea }
        if (r2 == 0) goto L_0x00b8;	 Catch:{ JSONException -> 0x00ea }
    L_0x001f:
        r9 = r0;	 Catch:{ JSONException -> 0x00ea }
        r9 = (org.json.JSONObject) r9;	 Catch:{ JSONException -> 0x00ea }
        r0 = "error";	 Catch:{ JSONException -> 0x00ea }
        r0 = r9.has(r0);	 Catch:{ JSONException -> 0x00ea }
        r2 = 1;	 Catch:{ JSONException -> 0x00ea }
        r3 = 0;	 Catch:{ JSONException -> 0x00ea }
        r4 = -1;	 Catch:{ JSONException -> 0x00ea }
        if (r0 == 0) goto L_0x0064;	 Catch:{ JSONException -> 0x00ea }
    L_0x002d:
        r0 = "error";	 Catch:{ JSONException -> 0x00ea }
        r0 = com.facebook.internal.Utility.getStringPropertyAsJSON(r9, r0, r14);	 Catch:{ JSONException -> 0x00ea }
        r0 = (org.json.JSONObject) r0;	 Catch:{ JSONException -> 0x00ea }
        r5 = "type";	 Catch:{ JSONException -> 0x00ea }
        r5 = r0.optString(r5, r14);	 Catch:{ JSONException -> 0x00ea }
        r6 = "message";	 Catch:{ JSONException -> 0x00ea }
        r6 = r0.optString(r6, r14);	 Catch:{ JSONException -> 0x00ea }
        r7 = "code";	 Catch:{ JSONException -> 0x00ea }
        r7 = r0.optInt(r7, r4);	 Catch:{ JSONException -> 0x00ea }
        r8 = "error_subcode";	 Catch:{ JSONException -> 0x00ea }
        r4 = r0.optInt(r8, r4);	 Catch:{ JSONException -> 0x00ea }
        r8 = "error_user_msg";	 Catch:{ JSONException -> 0x00ea }
        r8 = r0.optString(r8, r14);	 Catch:{ JSONException -> 0x00ea }
        r11 = "error_user_title";	 Catch:{ JSONException -> 0x00ea }
        r11 = r0.optString(r11, r14);	 Catch:{ JSONException -> 0x00ea }
        r12 = "is_transient";	 Catch:{ JSONException -> 0x00ea }
        r0 = r0.optBoolean(r12, r3);	 Catch:{ JSONException -> 0x00ea }
        r3 = r4;	 Catch:{ JSONException -> 0x00ea }
        r4 = r7;	 Catch:{ JSONException -> 0x00ea }
        r7 = r8;	 Catch:{ JSONException -> 0x00ea }
        r8 = r0;	 Catch:{ JSONException -> 0x00ea }
        goto L_0x00a4;	 Catch:{ JSONException -> 0x00ea }
    L_0x0064:
        r0 = "error_code";	 Catch:{ JSONException -> 0x00ea }
        r0 = r9.has(r0);	 Catch:{ JSONException -> 0x00ea }
        if (r0 != 0) goto L_0x0085;	 Catch:{ JSONException -> 0x00ea }
    L_0x006c:
        r0 = "error_msg";	 Catch:{ JSONException -> 0x00ea }
        r0 = r9.has(r0);	 Catch:{ JSONException -> 0x00ea }
        if (r0 != 0) goto L_0x0085;	 Catch:{ JSONException -> 0x00ea }
    L_0x0074:
        r0 = "error_reason";	 Catch:{ JSONException -> 0x00ea }
        r0 = r9.has(r0);	 Catch:{ JSONException -> 0x00ea }
        if (r0 == 0) goto L_0x007d;	 Catch:{ JSONException -> 0x00ea }
    L_0x007c:
        goto L_0x0085;	 Catch:{ JSONException -> 0x00ea }
    L_0x007d:
        r5 = r14;	 Catch:{ JSONException -> 0x00ea }
        r6 = r5;	 Catch:{ JSONException -> 0x00ea }
        r7 = r6;	 Catch:{ JSONException -> 0x00ea }
        r11 = r7;	 Catch:{ JSONException -> 0x00ea }
        r2 = 0;	 Catch:{ JSONException -> 0x00ea }
        r3 = -1;	 Catch:{ JSONException -> 0x00ea }
        r8 = 0;	 Catch:{ JSONException -> 0x00ea }
        goto L_0x00a4;	 Catch:{ JSONException -> 0x00ea }
    L_0x0085:
        r0 = "error_reason";	 Catch:{ JSONException -> 0x00ea }
        r0 = r9.optString(r0, r14);	 Catch:{ JSONException -> 0x00ea }
        r5 = "error_msg";	 Catch:{ JSONException -> 0x00ea }
        r5 = r9.optString(r5, r14);	 Catch:{ JSONException -> 0x00ea }
        r6 = "error_code";	 Catch:{ JSONException -> 0x00ea }
        r6 = r9.optInt(r6, r4);	 Catch:{ JSONException -> 0x00ea }
        r7 = "error_subcode";	 Catch:{ JSONException -> 0x00ea }
        r4 = r9.optInt(r7, r4);	 Catch:{ JSONException -> 0x00ea }
        r3 = r4;	 Catch:{ JSONException -> 0x00ea }
        r4 = r6;	 Catch:{ JSONException -> 0x00ea }
        r7 = r14;	 Catch:{ JSONException -> 0x00ea }
        r11 = r7;	 Catch:{ JSONException -> 0x00ea }
        r8 = 0;	 Catch:{ JSONException -> 0x00ea }
        r6 = r5;	 Catch:{ JSONException -> 0x00ea }
        r5 = r0;	 Catch:{ JSONException -> 0x00ea }
    L_0x00a4:
        if (r2 == 0) goto L_0x00b8;	 Catch:{ JSONException -> 0x00ea }
    L_0x00a6:
        r15 = new com.facebook.FacebookRequestError;	 Catch:{ JSONException -> 0x00ea }
        r13 = 0;	 Catch:{ JSONException -> 0x00ea }
        r0 = r15;	 Catch:{ JSONException -> 0x00ea }
        r2 = r4;	 Catch:{ JSONException -> 0x00ea }
        r4 = r5;	 Catch:{ JSONException -> 0x00ea }
        r5 = r6;	 Catch:{ JSONException -> 0x00ea }
        r6 = r11;	 Catch:{ JSONException -> 0x00ea }
        r10 = r16;	 Catch:{ JSONException -> 0x00ea }
        r11 = r17;	 Catch:{ JSONException -> 0x00ea }
        r12 = r18;	 Catch:{ JSONException -> 0x00ea }
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);	 Catch:{ JSONException -> 0x00ea }
        return r15;	 Catch:{ JSONException -> 0x00ea }
    L_0x00b8:
        r0 = HTTP_RANGE_SUCCESS;	 Catch:{ JSONException -> 0x00ea }
        r0 = r0.contains(r1);	 Catch:{ JSONException -> 0x00ea }
        if (r0 != 0) goto L_0x00ea;	 Catch:{ JSONException -> 0x00ea }
    L_0x00c0:
        r15 = new com.facebook.FacebookRequestError;	 Catch:{ JSONException -> 0x00ea }
        r2 = -1;	 Catch:{ JSONException -> 0x00ea }
        r3 = -1;	 Catch:{ JSONException -> 0x00ea }
        r4 = 0;	 Catch:{ JSONException -> 0x00ea }
        r5 = 0;	 Catch:{ JSONException -> 0x00ea }
        r6 = 0;	 Catch:{ JSONException -> 0x00ea }
        r7 = 0;	 Catch:{ JSONException -> 0x00ea }
        r8 = 0;	 Catch:{ JSONException -> 0x00ea }
        r0 = "body";	 Catch:{ JSONException -> 0x00ea }
        r0 = r10.has(r0);	 Catch:{ JSONException -> 0x00ea }
        if (r0 == 0) goto L_0x00dd;	 Catch:{ JSONException -> 0x00ea }
    L_0x00d1:
        r0 = "body";	 Catch:{ JSONException -> 0x00ea }
        r9 = "FACEBOOK_NON_JSON_RESULT";	 Catch:{ JSONException -> 0x00ea }
        r0 = com.facebook.internal.Utility.getStringPropertyAsJSON(r10, r0, r9);	 Catch:{ JSONException -> 0x00ea }
        r0 = (org.json.JSONObject) r0;	 Catch:{ JSONException -> 0x00ea }
        r9 = r0;	 Catch:{ JSONException -> 0x00ea }
        goto L_0x00de;	 Catch:{ JSONException -> 0x00ea }
    L_0x00dd:
        r9 = r14;	 Catch:{ JSONException -> 0x00ea }
    L_0x00de:
        r13 = 0;	 Catch:{ JSONException -> 0x00ea }
        r0 = r15;	 Catch:{ JSONException -> 0x00ea }
        r10 = r16;	 Catch:{ JSONException -> 0x00ea }
        r11 = r17;	 Catch:{ JSONException -> 0x00ea }
        r12 = r18;	 Catch:{ JSONException -> 0x00ea }
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);	 Catch:{ JSONException -> 0x00ea }
        return r15;
    L_0x00ea:
        return r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookRequestError.checkResponseAndCreateError(org.json.JSONObject, java.lang.Object, java.net.HttpURLConnection):com.facebook.FacebookRequestError");
    }

    static synchronized FacebookRequestErrorClassification getErrorClassification() {
        synchronized (FacebookRequestError.class) {
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                FacebookRequestErrorClassification defaultErrorClassification = FacebookRequestErrorClassification.getDefaultErrorClassification();
                return defaultErrorClassification;
            }
            defaultErrorClassification = appSettingsWithoutQuery.getErrorClassification();
            return defaultErrorClassification;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.requestStatusCode);
        parcel.writeInt(this.errorCode);
        parcel.writeInt(this.subErrorCode);
        parcel.writeString(this.errorType);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.errorUserTitle);
        parcel.writeString(this.errorUserMessage);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, null, null, null, null, null);
    }
}
