总共有3种css

1. Inline CSS: 内联css
2. Internal or Embedded CSS: 内部或嵌入css 
3. External CSS: 外部css





**内联CSS：**内联CSS包含在body部分中的CSS属性，该属性随元素附加在一起，称为内联CSS。这种样式是在HTML标记中使用style属性指定的。

```html
这是inline css
<!DOCTYPE html> 
<html> 
	<head> 
		<title>Inline CSS</title> 
	</head> 
	
	<body> 
		<p style = "color:#009900; font-size:50px; 
				font-style:italic; text-align:center;"> 
			GeeksForGeeks 
		</p> 
	</body> 
</html>		 



```



**内部或嵌入式CSS：**当单个HTML文档必须具有唯一样式时，可以使用此样式。CSS规则集应位于头部的HTML文件中，*即CSS嵌入在HTML文件中*。

```html
<!DOCTYPE html> 
<html> 
	<head> 
		<title>Internal CSS</title> 
		<style> 
			.main { 
				text-align:center; 
			} 
			.GFG { 
				color:#009900; 
				font-size:50px; 
				font-weight:bold; 
			} 
			.geeks { 
				font-style:bold; 
				font-size:20px; 
			} 
		</style> 
	</head> 
	<body> 
		<div class = "main"> 
			<div class ="GFG">GeeksForGeeks</div> 
			
			<div class ="geeks"> 
				A computer science portal for geeks 
			</div> 
		</div> 
	</body> 
</html>			 

```



**外部CSS：**外部CSS包含单独的CSS文件，该文件仅包含样式属性，借助标签属性（例如，类，id，标题等）。CSS属性写在一个扩展名为.css的单独文件中，应使用**链接**标记链接到HTML文档。这意味着对于每个元素，样式只能设置一次，并将应用于整个网页。

```html
<!DOCTYPE html> 
<html> 
	<head> 
		<link rel="stylesheet" href="geeks.css"/> 
        // 引入css
	</head> 

	<body> 
		<div class = "main"> 
			<div class ="GFG">GeeksForGeeks</div> 
			<div id ="geeks"> 
				A computer science portal for geeks 
			</div> 
		</div> 
	</body> 
</html> 

```



```css
// geeks.css

body {
    background-color:powderblue;
}
.main {
    text-align:center;   
}
.GFG {
    color:#009900;
    font-size:50px;
    font-weight:bold;
}
#geeks {
    font-style:bold;
    font-size:20px;
}
```



**CSS的属性：**内联CSS具有最高优先级，然后是内部/嵌入式，其次是外部CSS，其优先级最低。可以在一页上定义多个样式表。如果对于HTML标签，在多个样式表中定义了样式，则将遵循以下顺序。

- 由于内联具有最高优先级，因此内部和外部样式表中定义的任何样式都将被内联样式覆盖。
- 内部或嵌入式在优先级列表中排第二，并且覆盖外部样式表中的样式。
- 外部样式表的优先级最低。如果没有在内联样式表或内部样式表中定义样式，则将外部样式表规则应用于HTML标签。