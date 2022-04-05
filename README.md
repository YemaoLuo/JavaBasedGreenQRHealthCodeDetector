# 基于Java的健康码绿码检测

### 当前版本仅实现澳康码绿码检测

#### 使用方法

1. 将.jar文件Add as library或利用Maven引入工程中
2. new DetectServiceImpl
3. 调用其detect方法并传入File
4. 返回值为Predict对象 包括ClassName以及预测概率

### 通过自行训练torchscript模型可实现更多额外功能

*若使用其他模型可能需要对源代码做出修改*

#### 更多功能开发中...
