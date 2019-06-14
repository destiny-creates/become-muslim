package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;

public final class ShareLinkContent extends ShareContent<ShareLinkContent, Builder> {
    public static final Creator<ShareLinkContent> CREATOR = new C20261();
    @Deprecated
    private final String contentDescription;
    @Deprecated
    private final String contentTitle;
    @Deprecated
    private final Uri imageUrl;
    private final String quote;

    /* renamed from: com.facebook.share.model.ShareLinkContent$1 */
    static class C20261 implements Creator<ShareLinkContent> {
        C20261() {
        }

        public ShareLinkContent createFromParcel(Parcel parcel) {
            return new ShareLinkContent(parcel);
        }

        public ShareLinkContent[] newArray(int i) {
            return new ShareLinkContent[i];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareLinkContent, Builder> {
        static final String TAG = "ShareLinkContent$Builder";
        @Deprecated
        private String contentDescription;
        @Deprecated
        private String contentTitle;
        @Deprecated
        private Uri imageUrl;
        private String quote;

        @Deprecated
        public Builder setContentDescription(String str) {
            Log.w(TAG, "This method does nothing. ContentDescription is deprecated in Graph API 2.9.");
            return this;
        }

        @Deprecated
        public Builder setContentTitle(String str) {
            Log.w(TAG, "This method does nothing. ContentTitle is deprecated in Graph API 2.9.");
            return this;
        }

        @Deprecated
        public Builder setImageUrl(Uri uri) {
            Log.w(TAG, "This method does nothing. ImageUrl is deprecated in Graph API 2.9.");
            return this;
        }

        public Builder setQuote(String str) {
            this.quote = str;
            return this;
        }

        public ShareLinkContent build() {
            return new ShareLinkContent();
        }

        public Builder readFrom(ShareLinkContent shareLinkContent) {
            if (shareLinkContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareLinkContent)).setContentDescription(shareLinkContent.getContentDescription()).setImageUrl(shareLinkContent.getImageUrl()).setContentTitle(shareLinkContent.getContentTitle()).setQuote(shareLinkContent.getQuote());
        }
    }

    public int describeContents() {
        return 0;
    }

    private ShareLinkContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.imageUrl = builder.imageUrl;
        this.quote = builder.quote;
    }

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.quote = parcel.readString();
    }

    @Deprecated
    public String getContentDescription() {
        return this.contentDescription;
    }

    @Deprecated
    public String getContentTitle() {
        return this.contentTitle;
    }

    @Deprecated
    public Uri getImageUrl() {
        return this.imageUrl;
    }

    public String getQuote() {
        return this.quote;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.imageUrl, 0);
        parcel.writeString(this.quote);
    }
}
