

from django.urls import path, include

from . import views

urlpatterns = [

    path("", views.index, name="index"),

    path("topics/", views.topics, name='topics'),
    path("topics/(?P<topic_id>\d+)/$", views.topic, name='topic'),

    # 用于用户添加新主题的网页
    path("new_topic/", views.new_topic, name='new_topic'),          # 当用户需要添加新主题时，切换到new_topic页面

    # 用于添加新条目的页面
    path("new_entry/(?P<topic_id>\d+)/$", views.new_entry, name='new_entry'),

    # 用于编辑条目
    path('edit_entry/(?P<entry_id>\d+)/$', views.edit_entry, name='edit_entry'),
    
]