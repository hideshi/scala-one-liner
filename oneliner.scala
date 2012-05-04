//チュートリアル
//http://d.hatena.ne.jp/hideshi_o/20120501/1335886709

//連続スペースをタブに変換
$ scala -i f -e 'fromFile(args(0)).getLines.map(_.replaceAll(" +","\t")).foreach(println(_))' filename

//ls -lから所有者とファイル名を抽出
$ ls -l | scala -i f -e 'stdin.getLines.map(_.split("+")).filter(_.length==9).foreach(a=>println(a(2)+":"+a(8)))'

//指定ディレクトリのファイル名を一括変換
$ scala -i f -e 'new File(args(0)).list.foreach(s => new File(s).renameTo(new File(s.replaceAll(args(1), args(2)))))' directory before after

//行番号を付加
$ scala -i f -e 'fromFile(args(0)).getLines.zipWithIndex.foreach(t => println("%4d\t%s".format(t._2, t._1)))'

//cat
$ scala -i f -e 'fromFile(args(0)).getLines.foreach(println(_))' filename

//cat | grep
$ scala -i f -e 'fromFile(args(0)).getLines.filter(_.contains(args(1))).foreach(println(_))' filename keyword

//wc -l
$ scala -i f -e 'println(fromFile(args(0)).getLines.size)' filename

//wc -m
$ scala -i f -e 'println(fromFile(args(0)).getLines.foldLeft("")(_ + _).size)' filename
