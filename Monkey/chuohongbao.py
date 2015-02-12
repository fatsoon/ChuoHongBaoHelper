#coding=utf-8
from com.android.monkeyrunner import MonkeyRunner,MonkeyDevice,MonkeyImage

#等待手机连接
device = MonkeyRunner.waitForConnection()
#运行程序的次数
count = 0
#屏幕宽高
screen_width = 768
screen_height = 1280
#touch点的宽度，可以理解为小红人的宽度
touch_radius = 200
#状态栏+导航栏的高度，纵坐标要从这个下面开始
status_and_action_height = 162

while True:
    count += 1
    #打印循环的次数
    print("count = " + str(count))
    #开始发送指令
    x_running = True
    #横坐标起始位置设为0
    x = 0
    while x_running:
        y_running = True
        #纵坐标起始位置设为状态栏+导航栏的高度
        y = status_and_action_height
        while y_running:
            device.touch(x, y, 'DOWN_AND_UP')
            # MonkeyRunner.sleep(0.2)
            y += touch_radius
            if y > screen_height:
                y_running = False
        x += touch_radius
        if x > screen_width:
            x_running = False
