package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.C3178i;
import com.facebook.FacebookCallback;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.Sharer;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.MessageDialogFeature;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import java.util.ArrayList;
import java.util.List;

public final class MessageDialog extends FacebookDialogBase<ShareContent, Result> implements Sharer {
    private static final int DEFAULT_REQUEST_CODE = RequestCodeOffset.Message.toRequestCode();
    private boolean shouldFailOnDataError;

    private class NativeHandler extends ModeHandler {
        private NativeHandler() {
            super();
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            return (shareContent == null || MessageDialog.canShow(shareContent.getClass()) == null) ? null : true;
        }

        public AppCall createAppCall(final ShareContent shareContent) {
            ShareContentValidation.validateForMessage(shareContent);
            final AppCall createBaseAppCall = MessageDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = MessageDialog.this.getShouldFailOnDataError();
            MessageDialog.logDialogShare(MessageDialog.this.getActivityContext(), shareContent, createBaseAppCall);
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ParameterProvider() {
                public Bundle getParameters() {
                    return NativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                }

                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                }
            }, MessageDialog.getFeature(shareContent.getClass()));
            return createBaseAppCall;
        }
    }

    public static void show(Activity activity, ShareContent shareContent) {
        new MessageDialog(activity).show(shareContent);
    }

    public static void show(C3178i c3178i, ShareContent shareContent) {
        show(new FragmentWrapper(c3178i), shareContent);
    }

    public static void show(Fragment fragment, ShareContent shareContent) {
        show(new FragmentWrapper(fragment), shareContent);
    }

    private static void show(FragmentWrapper fragmentWrapper, ShareContent shareContent) {
        new MessageDialog(fragmentWrapper).show(shareContent);
    }

    public static boolean canShow(Class<? extends ShareContent> cls) {
        cls = getFeature(cls);
        return (cls == null || DialogPresenter.canPresentNativeDialogWithFeature(cls) == null) ? null : true;
    }

    public MessageDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
        this.shouldFailOnDataError = null;
        ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
    }

    public MessageDialog(C3178i c3178i) {
        this(new FragmentWrapper(c3178i));
    }

    public MessageDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    private MessageDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
        this.shouldFailOnDataError = null;
        ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
    }

    MessageDialog(Activity activity, int i) {
        super(activity, i);
        this.shouldFailOnDataError = null;
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    MessageDialog(C3178i c3178i, int i) {
        this(new FragmentWrapper(c3178i), i);
    }

    MessageDialog(Fragment fragment, int i) {
        this(new FragmentWrapper(fragment), i);
    }

    private MessageDialog(FragmentWrapper fragmentWrapper, int i) {
        super(fragmentWrapper, i);
        this.shouldFailOnDataError = null;
        ShareInternalUtility.registerStaticShareCallback(i);
    }

    protected void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManagerImpl, facebookCallback);
    }

    public boolean getShouldFailOnDataError() {
        return this.shouldFailOnDataError;
    }

    public void setShouldFailOnDataError(boolean z) {
        this.shouldFailOnDataError = z;
    }

    protected AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    protected List<ModeHandler> getOrderedModeHandlers() {
        List arrayList = new ArrayList();
        arrayList.add(new NativeHandler());
        return arrayList;
    }

    private static DialogFeature getFeature(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSAGE_DIALOG;
        }
        if (ShareMessengerGenericTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_GENERIC_TEMPLATE;
        }
        if (ShareMessengerOpenGraphMusicTemplateContent.class.isAssignableFrom(cls)) {
            return MessageDialogFeature.MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE;
        }
        return ShareMessengerMediaTemplateContent.class.isAssignableFrom(cls) != null ? MessageDialogFeature.MESSENGER_MEDIA_TEMPLATE : null;
    }

    private static void logDialogShare(Context context, ShareContent shareContent, AppCall appCall) {
        DialogFeature feature = getFeature(shareContent.getClass());
        String str = feature == MessageDialogFeature.MESSAGE_DIALOG ? AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS : feature == MessageDialogFeature.MESSENGER_GENERIC_TEMPLATE ? AnalyticsEvents.PARAMETER_SHARE_MESSENGER_GENERIC_TEMPLATE : feature == MessageDialogFeature.MESSENGER_MEDIA_TEMPLATE ? AnalyticsEvents.PARAMETER_SHARE_MESSENGER_MEDIA_TEMPLATE : feature == MessageDialogFeature.MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE ? AnalyticsEvents.PARAMETER_SHARE_MESSENGER_OPEN_GRAPH_MUSIC_TEMPLATE : "unknown";
        context = AppEventsLogger.newLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_TYPE, str);
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_UUID, appCall.getCallId().toString());
        bundle.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PAGE_ID, shareContent.getPageId());
        context.logSdkEvent(AnalyticsEvents.EVENT_SHARE_MESSENGER_DIALOG_SHOW, null, bundle);
    }
}
