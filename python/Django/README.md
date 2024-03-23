# Django 学习笔记
来源：Django官方网站，学习例子：开发一个简单的投票程序

- Path()参数：
四个参数：route, view(两个必须参数), kwargs和name(可选参数)
    - route：route 是一个匹配 URL 的准则（类似正则表达式）。当 Django 响应一个请求时，它会从 urlpatterns 的第一项开始，按顺序依次匹配列表中的项，直到找到匹配的项。这些准则不会匹配 GET 和 POST 参数或域名。例如，URLconf 在处理请求 https://www.example.com/myapp/ 时，它会尝试匹配 myapp/ 。处理请求 https://www.example.com/myapp/?page=3 时，也只会尝试匹配 myapp/。
    - view：当 Django 找到了一个匹配的准则，就会调用这个特定的视图函数，并传入一个 HttpRequest 对象作为第一个参数，被“捕获”的参数以关键字参数的形式传入。稍后，我们会给出一个例子。
    - kwargs：任意个关键字参数可以作为一个字典传递给目标视图函数。本教程中不会使用这一特性。
    - name：为你的 URL 取名能使你在 Django 的任意地方唯一地引用它，尤其是在模板中。这个有用的特性允许你只改一个文件就能全局地修改某个 URL 模式。


# Django 学习笔记
项目来源：书籍： 《python 从入门到实践》 Part II: 项目3 Web应用程序
## 第 18 章 Django 入门
### 18.1 建立项目
#### 18.1.1 制定规范，编写文档，描述项目的目的
......学习笔记网站......
#### 18.1.2 建立虚拟环境
- 创建目录learning_log
- 搭建虚拟环境，建立项目文件依赖项，命令： python -m venv ll_env   
该命令运行了模块 venv，使用其创建一个名为ll_env的虚拟环境
- 激活虚拟环境：source ll_env/bin/activate(linux 环境) ll_env\Scripts\activate(windows 环境)
- 若要停止该环境，使用命令：deactivate

#### 18.1.5 安装Django
- 命令： pip install Django

#### 18.1.6 在Django中创建项目
- 在处于活动的虚拟环境下（ll_env包含在括号内），执行如下命令创建项目
    - django-admin startproject learning_log . (最后的句号让新项目使用合适的目录结构)  
    注意：如果没加句号，部署时就会遭遇一些配置问题，需将创建的文件删除（除ll——env文件），再重新运行该命令
    - 文件settings.py指定Django如何与你的系统交互以及如何管理项目。在开发项目的过程中，我们将修改其中一些设置，并添加一些设置。文件urls.py告诉Django应创建哪些网页来响应浏览器请求。文件wsgi.py帮助Django提供它创建的文件，这个文件名是web server gateway interface（Web服务器网关接口）的首字母缩写。

#### 18.1.7 创建数据库
- 创建数据库：python manage.py migrate  
Django又创建了一个文件——db.sqlite3。SQLite是一种使用单个文件的数据库，是编写简单应用程序的理想选择，因为它让你不用太关注数据库管理的问题。

#### 18.1.8 查看项目
- 命令：python manage.py runserver (执行结果如下) (该命令将启动Django服务器)
```python
Watching for file changes with StatReloader
Performing system checks...

System check identified no issues (0 silenced).
March 17, 2024 - 22:22:57
Django version 5.0.3, using settings 'learning_log.settings'
Starting development server at http://127.0.0.1:8000/
Quit the server with CTRL-BREAK.
```
- URL http://127.0.0.1:8000/表明项目将在你的计算机（即localhost）的端口8000上侦听请求  
localhost是一种只处理当前系统发出的请求，而不允许其他任何人查看你正在开发的网页的服务器。

### 18.2 创建应用程序
- 命令：python manage.py startapp learning_logs  
该命令会新增一些文件，models.py, admin.py和view.py。models.py来定义我们要在应用程序中管理的数据。

