## Simulation-Framework构建方式
1. 使用Idea导入Simulation-Framework
2. 进入各个Archetype子项目中
3. 分别通过命令行调用`mvn clean archetype:create-from-project`生成Archetype项目的相关文件
4. 切换到各个子项目的`target/generated-sources/archetype/`目录下
5. 分别通过命令行调用`mvn install`对Archetype项目进行打包并在本地的`~/.m2/repository/org/apache/maven/archetype`目录下生成${项目名}-archetype文件夹

## Simulation-Framework使用方式
1. 通过Idea创建新的父子Maven项目，父项目中`packaging`为`pom`，关于Maven父子项目参考[Maven模块聚合和继承](https://blog.csdn.net/liutengteng130/article/details/47001831)
2. 右击父项目选择新增Module
3. 在Maven选项卡中勾选Create From Archetype(如果之前已经添加过对应的Archetype则直接跳至第9步)
4. 点击Add Archetype
5. 填入Archetype项目对应的groupId(默认为org.apache.maven.archetype)
6. 填入对应的artifactId(默认为${项目名}-archetype)
7. 填入对应的version(默认为1.0)
8. 点击确定
9. 使用新创建的Archetype创建项目即可