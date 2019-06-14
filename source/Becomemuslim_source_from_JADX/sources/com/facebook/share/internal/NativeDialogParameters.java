package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

public class NativeDialogParameters {
    public static Bundle create(UUID uuid, ShareContent shareContent, boolean z) {
        Validate.notNull(shareContent, "shareContent");
        Validate.notNull(uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return create((ShareLinkContent) shareContent, z);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            return create(sharePhotoContent, ShareInternalUtility.getPhotoUrls(sharePhotoContent, uuid), z);
        } else if (shareContent instanceof ShareVideoContent) {
            ShareVideoContent shareVideoContent = (ShareVideoContent) shareContent;
            return create(shareVideoContent, ShareInternalUtility.getVideoUrl(shareVideoContent, uuid), z);
        } else if (shareContent instanceof ShareOpenGraphContent) {
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return create(shareOpenGraphContent, ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForCall(uuid, shareOpenGraphContent), false), z);
            } catch (UUID uuid2) {
                z = new StringBuilder();
                z.append("Unable to create a JSON Object from the provided ShareOpenGraphContent: ");
                z.append(uuid2.getMessage());
                throw new FacebookException(z.toString());
            }
        } else if (shareContent instanceof ShareMediaContent) {
            ShareMediaContent shareMediaContent = (ShareMediaContent) shareContent;
            return create(shareMediaContent, ShareInternalUtility.getMediaInfos(shareMediaContent, uuid2), z);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            ShareCameraEffectContent shareCameraEffectContent = (ShareCameraEffectContent) shareContent;
            return create(shareCameraEffectContent, ShareInternalUtility.getTextureUrlBundle(shareCameraEffectContent, uuid2), z);
        } else if (shareContent instanceof ShareMessengerGenericTemplateContent) {
            return create((ShareMessengerGenericTemplateContent) shareContent, z);
        } else {
            if (shareContent instanceof ShareMessengerOpenGraphMusicTemplateContent) {
                return create((ShareMessengerOpenGraphMusicTemplateContent) shareContent, z);
            }
            if (shareContent instanceof ShareMessengerMediaTemplateContent) {
                return create((ShareMessengerMediaTemplateContent) shareContent, z);
            }
            if (!(shareContent instanceof ShareStoryContent)) {
                return null;
            }
            ShareStoryContent shareStoryContent = (ShareStoryContent) shareContent;
            return create(shareStoryContent, ShareInternalUtility.getBackgroundAssetMediaInfo(shareStoryContent, uuid2), ShareInternalUtility.getStickerUrl(shareStoryContent, uuid2), z);
        }
    }

    private static Bundle create(ShareCameraEffectContent shareCameraEffectContent, Bundle bundle, boolean z) {
        z = createBaseParameters(shareCameraEffectContent, z);
        Utility.putNonEmptyString(z, ShareConstants.EFFECT_ID, shareCameraEffectContent.getEffectId());
        if (bundle != null) {
            z.putBundle(ShareConstants.EFFECT_TEXTURES, bundle);
        }
        try {
            shareCameraEffectContent = CameraEffectJSONUtility.convertToJSON(shareCameraEffectContent.getArguments());
            if (shareCameraEffectContent != null) {
                Utility.putNonEmptyString(z, ShareConstants.EFFECT_ARGS, shareCameraEffectContent.toString());
            }
            return z;
        } catch (ShareCameraEffectContent shareCameraEffectContent2) {
            z = new StringBuilder();
            z.append("Unable to create a JSON Object from the provided CameraEffectArguments: ");
            z.append(shareCameraEffectContent2.getMessage());
            throw new FacebookException(z.toString());
        }
    }

    private static Bundle create(ShareLinkContent shareLinkContent, boolean z) {
        z = createBaseParameters(shareLinkContent, z);
        Utility.putNonEmptyString(z, ShareConstants.TITLE, shareLinkContent.getContentTitle());
        Utility.putNonEmptyString(z, ShareConstants.DESCRIPTION, shareLinkContent.getContentDescription());
        Utility.putUri(z, ShareConstants.IMAGE_URL, shareLinkContent.getImageUrl());
        Utility.putNonEmptyString(z, ShareConstants.QUOTE, shareLinkContent.getQuote());
        Utility.putUri(z, ShareConstants.MESSENGER_URL, shareLinkContent.getContentUrl());
        Utility.putUri(z, ShareConstants.TARGET_DISPLAY, shareLinkContent.getContentUrl());
        return z;
    }

    private static Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z) {
        sharePhotoContent = createBaseParameters(sharePhotoContent, z);
        sharePhotoContent.putStringArrayList(ShareConstants.PHOTOS, new ArrayList(list));
        return sharePhotoContent;
    }

    private static Bundle create(ShareVideoContent shareVideoContent, String str, boolean z) {
        z = createBaseParameters(shareVideoContent, z);
        Utility.putNonEmptyString(z, ShareConstants.TITLE, shareVideoContent.getContentTitle());
        Utility.putNonEmptyString(z, ShareConstants.DESCRIPTION, shareVideoContent.getContentDescription());
        Utility.putNonEmptyString(z, ShareConstants.VIDEO_URL, str);
        return z;
    }

    private static Bundle create(ShareMediaContent shareMediaContent, List<Bundle> list, boolean z) {
        shareMediaContent = createBaseParameters(shareMediaContent, z);
        shareMediaContent.putParcelableArrayList(ShareConstants.MEDIA, new ArrayList(list));
        return shareMediaContent;
    }

    private static Bundle create(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z) {
        z = createBaseParameters(shareOpenGraphContent, z);
        Utility.putNonEmptyString(z, ShareConstants.PREVIEW_PROPERTY_NAME, (String) ShareInternalUtility.getFieldNameAndNamespaceFromFullName(shareOpenGraphContent.getPreviewPropertyName()).second);
        Utility.putNonEmptyString(z, ShareConstants.ACTION_TYPE, shareOpenGraphContent.getAction().getActionType());
        Utility.putNonEmptyString(z, ShareConstants.ACTION, jSONObject.toString());
        return z;
    }

    private static Bundle create(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent, boolean z) {
        z = createBaseParameters(shareMessengerGenericTemplateContent, z);
        try {
            MessengerShareContentUtility.addGenericTemplateContent(z, shareMessengerGenericTemplateContent);
            return z;
        } catch (ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to create a JSON Object from the provided ShareMessengerGenericTemplateContent: ");
            stringBuilder.append(shareMessengerGenericTemplateContent2.getMessage());
            throw new FacebookException(stringBuilder.toString());
        }
    }

    private static Bundle create(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent, boolean z) {
        z = createBaseParameters(shareMessengerOpenGraphMusicTemplateContent, z);
        try {
            MessengerShareContentUtility.addOpenGraphMusicTemplateContent(z, shareMessengerOpenGraphMusicTemplateContent);
            return z;
        } catch (ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to create a JSON Object from the provided ShareMessengerOpenGraphMusicTemplateContent: ");
            stringBuilder.append(shareMessengerOpenGraphMusicTemplateContent2.getMessage());
            throw new FacebookException(stringBuilder.toString());
        }
    }

    private static Bundle create(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent, boolean z) {
        z = createBaseParameters(shareMessengerMediaTemplateContent, z);
        try {
            MessengerShareContentUtility.addMediaTemplateContent(z, shareMessengerMediaTemplateContent);
            return z;
        } catch (ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to create a JSON Object from the provided ShareMessengerMediaTemplateContent: ");
            stringBuilder.append(shareMessengerMediaTemplateContent2.getMessage());
            throw new FacebookException(stringBuilder.toString());
        }
    }

    private static Bundle create(ShareStoryContent shareStoryContent, Bundle bundle, Bundle bundle2, boolean z) {
        z = createBaseParameters(shareStoryContent, z);
        if (bundle != null) {
            z.putParcelable(ShareConstants.STORY_BG_ASSET, bundle);
        }
        if (bundle2 != null) {
            z.putParcelable(ShareConstants.STORY_INTERACTIVE_ASSET_URI, bundle2);
        }
        Collection backgroundColorList = shareStoryContent.getBackgroundColorList();
        if (Utility.isNullOrEmpty(backgroundColorList) == null) {
            z.putStringArrayList(ShareConstants.STORY_INTERACTIVE_COLOR_LIST, new ArrayList(backgroundColorList));
        }
        Utility.putNonEmptyString(z, ShareConstants.STORY_DEEP_LINK_URL, shareStoryContent.getAttributionLink());
        return z;
    }

    private static Bundle createBaseParameters(ShareContent shareContent, boolean z) {
        Bundle bundle = new Bundle();
        Utility.putUri(bundle, ShareConstants.CONTENT_URL, shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.PLACE_ID, shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, ShareConstants.PAGE_ID, shareContent.getPageId());
        Utility.putNonEmptyString(bundle, ShareConstants.REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.DATA_FAILURES_FATAL, z);
        Collection peopleIds = shareContent.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putStringArrayList(ShareConstants.PEOPLE_IDS, new ArrayList(peopleIds));
        }
        shareContent = shareContent.getShareHashtag();
        if (shareContent != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.HASHTAG, shareContent.getHashtag());
        }
        return bundle;
    }
}
