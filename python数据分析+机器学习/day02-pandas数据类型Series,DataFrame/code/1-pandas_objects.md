
将鱼图像数据进行操作，使用numpy知识

# Pandas的数据结构



导入pandas：  
三剑客


```python
import pandas as pd
import numpy as np
from pandas import Series,DataFrame
```

### 1、Series


```python
[1,2,3]
```




    [1, 2, 3]




```python
np.array([1,2,3,4])
```




    array([1, 2, 3, 4])



Series是一种类似与一维数组的对象，由下面两个部分组成：
- values：一组数据（ndarray类型）
- index：相关的数据索引标签

#### 1）Series的创建

两种创建方式：

(1) 由列表或numpy数组创建

    默认索引为0到N-1的整数型索引


```python
s1 = Series([1,2,3,4,5])
```


```python
s1
```




    0    1
    1    2
    2    3
    3    4
    4    5
    dtype: int64




```python
n1 = np.array([1,2,3,4,5])
n1
```




    array([1, 2, 3, 4, 5])




```python
s2 = Series(n1)
s2
```




    0    1
    1    2
    2    3
    3    4
    4    5
    dtype: int32



    还可以通过设置index参数指定索引


```python
s3 = Series(data=n1,index=['A','B','C','D','E'])
# s3 = Series(data=n1,index=list('ABCDE'))
s3
```




    A    1
    B    2
    C    3
    D    4
    E    5
    dtype: int32



特别地，由ndarray创建的是引用，而不是副本。对Series元素的改变也会改变原来的ndarray对象中的元素。（列表没有这种情况）


```python
l1 = np.array([1,2,3,4,5])
s1 = Series(data=l1)
s1[0] = 100
s1
```




    0    100
    1      2
    2      3
    3      4
    4      5
    dtype: int32




```python
l1
```




    array([100,   2,   3,   4,   5])



(2) 由字典创建


```python
dic = {
    'name':'dancer',
    'oldname':'张学友',
    'age':19,
}

# 字典生成的Series是有序的
s = Series(data=dic)
s
```




    name       dancer
    oldname       张学友
    age            19
    dtype: object




```python
s[2]
```




    19



============================================

练习1：

使用多种方法创建以下Series，命名为s1：  
语文 150   
数学 150   
英语 150   
理综 300   

============================================


```python
data = np.array([150,150,150,300])
index = ['语文','数学','英语','理综']
s1 = Series(data=data,index=index)
s1
```




    语文    150
    数学    150
    英语    150
    理综    300
    dtype: int32



#### 2）Series的索引和切片


```python
s1['语文']
```




    150



可以使用中括号取单个索引（此时返回的是元素类型），或者中括号里一个列表取多个索引（此时返回的仍然是一个Series类型）。分为显示索引和隐式索引：

(1) 显式索引：

    - 使用index中的元素作为索引值
    - 使用.loc[]（推荐）

 注意，此时是闭区间


```python
s1[0]
```




    150




```python
s1['语文']
```




    150




```python
s1.loc['语文']
```




    150




```python
s1.loc[['语文','理综']]
```




    语文    150
    理综    300
    dtype: int32



(2) 隐式索引：

    - 使用整数作为索引值
    - 使用.iloc[]（推荐）

 注意，此时是半开区间


```python
s1.iloc[[0,1]]
```




    语文    150
    数学    150
    dtype: int32



切片


```python
s = Series(data = np.random.randint(0,100,size=10),index=list('ABCDEFGHIK'))
s
```




    A    92
    B    28
    C    50
    D    82
    E    48
    F    57
    G     4
    H    14
    I    87
    K    14
    dtype: int32




```python
# 显式切片 闭区间
s['A':'D']
```




    A    92
    B    28
    C    50
    D    82
    dtype: int32




```python
s.loc['A':'F']
```




    A    92
    B    28
    C    50
    D    82
    E    48
    F    57
    dtype: int32




```python
# 隐式切片 闭区间
s[0:4]
```




    A    92
    B    28
    C    50
    D    82
    dtype: int32




```python
s.iloc[0:4]
```




    A    92
    B    28
    C    50
    D    82
    dtype: int32



============================================

练习2：

使用多种方法对练习1创建的Series s1进行索引和切片：

索引：
数学 150 

切片：
语文 150 
数学 150 
英语 150 

============================================


```python
s1
```




    语文    150
    数学    150
    英语    150
    理综    300
    dtype: int32




```python
s1['数学']
s1.loc['数学']
s1[1]
s1.iloc[1]
```




    150




```python
s1['语文':'英语']
s1.loc['语文':'英语']
s1[0:3]
s1.iloc[0:3]
```




    语文    150
    数学    150
    英语    150
    dtype: int32



#### 3）Series的基本概念

可以把Series看成一个定长的有序字典

可以通过shape，size，index,values等得到series的属性


```python
s1.shape
```




    (4,)




```python
s1.size
```




    4




```python
s1.index
```




    Index(['语文', '数学', '英语', '理综'], dtype='object')




```python
type(s1.index)
```




    pandas.core.indexes.base.Index



可以使用head(),tail()分别查看前n个和后n个值


