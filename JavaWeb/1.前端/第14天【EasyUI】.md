# 第1天【EasyUI】

## 主要内容

1.  EasyUI基础组件

## EasyUI页面布局

1.  EasyUI菜单按钮
2.  EasyUI表单组件

## 学习目标

| 节数                      | 知识点         | 要求 |
|---------------------------|----------------|------|
| 第一节（EasyUI基础组件）  | EasyUI基础组件 | 掌握 |
| 第二节（EasyUI页面布局）  | EasyUI页面布局 | 掌握 |
| 第三节（EasyUI菜单按钮）  | EasyUI菜单按钮 | 掌握 |
| 第四节（EasyUI表单组件）  | EasyUI表单组件 | 掌握 |

## 第一节 EasyUI基础组件

### EasyLoader（简单加载）

用法

加载 EasyUI 模块

easyloader.base = '../'; // 设置 easyui 基础目录

easyloader.load('messager', function(){ // 加载指定模块

\$.messager.alert('Title', 'load ok');

});

加载来自绝对路径的脚本

using('http://code.jquery.com/jquery-1.4.4.min.js', function(){

// ...

});

加载来自相对路径的脚本

// 脚本路径相对于 easyui 目录

using('./myscript.js', function(){

// ...

});

![](media/0795e039fa65245dd8e371e5e072f72f.png)

![](media/2e8b86303c35e06dec072002fb14a64c.png)

### Draggable（拖动）

使用\$.fn.draggable.defaults重写默认值对象。

使用案例

通过标签创建一个可拖动的元素。

\<div id="dd" class="easyui-draggable" data-options="handle:'\#title'" style="width:100px;height:100px;"\>

\<div id="title" style="background:\#ccc;"\>title\</div\>

\</div\>

使用Javascript创建一个可拖动的元素。

\<div id="dd1" style="width:100px;height:100px;"\>

\<div id="title" style="background:\#ccc;"\>title\</div\>

\</div\>

\$('\#dd').draggable({

handle:'\#title'

});

![](media/cddf0c88c49134a877549b0fcb8d68e6.png)

![](media/b5d421b6ea8dfa3106e14fa4342cf365.png)

![](media/0a7c1b0ff2409a5a3efbb66ba78850f5.png)

### Resizable（调整大小）

使用\$.fn.resizable.defaults重写默认值对象。

使用案例

使用标签创建可变大小的窗口。

\<div id="rr" class="easyui-resizable" data-options="maxWidth:800,maxHeight:600" style="width:100px;height:100px;border:1px solid \#ccc;"\>\</div\>

使用Javascript创建可变大小的窗口。

\<div id="rr" style="width:100px;height:100px;border:1px solid \#ccc;"\>\</div\>

\$('\#rr').resizable({

maxWidth:800,

maxHeight:600

});

![](media/3997ff885f3b931ac99a6bf71bca0b05.png)

![](media/8c3a42403cc703cbb1ec2f6d6a213745.png)

![](media/a18accf6b9787b31575a50889dc01740.png)

### Pagination（分页）

使用\$.fn.pagination.defaults重写默认值对象

该分页控件允许用户导航页面的数据。它支持页面导航和页面长度选择的选项设置。用户可以在分页控件上添加自定义按钮，以增强其功能。

![](media/150a3ed6d741287f3ea002e5d919d80b.png)

使用案例

使用标签创建分页控件。

\<div id="pp" class="easyui-pagination" data-options="total:2000,pageSize:10" style="background:\#efefef;border:1px solid \#ccc;"\>\</div\>

使用Javascript创建可变大小的窗口。

\<div id="rr" style="width:100px;height:100px;border:1px solid \#ccc;"\>\</div\>

\$('\#pp').pagination({

total:2000,

pageSize:10

});

让我们使用面板和分页插件来创建一个ajax分页。当用户选择一个新页面的时候，面板将显示指定页面的内容。

