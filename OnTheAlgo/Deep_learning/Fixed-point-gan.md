# Paper reading: Learning Fixed Points in Generative Adversarial Networks, From Image-to-Image Translation to Disease Detection and Localization




先是提出了一个疑问和4个要求：



疑问：

Can we train a GAN to remove an object, if present, from an image while otherwise preserving the image？

我们是否可以训练 GAN 从图像中移除一个对象（如果存在），同时保留图像？

4个要求：

1. The GAN must handle unpaired images. It maybe too arduous to collect a perfect pair of photos of the。必须可以用在不成对的图像里。不可能有一个 戴眼镜的人 和一摸一样的 不带眼镜的人 的套图的。
2. The GAN must require no source domain label when translating an image into a target domain (i.e.,
   source-domain-independent translation). For instance, a GAN trained for virtual healing aims to turn any image, with unknown health status, into a healthy one. 无论是健康的状况怎么样，都要把图像转移到健康的情况里。这是*源域无关翻译 （source-domain-independent-translation）*。
3. The GAN must conduct an identity transformation for same-domain translation. For “virtual healing”, the GAN should leave a healthy image intact, injecting neither artifacts nor new information into the image. 它必须能分得清楚图像是不是 same-domain。如果给他一个好的图片，就必须能发现这是一个健康的人的图片而不进行任何处理。
4. The GAN must perform a minimal image transformation for cross-domain translation. Changes should be applied only to the image attributes directly relevant to the translation task, with no impact on unrelated attributes. For instance, removing eyeglasses should not affect the remainder of the image (e.g., the hair, face color, and background), or removing diseases from a diseased image should not impact the region of the image labeled as normal. 它必须能执行cross-domain的最小变化。并且改变的部位都是有必要的。





具体来说，GAN 能否通过将未知健康状况（疾病或健康）的医学图像转换为健康图像，从而通过减去这两个图像来揭示患病区域，从而“几乎治愈”任何人？



提出一个概念：

*定点翻译能力（Fixed-point translation）*，需要让GAN识别 a minimal subset==(什么的subset？)== of target pixels for domain translation的能力，被称为：fixed-point translation。



给人的感觉是，健康的人的image的健康区域是健康domain，不健康的地方是不健康domain。



论文说，Fixed-Point GAN, trained by supervising same-domain translation through a conditional ==identity loss==（什么是identity loss？）, and regularizing cross-domain translation through ==revised adversarial==（什么是修正对抗性？）, domain classification, and ==cycle consistency loss==. 

Based on ==fixed-point translation==（定点翻译？？）, we further derive a novel framework for disease detection and localization using only image level annotation.把整张图片打标之后放到对应数据集里？？



Qualitative and quantitative evaluations demonstrate that the proposed method outperforms the state of the art in multi-domain image-to-image translation and that it surpasses predominant weakly-supervised localization methods in both disease detection and localization.

## 什么是image-to-image translation？

image-to-image translation: 图像到图像的翻译：就是不健康图 =>  翻译 => 健康图。举个例子，从中文翻译成英语。应该就是 sentence-to-sentence translation。



## 分析了竞品





## 我们的GAN

Therefore, we propose a novel GAN. We call it Fixed-Point GAN for its new fixed-point translation ability,
which allows the GAN to identify a minimal subset of pixels for domain translation. 我们的GAN叫fixed-point GAN，因为他有能力识别最小的像素做domain翻译。

Mathematically, x is a fixed point of function f(·) if f(x) = x. We borrow the term to describe the pixels to be preserved when applying the GAN translation function. 在数学上，如果 f(x) = x，x 是函数 f(·) 的不动点。 我们借用这个术语来描述在应用 GAN 转换函数时要保留的像素。这就是fixed-point的来源。

To achieve this capability, we have devised a new training scheme to promote the fixed-point translation during training by supervising same-domain translation through an additional conditional ==identity loss==, and ==regularizing cross-domain translation== through revised adversarial, domain classification, and cycle consistency loss. 

这就没懂

1. identity loss.
2. regular cross-domain translation.

Owing to its fixed-point translation ability, Fixed Point GAN performs a minimal transformation for cross domain translation and strives for an identity transformation for same-domain translation. Consequently, Fixed-Point GAN not only achieves better image-to-image translation for natural images but also offers a novel framework for disease detection and localization with only image-level annotation. 说我们的GAN不仅对自然图片有效，也对疾病的侦测与定位有效。并且仅需要图像级别的标注。

Our experiments demonstrate that Fixed-Point GAN significantly outperforms StarGAN over multiple datasets for the tasks of image-to-image translation and predominant anomaly detection and weakly-supervised localization methods for disease detection and localization. Formally, we make the following contributions