```python
s.head(2)
s.tail(2)
```




    I    87
    K    14
    dtype: int32



当索引没有对应的值时，可能出现缺失数据显示NaN（not a number）的情况


```python
# Series是索引对齐进行运算
s1 = Series(data = [1,2,3,4],index = list('ABCD'))
s2 = Series(data = [1,2,5,7],index = list('ACDE'))

s1 + s2
```




    A    2.0
    B    NaN
    C    5.0
    D    9.0
    E    NaN
    dtype: float64




```python
n1 = np.array([1,2,3,4])
n2 = np.array([1,2,5,7])
n1 + n2
```




    array([ 2,  4,  8, 11])




```python
np.nan + 5
```




    nan




```python
# pandas的特性，自动处理None为np.nan
s3 = Series(data = [1,2,3,None,4])
s3
```




    0    1.0
    1    2.0
    2    3.0
    3    NaN
    4    4.0
    dtype: float64




```python
n1 = np.array([1,2,3,np.nan,4])
n1
```




    array([ 1.,  2.,  3., nan,  4.])



series的运算

可以使用pd.isnull()，pd.notnull()，或自带isnull(),notnull()函数检测缺失数据

使用Bool_list访问数组对象


```python
s = Series(np.random.randint(0,100,size=5))
s
```




    0    19
    1    98
    2    25
    3    18
    4    85
    dtype: int32




```python
bool_list = [True,False,True,False,True]
s[bool_list]
```




    0    19
    2    25
    4    85
    dtype: int32



Series对象本身及其实例都有一个name属性

#### 4）Series的运算

(1) 适用于numpy的数组运算也适用于Series


```python
# 广播机制同样适用于Series
s1 + 10
```




    A    11
    B    12
    C    13
    D    14
    dtype: int64




```python
# 需求，创建一个分数列表，求每一个分数占总分数的百分比
score = Series(data=np.random.randint(0,150,size=10))
score
```




    0     86
    1    140
    2     39
    3     65
    4    116
    5    117
    6     52
    7     39
    8     96
    9     38
    dtype: int32




```python
score/score.sum()
```




    0    0.109137
    1    0.177665
    2    0.049492
    3    0.082487
    4    0.147208
    5    0.148477
    6    0.065990
    7    0.049492
    8    0.121827
    9    0.048223
    dtype: float64



(2) Series之间的运算

- 在运算中自动对齐不同索引的数据
- 如果索引不对应，则补NaN

- 注意：要想保留所有的index，则需要使用.add()函数


```python
s1 = Series(data = [1,2,3,4],index = list('ABCD'))
s2 = Series(data = [1,2,5,7],index = list('ACDE'))
```


```python
s1.add(s2,fill_value=0)
```




    A    2.0
    B    2.0
    C    5.0
    D    9.0
    E    7.0
    dtype: float64



# 加减乘除
s1.add()
s1.sub()
s1.mul()
s1.div()

============================================

练习3：

1. 想一想Series运算和ndarray运算的规则有什么不同？

2. 新建另一个索引包含“文综”的Series s2，并与s2进行多种算术操作。

============================================


```python
data1 = np.random.randint(0,150,size=4)
index1 = ['语文','数学','英语','理综']
data2 = np.random.randint(0,150,size=4)
index2 = ['语文','数学','英语','文综']

score1 = Series(data=data1,index=index1)
score2 = Series(data=data2,index=index2)
```


```python
score1.add(score2,fill_value=0)
```




    数学    213.0
    文综     65.0
    理综     10.0
    英语    177.0
    语文    228.0
    dtype: float64



### 2、DataFrame


```python
score1.name = '学科分数'
```


```python
score1
```




    语文    114
    数学    128
    英语    115
    理综     10
    Name: 学科分数, dtype: int32




```python
DataFrame(score1)
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>学科分数</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>语文</th>
      <td>114</td>
    </tr>
    <tr>
      <th>数学</th>
      <td>128</td>
    </tr>
    <tr>
      <th>英语</th>
      <td>115</td>
    </tr>
    <tr>
      <th>理综</th>
      <td>10</td>
    </tr>
  </tbody>
</table>
</div>



DataFrame是一个【表格型】的数据结构，可以看做是【由Series组成的字典】（共用同一个索引）。DataFrame由按一定顺序排列的多列数据组成。设计初衷是将Series的使用场景从一维拓展到多维。DataFrame既有行索引，也有列索引。
- 行索引：index
- 列索引：columns
- 值：values（numpy的二维数组）


```python
data = np.random.randint(0,100,size=(5,5))
index = ['小明','小芳','小玲','大黄','小天才']
columns = ['python','java','php','c','c#']
# 行代表数据样本、对象
# 列代表数据属性、特征

