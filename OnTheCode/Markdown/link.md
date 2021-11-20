# Markdown link

Github automatically parses anchor tags out of your headers. So you can do the following:

```md
[Custom foo description](#foo)

# Foo
```

In the above case, the `Foo` header has generated an anchor tag with the name `foo`

**Note**: just one `#` for all heading sizes, no space between `#` and anchor name, **anchor tag names must be lowercase, and delimited by dashes if multi-word**.

```md
[click on this link](#my-multi-word-header)

### My Multi Word Header
```

