# AI 学习
- 来源：https://www.bilibili.com/video/BV1Ue4y1q7nU?p=1&vd_source=d6bcbd2fac9e9b84fc22095c62ddbe80
- python以二进制安装包：pip wheel Pillow


## Jupter学习
- 安装jupyter notebook：pip install notebook==6(因为7.x版本不再支持安装扩展)
- 启动jupyter：jupyter notebook
- 安装numpy和matplotlib包：pip install numpy matplotlib 
- 安装Pillow：pip install Pillow
- pip查看安装的包的版本：pip show [包名]

- 设置环境变量：set LC_ALL=zh_CN.UTF-8 && set LANG=zh_CN.UTF-8
- 扩展notebook：pip install jupyter_contrib_nbextensions autopep8
- 启动扩展：jupyter contrib nbextension install --user
  

## Matplotlib学习
- 简单配置(以便处理中文字符和一些特殊字符)：创建文件.matplotlibrc

### matplot显示中文
- Linux环境（ubuntu）
- 到网上下载字体，随便收一种字体，比如微软雅黑：Microsoft YaHei
- 下载好之后复制到/usr/share/fonts，可能不同的发行版有所差异，需自己去搜索
- 然后使用命令:import matplotlib, print(matplotlib.matplotlib_fname())打印出matplotlib的配置文件所在的路径
- 加入该如今并修改配置文件
  ```python
    ....
    font.family: sans-serif
    font.sans-serif:....
    ....
    取消这两行的注释，并在font.sans-serif后加上下载的字体每次，注意大小写
  ```
- 修改配置文件好像无效
- 需要在每个文件的开头加上如下代码
  ```python
    import matplotlib as mpl 
    mpl.rcParams["font.sans-serif"] = ["Arial Unicode MS"]      # Arial Unicode MS 换成自己下载的字体的名称
    mpl.rcParams["axes.unicode_minus"] = False
  ```