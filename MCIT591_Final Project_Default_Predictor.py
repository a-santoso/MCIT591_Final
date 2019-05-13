#!/usr/bin/env python
# coding: utf-8

# # MCIT591_Final Project_Default_Predictor
# 
# # Ian Park | Antonius Santoso

# In[2]:


# Basic setup
from IPython.core.display import display, HTML
display(HTML("<style>.container { width:95% !important; }</style>"))
import os
import pandas as pd
import numpy as np
import re
import seaborn as sns
import scipy
import matplotlib.pyplot as plt
import matplotlib.backends.backend_pdf
os.chdir("C:/Users/Ian Park/Downloads") # Change this to you local directory


# In[3]:


#importing data
base_Df = pd.read_csv("loan.csv")
base_Df.head()


# <br>
# <br>
# <br>
# 
# # 1: Data Exploration and Evaluation

# In[4]:


# Subset to targeted data
df=base_Df[['loan_amnt', 'funded_amnt', 'term', 'int_rate', 'grade', 'annual_inc','dti','revol_bal','total_pymnt','loan_status']]
df.head()


# In[5]:


# 1. We need to convert 'term' to float/int and 'grade','issue_d','loan_status' needs encoding
# Convert term into number
df['term_num'] = df['term'].astype(object).astype(str).str.replace(r"months", '')
df['term_num'] = df['term_num'].astype(float)

# Label encoder
from sklearn.preprocessing import LabelEncoder
labelencoder = LabelEncoder()
needenc=['grade','loan_status']
for var in needenc:
    df[str(var)+"_enc"] = labelencoder.fit_transform(df[var])
df.head()


# In[6]:


# 2. 'annual_inc' has 4 missing values
# given that only 0.0005% data is missing, I will just take linear imputation 
missing=df[pd.isnull(df['annual_inc'])]
missing.head()


# In[7]:


# Check the values make sense
df['annual_inc'].interpolate(method='linear', inplace=True)
print('The number of missing values in column %s is %d' %('annual_inc', sum(pd.isnull(df['annual_inc']))))


# In[8]:


# Check if the values make sense - not the best but for a small number and quick analysis, I think this is good enough
df.loc[missing.index.values]


# In[9]:


print('Data details: ')
print(df.describe())
try:
    print(df.describe(include=['object', 'bool']))
except:pass


# In[14]:


# Exclude outliers - more than three standard deviation
outliers=['annual_inc','dti','revol_bal','total_pymnt']
df_norm=df[np.abs(df['dti']-df['dti'].mean()) <= (3*df['dti'].std())]
for bye in outliers:
    df_norm=df_norm[np.abs(df_norm[bye]-df_norm[bye].mean()) <= (3*df_norm[bye].std())]


# In[15]:


print(df.shape)
print(df_norm.shape)


# In[16]:


# Get data ready for Logit and create maps for future reference
# Status detail and encoding map everything that is not fully paid will be considered as default
status_map=df_norm[['loan_status','loan_status_enc']]
status_map.drop_duplicates().sort_values(by=['loan_status_enc'],ascending=[True]).reset_index(drop=True)


# In[17]:


# Grade detail and encoding map
grade_map=df_norm[['grade','grade_enc']]
grade_map.drop_duplicates().sort_values(by=['grade_enc'],ascending=[True]).reset_index(drop=True)


# In[18]:


# Create biniary default flag
df_norm['fully_paid'] = (df_norm.loan_status_enc==5).astype(int)|(df_norm.loan_status_enc==4).astype(int)
df_norm.loc[df_norm['fully_paid'] == 1].head()


# In[19]:


# Create dependent and independent variables
x=df_norm.select_dtypes(['number'])
x=x[x.columns.difference(['au_ror','issue year','loan_status_enc','term','fully_paid'])]
x.head(10)


# In[20]:


y=df_norm['fully_paid']
y.head()


# <br>
# <br>
# <br>
# 
# # 2. Logistic Regression
# 

# In[21]:


import statsmodels.discrete.discrete_model as sm
import statsmodels.formula.api as smf
import statsmodels.api as sma
from sklearn.model_selection import train_test_split

x=sma.add_constant(x)
x_train, x_test, y_train, y_test = train_test_split(x,y,test_size = 0.3, shuffle= True, random_state = 1)
results = sm.Logit(y_train,x_train).fit()
y_pred =pd.DataFrame(results.predict(x_test))
compare=pd.concat([y_test, y_pred], axis=1)
compare.columns=['y_test','y_pred']
compare.loc[compare['y_pred']>=0.5, 'y_pred_r'] = 1
compare.loc[compare['y_pred']<0.5, 'y_pred_r'] = 0
compare['match'] = compare['y_pred_r']==compare['y_test']
print(results.summary())
print('')
print('This model predicted default with '+str(len(compare[compare['match']==True])/len(compare)*100)+'% accuracy')
print('')
print(results.params)


# In[22]:


print(results.params)
results.params.to_csv("C:/Users/Ian Park/Downloads/coefficient.csv")


# # END of Notebook
