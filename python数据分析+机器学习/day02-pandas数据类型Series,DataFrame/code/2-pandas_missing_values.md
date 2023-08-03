
# 处理丢失数据

有两种丢失数据：
- None
- np.nan(NaN)

## 1. None

None是Python自带的，其类型为python object。因此，None不能参与到任何计算中。

object类型的运算要比int类型的运算慢得多  
计算不同数据类型求和时间  
%timeit np.arange(1e5,dtype=xxx).sum()

## 2. np.nan（NaN）

np.nan是浮点类型，能参与到计算中。但计算的结果总是NaN。

但可以使用np.nan*()函数来计算nan，此时视nan为0。

## 3. pandas中的None与NaN

### 1) pandas中None与np.nan都视作np.nan

创建DataFrame


```python
import numpy as np
import pandas as pd
from pandas import Series,DataFrame
```


```python
df1 = DataFrame(data=np.random.randint(0,100,size=(3,3)),columns=list('ABC'))
display(df1)
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
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>31</td>
      <td>12</td>
      <td>81</td>
    </tr>
    <tr>
      <th>1</th>
      <td>6</td>
      <td>75</td>
      <td>33</td>
    </tr>
    <tr>
      <th>2</th>
      <td>38</td>
      <td>97</td>
      <td>94</td>
    </tr>
  </tbody>
</table>
</div>



```python
df1.loc[0,'B'] = None
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
      <th>A</th>
      <th>B</th>
      <th>C</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>31</td>
      <td>NaN</td>
      <td>81</td>
    </tr>
    <tr>
      <th>1</th>
      <td>6</td>
      <td>75.0</td>
      <td>33</td>
    </tr>
    <tr>
      <th>2</th>
      <td>38</td>
      <td>97.0</td>
      <td>94</td>
    </tr>
  </tbody>
</table>
</div>




```python
df1['C'] = np.nan
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
      <th>A</th>
      <th>B</th>
      <th>C</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>31</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>1</th>
      <td>6</td>
      <td>75.0</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>2</th>
      <td>38</td>
      <td>97.0</td>
      <td>NaN</td>
    </tr>
  </tbody>
</table>
</div>




```python
df1.loc[0,'B']
```




    nan



使用DataFrame行索引与列索引修改DataFrame数据

### 2) pandas中None与np.nan的操作

- ``isnull()``
- ``notnull()``
- ``dropna()``: 过滤丢失数据
- ``fillna()``: 填充丢失数据

(1)判断函数
- ``isnull()``
- ``notnull()``


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
      <th>A</th>
      <th>B</th>
      <th>C</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>31</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>1</th>
      <td>6</td>
      <td>75.0</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>2</th>
      <td>38</td>
      <td>97.0</td>
      <td>NaN</td>
    </tr>
  </tbody>
</table>
</div>




```python
df1.isnull()
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
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>False</td>
      <td>True</td>
      <td>True</td>
    </tr>
    <tr>
      <th>1</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
    </tr>
    <tr>
      <th>2</th>
      <td>False</td>
      <td>False</td>
      <td>True</td>
    </tr>
  </tbody>
</table>
</div>




```python
df1.notnull()
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
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>True</td>
      <td>False</td>
      <td>False</td>
    </tr>
    <tr>
      <th>1</th>
      <td>True</td>
      <td>True</td>
      <td>False</td>
    </tr>
    <tr>
      <th>2</th>
      <td>True</td>
      <td>True</td>
      <td>False</td>
    </tr>
  </tbody>
</table>
</div>



(2) 过滤函数
- ``dropna()``


```python
# 新增一行、一列
df1.loc[3] = [12,15,18]
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
      <th>A</th>
      <th>B</th>
      <th>C</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>31</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>1</th>
      <td>6</td>
      <td>75.0</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>2</th>
      <td>38</td>
      <td>97.0</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>3</th>
      <td>12</td>
      <td>15.0</td>
      <td>18.0</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 默认是过滤所有有缺失值的行
df1.dropna()
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
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>3</th>
      <td>12</td>
      <td>15.0</td>
      <td>18.0</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 使用axis控制轴向变化
df1.dropna(axis=1)
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
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>31</td>
    </tr>
    <tr>
      <th>1</th>
      <td>6</td>
    </tr>
    <tr>
      <th>2</th>
      <td>38</td>
    </tr>
    <tr>
      <th>3</th>
      <td>12</td>
    </tr>
  </tbody>