df1 = DataFrame(data=data,index=index,columns=columns)
df1
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>python</th>
      <th>java</th>
      <th>php</th>
      <th>c</th>
      <th>c#</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>小明</th>
      <td>53</td>
      <td>54</td>
      <td>98</td>
      <td>33</td>
      <td>54</td>
    </tr>
    <tr>
      <th>小芳</th>
      <td>87</td>
      <td>60</td>
      <td>96</td>
      <td>98</td>
      <td>81</td>
    </tr>
    <tr>
      <th>小玲</th>
      <td>50</td>
      <td>47</td>
      <td>62</td>
      <td>98</td>
      <td>13</td>
    </tr>
    <tr>
      <th>大黄</th>
      <td>19</td>
      <td>78</td>
      <td>92</td>
      <td>87</td>
      <td>45</td>
    </tr>
    <tr>
      <th>小天才</th>
      <td>78</td>
      <td>71</td>
      <td>70</td>
      <td>43</td>
      <td>80</td>
    </tr>
  </tbody>
</table>
</div>




```python
dic = {
    'python':[90,90,50,30,25],
    'java':[90,90,25,50,30],
    'php':[90,90,80,80,80],
    'c':[0,0,100,100,100],
    'c#':[0,0,100,100,100]
}

df2 = DataFrame(data=dic)
df2.index = ['dancer','mery','tom','jack','rose']
df2
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>python</th>
      <th>java</th>
      <th>php</th>
      <th>c</th>
      <th>c#</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>dancer</th>
      <td>90</td>
      <td>90</td>
      <td>90</td>
      <td>0</td>
      <td>0</td>
    </tr>
    <tr>
      <th>mery</th>
      <td>90</td>
      <td>90</td>
      <td>90</td>
      <td>0</td>
      <td>0</td>
    </tr>
    <tr>
      <th>tom</th>
      <td>50</td>
      <td>25</td>
      <td>80</td>
      <td>100</td>
      <td>100</td>
    </tr>
    <tr>
      <th>jack</th>
      <td>30</td>
      <td>50</td>
      <td>80</td>
      <td>100</td>
      <td>100</td>
    </tr>
    <tr>
      <th>rose</th>
      <td>25</td>
      <td>30</td>
      <td>80</td>
      <td>100</td>
      <td>100</td>
    </tr>
  </tbody>
</table>
</div>



#### 1）DataFrame的创建
最常用的方法是传递一个字典来创建。DataFrame以字典的键作为每一【列】的名称，以字典的值（一个数组）作为每一列。

此外，DataFrame会自动加上每一行的索引（和Series一样）。

同Series一样，若传入的列与字典的键不匹配，则相应的值为NaN。


DataFrame属性：values、columns、index、shape


```python
data = np.random.randint(0,100,size=(5,5))
index = ['小明','小芳','小玲','大黄','小天才']
columns = ['python','java','php','c','c#']
# 行代表数据样本、对象
# 列代表数据属性、特征

df1 = DataFrame(data=data,index=index,columns=columns)
df1
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>python</th>
      <th>java</th>
      <th>php</th>
      <th>c</th>
      <th>c#</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>小明</th>
      <td>0</td>
      <td>75</td>
      <td>56</td>
      <td>88</td>
      <td>16</td>
    </tr>
    <tr>
      <th>小芳</th>
      <td>11</td>
      <td>50</td>
      <td>34</td>
      <td>2</td>
      <td>34</td>
    </tr>
    <tr>
      <th>小玲</th>
      <td>12</td>
      <td>58</td>
      <td>17</td>
      <td>51</td>
      <td>3</td>
    </tr>
    <tr>
      <th>大黄</th>
      <td>65</td>
      <td>70</td>
      <td>81</td>
      <td>87</td>
      <td>67</td>
    </tr>
    <tr>
      <th>小天才</th>
      <td>69</td>
      <td>32</td>
      <td>70</td>
      <td>82</td>
      <td>98</td>
    </tr>
  </tbody>
</table>
</div>




```python
df1.values
```




    array([[ 0, 75, 56, 88, 16],
           [11, 50, 34,  2, 34],
           [12, 58, 17, 51,  3],
           [65, 70, 81, 87, 67],
           [69, 32, 70, 82, 98]])




```python
df1.index
```




    Index(['小明', '小芳', '小玲', '大黄', '小天才'], dtype='object')




```python
df1.columns = ['a','b','c','d','e']
```


```python
# index\columns都可以赋值
# values只读的，不能赋值
value = np.random.randint(100,200,size=(5,5))
df1.values = value
df1
```

    D:\software\Anaconda3\lib\site-packages\ipykernel_launcher.py:4: UserWarning: Pandas doesn't allow columns to be created via a new attribute name - see https://pandas.pydata.org/pandas-docs/stable/indexing.html#attribute-access
      after removing the cwd from sys.path.
    


    ---------------------------------------------------------------------------

    AttributeError                            Traceback (most recent call last)

    D:\software\Anaconda3\lib\site-packages\pandas\core\generic.py in __setattr__(self, name, value)
       4406                 else:
    -> 4407                     object.__setattr__(self, name, value)
       4408             except (AttributeError, TypeError):
    

    AttributeError: can't set attribute

    
    During handling of the above exception, another exception occurred:
    

    AttributeError                            Traceback (most recent call last)

    <ipython-input-61-20b0a9462f03> in <module>()
          2 # values只读的，不能赋值
          3 value = np.random.randint(100,200,size=(5,5))
    ----> 4 df1.values = value
          5 df1
    

    D:\software\Anaconda3\lib\site-packages\pandas\core\generic.py in __setattr__(self, name, value)
       4413                                   "stable/indexing.html#attribute-access",
       4414                                   stacklevel=2)
    -> 4415                 object.__setattr__(self, name, value)
       4416 
       4417     # ----------------------------------------------------------------------
    

    AttributeError: can't set attribute