\<div id="content" class="easyui-panel" style="height:200px" data-options="href:'show_content.php?page=1'"\>

\</div\>

\<div class="easyui-pagination" style="border:1px solid \#ccc;" data-options=").panel('refresh', 'show_content.php?page='+pageNumber);}"\>

\</div\>

面板上默认显示第一页的内容。当用户导航页面的时候，'onSelectPage'事件将被触发，将会根据一个新的URL参数获取对应页面的新内容，并通过'refresh'方法将内容刷新到内容面板上。

![](media/a8fa288a3cf57513105a0dc35d535967.png)

![](media/d57c70e2c0b7e340680acb6af6dea52c.png)

![](media/448f6938bd6fbcee0201a9344457a49a.png)

![](media/84dfccf1116722114e3a8ca801086734.png)

![](media/968e3f4b0b990f4d0c63f56b4d975b28.png)

### SearchBox（搜索框）

使用案例

创建查询框

1\. 使用标签创建。添加'easyui-searchbox'类ID到\< input/\>标签。

\<script type="text/javascript"\>

function qq(value, name) {

alert(value + ":" + name)

}

\</script\>

\<input id="ss" class="easyui-searchbox" style="width:300px" data-options="searcher:qq,prompt:'Please Input Value',menu:'\#mm'"\>

\<div id="mm" style="width:120px"\>

\<div data-options="name:'all',iconCls:'icon-ok'"\>All News\</div\>

\<div data-options="name:'sports'"\>Sports News\</div\>

\</div\>

2\. 创建程序。

\<input id="ss"\>

\<div id="mm1" style="width:120px"\>

\<div data-options="name:'all',iconCls:'icon-ok'"\>All News\</div\>

\<div data-options="name:'sports'"\>Sports News\</div\>

\</div\>

\$('\#ss').searchbox({

searcher:function(value,name){

alert(value + "," + name)

},

menu:'\#mm',

prompt:'请输入值'

});

![](media/631885088059b72de3d961ad3f57905a.png)

![](media/d7c4bc49ed791413b207727b16f605eb.png)

![](media/c3e45fbeadfda74ac91493df9aca1e64.png)

### 本节作业

1.  掌握EasyLoader（简单加载）
2.  掌握Resizable（调整大小）
3.  掌握Pagination（分页）

## 第二节EasyUI页面布局

### 2.1 Panel（面板）

使用\$.fn.panel.defaults重写默认值对象。

面板作为承载其它内容的容器。这是构建其他组件的基础（比如：layout,tabs,accordion等）。它还提供了折叠、关闭、最大化、最小化和自定义行为。面板可以很容易地嵌入到web页面的任何位置。

![](media/2be0ef53d28ffde05123b12326f6a0c0.png)

创建面板

创建进度条

1\. 通过标签创建面板

通过标签创建更简单。添加'easyui-panel'类ID到\< div/\>标签。

\<div id="p" class="easyui-panel" title="My Panel" style="width:500px;height:150px;padding:10px;background:\#fafafa;" data-options="iconCls:'icon-save',closable:true,collapsible:true,minimizable:true,maximizable:true"\>

\<p\>panel content.\</p\>

\<p\>panel content.\</p\>

\</div\>

2\. 创建面板程序

让我们创建面板右上角的的工具栏。

\<div id="p" style="padding:10px;"\>

\<p\>panel content.\</p\>

\<p\>panel content.\</p\>

\</div\>

\$('\#p').panel({

width:500,

height:150,

title: 'My Panel',

tools: [{

iconCls:'icon-add',

handler:function(){alert('new')}

},{

iconCls:'icon-save',

handler:function(){alert('save')}

}]

});

移动面板

调用'move'方法移动面板到新的位置。

\$('\#p').panel('move',{

left:100,

top:100

});

读取内容

当加载成功的时候让我们通过ajax加载面板内容并显示一些消息。

\$('\#p').panel({

href:'content_url.php',

onLoad:function(){

alert('loaded successfully');

}

});

