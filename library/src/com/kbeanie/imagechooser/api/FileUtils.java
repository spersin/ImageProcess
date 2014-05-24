/*******************************************************************************
 * Copyright 2013 Kumar Bibek
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.kbeanie.imagechooser.api;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class FileUtils {
//    public static String getDirectory(String foldername) {
//        File directory = null;
//        directory = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
//                + File.separator + foldername);
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
//        return directory.getAbsolutePath();
//    }

    public static String getDirectory(Context context, String foldername) {
        File storageDir = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            storageDir = context
                    .getExternalFilesDir(foldername);
            if (storageDir != null) {
                if (!storageDir.mkdirs()) {
                    if (!storageDir.exists()) {
                        Log.e("Pictures", "failed to create directory");
                        return null;
                    }
                }
            }

        } else {
            Log.e("", "External storage is not mounted READ/WRITE.");
        }
        return storageDir.getAbsolutePath();
    }

    public static String getFileExtension(String filename) {
        String extension = "";
        try {
            extension = filename.substring(filename.lastIndexOf(".") + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return extension;
    }

}
