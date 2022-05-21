package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JavaFileUtil {

    /**
     * 找到文件夹根目录下的所有文件的路径
     */
    public static List<String> getAllFilePaths(String path) {
        List<String> resultFileName = new ArrayList<>();
        File file = new File(path);
        File[] files = file.listFiles();
        if (files == null)
            return resultFileName;// 判断目录下是不是空的
        for (File f : files) {
            if (f.isDirectory()) {// 判断是否文件夹
                //resultFileName.add(f.getPath());
                resultFileName.addAll(getAllFilePaths(f.toString()));// 调用自身,查找子目录
            } else
                resultFileName.add(f.getPath());
        }
        return resultFileName;
    }
}
