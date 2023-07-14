package org.example.week3.day18;

import java.io.File;
import java.io.FileFilter;

/**
 * 这是一个实现了FileFilter接口的FilterByHidden类，用于过滤出某文件夹下的非隐藏文件。
 *
 * FileFilter接口是Java IO包中的一个接口，用于过滤文件和目录。它包含一个方法boolean accept(File file)，用于确定指定文件（或目录）是否应该包含在过滤结果中。
 *
 * 在FilterByHidden类中，accept(File file)方法被实现如下：
 *
 * public boolean accept(File file) {
 *     boolean b = file.isHidden();
 *     return !b;
 * }
 * 该方法用于判断给定的文件对象file是否是隐藏文件。通过调用file.isHidden()方法，可以获取文件是否被标记为隐藏。如果文件是隐藏的，则返回false，表示该文件不应该包含在过滤结果中；如果文件不是隐藏的，则返回true，表示该文件应该包含在过滤结果中。
 *
 * 通过使用FilterByHidden类，可以过滤掉某文件夹中的隐藏文件，只返回非隐藏文件。
 *
 * 以下是一个示例用法：
 *
 * File folder = new File("path/to/folder");
 * File[] files = folder.listFiles(new FilterByHidden());
 * for (File file : files) {
 *     System.out.println(file.getName());
 * }
 * 上述代码将会列出路径为path/to/folder文件夹中的所有非隐藏文件的名字。
 */
public class FilterByHidden implements FileFilter {

    /**
     * 列出某文件夹下的非隐藏文件
     */
    public boolean accept(File file) {
        boolean b = file.isHidden();
        return !b;
    }

}