#### 18.2.1 定义模型
在model.py中定义与用户相关的数据，以便后续使用  
- 打开models.py， 添加内容 

#### 18.2.2 激活模型
- 打开setting.py文件，在INSTALLED_APPS元组中添加条目：learning_log(当前项目名称)
- 让Django修改数据库，使其能够存储与模型Topic相关的信息。命令：python manage.py makemigrations learning_logs  
    - 命令makemigration确定如何让Django修改数据库。执行该命令将会生成一个名为0001_initial.py的迁移文件，这个文件将在数据库中为模型Topic创建一个表
- 修改数据库：python manage.py migrate

#### 18.2.3 Django管理网站
##### 1 创建超级用户
- 命令：python manage.py createsuperuser(输入该命令将会出现以下信息)，按提示输入即可
```python
(ll_env)learning_log$ python manage.py createsuperuser
Username (leave blank to use 'ehmatthes'): ll_admin ❶
Email address: ❷
Password: ❸
Password (again):
Superuser created successfully.
(ll_env)learning_log$
```

##### 2 向管理网站注册模型
- 打开文件admin.py
- 输入以下信息，
```python
from learning_logs.models import Topic

admin.site.register(Topic)
```

#### 18.2.4 定义模型Entry
要记录学到的国际象棋和攀岩知识，需要为用户可在学习笔记中添加的条目定义模型。每个条目都与特定主题相关联，这种关系被称为多对一关系，即多个条目可关联到同一个主题。
```python
class Entry(models.Model):
    """学到的有关某个主题的具体知识"""
    topic = models.ForeignKey(Topic,on_delete=models.CASCADE)
    text = models.TextField()
    date_added = models.DateTimeField(auto_now_add=True)

    class Meta:
        verbose_name_plural = 'entries'
    
    def __str__(self):
        """返回模型的字符串表示"""

        return self.text[:50] + "..."
```
像Topic一样，Entry也继承了Django基类Model（见❶）。第一个属性topic是一个ForeignKey实例（见❷）。外键是一个数据库术
语，它引用了数据库中的另一条记录；这些代码将每个条目关联到特定的主题。每个主题创建时，都给它分配了一个键（或ID）。需要在两项数据之间建立联系时，Django使用与每项信息相关联的键。稍后我们将根据这些联系获取与特定主题相关联的所有条目。接下来是属性text，它是一个TextField实例（见❸）。这种字段不需要长度限制，因为我们不想限制条目的长度。属性date_added让我们能够按创建顺序呈现条目，并在每个条目旁边放置时间戳。在❹处，我们在Entry类中嵌套了Meta类。Meta存储用于管理模型的额外信息，在这里，它让我们能够设置一个特殊属性，让Django在需要时使用Entries来表示多个条目。如果没有这个类， Django将使用Entrys来表示多个条目。最后，方法__str__()告诉Django，呈现条目时应显示哪些信息。由于条目包含的文本可能很长，我们让Django只显示text的前50个字符（见❺）。我们还添加了一个省略
号，指出显示的并非整个条目。

- **ForeignKey()**外键函数，是一个数据库术语，引用数据库中的另一条记录，在这里的作用是将每个条目关联到特定的主题上
- **Meta**用于管理模型的额外信息，在这里，它能让我们设置一个特殊属性，让django需要时使用Entries来表示多个条目
- 如果没有**Meta**类，django将使用Entrys来表示多个条目
- 最后记住需要迁移Entry模型

#### 18.2.5 迁移模型Entry
- 修改模型models.py之后，需要再次迁移数据库。
- 执行命令：python manage.py makemigrations app_name
- 然后执行命令：python manage.py migrate

#### 18.2.6 向网站注册Entry
- 修改文件admin.py