</table>
</div>




```python
df1.loc[3,'C'] = np.nan
```


```python
df1.dropna?
```


    [1;31mSignature:[0m [0mdf1[0m[1;33m.[0m[0mdropna[0m[1;33m([0m[0maxis[0m[1;33m=[0m[1;36m0[0m[1;33m,[0m [0mhow[0m[1;33m=[0m[1;34m'any'[0m[1;33m,[0m [0mthresh[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [0msubset[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [0minplace[0m[1;33m=[0m[1;32mFalse[0m[1;33m)[0m[1;33m[0m[0m
    [1;31mDocstring:[0m
    Remove missing values.
    
    See the :ref:`User Guide <missing_data>` for more on which values are
    considered missing, and how to work with missing data.
    
    Parameters
    ----------
    axis : {0 or 'index', 1 or 'columns'}, default 0
        Determine if rows or columns which contain missing values are
        removed.
    
        * 0, or 'index' : Drop rows which contain missing values.
        * 1, or 'columns' : Drop columns which contain missing value.
    
        .. deprecated:: 0.23.0: Pass tuple or list to drop on multiple
        axes.
    how : {'any', 'all'}, default 'any'
        Determine if row or column is removed from DataFrame, when we have
        at least one NA or all NA.
    
        * 'any' : If any NA values are present, drop that row or column.
        * 'all' : If all values are NA, drop that row or column.
    thresh : int, optional
        Require that many non-NA values.
    subset : array-like, optional
        Labels along other axis to consider, e.g. if you are dropping rows
        these would be a list of columns to include.
    inplace : bool, default False
        If True, do operation inplace and return None.
    
    Returns
    -------
    DataFrame
        DataFrame with NA entries dropped from it.
    
    See Also
    --------
    DataFrame.isna: Indicate missing values.
    DataFrame.notna : Indicate existing (non-missing) values.
    DataFrame.fillna : Replace missing values.
    Series.dropna : Drop missing values.
    Index.dropna : Drop missing indices.
    
    Examples
    --------
    >>> df = pd.DataFrame({"name": ['Alfred', 'Batman', 'Catwoman'],
    ...                    "toy": [np.nan, 'Batmobile', 'Bullwhip'],
    ...                    "born": [pd.NaT, pd.Timestamp("1940-04-25"),
    ...                             pd.NaT]})
    >>> df
           name        toy       born
    0    Alfred        NaN        NaT
    1    Batman  Batmobile 1940-04-25
    2  Catwoman   Bullwhip        NaT
    
    Drop the rows where at least one element is missing.
    
    >>> df.dropna()
         name        toy       born
    1  Batman  Batmobile 1940-04-25
    
    Drop the columns where at least one element is missing.
    
    >>> df.dropna(axis='columns')
           name
    0    Alfred
    1    Batman
    2  Catwoman
    
    Drop the rows where all elements are missing.
    
    >>> df.dropna(how='all')
           name        toy       born
    0    Alfred        NaN        NaT
    1    Batman  Batmobile 1940-04-25
    2  Catwoman   Bullwhip        NaT
    
    Keep only the rows with at least 2 non-NA values.
    
    >>> df.dropna(thresh=2)
           name        toy       born
    1    Batman  Batmobile 1940-04-25
    2  Catwoman   Bullwhip        NaT
    
    Define in which columns to look for missing values.
    
    >>> df.dropna(subset=['name', 'born'])
           name        toy       born
    1    Batman  Batmobile 1940-04-25
    
    Keep the DataFrame with valid entries in the same variable.
    
    >>> df.dropna(inplace=True)
    >>> df
         name        toy       born
    1  Batman  Batmobile 1940-04-25
    [1;31mFile:[0m      d:\software\anaconda3\lib\site-packages\pandas\core\frame.py
    [1;31mType:[0m      method
    



```python
# inplace默认为False,设置为True,表示修改原始数据结构
df1.dropna(axis=1,how='all',inplace=True)
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
      <th>A</th>
      <th>B</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>31</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>1</th>
      <td>6</td>
      <td>75.0</td>
    </tr>
    <tr>
      <th>2</th>
      <td>38</td>
      <td>97.0</td>
    </tr>
    <tr>
      <th>3</th>
      <td>12</td>
      <td>15.0</td>
    </tr>
  </tbody>
</table>
</div>



可以选择过滤的是行还是列（默认为行）

也可以选择过滤的方式 how = 'all'

(3) 填充函数 Series/DataFrame
- ``fillna()``


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
      <th>A</th>
      <th>B</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>31</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>1</th>
      <td>6</td>
      <td>75.0</td>
    </tr>
    <tr>
      <th>2</th>
      <td>38</td>
      <td>97.0</td>
    </tr>
    <tr>
      <th>3</th>
      <td>12</td>
      <td>15.0</td>
    </tr>
  </tbody>
</table>
</div>




```python
# value参数默认是把所有空值用指定值填充
df1.fillna(value=100)
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
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>31</td>
      <td>100.0</td>
    </tr>
    <tr>
      <th>1</th>
      <td>6</td>
      <td>75.0</td>
    </tr>
    <tr>
      <th>2</th>
      <td>38</td>
      <td>97.0</td>
    </tr>
    <tr>
      <th>3</th>
      <td>12</td>
      <td>15.0</td>
    </tr>
  </tbody>
</table>
</div>




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
      <th>A</th>
      <th>B</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>31</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>1</th>
      <td>6</td>
      <td>75.0</td>
    </tr>
    <tr>
      <th>2</th>
      <td>38</td>
      <td>97.0</td>
    </tr>
    <tr>
      <th>3</th>
      <td>12</td>
      <td>15.0</td>
    </tr>
  </tbody>
</table>
</div>




```python
df1.fillna?
```


    [1;31mSignature:[0m [0mdf1[0m[1;33m.[0m[0mfillna[0m[1;33m([0m[0mvalue[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [0mmethod[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [0maxis[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [0minplace[0m[1;33m=[0m[1;32mFalse[0m[1;33m,[0m [0mlimit[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [0mdowncast[0m[1;33m=[0m[1;32mNone[0m[1;33m,[0m [1;33m**[0m[0mkwargs[0m[1;33m)[0m[1;33m[0m[0m
    [1;31mDocstring:[0m
    Fill NA/NaN values using the specified method
    
    Parameters
    ----------
    value : scalar, dict, Series, or DataFrame
        Value to use to fill holes (e.g. 0), alternately a
        dict/Series/DataFrame of values specifying which value to use for
        each index (for a Series) or column (for a DataFrame). (values not
        in the dict/Series/DataFrame will not be filled). This value cannot
        be a list.
    method : {'backfill', 'bfill', 'pad', 'ffill', None}, default None
        Method to use for filling holes in reindexed Series
        pad / ffill: propagate last valid observation forward to next valid
        backfill / bfill: use NEXT valid observation to fill gap
    axis : {0 or 'index', 1 or 'columns'}
    inplace : boolean, default False
        If True, fill in place. Note: this will modify any
        other views on this object, (e.g. a no-copy slice for a column in a
        DataFrame).
    limit : int, default None
        If method is specified, this is the maximum number of consecutive
        NaN values to forward/backward fill. In other words, if there is
        a gap with more than this number of consecutive NaNs, it will only
        be partially filled. If method is not specified, this is the
        maximum number of entries along the entire axis where NaNs will be
        filled. Must be greater than 0 if not None.
    downcast : dict, default is None
        a dict of item->dtype of what to downcast if possible,
        or the string 'infer' which will try to downcast to an appropriate
        equal type (e.g. float64 to int64 if possible)
    
    See Also
    --------
    interpolate : Fill NaN values using interpolation.
    reindex, asfreq
    
    Returns
    -------
    filled : DataFrame
    
    Examples
    --------
    >>> df = pd.DataFrame([[np.nan, 2, np.nan, 0],
    ...                    [3, 4, np.nan, 1],
    ...                    [np.nan, np.nan, np.nan, 5],
    ...                    [np.nan, 3, np.nan, 4]],
    ...                    columns=list('ABCD'))
    >>> df
         A    B   C  D
    0  NaN  2.0 NaN  0
    1  3.0  4.0 NaN  1
    2  NaN  NaN NaN  5
    3  NaN  3.0 NaN  4
    
    Replace all NaN elements with 0s.
    
    >>> df.fillna(0)
        A   B   C   D
    0   0.0 2.0 0.0 0
    1   3.0 4.0 0.0 1
    2   0.0 0.0 0.0 5
    3   0.0 3.0 0.0 4
    
    We can also propagate non-null values forward or backward.
    
    >>> df.fillna(method='ffill')
        A   B   C   D
    0   NaN 2.0 NaN 0
    1   3.0 4.0 NaN 1
    2   3.0 4.0 NaN 5
    3   3.0 3.0 NaN 4
    
    Replace all NaN elements in column 'A', 'B', 'C', and 'D', with 0, 1,
    2, and 3 respectively.
    
    >>> values = {'A': 0, 'B': 1, 'C': 2, 'D': 3}
    >>> df.fillna(value=values)
        A   B   C   D
    0   0.0 2.0 2.0 0
    1   3.0 4.0 2.0 1
    2   0.0 1.0 2.0 5
    3   0.0 3.0 2.0 4
    
    Only replace the first NaN element.
    
    >>> df.fillna(value=values, limit=1)
        A   B   C   D
    0   0.0 2.0 2.0 0
    1   3.0 4.0 NaN 1
    2   NaN 1.0 NaN 5
    3   NaN 3.0 NaN 4
    [1;31mFile:[0m      d:\software\anaconda3\lib\site-packages\pandas\core\frame.py
    [1;31mType:[0m      method
    



```python
df1.fillna(method='ffill',limit=1,axis=1)
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
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>31.0</td>
      <td>31.0</td>
    </tr>
    <tr>
      <th>1</th>
      <td>6.0</td>
      <td>75.0</td>
    </tr>
    <tr>
      <th>2</th>
      <td>38.0</td>
      <td>97.0</td>
    </tr>
    <tr>
      <th>3</th>
      <td>12.0</td>
      <td>15.0</td>
    </tr>
  </tbody>
</table>
</div>



可以选择前向填充还是后向填充

对于DataFrame来说，还要选择填充的轴axis。记住，对于DataFrame来说：

- axis=0：index/行
- axis=1：columns/列

============================================

练习7：

1. 简述None与NaN的区别

2. 假设张三李四参加模拟考试，但张三因为突然想明白人生放弃了英语考试，因此记为None，请据此创建一个DataFrame,命名为ddd3

3. 老师决定根据用数学的分数填充张三的英语成绩，如何实现？
    用李四的英语成绩填充张三的英语成绩？

============================================


```python
data = np.random.randint(0,100,size=(3,3))
columns = ['语文','数学','英语']
index = ['张三','李四','王二小']
score = DataFrame(data=data, index=index,columns=columns)
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
      <th>语文</th>
      <th>数学</th>
      <th>英语</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>张三</th>
      <td>68</td>
      <td>97</td>
      <td>89</td>
    </tr>
    <tr>
      <th>李四</th>
      <td>49</td>
      <td>6</td>
      <td>73</td>
    </tr>
    <tr>
      <th>王二小</th>
      <td>51</td>
      <td>38</td>
      <td>0</td>
    </tr>
  </tbody>
</table>
</div>




```python
score.loc['张三','英语'] = np.nan
```


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
      <th>语文</th>
      <th>数学</th>
      <th>英语</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>张三</th>
      <td>68</td>
      <td>97</td>
      <td>NaN</td>
    </tr>
    <tr>
      <th>李四</th>
      <td>49</td>
      <td>6</td>
      <td>73.0</td>
    </tr>
    <tr>
      <th>王二小</th>
      <td>51</td>
      <td>38</td>
      <td>0.0</td>
    </tr>
  </tbody>
</table>
</div>




```python
score.fillna(method='ffill',axis=1)
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
      <th>语文</th>
      <th>数学</th>
      <th>英语</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>张三</th>
      <td>68.0</td>
      <td>97.0</td>
      <td>97.0</td>
    </tr>
    <tr>
      <th>李四</th>
      <td>49.0</td>
      <td>6.0</td>
      <td>73.0</td>
    </tr>
    <tr>
      <th>王二小</th>
      <td>51.0</td>
      <td>38.0</td>
      <td>0.0</td>
    </tr>
  </tbody>
</table>
</div>




```python
score.fillna(method='bfill',axis=0)
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
      <th>语文</th>
      <th>数学</th>
      <th>英语</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>张三</th>
      <td>68</td>
      <td>97</td>
      <td>73.0</td>
    </tr>
    <tr>
      <th>李四</th>
      <td>49</td>
      <td>6</td>
      <td>73.0</td>
    </tr>
    <tr>
      <th>王二小</th>
      <td>51</td>
      <td>38</td>
      <td>0.0</td>
    </tr>
  </tbody>
</table>
</div>