```python
df1.shape
```




    (5, 5)



============================================

练习4：

根据以下考试成绩表，创建一个DataFrame，命名为df：
```
    张三  李四
语文 150  0
数学 150  0
英语 150  0
理综 300  0
```

============================================


```python
# data\index\columns
data = np.array([[150,0],[150,0],[150,0],[300,0]])
index = ['语文','数学','英语','理综']
columns = ['张三','李四']
df = DataFrame(data=data,index=index,columns=columns)

# 字典
dic = {
    '张三':[150,150,150,300],
    '李四':[0,0,0,0]
}
df1 = DataFrame(data=dic,index=index)
display(df1,df)
```


<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>张三</th>
      <th>李四</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>语文</th>
      <td>150</td>
      <td>0</td>
    </tr>
    <tr>
      <th>数学</th>
      <td>150</td>
      <td>0</td>
    </tr>
    <tr>
      <th>英语</th>
      <td>150</td>
      <td>0</td>
    </tr>
    <tr>
      <th>理综</th>
      <td>300</td>
      <td>0</td>
    </tr>
  </tbody>
</table>
</div>



<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>张三</th>
      <th>李四</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>语文</th>
      <td>150</td>
      <td>0</td>
    </tr>
    <tr>
      <th>数学</th>
      <td>150</td>
      <td>0</td>
    </tr>
    <tr>
      <th>英语</th>
      <td>150</td>
      <td>0</td>
    </tr>
    <tr>
      <th>理综</th>
      <td>300</td>
      <td>0</td>
    </tr>
  </tbody>
</table>
</div>


#### 2）DataFrame的索引

(1) 对列进行索引

    - 通过类似字典的方式
    - 通过属性的方式

 可以将DataFrame的列获取为一个Series。返回的Series拥有原DataFrame相同的索引，且name属性也已经设置好了，就是相应的列名。


```python
dic = {
    'name':['dancer','tom','lucy','jack','rose'],
    'age':[19,18,30,25,18],
    'address':['beijing','shanghai','guangzhou','shenzhen','haerbin']
}

df = DataFrame(data=dic)
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>name</th>
      <th>age</th>
      <th>address</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>dancer</td>
      <td>19</td>
      <td>beijing</td>
    </tr>
    <tr>
      <th>1</th>
      <td>tom</td>
      <td>18</td>
      <td>shanghai</td>
    </tr>
    <tr>
      <th>2</th>
      <td>lucy</td>
      <td>30</td>
      <td>guangzhou</td>
    </tr>
    <tr>
      <th>3</th>
      <td>jack</td>
      <td>25</td>
      <td>shenzhen</td>
    </tr>
    <tr>
      <th>4</th>
      <td>rose</td>
      <td>18</td>
      <td>haerbin</td>
    </tr>
  </tbody>
</table>
</div>




```python
# # 不可以这样进行隐式索引访问
# df[0]
```


```python
# 对列进行索引，参数必须是列索引标签
df['address']
```




    0      beijing
    1     shanghai
    2    guangzhou
    3     shenzhen
    4      haerbin
    Name: address, dtype: object




```python
# 使用类似属性的方式访问一列
df.address
```




    0      beijing
    1     shanghai
    2    guangzhou
    3     shenzhen
    4      haerbin
    Name: address, dtype: object



(2) 对行进行索引

    - 使用.ix[]来进行行索引
    - 使用.loc[]加index来进行行索引
    - 使用.iloc[]加整数来进行行索引
    
 同样返回一个Series，index为原来的columns。


```python
# 以表格中的某一列重新设置行索引，set_index（标签名）
df1 = df.set_index(keys=['name'])
```


```python
df1
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>age</th>
      <th>address</th>
    </tr>
    <tr>
      <th>name</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>dancer</th>
      <td>19</td>
      <td>beijing</td>
    </tr>
    <tr>
      <th>tom</th>
      <td>18</td>
      <td>shanghai</td>
    </tr>
    <tr>
      <th>lucy</th>
      <td>30</td>
      <td>guangzhou</td>
    </tr>
    <tr>
      <th>jack</th>
      <td>25</td>
      <td>shenzhen</td>
    </tr>
    <tr>
      <th>rose</th>
      <td>18</td>
      <td>haerbin</td>
    </tr>
  </tbody>
</table>
</div>




```python
df1.loc['dancer']
```




    age             19
    address    beijing
    Name: dancer, dtype: object




```python
df.loc[1]
```




    name            tom
    age              18
    address    shanghai
    Name: 1, dtype: object




