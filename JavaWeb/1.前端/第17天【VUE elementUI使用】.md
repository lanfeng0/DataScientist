# 第3天【VUE elementUI使用】

## 主要内容

1.  安装elementUI
2.  使用elementUI

## 学习目标

| 节数                      | 知识点               | 要求 |
|---------------------------|----------------------|------|
| 第一节（安装element-ui）  | Element UI的引入方式 | 掌握 |
| 第二节（使用element -ui） | Element UI的使用     | 掌握 |

## 第一节 安装element-ui

### npm安装

推荐使用 npm 的方式安装，它能更好地和 [webpack](https://webpack.js.org/) 打包工具配合使用。

npm i element-ui -S

### 1.2 CDN安装

目前可以通过 [unpkg.com/element-ui](https://unpkg.com/element-ui/) 获取到最新版本的资源，在页面上引入 js 和 css 文件即可开始使用。

\<!-- 引入样式 --\>

\<link

rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css"\>

\<!-- 引入组件库 --\>

\<script src="https://unpkg.com/element-ui/lib/index.js"\>\</script\>

## 1.3 CDN 安装代码案例

\<!-- import JavaScript --\>

\<script src="https://unpkg.com/element-ui/lib/index.js"\>\</script\>

\<script\>

new Vue({

el: '\#app',

data: function() {

return { visible: false }

}

})

\</script\>\</html\>

## 1.4 完整引入

## 在 main.js 中写入以下内容：

import Vue from 'vue';

import ElementUI from 'element-ui';

import 'element-ui/lib/theme-chalk/index.css';

import App from './App.vue';

Vue.use(ElementUI);

new Vue({

el: '\#app',

render: h =\> h(App)

});

以上代码便完成了 Element 的引入。需要注意的是，样式文件需要单独引入。

## 1.5 按需引入

借助 [babel-plugin-component](https://github.com/QingWei-Li/babel-plugin-component)，我们可以只引入需要的组件，以达到减小项目体积的目的。

首先，安装 babel-plugin-component：

npm install babel-plugin-component -D

然后，将 .babelrc 修改为：

{

"presets": [["es2015", { "modules": false }]],

"plugins": [

[

"component",

{

"libraryName": "element-ui",

"styleLibraryName": "theme-chalk"

}

]

]

}

接下来，如果你只希望引入部分组件，比如 Button 和 Select，那么需要在 main.js 中写入以下内容：

import Vue from 'vue';

import { Button, Select } from 'element-ui';

import App from './App.vue';

Vue.component(Button.name, Button);

Vue.component(Select.name, Select);

/\* 或写为

\* Vue.use(Button)

\* Vue.use(Select)

\*/

new Vue({

el: '\#app',

render: h =\> h(App)

});

## 1.5 全局配置

**1.5.1 配置**

在引入 Element 时，可以传入一个全局配置对象。该对象目前支持 size 与 zIndex 字段。size 用于改变组件的默认尺寸，zIndex 设置弹框的初始 z-index（默认值：2000）。按照引入 Element 的方式，具体操作如下：

**1.5.2 完整引入 Element：**

import Vue from 'vue';

import Element from 'element-ui';

Vue.use(Element, { size: 'small', zIndex: 3000 });

**1.5.3 按需引入 Element：**

import Vue from 'vue';

import { Button } from 'element-ui';

Vue.prototype.\$ELEMENT = { size: 'small', zIndex: 3000 };

Vue.use(Button);

按照以上设置，项目中所有拥有 size 属性的组件的默认尺寸均为 'small'，弹框的初始 z-index 为 3000。

## 第二节Element UI 使用

## 2.1 Basic系列组件：

## 2.1.1 Layout 布局

通过基础的 24 分栏，迅速简便地创建布局

## 2.1.2基础布局

使用单一分栏创建基础的栅格布局。

通过 row 和 col 组件，并通过 col 组件的 span 属性我们就可以自由地组合布局。

\<el-row\>

\<el-col :span="24"\>\<div class="grid-content bg-purple-dark"\>\</div\>\</el-col\>\</el-row\>\<el-row\>

\<el-col :span="12"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="12"\>\<div class="grid-content bg-purple-light"\>\</div\>\</el-col\>\</el-row\>\<el-row\>

\<el-col :span="8"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="8"\>\<div class="grid-content bg-purple-light"\>\</div\>\</el-col\>

\<el-col :span="8"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>\</el-row\>\<el-row\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple-light"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple-light"\>\</div\>\</el-col\>\</el-row\>\<el-row\>

\<el-col :span="4"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="4"\>\<div class="grid-content bg-purple-light"\>\</div\>\</el-col\>

\<el-col :span="4"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="4"\>\<div class="grid-content bg-purple-light"\>\</div\>\</el-col\>

\<el-col :span="4"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="4"\>\<div class="grid-content bg-purple-light"\>\</div\>\</el-col\>\</el-row\>

\<style\>

.el-row {

margin-bottom: 20px;

&:last-child {

margin-bottom: 0;

}

}

.el-col {

border-radius: 4px;

}

.bg-purple-dark {

background: \#99a9bf;

}

.bg-purple {

background: \#d3dce6;

}

.bg-purple-light {

background: \#e5e9f2;

}

.grid-content {

border-radius: 4px;

min-height: 36px;

}

.row-bg {

padding: 10px 0;

background-color: \#f9fafc;

}\</style\>

## 2.1.3 分栏间隔

分栏之间存在间隔。

Row 组件 提供 gutter 属性来指定每一栏之间的间隔，默认间隔为 0。

\<el-row :gutter="20"\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>\</el-row\>

\<style\>

.el-row {

margin-bottom: 20px;

&:last-child {

margin-bottom: 0;

}

}

.el-col {

border-radius: 4px;

}

.bg-purple-dark {

background: \#99a9bf;

}

.bg-purple {

background: \#d3dce6;

}

.bg-purple-light {

background: \#e5e9f2;

}

.grid-content {

border-radius: 4px;

min-height: 36px;

}

.row-bg {

padding: 10px 0;

background-color: \#f9fafc;

}\</style\>

## 2.1.4混合布局

通过基础的 1/24 分栏任意扩展组合形成较为复杂的混合布局。

\<el-row :gutter="20"\>

\<el-col :span="16"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="8"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>\</el-row\>\<el-row :gutter="20"\>

\<el-col :span="8"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="8"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="4"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="4"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>\</el-row\>\<el-row :gutter="20"\>

\<el-col :span="4"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="16"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="4"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>\</el-row\>

\<style\>

.el-row {

margin-bottom: 20px;

&:last-child {

margin-bottom: 0;

}

}

.el-col {

border-radius: 4px;

}

.bg-purple-dark {

background: \#99a9bf;

}

.bg-purple {

background: \#d3dce6;

}

.bg-purple-light {

background: \#e5e9f2;

}

.grid-content {

border-radius: 4px;

min-height: 36px;

}

.row-bg {

padding: 10px 0;

background-color: \#f9fafc;

}\</style\>

## 2.1.5分栏偏移

支持偏移指定的栏数。

通过制定 col 组件的 offset 属性可以指定分栏偏移的栏数。

\<el-row :gutter="20"\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="6" :offset="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>\</el-row\>\<el-row :gutter="20"\>

\<el-col :span="6" :offset="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="6" :offset="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>\</el-row\>\<el-row :gutter="20"\>

\<el-col :span="12" :offset="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>\</el-row\>

\<style\>

.el-row {

margin-bottom: 20px;

&:last-child {

margin-bottom: 0;

}

}

.el-col {

border-radius: 4px;

}

.bg-purple-dark {

background: \#99a9bf;

}

.bg-purple {

background: \#d3dce6;

}

.bg-purple-light {

background: \#e5e9f2;

}

.grid-content {

border-radius: 4px;

min-height: 36px;

}

.row-bg {

padding: 10px 0;

background-color: \#f9fafc;

}\</style\>

## 2.1.6对齐方式

通过 flex 布局来对分栏进行灵活的对齐。

将 type 属性赋值为 'flex'，可以启用 flex 布局，并可通过 justify 属性来指定 start, center, end, space-between, space-around 其中的值来定义子元素的排版方式。

\<el-row type="flex" class="row-bg"\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple-light"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>\</el-row\>\<el-row type="flex" class="row-bg" justify="center"\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple-light"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>\</el-row\>\<el-row type="flex" class="row-bg" justify="end"\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple-light"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>\</el-row\>\<el-row type="flex" class="row-bg" justify="space-between"\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple-light"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>\</el-row\>\<el-row type="flex" class="row-bg" justify="space-around"\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple-light"\>\</div\>\</el-col\>

\<el-col :span="6"\>\<div class="grid-content bg-purple"\>\</div\>\</el-col\>\</el-row\>

\<style\>

.el-row {

margin-bottom: 20px;

&:last-child {

margin-bottom: 0;

}

}

.el-col {

border-radius: 4px;

}

.bg-purple-dark {

background: \#99a9bf;

}

.bg-purple {

background: \#d3dce6;

}

.bg-purple-light {

background: \#e5e9f2;

}

.grid-content {

border-radius: 4px;

min-height: 36px;

}

.row-bg {

padding: 10px 0;

background-color: \#f9fafc;

}\</style\>

## 2.2 Container 布局容器

布局的容器组件，方便快速搭建页面的基本结构：

\<el-container\>：外层容器。当子元素中包含 \<el-header\> 或 \<el-footer\> 时，全部子元素会垂直上下排列，否则会水平左右排列。

\<el-header\>：顶栏容器。

\<el-aside\>：侧边栏容器。

\<el-main\>：主要区域容器。

\<el-footer\>：底栏容器。

## 2.3 Button 按钮

## 2.3.1基础用法

使用type、plain、round和circle属性来定义 Button 的样式。

\<el-row\>

\<el-button\>默认按钮\</el-button\>

\<el-button type="primary"\>主要按钮\</el-button\>

\<el-button type="success"\>成功按钮\</el-button\>

\<el-button type="info"\>信息按钮\</el-button\>

\<el-button type="warning"\>警告按钮\</el-button\>

\<el-button type="danger"\>危险按钮\</el-button\>\</el-row\>

\<el-row\>

\<el-button plain\>朴素按钮\</el-button\>

\<el-button type="primary" plain\>主要按钮\</el-button\>

\<el-button type="success" plain\>成功按钮\</el-button\>

\<el-button type="info" plain\>信息按钮\</el-button\>

\<el-button type="warning" plain\>警告按钮\</el-button\>

\<el-button type="danger" plain\>危险按钮\</el-button\>\</el-row\>

\<el-row\>

\<el-button round\>圆角按钮\</el-button\>

\<el-button type="primary" round\>主要按钮\</el-button\>

\<el-button type="success" round\>成功按钮\</el-button\>

\<el-button type="info" round\>信息按钮\</el-button\>

\<el-button type="warning" round\>警告按钮\</el-button\>

\<el-button type="danger" round\>危险按钮\</el-button\>\</el-row\>

\<el-row\>

\<el-button icon="el-icon-search" circle\>\</el-button\>

\<el-button type="primary" icon="el-icon-edit" circle\>\</el-button\>

\<el-button type="success" icon="el-icon-check" circle\>\</el-button\>

\<el-button type="info" icon="el-icon-message" circle\>\</el-button\>

\<el-button type="warning" icon="el-icon-star-off" circle\>\</el-button\>

\<el-button type="danger" icon="el-icon-delete" circle\>\</el-button\>\</el-row\>

## 2.3.2 禁用状态

按钮不可用状态。

你可以使用disabled属性来定义按钮是否可用，它接受一个Boolean值。

\<el-row\>

\<el-button disabled\>默认按钮\</el-button\>

\<el-button type="primary" disabled\>主要按钮\</el-button\>

\<el-button type="success" disabled\>成功按钮\</el-button\>

\<el-button type="info" disabled\>信息按钮\</el-button\>

\<el-button type="warning" disabled\>警告按钮\</el-button\>

\<el-button type="danger" disabled\>危险按钮\</el-button\>\</el-row\>

\<el-row\>

\<el-button plain disabled\>朴素按钮\</el-button\>

\<el-button type="primary" plain disabled\>主要按钮\</el-button\>

\<el-button type="success" plain disabled\>成功按钮\</el-button\>

\<el-button type="info" plain disabled\>信息按钮\</el-button\>

\<el-button type="warning" plain disabled\>警告按钮\</el-button\>

\<el-button type="danger" plain disabled\>危险按钮\</el-button\>\</el-row\>

## 2.3.3 文字按钮

没有边框和背景色的按钮。

\<el-button type="text"\>文字按钮\</el-button\>\<el-button type="text" disabled\>文字按钮\</el-button\>

### 2.3.4 图标按钮

带图标的按钮可增强辨识度（有文字）或节省空间（无文字）。

设置icon属性即可，icon 的列表可以参考 Element 的 icon 组件，也可以设置在文字右边的 icon ，只要使用i标签即可，可以使用自定义图标。

\<el-button type="primary" icon="el-icon-edit"\>\</el-button\>\<el-button type="primary" icon="el-icon-share"\>\</el-button\>\<el-button type="primary" icon="el-icon-delete"\>\</el-button\>\<el-button type="primary" icon="el-icon-search"\>搜索\</el-button\>\<el-button type="primary"\>上传\<i class="el-icon-upload el-icon--right"\>\</i\>\</el-button\>

## 2.4 表单系列

[Radio 单选框](https://element.eleme.cn/#/zh-CN/component/radio)

[https://element.eleme.cn/\#/zh-CN/component/radio](https://element.eleme.cn/#/zh-CN/component/radio)

[Checkbox 多选框](https://element.eleme.cn/#/zh-CN/component/checkbox)

[https://element.eleme.cn/\#/zh-CN/component/checkbox](https://element.eleme.cn/#/zh-CN/component/checkbox)

[Input 输入框](https://element.eleme.cn/#/zh-CN/component/input)

[https://element.eleme.cn/\#/zh-CN/component/input](https://element.eleme.cn/#/zh-CN/component/input)

[InputNumber 计数器](https://element.eleme.cn/#/zh-CN/component/input-number)[https://element.eleme.cn/\#/zh-CN/component/input-number](https://element.eleme.cn/#/zh-CN/component/input-number)

[Select 选择器](https://element.eleme.cn/#/zh-CN/component/select)

[https://element.eleme.cn/\#/zh-CN/component/select](https://element.eleme.cn/#/zh-CN/component/select)

[Cascader 级联选择器](https://element.eleme.cn/#/zh-CN/component/cascader)

[https://element.eleme.cn/\#/zh-CN/component/cascader](https://element.eleme.cn/#/zh-CN/component/cascader)

[Switch 开关](https://element.eleme.cn/#/zh-CN/component/switch)

[https://element.eleme.cn/\#/zh-CN/component/switch](https://element.eleme.cn/#/zh-CN/component/switch)

[Slider 滑块](https://element.eleme.cn/#/zh-CN/component/slider)

[https://element.eleme.cn/\#/zh-CN/component/slider](https://element.eleme.cn/#/zh-CN/component/slider)

[TimePicker 时间选择器](https://element.eleme.cn/#/zh-CN/component/time-picker)

[https://element.eleme.cn/\#/zh-CN/component/time-picker](https://element.eleme.cn/#/zh-CN/component/time-picker)

[DatePicker 日期选择器](https://element.eleme.cn/#/zh-CN/component/date-picker)

[https://element.eleme.cn/\#/zh-CN/component/date-picker](https://element.eleme.cn/#/zh-CN/component/date-picker)

[DateTimePicker 日期时间选择器](https://element.eleme.cn/#/zh-CN/component/datetime-picker)

[https://element.eleme.cn/\#/zh-CN/component/datetime-picker](https://element.eleme.cn/#/zh-CN/component/datetime-picker)

[Upload 上传](https://element.eleme.cn/#/zh-CN/component/upload)

[https://element.eleme.cn/\#/zh-CN/component/upload](https://element.eleme.cn/#/zh-CN/component/upload)

[Rate 评分](https://element.eleme.cn/#/zh-CN/component/rate)

[https://element.eleme.cn/\#/zh-CN/component/rate](https://element.eleme.cn/#/zh-CN/component/rate)

[ColorPicker 颜色选择器](https://element.eleme.cn/#/zh-CN/component/color-picker)

[https://element.eleme.cn/\#/zh-CN/component/color-picker](https://element.eleme.cn/#/zh-CN/component/color-picker)

[Transfer 穿梭框](https://element.eleme.cn/#/zh-CN/component/transfer)

[https://element.eleme.cn/\#/zh-CN/component/transfer](https://element.eleme.cn/#/zh-CN/component/transfer)

[Form 表单](https://element.eleme.cn/#/zh-CN/component/form)

[https://element.eleme.cn/\#/zh-CN/component/form](https://element.eleme.cn/#/zh-CN/component/form)

## 2.5 Data系列

[Table 表格](https://element.eleme.cn/#/zh-CN/component/table)

[https://element.eleme.cn/\#/zh-CN/component/table](https://element.eleme.cn/#/zh-CN/component/table)

[Tag 标签](https://element.eleme.cn/#/zh-CN/component/tag)

[https://element.eleme.cn/\#/zh-CN/component/tag](https://element.eleme.cn/#/zh-CN/component/tag)

[Progress 进度条](https://element.eleme.cn/#/zh-CN/component/progress)

[https://element.eleme.cn/\#/zh-CN/component/progress](https://element.eleme.cn/#/zh-CN/component/progress)

[Tree 树形控件](https://element.eleme.cn/#/zh-CN/component/tree)

[https://element.eleme.cn/\#/zh-CN/component/tree](https://element.eleme.cn/#/zh-CN/component/tree)

[Pagination 分页](https://element.eleme.cn/#/zh-CN/component/pagination)

[https://element.eleme.cn/\#/zh-CN/component/pagination](https://element.eleme.cn/#/zh-CN/component/pagination)

[Badge 标记](https://element.eleme.cn/#/zh-CN/component/badge)

[https://element.eleme.cn/\#/zh-CN/component/badge](https://element.eleme.cn/#/zh-CN/component/badge)

[Avatar 头像](https://element.eleme.cn/#/zh-CN/component/avatar)

[https://element.eleme.cn/\#/zh-CN/component/avatar](https://element.eleme.cn/#/zh-CN/component/avatar)

## 2.6 Notice系列

[Alert 警告](https://element.eleme.cn/#/zh-CN/component/alert)

[https://element.eleme.cn/\#/zh-CN/component/alert](https://element.eleme.cn/#/zh-CN/component/alert)

[Loading 加载](https://element.eleme.cn/#/zh-CN/component/loading)

[https://element.eleme.cn/\#/zh-CN/component/loading](https://element.eleme.cn/#/zh-CN/component/loading)

[Message 消息提示](https://element.eleme.cn/#/zh-CN/component/message)

[https://element.eleme.cn/\#/zh-CN/component/message](https://element.eleme.cn/#/zh-CN/component/message)

[MessageBox 弹框](https://element.eleme.cn/#/zh-CN/component/message-box)

[https://element.eleme.cn/\#/zh-CN/component/message-box](https://element.eleme.cn/#/zh-CN/component/message-box)

[Notification 通知](https://element.eleme.cn/#/zh-CN/component/notification)

[https://element.eleme.cn/\#/zh-CN/component/notification](https://element.eleme.cn/#/zh-CN/component/notification)

## 2.7 Navigation系列

[NavMenu 导航菜单](https://element.eleme.cn/#/zh-CN/component/menu)

[https://element.eleme.cn/\#/zh-CN/component/menu](https://element.eleme.cn/#/zh-CN/component/menu)

[Tabs 标签页](https://element.eleme.cn/#/zh-CN/component/tabs)

[https://element.eleme.cn/\#/zh-CN/component/tabs](https://element.eleme.cn/#/zh-CN/component/tabs)

[Breadcrumb 面包屑](https://element.eleme.cn/#/zh-CN/component/breadcrumb)

[https://element.eleme.cn/\#/zh-CN/component/breadcrumb](https://element.eleme.cn/#/zh-CN/component/breadcrumb)

[PageHeader 页头](https://element.eleme.cn/#/zh-CN/component/page-header)

[https://element.eleme.cn/\#/zh-CN/component/page-header](https://element.eleme.cn/#/zh-CN/component/page-header)

[Dropdown 下拉菜单](https://element.eleme.cn/#/zh-CN/component/dropdown)

[https://element.eleme.cn/\#/zh-CN/component/dropdown](https://element.eleme.cn/#/zh-CN/component/dropdown)

[Steps 步骤条](https://element.eleme.cn/#/zh-CN/component/steps)

[https://element.eleme.cn/\#/zh-CN/component/steps](https://element.eleme.cn/#/zh-CN/component/steps)
