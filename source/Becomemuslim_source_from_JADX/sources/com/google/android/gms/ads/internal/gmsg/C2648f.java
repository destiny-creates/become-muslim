package com.google.android.gms.ads.internal.gmsg;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.View;
import com.facebook.common.util.UriUtil;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.ahi;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.jw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.ads.internal.gmsg.f */
public final class C2648f {
    /* renamed from: a */
    private final Context f6874a;
    /* renamed from: b */
    private final ahi f6875b;
    /* renamed from: c */
    private final View f6876c;

    public C2648f(Context context, ahi ahi, View view) {
        this.f6874a = context;
        this.f6875b = ahi;
        this.f6876c = view;
    }

    /* renamed from: a */
    private static Intent m7526a(Intent intent, ResolveInfo resolveInfo) {
        Intent intent2 = new Intent(intent);
        intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        return intent2;
    }

    /* renamed from: a */
    private static Intent m7527a(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    /* renamed from: a */
    private final ResolveInfo m7528a(Intent intent) {
        return m7529a(intent, new ArrayList());
    }

    /* renamed from: a */
    private final ResolveInfo m7529a(Intent intent, ArrayList<ResolveInfo> arrayList) {
        ResolveInfo resolveInfo = null;
        try {
            PackageManager packageManager = this.f6874a.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            Collection queryIntentActivities = packageManager.queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            if (queryIntentActivities != null && resolveActivity != null) {
                for (int i = 0; i < queryIntentActivities.size(); i++) {
                    ResolveInfo resolveInfo2 = (ResolveInfo) queryIntentActivities.get(i);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                }
            }
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        } catch (Throwable th) {
            ax.m7468i().a(th, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
        }
    }

    /* renamed from: a */
    public final Intent m7530a(Map<String, String> map) {
        ActivityManager activityManager = (ActivityManager) this.f6874a.getSystemService("activity");
        String str = (String) map.get("u");
        Uri uri = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object obj;
        Builder buildUpon;
        String str2;
        ArrayList arrayList;
        Intent a;
        Intent a2;
        ResolveInfo a3;
        Intent a4;
        List<RunningAppProcessInfo> runningAppProcesses;
        ArrayList arrayList2;
        int size;
        int i;
        Object obj2;
        ResolveInfo resolveInfo;
        Uri parse = Uri.parse(C4270e.m13904a(this.f6874a, this.f6875b, str, this.f6876c, null));
        boolean parseBoolean = Boolean.parseBoolean((String) map.get("use_first_package"));
        boolean parseBoolean2 = Boolean.parseBoolean((String) map.get("use_running_process"));
        if (!Boolean.parseBoolean((String) map.get("use_custom_tabs"))) {
            if (!((Boolean) aph.f().a(asp.cM)).booleanValue()) {
                obj = null;
                if (UriUtil.HTTP_SCHEME.equalsIgnoreCase(parse.getScheme())) {
                    if (UriUtil.HTTPS_SCHEME.equalsIgnoreCase(parse.getScheme())) {
                        buildUpon = parse.buildUpon();
                        str2 = UriUtil.HTTP_SCHEME;
                    }
                    arrayList = new ArrayList();
                    a = C2648f.m7527a(parse);
                    a2 = C2648f.m7527a(uri);
                    if (obj != null) {
                        ax.m7464e();
                        jw.b(this.f6874a, a);
                        ax.m7464e();
                        jw.b(this.f6874a, a2);
                    }
                    a3 = m7529a(a, arrayList);
                    if (a3 == null) {
                        return C2648f.m7526a(a, a3);
                    }
                    if (a2 != null) {
                        a3 = m7528a(a2);
                        if (a3 != null) {
                            a4 = C2648f.m7526a(a, a3);
                            if (m7528a(a4) != null) {
                                return a4;
                            }
                        }
                    }
                    if (arrayList.size() != 0) {
                        return a;
                    }
                    if (parseBoolean2 && activityManager != null) {
                        runningAppProcesses = activityManager.getRunningAppProcesses();
                        if (runningAppProcesses != null) {
                            arrayList2 = arrayList;
                            size = arrayList2.size();
                            i = 0;
                            while (i < size) {
                                obj2 = arrayList2.get(i);
                                i++;
                                resolveInfo = (ResolveInfo) obj2;
                                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                                    if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                                        return C2648f.m7526a(a, resolveInfo);
                                    }
                                }
                            }
                        }
                    }
                    return parseBoolean ? C2648f.m7526a(a, (ResolveInfo) arrayList.get(0)) : a;
                } else {
                    buildUpon = parse.buildUpon();
                    str2 = UriUtil.HTTPS_SCHEME;
                }
                uri = buildUpon.scheme(str2).build();
                arrayList = new ArrayList();
                a = C2648f.m7527a(parse);
                a2 = C2648f.m7527a(uri);
                if (obj != null) {
                    ax.m7464e();
                    jw.b(this.f6874a, a);
                    ax.m7464e();
                    jw.b(this.f6874a, a2);
                }
                a3 = m7529a(a, arrayList);
                if (a3 == null) {
                    return C2648f.m7526a(a, a3);
                }
                if (a2 != null) {
                    a3 = m7528a(a2);
                    if (a3 != null) {
                        a4 = C2648f.m7526a(a, a3);
                        if (m7528a(a4) != null) {
                            return a4;
                        }
                    }
                }
                if (arrayList.size() != 0) {
                    return a;
                }
                runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    arrayList2 = arrayList;
                    size = arrayList2.size();
                    i = 0;
                    while (i < size) {
                        obj2 = arrayList2.get(i);
                        i++;
                        resolveInfo = (ResolveInfo) obj2;
                        while (r8.hasNext()) {
                            if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                                return C2648f.m7526a(a, resolveInfo);
                            }
                        }
                    }
                }
                if (parseBoolean) {
                }
            }
        }
        obj = 1;
        if (UriUtil.HTTP_SCHEME.equalsIgnoreCase(parse.getScheme())) {
            if (UriUtil.HTTPS_SCHEME.equalsIgnoreCase(parse.getScheme())) {
                buildUpon = parse.buildUpon();
                str2 = UriUtil.HTTP_SCHEME;
            }
            arrayList = new ArrayList();
            a = C2648f.m7527a(parse);
            a2 = C2648f.m7527a(uri);
            if (obj != null) {
                ax.m7464e();
                jw.b(this.f6874a, a);
                ax.m7464e();
                jw.b(this.f6874a, a2);
            }
            a3 = m7529a(a, arrayList);
            if (a3 == null) {
                return C2648f.m7526a(a, a3);
            }
            if (a2 != null) {
                a3 = m7528a(a2);
                if (a3 != null) {
                    a4 = C2648f.m7526a(a, a3);
                    if (m7528a(a4) != null) {
                        return a4;
                    }
                }
            }
            if (arrayList.size() != 0) {
                return a;
            }
            runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                arrayList2 = arrayList;
                size = arrayList2.size();
                i = 0;
                while (i < size) {
                    obj2 = arrayList2.get(i);
                    i++;
                    resolveInfo = (ResolveInfo) obj2;
                    while (r8.hasNext()) {
                        if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                            return C2648f.m7526a(a, resolveInfo);
                        }
                    }
                }
            }
            if (parseBoolean) {
            }
        }
        buildUpon = parse.buildUpon();
        str2 = UriUtil.HTTPS_SCHEME;
        uri = buildUpon.scheme(str2).build();
        arrayList = new ArrayList();
        a = C2648f.m7527a(parse);
        a2 = C2648f.m7527a(uri);
        if (obj != null) {
            ax.m7464e();
            jw.b(this.f6874a, a);
            ax.m7464e();
            jw.b(this.f6874a, a2);
        }
        a3 = m7529a(a, arrayList);
        if (a3 == null) {
            return C2648f.m7526a(a, a3);
        }
        if (a2 != null) {
            a3 = m7528a(a2);
            if (a3 != null) {
                a4 = C2648f.m7526a(a, a3);
                if (m7528a(a4) != null) {
                    return a4;
                }
            }
        }
        if (arrayList.size() != 0) {
            return a;
        }
        runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            arrayList2 = arrayList;
            size = arrayList2.size();
            i = 0;
            while (i < size) {
                obj2 = arrayList2.get(i);
                i++;
                resolveInfo = (ResolveInfo) obj2;
                while (r8.hasNext()) {
                    if (runningAppProcessInfo.processName.equals(resolveInfo.activityInfo.packageName)) {
                        return C2648f.m7526a(a, resolveInfo);
                    }
                }
            }
        }
        if (parseBoolean) {
        }
    }
}
