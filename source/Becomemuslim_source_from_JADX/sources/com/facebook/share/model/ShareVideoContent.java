package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareVideoContent extends ShareContent<ShareVideoContent, Builder> implements ShareModel {
    public static final Creator<ShareVideoContent> CREATOR = new C20401();
    private final String contentDescription;
    private final String contentTitle;
    private final SharePhoto previewPhoto;
    private final ShareVideo video;

    /* renamed from: com.facebook.share.model.ShareVideoContent$1 */
    static class C20401 implements Creator<ShareVideoContent> {
        C20401() {
        }

        public ShareVideoContent createFromParcel(Parcel parcel) {
            return new ShareVideoContent(parcel);
        }

        public ShareVideoContent[] newArray(int i) {
            return new ShareVideoContent[i];
        }
    }

    public static final class Builder extends com.facebook.share.model.ShareContent.Builder<ShareVideoContent, Builder> {
        private String contentDescription;
        private String contentTitle;
        private SharePhoto previewPhoto;
        private ShareVideo video;

        public Builder setContentDescription(String str) {
            this.contentDescription = str;
            return this;
        }

        public Builder setContentTitle(String str) {
            this.contentTitle = str;
            return this;
        }

        public Builder setPreviewPhoto(SharePhoto sharePhoto) {
            if (sharePhoto == null) {
                sharePhoto = null;
            } else {
                sharePhoto = new com.facebook.share.model.SharePhoto.Builder().readFrom(sharePhoto).build();
            }
            this.previewPhoto = sharePhoto;
            return this;
        }

        public Builder setVideo(ShareVideo shareVideo) {
            if (shareVideo == null) {
                return this;
            }
            this.video = new com.facebook.share.model.ShareVideo.Builder().readFrom(shareVideo).build();
            return this;
        }

        public ShareVideoContent build() {
            return new ShareVideoContent();
        }

        public Builder readFrom(ShareVideoContent shareVideoContent) {
            if (shareVideoContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareVideoContent)).setContentDescription(shareVideoContent.getContentDescription()).setContentTitle(shareVideoContent.getContentTitle()).setPreviewPhoto(shareVideoContent.getPreviewPhoto()).setVideo(shareVideoContent.getVideo());
        }
    }

    public int describeContents() {
        return 0;
    }

    private ShareVideoContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.previewPhoto = builder.previewPhoto;
        this.video = builder.video;
    }

    ShareVideoContent(Parcel parcel) {
        super(parcel);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        com.facebook.share.model.SharePhoto.Builder readFrom = new com.facebook.share.model.SharePhoto.Builder().readFrom(parcel);
        if (readFrom.getImageUrl() == null) {
            if (readFrom.getBitmap() == null) {
                this.previewPhoto = null;
                this.video = new com.facebook.share.model.ShareVideo.Builder().readFrom(parcel).build();
            }
        }
        this.previewPhoto = readFrom.build();
        this.video = new com.facebook.share.model.ShareVideo.Builder().readFrom(parcel).build();
    }

    public String getContentDescription() {
        return this.contentDescription;
    }

    public String getContentTitle() {
        return this.contentTitle;
    }

    public SharePhoto getPreviewPhoto() {
        return this.previewPhoto;
    }

    public ShareVideo getVideo() {
        return this.video;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.previewPhoto, 0);
        parcel.writeParcelable(this.video, 0);
    }
}
