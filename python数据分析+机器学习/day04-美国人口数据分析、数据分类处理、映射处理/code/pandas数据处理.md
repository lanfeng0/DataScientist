
# pandas数据处理

## 1.删除重复元素


```python
import numpy as np
import pandas as pd
from pandas import Series,DataFrame
```


```python

df = DataFrame({'color':['white','white','red','red','white'],
               'value':[2,1,3,3,2]})
display(df,df.duplicated(),df.drop_duplicates())
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
      <th>color</th>
      <th>value</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>white</td>
      <td>2</td>
    </tr>
    <tr>
      <th>1</th>
      <td>white</td>
      <td>1</td>
    </tr>
    <tr>
      <th>2</th>
      <td>red</td>
      <td>3</td>
    </tr>
    <tr>
      <th>3</th>
      <td>red</td>
      <td>3</td>
    </tr>
    <tr>
      <th>4</th>
      <td>white</td>
      <td>2</td>
    </tr>
  </tbody>
</table>
</div>



    0    False
    1    False
    2    False
    3     True
    4     True
    dtype: bool



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
      <th>color</th>
      <th>value</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>white</td>
      <td>2</td>
    </tr>
    <tr>
      <th>1</th>
      <td>white</td>
      <td>1</td>
    </tr>
    <tr>
      <th>2</th>
      <td>red</td>
      <td>3</td>
    </tr>
  </tbody>
</table>
</div>



```python
df.duplicated?
```


    [1;31mSignature:[0m [0mdf[0m[1;33m.[0m[0mduplicated[0m[1;33m([0m[0msubset[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [0mkeep[0m[1;33m=[0m[1;34m'first'[0m[1;33m)[0m[1;33m[0m[0m
    [1;31mDocstring:[0m
    Return boolean Series denoting duplicate rows, optionally only
    considering certain columns
    
    Parameters
    ----------
    subset : column label or sequence of labels, optional
        Only consider certain columns for identifying duplicates, by
        default use all of the columns
    keep : {'first', 'last', False}, default 'first'
        - ``first`` : Mark duplicates as ``True`` except for the
          first occurrence.
        - ``last`` : Mark duplicates as ``True`` except for the
          last occurrence.
        - False : Mark all duplicates as ``True``.
    
    Returns
    -------
    duplicated : Series
    [1;31mFile:[0m      d:\software\anaconda3\lib\site-packages\pandas\core\frame.py
    [1;31mType:[0m      method
    



```python
df = pd.DataFrame({'col1': ['one', 'one', 'two', 'two', 'two', 'three', 'four'], 'col2': [1, 2, 1, 2, 1, 1, 1],
                   'col3':['AA','BB','CC','DD','EE','FF','GG']},index=['a', 'a', 'b', 'c', 'b', 'a','c'])
display(df)
#duplicated(self, subset=None, keep='first')
#根据列名标记
#keep='first'
df.duplicated()#默认所有列，无重复记录
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
      <th>col1</th>
      <th>col2</th>
      <th>col3</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>a</th>
      <td>one</td>
      <td>1</td>
      <td>AA</td>
    </tr>
    <tr>
      <th>a</th>
      <td>one</td>
      <td>2</td>
      <td>BB</td>
    </tr>
    <tr>
      <th>b</th>
      <td>two</td>
      <td>1</td>
      <td>CC</td>
    </tr>
    <tr>
      <th>c</th>
      <td>two</td>
      <td>2</td>
      <td>DD</td>
    </tr>
    <tr>
      <th>b</th>
      <td>two</td>
      <td>1</td>
      <td>EE</td>
    </tr>
    <tr>
      <th>a</th>
      <td>three</td>
      <td>1</td>
      <td>FF</td>
    </tr>
    <tr>
      <th>c</th>
      <td>four</td>
      <td>1</td>
      <td>GG</td>
    </tr>
  </tbody>
</table>
</div>





    a    False
    a    False
    b    False
    c    False
    b    False
    a    False
    c    False
    dtype: bool



## 2. 映射


```python
# replace()函数：替换元素
```


```python
df = DataFrame({'item':['ball','mug','pen'],
               'color':['white','rosso','verde'],
               'price':[5.56,4.20,1.30]})
newcolors = {'rosso':'red','verde':'green'}
display(df,df.replace(newcolors))

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
      <th>item</th>
      <th>color</th>
      <th>price</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>ball</td>
      <td>white</td>
      <td>5.56</td>
    </tr>
    <tr>
      <th>1</th>
      <td>mug</td>
      <td>rosso</td>
      <td>4.20</td>
    </tr>
    <tr>
      <th>2</th>
      <td>pen</td>
      <td>verde</td>
      <td>1.30</td>
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
      <th>item</th>
      <th>color</th>
      <th>price</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>ball</td>
      <td>white</td>
      <td>5.56</td>
    </tr>
    <tr>
      <th>1</th>
      <td>mug</td>
      <td>red</td>
      <td>4.20</td>
    </tr>
    <tr>
      <th>2</th>
      <td>pen</td>
      <td>green</td>
      <td>1.30</td>
    </tr>
  </tbody>
</table>
</div>



```python
df2 = DataFrame({'math':[100,139,np.nan],'English':[146,None,119]},index = ['张三','李四','Tom'])
newvalues = {np.nan:100}
display(df2,df2.replace(newvalues))

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
      <th>math</th>
      <th>English</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>张三</th>
      <td>100.0</td>
      <td>146.0</td>
    </tr>
    <tr>
      <th>李四</th>
      <td>139.0</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>Tom</th>
      <td>NaN</td>
      <td>119.0</td>
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
      <th>math</th>
      <th>English</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>张三</th>
      <td>100.0</td>
      <td>146.0</td>
    </tr>
    <tr>
      <th>李四</th>
      <td>139.0</td>
      <td>100.0</td>
    </tr>
    <tr>
      <th>Tom</th>
      <td>100.0</td>
      <td>119.0</td>
    </tr>
  </tbody>
