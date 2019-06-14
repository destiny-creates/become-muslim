package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent.ImageAspectRatio;
import com.facebook.share.model.ShareMessengerGenericTemplateElement;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent.MediaType;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import com.facebook.share.model.ShareMessengerURLActionButton.WebviewHeightRatio;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessengerShareContentUtility {
    public static final String ATTACHMENT = "attachment";
    public static final String ATTACHMENT_ID = "attachment_id";
    public static final String ATTACHMENT_PAYLOAD = "payload";
    public static final String ATTACHMENT_TEMPLATE_TYPE = "template";
    public static final String ATTACHMENT_TYPE = "type";
    public static final String BUTTONS = "buttons";
    public static final String BUTTON_TYPE = "type";
    public static final String BUTTON_URL_TYPE = "web_url";
    public static final String DEFAULT_ACTION = "default_action";
    public static final String ELEMENTS = "elements";
    public static final Pattern FACEBOOK_DOMAIN = Pattern.compile("^(.+)\\.(facebook\\.com)$");
    public static final String FALLBACK_URL = "fallback_url";
    public static final String IMAGE_ASPECT_RATIO = "image_aspect_ratio";
    public static final String IMAGE_RATIO_HORIZONTAL = "horizontal";
    public static final String IMAGE_RATIO_SQUARE = "square";
    public static final String IMAGE_URL = "image_url";
    public static final String MEDIA_IMAGE = "image";
    public static final String MEDIA_TYPE = "media_type";
    public static final String MEDIA_VIDEO = "video";
    public static final String MESSENGER_EXTENSIONS = "messenger_extensions";
    public static final String PREVIEW_DEFAULT = "DEFAULT";
    public static final String PREVIEW_OPEN_GRAPH = "OPEN_GRAPH";
    public static final String SHARABLE = "sharable";
    public static final String SHARE_BUTTON_HIDE = "hide";
    public static final String SUBTITLE = "subtitle";
    public static final String TEMPLATE_GENERIC_TYPE = "generic";
    public static final String TEMPLATE_MEDIA_TYPE = "media";
    public static final String TEMPLATE_OPEN_GRAPH_TYPE = "open_graph";
    public static final String TEMPLATE_TYPE = "template_type";
    public static final String TITLE = "title";
    public static final String URL = "url";
    public static final String WEBVIEW_RATIO = "webview_height_ratio";
    public static final String WEBVIEW_RATIO_COMPACT = "compact";
    public static final String WEBVIEW_RATIO_FULL = "full";
    public static final String WEBVIEW_RATIO_TALL = "tall";
    public static final String WEBVIEW_SHARE_BUTTON = "webview_share_button";

    /* renamed from: com.facebook.share.internal.MessengerShareContentUtility$1 */
    static /* synthetic */ class C20111 {
        /* renamed from: $SwitchMap$com$facebook$share$model$ShareMessengerGenericTemplateContent$ImageAspectRatio */
        static final /* synthetic */ int[] f4993xb7309c05 = new int[ImageAspectRatio.values().length];
        /* renamed from: $SwitchMap$com$facebook$share$model$ShareMessengerMediaTemplateContent$MediaType */
        static final /* synthetic */ int[] f4994x2a75e664 = new int[MediaType.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r0 = com.facebook.share.model.ShareMessengerMediaTemplateContent.MediaType.values();
            r0 = r0.length;
            r0 = new int[r0];
            f4994x2a75e664 = r0;
            r0 = 1;
            r1 = f4994x2a75e664;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = com.facebook.share.model.ShareMessengerMediaTemplateContent.MediaType.VIDEO;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = com.facebook.share.model.ShareMessengerGenericTemplateContent.ImageAspectRatio.values();
            r1 = r1.length;
            r1 = new int[r1];
            f4993xb7309c05 = r1;
            r1 = f4993xb7309c05;	 Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = com.facebook.share.model.ShareMessengerGenericTemplateContent.ImageAspectRatio.SQUARE;	 Catch:{ NoSuchFieldError -> 0x0027 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0027 }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0027 }
        L_0x0027:
            r1 = com.facebook.share.model.ShareMessengerURLActionButton.WebviewHeightRatio.values();
            r1 = r1.length;
            r1 = new int[r1];
            f4995x92e77847 = r1;
            r1 = f4995x92e77847;	 Catch:{ NoSuchFieldError -> 0x003a }
            r2 = com.facebook.share.model.ShareMessengerURLActionButton.WebviewHeightRatio.WebviewHeightRatioCompact;	 Catch:{ NoSuchFieldError -> 0x003a }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x003a }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x003a }
        L_0x003a:
            r0 = f4995x92e77847;	 Catch:{ NoSuchFieldError -> 0x0045 }
            r1 = com.facebook.share.model.ShareMessengerURLActionButton.WebviewHeightRatio.WebviewHeightRatioTall;	 Catch:{ NoSuchFieldError -> 0x0045 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0045 }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x0045 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0045 }
        L_0x0045:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.internal.MessengerShareContentUtility.1.<clinit>():void");
        }
    }

    public static void addGenericTemplateContent(Bundle bundle, ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        addGenericTemplateElementForPreview(bundle, shareMessengerGenericTemplateContent.getGenericTemplateElement());
        Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, serializeGenericTemplateContent(shareMessengerGenericTemplateContent));
    }

    public static void addOpenGraphMusicTemplateContent(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        addOpenGraphMusicTemplateContentForPreview(bundle, shareMessengerOpenGraphMusicTemplateContent);
        Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, serializeOpenGraphMusicTemplateContent(shareMessengerOpenGraphMusicTemplateContent));
    }

    public static void addMediaTemplateContent(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        addMediaTemplateContentForPreview(bundle, shareMessengerMediaTemplateContent);
        Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, serializeMediaTemplateContent(shareMessengerMediaTemplateContent));
    }

    private static void addGenericTemplateElementForPreview(Bundle bundle, ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
        if (shareMessengerGenericTemplateElement.getButton() != null) {
            addActionButton(bundle, shareMessengerGenericTemplateElement.getButton(), false);
        } else if (shareMessengerGenericTemplateElement.getDefaultAction() != null) {
            addActionButton(bundle, shareMessengerGenericTemplateElement.getDefaultAction(), true);
        }
        Utility.putUri(bundle, ShareConstants.IMAGE_URL, shareMessengerGenericTemplateElement.getImageUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, PREVIEW_DEFAULT);
        Utility.putNonEmptyString(bundle, ShareConstants.TITLE, shareMessengerGenericTemplateElement.getTitle());
        Utility.putNonEmptyString(bundle, ShareConstants.SUBTITLE, shareMessengerGenericTemplateElement.getSubtitle());
    }

    private static void addOpenGraphMusicTemplateContentForPreview(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        addActionButton(bundle, shareMessengerOpenGraphMusicTemplateContent.getButton(), false);
        Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, PREVIEW_OPEN_GRAPH);
        Utility.putUri(bundle, ShareConstants.OPEN_GRAPH_URL, shareMessengerOpenGraphMusicTemplateContent.getUrl());
    }

    private static void addMediaTemplateContentForPreview(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        addActionButton(bundle, shareMessengerMediaTemplateContent.getButton(), false);
        Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, PREVIEW_DEFAULT);
        Utility.putNonEmptyString(bundle, ShareConstants.ATTACHMENT_ID, shareMessengerMediaTemplateContent.getAttachmentId());
        if (shareMessengerMediaTemplateContent.getMediaUrl() != null) {
            Utility.putUri(bundle, getMediaUrlKey(shareMessengerMediaTemplateContent.getMediaUrl()), shareMessengerMediaTemplateContent.getMediaUrl());
        }
        Utility.putNonEmptyString(bundle, "type", getMediaType(shareMessengerMediaTemplateContent.getMediaType()));
    }

    private static void addActionButton(Bundle bundle, ShareMessengerActionButton shareMessengerActionButton, boolean z) {
        if (shareMessengerActionButton != null && (shareMessengerActionButton instanceof ShareMessengerURLActionButton)) {
            addURLActionButton(bundle, (ShareMessengerURLActionButton) shareMessengerActionButton, z);
        }
    }

    private static void addURLActionButton(Bundle bundle, ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) {
        if (z) {
            z = Utility.getUriString(shareMessengerURLActionButton.getUrl());
        } else {
            z = new StringBuilder();
            z.append(shareMessengerURLActionButton.getTitle());
            z.append(" - ");
            z.append(Utility.getUriString(shareMessengerURLActionButton.getUrl()));
            z = z.toString();
        }
        Utility.putNonEmptyString(bundle, ShareConstants.TARGET_DISPLAY, z);
        Utility.putUri(bundle, ShareConstants.ITEM_URL, shareMessengerURLActionButton.getUrl());
    }

    private static JSONObject serializeGenericTemplateContent(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
        return new JSONObject().put(ATTACHMENT, new JSONObject().put("type", "template").put(ATTACHMENT_PAYLOAD, new JSONObject().put(TEMPLATE_TYPE, TEMPLATE_GENERIC_TYPE).put(SHARABLE, shareMessengerGenericTemplateContent.getIsSharable()).put(IMAGE_ASPECT_RATIO, getImageRatioString(shareMessengerGenericTemplateContent.getImageAspectRatio())).put(ELEMENTS, new JSONArray().put(serializeGenericTemplateElement(shareMessengerGenericTemplateContent.getGenericTemplateElement())))));
    }

    private static JSONObject serializeOpenGraphMusicTemplateContent(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        return new JSONObject().put(ATTACHMENT, new JSONObject().put("type", "template").put(ATTACHMENT_PAYLOAD, new JSONObject().put(TEMPLATE_TYPE, "open_graph").put(ELEMENTS, new JSONArray().put(serializeOpenGraphMusicTemplateElement(shareMessengerOpenGraphMusicTemplateContent)))));
    }

    private static JSONObject serializeMediaTemplateContent(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        return new JSONObject().put(ATTACHMENT, new JSONObject().put("type", "template").put(ATTACHMENT_PAYLOAD, new JSONObject().put(TEMPLATE_TYPE, "media").put(ELEMENTS, new JSONArray().put(serializeMediaTemplateElement(shareMessengerMediaTemplateContent)))));
    }

    private static JSONObject serializeGenericTemplateElement(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
        JSONObject put = new JSONObject().put("title", shareMessengerGenericTemplateElement.getTitle()).put(SUBTITLE, shareMessengerGenericTemplateElement.getSubtitle()).put(IMAGE_URL, Utility.getUriString(shareMessengerGenericTemplateElement.getImageUrl()));
        if (shareMessengerGenericTemplateElement.getButton() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(serializeActionButton(shareMessengerGenericTemplateElement.getButton()));
            put.put(BUTTONS, jSONArray);
        }
        if (shareMessengerGenericTemplateElement.getDefaultAction() != null) {
            put.put(DEFAULT_ACTION, serializeActionButton(shareMessengerGenericTemplateElement.getDefaultAction(), true));
        }
        return put;
    }

    private static JSONObject serializeOpenGraphMusicTemplateElement(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
        JSONObject put = new JSONObject().put("url", Utility.getUriString(shareMessengerOpenGraphMusicTemplateContent.getUrl()));
        if (shareMessengerOpenGraphMusicTemplateContent.getButton() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(serializeActionButton(shareMessengerOpenGraphMusicTemplateContent.getButton()));
            put.put(BUTTONS, jSONArray);
        }
        return put;
    }

    private static JSONObject serializeMediaTemplateElement(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
        JSONObject put = new JSONObject().put(ATTACHMENT_ID, shareMessengerMediaTemplateContent.getAttachmentId()).put("url", Utility.getUriString(shareMessengerMediaTemplateContent.getMediaUrl())).put(MEDIA_TYPE, getMediaType(shareMessengerMediaTemplateContent.getMediaType()));
        if (shareMessengerMediaTemplateContent.getButton() != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(serializeActionButton(shareMessengerMediaTemplateContent.getButton()));
            put.put(BUTTONS, jSONArray);
        }
        return put;
    }

    private static JSONObject serializeActionButton(ShareMessengerActionButton shareMessengerActionButton) {
        return serializeActionButton(shareMessengerActionButton, false);
    }

    private static JSONObject serializeActionButton(ShareMessengerActionButton shareMessengerActionButton, boolean z) {
        return shareMessengerActionButton instanceof ShareMessengerURLActionButton ? serializeURLActionButton((ShareMessengerURLActionButton) shareMessengerActionButton, z) : null;
    }

    private static JSONObject serializeURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) {
        JSONObject put = new JSONObject().put("type", BUTTON_URL_TYPE);
        String str = "title";
        if (z) {
            z = false;
        } else {
            z = shareMessengerURLActionButton.getTitle();
        }
        return put.put(str, z).put("url", Utility.getUriString(shareMessengerURLActionButton.getUrl())).put(WEBVIEW_RATIO, getWebviewHeightRatioString(shareMessengerURLActionButton.getWebviewHeightRatio())).put(MESSENGER_EXTENSIONS, shareMessengerURLActionButton.getIsMessengerExtensionURL()).put(FALLBACK_URL, Utility.getUriString(shareMessengerURLActionButton.getFallbackUrl())).put(WEBVIEW_SHARE_BUTTON, getShouldHideShareButton(shareMessengerURLActionButton));
    }

    private static String getMediaUrlKey(Uri uri) {
        String host = uri.getHost();
        return (Utility.isNullOrEmpty(host) || FACEBOOK_DOMAIN.matcher(host).matches() == null) ? ShareConstants.IMAGE_URL : "uri";
    }

    private static String getWebviewHeightRatioString(WebviewHeightRatio webviewHeightRatio) {
        if (webviewHeightRatio == null) {
            return WEBVIEW_RATIO_FULL;
        }
        switch (webviewHeightRatio) {
            case WebviewHeightRatioCompact:
                return WEBVIEW_RATIO_COMPACT;
            case WebviewHeightRatioTall:
                return WEBVIEW_RATIO_TALL;
            default:
                return WEBVIEW_RATIO_FULL;
        }
    }

    private static String getImageRatioString(ImageAspectRatio imageAspectRatio) {
        if (imageAspectRatio == null) {
            return IMAGE_RATIO_HORIZONTAL;
        }
        return C20111.f4993xb7309c05[imageAspectRatio.ordinal()] != 1 ? IMAGE_RATIO_HORIZONTAL : IMAGE_RATIO_SQUARE;
    }

    private static String getMediaType(MediaType mediaType) {
        if (mediaType == null) {
            return MEDIA_IMAGE;
        }
        return C20111.f4994x2a75e664[mediaType.ordinal()] != 1 ? MEDIA_IMAGE : "video";
    }

    private static String getShouldHideShareButton(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        return shareMessengerURLActionButton.getShouldHideWebviewShareButton() != null ? SHARE_BUTTON_HIDE : null;
    }
}
