# 更新日志
- 18.10.02 v1.5.0
  1. 新增：支持自定义验证码规则，支持规则导入导出
- 18.09.14 v1.4.6
  1. 增加新选项：自动输入成功后清除剪切板内容
  2. “无障碍服务模式” 和 “Root模式” 合并为 “自动输入模式”
  3. 增强在WebView中自动输入验证码的能力
  4. 潜在性的异常修复以及其他BUG修复
- 18.09.02 v1.4.5
  1. 修改App名字
  2. 修复验证码短信中包含小数会解析出错误验证码的BUG
- 18.08.31 v1.4.4
  1. 优化英文短信验证码识别算法
  2. 修复无障碍模式以及手动对焦模式下无法自动输入的BUG
  3. 更新FAQ
- 18.08.20 v1.4.3
  1. 新增功能：两种对焦模式（自动对焦和手动对焦）
  2. 补充完善FAQ
- 18.08.16 v1.4.2
  1. 新增功能：进QQ群反馈交流入口
  2. 补充完善FAQ
- 18.08.15 v1.4.1
  1. 修复BUG：在第三方App未启用的情况下，打开第三方App的空指针异常。
- 18.08.14 v1.4.0
  1. 优化验证码识别算法，提高识别率。
  2. 新加入主题功能
- 18.08.06 v1.3.0
  1. 修复Android 6.0及以下包含自动输入在内的问题
  2. 优化自动输入验证码策略
  3. 加入繁体中文
  4. 添加FAQ（英文版本的没翻译，求翻译w(ﾟДﾟ)w）
  5. 加入调试开关，用以输出log到Xposed（仅调试用）
- 18.07.26 v1.2.1
  1. 优化自动输入的策略
- 18.07.25 v1.2.0
  1. 移除标记为已读功能
  2. 增加短信验证码自动输入功能
  3. 集成友盟统计
- 18.07.11 v1.1.1
  1. Bug fix: Can't create handler inside thread that has not called Looper.prepare().
  2. Bug fix: test-only package cannot be installed
- 18.06.26 v1.0.1 
  1. 自定义短信验证码关键字的正则表达式规则
  2. 添加规则测试功能
- 18.05.27 v0.0.1 
  1. 添加基本功能