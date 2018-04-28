#! /bin/sh

#启动方法
start(){
 now=`date "+%Y%m%d%H%M%S"`

 mkdir -p ~/.workday
 mkdir -p ~/log/

 nohup java -Xms256m -Xmx2048m -jar ./target/workday-1.0-SNAPSHOT.war > ~/log/workday.log  2>&1 &
 echo $! > ~/.workday/workday.pid

 tail -f ~/log/workday.log
}
#停止方法
stop(){
 kill -9 `cat ~/.workday/workday.pid`
}

case "$1" in
start)
start
;;
stop)
stop
;;
restart)
stop
start
;;
*)
printf 'Usage: %s {start|stop|restart}\n' "$prog"
exit 1
;;
esac