package com.google.android.gms.internal.ads;

import android.support.v4.util.C0463l;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

@cm
public final class bt implements bh<aty> {
    /* renamed from: a */
    private final boolean f24000a;

    public bt(boolean z) {
        this.f24000a = z;
    }

    /* renamed from: a */
    public final /* synthetic */ aui mo4219a(ay ayVar, JSONObject jSONObject) {
        C0463l c0463l = new C0463l();
        C0463l c0463l2 = new C0463l();
        Future a = ayVar.m19121a(jSONObject);
        no a2 = ayVar.m19122a(jSONObject, "video");
        JSONArray jSONArray = jSONObject.getJSONArray("custom_assets");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("type");
            if ("string".equals(string)) {
                c0463l2.put(jSONObject2.getString("name"), jSONObject2.getString("string_value"));
            } else if (MessengerShareContentUtility.MEDIA_IMAGE.equals(string)) {
                c0463l.put(jSONObject2.getString("name"), ayVar.m19125a(jSONObject2, "image_value", this.f24000a));
            } else {
                String str = "Unknown custom asset type: ";
                string = String.valueOf(string);
                mt.m19924e(string.length() != 0 ? str.concat(string) : new String(str));
            }
        }
        qo a3 = ay.m19112a(a2);
        String string2 = jSONObject.getString("custom_template_id");
        C0463l c0463l3 = new C0463l();
        for (int i2 = 0; i2 < c0463l.size(); i2++) {
            c0463l3.put(c0463l.b(i2), ((Future) c0463l.c(i2)).get());
        }
        return new aty(string2, c0463l3, c0463l2, (atp) a.get(), a3 != null ? a3.mo6127b() : null, a3 != null ? a3.getView() : null);
    }
}