</table>
</div>



```python
#  map()函数：新建一列
# map中返回的数据是一个具体值，不能迭代
```


```python
df3 = DataFrame({'color':['red','green','blue'],'project':['math','english','chemistry']})
print(df3)
price = {'red':5.56,'green':3.14,'chemistry':2.79}
print(price)
df3['price'] = df3['color'].map(price)
display(df3)
```

       color    project
    0    red       math
    1  green    english
    2   blue  chemistry
    {'red': 5.56, 'green': 3.14, 'chemistry': 2.79}
    


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
      <th>color</th>
      <th>project</th>
      <th>price</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>red</td>
      <td>math</td>
      <td>5.56</td>
    </tr>
    <tr>
      <th>1</th>
      <td>green</td>
      <td>english</td>
      <td>3.14</td>
    </tr>
    <tr>
      <th>2</th>
      <td>blue</td>
      <td>chemistry</td>
      <td>NaN</td>
    </tr>
  </tbody>
</table>
</div>



```python
df3['color'].map
```




    <bound method Series.map of 0      red
    1    green
    2     blue
    Name: color, dtype: object>




```python
df3 = DataFrame({'zs':[129,130,34],
                'ls':[136,98,8]},index = ['张三','李四','倩倩'])
print(df3)
display(df3['zs'].map({129:'你好',130:'非常好',34:'不错'}))
display(df3['zs'].map({129:120}))
def mapscore(score):
    if score<90:
        return 'failed'
    elif score>120:
        return 'excellent'
    else:
        return 'pass'

df3['status'] = df3['zs'].map(mapscore)
df3
```

         zs   ls
    张三  129  136
    李四  130   98
    倩倩   34    8
    


    张三     你好
    李四    非常好
    倩倩     不错
    Name: zs, dtype: object



    张三    120.0
    李四      NaN
    倩倩      NaN
    Name: zs, dtype: float64





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
      <th>zs</th>
      <th>ls</th>
      <th>status</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>张三</th>
      <td>129</td>
      <td>136</td>
      <td>excellent</td>
    </tr>
    <tr>
      <th>李四</th>
      <td>130</td>
      <td>98</td>
      <td>excellent</td>
    </tr>
    <tr>
      <th>倩倩</th>
      <td>34</td>
      <td>8</td>
      <td>failed</td>
    </tr>
  </tbody>
</table>
</div>



rename()函数：替换索引


```python
import numpy as np
import pandas as pd
from pandas import Series,DataFrame
df4 = DataFrame({'color':['white','gray','purple','blue','green'],'value':np.random.randint(10,size = 5)})
new_index = {0:'first',1:'two',2:'three',3:'four',4:'five'}
display(df4,df4.rename(new_index))

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
      <th>color</th>
      <th>value</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>white</td>
      <td>2</td>
    </tr>
    <tr>
      <th>1</th>
      <td>gray</td>
      <td>8</td>
    </tr>
    <tr>
      <th>2</th>
      <td>purple</td>
      <td>4</td>
    </tr>
    <tr>
      <th>3</th>
      <td>blue</td>
      <td>7</td>
    </tr>
    <tr>
      <th>4</th>
      <td>green</td>
      <td>2</td>
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
      <th>color</th>
      <th>value</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>first</th>
      <td>white</td>
      <td>2</td>
    </tr>
    <tr>
      <th>two</th>
      <td>gray</td>
      <td>8</td>
    </tr>
    <tr>
      <th>three</th>
      <td>purple</td>
      <td>4</td>
    </tr>
    <tr>
      <th>four</th>
      <td>blue</td>
      <td>7</td>
    </tr>
    <tr>
      <th>five</th>
      <td>green</td>
      <td>2</td>
    </tr>
  </tbody>
</table>
</div>


## 3. 异常值检测和过滤

### 3.1:使用describe()函数查看每一列的描述性统计量


```python
import numpy as np
import pandas as pd
from pandas import Series,DataFrame
# np.random.seed(0)是NumPy中用于设置随机数生成器的种子的方法。种子是一个整数值，用于初始化随机数生成器的起始状态。通过设置种子，
# 可以使随机数生成过程具有可重复性，即每次运行程序时生成的随机数序列都是相同的。
# 在调用np.random.seed(0)之后，使用NumPy的随机数生成函数（如np.random.randn()或np.random.randint()）将生成同样的随机数序列，因为种子值是固定的。
np.random.seed(0)
df = DataFrame(np.random.randint(10,size = 10))
display(df.head(10),df.describe())
# 25% 分位数、中位数、75% 分位数
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
      <th>0</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>5</td>
    </tr>
    <tr>
      <th>1</th>
      <td>0</td>
    </tr>
    <tr>
      <th>2</th>
      <td>3</td>
    </tr>
    <tr>
      <th>3</th>
      <td>3</td>
    </tr>
    <tr>
      <th>4</th>
      <td>7</td>
    </tr>
    <tr>
      <th>5</th>
      <td>9</td>
    </tr>
    <tr>
      <th>6</th>
      <td>3</td>
    </tr>
    <tr>
      <th>7</th>
      <td>5</td>
    </tr>
    <tr>
      <th>8</th>
      <td>2</td>
    </tr>
    <tr>
      <th>9</th>
      <td>4</td>
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
      <th>0</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>count</th>
      <td>10.000000</td>
    </tr>
    <tr>
      <th>mean</th>
      <td>4.100000</td>
    </tr>
    <tr>
      <th>std</th>
      <td>2.558211</td>
    </tr>
    <tr>
      <th>min</th>
      <td>0.000000</td>
    </tr>
    <tr>
      <th>25%</th>
      <td>3.000000</td>
    </tr>
    <tr>
      <th>50%</th>
      <td>3.500000</td>
    </tr>
    <tr>
      <th>75%</th>
      <td>5.000000</td>
    </tr>
    <tr>
      <th>max</th>
      <td>9.000000</td>
    </tr>
  </tbody>
