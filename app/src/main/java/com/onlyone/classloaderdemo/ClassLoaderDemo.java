package com.onlyone.classloaderdemo;

import android.content.Context;

import java.lang.reflect.Field;

import dalvik.system.DexClassLoader;

public class ClassLoaderDemo {

    String dexPath;
    String optimizedDirectory;
    String librarySearchPath;


    public void load(Context context) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Class<?> baseDexClassLoaderClass = Class.forName("dalvik.system.BaseDexClassLoader");
        Field dexPathList = baseDexClassLoaderClass.getDeclaredField("pathList");
        dexPathList.setAccessible(true);

        Class<?> dexPathListClass = Class.forName("dalvik.system.DexPathList");
        Field dexElementsField = dexPathListClass.getDeclaredField("dexElements");
        dexElementsField.setAccessible(true);

        ClassLoader hostClassLoader = context.getClassLoader();
        Object hostPathList = dexPathList.get(hostClassLoader);
        Object[] hostDexElements = (Object[]) dexElementsField.get(hostPathList);


        ClassLoader pluginClassLoader = new DexClassLoader(dexPath, optimizedDirectory, librarySearchPath, context.getClassLoader());
        Object pluginPathList = dexPathList.get(pluginClassLoader);
        Object[] pluginDexElements = (Object[]) dexElementsField.get(pluginPathList);
    }
}