```python
df1
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>age</th>
      <th>address</th>
    </tr>
    <tr>
      <th>name</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>dancer</th>
      <td>19</td>
      <td>beijing</td>
    </tr>
    <tr>
      <th>tom</th>
      <td>18</td>
      <td>shanghai</td>
    </tr>
    <tr>
      <th>lucy</th>
      <td>30</td>
      <td>guangzhou</td>
    </tr>
    <tr>
      <th>jack</th>
      <td>25</td>
      <td>shenzhen</td>
    </tr>
    <tr>
      <th>rose</th>
      <td>18</td>
      <td>haerbin</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 隐式索引访问行
df1.ix[0]
```

    D:\software\Anaconda3\lib\site-packages\ipykernel_launcher.py:2: DeprecationWarning: 
    .ix is deprecated. Please use
    .loc for label based indexing or
    .iloc for positional indexing
    
    See the documentation here:
    http://pandas.pydata.org/pandas-docs/stable/indexing.html#ix-indexer-is-deprecated
      
    




    age             19
    address    beijing
    Name: dancer, dtype: object



(3) 对元素索引的方法
    - 使用列索引
    - 使用行索引(iloc[3,1]相当于两个参数;iloc[[3,3]] 里面的[3,3]看做一个参数)
    - 使用values属性（二维numpy数组）


```python
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>name</th>
      <th>age</th>
      <th>address</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>dancer</td>
      <td>19</td>
      <td>beijing</td>
    </tr>
    <tr>
      <th>1</th>
      <td>tom</td>
      <td>18</td>
      <td>shanghai</td>
    </tr>
    <tr>
      <th>2</th>
      <td>lucy</td>
      <td>30</td>
      <td>guangzhou</td>
    </tr>
    <tr>
      <th>3</th>
      <td>jack</td>
      <td>25</td>
      <td>shenzhen</td>
    </tr>
    <tr>
      <th>4</th>
      <td>rose</td>
      <td>18</td>
      <td>haerbin</td>
    </tr>
  </tbody>
</table>
</div>




```python
df.name[1]
```




    'tom'




```python
df.loc[1]['name']
```




    'tom'




```python
df.loc[1,'name']
```




    'tom'




```python
# 获取索引为1的行和索引为2的列对应的值
df.iloc[1,2]
```




    'shanghai'




```python
# 获取多行 索引为1和2的行
df.iloc[[1,2]]
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>name</th>
      <th>age</th>
      <th>address</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>1</th>
      <td>tom</td>
      <td>18</td>
      <td>shanghai</td>
    </tr>
    <tr>
      <th>2</th>
      <td>lucy</td>
      <td>30</td>
      <td>guangzhou</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 获取多列
df[['address','name']]
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>address</th>
      <th>name</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>beijing</td>
      <td>dancer</td>
    </tr>
    <tr>
      <th>1</th>
      <td>shanghai</td>
      <td>tom</td>
    </tr>
    <tr>
      <th>2</th>
      <td>guangzhou</td>
      <td>lucy</td>
    </tr>
    <tr>
      <th>3</th>
      <td>shenzhen</td>
      <td>jack</td>
    </tr>
    <tr>
      <th>4</th>
      <td>haerbin</td>
      <td>rose</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 【重点】
# 获取一列  df[列标签]              获取多列[[列标签1，列标签2]]
# 获取一行  df.loc[行标签]          获取多行 df.loc[[行标签1，行标签2]]
# 获取元素  df.loc[行标签，列标签]
```

### 切片


```python
# 行索引
df[0:2]
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>name</th>
      <th>age</th>
      <th>address</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>dancer</td>
      <td>19</td>
      <td>beijing</td>
    </tr>
    <tr>
      <th>1</th>
      <td>tom</td>
      <td>18</td>
      <td>shanghai</td>
    </tr>
  </tbody>
</table>
</div>




```python

# 隐式索引
df.iloc[0:2]
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>name</th>
      <th>age</th>
      <th>address</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>dancer</td>
      <td>19</td>
      <td>beijing</td>
    </tr>
    <tr>
      <th>1</th>
      <td>tom</td>
      <td>18</td>
      <td>shanghai</td>
    </tr>
  </tbody>
</table>
</div>




```python
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>name</th>
      <th>age</th>
      <th>address</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>dancer</td>
      <td>19</td>
      <td>beijing</td>
    </tr>
    <tr>
      <th>1</th>
      <td>tom</td>
      <td>18</td>
      <td>shanghai</td>
    </tr>
    <tr>
      <th>2</th>
      <td>lucy</td>
      <td>30</td>
      <td>guangzhou</td>
    </tr>
    <tr>
      <th>3</th>
      <td>jack</td>
      <td>25</td>
      <td>shenzhen</td>
    </tr>
    <tr>
      <th>4</th>
      <td>rose</td>
      <td>18</td>
      <td>haerbin</td>
    </tr>
  </tbody>
</table>
</div>




