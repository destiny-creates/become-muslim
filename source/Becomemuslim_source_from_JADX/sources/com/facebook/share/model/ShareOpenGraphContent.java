package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Builder> {
    public static final Creator<ShareOpenGraphContent> CREATOR = new C20341();
    private final ShareOpenGraphAction action;
    private final String previewPropertyName;

    /* renamed from: com.facebook.share.model.ShareOpenGraphContent$1 */
    static class C20341 implements Creator<ShareOpenGraphContent> {
        C20341() {
        }

        public ShareOpenGraphContent createFromParcel(Parcel parcel) {
            return new ShareOpenGraphContent(parcel);
        }

        public ShareOpenGraphContent[] newArray(int i) {
            return new ShareOpenGraphContent[i];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareOpenGraphContent, Builder> {
        private ShareOpenGraphAction action;
        private String previewPropertyName;

        public Builder setAction(ShareOpenGraphAction shareOpenGraphAction) {
            if (shareOpenGraphAction == null) {
                shareOpenGraphAction = null;
            } else {
                shareOpenGraphAction = new com.facebook.share.model.ShareOpenGraphAction.Builder().readFrom(shareOpenGraphAction).build();
            }
            this.action = shareOpenGraphAction;
            return this;
        }

        public Builder setPreviewPropertyName(String str) {
            this.previewPropertyName = str;
            return this;
        }

        public ShareOpenGraphContent build() {
            return new ShareOpenGraphContent();
        }

        public Builder readFrom(ShareOpenGraphContent shareOpenGraphContent) {
            if (shareOpenGraphContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareOpenGraphContent)).setAction(shareOpenGraphContent.getAction()).setPreviewPropertyName(shareOpenGraphContent.getPreviewPropertyName());
        }
    }

    public int describeContents() {
        return 0;
    }

    private ShareOpenGraphContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        this.action = builder.action;
        this.previewPropertyName = builder.previewPropertyName;
    }

    ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        this.action = new com.facebook.share.model.ShareOpenGraphAction.Builder().readFrom(parcel).build();
        this.previewPropertyName = parcel.readString();
    }

    public ShareOpenGraphAction getAction() {
        return this.action;
    }

    public String getPreviewPropertyName() {
        return this.previewPropertyName;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.action, 0);
        parcel.writeString(this.previewPropertyName);
    }
}
