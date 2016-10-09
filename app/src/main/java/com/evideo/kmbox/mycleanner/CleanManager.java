/*
 * Copyright (C) 2014-2016  福建星网视易信息系统有限公司
 * All rights reserved by  福建星网视易信息系统有限公司
 * 
 * Modification History:
 * Date        Author      Version     Description
 * -----------------------------------------------
 * 2016/10/9       Whh       1       [修订说明]
 *
 */

package com.evideo.kmbox.mycleanner;


import java.util.ArrayList;

public class CleanManager {

    private static CleanManager sInstance;

    private ArrayList<CleanItem>[] mSimpleCleanLists;
    private ArrayList<CleanItem>[] mDeepCleanLists;

    private ICallBack mCallBack;

    private CleanManager() {}

    public static CleanManager getInstance() {
        if (sInstance == null) {
            synchronized (CleanManager.class) {
                sInstance = new CleanManager();
            }
        }
        return sInstance;
    }

    //初步清理初始化
    public void initSimpleCleanItem() {

    }

    //深度清理初始化
    public void initDeepCleanItem() {

    }

    //界面更新回调
    public void setCallBack(ICallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    public interface ICallBack {
        void updateView();
    }
}
