package com.facebook.share.internal;

import android.graphics.Bitmap;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.ShareOpenGraphValueContainer;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.List;
import java.util.Locale;

public class ShareContentValidation {
    private static Validator ApiValidator;
    private static Validator DefaultValidator;
    private static Validator StoryValidator;
    private static Validator WebShareValidator;

    private static class Validator {
        private boolean isOpenGraphContent;

        private Validator() {
            this.isOpenGraphContent = false;
        }

        public void validate(ShareLinkContent shareLinkContent) {
            ShareContentValidation.validateLinkContent(shareLinkContent, this);
        }

        public void validate(SharePhotoContent sharePhotoContent) {
            ShareContentValidation.validatePhotoContent(sharePhotoContent, this);
        }

        public void validate(ShareVideoContent shareVideoContent) {
            ShareContentValidation.validateVideoContent(shareVideoContent, this);
        }

        public void validate(ShareMediaContent shareMediaContent) {
            ShareContentValidation.validateMediaContent(shareMediaContent, this);
        }

        public void validate(ShareCameraEffectContent shareCameraEffectContent) {
            ShareContentValidation.validateCameraEffectContent(shareCameraEffectContent, this);
        }

        public void validate(ShareOpenGraphContent shareOpenGraphContent) {
            this.isOpenGraphContent = true;
            ShareContentValidation.validateOpenGraphContent(shareOpenGraphContent, this);
        }

        public void validate(ShareOpenGraphAction shareOpenGraphAction) {
            ShareContentValidation.validateOpenGraphAction(shareOpenGraphAction, this);
        }

        public void validate(ShareOpenGraphObject shareOpenGraphObject) {
            ShareContentValidation.validateOpenGraphObject(shareOpenGraphObject, this);
        }

        public void validate(ShareOpenGraphValueContainer shareOpenGraphValueContainer, boolean z) {
            ShareContentValidation.validateOpenGraphValueContainer(shareOpenGraphValueContainer, this, z);
        }

        public void validate(SharePhoto sharePhoto) {
            ShareContentValidation.validatePhotoForNativeDialog(sharePhoto, this);
        }

        public void validate(ShareVideo shareVideo) {
            ShareContentValidation.validateVideo(shareVideo, this);
        }

        public void validate(ShareMedia shareMedia) {
            ShareContentValidation.validateMedium(shareMedia, this);
        }

        public void validate(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
            ShareContentValidation.validateMessengerOpenGraphMusicTemplate(shareMessengerOpenGraphMusicTemplateContent);
        }

        public void validate(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            ShareContentValidation.validateShareMessengerGenericTemplateContent(shareMessengerGenericTemplateContent);
        }

        public void validate(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
            ShareContentValidation.validateShareMessengerMediaTemplateContent(shareMessengerMediaTemplateContent);
        }

        public void validate(ShareStoryContent shareStoryContent) {
            ShareContentValidation.validateStoryContent(shareStoryContent, this);
        }

        public boolean isOpenGraphContent() {
            return this.isOpenGraphContent;
        }
    }

    private static class ApiValidator extends Validator {
        private ApiValidator() {
            super();
        }

        public void validate(SharePhoto sharePhoto) {
            ShareContentValidation.validatePhotoForApi(sharePhoto, this);
        }

        public void validate(ShareVideoContent shareVideoContent) {
            if (!Utility.isNullOrEmpty(shareVideoContent.getPlaceId())) {
                throw new FacebookException("Cannot share video content with place IDs using the share api");
            } else if (!Utility.isNullOrEmpty(shareVideoContent.getPeopleIds())) {
                throw new FacebookException("Cannot share video content with people IDs using the share api");
            } else if (Utility.isNullOrEmpty(shareVideoContent.getRef()) == null) {
                throw new FacebookException("Cannot share video content with referrer URL using the share api");
            }
        }

        public void validate(ShareMediaContent shareMediaContent) {
            throw new FacebookException("Cannot share ShareMediaContent using the share api");
        }

        public void validate(ShareLinkContent shareLinkContent) {
            if (Utility.isNullOrEmpty(shareLinkContent.getQuote()) == null) {
                throw new FacebookException("Cannot share link content with quote using the share api");
            }
        }
    }

    private static class StoryShareValidator extends Validator {
        private StoryShareValidator() {
            super();
        }

        public void validate(ShareStoryContent shareStoryContent) {
            ShareContentValidation.validateStoryContent(shareStoryContent, this);
        }
    }

    private static class WebShareValidator extends Validator {
        private WebShareValidator() {
            super();
        }