![](media/a30e3ded29989329e136670918331cc7.png)

![](media/42e9c632425a0486ebdf8bb069bab24b.png)

![](media/7e50af02ceaa2083be8a4b049ae12440.png)

![](media/eedc49dc21bdd2ebe48a25ef22809898.png)

### 2.2 Tabs（选项卡）

使用\$.fn.tabs.defaults重写默认值对象。

选项卡显示一批面板。但在同一个时间只会显示一个面板。每个选项卡面板都有头标题和一些小的按钮工具菜单，包括关闭按钮和其他自定义按钮。

![](media/3096dea2c9c3f5d63b2f6a4b327f2af6.png)

使用案例

创建面板

1\. 通过标签创建选项卡

通过标签可以更容易的创建选项卡，我们不需要写任何Javascript代码。只需要给\< div/\>标签添加一个类ID'easyui-tabs'。每个选项卡面板都通过子\< div/\>标签进行创建，用法和panel(面板)相同。

\<div id="tt" class="easyui-tabs" style="width:500px;height:250px;"\>

\<div title="Tab1" style="padding:20px;display:none;"\>

tab1

\</div\>

\<div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;"\>

tab2

\</div\>

\<div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;display:none;"\>

tab3

\</div\>

\</div\>

2\. 通过Javascript创建选项卡

下面的代码演示如何使用Javascript创建选项卡，当该选项卡被选择时将会触发'onSelect'事件。

\$('\#tt').tabs({

border:false,

onSelect:function(title){

alert(title+' is selected');

}

});

添加新的选项卡面板

添加一个新的包含小工具菜单的选项卡面板，小工具菜单图标(8x8)被放置在关闭按钮之前。

// add a new tab panel

\$('\#tt').tabs('add',{

title:'New Tab',

content:'Tab Body',

closable:true,

tools:[{

iconCls:'icon-mini-refresh',

handler:function(){

alert('refresh');

}

}]

});

获取选择的选项卡

// get the selected tab panel and its tab object

var pp = \$('\#tt').tabs('getSelected');

var tab = pp.panel('options').tab; // the corresponding tab object

### 

### 2.3 Accordion（分类）

使用\$.fn.accordion.defaults重写默认值对象。

分类空间允许用户使用多面板，但在同一时间只会显示一个。每个面板都内建支持展开和折叠功能。点击一个面板的标题将会展开或折叠面板主体。面板内容可以通过指定的'href'属性使用ajax方式读取面板内容。用户可以定义一个被默认选中的面板，如果未指定，那么第一个面板就是默认的。

![](media/ff3c68eaa2c0acdeb72395e260ecd3ae.png)

使用案例

创建分类

通过标签创建分类，给\< div/\>标签添加一个名为'easyui-accordion'的类ID。

\<div id="aa" class="easyui-accordion" style="width:300px;height:200px;"\>

\<div title="Title1" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;"\>

\<h3 style="color:\#0099FF;"\>Accordion for jQuery\</h3\>

\<p\>Accordion is a part of easyui framework for jQuery.

It lets you define your accordion component on web page more easily.\</p\>

\</div\>

\<div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;"\>

content2

\</div\>

\<div title="Title3"\>

content3

\</div\>

\</div\>

我们可以更改或修改面板的一些功能以后再重新创建它。

\$('\#aa').accordion({

animate:false

});

刷新分类面板内容

调用'getSelected'方法获取当前面板，此外我们还可以调用'refresh'方法重新载入新内容。

var pp = \$('\#aa').accordion('getSelected'); // 获取选择的面板

if (pp){

pp.panel('refresh','new_content.php'); // 调用'refresh'方法刷新

}

### 

### 2.4 Layout（布局）

使用\$.fn.layout.defaults重写默认值对象。

布局容器有5个区域：北、南、东、西和中间。中间区域面板是必须的，边缘的面板都是可选的。每个边缘区域面板都可以通过拖拽其边框改变大小，也可以点击折叠按钮将面板折叠起来。布局可以进行嵌套，用户可以通过组合布局构建复杂的布局结构。

