
# pandas层次化索引

## 1. 创建多层行索引

### 1) 隐式构造

最常见的方法是给DataFrame构造函数的index参数传递两个或更多的数组

- Series也可以创建多层索引


```python
import numpy as np
import pandas as pd
from pandas import Series,DataFrame
```


```python
df=DataFrame(np.random.rand(4,2),index=[['a','a','b','b'],[1,2,1,2]],columns=['data1','data2'])
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
      <th></th>
      <th>data1</th>
      <th>data2</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th rowspan="2" valign="top">a</th>
      <th>1</th>
      <td>0.551073</td>
      <td>0.842390</td>
    </tr>
    <tr>
      <th>2</th>
      <td>0.684310</td>
      <td>0.857883</td>
    </tr>
    <tr>
      <th rowspan="2" valign="top">b</th>
      <th>1</th>
      <td>0.090266</td>
      <td>0.400649</td>
    </tr>
    <tr>
      <th>2</th>
      <td>0.490777</td>
      <td>0.565122</td>
    </tr>
  </tbody>
</table>
</div>




```python
data = np.random.randint(0,1000,size=8)

# [['7月','8月'],['0#','90#','95#','97#']]

# [['7月','0#'],['7月','90#'],['7月','95#'],['7月','98#'],['8月','0#'],['8月','90#'],['8月','95#'],['8月','98#']]

index = [['7月','7月','7月','7月','8月','8月','8月','8月'],['0#','90#','95#','97#','0#','90#','95#','97#']]

s = Series(data=data,index=index)
DataFrame(s)
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
      <th></th>
      <th>0</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th rowspan="4" valign="top">7月</th>
      <th>0#</th>
      <td>786</td>
    </tr>
    <tr>
      <th>90#</th>
      <td>298</td>
    </tr>
    <tr>
      <th>95#</th>
      <td>527</td>
    </tr>
    <tr>
      <th>97#</th>
      <td>296</td>
    </tr>
    <tr>
      <th rowspan="4" valign="top">8月</th>
      <th>0#</th>
      <td>428</td>
    </tr>
    <tr>
      <th>90#</th>
      <td>963</td>
    </tr>
    <tr>
      <th>95#</th>
      <td>484</td>
    </tr>
    <tr>
      <th>97#</th>
      <td>21</td>
    </tr>
  </tbody>
</table>
</div>



### 2) 显示构造pd.MultiIndex

- 使用数组


```python
columns = pd.MultiIndex.from_arrays([[1, 1, 2, 2], ['red', 'blue', 'red', 'blue']])
display(columns)
data=np.random.randint(0,100,size=(3,4))
display(data)
df=DataFrame(data=data,columns=columns)
df
```


    MultiIndex(levels=[[1, 2], ['blue', 'red']],
               labels=[[0, 0, 1, 1], [1, 0, 1, 0]])



    array([[56,  7, 41, 55],
           [15, 43, 62, 54],
           [ 8,  5, 82, 27]])





