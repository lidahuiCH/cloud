# Centos 7下使用yum安装redis
https://www.jianshu.com/p/ebda253a8daa

# 安装redis
yum install redis
# 启动redis
systemctl start redis.service
# 设置redis开机启动
systemctl enable redis.service