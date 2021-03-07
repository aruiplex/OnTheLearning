function query(params) {
  // 查数据库
}

// aysnc 就是单开一个线程(类似于一个线程, 其实就是非阻塞的一种表现)
// await 就是表示等待他搞完
async function haha() {
  let a = await query();
  await jixu(a);
}

function jixu(params) {
  // jixu
}
