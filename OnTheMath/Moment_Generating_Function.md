# Moment Generating Function



#### 1. 什么是*movement*？

对于随机变量$x$, **The moments are the expected values of X, e.g., E(X), E(X²), E(X³), … etc.**

> n movement is $E(x^n)$,
>
> n movement 是$x^n$的期望

对于比较常见的公式:
$$
\mu = E(x)
\\
Variance=E(X^2) − \mu^2
$$
$E(x^2)$​​ ​​就是 second moment.



#### 2. 什么是Moment Generating Function？

MGF是用于生成 n-th movement 的函数。

> MGF is literally the function that generates the moments $E(x^n)$​.

$$
M G F_{x}(t):=E\left[e^{t x}\right]= \begin{cases}\sum_{x} e^{t x} \cdot P(x) & x: \text { discrete } \\ \int_{x} e^{t x} \cdot f(x) dx &x: \text { continuous }\end{cases}\\

f(x)\space is\space PDF,\space P(x)\space is\space PMF
$$

> 也就是说，可以用$pdf$​​​来求出来$mgf$​​，求和 和 积分区间是$x$的取值范围，之后求出来 n-th movement.​



#### 3. 怎么从 MGF 得到 n-th movement？

**Take a derivative of MGF n times and plug t = 0 in. Then, you will get $E(X^n)$​​**
$$
\begin{aligned}
&E\left(X^{n}\right)=\left.\frac{d^{n}}{d t^{n}} M G F_{x}(t)\right|_{t=0} \\

\end{aligned}
$$

**n-th** moment:
$$
\begin{aligned}

&E(X)=\left.\frac{d}{d t} M G F_{x}(t)\right|_{t=0}=M G F_{x}^{\prime}(0) \\
&E\left(x^{2}\right)=\left.\frac{d^{2}}{d t^{2}} M G F_{x}(t)\right|_{t=0}=M G F_{x}^{\prime \prime}(0)
\end{aligned}
$$

> 这里为什么会多一个t？原因在里面的原理中会讲到。
>
>  **t** is a helper variable. We introduced **t** in order to be able to use calculus (derivatives) and make the terms (that we are not interested in) zero.



#### 4. 为什么 MGF 的 n-th derivative 是 n-th movement？

使用泰勒展开，具体的在reference中查看。



#### 5. Reference

https://towardsdatascience.com/moment-generating-function-explained-27821a739035

