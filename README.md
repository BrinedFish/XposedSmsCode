# XposedSmsCode
A Xposed Module which can recognize ,parse SMS code and copy it to clipboard when a new message arrives.It can also auto-input SMS code. / 识别短信验证码的Xposed模块，并将验证码拷贝到剪切板，亦可以自动输入验证码。

<img src="ss/ss_01.png" width="180"/><img src="ss/ss_02.jpg" width="180"/><img src="ss/ss_03.jpg" width="180"/><img src="ss/ss_04.jpg" width="180"/><img src="ss/ss_05.jpg" width="180"/>

You can download this module on [Xposed Repository](http://repo.xposed.info/module/com.github.tianma8023.xposed.smscode) or [Coolapk](https://www.coolapk.com/apk/com.github.tianma8023.xposed.smscode). 

可以在 [Xposed仓库](http://repo.xposed.info/module/com.github.tianma8023.xposed.smscode) 或者 [酷安](https://www.coolapk.com/apk/com.github.tianma8023.xposed.smscode) 下载此模块。

# Usage / 使用
1. Root your device and install Xposed Framework. / Root你的设备，安装Xposed框架
2. Install and activite this xposed module and then reboot. / 安装本模块，激活并重启
3. Have fun!

Welcome any feedbacks. / 欢迎反馈，欢迎提出意见或建议。

# Attention / 注意
**This module is suitable for AOSP ROM, it may not work well on other 3rd-party Rom. / 此模块适用于偏原生的系统，其他第三方定制Rom可能不适用。**

**Compatibility: Requires Android 4.4+ (api level ≥ 19). / 兼容性：兼容 Android 4.4及以上（api等级≥19）设备。**

# Features / 功能
- Copy verification code to clipboard when a new message arrives. / 收到验证码短信后将验证码复制到系统剪贴板
- Show toast when a SMS verification code is copied. / 当验证码被复制后显示Toast
- <s>Mark verification code message as read (experimental). / 将验证码短信标记为已读（实验性）</s>
- Custom keywords about verification code message (regular expressions allowed). / 自定义验证码短信关键字（正则表达式）
- Auto-input SMS code. / 自动输入验证码

# Logs / 更新日志
- 18.08.20 v1.4.3
  1. Add feature: two Focus Modes(Auto mode, Manual mode) / 新增功能：两种对焦模式（自动对焦和手动对焦）
  2. Add more FAQs. / 补充完善FAQ
- 18.08.16 v1.4.2
  1. Add feature: join QQ group for communication and bug report. / 新增功能：进QQ群反馈交流入口
  2. Add more FAQs. / 补充完善FAQ
- 18.08.15 v1.4.1
  1. Bug fix: NullPointerException while starting 3rd party app if it isn't installed or enabled. / 修复BUG：在第三方App未启用的情况下，打开第三方App的空指针异常。
- 18.08.14 v1.4.0
  1. Optimize the algorithm of parsing SMS code. / 优化验证码识别算法，提高识别率。
  2. New feature: theme. / 新加入主题功能
- 18.08.06 v1.3.0
  1. Bug fix: Auto-input bug (below Android 6.0) / 修复Android 6.0及以下包含自动输入在内的问题
  2. Optimize the strategy of auto-input / 优化自动输入验证码策略
  3. Add new language: Traditional Chinese / 加入繁体中文
  4. Add FAQs(Sorry for my poor English, there is no english version now, u can contact me on Github if u can help me translate it into English) / 添加FAQ（英文版本的没翻译，求翻译w(ﾟДﾟ)w）
  5. Add a switch for verbose logging(Only for debug) / 加入调试开关，用以输出log到Xposed（仅调试用）
- 18.07.26 v1.2.1
  1. Optimize the strategy of Auto-input. / 优化自动输入的策略
- 18.07.25 v1.2.0
  1. Remove the feature of marking SMS as read. / 移除标记为已读功能
  2. Add the feature of Auto-Input SMS code. / 增加短信验证码自动输入功能
  3. Integrate UMeng analyze tools. / 集成友盟统计
- 18.07.11 v1.1.1
  1. Bug fix: Can't create handler inside thread that has not called Looper.prepare().
  2. Bug fix: test-only package cannot be installed
- 18.06.26 v1.0.1 
  1. Custom SMS code keywords rules of regular expressions. / 自定义短信验证码关键字的正则表达式规则
  2. SMS code test feature added. / 添加规则测试功能
- 18.05.27 v0.0.1 Basic funtions added. / 添加基本功能

# Thanks / 感谢
- [NekoSMS](https://github.com/apsun/NekoSMS)
- [SmsCodeHelper](https://github.com/drakeet/SmsCodeHelper)
- [ButterKnife](https://github.com/JakeWharton/butterknife)
- [Remote Preferences](https://github.com/apsun/RemotePreferences)
- [Material Dialogs](https://github.com/afollestad/material-dialogs)
- [Android Shell](https://github.com/jaredrummler/AndroidShell)

# License / 协议
All code is licensed under [GPLv3](https://www.gnu.org/licenses/gpl-3.0.txt) 

所有的源码均遵循 [GPLv3](https://www.gnu.org/licenses/gpl-3.0.txt) 协议