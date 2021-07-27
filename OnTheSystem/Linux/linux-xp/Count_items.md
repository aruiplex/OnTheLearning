Count item number in a directory:

```bash
find DIR_NAME -type f | wc -l
```

-  `-type f`: to include only flies.
- `|`: redirects `find` command's standard output to `wc` command's standard input.
- `wc`: short for word count to count newlines, words and bytes on its input.
- `-l`: to count just new lines.

