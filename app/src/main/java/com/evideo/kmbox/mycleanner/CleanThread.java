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

import android.content.Context;

import com.evideo.kmbox.mycleanner.util.FileUtil;

import java.util.ArrayList;

public class CleanThread extends Thread {

    private Context mContext;
    private ArrayList<CleanItem>[] mCleanLists;

    public CleanThread(Context mContext, ArrayList<CleanItem>[] mCleanLists) {
        this.mContext = mContext;
        this.mCleanLists = mCleanLists;
    }

    @Override
    public void run() {
        super.run();
        if (mCleanLists == null) {
            return;
        }

        int size = mCleanLists.length;
        for (int i=0; i<size; i++) {
            int len = mCleanLists[i].size();
            for (int j=len; j>=0; j--) {
                if (mCleanLists[i].get(j).getState() == 1) {
                    //删除该项，从列表中移除此项，更新界面
                    FileUtil.deleteDir(mCleanLists[i].get(j).getPath());
                    mCleanLists[i].remove(j);
                    /**更新界面*/
                }
            }
        }
    }


}