#### 18.2.7 Django shell
- 交互式会话，命令：python manage.py shell(打开python交互式界面)
```python
>>> from learning_logs.models import Topic
>>> Topic.objects.all()  #获取模型Topic的所以实例，返回一个列表，称为查询集(queryset)
[, ]
>>> topics = Topic.objects.all()
>>> topics[0].id        # id返回主题的编号
1
>>> t = Topic.objects.get(id=1)
>>> t.entry_set.all()   # 返回与该主题有关的所有条目
```
- 通过外键关系获取数据，可以使用相关模型的**小写名称**、**下划线**和**单词set**。


### 18.3 创建网页：学习笔记主页
#### 18.3.1 映射URL
- 定义URL、编写视图、编写模板
- 打开文件urls.py
这行代码包含实参**namespace**，让我们能够将learning_logs的
URL同项目中的其他URL区分开来，这在项目开始扩展时很有帮助。
#### 18.3.2 编写视图
- 修改learning_logs文件夹下的views.py文件
```python
from django.shortcuts import render

# Create your views here.
def index(request):
    """用于主页的视窗函数"""
    return render(request, 'learning_logs/index.html')

```
- render()函数提供数据渲染响应， 其接收两个参数
    - 原始对象
    - 一个可用于创建网页的模板
- request: 简单来说，当一个页面被请求时，Django就会创建一个包含本次请求的元信息的HttpResponse对象(请求报文中的请求行、首部信息，内容主体等)。Django会将这个对象自动传递给响应的**视图函数**，一般视图函数**约定俗成**的使用**request**参数承接这个对象。

#### 18.3.3 编写模板
- 每当网页被请求时，django将填入相关数据。模板让我们能够看到视图提供的任何数据
- 在learning_logs中新建一个文件夹，命名为templates，再在该文件夹中新建一个文件夹，命名为learning_logs，在该文件中编写模板
- 在templates目录下的learning_logs文件夹中创建文件index.html，编写模板
```html
<p>Learning Log</p>
<p>Learning Log helps you keep track of your learning, for any
topic you're
learning about.</p>
```
- 为什么要新建文件夹:templates/learning_logs。该行为建立了django能够明确解读的结构，即便项目很大也如此。


### 18.4 创建其他网页
- 创建两个显示数据的网页：
    - 1.列出所以主题
    - 2.显示特定主题的所有条目
- 对于每个网页，我们都将指定URL模式，编写一个视图函数，编写一个模板
- 先创建一个父模板，项目中的其他模板都继承它

#### 18.4.1 模板继承
- 创建一个名为base.html的模板（父模板），将其存储在index.html所在的目录
```html
<p>
    <a href="{% url 'learning_logs:index' %}">Learning Log</a>
</p>

{% block content %} {% endblock content %}

```
- {% %} 表示模板标签，模板标签是一小段代码，生成网页中要显示的信息
    - 模板标签{% url 'learning_logs:index' %}生成一个URL，该URL与learning_logs/urls.py中定义的名为index的URL模式匹配

- 在简单的HTML页面中，链接是使用**锚**标签定义的：<a href="link_url">link text</a>
- 最后，我们插入了一对块标签。这个块名为content，是一个占位符，其中包含的信息将由子模板指定。

- 创建子模版
```html
{% extends "learning_logs/base.html" %}

{% block content %}

<p>Learning Log helps you keep track of your learning, for any topic you're learning about. </p>

{% endblock content %}

```
- 子模版的第一行必须包含标签{% extends %}，让Django知道它继承了哪个父模板
- 注意：
在大型项目中，通常有一个用于整个网站的父模板——base.html，且网站的每个主要部分都有一个父模板。每个部分的
父模板都继承base.html，而网站的每个网页都继承相应部分的父模板。这让你能够轻松地修改整个网站的外观、网站任何一部分的外观以及任何一个网页的外观。这种配置提供了一种效率极高的工作方式，让你乐意不断地去改进网站。
- 注：**创建base.html模板时，要想其正常运行，需要在项目的urls.py文件中设置好应用程序的路径，如下所示:
```python
from django.contrib import admin
from django.urls import path, include 

from learning_logs import urls as ll_url
urlpatterns = [
    path('admin/', admin.site.urls),
    path('learning_logs/', include((ll_url, 'learning_logs'), namespace='learning_logs')),
]
```
- 导入应用程序的urls作为ll_url
- 修改路径，其中namespace一定要有，不然会报错


