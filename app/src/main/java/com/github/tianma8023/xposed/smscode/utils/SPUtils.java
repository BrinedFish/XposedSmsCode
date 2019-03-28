package com.github.tianma8023.xposed.smscode.utils;

import com.crossbowffs.remotepreferences.RemotePreferences;
import com.github.tianma8023.xposed.smscode.constant.PrefConst;

import static com.github.tianma8023.xposed.smscode.utils.RemotePreferencesUtils.getBoolean;
import static com.github.tianma8023.xposed.smscode.utils.RemotePreferencesUtils.getInt;
import static com.github.tianma8023.xposed.smscode.utils.RemotePreferencesUtils.getString;
import static com.github.tianma8023.xposed.smscode.utils.RemotePreferencesUtils.putInt;
import static com.github.tianma8023.xposed.smscode.utils.RemotePreferencesUtils.putString;

public class SPUtils {

    private static final String KEY_AUTO_INPUT_MODE_ACCESSIBILITY = "pref_auto_input_mode_accessibility";
    private static final boolean AUTO_INPUT_MODE_ACCESSIBILITY_DEFAULT = false;
    private static final String KEY_AUTO_INPUT_MODE_ROOT = "pref_auto_input_mode_root";
    private static final boolean AUTO_INPUT_MODE_ROOT_DEFAULT = false;

    // 本地的版本号
    private static final String LOCAL_VERSION_CODE = "local_version_code";
    private static final int LOCAL_VERSION_CODE_DEFAULT = 16;

    private SPUtils() {

    }

    /**
     * 总开关是否打开
     */
    public static boolean isEnabled(RemotePreferences preferences) {
        return getBoolean(preferences, PrefConst.KEY_ENABLE, PrefConst.ENABLE_DEFAULT);
    }

    /**
     * 日志模式是否是verbose log模式
     */
    public static boolean isVerboseLogMode(RemotePreferences preferences) {
        return getBoolean(preferences,
                PrefConst.KEY_VERBOSE_LOG_MODE, PrefConst.VERBOSE_LOG_MODE_DEFAULT);
    }

    /**
     * 自动输入总开关是否打开
     */
    public static boolean autoInputCodeEnabled(RemotePreferences preferences) {
        return getBoolean(preferences,
                PrefConst.KEY_ENABLE_AUTO_INPUT_CODE, PrefConst.ENABLE_AUTO_INPUT_CODE_DEFAULT);
    }

    /**
     * 自动输入模式是否是root模式
     */
    public static boolean isAutoInputRootMode(RemotePreferences preferences) {
        return getBoolean(preferences,
                KEY_AUTO_INPUT_MODE_ROOT, AUTO_INPUT_MODE_ROOT_DEFAULT);
    }

    /**
     * 自动输入模式是否是无障碍模式(仅用于兼容之前版本)
     */
    public static boolean isAutoInputAccessibilityMode(RemotePreferences preferences) {
        return getBoolean(preferences,
                KEY_AUTO_INPUT_MODE_ACCESSIBILITY, AUTO_INPUT_MODE_ACCESSIBILITY_DEFAULT);
    }


    /**
     * 设置自动输入模式
     */
    public static void setAutoInputMode(RemotePreferences preferences, String autoInputMode) {
        putString(preferences, PrefConst.KEY_AUTO_INPUT_MODE, autoInputMode);
    }

    /**
     * 获取自动输入模式
     */
    public static String getAutoInputMode(RemotePreferences preferences) {
        return getString(preferences,
                PrefConst.KEY_AUTO_INPUT_MODE, PrefConst.AUTO_INPUT_MODE_DEFAULT);
    }

    /**
     * 是否应该在自动输入成功之后清理剪切板
     */
    public static boolean shouldClearClipboard(RemotePreferences preferences) {
        return getBoolean(preferences,
                PrefConst.KEY_CLEAR_CLIPBOARD, PrefConst.CLEAR_CLIPBOARD_DEFAULT);
    }

