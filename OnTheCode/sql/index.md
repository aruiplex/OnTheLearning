# SQL

堪称最常用的最反人类的语言。

这东西为什么没人改改？

不过其实没那么烂，只能怪我用的少。



## 改变所有的`is_start`值，如果start_time在现在之前，就更新为已经开始。

```sql
UPDATE teaforence
SET teaforence.is_start =
CASE WHEN teaforence.start_time < NOW() THEN TRUE
ELSE FALSE END;
```



## 插入用户信息

```sql
INSERT INTO user
(create_time, email, password, nickname, alipay_img, wxpay_img, slogan, followee_num, follower_num, gender, is_enabled, username)
VALUES
('2021-06-21 22:18:25.402000', 'jingqun.zhang18@student.xjtlu.edu.cn', '$2a$10$g1RoVKOR1abP9r99Dn0T4uVdIKs0xVcVf6PiVtwdHUw0PBWX1tGLK', '22222', NULL, NULL, NULL,0, 0, 3, 1, "946dcca9-6aec-487f-963d-81e6214cddfa");
```

