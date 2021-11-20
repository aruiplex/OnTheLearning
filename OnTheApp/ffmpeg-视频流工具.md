# ffmpeg

```shell
# 从视频中抽取音频: 

ffmpeg -i sample.avi -q:a 0 -map a sample.mp3
```



压制

```bash

 ffmpeg -i input.mp4 -vcodec libx265 -crf 28 output.mp4
```

28是压缩率，越小质量越高
