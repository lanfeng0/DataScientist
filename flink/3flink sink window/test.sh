#!/bin/bash

# 指定要转换的目录
input_dir="E:\中软大数据\flink视频\flink课程\课件\3flink sink window"

# 遍历目录及子目录下的所有docx文件
find "$input_dir" -name "*.docx" -type f | while read -r file; do
    # 提取文件名（不包含扩展名）
    filename=$(basename "$file" .docx)

    # 创建输出目录
    output_dir="./$filename"
    mkdir -p "$output_dir"

    # 转换docx文件为md文件，并保存图片到输出目录
    pandoc "$file" -o "$output_dir/$filename.md" --extract-media="$output_dir"
done