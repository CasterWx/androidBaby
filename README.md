# androidBaby

android项目：掌心baby

开发工具 ：android studio

1. 开发过程全部使用android6.0（API 23）进行编译，最小版本支持android 4.0 （API 14）。

2. 项目APP所使用的技术包括以下模块		

    项目地址：https://github.com/CasterWx/androidBaby

    功能实现：
      
      1.功能引导页
	在每个Activity的布局文件外层添加一个FrameLayout(这方法好蠢，又要嵌套一层布局)，再将需要显示的引导页布局加在后面(或用include的方式)，写两个方法，获取和设置是否显示了该引导页的判断，存储到SharedPreferences。最后在对应Activity页面添加对应控制引导页显隐的逻辑。
      2.启动页
	设置 SplashActivity 为启动页并将其全屏，之后在 SpalshActivity 中贴上背景图就行了。首先在 style.xml 文件中创建全屏的主题属性。

	<style name="AppTheme.NoActionBar">			
		<item name="windowActionBar">false</item>	
		<item name="windowNoTitle">true</item>
	</style>

	<style name="AppTheme.Full" parent="AppTheme.NoActionBar">
		<item name="android:windowFullscreen">true</item>
	</style>
	然后在 AndroidManifest.xml 中使用
	<activity android:name=".SplashActivity" android:theme="@style/AppTheme.Full">
		<intent-filter>								
			<action android:name="android.intent.action.MAIN" />
			<category android:name="android.intent.category.LAUNCHER" />	
		</intent-filter>
	</activity> 
      3.登录注册（第三方登录）
	对于需要获取用户登录状态的操作，先判断用户是否已经登录。
	如果用户已经登录，则继续后面的操作，否则，跳转到登录页面进行登录。
	如果已经有账号，则可以直接登录，或者可以直接选择第三方平台授权登录。
	如果还没有账号，则需要先进行账号注册，注册成功后再登录；也可以不注册账号，通过第三方平台授权进行登录。
	如果有账号，但忘记密码，可以重置密码，否则直接登录。

      4.忘记密码/修改密码
	数据库中添加了两张表，一张表用来存储用户信息，诸如用户名，密码，手机号等，可任意添加。另一张表用来存储上一个登录用户的账户信息，为了方便才创建了一张表去存储，而且这张表设计了它只能存储一条信息，实现忘记/修改密码功能，每次的存储都是对上一条记录的覆盖。
      5.网络请求（开源库）
	Volley库：扩展性强，基于接口设计。一定程度上符合http规范。返回包括ResponseCode 的处理，请求头的处理，缓存机制的支持。重试以及优先级的定义。2.3版本以上基于HttpUrlconnection。2.3版本以下是Httpclient。提供简单的图片加载工具。
      6.数据解析
											
      7.数据存储（SQL/SP/File）

      8.图片异步加载（开源库）

      9.清除缓存

      10.账号绑定（同3）

      11.家长社区功能

      12.关于我们

      13.正则表达式工具

      14.轮播bannner

      15.加密（Base64/MD5）

      16.日志处理

      17.圆形头像

      18.圆角图片

      19.网络检查

      20.下拉刷新（开源库）

      21.底部加载更多

      22.跳转设置页

      23.通用json解析

      24.通用xml解析

      25.下拉刷新最新解决方案（swipelayout+Reclerview）

      26.网络框架

      27.通用adapter

      28.通用popupWindow

      29.通用webview

      30.gridView自适应

      31.ListView实现GridView两列效果

      32.解决GridView显示不全

      33.ScrollView嵌套ListView

      34.地区三级联动
