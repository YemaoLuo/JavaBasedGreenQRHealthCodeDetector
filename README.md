# 基于Java的健康码绿码检测

### 当前版本仅实现澳康码绿码检测

#### 准备工作

1. 将.jar文件Add as library或利用Maven引入工程中
2. 将weights文件夹拷贝至工程目录下(示例代码中weights文件夹存放于resources目录下)

#### 示例代码

```Java
  @Test
    public void testPredict(){
        // 引入DetectServiceImpl类
        DetectService service = new DetectServiceImpl();
        // 准备传入参数
        UtilInputs input = new UtilInputs();
        input.setClassName("QRCode.names");
        input.setModelName("QRCode.torchscript");
        // 获取模型所在目录路径
        input.setPath(Main.class.getResource("/weights").getPath());
        input.setHeight(640);
        input.setWidth(640);
        // 开始预测
        service.detect(null, input);
    }
```
####  工程结构

- project
  - src
    - domain
      - Predict.java
      - UtilInputs.java
      - Bound.java
    - service
      - DetectService
        - impl
          - DetectServiceImpl
    - utils
      - InitializeUtil.java
      - GetBoundUtil.java
  - target
  - weights
    - QRCode.names
    - QRCode.torchscript

### 通过自行训练torchscript模型可实现更多额外功能

*若使用其他模型可能需要对源代码做出修改*

#### 更多功能开发中...
