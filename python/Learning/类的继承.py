"""python 的继承和多继承
   python3 多继承无论是旧式继承或是新式继承，都是采用广度优先
"""


"""所属类"""
class Base(object):
    def show(self):
        print("这是base类")


class Animal(Base):
    # def show(self):
    #     print("这是动物类")
    pass

class Monkey(Animal):
    # def show(self):
    #     print("这是猴子类")
    pass

class Person(Monkey):
    # def show(self):
    #     print("这是人类")
    pass

"""科目类"""
class Nutural(Base):
    def show(self):
        print("这是自然科学")

class Physics(Nutural):
    def show(self):
        print("这是物理学")

class Mechanics(Physics):
    # def show(self):
    #     print("这是力学")
    pass



class Dashabi(Person, Mechanics):
    pass 

sb = Dashabi()

print(Base)

print(type(Base))
print(object)
print(type(sb))