![](media/e7c702282385a13e8a3fd576c09a2665.png)

使用案例

创建布局

1\. 通过标签创建布局

为\< div/\>标签增加名为'easyui-layout'的类ID。

\<div id="cc" class="easyui-layout" style="width:600px;height:400px;"\>

\<div data-options="region:'north',title:'North Title',split:true" style="height:100px;"\>\</div\>

\<div data-options="region:'south',title:'South Title',split:true" style="height:100px;"\>\</div\>

\<div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"\>\</div\>

\<div data-options="region:'west',title:'West',split:true" style="width:100px;"\>\</div\>

\<div data-options="region:'center',title:'center title'" style="padding:5px;background:\#eee;"\>\</div\>

\</div\>

2\. 使用完整页面创建布局

\<div data-options="region:'north',title:'North Title',split:true" style="height:100px;"\>\</div\>

\<div data-options="region:'south',title:'South Title',split:true" style="height:100px;"\>\</div\>

\<div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"\>\</div\>

\<div data-options="region:'west',title:'West',split:true" style="width:100px;"\>\</div\>

\<div data-options="region:'center',title:'center title'" style="padding:5px;background:\#eee;"\>\</div\>

3\. 创建嵌套布局

注意：嵌套在内部的布局面板的左侧(西面)面板是折叠的。

\<div data-options="region:'north'" style="height:100px"\>\</div\>

\<div data-options="region:'center'"\>

\<div class="easyui-layout" data-options="fit:true"\>

\<div data-options="region:'west',collapsed:true" style="width:180px"\>\</div\>

\<div data-options="region:'center'"\>\</div\>

\</div\>

\</div\>

4\. 通过ajax读取内容

布局是以面板为基础创建的。所有的布局面板都支持异步加载URL内容。使用异步加载技术，用户可以使自己的布局页面显示的内容更多更快。

\<div data-options="region:'west',href:'west_content.php'" style="width:180px"\>\</div\>

\<div data-options="region:'center',href:'center_content.php'"\>\</div\>

折叠布局面板

\$('\#cc').layout();

// collapse the west panel

\$('\#cc').layout('collapse','west');

添加西侧区域面板和工具菜单按钮

\$('\#cc').layout('add',{

region: 'west',

width: 180,

title: 'West Title',

split: true,

tools: [{

iconCls:'icon-add',

handler:function(){alert('add')}

},{

iconCls:'icon-remove',

handler:function(){alert('remove')}

}]

});

### 本节作业

1.  熟练使用Panel（面板），Tabs（选项卡）
2.  熟练掌握Accordion（分类）
3.  掌握Layout（布局）

## 第三节 EasyUI菜单按钮

### 3.1 Menu（菜单）

使用\$.fn.menu.defaults重写默认值对象。

菜单组件通常用于快捷菜单。他是构建其他菜单组件的必备基础组件。比如：menubutton和splitbutton。它还可以用于导航和执行命令。

![](media/f485716e2f43272057e6420ef5d9382e.png)

使用案例

创建菜单

通过标签创建菜单，给\< div/\>标签添加一个名为'easyui-menu'的类ID。每个菜单项都通过\< div/\>标签创建。我们可以添加'iconCls'属性来给菜单项定义一个图标显示到菜单项的左侧。添加'menu-sep'类ID菜单项将会生成一个菜单分割线。

\<div id="mm" class="easyui-menu" style="width:120px;"\>

\<div\>New\</div\>

\<div\>

\<span\>Open\</span\>

\<div style="width:150px;"\>

\<div\>\<b\>Word\</b\>\</div\>

\<div\>Excel\</div\>

\<div\>PowerPoint\</div\>

\</div\>

\</div\>

\<div data-options="iconCls:'icon-save'"\>Save\</div\>

\<div class="menu-sep"\>\</div\>

\<div\>Exit\</div\>

