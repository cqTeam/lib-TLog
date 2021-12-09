# lib-TLog
日志框架 [![](https://jitpack.io/v/cqTeam/lib-TLog.svg)](https://jitpack.io/#cqTeam/lib-TLog)
## 简介
### 功能
- 日志定位
- 展示该日志调用者的线程信息
- 支持Json字符串格式化

### 配置
1. 在Project的 `build.gradle`中添加 jitpack 地址
```
allprojects {
   repositories {
     ...
     maven { url 'https://jitpack.io' }
   }
}
```
2. 添加依赖
```
dependencies {
    implementation 'com.github.cqTeam:lib-TLog:Tag'
}
```

### 使用
#### 在 Application 中配置
```
// 1. 创建日志配置器 TLogConfig
val tlogConfig = TLogConfig.Builder()
            .isDebug(false) // Debug模式下才打印日志，默认是true；设置为false，就不会打印日志信息
            .formatJson(true) // 是否格式化Json字符串，默认false
            .showThreadInfo(true) // 是否展示线程信息，默认false
            .tag("TLog") // 全局Log的tag
            .setPackageNames("com.cqteam.tlog") // 配置需要定位的类的包名，一般使用AndroidManifest.xml中的package的值即可
            .build()
 // 2. 给日志添加配置
 TLog.addConfig(tlogConfig)
```

#### 调用
```
TLog.i("测试") // 日志的tag为全局配置的tag
TLog.i("测试","allTag") // 日志的tag为 allTag
```

#### 注意
- 如果要进行日志定位，一定要调用`TLogConfig.Builder.setPackageNames`方法，该方法接收可变参数，即
```
setPackageNames("com.cqteam.app","com.cqteam.user","com.cqteam.center")
```

### 日志结果
```
2021-11-01 11:20:12.553 25075-25169/com.cqteam.tlog D/TLog: 日志内容
    ======class======
    com.cqteam.tlog.MainActivity$onCreate$1.run(MainActivity.kt:19)
    com.cqteam.lib.tlog.TLog$Companion.d$default(TLog.kt:34)
    com.cqteam.lib.tlog.TLog$Companion.d(TLog.kt:35)
    com.cqteam.lib.tlog.handle.DefaultTLogHandle.d(DefaultTLogHandle.kt:23)
    com.cqteam.lib.tlog.handle.DefaultTLogHandle.handle(DefaultTLogHandle.kt:37)
    com.cqteam.lib.tlog.claz.ClassUtils.getClass(ClassUtils.kt:22)
    ======Thread======
    name:Thread-2
    id:3427
    priority:5
    groupName:main
    ===========================================================start=======================================================================
    {
        "code": 1,
        "msg": "请求成功",
        "data": {
            "record": {
                "id": 6,
                "uid": 103,
                "task_id": 6,
                "mode": 0,
                "integral": "500.00",
                "receive_time": 1635473988,
                "start_time": 1635473989,
                "finish_time": null,
                "cancel_time": null,
                "transfer_id": "GM2021102910194866028",
                "payment_type": 1,
                "money": 100,
                "order_id": null,
                "orders_id": null,
                "orders_goods_name": null,
                "orders_store_name": null,
                "transfer_time": null,
                "refund_trade_no": null,
                "refund_time": null,
                "comment_time": null,
                "status": 1,
                "create_time": 1635473988,
                "update_time": 1635473989,
                "delete_time": null
            },
            "task": {
                "id": 6,
                "mid": 108,
                "platform": 3,
                "delayed_min_time": 20,
                "delayed_max_time": 20,
                "last_receive_time": 1635474008,
                "receive": 1,
                "type": 4,
                "integral": "500",
                "integral_total": "1500",
                "integral_buyer": "300",
                "search": 1,
                "search_video": 0,
                "goods_keyword": "指甲剪包邮小商品",
                "goods_name": "指甲剪包邮小商品两三元商品四元小商品1到5元小礼物一元包邮韵达",
                "goods_store": "泥土巴巴坚持3店 ",
                "goods_price": "1",
                "goods_deliver": "广州",
                "goods_skus": "发百世 指甲剪1个 好评用-7T4",
                "goods_key": "",
                "goods_qrcode": "",
                "video_userid": "",
                "video_url": "",
                "video_key": "",
                "video_goods_name": "",
                "video_goods_id": "",
                "share_txt": "",
                "peoples": 3,
                "peoples_receive": 5,
                "peoples_start": -3,
                "peoples_completed": 0,
                "peoples_cancel": 8,
                "implement_time": null,
                "implement_device": 0,
                "comment_interval_time": "7",
                "pay_money": "1.00",
                "isComment": 0,
                "comment_txt": "",
                "comment_picture": "",
                "live_type": -1,
                "live_barrage": null,
                "live_praise": 0,
                "browse_time": 90,
                "search_time": 300,
                "comparison": 0,
                "chat_txt": "你好\r\n很不错",
                "overtime": 1500,
                "status": 0,
                "create_time": 1635423453,
                "update_time": 1635473989,
                "delete_time": null
            }
        }
    }
    ============================================================end========================================================================
```