</table>
</div>


### 使用std()函数可以求得DataFrame对象每一列的标准差


```python
df.std()
# 标准差
```




    0    2.558211
    dtype: float64




```python
np.abs(df)
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
      <th>0</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>5</td>
    </tr>
    <tr>
      <th>1</th>
      <td>0</td>
    </tr>
    <tr>
      <th>2</th>
      <td>3</td>
    </tr>
    <tr>
      <th>3</th>
      <td>3</td>
    </tr>
    <tr>
      <th>4</th>
      <td>7</td>
    </tr>
    <tr>
      <th>5</th>
      <td>9</td>
    </tr>
    <tr>
      <th>6</th>
      <td>3</td>
    </tr>
    <tr>
      <th>7</th>
      <td>5</td>
    </tr>
    <tr>
      <th>8</th>
      <td>2</td>
    </tr>
    <tr>
      <th>9</th>
      <td>4</td>
    </tr>
  </tbody>
</table>
</div>



### 根据每一列的标准差，对DataFrame元素进行过滤。借助any()函数，对每一列应用筛选条件


```python
display(df.std(),np.abs(df)>(3*df.std()),df[(np.abs(df)>df.std()*3).any(axis = 1)])
DataFrame.any?

```


    0    2.558211
    dtype: float64



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
      <th>0</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>False</td>
    </tr>
    <tr>
      <th>1</th>
      <td>False</td>
    </tr>
    <tr>
      <th>2</th>
      <td>False</td>
    </tr>
    <tr>
      <th>3</th>
      <td>False</td>
    </tr>
    <tr>
      <th>4</th>
      <td>False</td>
    </tr>
    <tr>
      <th>5</th>
      <td>True</td>
    </tr>
    <tr>
      <th>6</th>
      <td>False</td>
    </tr>
    <tr>
      <th>7</th>
      <td>False</td>
    </tr>
    <tr>
      <th>8</th>
      <td>False</td>
    </tr>
    <tr>
      <th>9</th>
      <td>False</td>
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
      <th>0</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>5</th>
      <td>9</td>
    </tr>
  </tbody>
</table>
</div>



    [1;31mSignature:[0m [0mDataFrame[0m[1;33m.[0m[0many[0m[1;33m([0m[0mself[0m[1;33m,[0m [0maxis[0m[1;33m=[0m[1;36m0[0m[1;33m,[0m [0mbool_only[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [0mskipna[0m[1;33m=[0m[1;32mTrue[0m[1;33m,[0m [0mlevel[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [1;33m**[0m[0mkwargs[0m[1;33m)[0m[1;33m[0m[0m
    [1;31mDocstring:[0m
    Return whether any element is True over requested axis.
    
    Unlike :meth:`DataFrame.all`, this performs an *or* operation. If any of the
    values along the specified axis is True, this will return True.
    
    Parameters
    ----------
    axis : {0 or 'index', 1 or 'columns', None}, default 0
        Indicate which axis or axes should be reduced.
    
        * 0 / 'index' : reduce the index, return a Series whose index is the
          original column labels.
        * 1 / 'columns' : reduce the columns, return a Series whose index is the
          original index.
        * None : reduce all axes, return a scalar.
    
    skipna : boolean, default True
        Exclude NA/null values. If an entire row/column is NA, the result
        will be NA.
    level : int or level name, default None
        If the axis is a MultiIndex (hierarchical), count along a
        particular level, collapsing into a Series.
    bool_only : boolean, default None
        Include only boolean columns. If None, will attempt to use everything,
        then use only boolean data. Not implemented for Series.
    **kwargs : any, default None
        Additional keywords have no effect but might be accepted for
        compatibility with NumPy.
    
    Returns
    -------
    any : Series or DataFrame (if level specified)
    
    See Also
    --------
    pandas.DataFrame.all : Return whether all elements are True.
    
    Examples
    --------
    **Series**
    
    For Series input, the output is a scalar indicating whether any element
    is True.
    
    >>> pd.Series([True, False]).any()
    True
    
    **DataFrame**
    
    Whether each column contains at least one True element (the default).
    
    >>> df = pd.DataFrame({"A": [1, 2], "B": [0, 2], "C": [0, 0]})
    >>> df
       A  B  C
    0  1  0  0
    1  2  2  0
    
    >>> df.any()
    A     True
    B     True
    C    False
    dtype: bool
    
    Aggregating over the columns.
    
    >>> df = pd.DataFrame({"A": [True, False], "B": [1, 2]})
    >>> df
           A  B
    0   True  1
    1  False  2
    
    >>> df.any(axis='columns')
    0    True
    1    True
    dtype: bool
    
    >>> df = pd.DataFrame({"A": [True, False], "B": [1, 0]})
    >>> df
           A  B
    0   True  1
    1  False  0
    
    >>> df.any(axis='columns')
    0    True
    1    False
    dtype: bool
    
    Aggregating over the entire DataFrame with ``axis=None``.
    
    >>> df.any(axis=None)
    True
    
    `any` for an empty DataFrame is an empty Series.
    
    >>> pd.DataFrame([]).any()
    Series([], dtype: bool)
    [1;31mFile:[0m      d:\software\anaconda3\lib\site-packages\pandas\core\generic.py
    [1;31mType:[0m      function
    



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
      <th>0</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>5</td>
    </tr>
    <tr>
      <th>1</th>
      <td>0</td>
    </tr>
    <tr>
      <th>2</th>
      <td>3</td>
    </tr>
    <tr>
      <th>3</th>
      <td>3</td>
    </tr>
    <tr>
      <th>4</th>
      <td>7</td>
    </tr>
    <tr>
      <th>5</th>
      <td>9</td>
    </tr>
    <tr>
      <th>6</th>
      <td>3</td>
    </tr>
    <tr>
      <th>7</th>
      <td>5</td>
    </tr>
    <tr>
      <th>8</th>
      <td>2</td>
    </tr>
    <tr>
      <th>9</th>
      <td>4</td>
    </tr>
  </tbody>
</table>
</div>




```python
display(df[(df>df.std()*3).any(axis = 1)])
df.drop(df[(np.abs(df) > (3*df.std())).any(axis=1)].index,inplace=True)
display(df,df.shape)
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
      <th>0</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>5</th>
      <td>9</td>
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
      <th>0</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>5</td>
    </tr>
    <tr>
      <th>1</th>
      <td>0</td>
    </tr>
    <tr>
      <th>2</th>
      <td>3</td>
    </tr>
    <tr>
      <th>3</th>
      <td>3</td>
    </tr>
    <tr>
      <th>4</th>
      <td>7</td>
    </tr>
    <tr>
      <th>6</th>
      <td>3</td>
    </tr>
    <tr>
      <th>7</th>
      <td>5</td>
    </tr>
    <tr>
      <th>8</th>
      <td>2</td>
    </tr>
    <tr>
      <th>9</th>
      <td>4</td>
    </tr>
  </tbody>