        public void validate(ShareVideoContent shareVideoContent) {
            throw new FacebookException("Cannot share ShareVideoContent via web sharing dialogs");
        }

        public void validate(ShareMediaContent shareMediaContent) {
            throw new FacebookException("Cannot share ShareMediaContent via web sharing dialogs");
        }

        public void validate(SharePhoto sharePhoto) {
            ShareContentValidation.validatePhotoForWebDialog(sharePhoto, this);
        }
    }

    public static void validateForMessage(ShareContent shareContent) {
        validate(shareContent, getDefaultValidator());
    }

    public static void validateForNativeShare(ShareContent shareContent) {
        validate(shareContent, getDefaultValidator());
    }

    public static void validateForWebShare(ShareContent shareContent) {
        validate(shareContent, getWebShareValidator());
    }

    public static void validateForApiShare(ShareContent shareContent) {
        validate(shareContent, getApiValidator());
    }

    public static void validateForStoryShare(ShareContent shareContent) {
        validate(shareContent, getStoryValidator());
    }

    private static Validator getStoryValidator() {
        if (StoryValidator == null) {
            StoryValidator = new StoryShareValidator();
        }
        return StoryValidator;
    }

    private static Validator getDefaultValidator() {
        if (DefaultValidator == null) {
            DefaultValidator = new Validator();
        }
        return DefaultValidator;
    }

    private static Validator getApiValidator() {
        if (ApiValidator == null) {
            ApiValidator = new ApiValidator();
        }
        return ApiValidator;
    }

    private static Validator getWebShareValidator() {
        if (WebShareValidator == null) {
            WebShareValidator = new WebShareValidator();
        }
        return WebShareValidator;
    }

