# cola
一套简单的可以复制、可以理解、可以落地、可以控制复杂性的”指导和约束"的框架。是一种架构思想，是整合了洋葱圈架构、适配器架构、DDD、整洁架构、TMF 等架构思想的一种应用架构。

本项目主要是基于阿里cola的核心组件cola-core的扩展功能的开发和一些问题修复，详细关于cola的介绍可以参考：https://www.cnblogs.com/yunqishequ/p/13321650.html， 原开源项目地址：https://github.com/alibaba/COLA。

同时也欢迎各位大拿提出自己的想法和好的设计，共同把这个业务应用框架做的更强大，保持项目持续更新的状态。

1.支持同步事件执行器排序，通过注解@Order来标识事件执行器处理顺序