</table>
</div>



    (9, 1)



```python
df.drop?
```


    [1;31mSignature:[0m [0mdf[0m[1;33m.[0m[0mdrop[0m[1;33m([0m[0mlabels[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [0maxis[0m[1;33m=[0m[1;36m0[0m[1;33m,[0m [0mindex[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [0mcolumns[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [0mlevel[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [0minplace[0m[1;33m=[0m[1;32mFalse[0m[1;33m,[0m [0merrors[0m[1;33m=[0m[1;34m'raise'[0m[1;33m)[0m[1;33m[0m[0m
    [1;31mDocstring:[0m
    Drop specified labels from rows or columns.
    
    Remove rows or columns by specifying label names and corresponding
    axis, or by specifying directly index or column names. When using a
    multi-index, labels on different levels can be removed by specifying
    the level.
    
    Parameters
    ----------
    labels : single label or list-like
        Index or column labels to drop.
    axis : {0 or 'index', 1 or 'columns'}, default 0
        Whether to drop labels from the index (0 or 'index') or
        columns (1 or 'columns').
    index, columns : single label or list-like
        Alternative to specifying axis (``labels, axis=1``
        is equivalent to ``columns=labels``).
    
        .. versionadded:: 0.21.0
    level : int or level name, optional
        For MultiIndex, level from which the labels will be removed.
    inplace : bool, default False
        If True, do operation inplace and return None.
    errors : {'ignore', 'raise'}, default 'raise'
        If 'ignore', suppress error and only existing labels are
        dropped.
    
    Returns
    -------
    dropped : pandas.DataFrame
    
    See Also
    --------
    DataFrame.loc : Label-location based indexer for selection by label.
    DataFrame.dropna : Return DataFrame with labels on given axis omitted
        where (all or any) data are missing
    DataFrame.drop_duplicates : Return DataFrame with duplicate rows
        removed, optionally only considering certain columns
    Series.drop : Return Series with specified index labels removed.
    
    Raises
    ------
    KeyError
        If none of the labels are found in the selected axis
    
    Examples
    --------
    >>> df = pd.DataFrame(np.arange(12).reshape(3,4),
    ...                   columns=['A', 'B', 'C', 'D'])
    >>> df
       A  B   C   D
    0  0  1   2   3
    1  4  5   6   7
    2  8  9  10  11
    
    Drop columns
    
    >>> df.drop(['B', 'C'], axis=1)
       A   D
    0  0   3
    1  4   7
    2  8  11
    
    >>> df.drop(columns=['B', 'C'])
       A   D
    0  0   3
    1  4   7
    2  8  11
    
    Drop a row by index
    
    >>> df.drop([0, 1])
       A  B   C   D
    2  8  9  10  11
    
    Drop columns and/or rows of MultiIndex DataFrame
    
    >>> midx = pd.MultiIndex(levels=[['lama', 'cow', 'falcon'],
    ...                              ['speed', 'weight', 'length']],
    ...                      labels=[[0, 0, 0, 1, 1, 1, 2, 2, 2],
    ...                              [0, 1, 2, 0, 1, 2, 0, 1, 2]])
    >>> df = pd.DataFrame(index=midx, columns=['big', 'small'],
    ...                   data=[[45, 30], [200, 100], [1.5, 1], [30, 20],
    ...                         [250, 150], [1.5, 0.8], [320, 250],
    ...                         [1, 0.8], [0.3,0.2]])
    >>> df
                    big     small
    lama    speed   45.0    30.0
            weight  200.0   100.0
            length  1.5     1.0
    cow     speed   30.0    20.0
            weight  250.0   150.0
            length  1.5     0.8
    falcon  speed   320.0   250.0
            weight  1.0     0.8
            length  0.3     0.2
    
    >>> df.drop(index='cow', columns='small')
                    big
    lama    speed   45.0
            weight  200.0
            length  1.5
    falcon  speed   320.0
            weight  1.0
            length  0.3
    
    >>> df.drop(index='length', level=1)
                    big     small
    lama    speed   45.0    30.0
            weight  200.0   100.0
    cow     speed   30.0    20.0
            weight  250.0   150.0
    falcon  speed   320.0   250.0
            weight  1.0     0.8
    [1;31mFile:[0m      d:\software\anaconda3\lib\site-packages\pandas\core\frame.py
    [1;31mType:[0m      method
    


## 4. 排序


```python
# 使用.take()函数排序
# 可以借助np.random.permutation()函数随机排序
```


```python
df5 = DataFrame(np.arange(25).reshape(5,5))
new_order = np.random.permutation(5)
display(df5,new_order,df5.take(new_order))
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
      <th>0</th>
      <th>1</th>
      <th>2</th>
      <th>3</th>
      <th>4</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>0</td>
      <td>1</td>
      <td>2</td>
      <td>3</td>
      <td>4</td>
    </tr>
    <tr>
      <th>1</th>
      <td>5</td>
      <td>6</td>
      <td>7</td>
      <td>8</td>
      <td>9</td>
    </tr>
    <tr>
      <th>2</th>
      <td>10</td>
      <td>11</td>
      <td>12</td>
      <td>13</td>
      <td>14</td>
    </tr>
    <tr>
      <th>3</th>
      <td>15</td>
      <td>16</td>
      <td>17</td>
      <td>18</td>
      <td>19</td>
    </tr>
    <tr>
      <th>4</th>
      <td>20</td>
      <td>21</td>
      <td>22</td>
      <td>23</td>
      <td>24</td>
    </tr>
  </tbody>
</table>
</div>



    array([2, 3, 4, 1, 0])



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
      <th>0</th>
      <th>1</th>
      <th>2</th>
      <th>3</th>
      <th>4</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>2</th>
      <td>10</td>
      <td>11</td>
      <td>12</td>
      <td>13</td>
      <td>14</td>
    </tr>
    <tr>
      <th>3</th>
      <td>15</td>
      <td>16</td>
      <td>17</td>
      <td>18</td>
      <td>19</td>
    </tr>
    <tr>
      <th>4</th>
      <td>20</td>
      <td>21</td>
      <td>22</td>
      <td>23</td>
      <td>24</td>
    </tr>
    <tr>
      <th>1</th>
      <td>5</td>
      <td>6</td>
      <td>7</td>
      <td>8</td>
      <td>9</td>
    </tr>
    <tr>
      <th>0</th>
      <td>0</td>
      <td>1</td>
      <td>2</td>
      <td>3</td>
      <td>4</td>
    </tr>
  </tbody>
</table>
</div>



```python
# 随机抽样
# 当DataFrame规模足够大时，直接使用np.random.randint()函数，就配合take()函数实现随机抽样
```


```python
sample = np.random.randint(0,len(df5),size = 3)
print(sample)
print(df)
df.take(sample)

```

    [2 3 0]
       0
    0  5
    1  0
    2  3
    3  3
    4  7
    6  3
    7  5
    8  2
    9  4
    




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
      <th>0</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>2</th>
      <td>3</td>
    </tr>
    <tr>
      <th>3</th>
      <td>3</td>
    </tr>
    <tr>
      <th>0</th>
      <td>5</td>
    </tr>
  </tbody>
</table>
</div>



## 5. 数据分类处理【重点】


```python
# 数据聚合是数据处理的最后一步，通常是要使每一个数组生成一个单一的数值。
# 数据分类处理：
# 分组：先把数据分为几组
# 用函数处理：为不同组的数据应用不同的函数以转换数据
# 合并：把不同组得到的结果合并起来
# 数据分类处理的核心： groupby()函数
```


```python
# 数据分类处理的核心： groupby()函数
df = DataFrame({'color':['white','red','green','red'],
               'item':['ball','mug','pen','pencil'],
               'price1':np.random.rand(4),
               'price2':np.random.rand(4)})
g = df.groupby('color')['price1']
display(df,g,g.groups,type(g))

display(g.sum(),g.mean(),g.max())

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
      <th>color</th>
      <th>item</th>
      <th>price1</th>
      <th>price2</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>white</td>
      <td>ball</td>
      <td>0.170910</td>
      <td>0.325047</td>
    </tr>
    <tr>
      <th>1</th>
      <td>red</td>
      <td>mug</td>
      <td>0.358152</td>
      <td>0.038425</td>
    </tr>
    <tr>
      <th>2</th>
      <td>green</td>
      <td>pen</td>
      <td>0.750686</td>
      <td>0.634274</td>
    </tr>
    <tr>
      <th>3</th>
      <td>red</td>
      <td>pencil</td>
      <td>0.607831</td>
      <td>0.958949</td>
    </tr>
  </tbody>
</table>
</div>



    <pandas.core.groupby.groupby.SeriesGroupBy object at 0x000001CFB0763048>



    {'green': Int64Index([2], dtype='int64'),
     'red': Int64Index([1, 3], dtype='int64'),
     'white': Int64Index([0], dtype='int64')}



    pandas.core.groupby.groupby.SeriesGroupBy



    color
    green    0.750686
    red      0.965983
    white    0.170910
    Name: price1, dtype: float64



    color
    green    0.750686
    red      0.482991
    white    0.170910
    Name: price1, dtype: float64



    color
    green    0.750686
    red      0.607831
    white    0.170910
    Name: price1, dtype: float64


## 6. 高级数据聚合


```python
# 可以使用pd.merge()函数包聚合操作的计算结果添加到df的每一行
```


```python
np.random.seed(0)
d1={'item':['luobo','baicai','lajiao','donggua','luobo','baicai','lajiao','donggua'],
   'color':['white','white','red','green','white','white','red','green'],
   'weight':np.random.randint(10,size = 8),
   'price':np.random.randint(10,size = 8)}
df = DataFrame(d1)
display(df)
sums = df.groupby('color').sum().add_prefix('total_')
display(sums)
items = df.groupby('item')['price','weight'].sum()
display(items)
means = items['price']/items['weight']
display(means)
means = DataFrame(means,columns=['means_price'])
display(means)
df2 = pd.merge(df,sums,left_on = 'color',right_index = True)

df3 = pd.merge(df2,means,left_on = 'item',right_index = True)
display(df2,df3)
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
      <th>item</th>
      <th>color</th>
      <th>weight</th>
      <th>price</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>luobo</td>
      <td>white</td>
      <td>5</td>
      <td>2</td>
    </tr>
    <tr>
      <th>1</th>
      <td>baicai</td>
      <td>white</td>
      <td>0</td>
      <td>4</td>
    </tr>
    <tr>
      <th>2</th>
      <td>lajiao</td>
      <td>red</td>
      <td>3</td>
      <td>7</td>
    </tr>
    <tr>
      <th>3</th>
      <td>donggua</td>
      <td>green</td>
      <td>3</td>
      <td>6</td>
    </tr>
    <tr>
      <th>4</th>
      <td>luobo</td>
      <td>white</td>
      <td>7</td>
      <td>8</td>
    </tr>
    <tr>
      <th>5</th>
      <td>baicai</td>
      <td>white</td>
      <td>9</td>
      <td>8</td>
    </tr>
    <tr>
      <th>6</th>
      <td>lajiao</td>
      <td>red</td>
      <td>3</td>
      <td>1</td>
    </tr>
    <tr>
      <th>7</th>
      <td>donggua</td>
      <td>green</td>
      <td>5</td>
      <td>6</td>
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
      <th>total_weight</th>
      <th>total_price</th>
    </tr>
    <tr>
      <th>color</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>green</th>
      <td>8</td>
      <td>12</td>
    </tr>
    <tr>
      <th>red</th>
      <td>6</td>
      <td>8</td>
    </tr>
    <tr>
      <th>white</th>
      <td>21</td>
      <td>22</td>
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
      <th>price</th>
      <th>weight</th>
    </tr>
    <tr>
      <th>item</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>baicai</th>
      <td>12</td>
      <td>9</td>
    </tr>
    <tr>
      <th>donggua</th>
      <td>12</td>
      <td>8</td>
    </tr>
    <tr>
      <th>lajiao</th>
      <td>8</td>
      <td>6</td>
    </tr>
    <tr>
      <th>luobo</th>
      <td>10</td>
      <td>12</td>
    </tr>
  </tbody>
</table>
</div>



    item
    baicai     1.333333
    donggua    1.500000
    lajiao     1.333333
    luobo      0.833333
    dtype: float64



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
      <th>means_price</th>
    </tr>
    <tr>
      <th>item</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>baicai</th>
      <td>1.333333</td>
    </tr>
    <tr>
      <th>donggua</th>
      <td>1.500000</td>
    </tr>
    <tr>
      <th>lajiao</th>
      <td>1.333333</td>
    </tr>
    <tr>
      <th>luobo</th>
      <td>0.833333</td>
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
      <th>item</th>
      <th>color</th>
      <th>weight</th>
      <th>price</th>
      <th>total_weight</th>
      <th>total_price</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>luobo</td>
      <td>white</td>
      <td>5</td>
      <td>2</td>
      <td>21</td>
      <td>22</td>
    </tr>
    <tr>
      <th>1</th>
      <td>baicai</td>
      <td>white</td>
      <td>0</td>
      <td>4</td>
      <td>21</td>
      <td>22</td>
    </tr>
    <tr>
      <th>4</th>
      <td>luobo</td>
      <td>white</td>
      <td>7</td>
      <td>8</td>
      <td>21</td>
      <td>22</td>
    </tr>
    <tr>
      <th>5</th>
      <td>baicai</td>
      <td>white</td>
      <td>9</td>
      <td>8</td>
      <td>21</td>
      <td>22</td>
    </tr>
    <tr>
      <th>2</th>
      <td>lajiao</td>
      <td>red</td>
      <td>3</td>
      <td>7</td>
      <td>6</td>
      <td>8</td>
    </tr>
    <tr>
      <th>6</th>
      <td>lajiao</td>
      <td>red</td>
      <td>3</td>
      <td>1</td>
      <td>6</td>
      <td>8</td>
    </tr>
    <tr>
      <th>3</th>
      <td>donggua</td>
      <td>green</td>
      <td>3</td>
      <td>6</td>
      <td>8</td>
      <td>12</td>
    </tr>
    <tr>
      <th>7</th>
      <td>donggua</td>
      <td>green</td>
      <td>5</td>
      <td>6</td>
      <td>8</td>
      <td>12</td>
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
      <th>item</th>
      <th>color</th>
      <th>weight</th>
      <th>price</th>
      <th>total_weight</th>
      <th>total_price</th>
      <th>means_price</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>luobo</td>
      <td>white</td>
      <td>5</td>
      <td>2</td>
      <td>21</td>
      <td>22</td>
      <td>0.833333</td>
    </tr>
    <tr>
      <th>4</th>
      <td>luobo</td>
      <td>white</td>
      <td>7</td>
      <td>8</td>
      <td>21</td>
      <td>22</td>
      <td>0.833333</td>
    </tr>
    <tr>
      <th>1</th>
      <td>baicai</td>
      <td>white</td>
      <td>0</td>
      <td>4</td>
      <td>21</td>
      <td>22</td>
      <td>1.333333</td>
    </tr>
    <tr>
      <th>5</th>
      <td>baicai</td>
      <td>white</td>
      <td>9</td>
      <td>8</td>
      <td>21</td>
      <td>22</td>
      <td>1.333333</td>
    </tr>
    <tr>
      <th>2</th>
      <td>lajiao</td>
      <td>red</td>
      <td>3</td>
      <td>7</td>
      <td>6</td>
      <td>8</td>
      <td>1.333333</td>
    </tr>
    <tr>
      <th>6</th>
      <td>lajiao</td>
      <td>red</td>
      <td>3</td>
      <td>1</td>
      <td>6</td>
      <td>8</td>
      <td>1.333333</td>
    </tr>
    <tr>
      <th>3</th>
      <td>donggua</td>
      <td>green</td>
      <td>3</td>
      <td>6</td>
      <td>8</td>
      <td>12</td>
      <td>1.500000</td>
    </tr>
    <tr>
      <th>7</th>
      <td>donggua</td>
      <td>green</td>
      <td>5</td>
      <td>6</td>
      <td>8</td>
      <td>12</td>
      <td>1.500000</td>
    </tr>
  </tbody>
</table>
</div>



```python
# 可以使用transform和apply实现相同功能
```


```python
# transform
```


```python
d1={'item':['luobo','baicai','lajiao','donggua','luobo','baicai','lajiao','donggua'],
   'color':['white','white','red','green','white','white','red','green'],
   'weight':np.random.randint(10,size = 8),
   'price':np.random.randint(10,size = 8)}
df = DataFrame(d1)
sum1 = df.groupby('color')['price','weight'].sum().add_prefix("total_")
print(df.groupby('color')['price','weight'].transform(lambda x:x.sum()))
sums2 = df.groupby('color')['price','weight'].transform(lambda x:x.sum()).add_prefix('total_')
sums3 = df.groupby('color')['price','weight'].transform(sum).add_prefix('total_')
display(sum,df,sum1,sums2,sums3)
```

       price  weight
    0     21       6
    1     21       6
    2     11       6
    3      9       2
    4     21       6
    5     21       6
    6     11       6
    7      9       2
    


    <function sum(iterable, start=0, /)>



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
      <th>item</th>
      <th>color</th>
      <th>weight</th>
      <th>price</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>luobo</td>
      <td>white</td>
      <td>1</td>
      <td>7</td>
    </tr>
    <tr>
      <th>1</th>
      <td>baicai</td>
      <td>white</td>
      <td>2</td>
      <td>5</td>
    </tr>
    <tr>
      <th>2</th>
      <td>lajiao</td>
      <td>red</td>
      <td>4</td>
      <td>9</td>
    </tr>
    <tr>
      <th>3</th>
      <td>donggua</td>
      <td>green</td>
      <td>2</td>
      <td>0</td>
    </tr>
    <tr>
      <th>4</th>
      <td>luobo</td>
      <td>white</td>
      <td>0</td>
      <td>2</td>
    </tr>
    <tr>
      <th>5</th>
      <td>baicai</td>
      <td>white</td>
      <td>3</td>
      <td>7</td>
    </tr>
    <tr>
      <th>6</th>
      <td>lajiao</td>
      <td>red</td>
      <td>2</td>
      <td>2</td>
    </tr>
    <tr>
      <th>7</th>
      <td>donggua</td>
      <td>green</td>
      <td>0</td>
      <td>9</td>
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
      <th>total_price</th>
      <th>total_weight</th>
    </tr>
    <tr>
      <th>color</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>green</th>
      <td>9</td>
      <td>2</td>
    </tr>
    <tr>
      <th>red</th>
      <td>11</td>
      <td>6</td>
    </tr>
    <tr>
      <th>white</th>
      <td>21</td>
      <td>6</td>
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
      <th>total_price</th>
      <th>total_weight</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>21</td>
      <td>6</td>
    </tr>
    <tr>
      <th>1</th>
      <td>21</td>
      <td>6</td>
    </tr>
    <tr>
      <th>2</th>
      <td>11</td>
      <td>6</td>
    </tr>
    <tr>
      <th>3</th>
      <td>9</td>
      <td>2</td>
    </tr>
    <tr>
      <th>4</th>
      <td>21</td>
      <td>6</td>
    </tr>
    <tr>
      <th>5</th>
      <td>21</td>
      <td>6</td>
    </tr>
    <tr>
      <th>6</th>
      <td>11</td>
      <td>6</td>
    </tr>
    <tr>
      <th>7</th>
      <td>9</td>
      <td>2</td>
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
      <th>total_price</th>
      <th>total_weight</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>21</td>
      <td>6</td>
    </tr>
    <tr>
      <th>1</th>
      <td>21</td>
      <td>6</td>
    </tr>
    <tr>
      <th>2</th>
      <td>11</td>
      <td>6</td>
    </tr>
    <tr>
      <th>3</th>
      <td>9</td>
      <td>2</td>
    </tr>
    <tr>
      <th>4</th>
      <td>21</td>
      <td>6</td>
    </tr>
    <tr>
      <th>5</th>
      <td>21</td>
      <td>6</td>
    </tr>
    <tr>
      <th>6</th>
      <td>11</td>
      <td>6</td>
    </tr>
    <tr>
      <th>7</th>
      <td>9</td>
      <td>2</td>
    </tr>
  </tbody>
</table>
</div>



```python
# apply操作
```


```python
def sum_price(x):
    return x.sum()
sums3 = df.groupby('color')['price','weight'].apply(lambda x:x.sum()).add_prefix('total_')
sums4 = df.groupby('color')['price','weight'].apply(sum_price).add_prefix('total_')
display(df,sums3,sums4)

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
      <th>item</th>
      <th>color</th>
      <th>weight</th>
      <th>price</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>luobo</td>
      <td>white</td>
      <td>7</td>
      <td>4</td>
    </tr>
    <tr>
      <th>1</th>
      <td>baicai</td>
      <td>white</td>
      <td>7</td>
      <td>3</td>
    </tr>
    <tr>
      <th>2</th>
      <td>lajiao</td>
      <td>red</td>
      <td>8</td>
      <td>0</td>
    </tr>
    <tr>
      <th>3</th>
      <td>donggua</td>
      <td>green</td>
      <td>1</td>
      <td>3</td>
    </tr>
    <tr>
      <th>4</th>
      <td>luobo</td>
      <td>white</td>
      <td>5</td>
      <td>5</td>
    </tr>
    <tr>
      <th>5</th>
      <td>baicai</td>
      <td>white</td>
      <td>9</td>
      <td>0</td>
    </tr>
    <tr>
      <th>6</th>
      <td>lajiao</td>
      <td>red</td>
      <td>8</td>
      <td>2</td>
    </tr>
    <tr>
      <th>7</th>
      <td>donggua</td>
      <td>green</td>
      <td>9</td>
      <td>3</td>
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
      <th>total_price</th>
      <th>total_weight</th>
    </tr>
    <tr>
      <th>color</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>green</th>
      <td>6</td>
      <td>10</td>
    </tr>
    <tr>
      <th>red</th>
      <td>2</td>
      <td>16</td>
    </tr>
    <tr>
      <th>white</th>
      <td>12</td>
      <td>28</td>
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
      <th>total_price</th>
      <th>total_weight</th>
    </tr>
    <tr>
      <th>color</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>green</th>
      <td>6</td>
      <td>10</td>
    </tr>
    <tr>
      <th>red</th>
      <td>2</td>
      <td>16</td>
    </tr>
    <tr>
      <th>white</th>
      <td>12</td>
      <td>28</td>
    </tr>
  </tbody>
</table>
</div>



```python
# 练习：
# 假设菜市场张大妈在卖菜，有以下属性：
# 菜品(item)：萝卜，白菜，辣椒，冬瓜
# 颜色(color)：白，青，红
# 重量(weight)
# 价格(price)
# 要求以属性作为列索引，新建一个df = DataFrame
# 对df进行聚合操作，求出颜色为白色的价格总和
# 对df进行聚合操作，求出萝卜的所有重量(包括白萝卜，胡萝卜，青萝卜）以及平均价格
```


```python
d1={'item':['luobo','baicai','lajiao','donggua','luobo','baicai','lajiao','donggua'],
   'color':['white','white','red','green','white','white','red','green'],
   'weight':np.random.randint(10,size = 8),
   'price':np.random.randint(10,size = 8)}
df = DataFrame(d1)
g1 = df.groupby('color')['price']
g2 = df.groupby('item')['price','weight']
display(df,g1.sum(),g1.sum().green,g2.sum(),g2.sum()['weight']['donggua'])

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
      <th>item</th>
      <th>color</th>
      <th>weight</th>
      <th>price</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>luobo</td>
      <td>white</td>
      <td>2</td>
      <td>9</td>
    </tr>
    <tr>
      <th>1</th>
      <td>baicai</td>
      <td>white</td>
      <td>3</td>
      <td>1</td>
    </tr>
    <tr>
      <th>2</th>
      <td>lajiao</td>
      <td>red</td>
      <td>3</td>
      <td>4</td>
    </tr>
    <tr>
      <th>3</th>
      <td>donggua</td>
      <td>green</td>
      <td>2</td>
      <td>6</td>
    </tr>
    <tr>
      <th>4</th>
      <td>luobo</td>
      <td>white</td>
      <td>3</td>
      <td>8</td>
    </tr>
    <tr>
      <th>5</th>
      <td>baicai</td>
      <td>white</td>
      <td>4</td>
      <td>2</td>
    </tr>
    <tr>
      <th>6</th>
      <td>lajiao</td>
      <td>red</td>
      <td>1</td>
      <td>3</td>
    </tr>
    <tr>
      <th>7</th>
      <td>donggua</td>
      <td>green</td>
      <td>2</td>
      <td>0</td>
    </tr>
  </tbody>
</table>
</div>



    color
    green     6
    red       7
    white    20
    Name: price, dtype: int32



    6



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
      <th>price</th>
      <th>weight</th>
    </tr>
    <tr>
      <th>item</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>baicai</th>
      <td>3</td>
      <td>7</td>
    </tr>
    <tr>
      <th>donggua</th>
      <td>6</td>
      <td>4</td>
    </tr>
    <tr>
      <th>lajiao</th>
      <td>7</td>
      <td>4</td>
    </tr>
    <tr>
      <th>luobo</th>
      <td>17</td>
      <td>5</td>
    </tr>
  </tbody>
</table>
</div>



    4



```python

```
