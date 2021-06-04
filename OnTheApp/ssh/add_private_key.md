# Solve SSH add private problem

In some cases, the private key is not reachable for current user (you). Therefore, first change the authority for current user.



SSH integrate tool to add private key:

```bash
ssh-add ~/.ssh/id_rsa
```



Exception:

1. Permissions 0755 for are too open.

   Keys need to be only readable by you (what i did):

   ```bash
   chmod 400 ~/.ssh/id_rsa
   ```

   If Keys need to be read-writable by you:

   ```bash
   chmod 600 ~/.ssh/id_rsa
   ```

   

Reference:

1. https://stackoverflow.com/questions/9270734/ssh-permissions-are-too-open-error
2. https://stackoverflow.com/questions/3466626/how-to-permanently-add-a-private-key-with-ssh-add-on-ubuntu

