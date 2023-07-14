package org.example.week3.day18;

import java.io.File;
import java.io.FilenameFilter;

//文件名过滤器
public class FilterByFileName implements FilenameFilter {
    private String endStr;

    public FilterByFileName(String endStr) {
        super();
        this.endStr = endStr;
    }

    /**
     * 把满足条件的查出来
     */

    @Override
    public boolean accept(File dir, String name) {
        boolean b = name.endsWith(endStr);
        return b;
    }

}
