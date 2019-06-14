package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.C2696n;
import com.google.android.gms.ads.mediation.C2695m;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.Iterator;
import org.json.JSONObject;

public final class bet extends beo {
    /* renamed from: a */
    private final tb f28497a;

    public bet(tb tbVar) {
        this.f28497a = tbVar;
    }

    /* renamed from: a */
    private static Bundle m37431a(String str) {
        String str2 = "Server parameters: ";
        String valueOf = String.valueOf(str);
        mt.m19924e(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                bundle2.putString(str3, jSONObject.getString(str3));
            }
            return bundle2;
        } catch (Throwable e) {
            mt.m19919b("", e);
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final bex mo4209a() {
        return bex.m37439a(this.f28497a.m20113b());
    }

    /* renamed from: a */
    public final void mo4210a(C2758b c2758b, String str, Bundle bundle, beq beq) {
        try {
            int i;
            Object bew = new bew(this, beq);
            tb tbVar = this.f28497a;
            Context context = (Context) C4757d.a(c2758b);
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != -1396342996) {
                if (hashCode != -1052618729) {
                    if (hashCode != -239580146) {
                        if (hashCode == 604727084) {
                            if (str.equals("interstitial")) {
                                obj = 1;
                            }
                        }
                    } else if (str.equals("rewarded")) {
                        obj = 2;
                    }
                } else if (str.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
                    obj = 3;
                }
            } else if (str.equals("banner")) {
                obj = null;
            }
            switch (obj) {
                case null:
                    i = tc.f16029a;
                    break;
                case 1:
                    i = tc.f16030b;
                    break;
                case 2:
                    i = tc.f16031c;
                    break;
                case 3:
                    i = tc.f16032d;
                    break;
                default:
                    throw new IllegalArgumentException("Internal Error");
            }
            tbVar.m20112a(new td(context, i, bundle), bew);
        } catch (Throwable th) {
            mt.m19919b("Error generating signals for RTB", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo4211a(byte[] bArr, String str, Bundle bundle, C2758b c2758b, bej bej, bde bde, aou aou) {
        try {
            sy beu = new beu(this, bej, bde);
            tb tbVar = this.f28497a;
            ta taVar = new ta((Context) C4757d.a(c2758b), bArr, m37431a(str), bundle);
            C2696n.a(aou.f28283e, aou.f28280b, aou.f28279a);
            beu.mo4216a(String.valueOf(tbVar.getClass().getSimpleName()).concat(" does not support banner."));
        } catch (Throwable th) {
            mt.m19919b("Adapter failed to render banner ad.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo4212a(byte[] bArr, String str, Bundle bundle, C2758b c2758b, bel bel, bde bde) {
        try {
            sy bev = new bev(this, bel, bde);
            tb tbVar = this.f28497a;
            ta taVar = new ta((Context) C4757d.a(c2758b), bArr, m37431a(str), bundle);
            bev.mo4216a(String.valueOf(tbVar.getClass().getSimpleName()).concat(" does not support interstitial."));
        } catch (Throwable th) {
            mt.m19919b("Adapter failed to render interstitial ad.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    /* renamed from: b */
    public final bex mo4213b() {
        return bex.m37439a(this.f28497a.m20111a());
    }

    /* renamed from: c */
    public final aqv mo4214c() {
        if (!(this.f28497a instanceof C2695m)) {
            return null;
        }
        try {
            return ((C2695m) this.f28497a).getVideoController();
        } catch (Throwable th) {
            mt.m19919b("", th);
            return null;
        }
    }

    /* renamed from: d */
    public final void mo4215d() {
        sz szVar = null;
        try {
            szVar.m20110a();
        } catch (Throwable th) {
            mt.m19919b("", th);
            RemoteException remoteException = new RemoteException();
        }
    }
}