```python
df.loc[:,'age':'address']
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>age</th>
      <th>address</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>19</td>
      <td>beijing</td>
    </tr>
    <tr>
      <th>1</th>
      <td>18</td>
      <td>shanghai</td>
    </tr>
    <tr>
      <th>2</th>
      <td>30</td>
      <td>guangzhou</td>
    </tr>
    <tr>
      <th>3</th>
      <td>25</td>
      <td>shenzhen</td>
    </tr>
    <tr>
      <th>4</th>
      <td>18</td>
      <td>haerbin</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 列切片

df.iloc[:,0:3]
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>name</th>
      <th>age</th>
      <th>address</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>dancer</td>
      <td>19</td>
      <td>beijing</td>
    </tr>
    <tr>
      <th>1</th>
      <td>tom</td>
      <td>18</td>
      <td>shanghai</td>
    </tr>
    <tr>
      <th>2</th>
      <td>lucy</td>
      <td>30</td>
      <td>guangzhou</td>
    </tr>
    <tr>
      <th>3</th>
      <td>jack</td>
      <td>25</td>
      <td>shenzhen</td>
    </tr>
    <tr>
      <th>4</th>
      <td>rose</td>
      <td>18</td>
      <td>haerbin</td>
    </tr>
  </tbody>
</table>
</div>



【注意】
直接用中括号时：
- 索引表示的是列索引
- 切片表示的是行切片

============================================

练习5：

使用多种方法对df进行索引和切片，并比较其中的区别

============================================


```python
data = np.random.randint(0,150,size=(5,5))
index = list('ABCDE')
columns = ['python','Java','C','OC','PHP']
df = DataFrame(data=data,index=index,columns=columns)
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>python</th>
      <th>Java</th>
      <th>C</th>
      <th>OC</th>
      <th>PHP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>A</th>
      <td>101</td>
      <td>63</td>
      <td>114</td>
      <td>7</td>
      <td>136</td>
    </tr>
    <tr>
      <th>B</th>
      <td>67</td>
      <td>40</td>
      <td>5</td>
      <td>60</td>
      <td>59</td>
    </tr>
    <tr>
      <th>C</th>
      <td>29</td>
      <td>61</td>
      <td>78</td>
      <td>117</td>
      <td>31</td>
    </tr>
    <tr>
      <th>D</th>
      <td>27</td>
      <td>76</td>
      <td>27</td>
      <td>21</td>
      <td>21</td>
    </tr>
    <tr>
      <th>E</th>
      <td>117</td>
      <td>129</td>
      <td>9</td>
      <td>54</td>
      <td>53</td>
    </tr>
  </tbody>
</table>
</div>




```python
df[['Java','C']]
df.loc[:,'Java':'C']
df.iloc[:,1:3]
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>Java</th>
      <th>C</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>A</th>
      <td>63</td>
      <td>114</td>
    </tr>
    <tr>
      <th>B</th>
      <td>40</td>
      <td>5</td>
    </tr>
    <tr>
      <th>C</th>
      <td>61</td>
      <td>78</td>
    </tr>
    <tr>
      <th>D</th>
      <td>76</td>
      <td>27</td>
    </tr>
    <tr>
      <th>E</th>
      <td>129</td>
      <td>9</td>
    </tr>
  </tbody>
</table>
</div>




```python
df.loc['B':'C']
df['B':'C']
df.iloc[1:3]
df.loc[['B','C']]
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>python</th>
      <th>Java</th>
      <th>C</th>
      <th>OC</th>
      <th>PHP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>B</th>
      <td>67</td>
      <td>40</td>
      <td>5</td>
      <td>60</td>
      <td>59</td>
    </tr>
    <tr>
      <th>C</th>
      <td>29</td>
      <td>61</td>
      <td>78</td>
      <td>117</td>
      <td>31</td>
    </tr>
  </tbody>
</table>
</div>




```python
df['Java']['A']
df.loc['A']['Java']
df.loc['A','Java']
```




    63




```python
df['PHP']
df.PHP
```




    A    136
    B     59
    C     31
    D     21
    E     53
    Name: PHP, dtype: int32




```python
df.loc['B']
df.iloc[1]
df.loc['B':'B']
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>python</th>
      <th>Java</th>
      <th>C</th>
      <th>OC</th>
      <th>PHP</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>B</th>
      <td>67</td>
      <td>40</td>
      <td>5</td>
      <td>60</td>
      <td>59</td>
    </tr>
  </tbody>
</table>
</div>



#### 3）DataFrame的运算

numpy运算 聚合  np.nansum()
广播 空值

Sereis  s.add
索引对齐

（1） DataFrame之间的运算

同Series一样：

- 在运算中自动对齐相同索引的数据
- 如果索引不对应，则补NaN


```python
data = np.random.randint(0,100,size=(5,5))
index = list('ABCDE')
columns = list('甲乙丙丁戊')

df1 = DataFrame(data=data,index=index,columns=columns)
df1
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>甲</th>
      <th>乙</th>
      <th>丙</th>
      <th>丁</th>
      <th>戊</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>A</th>
      <td>6</td>
      <td>4</td>
      <td>42</td>
      <td>11</td>
      <td>14</td>
    </tr>
    <tr>
      <th>B</th>
      <td>54</td>
      <td>45</td>
      <td>95</td>
      <td>74</td>
      <td>98</td>
    </tr>
    <tr>
      <th>C</th>
      <td>64</td>
      <td>46</td>
      <td>6</td>
      <td>82</td>
      <td>34</td>
    </tr>
    <tr>
      <th>D</th>
      <td>44</td>
      <td>31</td>
      <td>88</td>
      <td>6</td>
      <td>85</td>
    </tr>
    <tr>
      <th>E</th>
      <td>62</td>
      <td>52</td>
      <td>87</td>
      <td>56</td>
      <td>50</td>
    </tr>
  </tbody>
