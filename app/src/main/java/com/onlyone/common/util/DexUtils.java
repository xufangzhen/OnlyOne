package com.onlyone.common.util;

import android.content.Context;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class DexUtils {


    public static void load2(Context context) {
        try {

            Field dexPathListField = BaseDexClassLoader.class.getDeclaredField("pathList");
            dexPathListField.setAccessible(true);

            Class<?> dexPathList = Class.forName("dalvik.system.DexPathList");
            Field dexElementsField = dexPathList.getDeclaredField("dexElements");
            dexElementsField.setAccessible(true);

            //Main dexElements
            PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
            Object mainDexPathListObject = dexPathListField.get(pathClassLoader);
            Object[] mainDexElementsObjects = (Object[]) dexElementsField.get(mainDexPathListObject);

            //Sub dexElements
            String dexPath = context.getFilesDir().toString() + "/app-debug.apk";
            ClassLoader dexClassLoader = new DexClassLoader(dexPath, context.getCacheDir().getAbsolutePath(), null, context.getClassLoader());
            Object subDexPathListObject = dexPathListField.get(dexClassLoader);
            Object[] subDexElementsObjects = (Object[]) dexElementsField.get(subDexPathListObject);


            Object[] newDexElements = (Object[]) Array.newInstance(mainDexElementsObjects.getClass().getComponentType(), mainDexElementsObjects.length + subDexElementsObjects.length);

//            Object[] newDexElements = new Object[mainDexElementsObjects.length + subDexElementsObjects.length];
            System.arraycopy(mainDexElementsObjects, 0, newDexElements, 0, mainDexElementsObjects.length);
            System.arraycopy(subDexElementsObjects, 0, newDexElements, mainDexElementsObjects.length, subDexElementsObjects.length);

            dexElementsField.set(mainDexPathListObject, newDexElements);

        } catch (Exception e) {
        }
    }

//
//    public static void load(Context context) {
//        //Main dexElements
//        Object[] mainDexElementsObjects = getDexElements(context,);
//        //Sub dexElements
//
//        String dexPath = context.getFilesDir().toString() + "/app-debug.apk";
//        PathClassLoader pathClassLoader = new PathClassLoader(dexPath, DexUtils.class.getClassLoader().getParent());
//        Object[] subDexElementsObjects = getDexElements(context, (Class<BaseDexClassLoader>) pathClassLoader.getParent().getClass());
//
//        Object[] newDexElements = new Object[mainDexElementsObjects.length + subDexElementsObjects.length];
//
//        System.arraycopy(mainDexElementsObjects, 0, newDexElements, 0, mainDexElementsObjects.length);
//        System.arraycopy(subDexElementsObjects, 0, newDexElements, mainDexElementsObjects.length, subDexElementsObjects.length);
//    }
//
//
//    private static Object[] getDexElements(Context context,Class<>) {
//        Object[] dexElementsObjects = null;
//        try {
//            Field dexPathListField = classLoader.getClass().getDeclaredField("pathList");
//            dexPathListField.setAccessible(true);
//            Object dexPathListObject = dexPathListField.get(context.getClassLoader());
//
//            Field dexElementsField = dexPathListObject.getClass().getDeclaredField("dexElements");
//            dexElementsObjects = (Object[]) dexElementsField.get(dexPathListObject);
//
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return dexElementsObjects;
//    }


}
