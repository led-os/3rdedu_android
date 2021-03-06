package com.disanxuetang.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

import java.util.Arrays;
import java.util.List;

import com.disanxuetang.shortcutbadger.Badger;
import com.disanxuetang.shortcutbadger.ShortcutBadgeException;


/**
 * @author liukui 2018/04/18
 */
public class EverythingMeHomeBadger implements Badger {

    private static final String CONTENT_URI = "content://me.everything.badger/apps";
    private static final String COLUMN_PACKAGE_NAME = "package_name";
    private static final String COLUMN_ACTIVITY_NAME = "activity_name";
    private static final String COLUMN_COUNT = "count";

    @Override
    public void executeBadge(Context context, ComponentName componentName, int badgeCount) throws ShortcutBadgeException  {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PACKAGE_NAME, componentName.getPackageName());
        contentValues.put(COLUMN_ACTIVITY_NAME, componentName.getClassName());
        contentValues.put(COLUMN_COUNT, badgeCount);
        context.getContentResolver().insert(Uri.parse(CONTENT_URI), contentValues);
    }

    @Override
    public List<String> getSupportLaunchers() {
        return Arrays.asList("me.everything.launcher");
    }
}
