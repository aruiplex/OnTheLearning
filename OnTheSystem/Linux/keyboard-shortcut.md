# Linux中的快捷键系统

本来开开心心用的好好的，突然vscode的智能补全就不能用了`ctrl .`。会出来很奇怪的东西，今天碰巧在出来奇怪东西的时候按了一下空格，结果是一堆emoji。我顺着ubuntu下的emoji查了查，发现是ubuntu的 emoji picker。这整个过程真的一言难尽。就顺着[stackoverflow](https://askubuntu.com/questions/1045915/how-to-insert-an-emoji-into-a-text-in-ubuntu-18-04-and-later)和[askubuntu](https://askubuntu.com/questions/1039008/how-can-i-change-the-keyboard-shortcut-for-emoji-picker)做下去，就解决了问题。

```bash
ibus-setup
```

里面可以设置。

在快捷键里面的dot是叫做period。

我先是查了ubuntu的shortcut调用原理，想从原理中看到是谁占用了这个快捷键，发现不可以查得到。还好一通瞎按，找到了线索。

