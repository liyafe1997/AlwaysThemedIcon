package com.strawing.alwaysthemedicon;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.XposedBridge;

public class MainModule implements IXposedHookZygoteInit {

    @Override
    public void initZygote(IXposedHookZygoteInit.StartupParam startParam) {
        XposedHelpers.findAndHookMethod("android.content.pm.LauncherActivityInfo", null, "getIcon", int.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                try {
                    param.args[0] = 0;
                } catch (Exception e) {
                    XposedBridge.log("AlwaysThemedIcon Error: No arg in getIcon");
                }
            }

        });

    }

}