#### 18.4.2 显示所有的主题的页面
- 目标：显示全部主题的网页、显示特定主题中的条目的网页

1. 编辑URL：在应用程序的urls.py文件中添加用于显示所有主题的网页的URL
```python
path("topics/", views.topics, name='topics'),
```

- 2. 视图
需要在文件views中添加函数topics
```python
def topics(request):
    """显示所有的主题"""
    topics = Topic.objects.order_by('date_added') # 查询数据库，请求提供Topics对象。并按属性date_added对其进行排序
    context = {'topics': topics}                  # 将要发送给模板的上下文

    return render(request, 'learning_logs/topics.html', context)
```
- 从应用程序的models模块中引入Topic
- 视窗函数接收Topic，并以时间戳进行排序
- 最后调用render()函数将数据返回带topics模板中

- 3. 模板
显示所有主题的页面的模板接受字典context，以便能够使用topics()提供的数据
```html
{% extends "learning_logs/base.html" %}

{% block content %}
    <p>Topics</p>

    <ul>        
        {% for topic in topics %}
            <li>{{ topic}}</li>
        {% empty %}
            <li>No topics have been added yet.</li>
        {% endfor %}
    </ul>

{% endblock content %}

```
<ul></ul>表示无序列表，在标准的HTML中，项目列表被称为无序列表，包好所有主题的项目列表开始于此处。每次循环，{{ topic }}都被替换为topic的当前值。这些花括号不会出现在网页中，它们只是用于告诉Django我们使用了一个模板变量。HTML标签<li></li>表示一个项目列表项，在标签对<ul></ul>内部，位于标签<li>和</li>之间的内容都是一个项目列表项。

#### 18.4.3 显示特定主题的网页
- 目标：显示特定主题的名称以及该主题的所有条目
- 步骤：定义URL、编写视图、编写模板

1. URL模式
```python
path("topics/(?P<topic_id>\d+)/$", views.topic, name='topic'),

```
- (?P<topic_id>\d+)/$正则表达式匹配一个整数， 即topic的ID，并将匹配到的ID存入topic_id变量，随后将其传入topic()函数

2. 视窗函数
```python
def topic(request, topic_id):
    """显示单个主题及其包含的条目"""
    topic = Topic.objects.get(id=topic_id)
    entries = topic.entry_set.order_by('-date_added')
    context = {'topic': topic, 'entries': entries}
    return render(request, 'learning_logs/topic.html', context)
```
- -date_added中的-号将得到的条目按时间戳降序排序，即先显示最近的条目


## 第 19 章 用户账户
- 描述：Web应用程序的核心是让任何用户都能够注册账户并能够使用它
- 目标（在非管理页面下）:
    - 添加主题Topic
    - 添加条目Entry
    - 编辑条目Entry
    - 实现一个用户身份验证系统
        - 用户登录
        - 用户注销
        - 用户注册
    - 修改视图函数，让用户只能看到自己的数据
    

### 19.1 让用户能够输入数据
#### 19.1.1 添加新主题
- 步骤：定义URL、编写视图函数、编写模板
- 注意：**这里的页面是基于表单(form)的页面，因此在此之前我们需要导入包好表单的模块form.py**

1. 用于添加主题的表单
- 描述： 让用户输入并提交信息的页面都是表单
- 安全： 用户输入信息时，我们需要进行验证，以防用户输入恶意代码
- 保存： 在确保输入的信息安全之后，对信息进行有效处理，然后将其保存到数据库
- 创建： 创建表单的最简单的办法是使用ModelForm模块，他根据我们在models.py中定义的模型的信息自动创建表单
- 实例： 在model.py所在的目录创建一个form.py文件

