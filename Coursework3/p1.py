import datetime as dt
import pandas_datareader as pdr
import matplotlib.pyplot as plt
from matplotlib import style

start = dt.datetime(2010,1,1)
end = dt.datetime.now()

df = pdr.DataReader(["DJIA","SP500"],"fred",start,end)

print("\nPrint number of records: ")

print(df.columns)

print("\nPrind data frame: ")
print(df)

print("\nPrint first five lines: ")
print(df.head())
print("\nPrint last five lines: ")
print(df.tail())
print("\nPrint first 2 lines: ")
print(df.head(2))
print("\nPrint last 2 lines: ")
print(df.tail(2))

style.use('ggplot')

df['DJIA'].plot()
df['SP500'].plot()
plt.legend()
plt.show()