# Font settings in linux 



Fonts directory: `/usr/local/share/fonts`

```bash
mv fonts.ttc /usr/local/share/fonts
fc-cache -f -v
fc-list | grep "sarasa"
```

