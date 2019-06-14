package com.facebook.ads.internal.protocol;

import android.content.Context;
import android.text.TextUtils;
import com.amplitude.api.AmplitudeClient;
import com.facebook.ads.internal.p105q.p109d.C1540a;
import com.facebook.ads.internal.p105q.p109d.C1541b;
import com.facebook.share.internal.MessengerShareContentUtility;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.protocol.h */
public final class C1491h {
    /* renamed from: a */
    private final C1490a f4406a;
    /* renamed from: b */
    private final Long f4407b;
    /* renamed from: c */
    private final String f4408c;
    /* renamed from: d */
    private final String f4409d;

    /* renamed from: com.facebook.ads.internal.protocol.h$a */
    private enum C1490a {
        ID,
        CREATIVE,
        NONE
    }

    public C1491h(Context context, String str, String str2, C1487f c1487f) {
        if (TextUtils.isEmpty(str)) {
            this.f4406a = C1490a.NONE;
            this.f4407b = null;
            this.f4409d = null;
            this.f4408c = null;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            switch (C1490a.valueOf(jSONObject.getString("type").toUpperCase())) {
                case ID:
                    this.f4406a = C1490a.ID;
                    this.f4407b = Long.valueOf(jSONObject.getString("bid_id"));
                    this.f4409d = jSONObject.getString(AmplitudeClient.DEVICE_ID_KEY);
                    this.f4408c = null;
                    break;
                case CREATIVE:
                    this.f4406a = C1490a.CREATIVE;
                    this.f4407b = Long.valueOf(jSONObject.getString("bid_id"));
                    this.f4409d = jSONObject.getString(AmplitudeClient.DEVICE_ID_KEY);
                    this.f4408c = new JSONObject(jSONObject.getString(MessengerShareContentUtility.ATTACHMENT_PAYLOAD)).toString();
                    break;
                default:
                    AdErrorType adErrorType = AdErrorType.BID_PAYLOAD_ERROR;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported BidPayload type ");
                    stringBuilder.append(jSONObject.getString("type"));
                    throw new C1482b(adErrorType, stringBuilder.toString());
            }
            if (!jSONObject.getString("sdk_version").equals("4.99.0")) {
                throw new C1482b(AdErrorType.BID_IMPRESSION_MISMATCH, String.format("Bid %d for SDK version %s being used on SDK version %s", new Object[]{this.f4407b, jSONObject.getString("sdk_version"), "4.99.0"}));
            } else if (!jSONObject.getString("resolved_placement_id").equals(str2)) {
                throw new C1482b(AdErrorType.BID_IMPRESSION_MISMATCH, String.format("Bid %d for placement %s being used on placement %s", new Object[]{this.f4407b, jSONObject.getString("resolved_placement_id"), str2}));
            } else if (jSONObject.getInt("template") != c1487f.m5253a()) {
                throw new C1482b(AdErrorType.BID_IMPRESSION_MISMATCH, String.format("Bid %d for template %s being used on template %s", new Object[]{this.f4407b, Integer.valueOf(jSONObject.getInt("template")), c1487f}));
            }
        } catch (Exception e) {
            C1540a.m5396a(context, "api", C1541b.f4559d, e);
            throw new C1482b(AdErrorType.BID_PAYLOAD_ERROR, "Invalid BidPayload", e);
        }
    }

    /* renamed from: a */
    public void m5257a(String str) {
        if (!this.f4409d.equals(str)) {
            throw new C1482b(AdErrorType.BID_IMPRESSION_MISMATCH, String.format("Bid %d for IDFA %s being used on IDFA %s", new Object[]{this.f4407b, this.f4409d, str}));
        }
    }

    /* renamed from: a */
    public boolean m5258a() {
        return this.f4406a == C1490a.CREATIVE;
    }

    /* renamed from: b */
    public String m5259b() {
        return this.f4408c;
    }

    /* renamed from: c */
    public boolean m5260c() {
        return this.f4406a != C1490a.NONE;
    }

    /* renamed from: d */
    public String m5261d() {
        return this.f4407b == null ? null : this.f4407b.toString();
    }
}
