package com.facebook.react.modules.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import com.amplitude.api.Constants;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.GuardedResultAsyncTask;
import com.facebook.react.bridge.ReactContext;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ForwardingCookieHandler extends CookieHandler {
    private static final String COOKIE_HEADER = "Cookie";
    private static final boolean USES_LEGACY_STORE = (VERSION.SDK_INT < 21);
    private static final String VERSION_ONE_HEADER = "Set-cookie2";
    private static final String VERSION_ZERO_HEADER = "Set-cookie";
    private final ReactContext mContext;
    private CookieManager mCookieManager;
    private final CookieSaver mCookieSaver = new CookieSaver();

    private class CookieSaver {
        private static final int MSG_PERSIST_COOKIES = 1;
        private static final int TIMEOUT = 30000;
        private final Handler mHandler;

        /* renamed from: com.facebook.react.modules.network.ForwardingCookieHandler$CookieSaver$2 */
        class C19512 implements Runnable {
            C19512() {
            }

            public void run() {
                if (ForwardingCookieHandler.USES_LEGACY_STORE) {
                    CookieSyncManager.getInstance().sync();
                } else {
                    CookieSaver.this.flush();
                }
            }
        }

        public CookieSaver() {
            this.mHandler = new Handler(Looper.getMainLooper(), new Callback(ForwardingCookieHandler.this) {
                public boolean handleMessage(Message message) {
                    if (message.what != 1) {
                        return null;
                    }
                    CookieSaver.this.persistCookies();
                    return true;
                }
            });
        }

        public void onCookiesModified() {
            if (ForwardingCookieHandler.USES_LEGACY_STORE) {
                this.mHandler.sendEmptyMessageDelayed(1, Constants.EVENT_UPLOAD_PERIOD_MILLIS);
            }
        }

        public void persistCookies() {
            this.mHandler.removeMessages(1);
            ForwardingCookieHandler.this.runInBackground(new C19512());
        }

        @TargetApi(21)
        private void flush() {
            ForwardingCookieHandler.this.getCookieManager().flush();
        }
    }

    public ForwardingCookieHandler(ReactContext reactContext) {
        this.mContext = reactContext;
    }

    public Map<String, List<String>> get(URI uri, Map<String, List<String>> map) {
        uri = getCookieManager().getCookie(uri.toString());
        if (TextUtils.isEmpty(uri) != null) {
            return Collections.emptyMap();
        }
        return Collections.singletonMap(COOKIE_HEADER, Collections.singletonList(uri));
    }

    public void put(URI uri, Map<String, List<String>> map) {
        uri = uri.toString();
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            String str = (String) entry.getKey();
            if (str != null && isCookieHeader(str)) {
                addCookies(uri, (List) entry.getValue());
            }
        }
    }

    public void clearCookies(final com.facebook.react.bridge.Callback callback) {
        if (USES_LEGACY_STORE) {
            new GuardedResultAsyncTask<Boolean>(this.mContext) {
                protected Boolean doInBackgroundGuarded() {
                    ForwardingCookieHandler.this.getCookieManager().removeAllCookie();
                    ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
                    return Boolean.valueOf(true);
                }

                protected void onPostExecuteGuarded(Boolean bool) {
                    callback.invoke(bool);
                }
            }.execute(new Void[null]);
        } else {
            clearCookiesAsync(callback);
        }
    }

    private void clearCookiesAsync(final com.facebook.react.bridge.Callback callback) {
        getCookieManager().removeAllCookies(new ValueCallback<Boolean>() {
            public void onReceiveValue(Boolean bool) {
                ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
                callback.invoke(bool);
            }
        });
    }

    public void destroy() {
        if (USES_LEGACY_STORE) {
            getCookieManager().removeExpiredCookie();
            this.mCookieSaver.persistCookies();
        }
    }

    private void addCookies(final String str, final List<String> list) {
        if (USES_LEGACY_STORE) {
            runInBackground(new Runnable() {
                public void run() {
                    for (String cookie : list) {
                        ForwardingCookieHandler.this.getCookieManager().setCookie(str, cookie);
                    }
                    ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
                }
            });
            return;
        }
        for (String addCookieAsync : list) {
            addCookieAsync(str, addCookieAsync);
        }
        this.mCookieSaver.onCookiesModified();
    }

    @TargetApi(21)
    private void addCookieAsync(String str, String str2) {
        getCookieManager().setCookie(str, str2, null);
    }

    private static boolean isCookieHeader(String str) {
        if (!str.equalsIgnoreCase(VERSION_ZERO_HEADER)) {
            if (str.equalsIgnoreCase(VERSION_ONE_HEADER) == null) {
                return null;
            }
        }
        return true;
    }

    private void runInBackground(final Runnable runnable) {
        new GuardedAsyncTask<Void, Void>(this.mContext) {
            protected void doInBackgroundGuarded(Void... voidArr) {
                runnable.run();
            }
        }.execute(new Void[null]);
    }

    private CookieManager getCookieManager() {
        if (this.mCookieManager == null) {
            possiblyWorkaroundSyncManager(this.mContext);
            this.mCookieManager = CookieManager.getInstance();
            if (USES_LEGACY_STORE) {
                this.mCookieManager.removeExpiredCookie();
            }
        }
        return this.mCookieManager;
    }

    private static void possiblyWorkaroundSyncManager(Context context) {
        if (USES_LEGACY_STORE) {
            CookieSyncManager.createInstance(context).sync();
        }
    }
}