\</div\>

使用Javascript创建菜单项并监听'onClick'事件。

\$('\#mm').menu({

onClick:function(item){

//...

}

});

显示菜单

在菜单被创建的时候它是隐藏和不可见的。调用'show'方法显示菜单。

\$('\#mm').menu('show', {

left: 200,

top: 100

});

![](media/ad0923436b1efaed0f3a9e5abc410c1f.png)

### 3.2 SideMenu（侧栏菜单）

![](media/0c89e8ce5ec994d8cb5d636cde0173bb.png)

使用案例

创建侧菜单

通过标签创建侧菜单

\<div id="sm" data-toggle="topjui-sidemenu" data-options="data:data"\>

\</div\>

使用Javascript创建侧菜单。

\<div id="sm" style="width:300px"\>\</div\>

\$('\#sm').iSidemenu({

data: data

});

![](media/8bcdaf97233d9bd8da5b44d4d3769bfa.png)

### 3.3 LinkButton（按钮）

使用\$.fn.linkbutton.defaults重写默认值对象。

按钮组件使用超链接按钮创建。它使用一个普通的\< a\>标签进行展示。它可以同时显示一个图标和文本,或只有图标或文字。按钮的宽度可以动态和折叠/展开以适应它的文本标签。

![](media/8de74e46b5f3dc909af69a1f3114bb52.png)

使用案例

创建按钮

使用标签创建按钮更加简单。

\<a id="btn" href="\#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"\>easyui\</a\>

也可以使用Javascript创建按钮。

\<a id="btn" href="\#"\>easyui\</a\>

\$('\#btn').linkbutton({

iconCls: 'icon-search'

});

处理按钮的点击

点击按钮会将用户引导到其他页面。

\<a href="otherpage.php" class="easyui-linkbutton" data-options="iconCls:'icon-search'"\>easyui\</a\>

下面的示例提示了一个警告信息。

\<a href="\#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="javascript:alert('easyui')"\>easyui\</a\>

使用jQuery绑定点击事件。

\<a id="btn" href="\#" class="easyui-linkbutton" data-options="iconCls:'icon-search'"\>easyui\</a\>

\$(function(){

\$('\#btn').bind('click', function(){

alert('easyui');

});

});

### 3.4 MenuButton（菜单按钮）

扩展自\$.fn.linkbutton.defaults。使用\$.fn.menubutton.defaults重写默认值对象。

菜单按钮是下拉菜单的一部分。它伴随着linkbutton和menu组件。在用户点击linkbutton之前菜单是隐藏的，当用户用鼠标点击或移动到linkbutton上面的时候菜单才会显示。

![](media/1778e3f8ca17dd49a0e727fc668616db.png)

用法

通常菜单按钮通过标签创建。

\<a href="javascript:void(0)" id="mb" class="easyui-menubutton" data-options="menu:'\#mm',iconCls:'icon-edit'"\>Edit\</a\>

\<div id="mm" style="width:150px;"\>

\<div data-options="iconCls:'icon-undo'"\>Undo\</div\>

\<div data-options="iconCls:'icon-redo'"\>Redo\</div\>

\<div class="menu-sep"\>\</div\>

\<div\>Cut\</div\>

\<div\>Copy\</div\>

\<div\>Paste\</div\>

\<div class="menu-sep"\>\</div\>

\<div data-options="iconCls:'icon-remove'"\>Delete\</div\>

\<div\>Select All\</div\>

\</div\>

使用Javascript创建菜单按钮。

\<a href="javascript:void(0)" id="mb"\>Edit\</a\>

\<div id="mm" style="width:150px"\>

...

\</div\>

\$('\#mb').menubutton({

iconCls: 'icon-edit',

menu: '\#mm'

});

![](media/48b458664297e5c4183481702b8b347a.png)

### 本节作业

1.  熟练使用Menu（菜单）
2.  熟练掌握LinkButton（按钮）
3.  掌握MenuButton（菜单按钮）