<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead tr th {
        text-align: left;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr>
      <th></th>
      <th colspan="2" halign="left">1</th>
      <th colspan="2" halign="left">2</th>
    </tr>
    <tr>
      <th></th>
      <th>red</th>
      <th>blue</th>
      <th>red</th>
      <th>blue</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>56</td>
      <td>7</td>
      <td>41</td>
      <td>55</td>
    </tr>
    <tr>
      <th>1</th>
      <td>15</td>
      <td>43</td>
      <td>62</td>
      <td>54</td>
    </tr>
    <tr>
      <th>2</th>
      <td>8</td>
      <td>5</td>
      <td>82</td>
      <td>27</td>
    </tr>
  </tbody>
</table>
</div>



- 使用tuple


```python
columns = pd.MultiIndex.from_tuples([(1, u'red'), (1, u'blue'),
              (2, u'red'), (2, u'blue')])
display(columns)
data = np.random.randint(0,1000,size=(3,4))
display(data)
df = DataFrame(data=data,columns=columns)
df
```


    MultiIndex(levels=[[1, 2], ['blue', 'red']],
               labels=[[0, 0, 1, 1], [1, 0, 1, 0]])



    array([[580, 466, 166, 331],
           [397, 977, 303, 463],
           [112, 118, 818, 476]])





<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead tr th {
        text-align: left;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr>
      <th></th>
      <th colspan="2" halign="left">1</th>
      <th colspan="2" halign="left">2</th>
    </tr>
    <tr>
      <th></th>
      <th>red</th>
      <th>blue</th>
      <th>red</th>
      <th>blue</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>580</td>
      <td>466</td>
      <td>166</td>
      <td>331</td>
    </tr>
    <tr>
      <th>1</th>
      <td>397</td>
      <td>977</td>
      <td>303</td>
      <td>463</td>
    </tr>
    <tr>
      <th>2</th>
      <td>112</td>
      <td>118</td>
      <td>818</td>
      <td>476</td>
    </tr>
  </tbody>
</table>
</div>



- 使用product

    最简单，推荐使用


```python
columns = pd.MultiIndex.from_product([['7月','8月'],['0#','90#','95#','97#']])
display(columns)
data = np.random.randint(0,1000,size=(3,8))
display(data)
df = DataFrame(data=data,columns=columns)
df
```


    MultiIndex(levels=[['7月', '8月'], ['0#', '90#', '95#', '97#']],
               labels=[[0, 0, 0, 0, 1, 1, 1, 1], [0, 1, 2, 3, 0, 1, 2, 3]])



    array([[674, 485, 829, 227, 363, 768, 540, 752],
           [573, 959, 204, 142,  88, 910, 216, 702],
           [814, 852, 545, 424, 380, 407, 440, 903]])





<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead tr th {
        text-align: left;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr>
      <th></th>
      <th colspan="4" halign="left">7月</th>
      <th colspan="4" halign="left">8月</th>
    </tr>
    <tr>
      <th></th>
      <th>0#</th>
      <th>90#</th>
      <th>95#</th>
      <th>97#</th>
      <th>0#</th>
      <th>90#</th>
      <th>95#</th>
      <th>97#</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>674</td>
      <td>485</td>
      <td>829</td>
      <td>227</td>
      <td>363</td>
      <td>768</td>
      <td>540</td>
      <td>752</td>
    </tr>
    <tr>
      <th>1</th>
      <td>573</td>
      <td>959</td>
      <td>204</td>
      <td>142</td>
      <td>88</td>
      <td>910</td>
      <td>216</td>
      <td>702</td>
    </tr>
    <tr>
      <th>2</th>
      <td>814</td>
      <td>852</td>
      <td>545</td>
      <td>424</td>
      <td>380</td>
      <td>407</td>
      <td>440</td>
      <td>903</td>
    </tr>
  </tbody>
</table>
</div>



- 人口统计


```python
Mindex = pd.MultiIndex.from_tuples([('California',2000),('California',2010),
        ('New York',2000),('New York',2010),
        ('Texas',2000),('Texas',2010)])

#Mindex = pd.MultiIndex.from_product([['California','New York','Texas'],[2000,2010]])
populations=np.random.randint(0,1000000,size=6)
pop = DataFrame(populations,index=Mindex,columns = ['人口'])
pop
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
      <th></th>
      <th>人口</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th rowspan="2" valign="top">California</th>
      <th>2000</th>
      <td>431190</td>
    </tr>
    <tr>
      <th>2010</th>
      <td>298318</td>
    </tr>
    <tr>
      <th rowspan="2" valign="top">New York</th>
      <th>2000</th>
      <td>395240</td>
    </tr>
    <tr>
      <th>2010</th>
      <td>862462</td>
    </tr>
    <tr>
      <th rowspan="2" valign="top">Texas</th>
      <th>2000</th>
      <td>226286</td>
    </tr>
    <tr>
      <th>2010</th>
      <td>102173</td>
    </tr>
  </tbody>
</table>
</div>



============================================

练习8：

1. 创建一个DataFrame，表示出张三李四期中期末各科成绩

============================================


```python
index = pd.MultiIndex.from_product([['期中','期末'],['python','c','java']])
columns = ['张三','李四']
data = np.random.randint(0,150,size=(6,2))
score = DataFrame(data=data,index=index,columns=columns)
score
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
      <th></th>
      <th>张三</th>
      <th>李四</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th rowspan="3" valign="top">期中</th>
      <th>python</th>
      <td>139</td>
      <td>72</td>
    </tr>
    <tr>
      <th>c</th>
      <td>61</td>
      <td>106</td>
    </tr>
    <tr>
      <th>java</th>
      <td>73</td>
      <td>9</td>
    </tr>
    <tr>
      <th rowspan="3" valign="top">期末</th>
      <th>python</th>
      <td>50</td>
      <td>6</td>
    </tr>
    <tr>
      <th>c</th>
      <td>83</td>
      <td>147</td>
    </tr>
    <tr>
      <th>java</th>
      <td>9</td>
      <td>63</td>
    </tr>
  </tbody>
</table>
</div>



## 2. 多层列索引

除了行索引index，列索引columns也能用同样的方法创建多层索引


```python
a = np.random.randint(0,150,(2,8))
Mindex = pd.MultiIndex.from_product([['语文','数学','英语','理综'],['期中','期末']])
ddd = DataFrame(data = a,
                index = ['张三','李四'],
                columns = Mindex)
ddd
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead tr th {
        text-align: left;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr>
      <th></th>
      <th colspan="2" halign="left">语文</th>
      <th colspan="2" halign="left">数学</th>
      <th colspan="2" halign="left">英语</th>
      <th colspan="2" halign="left">理综</th>
    </tr>
    <tr>
      <th></th>
      <th>期中</th>
      <th>期末</th>
      <th>期中</th>
      <th>期末</th>
      <th>期中</th>
      <th>期末</th>
      <th>期中</th>
      <th>期末</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>张三</th>
      <td>17</td>
      <td>147</td>
      <td>58</td>
      <td>56</td>
      <td>41</td>
      <td>23</td>
      <td>36</td>
      <td>88</td>
    </tr>
    <tr>
      <th>李四</th>
      <td>45</td>
      <td>39</td>
      <td>71</td>
      <td>7</td>
      <td>45</td>
      <td>137</td>
      <td>93</td>
      <td>43</td>
    </tr>
  </tbody>
</table>
</div>



## 3. 多层索引对象的索引与切片操作

### 1）Series的操作

【重要】对于Series来说，直接中括号[]与使用.loc()完全一样，推荐使用.loc中括号索引和切片。


```python
index = [['7月','7月','7月','7月','8月','8月','8月','8月'],['0#','90#','95#','97#','0#','90#','95#','97#']]
data = np.random.randint(0,1000,size=8)
print(data)
s = Series(data=data,index=index)
s
```

    [ 81 387 796 303 454 247 527 383]
    




    7月  0#      81
        90#    387
        95#    796
        97#    303
    8月  0#     454
        90#    247
        95#    527
        97#    383
    dtype: int32



(1) 索引


```python
# 特有的访问方式
print(s.loc['7月','0#'])
s.loc['7月']['0#']
```

    81
    




    81



(2) 切片


```python
s.loc['7月']['0#':'95#']
```




    0#      81
    90#    387
    95#    796
    dtype: int32




```python
# 使用隐式索引进行切片，可以忽视多级索引
s.iloc[2:7]
```




    7月  95#    796
        97#    303
    8月  0#     454
        90#    247
        95#    527
    dtype: int32



### 2）DataFrame的操作

(1) 可以直接使用列名称来进行列索引


```python
score
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
      <th></th>
      <th>张三</th>
      <th>李四</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th rowspan="3" valign="top">期中</th>
      <th>python</th>
      <td>139</td>
      <td>72</td>
    </tr>
    <tr>
      <th>c</th>
      <td>61</td>
      <td>106</td>
    </tr>
    <tr>
      <th>java</th>
      <td>73</td>
      <td>9</td>
    </tr>
    <tr>
      <th rowspan="3" valign="top">期末</th>
      <th>python</th>
      <td>50</td>
      <td>6</td>
    </tr>
    <tr>
      <th>c</th>
      <td>83</td>
      <td>147</td>
    </tr>
    <tr>
      <th>java</th>
      <td>9</td>
      <td>63</td>
    </tr>
  </tbody>
</table>
</div>




```python
score['张三']
```




    期中  python    139
        c          61
        java       73
    期末  python     50
        c          83
        java        9
    Name: 张三, dtype: int32



行多级索引的索引和切片操作


```python
score
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
      <th></th>
      <th>张三</th>
      <th>李四</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th rowspan="3" valign="top">期中</th>
      <th>python</th>
      <td>139</td>
      <td>72</td>
    </tr>
    <tr>
      <th>c</th>
      <td>61</td>
      <td>106</td>
    </tr>
    <tr>
      <th>java</th>
      <td>73</td>
      <td>9</td>
    </tr>
    <tr>
      <th rowspan="3" valign="top">期末</th>
      <th>python</th>
      <td>50</td>
      <td>6</td>
    </tr>
    <tr>
      <th>c</th>
      <td>83</td>
      <td>147</td>
    </tr>
    <tr>
      <th>java</th>
      <td>9</td>
      <td>63</td>
    </tr>
  </tbody>
</table>
</div>




```python
display(score.loc['期中'].loc['python','李四'])
display(score.iloc[0]['李四'])
display(score['李四'][0])
display(score.iloc[0,1])
display(score['李四'].loc['期中','python'])
```


    72



    72



    72



    72



    72



```python
# 切片
print(score.loc['期中']['python':'c'])
score.iloc[2:4]
```

             张三   李四
    python  139   72
    c        61  106
    




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
      <th></th>
      <th>张三</th>
      <th>李四</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>期中</th>
      <th>java</th>
      <td>73</td>
      <td>9</td>
    </tr>
    <tr>
      <th>期末</th>
      <th>python</th>
      <td>50</td>
      <td>6</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 需求：获取期中期末的python成绩
score.iloc[[0,3]]
# score.loc[[0,3]]
# 还可以使用stack变换来解决此问题
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
      <th></th>
      <th>张三</th>
      <th>李四</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>期中</th>
      <th>python</th>
      <td>139</td>
      <td>72</td>
    </tr>
    <tr>
      <th>期末</th>
      <th>python</th>
      <td>50</td>
      <td>6</td>
    </tr>
  </tbody>
</table>
</div>




```python
score.loc['期中'].loc['python':'c','张三']
```




    python    139
    c          61
    Name: 张三, dtype: int32



列多级索引的索引和切片操作

(2) 使用行索引需要用ix()，loc()等函数

【极其重要】推荐使用loc()函数

注意在对行索引的时候，若一级行索引还有多个，对二级行索引会遇到问题！也就是说，无法直接对二级索引进行索引，必须让二级索引变成一级索引后才能对其进行索引！

============================================

练习9：

1. 分析比较Series和DataFrame各种索引的方式，熟练掌握.loc()方法

2. 假设张三再一次在期中考试的时候因为特殊原因放弃英语考试，如何实现？

============================================

# Series索引
显示 [indexname] .loc[indexname] [[indexname1,indexname2]] .loc[[indexname1,indexname2]]
隐式 .iloc[locindex] .iloc[[locindex1,locindex2]]
# Series切片
显示 [index1:index2]  .loc[index1:index2]
隐士 .iloc[locindex1:locindex2]

# DataFrame索引
显示 
行索引：df.loc[indexname]
列索引：df[columnname]  df.columnname
元素索引: df.loc[indexname,columnname]

隐式
行索引：df.iloc[locindex]
列索引：df.iloc[:,loccolumn]
元素索引：df.iloc[locindex,loccoloumn]

# 多级索引的DataFrame\Series
化繁为简
隐式索引的访问方式可以忽略多级索引问题

## 4. 索引的堆（stack）

- ``stack()``
- ``unstack()``

stack:把列索引转换成行索引
unstack：把行索引变成列索引
level：控制要转换的索引（索引最外层记为0，往里一次递增1）


```python
score
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
      <th></th>
      <th>张三</th>
      <th>李四</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th rowspan="3" valign="top">期中</th>
      <th>python</th>
      <td>139</td>
      <td>72</td>
    </tr>
    <tr>
      <th>c</th>
      <td>61</td>
      <td>106</td>
    </tr>
    <tr>
      <th>java</th>
      <td>73</td>
      <td>9</td>
    </tr>
    <tr>
      <th rowspan="3" valign="top">期末</th>
      <th>python</th>
      <td>50</td>
      <td>6</td>
    </tr>
    <tr>
      <th>c</th>
      <td>83</td>
      <td>147</td>
    </tr>
    <tr>
      <th>java</th>
      <td>9</td>
      <td>63</td>
    </tr>
  </tbody>
</table>
</div>




```python
score.unstack(level=0).stack(level=0).unstack(level=0)
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead tr th {
        text-align: left;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr>
      <th></th>
      <th colspan="3" halign="left">期中</th>
      <th colspan="3" halign="left">期末</th>
    </tr>
    <tr>
      <th></th>
      <th>c</th>
      <th>java</th>
      <th>python</th>
      <th>c</th>
      <th>java</th>
      <th>python</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>张三</th>
      <td>61</td>
      <td>73</td>
      <td>139</td>
      <td>83</td>
      <td>9</td>
      <td>50</td>
    </tr>
    <tr>
      <th>李四</th>
      <td>106</td>
      <td>9</td>
      <td>72</td>
      <td>147</td>
      <td>63</td>
      <td>6</td>
    </tr>
  </tbody>
</table>
</div>




```python
score.unstack(level=0).loc['python']
```




    张三  期中    139
        期末     50
    李四  期中     72
        期末      6
    Name: python, dtype: int32



小技巧】使用stack()的时候，level等于哪一个，哪一个就消失，出现在行里。

【小技巧】使用unstack()的时候，level等于哪一个，哪一个就消失，出现在列里。

============================================

练习10：

1. 使用unstack()将ddd变为两行，分别为期中期末

2. 使用unstack()将ddd变为四行，分别为四个科目

============================================


```python
ddd
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead tr th {
        text-align: left;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr>
      <th></th>
      <th colspan="2" halign="left">语文</th>
      <th colspan="2" halign="left">数学</th>
      <th colspan="2" halign="left">英语</th>
      <th colspan="2" halign="left">理综</th>
    </tr>
    <tr>
      <th></th>
      <th>期中</th>
      <th>期末</th>
      <th>期中</th>
      <th>期末</th>
      <th>期中</th>
      <th>期末</th>
      <th>期中</th>
      <th>期末</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>张三</th>
      <td>17</td>
      <td>147</td>
      <td>58</td>
      <td>56</td>
      <td>41</td>
      <td>23</td>
      <td>36</td>
      <td>88</td>
    </tr>
    <tr>
      <th>李四</th>
      <td>45</td>
      <td>39</td>
      <td>71</td>
      <td>7</td>
      <td>45</td>
      <td>137</td>
      <td>93</td>
      <td>43</td>
    </tr>
  </tbody>
</table>
</div>




```python
ddd.stack(level=1).unstack(level=0)
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead tr th {
        text-align: left;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr>
      <th></th>
      <th colspan="2" halign="left">数学</th>
      <th colspan="2" halign="left">理综</th>
      <th colspan="2" halign="left">英语</th>
      <th colspan="2" halign="left">语文</th>
    </tr>
    <tr>
      <th></th>
      <th>张三</th>
      <th>李四</th>
      <th>张三</th>
      <th>李四</th>
      <th>张三</th>
      <th>李四</th>
      <th>张三</th>
      <th>李四</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>期中</th>
      <td>58</td>
      <td>71</td>
      <td>36</td>
      <td>93</td>
      <td>41</td>
      <td>45</td>
      <td>17</td>
      <td>45</td>
    </tr>
    <tr>
      <th>期末</th>
      <td>56</td>
      <td>7</td>
      <td>88</td>
      <td>43</td>
      <td>23</td>
      <td>137</td>
      <td>147</td>
      <td>39</td>
    </tr>
  </tbody>
</table>
</div>




```python
ddd.stack(level=0).unstack(level=0)
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead tr th {
        text-align: left;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr>
      <th></th>
      <th colspan="2" halign="left">期中</th>
      <th colspan="2" halign="left">期末</th>
    </tr>
    <tr>
      <th></th>
      <th>张三</th>
      <th>李四</th>
      <th>张三</th>
      <th>李四</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>数学</th>
      <td>58</td>
      <td>71</td>
      <td>56</td>
      <td>7</td>
    </tr>
    <tr>
      <th>理综</th>
      <td>36</td>
      <td>93</td>
      <td>88</td>
      <td>43</td>
    </tr>
    <tr>
      <th>英语</th>
      <td>41</td>
      <td>45</td>
      <td>23</td>
      <td>137</td>
    </tr>
    <tr>
      <th>语文</th>
      <td>17</td>
      <td>45</td>
      <td>147</td>
      <td>39</td>
    </tr>
  </tbody>
</table>
</div>




```python
columns = pd.MultiIndex.from_product([['期中','期末'],['量子力学','达尔文进化论','相对论','虫洞深入探讨']])
index = ['大黄','小玲','小天才']
data = np.random.randint(0,150,size=(3,8))
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

    .dataframe thead tr th {
        text-align: left;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr>
      <th></th>
      <th colspan="4" halign="left">期中</th>
      <th colspan="4" halign="left">期末</th>
    </tr>
    <tr>
      <th></th>
      <th>量子力学</th>
      <th>达尔文进化论</th>
      <th>相对论</th>
      <th>虫洞深入探讨</th>
      <th>量子力学</th>
      <th>达尔文进化论</th>
      <th>相对论</th>
      <th>虫洞深入探讨</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>大黄</th>
      <td>59</td>
      <td>141</td>
      <td>24</td>
      <td>1</td>
      <td>29</td>
      <td>121</td>
      <td>82</td>
      <td>15</td>
    </tr>
    <tr>
      <th>小玲</th>
      <td>90</td>
      <td>140</td>
      <td>41</td>
      <td>149</td>
      <td>8</td>
      <td>74</td>
      <td>142</td>
      <td>66</td>
    </tr>
    <tr>
      <th>小天才</th>
      <td>41</td>
      <td>136</td>
      <td>71</td>
      <td>68</td>
      <td>74</td>
      <td>29</td>
      <td>126</td>
      <td>56</td>
    </tr>
  </tbody>
</table>
</div>




```python
df1 = df.stack(level=0).unstack(level=0)
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

    .dataframe thead tr th {
        text-align: left;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr>
      <th></th>
      <th colspan="3" halign="left">相对论</th>
      <th colspan="3" halign="left">虫洞深入探讨</th>
      <th colspan="3" halign="left">达尔文进化论</th>
      <th colspan="3" halign="left">量子力学</th>
    </tr>
    <tr>
      <th></th>
      <th>大黄</th>
      <th>小玲</th>
      <th>小天才</th>
      <th>大黄</th>
      <th>小玲</th>
      <th>小天才</th>
      <th>大黄</th>
      <th>小玲</th>
      <th>小天才</th>
      <th>大黄</th>
      <th>小玲</th>
      <th>小天才</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>期中</th>
      <td>24</td>
      <td>41</td>
      <td>71</td>
      <td>1</td>
      <td>149</td>
      <td>68</td>
      <td>141</td>
      <td>140</td>
      <td>136</td>
      <td>59</td>
      <td>90</td>
      <td>41</td>
    </tr>
    <tr>
      <th>期末</th>
      <td>82</td>
      <td>142</td>
      <td>126</td>
      <td>15</td>
      <td>66</td>
      <td>56</td>
      <td>121</td>
      <td>74</td>
      <td>29</td>
      <td>29</td>
      <td>8</td>
      <td>74</td>
    </tr>
  </tbody>
</table>
</div>




```python
df.stack(level=1).unstack(level=0)
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead tr th {
        text-align: left;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr>
      <th></th>
      <th colspan="3" halign="left">期中</th>
      <th colspan="3" halign="left">期末</th>
    </tr>
    <tr>
      <th></th>
      <th>大黄</th>
      <th>小玲</th>
      <th>小天才</th>
      <th>大黄</th>
      <th>小玲</th>
      <th>小天才</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>相对论</th>
      <td>24</td>
      <td>41</td>
      <td>71</td>
      <td>82</td>
      <td>142</td>
      <td>126</td>
    </tr>
    <tr>
      <th>虫洞深入探讨</th>
      <td>1</td>
      <td>149</td>
      <td>68</td>
      <td>15</td>
      <td>66</td>
      <td>56</td>
    </tr>
    <tr>
      <th>达尔文进化论</th>
      <td>141</td>
      <td>140</td>
      <td>136</td>
      <td>121</td>
      <td>74</td>
      <td>29</td>
    </tr>
    <tr>
      <th>量子力学</th>
      <td>59</td>
      <td>90</td>
      <td>41</td>
      <td>29</td>
      <td>8</td>
      <td>74</td>
    </tr>
  </tbody>
</table>
</div>



## 5. 聚合操作

【注意】

- 需要指定axis

- 【小技巧】和unstack()相反，聚合的时候，axis等于哪一个，哪一个就保留。


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

    .dataframe thead tr th {
        text-align: left;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr>
      <th></th>
      <th colspan="4" halign="left">期中</th>
      <th colspan="4" halign="left">期末</th>
    </tr>
    <tr>
      <th></th>
      <th>量子力学</th>
      <th>达尔文进化论</th>
      <th>相对论</th>
      <th>虫洞深入探讨</th>
      <th>量子力学</th>
      <th>达尔文进化论</th>
      <th>相对论</th>
      <th>虫洞深入探讨</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>大黄</th>
      <td>59</td>
      <td>141</td>
      <td>24</td>
      <td>1</td>
      <td>29</td>
      <td>121</td>
      <td>82</td>
      <td>15</td>
    </tr>
    <tr>
      <th>小玲</th>
      <td>90</td>
      <td>140</td>
      <td>41</td>
      <td>149</td>
      <td>8</td>
      <td>74</td>
      <td>142</td>
      <td>66</td>
    </tr>
    <tr>
      <th>小天才</th>
      <td>41</td>
      <td>136</td>
      <td>71</td>
      <td>68</td>
      <td>74</td>
      <td>29</td>
      <td>126</td>
      <td>56</td>
    </tr>
  </tbody>
</table>
</div>




```python
df.mean(axis=1)
```




    大黄     59.000
    小玲     88.750
    小天才    75.125
    dtype: float64




```python
df.sum(axis=1)
```




    大黄     472
    小玲     710
    小天才    601
    dtype: int64




```python
df.max(axis=1)
```




    大黄     141
    小玲     149
    小天才    136
    dtype: int32




```python
df.stack(level=0).unstack(level=0).stack(level=1).mean(axis=1)
```




    期中  大黄      56.25
        小玲     105.00
        小天才     79.00
    期末  大黄      61.75
        小玲      72.50
        小天才     71.25
    dtype: float64




```python
df.stack(level=0).unstack(level=0).mean(axis=1)
```




    期中    80.083333
    期末    68.500000
    dtype: float64




```python
df.mean(axis=0)
```




    期中  量子力学       63.333333
        达尔文进化论    139.000000
        相对论        45.333333
        虫洞深入探讨     72.666667
    期末  量子力学       37.000000
        达尔文进化论     74.666667
        相对论       116.666667
        虫洞深入探讨     45.666667
    dtype: float64



所谓的聚合操作：平均数，方差，最大值，最小值……

============================================

练习11：

1. 计算各个科目期中期末平均成绩

2. 计算各科目张三李四的最高分

============================================


```python

```
