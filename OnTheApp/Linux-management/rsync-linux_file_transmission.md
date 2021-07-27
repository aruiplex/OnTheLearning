# rsync

It is a little like `cp`

The common syntax:

```bash
# --progress: display the process bar and speed.
rsync --progress <source> <destination>

# the upgrade version between two devices connected by network
rsync -avzh --remove-source-files --progress /source/ user@server:/target 
&&  find /source -type d -empty -delete
```

The common parameters:

- **-a** means "archive" and copies **everything recursively** from source to destination preserving nearly everything.
- **-v** gives more output ("verbose").
- **-h** for human readable.
- **--progress** to show how much work is done.
- **--remove-source-files** to remove the original files after transmission.





Another tool:

# Unison

Synchronize in both directions.

```bash
unison <Source> <Destination>
```





##### Reference:

[1] How to copy-merge two directories: https://unix.stackexchange.com/questions/149965/how-to-copy-merge-two-directories



