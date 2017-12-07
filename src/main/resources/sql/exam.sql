/*
SQLyog v10.2 
MySQL - 5.5.25 : Database - db_ssm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_ssm` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_ssm`;

/*Table structure for table `t_error_question` */

DROP TABLE IF EXISTS `t_error_question`;

CREATE TABLE `t_error_question` (
  `id` int(11) DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `time` varchar(150) DEFAULT NULL,
  `erroranswer` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_error_question` */

insert  into `t_error_question`(`id`,`qid`,`uid`,`state`,`num`,`time`,`erroranswer`) values (1,7,1,1,8,'2017年09月27日  02:48:40','C'),(2,8,1,1,8,'2017年09月27日  01:45:34','B'),(3,9,1,1,3,'2017年09月27日  01:13:35','C'),(4,31,1,1,5,'2017年09月27日  01:45:34','C'),(5,12,1,1,3,'2017年09月27日  01:45:34','A'),(6,20,1,1,1,'2017年09月27日  01:13:35','B'),(7,11,1,1,1,'2017年09月27日  01:22:30','C'),(8,40,1,1,1,'2017年09月27日  01:51:47','AC'),(9,43,1,1,1,'2017年09月27日  01:51:47','AB'),(10,46,1,1,1,'2017年09月27日  01:51:47','BC'),(11,7,2,1,1,'2017年09月30日  04:03:32','B'),(12,8,2,1,1,'2017年09月30日  04:03:32','B'),(13,9,2,1,1,'2017年09月30日  04:03:32','A'),(14,11,2,1,1,'2017年09月30日  04:03:32','C'),(15,12,2,1,1,'2017年09月30日  04:03:32','A'),(16,40,3,1,1,'2017年10月01日  08:12:12','ABCD'),(17,46,3,1,1,'2017年10月01日  08:12:12','AV'),(18,40,9,1,1,'2017年10月09日  10:29:32','A');

/*Table structure for table `t_exam_question` */

DROP TABLE IF EXISTS `t_exam_question`;

CREATE TABLE `t_exam_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text COMMENT '题干',
  `_option` text COMMENT '选项/简答题答案',
  `answer` text COMMENT '答案/解析',
  `type` int(11) DEFAULT '1' COMMENT '题型',
  `label` varchar(255) DEFAULT NULL COMMENT '标签',
  `rank` int(11) DEFAULT '1' COMMENT '试题难度 1：初级， 2：中级，3：高级',
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

/*Data for the table `t_exam_question` */

insert  into `t_exam_question`(`id`,`title`,`_option`,`answer`,`type`,`label`,`rank`,`created`) values (54,'(集合框架)下面都属于线程安全的类是( )。','ArrayList,Vector ,HashMap,Hashtable ,','BD',2,'5',1,NULL),(55,'单列集合的顶层接口是','java.util.Map, java.util.Collection,java.util.List ,java.util.Set,','B',1,'2',1,NULL),(56,'ArrayList类的底层数据结构是','数组结构,链表结构,哈希表结构,红黑树结构,','A',1,'5',1,NULL),(57,'LinkedList类的特点是',' 查询快 ,增删快,元素不重复,元素自然排序,','B',1,'3',1,NULL),(58,'Vector类的特点是',' 线程同步,线程不同步,增删快,底层是链表结构,','A',1,'2',1,NULL),(59,'关于迭代器说法错误的是','迭代器是取出集合元素的方式 ,迭代器的hasNext()方法返回值是布尔类型,List集合有特有迭代器,next()方法将返回集合中的上一个元素,','D',1,'1',1,NULL),(60,'实现下列哪个接口，可以启用比较功能','Runnable接口,Iterator接口,Serializable接口,Comparator接口,','D',1,'4',1,NULL),(61,'在我们所学知识中，下面哪几项是接口','java.util.Map,java.util.Collection, java.util.List,java.util.Set ,','ABCD',2,'3',1,NULL),(62,'按照课堂要求重写equals和hashCode后，下面关于这两个方法说法正确的是','两个对象的hashCode值相同，那么他们调用equals()方法返回值一定为true, 两个对象的hashCode值相同，那么他们调用equals()方法返回值可以为false,hashCode值一般与对象的成员变量有关 , 只要重写equals方法，就一定要重写hashCode方法,','BC',2,'6',1,NULL),(63,'下面有关java的一些细节问题，错误的是','构造方法不需要同步,一个子类不需要覆盖掉父类的同步方法,定义在接口中的方法默认是品public的,容器保存的是对象的引用,','B',1,'3',1,NULL),(64,'下面代码运行的结果是 ArrayList<String> al = new ArrayList<String>(); al.add(true); al.add(123); al.add(“abc”);  System.out.println(al);',' 编译失败, [true,123],[true,123,abc],[abc],','A',1,'1',1,NULL),(65,'将Map集合中的键存储到Set集合的方法是','entrySet() ,get(),keySet(),put(),','C',1,'3',1,NULL),(66,'使用TreeSet的无参构造创建集合对象存储元素时，该元素必须','实现Comparable接口,有main方法,有get和set方法,实现Serializable接口,','A',1,'3',1,NULL),(67,'下列语句正确的是','形式参数可被字段修饰符修饰,形式参数不可以是对象,形式参数为方法被调用时真正被传递的参数,形式参数可被视为local variable,','D',1,'1',1,NULL),(68,'关于将int数组使用系统提供的API转成集合后，不可以进行的操作是',' 增加集合中的元素, 迭代集合, 修改集合中的元素,获取集合中元素的个数,','A',1,'2',1,NULL),(69,'关于HashMap集合说法正确的是','HashMap集合是双列集合,HashMap集合不允许存储重复键,HashMap集合不允许存储重复值,HashMap集合线程是安全的 ,','AB',2,'3',1,NULL),(73,'Spring框架中的核心思想包括','依赖注入,控制反转,面向对象,面向切面,','ABD',3,'1,3',1,NULL),(76,'下面那一项不是java类访问控制关键字','public,this,private,','B',1,'3',1,NULL),(77,'下面关于HashMap和Hashtable的区别，说法正确的是',' Hashtable线程不安全，效率高 ,HashMap线程安全，效率低, HashMap允许null键和值,Hashtable不允许null键和值,','CD',3,'1',1,NULL),(78,'将集合转成数组的方法是','asList(),toCharArray(),toArray() , copy(),','C',1,'5',1,NULL),(79,'下列哪些语句关于java内存回收的说明是正确的？','程序员必须创建一个线程来释放内存,内存回收程序员负责释放无用内存,内存回收程序允许程序员直接释放内存,内存回收程序可以在指定得我时间释放内存对象,','B',1,'1',1,NULL),(80,'Collections工具类中的binarySearch()方法描述正确的是',' binarySearch()方法只能操作Set集合,binarySearch()方法只能操作List集合 ,binarySearch()方法只能操作Map集合, binarySearch()可以操作所有的集合,','B',1,'4',1,NULL),(81,'Set集合的特点是','元素有序 ,元素无序，不存储重复元素,存储重复元素 ,Set集合都是线程安全的,','B',1,'2',1,NULL),(82,'java语言使用的字符码集是','ASCLL,BCD,DCb,Unicode,','D',1,'4',1,NULL),(83,'下列叙述正确的是','实例方法可以直接调用超类的实例方法,实例方法可以直接超类的类方法,实例方法可以直接调用子类的实例方法,实例方法可以直接调用本类的实例方法,','D',1,'2',1,NULL),(90,'aa',',,,,','',1,'1',1,'2017-11-30 05:57:19'),(91,'lkjhgfdsg','dsa,dsa,dsa,ds,','A',1,'1',1,'2017-12-01 08:37:58'),(92,'sadsfdg','dsfh,df,dfg,c,','BCD',2,'1',1,'2017-12-01 08:38:13'),(93,'在异常处理中，如释放资源，关闭数据库、关闭文件应由（ ）语句来完成。','try子句,catch子句, finally子句,throw子句','D',1,NULL,1,'2017-12-01 08:38:39'),(94,'下列有关Thread的描述，哪个是正确的？','启动一个线程的方法是：thread. run(),结束一个线程的通常做法是：thread. stop(),将一个线程标记成daemon线程，意味着当主线程结束，并且没有其它正在运行的非daemon线程时，该daemon线程也会自动结束,让一个线程等待另一个线程的通知的方法是：thread. sleep()','C',1,NULL,1,'2017-12-01 08:38:39'),(95,'默认RMI采用的是什么通信协议？','HTTP,UDP/IP,TCP/IP,Multicast','C',1,NULL,1,'2017-12-01 08:38:39'),(96,'Java中只有整型才能使用的运算符为？','*, / ,% ,+','C',1,NULL,1,'2017-12-01 08:38:39'),(97,'dsaddas','S,S,A,D,','A',1,'1',1,NULL),(98,'在异常处理中，如释放资源，关闭数据库、关闭文件应由（ ）语句来完成。','try子句,catch子句, finally子句,throw子句','D',1,NULL,1,'2017-12-06 03:41:12'),(99,'下列有关Thread的描述，哪个是正确的？','启动一个线程的方法是：thread. run(),结束一个线程的通常做法是：thread. stop(),将一个线程标记成daemon线程，意味着当主线程结束，并且没有其它正在运行的非daemon线程时，该daemon线程也会自动结束,让一个线程等待另一个线程的通知的方法是：thread. sleep()','C',1,NULL,1,'2017-12-06 03:41:13'),(100,'默认RMI采用的是什么通信协议？','HTTP,UDP/IP,TCP/IP,Multicast','C',1,NULL,1,'2017-12-06 03:41:13'),(101,'Java中只有整型才能使用的运算符为？','*, / ,% ,+','C',1,NULL,1,'2017-12-06 03:41:13'),(102,'vfdffdddd',NULL,'',3,'1',1,'2017-12-06 06:03:16'),(103,'xdxxxxxx','xxx,xx,xxx,xxx,','',2,'1',1,'2017-12-06 06:03:25'),(104,'在异常处理中，如释放资源，关闭数据库、关闭文件应由（ ）语句来完成。','try子句,catch子句, finally子句,throw子句','D',1,NULL,1,'2017-12-06 06:04:12'),(105,'下列有关Thread的描述，哪个是正确的？','启动一个线程的方法是：thread. run(),结束一个线程的通常做法是：thread. stop(),将一个线程标记成daemon线程，意味着当主线程结束，并且没有其它正在运行的非daemon线程时，该daemon线程也会自动结束,让一个线程等待另一个线程的通知的方法是：thread. sleep()','C',1,NULL,1,'2017-12-06 06:04:12'),(106,'默认RMI采用的是什么通信协议？','HTTP,UDP/IP,TCP/IP,Multicast','C',1,NULL,1,'2017-12-06 06:04:12'),(107,'Java中只有整型才能使用的运算符为？','*, / ,% ,+','C',1,NULL,1,'2017-12-06 06:04:12');

/*Table structure for table `t_label` */

DROP TABLE IF EXISTS `t_label`;

CREATE TABLE `t_label` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_label` */

insert  into `t_label`(`lid`,`label`) values (1,'SE'),(2,'EE'),(3,'WEB'),(4,'DB'),(5,'spring'),(6,'redis');

/*Table structure for table `t_paper_history` */

DROP TABLE IF EXISTS `t_paper_history`;

CREATE TABLE `t_paper_history` (
  `phid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户ID',
  `pid` int(11) DEFAULT NULL COMMENT '试卷ID',
  `totalscore` int(11) DEFAULT NULL COMMENT '总分数',
  `detailscore` varchar(255) DEFAULT NULL COMMENT '详细得分',
  `grading` int(11) DEFAULT NULL COMMENT '评分方式，0：自动评分，1：人工评分',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`phid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_paper_history` */

insert  into `t_paper_history`(`phid`,`uid`,`pid`,`totalscore`,`detailscore`,`grading`,`created`) values (1,12,2,0,NULL,1,'2017-12-06 01:59:28'),(2,12,2,25,NULL,1,'2017-12-06 03:43:55'),(3,12,2,25,NULL,1,'2017-12-06 06:08:56');

/*Table structure for table `t_paper_question` */

DROP TABLE IF EXISTS `t_paper_question`;

CREATE TABLE `t_paper_question` (
  `pid` int(11) DEFAULT NULL COMMENT '试卷id',
  `qid` int(11) DEFAULT NULL COMMENT '试题类型'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_paper_question` */

insert  into `t_paper_question`(`pid`,`qid`) values (5,54),(6,63),(6,57),(6,54),(6,77),(7,66),(7,60),(7,77),(7,69),(7,54),(8,54),(2,55),(9,67),(9,64),(9,69),(9,62),(10,83),(10,59),(10,73),(10,69),(11,67),(11,79),(11,62),(11,54),(11,73),(11,55),(11,54),(11,58),(12,68),(12,64),(12,62),(12,69),(12,73),(13,54),(13,55),(14,60),(14,76),(14,69),(14,61),(14,73),(14,54),(14,55),(14,56),(14,57),(14,58),(14,59),(14,60),(14,61),(14,62),(14,63),(14,64),(14,65),(14,66),(14,67),(14,68),(14,69),(14,73),(14,76),(14,77),(14,78),(14,79),(14,80),(14,81),(14,82),(14,83),(14,90),(2,91),(2,92),(15,58),(15,66),(15,69),(15,61),(15,73),(16,78),(16,94),(16,54),(16,92),(16,77),(17,82),(17,65),(17,92),(17,61),(17,77),(18,63),(18,76),(18,92),(18,61),(18,73),(19,96),(19,79),(19,62),(19,69),(19,77),(20,97),(20,79),(20,62),(20,92),(20,73),(2,54),(21,60),(21,96),(21,92),(21,69),(21,73),(5,54),(5,55),(5,102),(5,103);

/*Table structure for table `t_paper_type` */

DROP TABLE IF EXISTS `t_paper_type`;

CREATE TABLE `t_paper_type` (
  `pid` int(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  `minute` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_paper_type` */

insert  into `t_paper_type`(`pid`,`tid`,`minute`) values (NULL,NULL,NULL);

/*Table structure for table `t_question_history` */

DROP TABLE IF EXISTS `t_question_history`;

CREATE TABLE `t_question_history` (
  `qhid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '用户ID',
  `qid` int(11) DEFAULT NULL COMMENT '试题ID',
  `lid` int(11) DEFAULT NULL COMMENT '试题标签ID',
  `pid` int(11) DEFAULT NULL COMMENT '试卷id',
  `uanswer` text COMMENT '用户答案',
  `state` int(11) DEFAULT NULL COMMENT '对错，0：对，1：错，2：待定',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`qhid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `t_question_history` */

insert  into `t_question_history`(`qhid`,`uid`,`qid`,`lid`,`pid`,`uanswer`,`state`,`created`) values (1,1,25,5,NULL,NULL,1,'2017-11-25 10:21:32'),(2,1,55,1,NULL,NULL,1,'2017-11-25 17:06:50'),(3,1,60,2,NULL,NULL,0,'2017-11-27 15:12:53'),(4,1,70,3,NULL,NULL,0,'2017-11-24 15:13:12'),(5,1,71,4,NULL,NULL,0,'2017-11-27 20:16:51'),(6,1,75,1,NULL,NULL,0,'2017-11-27 20:17:14'),(7,1,75,5,NULL,NULL,0,'2017-11-27 20:17:14'),(8,1,66,1,NULL,NULL,0,'2017-11-27 20:38:29'),(9,1,63,2,NULL,NULL,1,'2017-11-27 20:38:48'),(10,1,63,6,NULL,NULL,0,'2017-11-28 20:44:43'),(11,1,77,6,NULL,NULL,1,'2017-11-28 20:45:08'),(12,12,55,2,NULL,'',2,'2017-12-06 01:59:28'),(13,12,91,2,NULL,'',2,'2017-12-06 01:59:28'),(14,12,92,2,NULL,'',2,'2017-12-06 01:59:28'),(15,12,54,5,2,'A',1,'2017-12-06 03:43:55'),(16,12,55,2,2,'B',0,'2017-12-06 03:43:55'),(17,12,91,2,2,'',2,'2017-12-06 03:43:55'),(18,12,92,2,2,'',2,'2017-12-06 03:43:55'),(19,12,54,2,2,'A',1,'2017-12-06 06:08:55'),(20,12,55,2,2,'B',0,'2017-12-06 06:08:55'),(21,12,91,2,2,'',2,'2017-12-05 06:08:55'),(22,12,92,NULL,2,'C',1,'2017-12-05 06:08:55'),(23,NULL,NULL,2,NULL,NULL,NULL,NULL);

/*Table structure for table `t_test_paper` */

DROP TABLE IF EXISTS `t_test_paper`;

CREATE TABLE `t_test_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(765) DEFAULT NULL,
  `seednum` int(11) DEFAULT NULL,
  `qnum` int(11) DEFAULT NULL,
  `minute` int(11) DEFAULT NULL,
  `time` varchar(150) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `t_test_paper` */

insert  into `t_test_paper`(`id`,`pname`,`seednum`,`qnum`,`minute`,`time`,`rank`) values (2,'JavaSE基础卷',0,20,100,'90分钟',1),(5,'web考卷',0,25,100,'100分钟',2),(13,'AA',0,NULL,100,'100分钟',1),(16,'BB',NULL,NULL,NULL,'90分钟',1),(19,'ss',NULL,NULL,NULL,'50分钟',1),(20,'',NULL,NULL,NULL,'',1),(21,'rrrrrr',NULL,6,100,'10',1),(22,'',NULL,6,100,'',1);

/*Table structure for table `t_type` */

DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`type`) values (1,'单选题'),(2,'多选题'),(3,'填空题'),(4,'问答题');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  `pass` varchar(150) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`uid`,`name`,`pass`,`rank`) values (1,'13333333333','123456',2),(8,'14444444444','123456',1),(9,'12222222222','123456',1),(10,'11111111111','123456',0),(11,'15555555555','123456',1),(12,'16666666666','123456',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