    /**
     * 是否应该在复制验证码到系统剪切板之后显示Toast
     */
    public static boolean shouldShowToast(RemotePreferences preferences) {
        return getBoolean(preferences,
                PrefConst.KEY_SHOW_TOAST, PrefConst.SHOW_TOAST_DEFAULT);
    }

    /**
     * 获取对焦模式
     */
    public static String getFocusMode(RemotePreferences preferences) {
        return getString(preferences, PrefConst.KEY_FOCUS_MODE, PrefConst.FOCUS_MODE_AUTO);
    }

    /**
     * 获取短信验证码关键字
     */
    public static String getSMSCodeKeywords(RemotePreferences preferences) {
        return getString(preferences, PrefConst.KEY_SMSCODE_KEYWORDS, PrefConst.SMSCODE_KEYWORDS_DEFAULT);
    }

    /**
     * 获取本地记录的版本号
     */
    public static int getLocalVersionCode(RemotePreferences preferences) {
        // 如果不存在,则默认返回16,即v1.4.5版本
        return getInt(preferences, LOCAL_VERSION_CODE, LOCAL_VERSION_CODE_DEFAULT);
    }

    /**
     * 设置当前版本号
     */
    public static void setLocalVersionCode(RemotePreferences preferences, int versionCode) {
        putInt(preferences, LOCAL_VERSION_CODE, versionCode);
    }

    /**
     * Get current theme index
     */
    public static int getCurrentThemeIndex(RemotePreferences preferences) {
        return getInt(preferences, PrefConst.KEY_CURRENT_THEME_INDEX,
                PrefConst.CURRENT_THEME_INDEX_DEFAULT);
    }

    /**
     * Set current theme index
     */
    public static void setCurrentThemeIndex(RemotePreferences preferences, int curIndex) {
        putInt(preferences, PrefConst.KEY_CURRENT_THEME_INDEX, curIndex);
    }


    /**
     * 标记为已读是否打开
     */
    public static boolean markAsReadEnabled(RemotePreferences preferences) {
        return getBoolean(preferences,
                PrefConst.KEY_MARK_AS_READ, PrefConst.MARK_AS_READ_DEFAULT);
    }

    /**
     * 是否删除验证码短信
     */
    public static boolean deleteSmsEnabled(RemotePreferences preferences) {
        return getBoolean(preferences,
                PrefConst.KEY_DELETE_SMS, PrefConst.DELETE_SMS_DEFAULT);
    }

    /**
     * 是否复制到剪切板
     */
    public static boolean copyToClipboardEnabled(RemotePreferences preferences) {
        return getBoolean(preferences,
                PrefConst.KEY_COPY_TO_CLIPBOARD, PrefConst.COPY_TO_CLIPBOARD_DEFAULT);
    }

    /**
     * 是否在自动对焦失败后转为手动对焦
     */
    public static boolean manualFocusIfFailedEnabled(RemotePreferences preferences) {
        return getBoolean(preferences,
                PrefConst.KEY_MANUAL_FOCUS_IF_FAILED, PrefConst.MANUAL_FOCUS_IF_FAILED_DEFAULT);
    }

    /**
     * 是否记录短信验证码
     */
    public static boolean recordSmsCodeEnabled(RemotePreferences preferences) {
        return getBoolean(preferences,
                PrefConst.KEY_ENABLE_CODE_RECORDS, PrefConst.ENABLE_CODE_RECORDS_DEFAULT);
    }

    /**
     * 是否拦截短信通知
     */
    public static boolean blockSmsEnabled(RemotePreferences preferences) {
        return getBoolean(preferences,
                PrefConst.KEY_BLOCK_SMS, PrefConst.BLOCK_SMS_DEFAULT);
    }

    /**
     * 验证码提取成功后是否杀掉模块进程
     */
    public static boolean killMeEnabled(RemotePreferences preferences) {
        return getBoolean(preferences, PrefConst.KEY_KILL_ME, PrefConst.KILL_ME_DEFAULT);
    }
}
