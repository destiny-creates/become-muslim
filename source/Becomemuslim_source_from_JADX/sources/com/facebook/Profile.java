package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.internal.Validate;
import org.json.JSONObject;

public final class Profile implements Parcelable {
    public static final Creator<Profile> CREATOR = new C12692();
    private static final String FIRST_NAME_KEY = "first_name";
    private static final String ID_KEY = "id";
    private static final String LAST_NAME_KEY = "last_name";
    private static final String LINK_URI_KEY = "link_uri";
    private static final String MIDDLE_NAME_KEY = "middle_name";
    private static final String NAME_KEY = "name";
    private static final String TAG = "Profile";
    private final String firstName;
    private final String id;
    private final String lastName;
    private final Uri linkUri;
    private final String middleName;
    private final String name;

    /* renamed from: com.facebook.Profile$2 */
    static class C12692 implements Creator<Profile> {
        C12692() {
        }

        public Profile createFromParcel(Parcel parcel) {
            return new Profile(parcel);
        }

        public Profile[] newArray(int i) {
            return new Profile[i];
        }
    }

    /* renamed from: com.facebook.Profile$1 */
    static class C35191 implements GraphMeRequestWithCacheCallback {
        C35191() {
        }

        public void onSuccess(JSONObject jSONObject) {
            String optString = jSONObject.optString("id");
            if (optString != null) {
                String optString2 = jSONObject.optString("link");
                Profile.setCurrentProfile(new Profile(optString, jSONObject.optString(Profile.FIRST_NAME_KEY), jSONObject.optString(Profile.MIDDLE_NAME_KEY), jSONObject.optString(Profile.LAST_NAME_KEY), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
            }
        }

        public void onFailure(FacebookException facebookException) {
            String access$000 = Profile.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Got unexpected exception: ");
            stringBuilder.append(facebookException);
            Log.e(access$000, stringBuilder.toString());
        }
    }

    public int describeContents() {
        return 0;
    }

    public static Profile getCurrentProfile() {
        return ProfileManager.getInstance().getCurrentProfile();
    }

    public static void setCurrentProfile(Profile profile) {
        ProfileManager.getInstance().setCurrentProfile(profile);
    }

    public static void fetchProfileForCurrentAccessToken() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (AccessToken.isCurrentAccessTokenActive()) {
            Utility.getGraphMeRequestWithCacheAsync(currentAccessToken.getToken(), new C35191());
        } else {
            setCurrentProfile(null);
        }
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri) {
        Validate.notNullOrEmpty(str, "id");
        this.id = str;
        this.firstName = str2;
        this.middleName = str3;
        this.lastName = str4;
        this.name = str5;
        this.linkUri = uri;
    }

    public Uri getProfilePictureUri(int i, int i2) {
        return ImageRequest.getProfilePictureUri(this.id, i, i2);
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.name;
    }

    public Uri getLinkUri() {
        return this.linkUri;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        if (this.id.equals(profile.id) && this.firstName == null) {
            if (profile.firstName == null) {
                return z;
            }
        } else if (this.firstName.equals(profile.firstName) && this.middleName == null) {
            if (profile.middleName == null) {
                return z;
            }
        } else if (this.middleName.equals(profile.middleName) && this.lastName == null) {
            if (profile.lastName == null) {
                return z;
            }
        } else if (this.lastName.equals(profile.lastName) && this.name == null) {
            if (profile.name == null) {
                return z;
            }
        } else if (!this.name.equals(profile.name) || this.linkUri != null) {
            z = this.linkUri.equals(profile.linkUri);
            return z;
        } else if (profile.linkUri == null) {
            return z;
        }
        z = false;
        return z;
    }

    public int hashCode() {
        int hashCode = 527 + this.id.hashCode();
        if (this.firstName != null) {
            hashCode = (hashCode * 31) + this.firstName.hashCode();
        }
        if (this.middleName != null) {
            hashCode = (hashCode * 31) + this.middleName.hashCode();
        }
        if (this.lastName != null) {
            hashCode = (hashCode * 31) + this.lastName.hashCode();
        }
        if (this.name != null) {
            hashCode = (hashCode * 31) + this.name.hashCode();
        }
        return this.linkUri != null ? (hashCode * 31) + this.linkUri.hashCode() : hashCode;
    }

    org.json.JSONObject toJSONObject() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "id";	 Catch:{ JSONException -> 0x0038 }
        r2 = r3.id;	 Catch:{ JSONException -> 0x0038 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0038 }
        r1 = "first_name";	 Catch:{ JSONException -> 0x0038 }
        r2 = r3.firstName;	 Catch:{ JSONException -> 0x0038 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0038 }
        r1 = "middle_name";	 Catch:{ JSONException -> 0x0038 }
        r2 = r3.middleName;	 Catch:{ JSONException -> 0x0038 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0038 }
        r1 = "last_name";	 Catch:{ JSONException -> 0x0038 }
        r2 = r3.lastName;	 Catch:{ JSONException -> 0x0038 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0038 }
        r1 = "name";	 Catch:{ JSONException -> 0x0038 }
        r2 = r3.name;	 Catch:{ JSONException -> 0x0038 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0038 }
        r1 = r3.linkUri;	 Catch:{ JSONException -> 0x0038 }
        if (r1 == 0) goto L_0x0039;	 Catch:{ JSONException -> 0x0038 }
    L_0x002c:
        r1 = "link_uri";	 Catch:{ JSONException -> 0x0038 }
        r2 = r3.linkUri;	 Catch:{ JSONException -> 0x0038 }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x0038 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0038 }
        goto L_0x0039;
    L_0x0038:
        r0 = 0;
    L_0x0039:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.Profile.toJSONObject():org.json.JSONObject");
    }

    Profile(JSONObject jSONObject) {
        Uri uri = null;
        this.id = jSONObject.optString("id", null);
        this.firstName = jSONObject.optString(FIRST_NAME_KEY, null);
        this.middleName = jSONObject.optString(MIDDLE_NAME_KEY, null);
        this.lastName = jSONObject.optString(LAST_NAME_KEY, null);
        this.name = jSONObject.optString("name", null);
        jSONObject = jSONObject.optString(LINK_URI_KEY, null);
        if (jSONObject != null) {
            uri = Uri.parse(jSONObject);
        }
        this.linkUri = uri;
    }

    private Profile(Parcel parcel) {
        this.id = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.name = parcel.readString();
        parcel = parcel.readString();
        if (parcel == null) {
            parcel = null;
        } else {
            parcel = Uri.parse(parcel);
        }
        this.linkUri = parcel;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.firstName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.name);
        parcel.writeString(this.linkUri == 0 ? 0 : this.linkUri.toString());
    }
}
