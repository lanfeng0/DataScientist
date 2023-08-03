
# 目录
### 一、启动程序
### 二、IPython的帮助文档
1. 使用help()
2. 使用?
3. tab自动补全

### 三、IPython魔法命令
1. 运行外部Python文件
2. 运行计时
3. 查看当前会话中的所有变量与函数
4. 执行Linux指令
5. 更多魔法命令

### 四、IPython输入输出历史
1. 可使用In/Out调用输入输出历史
2. 使用下划线表示输出



## 一、启动程序





执行以下命令：
>jupyter notebook

[NotebookApp] Serving notebooks from local directory: /home/nanfengpo

[NotebookApp] 0 active kernels 

[NotebookApp] The IPython Notebook is running at: http://localhost:8888/

[NotebookApp] Use Control-C to stop this server and shut down all kernels (twice to skip confirmation).

注意以下几点：
- 打开地址为当前bash的目录，默认的根目录
- 浏览器地址为http://localhost:8888/
- 通过control -C终止jupyter程序

几个基本操作：
- 双击D：删除当前cell
- 单击M：转为markdown文档
- markdown文档下运行变为预览模式

## 二、IPython的帮助文档

### 1. 使用help()

通过以下命令来获得帮助文档：
>help(len)

Help on built-in function len in module builtins:

len(obj, /)
    Return the number of items in a container.


```python
help(len)
```

    Help on built-in function len in module builtins:
    
    len(obj, /)
        Return the number of items in a container.
    
    

### 2. 使用?

或者使用问号：
>len?


```python
len?
```



还可以应用到自定义的变量和自定义的函数上来返回帮助文档

此外，使用两个??可以把函数的源代码显示出来

### 3. tab自动补全

敲击tab键能自动补全
>L.<TAB>


```python
import numpy
```

也可以在import的时候自动补全
>import nu<TAB>

## 三、IPython魔法命令

### 1. 运行外部Python文件

使用下面命令运行外部python文件（默认是当前目录，最好加上绝对路径）
> %run *.py
    
例如在当前目录下有一个myscript.py文件：
```

def square(x):
    """square a number"""
    return x ** 2

for N in range(1, 4):
    print(N, "squared is", square(N))
```



```python
%run test.py
```

    test
    

我们可以通过下面命令执行它：
> %run myscript.py

尤其要注意的是，当我们使用魔法命令执行了一个外部文件时，该文件的函数就能在当前会话中使用
>square(5)


```python
%run myscript.py
```

    1 squared is 1
    2 squared is 4
    3 squared is 9
    


```python
square(5)
```




    25




```python
my_func1()
```


    ---------------------------------------------------------------------------

    NameError                                 Traceback (most recent call last)

    <ipython-input-3-a5c0d98eb9dc> in <module>()
    ----> 1 my_func1()
    

    NameError: name 'my_func1' is not defined


### 2. 运行计时

用下面命令计算statement的运行时间：
> %time statement



```python
def p():
    for i in range(10):
        print(i)

%time p()
def add():
    i = 0
    t = 0
    while i <=100000000:
        t += i
        i += 1
        if(i == 100000000):
            print(t)
%time add()
```

    0
    1
    2
    3
    4
    5
    6
    7
    8
    9
    Wall time: 1.5 ms
    4999999950000000
    Wall time: 5.11 s
    


```python
%time print('hello world')
```

    hello world
    Wall time: 0 ns
    

用下面命令计算statement的平均运行时间：
%timeit statement


```python
tup1 = ('physics', 'chemistry', 1997, 2000);
%timeit print(tup1)
```


```python
可以使用两个百分号来测试多行代码的平均运行时间：
%%timeit
statement1
statement2
statement3
```


      File "<ipython-input-37-2c8453f27385>", line 1
        可以使用两个百分号来测试多行代码的平均运行时间：
                               ^
    SyntaxError: invalid character in identifier
    


用下面命令计算statement的平均运行时间：   
> %timeit statement

timeit会多次运行statement，最后得到一个更为精准的预期运行时间

可以使用两个百分号来测试多行代码的平均运行时间：

`
%%timeit

statement1

statement2

statement3

`

记住：
- %time一般用于耗时长的代码段
- %timeit一般用于耗时短的代码段

### 3. 查看当前会话中的所有变量与函数

快速查看当前会话的所有变量与函数名称：
>%who


```python
a,b = 19,40
```


```python
%who
```

    N	 a	 b	 square	 
    

查看当前会话的所有变量与函数名称的详细信息：
>%whos


```python
%whos
```

    Variable   Type        Data/Info
    --------------------------------
    N          int         3
    a          int         19
    b          int         40
    square     function    <function square at 0x000001FCA12922F0>
    


```python
%who_ls
```




    ['N', 'a', 'b', 'square']



返回一个字符串列表，里面元素是当前会话的所有变量与函数名称：
>%who_ls


```python
%pwd
```




    'E:\\中软大数据视频-2020.10总部分享\\数据挖掘\\day01-jupyter简介、numpy入门\\code'



