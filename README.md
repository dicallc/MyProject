# Material新闻系统

<H2>1.当初开发的想法：</H2>

当初只是想做一个小小的心理测试项目，最后发现有个库很炫，就试着导入进去，发现挺好用的 
 开源库名字叫做materialviewpager 
 其实主要代码挺容易看懂的。
 
 
<H2>2.这个项目用到了那些东西</H2>

（1）项目是由服务器端的，使用bmob来实现的，没有服务器是挺麻烦的，我在服务器写好html的脚本，然后存在云端，然后再客户端用webview
,也算对于我们这种没钱买服务器的一种解决办法。
<br><br>

（2）同时也用到了5.0的ActivityTransition，有点小bug 没有解决，跳转动画，挺炫的，大家可以当初抽出来用一下 名字叫做
PreLollipopTransition
<br><br>

（3）RecyclerView 列表是用它来实现的，其实有个bug 就是不能条目点击，网上有很多解决办法，感觉都看不懂，最后我想了一下，没改源码，直接
填充器做了点击事件处理，就实现了条目点击。
<br><br>

（4）同时图片处理框架，仁者见仁，智者见智吧。我没有任何偏爱，项目中用到Picasso 我觉得挺好用的，推荐大家使用，从设置圆角到缓存加载，就一句话
很多开源项目中也用到了，我也就没有加其他的图片框架了。
<br><br>

（5）首页呢，用到了两个开源框架 MoveImageView 见名知意 ShimmerTextView 见名知意 是Facebook 开源的一个项目，我都抽出来了。大家以后
直接拿来用在View包里面。
<br><br>
<H2>3.总结：</H2>
其实这个项目总共也就花了两天时间做的，我一直在想，怎么解决展示性内容，最后在bmob发现了，竟然支持html语言，随后我就学了半天html5
写了点一些内容详情页。

<H2>4.关于内容问题：</H2>
如果你对于内容感兴趣的，可以加我QQ350474510 我在深圳~

<H2>app展示图</H2>
<img src="http://a.hiphotos.baidu.com/image/pic/item/a5c27d1ed21b0ef47b8fc2c6d8c451da80cb3ec6.jpg" />
<br><br><br>
<img src="http://g.hiphotos.baidu.com/image/pic/item/1c950a7b02087bf4a4631271f7d3572c10dfcf9f.jpg" />
