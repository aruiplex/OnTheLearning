# MongoDB





## 结构

### Database

是和mysql一样的database，是以一个项目为中心来区分的。

### Collection

是表（Table）。



Ckeck all collections.

```
show collections
```



可以显式（Explict）的创建，如果没有明确说，mongodb会按default configuration 创建一个。

```js
db.createCollection(name, options)
```

| Parameter |   Type   |                        Description                        |
| :-------: | :------: | :-------------------------------------------------------: |
|   Name    |  String  |           Name of the collection to be created            |
|  Options  | Document | (Optional) Specify options about memory size and indexing |

|    Field    |  Type   |                         Description                          |
| :---------: | :-----: | :----------------------------------------------------------: |
|   capped    | Boolean | (Optional) If true, enables a capped collection. Capped collection is a fixed size collection that automatically overwrites its oldest entries when it reaches its maximum size. **If you specify true, you need to specify size parameter also.** |
| autoIndexId | Boolean | (Optional) If true, automatically create index on _id field.s Default value is false. |
|    size     | number  | (Optional) Specifies a maximum size in bytes for a capped collection. **If capped is true, then you need to specify this field also.** |
|     max     | number  | (Optional) Specifies the maximum number of documents allowed in the capped collection. |

options are basicly used to limit the document number.

```
> db.createCollection("mycol", { capped : true, autoIndexID : true, size : 6142800, max : 10000 } ){

```



Drop collection from database.

```
db.collection.drop()
```





### Document & Sechme

首先需要明白sechme是什么意思，在mysql里面，sechma和table连在一起分不开，是因为每个table里面的sechma都是一样的，并且不可变的。但是在mongdb里面，是不需要sechme来model的。

在mongodb里，document是一行数据。每一个document是一组key-value pair。

> Data in MongoDB has a flexible schema.documents in the same collection. They do not need to have the same set of fields or structure Common fields in a collection’s documents may hold different types of data.

### 总结

|    RDBMS    |                         MongoDB                          |
| :---------: | :------------------------------------------------------: |
|  Database   |                         Database                         |
|    Table    |                        Collection                        |
|  Tuple/Row  |                         Document                         |
|   column    |                          Field                           |
| Table Join  |                    Embedded Documents                    |
| Primary Key | Primary Key (Default key _id provided by MongoDB itself) |



## Data types

Mongodb use BSON. Therefore, the datatypes in mongodb are also BSON.

| Type                       | Number | Alias                 | Notes                      |
| :------------------------- | :----- | :-------------------- | :------------------------- |
| Double                     | 1      | "double"              |                            |
| String                     | 2      | "string"              |                            |
| Object                     | 3      | "object"              |                            |
| Array                      | 4      | "array"               |                            |
| Binary data                | 5      | "binData"             |                            |
| Undefined                  | 6      | "undefined"           | Deprecated.                |
| ObjectId                   | 7      | "objectId"            |                            |
| Boolean                    | 8      | "bool"                |                            |
| Date                       | 9      | "date"                |                            |
| Null                       | 10     | "null"                |                            |
| Regular Expression         | 11     | "regex"               |                            |
| DBPointer                  | 12     | "dbPointer"           | Deprecated.                |
| JavaScript                 | 13     | "javascript"          |                            |
| Symbol                     | 14     | "symbol"              | Deprecated.                |
| JavaScript code with scope | 15     | "javascriptWithScope" | Deprecated in MongoDB 4.4. |
| 32-bit integer             | 16     | "int"                 |                            |
| Timestamp                  | 17     | "timestamp"           |                            |
| 64-bit integer             | 18     | "long"                |                            |
| Decimal128                 | 19     | "decimal"             | New in version 3.4.        |
| Min key                    | -1     | "minKey"              |                            |
| Max key                    | 127    | "maxKey"              |                            |





## Model

有两种形式，embeded & normalized：

- embeded is document of document
- normalized is split the multiple layer documents apart.





## CRUD

都有相同的句式：`db.collection.operation()`。

1. [`db.collection.insertOne()`](https://docs.mongodb.com/manual/reference/method/db.collection.insertOne/#mongodb-method-db.collection.insertOne)。直接插入一个数据





## Reference

[1] 可以直接用的mongosh：





