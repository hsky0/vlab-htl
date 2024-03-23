from django import forms            # 导入模块forms


from .models import Topic, Entry           # 应用程序创建的模型Topic

class TopicForm(forms.ModelForm):   # 定义一个名为TopicForm的类，继承forms.ModelForm
    """创建表单，让用户能够输入新主题"""
    class Meta:                     
        model = Topic               # 告诉django根据根据哪个模型(这里是Topic模型)创建表单，以及表单包含哪些字段
        fields = {'text'}           # 只包含text字段
        labels = {'text': ''}       # 告诉django不要为字段text生成标签


class EntryForm(forms.ModelForm):
    class Meta:
        model = Entry
        fields = {'text'}
        labels = {'text': ''}
        widgets = {'text': forms.Textarea(attrs={'cols': 100})}