# Vim



Vim最重要的时候是远程连接和sudo，另外就是需要行号。

```
:set number 
```

批量注释：

1. First, go to the first line you want to comment, press CtrlV. This will put the editor in the `VISUAL BLOCK` mode.
2. Then using the arrow key and select until the last line
3. Now press ShiftI, which will put the editor in `INSERT` mode and then press #. This will add a hash to the first line.
4. Then press Esc (give it a second), and it will insert a `#` character on all other selected lines.







Reference：

[1] https://linuxize.com/post/how-to-show-line-numbers-in-vim/

[2] https://stackoverflow.com/questions/1676632/whats-a-quick-way-to-comment-uncomment-lines-in-vim