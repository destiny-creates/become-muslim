package host.exp.exponent.p346j;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.support.v4.content.C0366b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.p340a.C6328c;
import host.exp.p333a.C6271b;
import host.exp.p333a.C6271b.C6269d;
import host.exp.p333a.C6279c.C6277f;
import java.util.ArrayList;
import java.util.List;
import javax.inject.C6562a;

/* compiled from: PermissionsHelper */
/* renamed from: host.exp.exponent.j.h */
public class C6391h {
    @C6562a
    /* renamed from: a */
    C6328c f20679a;
    /* renamed from: b */
    private C6269d f20680b;
    /* renamed from: c */
    private C6330b f20681c;
    /* renamed from: d */
    private String f20682d;
    /* renamed from: e */
    private boolean f20683e = true;
    /* renamed from: f */
    private List<String> f20684f = new ArrayList();
    /* renamed from: g */
    private List<String> f20685g = new ArrayList();
    /* renamed from: h */
    private int f20686h = 0;

    /* compiled from: PermissionsHelper */
    /* renamed from: host.exp.exponent.j.h$a */
    private class C6390a implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C6391h f20677a;
        /* renamed from: b */
        private String f20678b;

        C6390a(C6391h c6391h, String str) {
            this.f20677a = c6391h;
            this.f20678b = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f20677a.f20686h = this.f20677a.f20686h - 1;
            switch (i) {
                case -2:
                    this.f20677a.f20679a.m26040i().m34178b(this.f20678b, this.f20677a.f20681c);
                    this.f20677a.f20683e = 0;
                    break;
                case -1:
                    this.f20677a.f20679a.m26040i().m34176a(this.f20678b, this.f20677a.f20681c);
                    break;
                default:
                    break;
            }
            if (this.f20677a.f20686h > null) {
                this.f20677a.m26215b((String) this.f20677a.f20685g.get(this.f20677a.f20686h - 1));
            } else if (this.f20677a.f20684f.isEmpty() == null && VERSION.SDK_INT >= 23) {
                C6271b.m25897a().m25920b().requestPermissions((String[]) this.f20677a.f20684f.toArray(new String[this.f20677a.f20684f.size()]), 13);
            } else if (this.f20677a.f20683e != null) {
                this.f20677a.f20680b.permissionsGranted();
            } else {
                this.f20677a.f20680b.permissionsDenied();
            }
        }
    }

    public C6391h(C6330b c6330b) {
        C6294a.m25957a().m25961b(C6391h.class, this);
        this.f20681c = c6330b;
    }

    /* renamed from: a */
    public boolean m26223a(String str) {
        return ((VERSION.SDK_INT < 23 || C0366b.b(C6271b.m25897a().m25920b(), str) == 0) && this.f20679a.m26040i().m34179c(str, this.f20681c) != null) ? true : null;
    }

    /* renamed from: a */
    public boolean m26222a(C6269d c6269d, String[] strArr, String str) {
        Context b = C6271b.m25897a().m25920b();
        if (b == null) {
            return false;
        }
        this.f20682d = str;
        str = new ArrayList();
        Object obj = 1;
        for (String str2 : strArr) {
            if (VERSION.SDK_INT < 23 || C0366b.b(b, str2) == 0) {
                if (!(this.f20681c == null || this.f20679a.m26040i().m34179c(str2, this.f20681c))) {
                    this.f20685g.add(str2);
                }
            } else {
                this.f20684f.add(str2);
                if (b.shouldShowRequestPermissionRationale(str2)) {
                    str.add(str2);
                }
            }
            obj = null;
        }
        if (obj != null) {
            c6269d.permissionsGranted();
            return true;
        }
        this.f20686h = this.f20685g.size();
        this.f20680b = c6269d;
        if (this.f20685g.isEmpty() == null) {
            m26215b((String) this.f20685g.get(this.f20686h - 1));
        } else if (this.f20684f.isEmpty() == null && VERSION.SDK_INT >= 23) {
            b.requestPermissions((String[]) this.f20684f.toArray(new String[this.f20684f.size()]), 13);
        }
        return true;
    }

    /* renamed from: a */
    public void m26221a(int i, String[] strArr, int[] iArr) {
        if (i == 13) {
            if (this.f20680b != 0) {
                Object obj = null;
                if (iArr.length > 0) {
                    for (i = 0; i < iArr.length; i++) {
                        if (iArr[i] != 0) {
                            break;
                        }
                        if (this.f20681c != null) {
                            this.f20679a.m26040i().m34176a(strArr[i], this.f20681c);
                        }
                    }
                    obj = 1;
                }
                if (obj == null || this.f20683e == 0) {
                    this.f20680b.permissionsDenied();
                } else {
                    this.f20680b.permissionsGranted();
                }
                this.f20680b = 0;
            }
        } else if (VERSION.SDK_INT > 23) {
            C6271b.m25897a().m25920b().onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* renamed from: b */
    private void m26215b(String str) {
        Context b = C6271b.m25897a().m25920b();
        Builder builder = new Builder(b);
        OnClickListener c6390a = new C6390a(this, str);
        builder.setMessage(b.getString(C6277f.experience_needs_permissions, new Object[]{this.f20682d, b.getString(m26216c(str))})).setPositiveButton(C6277f.allow_experience_permissions, c6390a).setNegativeButton(C6277f.deny_experience_permissions, c6390a).show();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private int m26216c(java.lang.String r3) {
        /*
        r2 = this;
        r0 = r3.hashCode();
        r1 = -1;
        switch(r0) {
            case -1928411001: goto L_0x0066;
            case -1888586689: goto L_0x005b;
            case -406040016: goto L_0x0051;
            case -63024214: goto L_0x0046;
            case 463403621: goto L_0x003c;
            case 603653886: goto L_0x0032;
            case 1005993649: goto L_0x0028;
            case 1365911975: goto L_0x001e;
            case 1831139720: goto L_0x0014;
            case 1977429404: goto L_0x000a;
            default: goto L_0x0008;
        };
    L_0x0008:
        goto L_0x0070;
    L_0x000a:
        r0 = "android.permission.READ_CONTACTS";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0070;
    L_0x0012:
        r3 = 1;
        goto L_0x0071;
    L_0x0014:
        r0 = "android.permission.RECORD_AUDIO";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0070;
    L_0x001c:
        r3 = 4;
        goto L_0x0071;
    L_0x001e:
        r0 = "android.permission.WRITE_EXTERNAL_STORAGE";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0070;
    L_0x0026:
        r3 = 3;
        goto L_0x0071;
    L_0x0028:
        r0 = "android.settings.action.MANAGE_WRITE_SETTINGS";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0070;
    L_0x0030:
        r3 = 5;
        goto L_0x0071;
    L_0x0032:
        r0 = "android.permission.WRITE_CALENDAR";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0070;
    L_0x003a:
        r3 = 7;
        goto L_0x0071;
    L_0x003c:
        r0 = "android.permission.CAMERA";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0070;
    L_0x0044:
        r3 = 0;
        goto L_0x0071;
    L_0x0046:
        r0 = "android.permission.ACCESS_COARSE_LOCATION";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0070;
    L_0x004e:
        r3 = 9;
        goto L_0x0071;
    L_0x0051:
        r0 = "android.permission.READ_EXTERNAL_STORAGE";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0070;
    L_0x0059:
        r3 = 2;
        goto L_0x0071;
    L_0x005b:
        r0 = "android.permission.ACCESS_FINE_LOCATION";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0070;
    L_0x0063:
        r3 = 8;
        goto L_0x0071;
    L_0x0066:
        r0 = "android.permission.READ_CALENDAR";
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0070;
    L_0x006e:
        r3 = 6;
        goto L_0x0071;
    L_0x0070:
        r3 = -1;
    L_0x0071:
        switch(r3) {
            case 0: goto L_0x0090;
            case 1: goto L_0x008d;
            case 2: goto L_0x008a;
            case 3: goto L_0x0087;
            case 4: goto L_0x0084;
            case 5: goto L_0x0081;
            case 6: goto L_0x007e;
            case 7: goto L_0x007b;
            case 8: goto L_0x0078;
            case 9: goto L_0x0075;
            default: goto L_0x0074;
        };
    L_0x0074:
        return r1;
    L_0x0075:
        r3 = host.exp.p333a.C6279c.C6277f.perm_coarse_location;
        return r3;
    L_0x0078:
        r3 = host.exp.p333a.C6279c.C6277f.perm_fine_location;
        return r3;
    L_0x007b:
        r3 = host.exp.p333a.C6279c.C6277f.perm_calendar_write;
        return r3;
    L_0x007e:
        r3 = host.exp.p333a.C6279c.C6277f.perm_calendar_read;
        return r3;
    L_0x0081:
        r3 = host.exp.p333a.C6279c.C6277f.perm_system_brightness;
        return r3;
    L_0x0084:
        r3 = host.exp.p333a.C6279c.C6277f.perm_audio_recording;
        return r3;
    L_0x0087:
        r3 = host.exp.p333a.C6279c.C6277f.perm_camera_roll_write;
        return r3;
    L_0x008a:
        r3 = host.exp.p333a.C6279c.C6277f.perm_camera_roll_read;
        return r3;
    L_0x008d:
        r3 = host.exp.p333a.C6279c.C6277f.perm_contacts;
        return r3;
    L_0x0090:
        r3 = host.exp.p333a.C6279c.C6277f.perm_camera;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.j.h.c(java.lang.String):int");
    }
}
