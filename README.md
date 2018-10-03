KM-StickyHeader for Android RecyclerView
=============
[![Release](https://jitpack.io/v/smhdk/KM-Recyclerview-Sticky-Header.svg)](https://jitpack.io/#smhdk/KM-Recyclerview-Sticky-Header "![Release](https://jitpack.io/v/smhdk/KM-Recyclerview-Sticky-Header.svg)")

You can make sticky items in recyclerview with this library.

![Alt Text](https://media.giphy.com/media/1xVc3pqlRbwJIn9ebv/giphy.gif)
# Usage
-------------
Use KmRecyclerView component for show your items. 
```xml
<com.kodmap.library.kmrecyclerviewstickyheader.KmRecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```
If you do not want to use **KmRecyclerView** in your xml. Define new **KmHeaderItemDecoration** and set to your recyclerview.
```java
    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private KmHeaderItemDecoration kmHeaderItemDecoration;
    
    private void initRecyclerView(){
        adapter = new RecyclerViewAdapter(); // This custom adapter implementing KmStickyListener
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        kmHeaderItemDecoration = new KmHeaderItemDecoration(adapter);
    }
```
Extend your recyclerview adapter from KmStickyListener and handle override methods.
```java
public class RecyclerViewAdapter extends ListAdapter<Model, RecyclerView.ViewHolder> implements KmStickyListener {

 @Override
    public int getItemViewType(int position) {
        return getItem(position).type;
    }

    @Override
    public Integer getHeaderPositionForItem(Integer itemPosition) {
        //Implement for find sticky item position and return position
        return headerPosition;
    }

    @Override
    public Integer getHeaderLayout(Integer headerPosition) {
        //Return sticky item xml layout
        return R.layout.item_header;
    }

    @Override
    public void bindHeaderData(View header, Integer headerPosition) {
        //Bind item model to layout
    }
    
    @Override
    public Boolean isHeader(Integer itemPosition) {
        //Check if item is sticky header
        return null;
    }
}
```

# Download
-------------
##### Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
##### Step 2. Add the dependency
Add it in app build.gradle
```
dependencies {
		compile 'com.github.smhdk:KM-Recyclerview-Sticky-Header:v1.0.0'
	}
```
  
# Licence
-------------
MIT License

Copyright (c) 2018 Semih Dik

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
