package host.exp.exponent.p346j;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.v7.widget.LinearLayoutManager;
import com.facebook.internal.Utility;
import com.facebook.react.uimanager.ViewProps;
import host.exp.exponent.C6369g;
import host.exp.exponent.C6369g.C6359a;
import host.exp.exponent.p334a.C6289b;
import org.json.JSONObject;

/* compiled from: ExperienceActivityUtils */
/* renamed from: host.exp.exponent.j.d */
public class C6386d {
    /* renamed from: a */
    private static final String f20674a = "d";

    /* renamed from: a */
    public static void m26200a(JSONObject jSONObject, Activity activity) {
        if (jSONObject != null) {
            jSONObject = jSONObject.optString("orientation", null);
            if (jSONObject == null) {
                activity.setRequestedOrientation(-1);
                return;
            }
            int hashCode = jSONObject.hashCode();
            if (hashCode != 729267099) {
                if (hashCode != 1430647483) {
                    if (hashCode == 1544803905) {
                        if (jSONObject.equals("default") != null) {
                            jSONObject = null;
                            switch (jSONObject) {
                                case null:
                                    activity.setRequestedOrientation(-1);
                                    break;
                                case 1:
                                    activity.setRequestedOrientation(1);
                                    break;
                                case 2:
                                    activity.setRequestedOrientation(0);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                } else if (jSONObject.equals("landscape") != null) {
                    jSONObject = 2;
                    switch (jSONObject) {
                        case null:
                            activity.setRequestedOrientation(-1);
                            break;
                        case 1:
                            activity.setRequestedOrientation(1);
                            break;
                        case 2:
                            activity.setRequestedOrientation(0);
                            break;
                        default:
                            break;
                    }
                }
            } else if (jSONObject.equals("portrait") != null) {
                jSONObject = true;
                switch (jSONObject) {
                    case null:
                        activity.setRequestedOrientation(-1);
                        break;
                    case 1:
                        activity.setRequestedOrientation(1);
                        break;
                    case 2:
                        activity.setRequestedOrientation(0);
                        break;
                    default:
                        break;
                }
            }
            jSONObject = -1;
            switch (jSONObject) {
                case null:
                    activity.setRequestedOrientation(-1);
                    break;
                case 1:
                    activity.setRequestedOrientation(1);
                    break;
                case 2:
                    activity.setRequestedOrientation(0);
                    break;
                default:
                    break;
            }
        }
    }

    /* renamed from: a */
    public static void m26199a(String str, JSONObject jSONObject, Activity activity) {
        str = jSONObject.optJSONObject("androidStatusBar");
        if (str != null) {
            jSONObject = str.optString(ViewProps.BACKGROUND_COLOR);
        } else {
            jSONObject = jSONObject.optString("androidStatusBarColor");
        }
        if (jSONObject != null && C6384b.m26192a(jSONObject)) {
            try {
                activity.getWindow().clearFlags(67108864);
                activity.getWindow().setStatusBarColor(Color.parseColor(jSONObject));
            } catch (Throwable th) {
                C6289b.m25950a(f20674a, th);
            }
        }
        if (str != null) {
            str = str.optString("barStyle");
            if (str != null && VERSION.SDK_INT >= 23) {
                try {
                    activity.getWindow().clearFlags(67108864);
                    activity.getWindow().addFlags(LinearLayoutManager.INVALID_OFFSET);
                    if (str.equals("dark-content") != null) {
                        activity.getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    }
                } catch (Throwable th2) {
                    C6289b.m25950a(f20674a, th2);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m26198a(C6369g c6369g, final JSONObject jSONObject, final Activity activity) {
        String optString = jSONObject.optString("iconUrl");
        final int a = c6369g.m26136a(jSONObject);
        c6369g.m26140a(optString, new C6359a() {
            /* renamed from: a */
            public void mo5380a(Bitmap bitmap) {
                try {
                    activity.setTaskDescription(new TaskDescription(jSONObject.optString("name"), bitmap, a));
                } catch (Throwable th) {
                    C6289b.m25950a(C6386d.f20674a, th);
                }
            }
        });
    }
}
