# Git常见问题

1. 在使用过程中, 每次git pull、git push都需要输入账号和密码:

    这样的问题在windows中没见过, 但是在linux中确实是这样的, 每一次都要输入一遍.

    1. 存下来凭证

        ```bash
        $ git config credential.helper store
        $ git push http://example.com/repo.git
        Username: <type your username>
        Password: <type your password>
        ```

        但是这样是明文存下来账号密码, 在`~/.git-credentials `文件中.

        

        也可以放在内存里:

        ```bash
        $ git config credential.helper cache
        ```

        放内存里就不容易被看到了.