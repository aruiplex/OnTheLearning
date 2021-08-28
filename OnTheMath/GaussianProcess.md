# Gaussian Process

使用她的目的就是, 为了预测. 在给定了$n$个已知量之后, 需要在$m$个点上做出非线性预测 (non-linear regression).







## Multivariated Gaussian distribution 多元正态分布



k维随机向量 $\mathbf{X}=\left(X_{1}, \ldots, X_{k}\right)^{\mathrm{T}}$ 的多元正态分布写为: $\mathbf{X} \sim \mathcal{N}(\boldsymbol{\mu}, \mathbf{\Sigma})$​

> 一般情况下, multi-dimension 的空间就是n个长的列向量, 竖着的.

with $k$-dimensional mean vector:
$$
\boldsymbol{\mu}=\mathrm{E}[\mathbf{X}]=\left(\mathrm{E}\left[X_{1}\right], \mathrm{E}\left[X_{2}\right], \ldots, \mathrm{E}\left[X_{k}\right]\right)^{\mathbf{T}}
$$
and $k \times k$ covariance matrix:
$$
\Sigma_{i, j}=\mathrm{E}\left[\left(X_{i}-\mu_{i}\right)\left(X_{j}-\mu_{j}\right)\right]=\operatorname{Cov}\left[X_{i}, X_{j}\right]\\
where \space
1 \leq i, j \leq k
$$

很多个小的 $\Sigma_{i,j}$ 组成了完整的 $\Sigma$, 每一个$\Sigma_{i,j}$​是两个元素之间的相关性.

他的MGF (<a src="./Moment_Generating_Function.md"> Moment Generating Function</a>) 是:
$$
p(y|\Sigma) = exp(-\frac{1}{2}y^T\Sigma^{-1}y)\\
$$


如果$y$​是一个二维的向量, 那么