```python
from django import forms

from .models import Topic

class TopicForm(forms.ModelForm):
    class Meta:
        model = Topic           # 根据模型Topic创建表单
        field = {'text'}        # 表单中只包含text字段
        labels = {'text': ''}   # 不要为字段text生成标签
```

2. URL模式，new_topic
```python
path("new_topics/", views.new_topic, name='new_topic'),         # 用于添加新主题的网页
```

3. 视图函数new_topic()
```python
def new_topic(request):
    """添加新主题"""
    if request.method != 'POST':
        """未提交数据，创建一个新表单"""
        form = TopicForm()
    else:
        # POST提交的数据，对数据进行处理
        form = TopicForm(request.POST)
        if form.is_valid():
            form.save()
            return HttpResponseRedirect(reverse('learning_logs:topics'))
    context = {'form': form}
    return render(request, 'learning_logs/new_topic.html')
```
4. GET和POST请求

- request包含两种方法： GET和POST
    - request:          一种对象，包含了从网页请求到的元数据
    - GET:              只从服务器读取的页面请求
    - POST:             用户通过表单提交信息
    - 指定的POST请求：   处理所有表单

5. 模板new_topic
- 创建新模板new_topic.html
- 注意缩进
```html
{% extends 'learning_logs/base.html' %}

{% block content %}

    <p>Add a new topic:</p>

    <form action="{% url 'learning_logs:new_topic' %}" method="post">
        {% csrf_token %}
        {{form.as_p}}
        <button name="submit">add topic</button>
    </form>

{% endblock content %}

```

#### 19.1.2 添加新条目

1. 用于添加新条目的表单
```python
class EntryForm(forms.ModelForm):
    class Meta:
        model = Entry
        fileds = {'text'}
        labels = {'text': ''}
        widgets = {'text': forms.Textarea(attrs={'cols: 100'})}
```
- widgets用来设置输入框的列宽为100列（默认40列）
- 其他字段与TopicForm一样

2. URL模式new_entry
```python
path("new_entry/(?P<topic_id>\d+)/$", views.new_entry, name='new_entry'), # 用于添加新条目
```
- 其中(?P<topic_id>\d+)/$将与某个主题的ID匹配

3. 视图函数new_entry()
```python
def new_entry(request, topic_id):
    """在特定的主题中添加新条目"""
    topic = Topic.objects.get(id=topic_id)
    if request.method != 'POST':
        form = EntryForm()
    else:
        form = EntryForm(data=request.POST)
        if form.is_valid():
            new_entry = form.save(commit=False)
            new_entry.topic = topic
            new_entry.save()
            return HttpResponseRedirect(reverse('learning_logs:topic', args=[topic_id]))
    context = {'form': form}
    return render(request, 'learning_logs/new_entry.html', context)

```
- 该视图函数需要传入参数topic_id，即为特定主题的ID号，将在该主题下添加新的条目
- new_entry = form.save(commit=False)， save()函数传递了实参commit=False，
    - Django创建了一个新的条目对象，并将其存储到new_entry中
    - 但不保存到数据库，之后的new_entry.save()才将该条目保存到数据库， 并将其与正确的主题相关联

4. 模板new_entry
```html
{% extends "learning_logs/base.html" %}

{% block content %}

    <p><a href="{% url 'learing_logs:topic' topic.id}">{{topic}}</a></p>

    <p>Add a new entry:</p>
    <form action="{% url 'learning_logs:new_entry' topic.id %}" method="post">
        {% csrf_token %}
        {{form.as_p}}
        <button name="submit">add entry</button>

    </form>

{% endblock content %}
```
- 模板格式一定要注意，url一定要正确填写

#### 19.1.3 编辑条目
- 步骤：三部曲

