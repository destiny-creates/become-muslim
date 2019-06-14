package com.facebook;

import android.os.Bundle;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.Locale;
import org.json.JSONObject;

public class ShareGraphRequest {

    /* renamed from: com.facebook.ShareGraphRequest$1 */
    static class C35201 implements PhotoJSONProcessor {
        C35201() {
        }

        public JSONObject toJSONObject(SharePhoto sharePhoto) {
            sharePhoto = sharePhoto.getImageUrl();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", sharePhoto.toString());
                return jSONObject;
            } catch (Throwable e) {
                throw new FacebookException("Unable to attach images", e);
            }
        }
    }

    public static GraphRequest createOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject) {
        String string = shareOpenGraphObject.getString("type");
        if (string == null) {
            string = shareOpenGraphObject.getString("og:type");
        }
        if (string != null) {
            try {
                JSONObject jSONObject = (JSONObject) OpenGraphJSONUtility.toJSONValue(shareOpenGraphObject, new C35201());
                Bundle bundle = new Bundle();
                bundle.putString("object", jSONObject.toString());
                Object[] objArr = new Object[2];
                objArr[0] = "me";
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("objects/");
                stringBuilder.append(string);
                objArr[1] = stringBuilder.toString();
                return new GraphRequest(AccessToken.getCurrentAccessToken(), String.format(Locale.ROOT, "%s/%s", objArr), bundle, HttpMethod.POST);
            } catch (ShareOpenGraphObject shareOpenGraphObject2) {
                throw new FacebookException(shareOpenGraphObject2.getMessage());
            }
        }
        throw new FacebookException("Open graph object type cannot be null");
    }
}
