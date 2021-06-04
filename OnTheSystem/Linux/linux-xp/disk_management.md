# Disk Management

### Check disk status

list all disks and partitions:

```shell
fdisk -l
```

In a new disk, there has no partition in it. If you want to store any data, there must at least 1 partition.

### To create a file system in a disk:

```bash
# .exfat is the file system format, /dev/sda1 is the partition of the disk.
sudo mkfs.exfat /dev/sda1
```

### To partition in a disk:

```bash
# enter fdisk interactive mode
sudo fdisk /dev/sda1
```

P.S.: the defaults settings in fdisk is nice. Don't change if not necessary.

### To mount disk to a directory:

```bash
# /dev/sda1 is the disk position and /aruix_storage is the directory
sudo mount /dev/sda1 /aruix_storage
```

### To umount a disk:

```bash
# only disk name is enough
sudo umount /dev/sda1
```

### To mount disk in the start of boot.

Modify the `fstab` file. Syntax:

```
|disk position|mounted postion|type|options|dump|pass
/dev/sda1/    /aruix_storage  exfat defaults,uid=aruix 0   2
```

The `uid` is the owner of all files of this disk. 



dump means backUp?

pass is the mount order for boot.