1. URL
path("edit_entry/(?P<entry_id>\d+)/$", views.edit_entry, name='edit_entry'), # 用于编辑条目
- 注意，这里的匹配参数是entry_id

2. 视图函数
```python
def edit_entry(request, entry_id):
    """对特定的主题的特定条目进行编辑"""
    entry = Entry.objects.get(id=entry_id)
    topic = entry.topic
    if request.method != 'POST':
        form = EntryForm()
    else:
        form = EntryForm(instance=entry, data=request.POST)
        if form.is_valid():
            form.save()
            return HttpResponseRedirect(reverse('learning_logs:topic', args=[topic.id]))
    context = {'entry': entry, 'topic': topic, 'form': form}
    return render(request, 'learning_logs/edit_entry.html', context)
```

- form = EntryForm(instance=entry, data=request.POST)
    - instance=entry创建一个EntryForm的实例。这个参数让django创建一个表单，并使用既有条目对象的信息填充它
    - 用户将能够看到既有的数据，并能够编辑他们

3. 模板
```html
{% extends "learning_logs/base.html" %}

{% block content %}

    <p><a href="{% url 'learning_logs:topic' topic.id}">{{topic}}</a></p>

    <p>Edit entry:</p>

    <form action="{% url 'learning_logs:edit_entry' entry.id %}" method="post">
        {% csrf_token %}
        {{form.as_p}}
        <button name="submit">save changes</button>
    </form>
    
{% endblock content %}   

```
- 注意： learning_logs:edit_entry 冒号后不能有空格，不然会发生错误


### 19.2 创建用户账户
- 目标：建立一个用户注册的身份验证系统
    - 用户登录
    - 用户注销
    - 用户注册

#### 19.2.1 应用程序users
1. 创建应用程序

- 在终端键入命令：python manage.py users
    - 创建管理用户的应用程序
    - 将其添加到项目的settings.py文件中

2. 将users应用程序的URL填入下面的urls.py文件中
- path('users/', include((users_url, 'users'), namespace='users'))

#### 19.2.2 登录页面
- 目标：实现登录页面的功能
- 步骤：三部曲-->定义URL、编辑视图、编辑模板
```python
from django.urls import path
from django.contrib.auth.views import LoginView

from . import views
urlpatterns = [

    # 登录页面
    path('login/', LoginView.as_view(template='users/login.html'), name='login'),

]
```
- 这里使用django的默认登录视图LoginView
    - 实参template='users/login.html'将告诉django去什么地方找登录模板

1. 模板login.html
- 用户请求登录时，django使用其默认的视图，但我们需为该视图提供模板
- 创建模板，方法和之前在learning_logs中一样
    - 在users/目录下创建文件夹templates
    - 在文件夹templates/下创建users文件夹

```html
{% extends "learning_logs/base.html" %}

{% block content %}

    {% if form.error %}
        <p>Your username and password didn't match. Please try again.</p>
    {% endfor %}

    <form method="post" action="{% url 'users:login' %}">
        {% csrf_token %}
        {{form.as_p}}
        <button name="submit">log in</button> 
        <input type="hidden" name="next" value="{% url 'learning_logs:index' %}" />
    </form>
{% endblock content %}
```

2. 链接到登录页面
- 目标：
    - 在base.html中添加到登录页面的链接，让所有页面都包含它
    - 但在用户已经登录，不显示登录链接

```html
<p>
    <a href="{% url 'learning_logs:index' %}">Learning Log</a> -
    <a href="{% url 'learning_logs:topics' %}">Topics</a>
    {% if user.is_authenticated %}
        Hello, {{user.username}}
    {% else %}
        <a href="{% url 'users:login' %}">log in</a>
    {% endif %}
</p>

{% block content %} {% endblock content %}

```
- 在django身份验证中，，每个模板都可以使用变量user
- 该变量有is_authenticated属性，如果用户已登录，该属性为true，否则为false

#### 19.2.3 注销
- 模板：在base页面添加一个注销的链接