</table>
</div>




```python
data2 = np.random.randint(100,200,size=(3,3))
index2 = list('ABC')
columns2 = list('甲乙寅')

df2 = DataFrame(data=data2,index=index2,columns=columns2)
df2
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>甲</th>
      <th>乙</th>
      <th>寅</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>A</th>
      <td>153</td>
      <td>161</td>
      <td>178</td>
    </tr>
    <tr>
      <th>B</th>
      <td>178</td>
      <td>160</td>
      <td>192</td>
    </tr>
    <tr>
      <th>C</th>
      <td>160</td>
      <td>169</td>
      <td>177</td>
    </tr>
  </tbody>
</table>
</div>




```python
df1 + df2
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>丁</th>
      <th>丙</th>
      <th>乙</th>
      <th>寅</th>
      <th>戊</th>
      <th>甲</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>A</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>165.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>159.0</td>
    </tr>
    <tr>
      <th>B</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>205.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>232.0</td>
    </tr>
    <tr>
      <th>C</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>215.0</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>224.0</td>
    </tr>
    <tr>
      <th>D</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>E</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
  </tbody>
</table>
</div>




```python
df1.add(df2,fill_value=0)
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>丁</th>
      <th>丙</th>
      <th>乙</th>
      <th>寅</th>
      <th>戊</th>
      <th>甲</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>A</th>
      <td>11.0</td>
      <td>42.0</td>
      <td>165.0</td>
      <td>178.0</td>
      <td>14.0</td>
      <td>159.0</td>
    </tr>
    <tr>
      <th>B</th>
      <td>74.0</td>
      <td>95.0</td>
      <td>205.0</td>
      <td>192.0</td>
      <td>98.0</td>
      <td>232.0</td>
    </tr>
    <tr>
      <th>C</th>
      <td>82.0</td>
      <td>6.0</td>
      <td>215.0</td>
      <td>177.0</td>
      <td>34.0</td>
      <td>224.0</td>
    </tr>
    <tr>
      <th>D</th>
      <td>6.0</td>
      <td>88.0</td>
      <td>31.0</td>
      <td>NaN</td>
      <td>85.0</td>
      <td>44.0</td>
    </tr>
    <tr>
      <th>E</th>
      <td>56.0</td>
      <td>87.0</td>
      <td>52.0</td>
      <td>NaN</td>
      <td>50.0</td>
      <td>62.0</td>
    </tr>
  </tbody>
</table>
</div>



创建DataFrame df1 不同人员的各科目成绩，月考一

创建DataFrame df2 不同人员的各科目成绩，月考二  
有新学生转入

下面是Python 操作符与pandas操作函数的对应表：

| Python Operator | Pandas Method(s)                      |
|-----------------|---------------------------------------|
| ``+``           | ``add()``                             |
| ``-``           | ``sub()``, ``subtract()``             |
| ``*``           | ``mul()``, ``multiply()``             |
| ``/``           | ``truediv()``, ``div()``, ``divide()``|
| ``//``          | ``floordiv()``                        |
| ``%``           | ``mod()``                             |
| ``**``          | ``pow()``                             |


（2） Series与DataFrame之间的运算

【重要】

- 使用Python操作符：以行为单位操作（参数必须是行），对所有行都有效。（类似于numpy中二维数组与一维数组的运算，但可能出现NaN）

- 使用pandas操作函数：

        axis=0：以列为单位操作（参数必须是列），对所有列都有效。
        axis=1：以行为单位操作（参数必须是行），对所有行都有效。


```python
s1 = Series(data=np.random.randint(0,100,size=5),index=list('ABCDE'))
df1 = DataFrame(data = np.random.randint(0,100,size=(5,5)),index=list('BCDEF'),columns=list('甲乙丙丁戊'))
display(s1,df1)
```


    A    57
    B    38
    C    92
    D    99
    E    16
    dtype: int32



<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>甲</th>
      <th>乙</th>
      <th>丙</th>
      <th>丁</th>
      <th>戊</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>B</th>
      <td>29</td>
      <td>54</td>
      <td>68</td>
      <td>76</td>
      <td>68</td>
    </tr>
    <tr>
      <th>C</th>
      <td>88</td>
      <td>22</td>
      <td>34</td>
      <td>7</td>
      <td>85</td>
    </tr>
    <tr>
      <th>D</th>
      <td>85</td>
      <td>67</td>
      <td>56</td>
      <td>0</td>
      <td>50</td>
    </tr>
    <tr>
      <th>E</th>
      <td>14</td>
      <td>83</td>
      <td>5</td>
      <td>55</td>
      <td>22</td>
    </tr>
    <tr>
      <th>F</th>
      <td>91</td>
      <td>31</td>
      <td>79</td>
      <td>49</td>
      <td>73</td>
    </tr>
  </tbody>
</table>
</div>



```python
df1 + s1
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>A</th>
      <th>B</th>
      <th>C</th>
      <th>D</th>
      <th>E</th>
      <th>丁</th>
      <th>丙</th>
      <th>乙</th>
      <th>戊</th>
      <th>甲</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>B</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>C</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>D</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>E</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>F</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
  </tbody>
