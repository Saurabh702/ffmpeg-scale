# ffmpeg-scale

<details>
  <summary>test.sh</summary>

```
# Run using below command for different resolutions (generates resolution specific logs)
# parallel -j1 -k ./test.sh {1} '>>' {1}.log ::: {144,240,360} 

mkdir -p $1

{ { for file in *.mp4;
do
echo
echo $file" Output_Resolution : "$1"p"

echo
echo "Method : Whole "
time `java -jar test.jar $file $1 $1/whole_$file`

echo

for j in 15 30 60;
do
echo "Method : Segmentation, Segment_Size : "$j"s"
mkdir -p $1_$j
time `java -jar test.jar $file $1 $1_$j/seg_$file $j`
echo
done;

done; }  2>&1; }
```
</details>

## Logs

* Windows 10 Single Edition v1903
  * Terminal : git-bash
  * ffmpeg version git-2020-03-03-60b1f85
  * GNU parallel 20200322
  * Time taken for benchmark : ~4348s
  * Storage : HDD
  
  ### Visualization
  
  **Duration of Videos in order** : 128.53s, 364.57s, 91.75s, 264.23s, 202.73s
  
<details>
  <summary>144.log</summary>
  
```

20005819.mp4 Output_Resolution : 144p

Method : Whole 

real	0m28.025s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 15s

real	0m22.617s
user	0m0.015s
sys	0m0.031s

Method : Segmentation, Segment_Size : 30s

real	0m21.708s
user	0m0.031s
sys	0m0.015s

Method : Segmentation, Segment_Size : 60s

real	0m21.290s
user	0m0.000s
sys	0m0.062s


20005821.mp4 Output_Resolution : 144p

Method : Whole 

real	1m22.475s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 15s

real	1m11.150s
user	0m0.015s
sys	0m0.031s

Method : Segmentation, Segment_Size : 30s

real	1m10.665s
user	0m0.015s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	1m8.720s
user	0m0.031s
sys	0m0.046s


20005847.mp4 Output_Resolution : 144p

Method : Whole 

real	0m17.620s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 15s

real	0m16.005s
user	0m0.000s
sys	0m0.046s

Method : Segmentation, Segment_Size : 30s

real	0m16.194s
user	0m0.015s
sys	0m0.031s

Method : Segmentation, Segment_Size : 60s

real	0m16.451s
user	0m0.015s
sys	0m0.046s


20005849.mp4 Output_Resolution : 144p

Method : Whole 

real	0m53.103s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	0m45.690s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 30s

real	0m34.404s
user	0m0.000s
sys	0m0.078s

Method : Segmentation, Segment_Size : 60s

real	0m33.410s
user	0m0.000s
sys	0m0.046s


20005850.mp4 Output_Resolution : 144p

Method : Whole 

real	0m35.355s
user	0m0.015s
sys	0m0.062s

Method : Segmentation, Segment_Size : 15s

real	0m30.640s
user	0m0.031s
sys	0m0.046s

Method : Segmentation, Segment_Size : 30s

real	0m29.128s
user	0m0.000s
sys	0m0.046s

Method : Segmentation, Segment_Size : 60s

real	0m28.468s
user	0m0.031s
sys	0m0.046s


```
</details>

![144](https://user-images.githubusercontent.com/29001233/79412736-d6f5ba80-7fc3-11ea-871b-c9b62de46ac3.png)
  
<details>
  <summary>240.log</summary>
  
```  

20005819.mp4 Output_Resolution : 240p

Method : Whole 

real	0m42.801s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	0m40.166s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 30s

real	0m41.369s
user	0m0.000s
sys	0m0.031s

Method : Segmentation, Segment_Size : 60s

real	0m39.594s
user	0m0.000s
sys	0m0.046s


20005821.mp4 Output_Resolution : 240p

Method : Whole 

real	2m18.977s
user	0m0.000s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	2m9.710s
user	0m0.031s
sys	0m0.015s

Method : Segmentation, Segment_Size : 30s

real	2m6.590s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	2m7.726s
user	0m0.031s
sys	0m0.046s


20005847.mp4 Output_Resolution : 240p

Method : Whole 

real	0m29.161s
user	0m0.000s
sys	0m0.078s

Method : Segmentation, Segment_Size : 15s

real	0m28.147s
user	0m0.015s
sys	0m0.062s

Method : Segmentation, Segment_Size : 30s

real	0m27.060s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	0m26.838s
user	0m0.000s
sys	0m0.062s


20005849.mp4 Output_Resolution : 240p

Method : Whole 

real	1m11.594s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	1m0.937s
user	0m0.031s
sys	0m0.015s

Method : Segmentation, Segment_Size : 30s

real	0m59.956s
user	0m0.031s
sys	0m0.015s

Method : Segmentation, Segment_Size : 60s

real	0m58.894s
user	0m0.015s
sys	0m0.078s


20005850.mp4 Output_Resolution : 240p

Method : Whole 

real	0m55.496s
user	0m0.031s
sys	0m0.015s

Method : Segmentation, Segment_Size : 15s

real	0m53.499s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 30s

real	0m52.830s
user	0m0.031s
sys	0m0.046s

Method : Segmentation, Segment_Size : 60s

real	0m51.792s
user	0m0.015s
sys	0m0.078s


```
</details>

![240](https://user-images.githubusercontent.com/29001233/79413050-8e8acc80-7fc4-11ea-8148-c4114afd397b.png)

<details>
  <summary>360.log</summary>
  
```

20005819.mp4 Output_Resolution : 360p

Method : Whole 

real	1m18.910s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	1m15.734s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 30s

real	1m14.531s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	1m13.810s
user	0m0.015s
sys	0m0.062s


20005821.mp4 Output_Resolution : 360p

Method : Whole 

real	4m12.330s
user	0m0.015s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	4m2.444s
user	0m0.015s
sys	0m0.062s

Method : Segmentation, Segment_Size : 30s

real	4m2.401s
user	0m0.015s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	3m58.618s
user	0m0.000s
sys	0m0.078s


20005847.mp4 Output_Resolution : 360p

Method : Whole 

real	0m53.351s
user	0m0.000s
sys	0m0.046s

Method : Segmentation, Segment_Size : 15s

real	0m51.684s
user	0m0.000s
sys	0m0.078s

Method : Segmentation, Segment_Size : 30s

real	0m50.119s
user	0m0.031s
sys	0m0.046s

Method : Segmentation, Segment_Size : 60s

real	0m49.619s
user	0m0.000s
sys	0m0.062s


20005849.mp4 Output_Resolution : 360p

Method : Whole 

real	2m0.711s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 15s

real	1m52.542s
user	0m0.062s
sys	0m0.015s

Method : Segmentation, Segment_Size : 30s

real	1m50.179s
user	0m0.000s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	1m49.345s
user	0m0.031s
sys	0m0.046s


20005850.mp4 Output_Resolution : 360p

Method : Whole 

real	1m41.537s
user	0m0.031s
sys	0m0.031s

Method : Segmentation, Segment_Size : 15s

real	1m41.887s
user	0m0.031s
sys	0m0.015s

Method : Segmentation, Segment_Size : 30s

real	1m38.763s
user	0m0.015s
sys	0m0.062s

Method : Segmentation, Segment_Size : 60s

real	1m37.061s
user	0m0.000s
sys	0m0.046s


```
</details>

![360](https://user-images.githubusercontent.com/29001233/79413053-8fbbf980-7fc4-11ea-88cb-af7871598c98.png)