1. 注销URL
- path('logout/', views.logout_view, name='logout'),
- 该URL模式将请求发送给函数**logout_view**

2. 视图函数logout_view()
```python
from django.shortcuts import render
from django.http import HttpResponseRedirect
from django.contrib.auth import logout
from django.urls import reverse


# Create your views here.
def logout_view(request):
    """注销用户"""
    logout(request)
    return HttpResponseRedirect(reverse('learning_logs:index'))
```
- 这里用到了django的注销函数logout()
- 当用户注销后，返回主页面

3. 链接到注销视图
- 在base页面中添加
- 我们将它放在标签{% if user.is_authenticated %}中，使得仅当用户登录后才能看到它

#### 19.2.4 注册页面
- 目标：利用django提供的表单UserCreationForm，编写自己的视图函数和模板

1. 注册页面的URL模式
- path('register/', views.register, name='register')

2. 视图函数register()
```python
def register(request):
    """用户注册"""
    if request != 'POST':
        form = UserCreationForm()
    else:
        form = UserCreationForm(data=request.POST)
        if form.is_valid():
            new_user = form.save()
            # 让用户自动登录，再重定向到主页
            authenticated_user = authenticate(username=new_user.username, password=request.POST['password1'])
            login(request, authenticated_user)
            return HttpResponseRedirect(reverse('learning_logs:index'))
    context = {'form': form}
    return render(request, 'users/register.html', context)

```
- 保存好信息后，我们让用户自动登录
    - 调用authenticate()，将用户名和密码传递给该函数
        - 如果用户名和密码无误，方法authenticate()将返回一个通过身份验证的对象
    - 然后调用login()函数，将request和authenticate()返回的对象传递给该函数
    - 最后重定向到主页面

3. 注册模板
```html
{% extends "learning_logs/base.html" %}

{% block content %}

    <form method="post" action="{% url 'users:register' %}">
        {% csrf_token %}
        {{form.as_p}}
        <button name="submit">register</button>
        <input type="hidden" name="next" value="{% url 'learning_logs:index' %}" />
    </form>
{% endblock content %}

```

4. 链接到注册页面


### 19.3 让用户拥有自己的数据
- 目标： 限制用户对页面的访问， 用户只能访问属于自己的数据

#### 19.3.1 使用@login_required限制访问
- 装饰器(ddecorator)放在函数定义的前面指令，Python在函数运行前，根据它来修改函数代码的行为
```python
@login_required
def topics(request):
    """用于显示所有主题的视窗函数"""
    topics = Topic.objects.order_by('date_added')
    context = {'topics': topics}
    return render(request, 'learning_logs/topics.html', context)
```
- login_required()的代码检查用户是否已登录，仅当用户已登录时，Django才运行topics()的代码。
- 如果用户未登录，就重定向到登录页面。
- 为实现这种重定向，我们需要修改settings.py，让Django知道到哪里去查找登录页面。

- setting.py 文件
```python

# 我的设置
LOGIN_URL = '/users/login/'

```
- 现在，如果未登录的用户请求装饰器@login_required的保护页面，Django将重定向到settings.py中的LOGIN_URL指定的URL。

2. 全面限制对项目“学习笔记”的访问
- 在learning_logs/views中，除index()外对其他函数都加上装饰器以作限制 

#### 19.3.2 将数据关联到用户

- 目标：将数据关联到提交他们的用户，只需将最高层的数据关联到用户，低层的数据自动会关联到相应的用户
- 步骤：
    - 修改Topic模型，在其中添加一个关联到用户的外键
    - 修改model.py文件之后，必须迁移数据库
    - 最后对某些视图进行修改，使其只显示与当前登录的用户相关的数据

1. 修改模型Topic
- 通过外键建立模型与用户关系: owner = models.ForeignKey(User)

