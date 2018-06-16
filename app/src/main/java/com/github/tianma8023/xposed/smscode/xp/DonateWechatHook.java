package com.github.tianma8023.xposed.smscode.xp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.github.tianma8023.xposed.smscode.constant.IConstants;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Hook Wechat, including: <br/>
 * class com.tencent.mm.ui.LauncherUI <br/>
 * class com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI
 */
public class DonateWechatHook {

    private static final String KEY_SCENE = "key_scene";
    private static final String KEY_QRCODE_URL = "key_qrcode_url";
    private static final String KEY_CHANNEL = "key_channel";

    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (IConstants.WECHAT_PACKAGE_NAME.equals(lpparam.packageName)) {
            try {
                hookLauncherUIOnCreate(lpparam);
                hookQrRewardSelectMoneyUI(lpparam);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Hook com.tencent.mm.ui.LauncherUI#onCreate();
     */
    private void hookLauncherUIOnCreate(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(IConstants.WECHAT_LAUNCHER_UI,
                lpparam.classLoader,
                "onCreate",
                Bundle.class,
                new LauncherUIOnCreateHook());
    }

    private class LauncherUIOnCreateHook extends XC_MethodHook {

        @Override
        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
            Activity activity = (Activity) param.thisObject;
            if (activity != null) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    String className = intent.getComponent().getClassName();
                    boolean hasDonateExtra = intent.hasExtra(IConstants.WECHAT_KEY_EXTRA_DONATE);
                    if (IConstants.WECHAT_LAUNCHER_UI.equals(className) && hasDonateExtra) {
                        intent.removeExtra(IConstants.WECHAT_KEY_EXTRA_DONATE);

                        Intent donateIntent = new Intent();
                        donateIntent.setClassName(activity, IConstants.WECHAT_QR_REWARD_SELECT_MONEY_UI);
                        donateIntent.putExtra(KEY_SCENE, 2);
                        donateIntent.putExtra(KEY_QRCODE_URL, IConstants.WECHAT_QRCODE_URL);
                        donateIntent.putExtra(KEY_CHANNEL, 13);
                        donateIntent.putExtra(IConstants.WECHAT_KEY_EXTRA_DONATE, true);
                        activity.startActivity(donateIntent);
                        activity.finish();
                    }

                }
            }
        }
    }

    /**
     * Hook com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI#onCreate();
     */
    private void hookQrRewardSelectMoneyUI(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod(IConstants.WECHAT_QR_REWARD_SELECT_MONEY_UI,
                lpparam.classLoader,
                "onCreate",
                Bundle.class,
                new QrRewardSelectMoneyUIOnCreateHook());
    }

    private class QrRewardSelectMoneyUIOnCreateHook extends XC_MethodHook {
        @Override
        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
            Activity activity = (Activity) param.thisObject;
            if (activity != null) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    boolean hasDonateExtra = intent.hasExtra(IConstants.WECHAT_KEY_EXTRA_DONATE);
                    if (hasDonateExtra) {
                        String qrCodeUrl = activity.getIntent().getStringExtra(KEY_QRCODE_URL);
                        if (TextUtils.isEmpty(qrCodeUrl)) {
                            intent.putExtra(KEY_QRCODE_URL, IConstants.WECHAT_QRCODE_URL);
                        }
                    }
                }
            }
        }
    }
}
