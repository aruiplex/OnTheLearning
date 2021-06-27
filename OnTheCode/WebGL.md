# WebGL (web 图形库)

1. 定义: 是一种 js 的 api.
2. 用途: 在浏览器中渲染高性能的交互式 3D 和 2D 图形. WebGL 通过引入一个与 OpenGL ES 2.0 `TODO:OpenGL` 非常一致的 API 来做到这一点，这种一致性使 API 可以利用用户设备提供的硬件图形加速。
3. 作用范围: HTML5 `<canvas>` 元素中使用, 所以是用 js 进行开发的.

## 与 three.js 的关系

three.js 是对 WebGL Api 的封装, WebGL 是直接调用底层的 OpenGL, OpenGL 可以使用硬件资源(显卡加速)

Threejs 在底层其实还是调用 html5 中的 canvas api 来实现绘图的。但和我们一般绘制 2D 图像不同，Threejs 在底层使用的是 canvas 的 webgl context 来实现 3D 绘图。webgl context 本身更多是直接对 gpu 的操作，用起来相当不直观，为此 Threejs 在顶层对 3D 绘图所需的各种元素（例如场景，摄影机，灯光，几何图像，材质等）进行了封装，如果我们需要使用 Threejs 来绘图，只需要创建一个最小绘图环境即可，这个最小绘图环境包含了三个要素：

1. 场景--包含所有需要显示的 3D 物体以及其他相关元素的容器

2. 摄像机--决定 3D 场景如何投影到 2D 画布之上

3. 渲染器--用于最后绘制的画笔

# 航拍 3 维重建

看到这个的时候我还是挺震惊的, 这东西不就是点云--(minus)吗; 还是很有意思的, 拍出来的照片是平面的, 转换之后竟然能做到立体 3d 效果.

TODO:

# Reference

1. [MDN](https://developer.mozilla.org/zh-CN/docs/Web/API/WebGL_API)
2. [three.js 的一篇 blog](https://cloud.tencent.com/developer/article/1005097)
