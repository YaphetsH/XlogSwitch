package com.yaphets.xlogswitch;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;


/**
 * Created by Yaphets on 2018/4/7.
 */

public class HookEntry implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals("com.tencent.mm")) {
            //get Context with classloader


            findAndHookMethod(Application.class, "attach", Context.class, new XC_MethodHook() {
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    ClassLoader classLoader = ((Context) param.args[0]).getClassLoader();
                    hookLog(classLoader);

                }
            });
        }
    }

    public void hookLog(ClassLoader cld) {
        Class clz = XposedHelpers.findClass("com.tencent.mm.sdk.platformtools.x", cld);
        //level switch
        XposedHelpers.setStaticIntField(clz, "level", 0);

        XposedHelpers.findAndHookMethod("com.tencent.mm.network.t", cld, "bJ",
                Boolean.TYPE, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        param.args[0] = false;
                        Log.d("CESHI","Success bJ");
                    }
                });
        XposedHelpers.findAndHookMethod("com.tencent.mm.network.t", cld, "KF",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        Log.d("CESHI","Success KF");
                    }
                });
//        XposedHelpers.findAndHookMethod("com.tencent.mm.network.t", cld, "KF",
//                new XC_MethodReplacement() {
//                    @Override
//                    protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
//
//                            Log.d("CESHI","Success KF");
//                           return null;
//
//
//                    }
//                });

                XposedHelpers.findAndHookMethod("com.tencent.mars.xlog.Xlog", cld, "setConsoleLogOpen",
                        Boolean.TYPE, new XC_MethodHook() {
                            @Override
                            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                param.args[0] = true;
                            }
                        });

        XposedHelpers.findAndHookMethod("com.tencent.mm.sdk.platformtools.x", cld, "f",
                String.class, String.class, Object[].class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        String str = (String) param.args[0];
                        String str2 = (String) param.args[1];
                        Object[] objArr = (Object[]) param.args[2];
                        String format = objArr == null ? str2 : String.format(str2, objArr);

                        Log.d(  str, format);
                    }
                });

        XposedHelpers.findAndHookMethod("com.tencent.mm.sdk.platformtools.x", cld, "e",
                String.class, String.class, Object[].class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        String str = (String) param.args[0];
                        String str2 = (String) param.args[1];
                        Object[] objArr = (Object[]) param.args[2];
                        String format = objArr == null ? str2 : String.format(str2, objArr);

                        Log.d( str, format);
                    }
                });
        XposedHelpers.findAndHookMethod("com.tencent.mm.sdk.platformtools.x", cld, "w",
                String.class, String.class, Object[].class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        String str = (String) param.args[0];
                        String str2 = (String) param.args[1];
                        Object[] objArr = (Object[]) param.args[2];
                        String format = objArr == null ? str2 : String.format(str2, objArr);

                        Log.d(  str, format);
                    }
                });
        XposedHelpers.findAndHookMethod("com.tencent.mm.sdk.platformtools.x", cld, "i",
                String.class, String.class, Object[].class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        String str = (String) param.args[0];
                        String str2 = (String) param.args[1];
                        Object[] objArr = (Object[]) param.args[2];
                        String format = objArr == null ? str2 : String.format(str2, objArr);

                        Log.d( str, format);
                    }
                });
        XposedHelpers.findAndHookMethod("com.tencent.mm.sdk.platformtools.x", cld, "d",
                String.class, String.class, Object[].class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        String str = (String) param.args[0];
                        String str2 = (String) param.args[1];
                        Object[] objArr = (Object[]) param.args[2];
                        String format = objArr == null ? str2 : String.format(str2, objArr);

                        Log.d( str, format);
                    }
                });
        XposedHelpers.findAndHookMethod("com.tencent.mm.sdk.platformtools.x", cld, "v",
                String.class, String.class, Object[].class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        String str = (String) param.args[0];
                        String str2 = (String) param.args[1];
                        Object[] objArr = (Object[]) param.args[2];
                        String format = objArr == null ? str2 : String.format(str2, objArr);

                        Log.d( str, format);
                    }
                });
        XposedHelpers.findAndHookMethod("com.tencent.mm.sdk.platformtools.x", cld, "j",
                String.class, String.class, Object[].class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        String str = (String) param.args[0];
                        String str2 = (String) param.args[1];
                        Object[] objArr = (Object[]) param.args[2];
                        String format = objArr == null ? str2 : String.format(str2, objArr);

                        Log.d( str, format);
                    }
                });
        XposedHelpers.findAndHookMethod("com.tencent.mm.sdk.platformtools.x", cld, "k",
                String.class, String.class, Object[].class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        String str = (String) param.args[0];
                        String str2 = (String) param.args[1];
                        Object[] objArr = (Object[]) param.args[2];
                        String format = objArr == null ? str2 : String.format(str2, objArr);

                        Log.d(str, format);
                    }
                });
                }


}
