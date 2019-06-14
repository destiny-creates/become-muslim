package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.C0373d;
import android.util.Log;
import com.facebook.AccessToken.AccessTokenRefreshCallback;
import com.facebook.GraphRequest.Callback;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class AccessTokenManager {
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    public static final String TAG = "AccessTokenManager";
    private static final String TOKEN_EXTEND_GRAPH_PATH = "oauth/access_token";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    private static volatile AccessTokenManager instance;
    private final AccessTokenCache accessTokenCache;
    private AccessToken currentAccessToken;
    private Date lastAttemptedTokenExtendDate = new Date(0);
    private final C0373d localBroadcastManager;
    private AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);

    private static class RefreshResult {
        public String accessToken;
        public Long dataAccessExpirationTime;
        public int expiresAt;

        private RefreshResult() {
        }
    }

    AccessTokenManager(C0373d c0373d, AccessTokenCache accessTokenCache) {
        Validate.notNull(c0373d, "localBroadcastManager");
        Validate.notNull(accessTokenCache, "accessTokenCache");
        this.localBroadcastManager = c0373d;
        this.accessTokenCache = accessTokenCache;
    }

    static AccessTokenManager getInstance() {
        if (instance == null) {
            synchronized (AccessTokenManager.class) {
                if (instance == null) {
                    instance = new AccessTokenManager(C0373d.m1138a(FacebookSdk.getApplicationContext()), new AccessTokenCache());
                }
            }
        }
        return instance;
    }

    AccessToken getCurrentAccessToken() {
        return this.currentAccessToken;
    }

    boolean loadCurrentAccessToken() {
        AccessToken load = this.accessTokenCache.load();
        if (load == null) {
            return false;
        }
        setCurrentAccessToken(load, false);
        return true;
    }

    void setCurrentAccessToken(AccessToken accessToken) {
        setCurrentAccessToken(accessToken, true);
    }

    private void setCurrentAccessToken(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.currentAccessToken;
        this.currentAccessToken = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0);
        if (z) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                this.accessTokenCache.clear();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(accessToken2, accessToken)) {
            sendCurrentAccessTokenChangedBroadcastIntent(accessToken2, accessToken);
            setTokenExpirationBroadcastAlarm();
        }
    }

    void currentAccessTokenChanged() {
        sendCurrentAccessTokenChangedBroadcastIntent(this.currentAccessToken, this.currentAccessToken);
    }

    private void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, accessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, accessToken2);
        this.localBroadcastManager.m1143a(intent);
    }

    private void setTokenExpirationBroadcastAlarm() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService("alarm");
        if (AccessToken.isCurrentAccessTokenActive() && currentAccessToken.getExpires() != null) {
            if (alarmManager != null) {
                Intent intent = new Intent(applicationContext, CurrentAccessTokenExpirationBroadcastReceiver.class);
                intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
                alarmManager.set(1, currentAccessToken.getExpires().getTime(), PendingIntent.getBroadcast(applicationContext, 0, intent, 0));
            }
        }
    }

    void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            refreshCurrentAccessToken(null);
        }
    }

    private boolean shouldExtendAccessToken() {
        boolean z = false;
        if (this.currentAccessToken == null) {
            return false;
        }
        Long valueOf = Long.valueOf(new Date().getTime());
        if (this.currentAccessToken.getSource().canExtendToken() && valueOf.longValue() - this.lastAttemptedTokenExtendDate.getTime() > 3600000 && valueOf.longValue() - this.currentAccessToken.getLastRefresh().getTime() > 86400000) {
            z = true;
        }
        return z;
    }

    private static GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, Callback callback) {
        return new GraphRequest(accessToken, ME_PERMISSIONS_GRAPH_PATH, new Bundle(), HttpMethod.GET, callback);
    }

    private static GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, Callback callback) {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accessToken, TOKEN_EXTEND_GRAPH_PATH, bundle, HttpMethod.GET, callback);
    }

    void refreshCurrentAccessToken(final AccessTokenRefreshCallback accessTokenRefreshCallback) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    AccessTokenManager.this.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
                }
            });
        }
    }

    private void refreshCurrentAccessTokenImpl(AccessTokenRefreshCallback accessTokenRefreshCallback) {
        final AccessToken accessToken = this.currentAccessToken;
        if (accessToken == null) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
        } else if (this.tokenRefreshInProgress.compareAndSet(false, true)) {
            this.lastAttemptedTokenExtendDate = new Date();
            final Set hashSet = new HashSet();
            final Set hashSet2 = new HashSet();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final RefreshResult refreshResult = new RefreshResult();
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(createGrantedPermissionsRequest(accessToken, new Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    graphResponse = graphResponse.getJSONObject();
                    if (graphResponse != null) {
                        graphResponse = graphResponse.optJSONArray("data");
                        if (graphResponse != null) {
                            atomicBoolean.set(true);
                            for (int i = 0; i < graphResponse.length(); i++) {
                                JSONObject optJSONObject = graphResponse.optJSONObject(i);
                                if (optJSONObject != null) {
                                    String optString = optJSONObject.optString("permission");
                                    String optString2 = optJSONObject.optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
                                    if (!(Utility.isNullOrEmpty(optString) || Utility.isNullOrEmpty(optString2))) {
                                        optString2 = optString2.toLowerCase(Locale.US);
                                        if (optString2.equals("granted")) {
                                            hashSet.add(optString);
                                        } else if (optString2.equals("declined")) {
                                            hashSet2.add(optString);
                                        } else {
                                            optString = AccessTokenManager.TAG;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append("Unexpected status: ");
                                            stringBuilder.append(optString2);
                                            Log.w(optString, stringBuilder.toString());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }), createExtendAccessTokenRequest(accessToken, new Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    graphResponse = graphResponse.getJSONObject();
                    if (graphResponse != null) {
                        refreshResult.accessToken = graphResponse.optString("access_token");
                        refreshResult.expiresAt = graphResponse.optInt("expires_at");
                        refreshResult.dataAccessExpirationTime = Long.valueOf(graphResponse.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME));
                    }
                }
            }));
            final AccessTokenRefreshCallback accessTokenRefreshCallback2 = accessTokenRefreshCallback;
            graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
                public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                    Throwable th;
                    AccessToken accessToken;
                    C35134 c35134 = this;
                    try {
                        AccessTokenRefreshCallback accessTokenRefreshCallback;
                        if (AccessTokenManager.getInstance().getCurrentAccessToken() != null) {
                            if (AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() == accessToken.getUserId()) {
                                if (!atomicBoolean.get() && refreshResult.accessToken == null && refreshResult.expiresAt == 0) {
                                    if (accessTokenRefreshCallback2 != null) {
                                        accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                                    }
                                    AccessTokenManager.this.tokenRefreshInProgress.set(false);
                                    accessTokenRefreshCallback = accessTokenRefreshCallback2;
                                    return;
                                }
                                String str;
                                Set set;
                                Date date;
                                Date date2;
                                if (refreshResult.accessToken != null) {
                                    str = refreshResult.accessToken;
                                } else {
                                    str = accessToken.getToken();
                                }
                                String str2 = str;
                                String applicationId = accessToken.getApplicationId();
                                String userId = accessToken.getUserId();
                                if (atomicBoolean.get()) {
                                    set = hashSet;
                                } else {
                                    set = accessToken.getPermissions();
                                }
                                Set set2 = set;
                                if (atomicBoolean.get()) {
                                    set = hashSet2;
                                } else {
                                    set = accessToken.getDeclinedPermissions();
                                }
                                Set set3 = set;
                                AccessTokenSource source = accessToken.getSource();
                                if (refreshResult.expiresAt != 0) {
                                    date = new Date(((long) refreshResult.expiresAt) * 1000);
                                } else {
                                    date = accessToken.getExpires();
                                }
                                Date date3 = new Date();
                                if (refreshResult.dataAccessExpirationTime != null) {
                                    date2 = new Date(1000 * refreshResult.dataAccessExpirationTime.longValue());
                                } else {
                                    date2 = accessToken.getDataAccessExpirationTime();
                                }
                                AccessToken accessToken2 = new AccessToken(str2, applicationId, userId, set2, set3, source, date, date3, date2);
                                try {
                                    AccessTokenManager.getInstance().setCurrentAccessToken(accessToken2);
                                    AccessTokenManager.this.tokenRefreshInProgress.set(false);
                                    if (accessTokenRefreshCallback2 != null) {
                                        accessTokenRefreshCallback2.OnTokenRefreshed(accessToken2);
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    accessToken = accessToken2;
                                    AccessTokenManager.this.tokenRefreshInProgress.set(false);
                                    accessTokenRefreshCallback2.OnTokenRefreshed(accessToken);
                                    throw th;
                                }
                            }
                        }
                        if (accessTokenRefreshCallback2 != null) {
                            accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
                        }
                        AccessTokenManager.this.tokenRefreshInProgress.set(false);
                        accessTokenRefreshCallback = accessTokenRefreshCallback2;
                    } catch (Throwable th3) {
                        th = th3;
                        accessToken = null;
                        AccessTokenManager.this.tokenRefreshInProgress.set(false);
                        if (!(accessTokenRefreshCallback2 == null || accessToken == null)) {
                            accessTokenRefreshCallback2.OnTokenRefreshed(accessToken);
                        }
                        throw th;
                    }
                }
            });
            graphRequestBatch.executeAsync();
        } else {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
            }
        }
    }
}