2. 确定当前有哪些用户
我们迁移数据库时，Django将对数据库进行修改，使其能够存储主题和用户之间的关联。为执行迁移，Django需要知道该将各个既有主题
关联到哪个用户。最简单的办法是，将既有主题都关联到同一个用户，如超级用户。为此，我们需要知道该用户的ID。
输入一系列命令即可：
- python manage.py makemigrations laerning_logs  (准备迁移数据库)
    - 出现选项，这里选择1选项，并设置默认值为1，即ID为1的用户
- python manage.py miigrate  (迁移数据)
- 最后可以进入交互式界面进行验证

#### 19.3.3 只允许用户访问自己的主题
- 目标：只向用户显示自己的主题
```python
@login_required
def topics(request):
    """用于显示所有主题的视窗函数"""
    topics = Topic.objects.filter(owner=request.user).order_by('date_added')
    context = {'topics': topics}
    return render(request, 'learning_logs/topics.html', context)
```
- 用户登录后，request对象将有一个user属性，这个属性存储了有关该用户的信息
- Topic.objects.filter(owner=request.user)让Django只从数据库中获取owner属性为当前用户的Topic对象。


#### 19.3.4 保护用户的主题
- 描述：
以拥有所有主题的用户的身份登录，访问特定的主题，并复制该页面的URL，或将其中的ID记录下来。然后，注销并以另一个用户的身份登录，再输入显示前述主题的页面的URL。虽然你是以另一个用户登录的，但依然能够查看该主题中的条目。
- 目标：修复该问题
```python
@login_required
def topic(request, topic_id):
    """显示单个主题及其包含的条目"""
    topic = Topic.objects.get(id=topic_id)
    if topic.owner != request.user:
        raise Http404               # 如果请求的用户和主题的用户不匹配，引发异常
    entries = topic.entry_set.order_by('-date_added')
    context = {'topic': topic, 'entries': entries}
    return render(request, 'learning_logs/topic.html', context)
```

#### 19.3.5 保护页面edit_entry
- 方法如上

#### 19.3.6 将新主题关联到当前用户
- 描述：
当前，用于添加新主题的页面存在问题，因此它没有将新主题关联到特定用户。如果你尝试添加新主题，将看到错误消息IntegrityError，指出learning_logs_topic.user_id不能为NULL。Django的意思是说，创建新主题时，你必须指定其owner字段的值。
```python
@login_required
def new_topic(request):
    """添加新主题"""
    if request.method != 'POST':
        """未提交数据，创建一个新表单"""
        form = TopicForm()
    else:
        # POST提交的数据，对数据进行处理
        form = TopicForm(request.POST)
        if form.is_valid():
            new_topic = form.save(commit=False)     # 不保存到数据库
            new_topic.owner = request.owner         # 设置主题的owner属性
            new_topic.save()                        # 保存到数据库
            return HttpResponseRedirect(reverse('learning_logs:topics'))
    context = {'form': form}
    return render(request, 'learning_logs/new_topic.html', context)

```

## 第 20 章 设置应用程序的样式并对其进行部署
- 目标：将项目部署到服务器上， 让其他人也能建立账户
- 工具：Bootstrap库
这是一组工具，用于为Web应用程序设置样式，使其在任何现代设备上都看起来很专业，无论是大型的平板显示器还是智能手机。为此，我们将使用应用程序django-bootstrap3，这也让你能够练习使用其他Django开发人员开发的应用程序。

### 20.1 设置项目“学习笔记”的样式
#### 20.1.1 应用程序django-bootstrap3
- 命令：pip install django-bootstrap3
- 将该应用程序添加到setting.py中
- 对该应用程序进行设置(在setting.py中)
```python172.31.146.23
BOOTSTRAP3 = {
    'include_jquery': True,
}
```
- 该设置无需手工下载jQuery并将其放到正确的地方
- 这一小节参照书即可(p598)，主要是一些有关html的语法


### 20.2 部署“学习笔记”
- 注册Heroku账户：https://www.heroku.com/
