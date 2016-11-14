package com.onlyone.common.widget.newbieguide;

import com.onlyone.common.util.AppUtils;
import com.onlyone.common.util.PreferencesUtils;

/**
 * 创建者：许方镇
 * 日期：2016/8/16
 * 功能模块：用于管理guideview是否显示的key管理类
 */
public class GuideTypeManager {

    public static final String TAG = "guide_view";
    public static final String GUIDE_VERSION = "guide_version";

    public static final int TYPE_ACTIVITY = 0;//活动引导
    public static final int TYPE_COLLECT = TYPE_ACTIVITY + 1;//收藏引导
    public static final int TYPE_CATEGORY = TYPE_COLLECT + 1;//分类末级页引导
    public static final int TYPE_BRAND_1 = TYPE_CATEGORY + 1;//brand滑动定位引导
    public static final int TYPE_BRAND_2 = TYPE_BRAND_1 + 1;//c区出现引导
    public static final int TYPE_GOODS_DETAIL_COLOR_SKU = TYPE_BRAND_2 + 1;//详情页sku颜色查看按钮
    public static final int TYPE_GOODS_DETAIL_COLOR_SKU_SHOWED = TYPE_GOODS_DETAIL_COLOR_SKU + 1;//详情页sku颜色查看出现过
    public static final int TYPE_GOODS_DETAIL_KOALA_FAQ_SHOWED = TYPE_GOODS_DETAIL_COLOR_SKU_SHOWED + 1;//详情页小考拉答疑FAQ
    public static final int TYPE_AFTER_SALE_BELOW = TYPE_GOODS_DETAIL_KOALA_FAQ_SHOWED + 1;//订单管理售后引导
    public static final int TYPE_AFTER_SALE_ABOVE = TYPE_AFTER_SALE_BELOW + 1;
    public static final int TYPE_COMMENT_LAST_SHOW_TIME = TYPE_AFTER_SALE_ABOVE + 1;
    public static final int TYPE_HOME_ALBUM = TYPE_COMMENT_LAST_SHOW_TIME + 1;//首页新手引导
    public static final int TYPE_SEARCH = TYPE_HOME_ALBUM + 1;//搜索页面
    public static final int TYPE_ALBUMS = TYPE_SEARCH + 1;//专辑详情页面
    public static final int TYPE_COUNT = TYPE_ALBUMS + 1;//总数，必须在最后

    /**
     * @param type 新手引导浮层类型
     * @return 从没显示过，则为true；显示过，则为false
     */
    public static boolean isNeverShowed(int type) {
        if (AppUtils.getVersionCode() != PreferencesUtils.getInt(GUIDE_VERSION, -1)) {
            PreferencesUtils.putInt(GUIDE_VERSION, AppUtils.getVersionCode());
            for (int i = 0; i < TYPE_COUNT; i++) {
                PreferencesUtils.putBoolean(TAG + i, true);
            }
        }
        return PreferencesUtils.getBoolean(TAG + type, true);
    }
}