### 4. 执行Linux指令

Linux指令：

$ echo "hello world"             # echo is like Python's print function
hello world

$ pwd                            # pwd = print working directory
/home/jake                             # this is the "path" that we're sitting in

$ ls                             # ls = list working directory contents
notebooks  projects 


$ mkdir mm
/home/jake/projects

在Linux指令之前加上  <font size = 5 color = green>!</font>，即可在ipython当中执行Linux指令。

注意会将标准输出以字符串形式返回


```python
!echo "HEllo Linux"
```

    "HEllo Linux"
    


```python
!ls

```

    'ls' 不是内部或外部命令，也不是可运行的程序
    或批处理文件。
    


```python
!pwd
```

    'pwd' 不是内部或外部命令，也不是可运行的程序
    或批处理文件。
    

### 5. 更多魔法命令

列出所有魔法命令
>lsmagic


```python
lsmagic
```




    Available line magics:
    %alias  %alias_magic  %autocall  %automagic  %autosave  %bookmark  %cd  %clear  %cls  %colors  %config  %connect_info  %copy  %ddir  %debug  %dhist  %dirs  %doctest_mode  %echo  %ed  %edit  %env  %gui  %hist  %history  %killbgscripts  %ldir  %less  %load  %load_ext  %loadpy  %logoff  %logon  %logstart  %logstate  %logstop  %ls  %lsmagic  %macro  %magic  %matplotlib  %mkdir  %more  %notebook  %page  %pastebin  %pdb  %pdef  %pdoc  %pfile  %pinfo  %pinfo2  %popd  %pprint  %precision  %profile  %prun  %psearch  %psource  %pushd  %pwd  %pycat  %pylab  %qtconsole  %quickref  %recall  %rehashx  %reload_ext  %ren  %rep  %rerun  %reset  %reset_selective  %rmdir  %run  %save  %sc  %set_env  %store  %sx  %system  %tb  %time  %timeit  %unalias  %unload_ext  %who  %who_ls  %whos  %xdel  %xmode
    
    Available cell magics:
    %%!  %%HTML  %%SVG  %%bash  %%capture  %%cmd  %%debug  %%file  %%html  %%javascript  %%js  %%latex  %%markdown  %%perl  %%prun  %%pypy  %%python  %%python2  %%python3  %%ruby  %%script  %%sh  %%svg  %%sx  %%system  %%time  %%timeit  %%writefile
    
    Automagic is ON, % prefix IS NOT needed for line magics.



查看魔法命令的文档:
使用?

## 四、IPython输入输出历史

### 1. 可使用In/Out调用输入输出历史
In返回一个字符串列表，里面是所有输入命令的字符串

Out返回一个含有输出的命令的序号及其输出组成的字典

两者皆可以通过索引获取元素


```python
for item in range(1,6):
    print(item)
    
```

    1
    2
    3
    4
    5
    

### 2. 使用下划线表示输出
"_"表示上一个输出

"_2"表示Out[2]

## 五、notebook的快捷键

### 1、命令模式 

	• Enter : 转入编辑模式 
    • Shift-Enter : 运行本单元，选中下个单元
    • Ctrl-Enter : 运行本单元，选中当前单元
    • Alt-Enter : 运行本单元，在下面插入一单元

# title

    • Y : 单元转入代码状态
	• M :单元转入markdown状态

	• A : 在上方插入新单元
    • B : 在下方插入新单元

### 2、编辑模式 ( Enter 键启动)

	• Tab : 代码补全或缩进
    • Shift-Tab : 提示


```python
import numpy as np
```

np.zeros()

	• Ctrl-A : 全选
	• Ctrl-Z : 复原

============================================

练习：

在Jupyter上实现以前的代码，包括：

- 简单代码
- 分支
- 循环
- 函数
- 类

============================================


```python
xmax,xmin = 50,10
```


```python
if xmax>40:
    print('非常大')
else:
    print('一般大')
```

    非常大
    


```python
for i in [1,2,3,4,58,9,10]:
    print(i)
```

    1
    2
    3
    4
    58
    9
    10
    




```python
def transform(number):
    print('this is a number of %d'%(number))
```


```python
transform(123)
```

    this is a number of 123
    


```python
#斐波那契数列
```


```python
def fanbonacci(num):
    a = 1
    b = 1
    for i in range(num):
        print('%10d %-10d'%(a,b))
        a = a + b
        b = a + b
fanbonacci(10)
```

             1 1         
             2 3         
             5 8         
            13 21        
            34 55        
            89 144       
           233 377       
           610 987       
          1597 2584      
          4181 6765      
    


```python

global a,b
a,b = 1,1
	
def fabnaci(num):
	global a,b
	for i in range(num):
		print('%10d %10d'%(a,b))
		a = a + b
		b = a + b
        
fabnaci(10)
```

             1          1
             2          3
             5          8
            13         21
            34         55
            89        144
           233        377
           610        987
          1597       2584
          4181       6765
    


```python

```
