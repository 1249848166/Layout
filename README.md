## 使用方式
```java
<mf.com.sulayout.SuLinearLayout
    android:orientation="horizontal"
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:text="Hello World!"
        android:layout_weight="1"
        android:layout_margin="10px"
        android:background="#f00"
        android:gravity="center"
        app:layout_widthPercent="0.5"
        app:layout_heightPercent="0.5"
        android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        />

    <TextView
        android:text="Hello World!"
        android:layout_margin="10px"
        android:layout_weight="1"
        android:background="#f00"
        app:layout_widthPercent="0.5"
        app:layout_heightPercent="0.5"
        android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        />
```
指定父视图为mf.com.sulayout包下的viewgroup控件，然后在其子控件中添加两个比例属性（比例属性存在时，会覆盖原油layout_width和layout_height属性使他们不起作用）
app:layout_widthPercent="0.5"
app:layout_heightPercent="0.5"
目前只提供LinearLayout和RelativeLayout