</table>
</div>




```python
display(df1.shape,s1.shape)
```


    (5, 5)



    (5,)



```python
# fill_value在df和series之间运算时，不能使用
df1.add(s1,axis=0)
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>甲</th>
      <th>乙</th>
      <th>丙</th>
      <th>丁</th>
      <th>戊</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>A</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>B</th>
      <td>67.0</td>
      <td>92.0</td>
      <td>106.0</td>
      <td>114.0</td>
      <td>106.0</td>
    </tr>
    <tr>
      <th>C</th>
      <td>180.0</td>
      <td>114.0</td>
      <td>126.0</td>
      <td>99.0</td>
      <td>177.0</td>
    </tr>
    <tr>
      <th>D</th>
      <td>184.0</td>
      <td>166.0</td>
      <td>155.0</td>
      <td>99.0</td>
      <td>149.0</td>
    </tr>
    <tr>
      <th>E</th>
      <td>30.0</td>
      <td>99.0</td>
      <td>21.0</td>
      <td>71.0</td>
      <td>38.0</td>
    </tr>
    <tr>
      <th>F</th>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
  </tbody>
</table>
</div>



  axis=0（0 == index 行）：以列为单位操作（参数必须是列），对所有列都有效。
  axis=1（1 == columns 列）：以行为单位操作（参数必须是行），对所有行都有效。

【注意】fill_value在df和series之间运算时，不能使用

============================================

练习6：

1. 假设ddd是期中考试成绩，ddd2是期末考试成绩，请自由创建ddd2，并将其与ddd相加，求期中期末平均值。

2. 假设张三期中考试数学被发现作弊，要记为0分，如何实现？

3. 李四因为举报张三作弊立功，期中考试所有科目加100分，如何实现？

4. 后来老师发现有一道题出错了，为了安抚学生情绪，给每位学生每个科目都加10分，如何实现？

============================================


```python
score1 = DataFrame(data=np.random.randint(0,100,size=(3,3)),index=['dancer','tom','jack'],columns=['python','c','java'])
score2 = DataFrame(data=np.random.randint(0,100,size=(3,3)),index=['dancer','tom','jack'],columns=['python','c','java'])
display(score1,score2)
```


<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>python</th>
      <th>c</th>
      <th>java</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>dancer</th>
      <td>90</td>
      <td>76</td>
      <td>69</td>
    </tr>
    <tr>
      <th>tom</th>
      <td>86</td>
      <td>78</td>
      <td>24</td>
    </tr>
    <tr>
      <th>jack</th>
      <td>86</td>
      <td>81</td>
      <td>21</td>
    </tr>
  </tbody>
</table>
</div>



<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>python</th>
      <th>c</th>
      <th>java</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>dancer</th>
      <td>26</td>
      <td>83</td>
      <td>45</td>
    </tr>
    <tr>
      <th>tom</th>
      <td>3</td>
      <td>75</td>
      <td>91</td>
    </tr>
    <tr>
      <th>jack</th>
      <td>60</td>
      <td>85</td>
      <td>53</td>
    </tr>
  </tbody>
</table>
</div>



```python
mean = (score1 + score2)/2
display(mean)
```


<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>python</th>
      <th>c</th>
      <th>java</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>dancer</th>
      <td>58.0</td>
      <td>79.5</td>
      <td>57.0</td>
    </tr>
    <tr>
      <th>tom</th>
      <td>44.5</td>
      <td>76.5</td>
      <td>57.5</td>
    </tr>
    <tr>
      <th>jack</th>
      <td>73.0</td>
      <td>83.0</td>
      <td>37.0</td>
    </tr>
  </tbody>
</table>
</div>



```python
score1.loc['dancer','c'] = 0
score1
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>python</th>
      <th>c</th>
      <th>java</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>dancer</th>
      <td>90</td>
      <td>0</td>
      <td>69</td>
    </tr>
    <tr>
      <th>tom</th>
      <td>86</td>
      <td>78</td>
      <td>24</td>
    </tr>
    <tr>
      <th>jack</th>
      <td>86</td>
      <td>81</td>
      <td>21</td>
    </tr>
  </tbody>
</table>
</div>




```python
score1.loc['tom'] += 100
```


```python
score1
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>python</th>
      <th>c</th>
      <th>java</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>dancer</th>
      <td>90</td>
      <td>0</td>
      <td>69</td>
    </tr>
    <tr>
      <th>tom</th>
      <td>186</td>
      <td>178</td>
      <td>124</td>
    </tr>
    <tr>
      <th>jack</th>
      <td>86</td>
      <td>81</td>
      <td>21</td>
    </tr>
  </tbody>
</table>
</div>




```python
score1 += 10
score1
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>python</th>
      <th>c</th>
      <th>java</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>dancer</th>
      <td>100</td>
      <td>10</td>
      <td>79</td>
    </tr>
    <tr>
      <th>tom</th>
      <td>196</td>
      <td>188</td>
      <td>134</td>
    </tr>
    <tr>
      <th>jack</th>
      <td>96</td>
      <td>91</td>
      <td>31</td>
    </tr>
  </tbody>
</table>
</div>


