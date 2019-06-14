package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class ShareMessengerGenericTemplateContent extends ShareContent<ShareMessengerGenericTemplateContent, Builder> {
    public static final Creator<ShareMessengerGenericTemplateContent> CREATOR = new C20281();
    private final ShareMessengerGenericTemplateElement genericTemplateElement;
    private final ImageAspectRatio imageAspectRatio;
    private final boolean isSharable;

    /* renamed from: com.facebook.share.model.ShareMessengerGenericTemplateContent$1 */
    static class C20281 implements Creator<ShareMessengerGenericTemplateContent> {
        C20281() {
        }

        public ShareMessengerGenericTemplateContent createFromParcel(Parcel parcel) {
            return new ShareMessengerGenericTemplateContent(parcel);
        }

        public ShareMessengerGenericTemplateContent[] newArray(int i) {
            return new ShareMessengerGenericTemplateContent[i];
        }
    }

    public enum ImageAspectRatio {
        HORIZONTAL,
        SQUARE
    }

    public static class Builder extends com.facebook.share.model.ShareContent.Builder<ShareMessengerGenericTemplateContent, Builder> {
        private ShareMessengerGenericTemplateElement genericTemplateElement;
        private ImageAspectRatio imageAspectRatio;
        private boolean isSharable;

        public Builder setIsSharable(boolean z) {
            this.isSharable = z;
            return this;
        }

        public Builder setImageAspectRatio(ImageAspectRatio imageAspectRatio) {
            this.imageAspectRatio = imageAspectRatio;
            return this;
        }

        public Builder setGenericTemplateElement(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
            this.genericTemplateElement = shareMessengerGenericTemplateElement;
            return this;
        }

        public ShareMessengerGenericTemplateContent build() {
            return new ShareMessengerGenericTemplateContent(this);
        }

        public Builder readFrom(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            if (shareMessengerGenericTemplateContent == null) {
                return this;
            }
            return ((Builder) super.readFrom((ShareContent) shareMessengerGenericTemplateContent)).setIsSharable(shareMessengerGenericTemplateContent.getIsSharable()).setImageAspectRatio(shareMessengerGenericTemplateContent.getImageAspectRatio()).setGenericTemplateElement(shareMessengerGenericTemplateContent.getGenericTemplateElement());
        }
    }

    public int describeContents() {
        return 0;
    }

    protected ShareMessengerGenericTemplateContent(Builder builder) {
        super((com.facebook.share.model.ShareContent.Builder) builder);
        this.isSharable = builder.isSharable;
        this.imageAspectRatio = builder.imageAspectRatio;
        this.genericTemplateElement = builder.genericTemplateElement;
    }

    ShareMessengerGenericTemplateContent(Parcel parcel) {
        super(parcel);
        this.isSharable = parcel.readByte() != (byte) 0;
        this.imageAspectRatio = (ImageAspectRatio) parcel.readSerializable();
        this.genericTemplateElement = (ShareMessengerGenericTemplateElement) parcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader());
    }

    public boolean getIsSharable() {
        return this.isSharable;
    }

    public ImageAspectRatio getImageAspectRatio() {
        return this.imageAspectRatio;
    }

    public ShareMessengerGenericTemplateElement getGenericTemplateElement() {
        return this.genericTemplateElement;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte((byte) this.isSharable);
        parcel.writeSerializable(this.imageAspectRatio);
        parcel.writeParcelable(this.genericTemplateElement, i);
    }
}