    private static void validate(ShareContent shareContent, Validator validator) {
        if (shareContent == null) {
            throw new FacebookException("Must provide non-null content to share");
        } else if (shareContent instanceof ShareLinkContent) {
            validator.validate((ShareLinkContent) shareContent);
        } else if (shareContent instanceof SharePhotoContent) {
            validator.validate((SharePhotoContent) shareContent);
        } else if (shareContent instanceof ShareVideoContent) {
            validator.validate((ShareVideoContent) shareContent);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            validator.validate((ShareOpenGraphContent) shareContent);
        } else if (shareContent instanceof ShareMediaContent) {
            validator.validate((ShareMediaContent) shareContent);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            validator.validate((ShareCameraEffectContent) shareContent);
        } else if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
            validator.validate((ShareMessengerOpenGraphMusicTemplateContent) shareContent);
        } else if (shareContent instanceof ShareMessengerMediaTemplateContent) {
            validator.validate((ShareMessengerMediaTemplateContent) shareContent);
        } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
            validator.validate((ShareMessengerGenericTemplateContent) shareContent);
        } else if (shareContent instanceof ShareStoryContent) {
            validator.validate((ShareStoryContent) shareContent);
        }
    }

    private static void validateStoryContent(ShareStoryContent shareStoryContent, Validator validator) {
        if (shareStoryContent == null || (shareStoryContent.getBackgroundAsset() == null && shareStoryContent.getStickerAsset() == null)) {
            throw new FacebookException("Must pass the Facebook app a background asset, a sticker asset, or both");
        }
        if (shareStoryContent.getBackgroundAsset() != null) {
            validator.validate(shareStoryContent.getBackgroundAsset());
        }
        if (shareStoryContent.getStickerAsset() != null) {
            validator.validate(shareStoryContent.getStickerAsset());
        }
    }

    private static void validateLinkContent(ShareLinkContent shareLinkContent, Validator validator) {
        shareLinkContent = shareLinkContent.getImageUrl();
        if (shareLinkContent == null) {
            return;
        }
        if (Utility.isWebUri(shareLinkContent) == null) {
            throw new FacebookException("Image Url must be an http:// or https:// url");
        }
    }

    private static void validatePhotoContent(SharePhotoContent sharePhotoContent, Validator validator) {
        SharePhotoContent<SharePhoto> photos = sharePhotoContent.getPhotos();
        if (photos == null || photos.isEmpty()) {
            throw new FacebookException("Must specify at least one Photo in SharePhotoContent.");
        } else if (photos.size() <= 6) {
            for (SharePhoto validate : photos) {
                validator.validate(validate);
            }
        } else {
            throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d photos.", new Object[]{Integer.valueOf(6)}));
        }
    }

    private static void validatePhoto(SharePhoto sharePhoto) {
        if (sharePhoto != null) {
            Bitmap bitmap = sharePhoto.getBitmap();
            sharePhoto = sharePhoto.getImageUrl();
            if (bitmap != null) {
                return;
            }
            if (sharePhoto == null) {
                throw new FacebookException("SharePhoto does not have a Bitmap or ImageUrl specified");
            }
            return;
        }
        throw new FacebookException("Cannot share a null SharePhoto");
    }

    private static void validatePhotoForApi(SharePhoto sharePhoto, Validator validator) {
        validatePhoto(sharePhoto);
        Bitmap bitmap = sharePhoto.getBitmap();
        sharePhoto = sharePhoto.getImageUrl();
        if (bitmap == null && Utility.isWebUri(sharePhoto) != null) {
            if (validator.isOpenGraphContent() == null) {
                throw new FacebookException("Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
            }
        }
    }

    private static void validatePhotoForNativeDialog(SharePhoto sharePhoto, Validator validator) {
        validatePhotoForApi(sharePhoto, validator);
        if (sharePhoto.getBitmap() != null || Utility.isWebUri(sharePhoto.getImageUrl()) == null) {
            Validate.hasContentProvider(FacebookSdk.getApplicationContext());
        }
    }

    private static void validatePhotoForWebDialog(SharePhoto sharePhoto, Validator validator) {
        validatePhoto(sharePhoto);
    }

    private static void validateVideoContent(ShareVideoContent shareVideoContent, Validator validator) {
        validator.validate(shareVideoContent.getVideo());
        SharePhoto previewPhoto = shareVideoContent.getPreviewPhoto();
        if (previewPhoto != null) {
            validator.validate(previewPhoto);
        }
    }

    private static void validateVideo(ShareVideo shareVideo, Validator validator) {
        if (shareVideo != null) {
            shareVideo = shareVideo.getLocalUrl();
            if (shareVideo == null) {
                throw new FacebookException("ShareVideo does not have a LocalUrl specified");
            } else if (Utility.isContentUri(shareVideo) != null) {
                return;
            } else {
                if (Utility.isFileUri(shareVideo) == null) {
                    throw new FacebookException("ShareVideo must reference a video that is on the device");
                }
                return;
            }
        }
        throw new FacebookException("Cannot share a null ShareVideo");
    }

    private static void validateMediaContent(ShareMediaContent shareMediaContent, Validator validator) {
        ShareMediaContent<ShareMedia> media = shareMediaContent.getMedia();
        if (media == null || media.isEmpty()) {
            throw new FacebookException("Must specify at least one medium in ShareMediaContent.");
        } else if (media.size() <= 6) {
            for (ShareMedia validate : media) {
                validator.validate(validate);
            }
        } else {
            throw new FacebookException(String.format(Locale.ROOT, "Cannot add more than %d media.", new Object[]{Integer.valueOf(6)}));
        }
    }

    public static void validateMedium(ShareMedia shareMedia, Validator validator) {
        if (shareMedia instanceof SharePhoto) {
            validator.validate((SharePhoto) shareMedia);
        } else if (shareMedia instanceof ShareVideo) {
            validator.validate((ShareVideo) shareMedia);
        } else {
            throw new FacebookException(String.format(Locale.ROOT, "Invalid media type: %s", new Object[]{shareMedia.getClass().getSimpleName()}));
        }
    }

    private static void validateCameraEffectContent(ShareCameraEffectContent shareCameraEffectContent, Validator validator) {
        if (Utility.isNullOrEmpty(shareCameraEffectContent.getEffectId()) != null) {
            throw new FacebookException("Must specify a non-empty effectId");
        }
    }

    private static void validateOpenGraphContent(ShareOpenGraphContent shareOpenGraphContent, Validator validator) {
        validator.validate(shareOpenGraphContent.getAction());
        String previewPropertyName = shareOpenGraphContent.getPreviewPropertyName();
        if (Utility.isNullOrEmpty(previewPropertyName)) {
            throw new FacebookException("Must specify a previewPropertyName.");
        } else if (shareOpenGraphContent.getAction().get(previewPropertyName) == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Property \"");
            stringBuilder.append(previewPropertyName);
            stringBuilder.append("\" was not found on the action. The name of the preview property must match the name of an action property.");
            throw new FacebookException(stringBuilder.toString());
        }
    }

    private static void validateOpenGraphAction(ShareOpenGraphAction shareOpenGraphAction, Validator validator) {
        if (shareOpenGraphAction == null) {
            throw new FacebookException("Must specify a non-null ShareOpenGraphAction");
        } else if (Utility.isNullOrEmpty(shareOpenGraphAction.getActionType())) {
            throw new FacebookException("ShareOpenGraphAction must have a non-empty actionType");
        } else {
            validator.validate(shareOpenGraphAction, false);
        }
    }

    private static void validateOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject, Validator validator) {
        if (shareOpenGraphObject != null) {
            validator.validate(shareOpenGraphObject, true);
            return;
        }
        throw new FacebookException("Cannot share a null ShareOpenGraphObject");
    }

    private static void validateOpenGraphValueContainer(ShareOpenGraphValueContainer shareOpenGraphValueContainer, Validator validator, boolean z) {
        for (String str : shareOpenGraphValueContainer.keySet()) {
            validateOpenGraphKey(str, z);
            Object obj = shareOpenGraphValueContainer.get(str);
            if (obj instanceof List) {
                for (Object next : (List) obj) {
                    if (next != null) {
                        validateOpenGraphValueContainerObject(next, validator);
                    } else {
                        throw new FacebookException("Cannot put null objects in Lists in ShareOpenGraphObjects and ShareOpenGraphActions");
                    }
                }
                continue;
            } else {
                validateOpenGraphValueContainerObject(obj, validator);
            }
        }
    }

    private static void validateMessengerOpenGraphMusicTemplate(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        if (Utility.isNullOrEmpty(shareMessengerOpenGraphMusicTemplateContent.getPageId())) {
            throw new FacebookException("Must specify Page Id for ShareMessengerOpenGraphMusicTemplateContent");
        } else if (shareMessengerOpenGraphMusicTemplateContent.getUrl() != null) {
            validateShareMessengerActionButton(shareMessengerOpenGraphMusicTemplateContent.getButton());
        } else {
            throw new FacebookException("Must specify url for ShareMessengerOpenGraphMusicTemplateContent");
        }
    }

    private static void validateShareMessengerGenericTemplateContent(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        if (Utility.isNullOrEmpty(shareMessengerGenericTemplateContent.getPageId())) {
            throw new FacebookException("Must specify Page Id for ShareMessengerGenericTemplateContent");
        } else if (shareMessengerGenericTemplateContent.getGenericTemplateElement() == null) {
            throw new FacebookException("Must specify element for ShareMessengerGenericTemplateContent");
        } else if (Utility.isNullOrEmpty(shareMessengerGenericTemplateContent.getGenericTemplateElement().getTitle())) {
            throw new FacebookException("Must specify title for ShareMessengerGenericTemplateElement");
        } else {
            validateShareMessengerActionButton(shareMessengerGenericTemplateContent.getGenericTemplateElement().getButton());
        }
    }

    private static void validateShareMessengerMediaTemplateContent(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        if (Utility.isNullOrEmpty(shareMessengerMediaTemplateContent.getPageId())) {
            throw new FacebookException("Must specify Page Id for ShareMessengerMediaTemplateContent");
        }
        if (shareMessengerMediaTemplateContent.getMediaUrl() == null) {
            if (Utility.isNullOrEmpty(shareMessengerMediaTemplateContent.getAttachmentId())) {
                throw new FacebookException("Must specify either attachmentId or mediaURL for ShareMessengerMediaTemplateContent");
            }
        }
        validateShareMessengerActionButton(shareMessengerMediaTemplateContent.getButton());
    }

    private static void validateShareMessengerActionButton(ShareMessengerActionButton shareMessengerActionButton) {
        if (shareMessengerActionButton != null) {
            if (Utility.isNullOrEmpty(shareMessengerActionButton.getTitle())) {
                throw new FacebookException("Must specify title for ShareMessengerActionButton");
            }
            if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                validateShareMessengerURLActionButton((ShareMessengerURLActionButton) shareMessengerActionButton);
            }
        }
    }

    private static void validateShareMessengerURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        if (shareMessengerURLActionButton.getUrl() == null) {
            throw new FacebookException("Must specify url for ShareMessengerURLActionButton");
        }
    }

    private static void validateOpenGraphKey(String str, boolean z) {
        if (z) {
            z = str.split(":");
            if (z.length >= 2) {
                for (String isEmpty : z) {
                    if (isEmpty.isEmpty()) {
                        throw new FacebookException("Invalid key found in Open Graph dictionary: %s", str);
                    }
                }
                return;
            }
            throw new FacebookException("Open Graph keys must be namespaced: %s", str);
        }
    }

    private static void validateOpenGraphValueContainerObject(Object obj, Validator validator) {
        if (obj instanceof ShareOpenGraphObject) {
            validator.validate((ShareOpenGraphObject) obj);
        } else if (obj instanceof SharePhoto) {
            validator.validate((SharePhoto) obj);
        }
    }
}
