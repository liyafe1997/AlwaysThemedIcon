# English

[简体中文](#%E7%AE%80%E4%BD%93%E4%B8%AD%E6%96%87-simplified-chinese)

[![Download](https://img.shields.io/github/downloads/liyafe1997/AlwaysThemedIcon/total)](https://github.com/liyafe1997/AlwaysThemedIcon/releases)
## Introduction

This module can let third party launcher always use icons with MIUI Themes. It may also work with other custom Android based OS, if they have the same logic of the theme and icon stuff.

The left one is Apex Launcher without this module, the right one is with this module enabled.

  <img src="https://user-images.githubusercontent.com/18359157/178597526-098630d7-13bb-4f01-ae04-30f91e286922.jpg" width="35%">   <img src="https://user-images.githubusercontent.com/18359157/178597503-bf5f0027-4ad6-45be-b561-e8bfc65f2790.jpg" width="35%"> 

## How does it works
This module only do one thing: Hook "android.content.pm.LauncherActivityInfo.getIcon" method, set the argument(int denisty, aka DPI) to 0. So the method will load icon with MIUI theme.

I think this is a feature instead of a bug of MIUI, since the icons in these Themes are fixed DPI, so if you request a specific DPI the system will try to get the most similar DPI icon from the "Resources" of the app package, because App developer usually put icons with different DPI in the Resouces. 

## How to apply this module
Install it, enable it in Xposed (I only tested with LSPosed). and **make sure your launcher is enabled in the scope of this module in LSPosed**. Then reboot.

Another important thing is, most launchers have icon cache, so even you have this module enabled, it still shows the original icon. You have to try to refresh the icon cache of your launch. The most common way is install a icon pack that supported by your launcher, switch to it and then switch back to "None" or "System Icon" or something. Or try to modify some settings, E.g. icon size, icon shape or soemthing. Also can try the Android's "Clean Cache" feature.

But as I test with Apex Launcher, these methods doesn't take effort. Seems with Apex Launcher the only way is do a backup and restore...Or just clean data, but your desktop layout and settings will be lost...



# 简体中文 (Simplified Chinese)

## 介绍
这个模块是让第三方Launcher的图标也能使用MIUI的主题图标。也许在其它第三方Android OS上也起作用，如果他们也用同样的方法来处理主题和图标的话。

以下左图是Apex Launcher，没安装模块只能显示App原始图标，右图为安装了该模块，可以显示MIUI的主题图标

  <img src="https://user-images.githubusercontent.com/18359157/178597526-098630d7-13bb-4f01-ae04-30f91e286922.jpg" width="35%">   <img src="https://user-images.githubusercontent.com/18359157/178597503-bf5f0027-4ad6-45be-b561-e8bfc65f2790.jpg" width="35%"> 
  
## 工作原理
 
这个模块只干一件事情：Hook "android.content.pm.LauncherActivityInfo.getIcon" 方法，把第一个参数（这个参数是int denisty, 意为图标DPI）设为0。然后这个方法就会加载带主题的图标。
 
这应该是一个feature，不是bug，因为MIUI主题里的图标DPI都是固定的，所以如果想通过这个API请求一个指定DPI的图标，那么系统就会尝试直接从App的Resources里读取最相近的图标，因为开发者一般会放入不同DPI的图标。

## 如何使用
安装该模块，在Xposed中启用（我只在LSPosed上测试了），并且**在作用域中勾上你的Launcher**，然后重启

还有一个重要的事情是，大部分Launcher都有图标缓存，所以即使你启用了这个模块，但Launcher没有刷新图标缓存，所以还是显示原来的图标。你得想办法去刷新图标缓存，一种最简单的可以尝试的方法是装一个与你的Launcher兼容的第三方图标包，然后切换到这个图标包，再切回“无”或者“系统图标”之类的，让它刷新图标缓存。也可以尝试一些设置比如改变图标大小，图标形状之类的，也可以尝试Android的“清除缓存”功能。

但我在Apex Launcher上试了，上述方法都不管用。。。看起来在Apex上只能用备份还原功能来刷新缓存，或者直接清除应用数据，但这样你的桌面布局和设置就没了。。。如果用上面的方法无法刷新缓存，又不想清数据，只能自己想想办法了。
